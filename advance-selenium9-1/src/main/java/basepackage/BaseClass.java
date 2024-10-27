package basepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import fileutilty.ReadProperty;
import listenerimplimentation.ListenerClass;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClass extends ListenerClass{
	
	public WebDriver driver;
	public static WebDriver sdriver;

	
	@BeforeClass(alwaysRun = true)
	public void openBrowser() {
		driver = new ChromeDriver();
		sdriver=driver;
		driver.manage().window().maximize();
		ReadProperty read = new ReadProperty();
		String url = read.fetchProperty("url");
		driver.get(url);
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, url);
		Reporter.log("WelcomePage is Displayed", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Close Browser", true);
	}

	@BeforeMethod(alwaysRun = true)
	public void login() {
		ReadProperty read = new ReadProperty();
		String username = read.fetchProperty("username");
		String password = read.fetchProperty("password");
		WelcomePage welcomePage=new WelcomePage(driver);
		welcomePage.getLoginButton().click();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getUserNameTF().sendKeys(username);
		loginPage.getPasswordTF().sendKeys(password);
		loginPage.getLoginButton().click();
		Reporter.log("Login", true);
	}

	@AfterMethod(alwaysRun = true)
	public void logout() {
		HomePage homePage=new HomePage(driver);
		homePage.getLogoutButton().click();
		Reporter.log("Logout", true);
	}

}
