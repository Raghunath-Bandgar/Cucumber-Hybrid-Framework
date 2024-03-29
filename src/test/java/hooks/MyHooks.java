package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {

	WebDriver driver;
	
	@Before
	public void setup() {
		
		
		Properties prop=ConfigReader.initializeProperties();//getting the browser name the properties file
	    driver=DriverFactory.initializeBrowser(prop.getProperty("Browser"));
		//driver=DriverFactory.getDriver();  // get driver by calling getDriver() method from DriverFactory
		driver.get(prop.getProperty("url"));
		
		
	}

	@After
	public void tearDown(Scenario scenario) {  //code for taking the screenshot
		
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		
		if (scenario.isFailed()) {
			
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
			
		}
		

		driver.quit();

	}


}
