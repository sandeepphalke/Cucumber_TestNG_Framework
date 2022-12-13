package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pages.UserHomePage;

public class UserHomeDefinitions {

	UserHomePage uhp = new UserHomePage();
	
	@Then("User is signed in")
	public void user_is_signed_in() {
	    
		uhp.validateHomePage();
	}
}
