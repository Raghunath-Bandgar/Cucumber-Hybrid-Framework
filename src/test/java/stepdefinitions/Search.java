package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {

	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	

	@Given("user opens the application")
	public void user_opens_the_application() {
		
		
		driver = DriverFactory.getDriver();
		
		System.out.println(">> user open application");
	}

	@When("user enter valid product {string} into the search field")
	public void user_enter_valid_product_into_the_search_field(String productText) throws Exception {
		
	    homePage= new HomePage(driver);
		homePage.enterTheProductIntoSearchField(productText);
		Thread.sleep(2000);
	}

	@And("user click on search button")
	public void user_click_on_search_button() throws Exception {
		
		homePage.clickOnSearchButton();
		Thread.sleep(2000);
	}

	@Then("valid product should get displayed in search result")
	public void valid_product_should_get_displayed_in_search_result() throws Exception {
		
		searchResultPage=new SearchResultPage(driver);
		Assert.assertTrue(searchResultPage.getValidProductDisplayedOnSeacheResult());
		Thread.sleep(2000);
	}

	@When("user enter non existing product {string} into the search field")
	public void user_enter_non_existing_product_into_the_search_field(String invalidProductText) throws Exception {
		
		homePage= new HomePage(driver);
		homePage.enterTheProductIntoSearchField(invalidProductText);
		Thread.sleep(2000);
		
	}

	@Then("proper text formating the user about no product matching should be displayed")
	public void proper_text_formating_the_user_about_no_product_matching_should_be_displayed() throws Exception {
		
		searchResultPage=new SearchResultPage(driver);
		Assert.assertTrue(searchResultPage.getNoProductMatchMessage().contains("There is no product that matches the search criteria."));
		Thread.sleep(2000);
	}

	@When("user dont enter product into the search field")
	public void user_dont_enter_product_into_the_search_field() {
		
		homePage= new HomePage(driver);
		
	}

}
