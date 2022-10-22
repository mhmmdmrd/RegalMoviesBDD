package regmovies.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import regmovies.bdd.base.BaseClass;

public class HomeSteps extends BaseClass {

	
	@Given("User in homepage")
	public void user_in_homepage() {
		homePage.getPageTitle("Movie Showtimes & Movie Tickets | Regal Theatres");
	   
	}

	@When("user verify homepage logo")
	public void user_verify_homepage_logo() {
		homePage.verifyLogo();
	}
	
}
