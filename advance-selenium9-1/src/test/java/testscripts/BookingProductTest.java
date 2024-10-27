package testscripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basepackage.BaseClass;

public class BookingProductTest extends BaseClass{

	@Test(groups = "Fuctionality")
	public void bookProductTest() throws InterruptedException {
		test.log(Status.INFO, "Clicking on Addresses");
		test.log(Status.INFO, "Clicking on Add Address");
		test.log(Status.INFO, "Filling all the Required Details");
		test.log(Status.INFO, "Clicking on Add Address");
		
	}
}
