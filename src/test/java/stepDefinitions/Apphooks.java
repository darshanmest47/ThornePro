package stepDefinitions;

import Utilities.DriverFactory;
import io.cucumber.java.*;

public class Apphooks {
	@Before
	public void launchMethod() {
		DriverFactory.initializeDriver();
	}
	
	@After
	public void tearDown() throws Exception{
		DriverFactory.quitDriver();
	}

}
