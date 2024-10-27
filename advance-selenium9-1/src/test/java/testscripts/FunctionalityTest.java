package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import fileutilty.ReadExcel;

public class FunctionalityTest extends BaseClass{

	@DataProvider
	public Object[][] dataSupplier() {
		ReadExcel readExcel=new ReadExcel();
		Object[][] data = readExcel.fetchMultipleData("FT Data");
		return data;
	}
	
	
	@Test(dataProvider = "dataSupplier", enabled = false)
	public void personalDetailsTest(String fn, String ln) {
		Reporter.log("Functional Start", true);
		driver.findElement(By.xpath("//div[@class='header-links']/ul/li[1]/a")).click();
		WebElement firstName = driver.findElement(By.id("FirstName"));
		firstName.clear();
		firstName.sendKeys(fn);
		WebElement lastName = driver.findElement(By.id("LastName"));
		lastName.clear();
		lastName.sendKeys(ln);
		Reporter.log("Functional End", true);
	}
}
