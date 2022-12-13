package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CommonPage;
import utils.TestBase;

public class CommonDefinitions extends TestBase{
	
	CommonPage cp = new CommonPage();
	
	@Given("User is on home page")
	public void user_is_on_home_page() throws IOException {
	   
		TestBase.initialization();
	}
	
	@Then("User close the browser")
	public void user_close_the_browser() {
		
		cp.closeBrowser();
		extent.flush();
	}

}
