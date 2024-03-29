package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.CommonUtils;

public class DriverFactory {
	
	static WebDriver driver = null;

	public static WebDriver initializeBrowser(String Browser) {


		if (Browser.equals("chrome")) {

			driver = new ChromeDriver();

		} else if (Browser.equals("firefox")) {

			driver = new FirefoxDriver();

		} else if (Browser.equals("edge")) {

			driver = new EdgeDriver();

		} else if (Browser.equals("safari")) {

			driver = new SafariDriver();

		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		
		
		return driver;

	}

	public static WebDriver getDriver() {
		
		return driver;
	}
	
	
}
