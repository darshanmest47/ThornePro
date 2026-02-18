package Utilities;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TakeScreenShot {

    public static void screenShot(Scenario scenario) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getWebDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File destination = new File("./FailedScreenShots/"+scenario.getName()+"_"+timestamp+".png");
        FileUtils.copyFile(source,destination);
    }
}
