package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement explicitWaitForElement(WebElement element, long durationinseconds) {

		WebElement webElement = null;

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinseconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Throwable e) {
			e.printStackTrace();

		}
		return webElement;
	}

	public void clickOnTheElement(WebElement element, long durationinseconds) {

		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationinseconds));
		// WebElement webElement =wait.until(ExpectedConditions.elementToBeClickable(element));

		// call the explicitWaitForElement method here
		WebElement webElement = explicitWaitForElement(element, durationinseconds);
		webElement.click();
	}

	public void typeTextIntoElement(WebElement element, String text, long durationinseconds) {

		// call the explicitWaitForElement method here
		WebElement webElement = explicitWaitForElement(element, durationinseconds);

		webElement.click();
		webElement.clear();
		webElement.sendKeys(text);

	}

	public void selectDropdownOption(WebElement element, String dropdownOption, long durationinseconds) {

		// call the explicitWaitForElement method here
		WebElement webElement = explicitWaitForElement(element, durationinseconds);

		Select select = new Select(webElement);
		select.selectByVisibleText(dropdownOption);

	}

	public Alert waitForAlert(long durationinseconds) {

		Alert alert = null;
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinseconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());

		} catch (Throwable e) {
			e.printStackTrace();

		}
		return alert;
	}

	public void acceptAlert(long durationinseconds) {

		// call the waitForAlert method here

		Alert alert = waitForAlert(durationinseconds);
		alert.accept();

	}

	public void dismissAlert(long durationinseconds) {

		// call the waitForAlert method here

		Alert alert = waitForAlert(durationinseconds);
		alert.dismiss();
	}

	public void mouseHoverAndClick(WebElement element, long durationinseconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinseconds));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));

		Actions act = new Actions(driver);
		act.moveToElement(webElement).click().build().perform();

	}

	public void javaScriptClick(WebElement element, long durationinseconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinseconds));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));

		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click()", webElement);
	}

	public void javaScriptType(WebElement element, long durationinseconds, String text) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinseconds));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));

		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + text + "'", webElement);
	}

	public String getTextFromElement(WebElement element, long durationinseconds) {

		WebElement webElement = explicitWaitForElement(element, durationinseconds);
		return webElement.getText();

	}

	public boolean displayStatus(WebElement element, long durationinseconds) {
		
       try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinseconds));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		return webElement.isDisplayed();
       }catch(Throwable e) {
    	 e.printStackTrace();
    	 return false;
    	   
       }
      
	}

}
