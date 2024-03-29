package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver) {

		// this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginoption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(xpath = "//input[@class='form-control input-lg']")
	private WebElement searchField;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public void clickOnMyAccount() {

		elementUtils.clickOnTheElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_TIME);
	}

	public void selectLoginOption() {

		elementUtils.clickOnTheElement(loginoption, CommonUtils.EXPLICIT_WAIT_TIME);
	}

	public void selectRegisterOption() {

		elementUtils.clickOnTheElement(registerOption, CommonUtils.EXPLICIT_WAIT_TIME);

	}

	public void enterTheProductIntoSearchField(String productText) {
		elementUtils.typeTextIntoElement(searchField, productText, CommonUtils.EXPLICIT_WAIT_TIME);

	}

	public void clickOnSearchButton() {

		elementUtils.clickOnTheElement(searchButton, CommonUtils.EXPLICIT_WAIT_TIME);
	}

}
