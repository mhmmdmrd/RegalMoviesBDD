package regmovies.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import regmovies.bdd.base.BaseClass;

public class LogInPageSteps extends BaseClass {
	
	@When("User clicks user icon")
	public void user_clicks_user_icon() {
		homePage.clickUserIcon();
	   
	}
	
	@Then("User will be in log in page")
	public void user_will_be_in_log_in_page() {
		logInPage.verifyPageTitle("Regal - Log In");
	   
	}
	
	@Then("User will be in {string} page")
	public void user_will_be_in_page(String string) {
	  logInPage.verifyPageTitle(string);
	}

	@Then("user will input bad {string} in email")
	public void user_will_input_bad_in_email(String string) {
		logInPage.inputEmail(string);
		
	}
	   

	@Then("user will input bad {int} in password")
	public void user_will_input_bad_in_password(Integer int1) {
		logInPage.inputPassword(int1.toString());
		
	}
	   

	@Then("user will click on log in")
	public void user_will_click_on_log_in() {
		logInPage.clickLogIn();
	   
	}

	@Then("user will verify error text is {string}")
	public void user_will_verify_error_text_is(String string) {
		logInPage.verifyError(string);
	   
	}

}
