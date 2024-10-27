package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='header-links']/ul[1]/li[1]/a")
	private WebElement myAccount;
	
	@FindBy(partialLinkText = "Log out")
	private WebElement logoutButton;

	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
}
