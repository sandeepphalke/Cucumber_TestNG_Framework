package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import utils.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//span[@class='MuiButton-label']")
	WebElement loginButton;
	
	@FindBy(xpath = "//button//span[text()='Proceed To Login']")
	WebElement proceedToLoginButton;
	
	@FindBy(xpath = "//button//span[text()='Procéder à la connexion']")
	WebElement proceedToLoginButtonFrench;
	
	@FindBy(xpath = "//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input']")
	WebElement languageChangeDropdown;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void validateHomePage() throws InterruptedException {
		
		Thread.sleep(5000);
		Assert.assertTrue(loginButton.isDisplayed());
	}
	public void clickLoginButton() throws InterruptedException {
		
		Thread.sleep(10000);
		loginButton.click();
	}
	
	public void clickProceedToLoginButton(String language) {
		
		if(language.equals("English"))
		{
			proceedToLoginButton.click();
		}
		else if(language.equals("French"))
		{
			proceedToLoginButtonFrench.click();
		}
		
	}
	
	public void changeLanguage(String language) throws InterruptedException {
		
		String langId = "";
		if(language.equals("English"))
		{
			langId="1";
		}
		else if(language.equals("French"))
		{
			langId="2";
		}
		
		Thread.sleep(3000);
		languageChangeDropdown.click();
		driver.findElement(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']//li["+langId+"]")).click();
	}
	
	public void isCorrectHomePageTextExist(String homeText) {
		
		if(homeText.equals("Home"))
		{
			if(driver.findElement(By.xpath("//span[text()='Home']")).isDisplayed()) {
				
				test.pass("Home text is displayed on Home Page.");
			}
			else {
				
				test.fail("Home text is not displayed on Home Page.");
			}
		}
		else if(homeText.equals("Accueil"))
		{
			if(driver.findElement(By.xpath("//span[text()='Accueil']")).isDisplayed()) {
				
				test.pass("Accueil text is displayed on Home Page.");
			}
			else {
				
				test.fail("Accueil text is not displayed on Home Page.");
			}
		}
		else
		{
			Assert.fail();
		}
	}
		

}
