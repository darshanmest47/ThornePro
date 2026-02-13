package Utilities.Waits;

import Utilities.DriverFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class WaitClass {


  public static WebDriverWait webDriverWait(){
      WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(),Duration.ofSeconds(30));
      return wait;
  }
}
