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

public class DemoSite {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");


//


        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
        js.executeScript("arguments[0].click();",element);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Widgets')]")));
        WebElement widgets = driver.findElement(By.xpath("//*[contains(text(),'Widgets')]"));
        js.executeScript("arguments[0].scrollIntoView();",widgets);
        js.executeScript("arguments[0].click();",widgets);

        WebElement datePicker = driver.findElement(By.xpath("//*[contains(text(),'Date Picker')]"));
        js.executeScript("arguments[0].click();",datePicker);

        WebElement datePicker1 = driver.findElement(By.id("datePickerMonthYearInput"));
//        datePicker1.clear();
//        datePicker1.sendKeys("02/20/2026");
        js.executeScript("arguments[0].value=''",datePicker1);
        js.executeScript("arguments[0].value='02/20/2026'",datePicker1);


     }
}
