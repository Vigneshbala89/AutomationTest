package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import fileutilty.ReadProperty;
import genericutility.JavaUtility;

public class RegisterTest {

	@Test
	public void registerTest() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		ReadProperty read = new ReadProperty();
		String url = read.fetchProperty("url");
		driver.get(url);
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, url);
		Reporter.log("WelcomePage is Displayed", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.partialLinkText("Register")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Vignesh");
		driver.findElement(By.id("LastName")).sendKeys("Kumar");
		JavaUtility java=new JavaUtility();
		int randumNumber = java.getRandomNumber(1000);
		String emailId="abc"+randumNumber+"@gmail.com";
		driver.findElement(By.id("Email")).sendKeys(emailId);
		driver.findElement(By.id("Password")).sendKeys("12345677");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("12345677");
		driver.findElement(By.id("register-button")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
	}
}
