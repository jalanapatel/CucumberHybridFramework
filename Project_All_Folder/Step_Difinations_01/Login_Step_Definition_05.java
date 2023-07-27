package Step_Difinations;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import FactoryName.Driver_Factory;
import Page_Object.Account_Page;
import Page_Object.Home_Page;
import Page_Object.Login_Page;
import Utility.Common_Utility_Class;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
 				valid_Email = jalanapatel0301@gmail.com
				valid_Password = 123456789
				
				Create method for creating new different invalid_email for every run, using timestamp
				
				Remove HardCode of Locators, using Page Object Model and Page Factory Design
				
				 #   Data drivern Framework,   --> Integrating Data Driven Scenario  ----> means scenario is written once, but executed multiple times, depen on no of data set passing into scenario. (Excel file not required at all)
 #   from Features_Files pass multiple dataset to Scenario 
 #   Use " Scenario Outline " keyword to convert data driven scenario,  and  " Examples: " and provide Datasets as show below for first Scenario: Login with Valid Credentials.
 #  and  make changed in data with  ' < > '  like <username>   < password > 
 #  here provide 3 dataset of username and password, so same scenario run three times.
 
 Add Extension of Tidy gherkin to run Data driven Scenario
 in Step definition methods are write as below
 @When("^User has enters  Valid Email Address  (.*) into the email Field of data$")   
@And("^User  has enters Valid password (.*) into the password Field of data$")                                                                       // this method belongs to data driven scenario of passwordl_Field of First Scenario: Valid Credentials
				
 
 ^ StartsWith
 $ EndsWith
 (.*)  data_Variable   instead of String_Value
 
 
 Use/Call/Invoke Element_Utility_Class and use different methods, multiple times.
 
 for go to any method Declaration and  Declaration Type ===>>>  Hold Ctrl key on keyboard and hover on method or class or constant type and make Right-Click
 
 
				
 */


public class Login_Step_Definition_05
{			

					WebDriver driver;
					
					private Login_Page loginPage;
					
					private Account_Page accountPage;
					
					private Common_Utility_Class common_Utility_Class ;
					
					

					@Given ("User has navigates to Login Page")
					public void  User_has_navigates_to_Login_Page()
							{
									driver = Driver_Factory.getDriver();                                                       // get Driver
									
									Home_Page homePage = new Home_Page(driver);                                               // Create Object of Home_Page
									
									homePage.clickOnMyAccount();                                                                            //   Get WebElement of My Account           
								
									loginPage = homePage.selectLoginoption();                                                                                       // Click on login
					
								}
			

					
					@When("^User has enters  Valid Email Address (.*) into the email Field of data$")                                                                   // this method belongs to data driven scenario of email_Field for First Scenario: Valid Credentials
					public void user_has_enters_valid_email_address_into_the_email_field_of_data(String emailText)
					{

						loginPage.enterEmailAddress(emailText);
		
					}

					
					
					@And("^User  has enters Valid password (.*) into the password Field of data$")                                                                       // this method belongs to data driven scenario of passwordl_Field of First Scenario: Valid Credentials
					public void user_has_enters_Valid_password_into_the_password_field_of_data(String passwordText) 
					{
							
						loginPage.enterPassword(passwordText);
						
					}
					
					@When("User has enters  Valid Email Address {string} into the email Field")
					public void user_has_enters_valid_email_address_into_the_email_field(String emailText)
					{

						loginPage.enterEmailAddress(emailText);
		
					}

					
					
					@And("User  has enters Valid password {string} into the password Field")
					public void user_has_enters_Valid_password_into_the_password_field(String passwordText) 
					{
							
						loginPage.enterPassword(passwordText);
						
					}

					@And("User has Click on Login button")
					public void user_has_click_on_login_button() 
					{
					
						accountPage = loginPage.clickonLoginButton();                                 //    Create/return  Object of Account_Page_Class
					
					}

					@Then("User should get successfully Logged in")
					public void user_should_get_successfully_logged_in()
					{
								Assert.assertTrue(accountPage.displayStatus_EditYourAccountInformationOption() );
					}

					
					
					@When ("User has enters Invalid Email Address into the email Field")
					public void user_has_enters_invalid_email_address_into_the_email_field()
					{
								common_Utility_Class = new Common_Utility_Class();                                        // Create Object of 	Common_Utility_Class 
						
									loginPage.enterEmailAddress(common_Utility_Class.getEmailAddressWithTimeStamp());                        // Get Invalid_Email from Common_Utility_Class 
					}


					@When("User has enters Invalid Password {string} into the password Field")
					public void user_has_enters_invalid_password_into_the_password_field(String invalidPasswordText) 
					{

						loginPage.enterPassword(invalidPasswordText);

					}

					@Then("User should get Warning Message about Credentials mismatch")                                    //   Warning: No match for E-Mail Address and/or Password.
					public void user_should_get_warning_message_about_credentials_mismatch() 
					{
							Assert.assertTrue( loginPage.warningMessageOfMisMatchCredentialsText().contains("Warning: No match for E-Mail Address and/or Password."));
		
					}

					@When("User do not enter Email Address into Email Field")
					public void user_do_not_enter_email_address_into_email_field() 
					{
					   
						loginPage.enterEmailAddress("");
			
					}

					
					@When("User do not enter Password into Password Field")
					public void user_do_not_enter_password_into_password_field() 
					{
						loginPage.enterPassword("");		
								
					}

					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
		}
