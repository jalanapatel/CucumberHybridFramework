package Experiments;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import FactoryName.Driver_Factory;
import Page_Object.Account_Success_Page;
import Page_Object.Home_Page;
import Page_Object.Register_Page;
import Utility.Common_Utility_Class;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register_Step_Definition_03 
{
	WebDriver driver;
	
	Home_Page homePage;
	
	private Register_Page registerPage;
	
	private 	Common_Utility_Class Common_Utility_Class;
	
	
	@Given ("User has navigates to Register Account Page")
	public void User_has_navigates_to_Register_Account_Page()
	{
		
		driver = Driver_Factory.getDriver();                              // Get Driver
		
		homePage = new Home_Page(driver);                           // Create Object of Home_Page
		
		homePage.clickOnMyAccount();
		
		homePage.selectRegisterOption();
		
	}
	
	
	@When("User enters the details into below Fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) 
	{
	     Map <String, String>  dataMap = dataTable.asMap(String.class, String.class);
		
	     registerPage = new Register_Page(driver);
	     
	     registerPage.enterFirstName(dataMap.get("FirstName"));                               // Get Data from register.feature_File
	     
	     registerPage.enterLastName(dataMap.get("LastName"));
	     
	 	Common_Utility_Class = new Common_Utility_Class();                                // Create Object of 	Common_Utility_Class  ---> static keyword remove
	     
	     registerPage.enterEmail(Common_Utility_Class.getEmailAddressWithTimeStamp());           // Get new email address from  .getEmailWithTimeStamp() method from Common_Utility_Class
	     
	     registerPage.enterTelephone(dataMap.get("Telephone"));
	     
	     registerPage.enterPassword(dataMap.get("Password"));                                        // Here, Enter Password and confirm_Password Same
	     
	     registerPage.enterConfirmPassword(dataMap.get("Password"));
	     
	}
	
	
	@When("User selects Privact Policy box")
	public void user_selects_privact_policy_box()
	{
				registerPage.selectPrivacyPolicy();
	}
	
	
	@When("Clicks on Continue button")
	public void clicks_on_continue_button()
	{
			registerPage.clickContinueButton();

	}
	
	
	@Then("User account should get created Successfully")                                            //  Your Account Has Been Created!
	public void user_account_should_get_created_successfully() 
	{
		Account_Success_Page accountSuccessPage = new Account_Success_Page(driver);
		
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.accountSuccessPageHeading() );
		
	
	//  Assert.assertTrue(accountSuccessPage.accountSuccessPageHeading().contains("Your Account Has Been Created!"));

	}
	
	
	@When("User selects  Yes  Newsletter subscribe")
	public void user_selects_yes_newsletter_subscribe() 
	{
		//label[@class='radio-inline']/input[@value='1']
		
		//input[@name='newsletter'][@value = '1']
		
		registerPage.selectYesNewsLetterSubscriptio();
				
	}

	
	
	@When("User enters the details into below Fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) 
	{
	     Map <String, String>  dataMap = dataTable.asMap(String.class, String.class);
		
	     registerPage = new Register_Page(driver);
	     
	     registerPage.enterFirstName(dataMap.get("FirstName"));                               // Get Data from register.feature_File
	     
	     registerPage.enterLastName(dataMap.get("LastName"));
	     
	     registerPage.enterEmail(dataMap.get("Email"));           // Get new email address from Register.feature_File
	     
	     registerPage.enterTelephone(dataMap.get("Telephone"));
	     
	     registerPage.enterPassword(dataMap.get("Password"));                                        // Here, Enter Password and confirm_Password Same
	     
	     registerPage.enterConfirmPassword(dataMap.get("Password"));

	}
	


	@Then("User should get proper Waring Message about duplicate Account {string}")                                 // Warning: E-Mail Address is already registered!
	public void user_should_get_proper_waring_message_about_duplicate_account(String duplicateEmailMessage)
	{
		//div[@class ='alert alert-danger alert-dismissible']
		
		//div[contains(@class,'alert-dismissible')]
	    
		Assert.assertTrue(registerPage.getduplicateAccountMessage().contains("Warning: E-Mail Address is already registered!") );

	}

	@When("User do not enter any details into fields")
	public void user_do_not_enter_any_details_into_fields()
	{
	    
		 registerPage = new Register_Page(driver);
		 
		// Intentionally Left Blank    ====>>>   As details are not entered  ---- Directly click on Continue Button
		
	}

	@Then("User should get proper Warning Messages for every Mandatory fields")
	public void user_should_get_proper_warning_messages_for_every_mandatory_fields() 
	{
	    // Privacy-Policy Warning  -->> Warning: You must agree to the Privacy Policy!
		
		Assert.assertTrue(registerPage.getPrivacyPolicyWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));

		
		//  First Name Warning   --->>   First Name must be between 1 and 32 characters!
				//Assert.assertTrue( registerPage.getFirstNameWarningMessage().contains("First Name must be between 1 and 32 characters!"));
		
	      Assert.assertEquals("First Name must be between 1 and 32 characters!" , registerPage.getFirstNameWarningMessage() );
		

		//  Last Name Warning  --->>  Last Name must be between 1 and 32 characters!
		//Assert.assertTrue(registerPage.getLastNameWarningMessage().contains("Last Name must be between 1 and 32 characters!"));
		
		Assert.assertEquals( "Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarningMessage() );

		
		//  E-mail Warning  --->>  E-Mail Address does not appear to be valid!
		// Assert.assertTrue( registerPage.getEmailWarningMessage().contains("E-Mail Address does not appear to be valid!"));
		
		Assert.assertEquals("E-Mail Address does not appear to be valid!" ,  registerPage.getEmailWarningMessage() );

		// Telephone Warning   --->>  Telephone must be between 3 and 32 characters!
		// Assert.assertTrue( registerPage.getTelephoneWarningMessage().contains("Telephone must be between 3 and 32 characters!"));
		
		Assert.assertEquals("Telephone must be between 3 and 32 characters!" ,  registerPage.getTelephoneWarningMessage() );
		
		
		//  Password Warning  --->>  Password must be between 4 and 20 characters!
		//Assert.assertTrue(registerPage.getPasswordWarningMessage().contains("Password must be between 4 and 20 characters!"));
		
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarningMessage() );

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
