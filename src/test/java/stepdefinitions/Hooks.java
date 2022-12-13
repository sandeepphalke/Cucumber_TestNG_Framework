package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestBase;

public class Hooks extends TestBase{

	@Before
	public void setup() throws IOException {
		TestBase.initialization();
	}

	@After	
	public void tearDown(Scenario scenario) throws Exception
	{
		
	    if(scenario.isFailed())
	    {	
	    	getScreenshot(driver,"testing");
	    	/*
	    	System.out.println("In after hook");
	    	TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "github");
			byte[] data =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(data,"image/png", "My screenshot");
			System.out.println(scenario.getName()); System.out.println("In after hook");
			 */
	    }
	    
	    driver.quit();
	}
}
