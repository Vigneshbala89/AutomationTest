package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(linkText = "Register"), @FindBy(className = "ico-register"), @FindBy(xpath = "//a[@class='ico-register']")})
	private WebElement registerButton;
	
	@FindBy(partialLinkText = "Log in")
	private WebElement loginButton;
	
	public WebElement getRegisterButton() {
		return registerButton;
	}
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	
}
