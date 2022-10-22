package regmovies.bdd.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",
		 glue = {"regmovies.bdd.steps","regmovies.bdd.base"},
		 tags = "@dataDriven",
		 plugin = {"pretty","html:target/Report.html", "json:target/Report.json"},
		 monochrome = true,
		 dryRun = false)

public class TestRunner {
	
	

}
