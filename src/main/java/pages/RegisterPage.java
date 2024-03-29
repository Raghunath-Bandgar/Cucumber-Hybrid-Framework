package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public RegisterPage(WebDriver driver) {

		// this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirm;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPoclicy;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement continueButton;

	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	private WebElement newsLetterYES;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateWarningMessage;

	@FindBy(xpath = "//input[@id='input-firstname']//following-sibling::div")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//input[@id='input-lastname']//following-sibling::div")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//input[@id='input-email']//following-sibling::div")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//input[@id='input-telephone']//following-sibling::div")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath = "//input[@id='input-password']//following-sibling::div")
	private WebElement passwordWarningMessage;
	
	
	
	
	
	

	public void enterFirstName(String firstNameText) {

		elementUtils.typeTextIntoElement(firstName, firstNameText, CommonUtils.EXPLICIT_WAIT_TIME);
	}

	public void enterLastName(String lastNameText) {

		elementUtils.typeTextIntoElement(lastName, lastNameText, CommonUtils.EXPLICIT_WAIT_TIME);

	}

	public void enterEmail(String emailText) {

		elementUtils.typeTextIntoElement(email, emailText, CommonUtils.EXPLICIT_WAIT_TIME);

	}

	public void enterTelephoneNumber(String telephoneNumber) {

		elementUtils.typeTextIntoElement(telephone, telephoneNumber, CommonUtils.EXPLICIT_WAIT_TIME);
	}

	public void enterPassword(String passwordText) {

		elementUtils.typeTextIntoElement(password, passwordText, CommonUtils.EXPLICIT_WAIT_TIME);
	}

	public void enterConfirmPassword(String confirmPassword) {

		elementUtils.typeTextIntoElement(confirm, confirmPassword, CommonUtils.EXPLICIT_WAIT_TIME);

	}

	public void selectPrivacyPolicy() {

		elementUtils.clickOnTheElement(privacyPoclicy, CommonUtils.EXPLICIT_WAIT_TIME);
	}

	public void clickOnContinueButton() {

		elementUtils.clickOnTheElement(continueButton, CommonUtils.EXPLICIT_WAIT_TIME);

	}

	public void selectYESNewsletter() {

		elementUtils.clickOnTheElement(newsLetterYES, CommonUtils.EXPLICIT_WAIT_TIME);
	}

	public String getWarningMessage() {

		return elementUtils.getTextFromElement(duplicateWarningMessage, CommonUtils.EXPLICIT_WAIT_TIME);

	}

	public String getFirstNameWarningMessage() {

		return elementUtils.getTextFromElement(firstNameWarningMessage, CommonUtils.EXPLICIT_WAIT_TIME);

	}

	public String getLastNameWarningMessage() {

		return elementUtils.getTextFromElement(lastNameWarningMessage, CommonUtils.EXPLICIT_WAIT_TIME);

	}

	public String getEmailWarningMessage() {

		return elementUtils.getTextFromElement(emailWarningMessage, CommonUtils.EXPLICIT_WAIT_TIME);

	}

	public String getTelephoneWarningMessage() {

		return elementUtils.getTextFromElement(telephoneWarningMessage, CommonUtils.EXPLICIT_WAIT_TIME);
	}

	public String getPasswordWarningMessage() {

		return elementUtils.getTextFromElement(passwordWarningMessage, CommonUtils.EXPLICIT_WAIT_TIME);

	}

}
