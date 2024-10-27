package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestClassTest {
	
	@Test
	public void reportTest() {
		Reporter.log("Reports Test Start", true);
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReports/TestReport.html");
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		ExtentTest test=report.createTest("Report Test 1");
		test.log(Status.INFO, "Crome Browser Opened");
		test.log(Status.INFO, "Logged In");
		test.log(Status.INFO, "Clicked on Profile");
		test.log(Status.INFO, "Clicked on Addresses");
		test.log(Status.INFO, "Clicked on Add Address");
		test.log(Status.INFO, "Entered all the required Details");
		test.log(Status.INFO, "Clicked on add Address");
		test.log(Status.SKIP, "Add Address is Failed");
		report.flush();
		Reporter.log("Reports Test End", true);
	}
	
}
