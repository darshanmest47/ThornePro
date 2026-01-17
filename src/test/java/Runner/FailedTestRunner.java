package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target/failed_scenarios.txt",glue = "stepDefinitions",plugin= {
				"pretty",
				"html:target/cucumber-reports/cucumber.html",
				"json:target/cucumber-reports/cucumber.json"
		},monochrome = true,publish = true,dryRun = false)

public class FailedTestRunner {

}
