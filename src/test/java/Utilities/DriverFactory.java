package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static ThreadLocal<WebDriver> tls = new ThreadLocal<>();
	
	
	public static void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		tls.set(driver);
		tls.get().manage().window().maximize();
		tls.get().get("https://qa-site.thorne.com/");
	}
	
	
	public static WebDriver getWebDriver() {
		return tls.get();
	}
	
	public static void quitDriver() throws Exception{
		if(tls.get()!=null) {
			try {			
			Thread.sleep(3000);
			tls.get().quit();
			}catch(Exception e) {
				System.out.println("Exception occured "+e.getMessage());
			}finally {
				tls.remove();

			}

		}
	}

}
