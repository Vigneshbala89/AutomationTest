package testscripts;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basepackage.BaseClass;

@Listeners(listenerimplimentation.ListenerClass.class)
public class AddAddressTest extends BaseClass{

	@Test(groups = "Regression")
	public void addAddressTest() {
		
		
		//Assert.fail();
		driver.findElement(By.xpath("//div[@class='header-links']/ul/li[1]/a")).click();
		test.log(Status.INFO, "Clicking on Profile");
		driver.findElement(By.xpath("//ul[@class='list']/li[2]/a")).click();
		test.log(Status.INFO, "Clicking on Addresses");
		test.log(Status.INFO, "Clicking on Add Address");
		test.log(Status.INFO, "Filling all the Required Details");
		test.log(Status.INFO, "Clicking on Add Address");
		Reporter.log("Add Address", true);
		
	}
	
	
}
