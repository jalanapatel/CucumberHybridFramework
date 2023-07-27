package Step_Difinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import FactoryName.Driver_Factory;
import Page_Object.Home_Page;
import Page_Object.Search_Result_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search_Step_Definition 
{
	
		WebDriver driver;
		
		private Home_Page homePage;
		
		Search_Result_Page searchResultPage;
		
	
	@Given("User open application to navigate at Home Page")
	public void user_open_application_to_navigate_at_home_page() 
	{
	    	driver = Driver_Factory.getDriver();                                            // Get Driver

	}

	@When("User enters valid product {string} into search box field")                                       // HP  --  Valid_Product
	public void user_enters_valid_product_into_search_box_field(String validProductText) 
	{
    	
    	homePage = new Home_Page(driver) ;
    	
    	homePage.enterProductIntoSearchBox(validProductText);
		
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button()
	{
			homePage = new Home_Page(driver) ;
		
			searchResultPage = homePage.clickOnSearchButton();                                               // Return Object of Search_Result_Page_Class
	}

	@Then("user should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() 
	{

		Assert.assertTrue(searchResultPage.displayStatudOfValidProduct_HP() );
		
		Assert.fail("Failed Test Intentionally,    So We Can Take ScreenShot........");
		
		// int a = 10/0;                                                                                                           // Intentionally Failed, method, so we can take screenShot of Failed Test   -- here it will give Arithmetic Exception
	}

	@When("User enter Invalid product {string} into search box field")                                                  //  Invalid_Product ---> Honda
	public void user_enter_invalid_product_into_search_box_field(String invalidProductText) 
	{
			Home_Page homePage = new Home_Page(driver);
			
			homePage.enterProductIntoSearchBox(invalidProductText);

	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() 
	{

		Assert.assertEquals("There is no product that matches the search criteria.",  searchResultPage.getmessageNoProductMatchText() ); 

	}

	@When("User do not enter any product name into Search box field")
	public void user_do_not_enter_any_product_name_into_search_box_field()
	{

				homePage = new Home_Page(driver);
		
				// Intentionally Left Blank    --- No Product Enter in SearchBox and directly click on SearchBox
	
	}


	
	
	
	
	
	
	
	
}
