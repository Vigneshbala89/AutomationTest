package listenerimplimentation;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import basepackage.BaseClass;
import genericutility.JavaUtility;

public class ListenerClass implements ISuiteListener, ITestListener{
	
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		spark=new ExtentSparkReporter("./AdvancedReports/"+suite.getName()+new JavaUtility().getSystemDate().toString().replace(" ", "_").replace(":", "_")+".html");
		report=new ExtentReports();
		Reporter.log(suite.getName()+" is Started", true);
	}
	
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log(suite.getName()+" is Finished", true);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		report.attachReporter(spark);
		test=report.createTest(result.getName());
		Reporter.log(result.getName()+" is Stareted Execution", true);
		test.log(Status.INFO, result.getName()+" Has Started Execution");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" is Successfully Executed", true);
		test.log(Status.PASS, result.getName()+" Has Successfully Executed");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+" is Skipped", true);
		test.log(Status.SKIP, result.getName()+" Has Skipped");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
//		JavaUtility java=new JavaUtility();
//		String date = java.getSystemDate().toString().replace(" ", "_").replace(":", "_");
		
		String screenShotPath="./FailedScreenshots/"+result.getName()+new JavaUtility().getSystemDate().toString().replace(" ", "_").replace(":", "_")+".png";
		File path=new File(screenShotPath);
		File ss = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(ss, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getName()+" Has Failed and Captured the Screenshot");
		test.addScreenCaptureFromPath("."+screenShotPath);
		Reporter.log(result.getName()+" is Failed and Screenshot is Captured", true);
	}
	

}
