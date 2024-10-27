package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	private WebElement userNameTF;
	
	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(id = "Password")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton; 
	
	
}
