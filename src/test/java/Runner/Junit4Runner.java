package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\features",
glue = "stepDefinitions",
plugin = {
        "pretty",
        "rerun:target/failed_scenarios.txt",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
},tags = "",
		monochrome = true,dryRun=false,publish = true)
public class Junit4Runner {

}
