package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import utils.TestBase;

public class SignInPage extends TestBase{
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement emailInput;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;
	
	@FindBy(xpath = "//button[@id='next']")
	WebElement signInButton;
	
	public SignInPage() {
		
		PageFactory.initElements(driver, this);
	}

	public void enterEmail() {
		
		emailInput.sendKeys("sandeepkumar.phalke@e-zest.in");
	}
	
	public void enterPassword() {
		
		passwordInput.sendKeys("Test@123");
	}
	
	public void clickSignInButton() throws InterruptedException {
		
		signInButton.click();
		Thread.sleep(5000);
	}
	
	public void signInButtonIsDisplayed() {
		
		if(signInButton.isDisplayed()){
			
			test.pass("Sign In Button is displayed on Sign In Page.");
		}
		else{
			
			test.fail("Sign In Button is not displayed on Sign In Page.");
		}
	}
	
	public void enterEmail(String email) {
		
		emailInput.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		
		passwordInput.sendKeys(password);
	}
}
