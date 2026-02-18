import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Calader {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[contains(text(),'Elements')]")).click();
        WebElement widgets = driver.findElement(By.xpath("//*[contains(text(),'Widgets')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView();",widgets);
        widgets.click();



     }
}
