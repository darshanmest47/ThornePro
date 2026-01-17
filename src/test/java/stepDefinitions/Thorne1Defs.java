package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DriverFactory;
import io.cucumber.java.en.Given;

public class Thorne1Defs {
	
	@Given("I am a user accessing thorne website on uat")
	public void I_am_a_user_accessing_thorne_website_on_uat() {
		DriverFactory.getWebDriver().get("https://uat-site.thorne.com/");
		Assert.assertTrue(DriverFactory.getWebDriver().getCurrentUrl().contains("https://uat-site.thorne.com/"));
	}
		

}
