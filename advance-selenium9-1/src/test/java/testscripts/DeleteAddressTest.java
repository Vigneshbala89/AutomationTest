package testscripts;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basepackage.BaseClass;

@Listeners(listenerimplimentation.ListenerClass.class)
public class DeleteAddressTest extends BaseClass{

	@Test(groups = "Regression")
	public void deleteAddressTest() {
		test.log(Status.INFO, "Clicking on Addresses");
		test.log(Status.INFO, "Clicking on Add Address");
		test.log(Status.INFO, "Filling all the Required Details");
		test.log(Status.INFO, "Clicking on Add Address");
		Reporter.log("Delete Address", true);
	}
}
