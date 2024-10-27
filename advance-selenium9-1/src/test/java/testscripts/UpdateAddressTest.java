package testscripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import basepackage.BaseClass;

public class UpdateAddressTest extends BaseClass{

	@Test(groups = "Smoke")
	public void updateAddressTest() {
		Reporter.log("Update Address", true);
	}
}
