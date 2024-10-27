package genericutility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement dragElement, WebElement dropElement) {
		Actions act=new Actions(driver);
		act.dragAndDrop(dragElement, dropElement).perform();
	}
	
	
	public void getScreeonshot(WebDriver driver, String screenshotName) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File ss=ts.getScreenshotAs(OutputType.FILE);
		File path=new File("./Screenshots/"+screenshotName+".png");
		try {
			FileHandler.copy(ss, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void switchFrameUsingIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchFrameUsingWebelement(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	public void switchFrameUsingIdOrName(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public boolean checkDropdown(WebElement dropdown) {
		Select sel=new Select(dropdown);
		return sel.isMultiple();
	}
	
	public void selectDropdownByIndex(WebElement dropdown, int index) {
		Select sel=new Select(dropdown);
		sel.selectByIndex(index);
	}
	
	public void selectDropdownByValue(WebElement dropdown, String value) {
		Select sel=new Select(dropdown);
		sel.selectByValue(value);
	}
	
	public List<WebElement> getAllOptionsFromDropdown(WebElement dropdown) {
		Select sel=new Select(dropdown);
		List<WebElement> allopts = sel.getOptions();
		return allopts;
	}
	
	public void switchDriverFocusToWindow(WebDriver driver, String mainId, Set<String> allIds, String requiredTitle) {
		for(String id:allIds) {
			if(!(id.equals(mainId))) {
				driver.switchTo().window(id);
				String title = driver.getTitle();
				if(title.contains(requiredTitle)) {
					continue;
				}
			}
		}
	}
}
