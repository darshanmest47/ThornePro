import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testfile {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        WebElement element = driver.findElement(By.xpath("//td[contains(text(),'Mum')]/parent::tr/preceding-sibling::tr/td[contains(text(),'Pra')]"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.xpath("//td[contains(text(),'Kish')]/parent::tr/following-sibling::tr/td[contains(text(),'Ban')]"));
        System.out.println(element1.getText());

        WebElement element2 = driver.findElement(By.xpath("//td[contains(text(),'Pun')]/preceding-sibling::td[contains(text(),'Man')]"));
        System.out.println(element2.getText());

        WebElement element3 = driver.findElement(By.xpath("//td[contains(text(),'Delhi')]/ancestor::tbody/tr/td[contains(text(),'Man')]/parent::tr/following-sibling::tr/td[text()='29']"));
        System.out.println(element3.getText());

        Thread.sleep(5000);
        driver.quit();
    }
}
