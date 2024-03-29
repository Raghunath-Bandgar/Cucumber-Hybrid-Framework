package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Registration {

	WebDriver driver;
	private RegisterPage registerPage;
	

	@Given("User navigate to Register account page")
	public void user_navigate_to_register_account_page() throws Exception {

		
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectRegisterOption();
		Thread.sleep(2000);
	}

	@When("User enter the below details into the field")
	public void User_enter_the_below_details_into_the_field(DataTable dataTable) throws Exception {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(map.get("firstname"));
		Thread.sleep(2000);
		registerPage.enterLastName(map.get("lastname"));
		Thread.sleep(2000);
		registerPage.enterEmail(CommonUtils.getEmailWithTimeStamp());
		Thread.sleep(2000);
		registerPage.enterTelephoneNumber(map.get("mobilenumber"));
		Thread.sleep(2000);
		registerPage.enterPassword(map.get("password"));
		Thread.sleep(2000);
		registerPage.enterConfirmPassword(map.get("passwordconfirm"));
		Thread.sleep(2000);

	}

	@When("User enter the below details into the field with duplicate Email address")
	public void User_enter_the_below_details_into_the_field_with_duplicate_Email_address(DataTable dataTable)
			throws Exception {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(map.get("firstname")); 
		registerPage.enterLastName(map.get("lastname"));
		registerPage.enterEmail(map.get("emailid"));
		registerPage.enterTelephoneNumber(map.get("mobilenumber"));
		registerPage.enterPassword(map.get("password"));
		registerPage.enterConfirmPassword(map.get("passwordconfirm"));
		Thread.sleep(2000);

	}

	@And("select privacy policy")
	public void select_privacy_policy() throws Exception {

		registerPage.selectPrivacyPolicy();
		Thread.sleep(2000);
	}

	@And("click on continue button")
	public void click_on_continue_button() throws Exception {

		registerPage.clickOnContinueButton();
		Thread.sleep(2000);
	}

	@Then("Account should get successfully created")
	public void account_should_get_successfully_created() throws Exception {

		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertEquals("Congratulations! Your new account has been successfully created!",
				accountSuccessPage.getAccountSuccessfullyCreatedMessage());
		Thread.sleep(2000);

	}

	@When("Select Yes for Newslatter")
	public void select_yes_for_newslatter() throws Exception {

		registerPage.selectYESNewsletter();
		Thread.sleep(2000);
	}

	@When("User dont enters details into the any fields")
	public void user_dont_enters_details_into_the_any_fields() {

		registerPage = new RegisterPage(driver);
	}

	@Then("warning messages should be displayed under all mandatory fields")
	public void warning_messages_should_be_displayed_under_all_mandatory_fields() throws Exception {

		Assert.assertTrue(registerPage.getWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
		Thread.sleep(2000);
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.getFirstNameWarningMessage());
		Thread.sleep(2000);
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.getLastNameWarningMessage());
		Thread.sleep(2000);
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.getEmailWarningMessage());
		Thread.sleep(2000);
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.getTelephoneWarningMessage());
		Thread.sleep(2000);
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerPage.getPasswordWarningMessage());
		Thread.sleep(2000);

	}

	@Then("warning message informing to the user about duplicate email address")
	public void warning_message_informing_to_the_user_about_duplicate_email_address() throws Exception {

		Assert.assertTrue(registerPage.getWarningMessage().contains("Warning: E-Mail Address is already registered!"));
		Thread.sleep(2000);

	}

}
