package pages;

import org.testng.annotations.Test;

import utils.TestBase;

public class CommonPage extends TestBase{
	
	@Test
	public void closeBrowser() {
		
		driver.quit(); 
	}

}
