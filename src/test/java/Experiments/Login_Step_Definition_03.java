package Experiments;

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
				
 */


public class Login_Step_Definition_03
{			

					WebDriver driver;
					
					private Login_Page loginPage;
					
					private Common_Utility_Class Common_Utility_Class;
					
					
					private String getEmailAddressWithTimeStamp()                                 // Create Method with Private Access, to generate email with timestamp
							{
								Date date = new Date();
								
								String email_TimeStamp ="jammyPatel_" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com" ;
								
								return email_TimeStamp ;
				
							}
					
	
					@Given ("User has navigates to Login Page")
					public void  User_has_navigates_to_Login_Page()
							{
									driver = Driver_Factory.getDriver();                                                       // get Driver
									
									Home_Page homePage = new Home_Page(driver);                                               // Create Object of Home_Page
									
									homePage.clickOnMyAccount();                                                                            //   Get WebElement of My Account
								
									homePage.selectLoginoption();                                                                                       // Click on login
					
								}
			

					
					@When("User has enters  Valid Email Address {string} into the email Field")
					public void user_has_enters_valid_email_address_into_the_email_field(String emailText)
					{
					
						loginPage = new Login_Page(driver);
						
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
					
						loginPage.clickonLoginButton();
					
					}

					@Then("User should get successfully Logged in")
					public void user_should_get_successfully_logged_in()
					{
						Account_Page accountPage = new Account_Page(driver);          // Create Object of Account_Page_Class
						
						Assert.assertTrue(accountPage.displayStatus_EditYourAccountInformationOption() );
					}

					
					
					@When ("User has enters Invalid Email Address into the email Field")
					public void user_has_enters_invalid_email_address_into_the_email_field()
					{
						
						loginPage = new Login_Page(driver);
						
						Common_Utility_Class = new Common_Utility_Class();
						
						loginPage.enterEmailAddress(Common_Utility_Class.getEmailAddressWithTimeStamp());                        // Get Email from Common_Utility_Class 
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
					    loginPage = new Login_Page(driver);	
						loginPage.enterEmailAddress("");
						
						
					}

					
					@When("User do not enter Password into Password Field")
					public void user_do_not_enter_password_into_password_field() 
					{
						loginPage.enterPassword("");		
								
					}

					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
		}
