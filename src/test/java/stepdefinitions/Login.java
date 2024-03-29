package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {

	WebDriver driver;
	private LoginPage loginPage;
	

	@Given("^user has opened the application URL$")
	public void user_has_opened_the_application_URL() throws Exception {
		
		
		driver = DriverFactory.getDriver(); // get driver by calling getDriver() method from DriverFactory
        Thread.sleep(2000);
        
	}

	@And("^navigated to login page$")
	public void navigated_to_login_page() throws Exception {
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		 Thread.sleep(2000);
		
	}

	@When("^user enters valid email (.+) address$")
	public void user_enters_valid_email_address(String emailText) throws Exception {
		
		loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress(emailText);
		Thread.sleep(2000);
	}

	@And("^user enters valid (.+) password$")
	public void user_enters_valid_password(String passwordText) throws Exception {
		
		loginPage.enterPassword(passwordText);
		 Thread.sleep(2000);
	}

	@And("^click on login button$")
	public void click_on_login_button() throws Exception {
		
		loginPage.clickOnLoginButton();
		 Thread.sleep(2000);
		   
	}

	@Then("^user should be able to successfully login$")
	public void user_should_be_able_to_successfully_login() throws Exception {
		
		AccountPage accountPage=new AccountPage(driver);
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformation());
		 Thread.sleep(2000);
	} 

	@When("user enters Invalid email address")
	public void user_enters_Invalid_email_address() throws Exception {
		
		loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
	    Thread.sleep(2000);
	}

	@And("user enters Invalid {string} password")
	public void user_enters_Invalid_password(String invalidPassword) throws Exception {
		
		loginPage.enterPassword(invalidPassword);
	    Thread.sleep(2000);
	   
	

	}

	@Then("^user should get proper warning message$")
	public void user_should_get_proper_warning_message() throws Exception {
		
		Assert.assertTrue(loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
		 Thread.sleep(2000);
	}

	@When("user don’t enters any email address")
	public void user_don_t_enters_any_email_address() throws Exception {
		
		loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress("");		
		Thread.sleep(2000);
	}

	@And("user don’t enters any  password")
	public void user_don_t_enters_any_password() throws Exception {
		
		loginPage=new LoginPage(driver);
		loginPage.enterPassword("");
		
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
		 Thread.sleep(2000);
	}
	
	
}
