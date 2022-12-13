package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import utils.TestBase;

public class UserHomePage extends TestBase{

	
	@FindBy(xpath = "//span[text()='Export']")
	WebElement exportButton;
	
	
	public UserHomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void validateHomePage() {
		 
		 if(exportButton.isDisplayed())
			{
				test.pass("Export Button is displayed on User Home Page.");
			}
			else{
				
				test.fail("Export Button is not displayed on User Home Page.");
			}
	}
}
