package stepDefinitions;

import Utilities.DriverFactory;
import Utilities.TakeScreenShot;
import com.aventstack.extentreports.reporter.FileUtil;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Apphooks {
	@Before
	public void launchMethod() {
		DriverFactory.initializeDriver();
	}
	
	@After
	public void tearDown(Scenario scenario) throws Exception{
		if(scenario.isFailed()){
			TakeScreenShot.screenShot(scenario);
		}
		DriverFactory.quitDriver();
	}

}
