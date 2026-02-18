import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MMT {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");

        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Flight Tracker')]/ancestor::*[contains(@class,'minContainer')]/preceding-sibling::div/div/div/ul/li[4]/div/p[contains(text(),'My Trips')]"));
        System.out.println(element.getText());
        Thread.sleep(5000);
        driver.quit();
    }
}
