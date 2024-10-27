package testscripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import basepackage.BaseClass;

public class SearchProductTest extends BaseClass{

	@Test(groups = "Smoke")
	public void searchProductTest() {
		Reporter.log("Search Product", true);
	}
}
