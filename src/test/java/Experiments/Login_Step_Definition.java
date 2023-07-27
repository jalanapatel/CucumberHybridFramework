package Experiments;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
 				valid_Email = jalanapatel0301@gmail.com
				valid_Password = 123456789

 */


public class Login_Step_Definition
{			
	WebDriver driver;
	
	
	
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	
	@After
	public void tearDown()
	{
		driver.close();
	}
	
					
	
					@Given ("User has navigates to Login Page")
					public void  User_has_navigates_to_Login_Page()
					
					{
							driver.findElement(By.xpath("//span[text()= 'My Account']")).click();
							
							driver.findElement(By.linkText("Login")).click();
			
					}
			

					
					@When("User has enters  Valid Email Address {string} into the email Field")
					public void user_has_enters_valid_email_address_into_the_email_field(String emailText)
					{
					
						driver.findElement(By.id("input-email")).sendKeys(emailText);
						
					}

					
					
					@And("User  has enters Valid password {string} into the password Field")
					public void user_has_enters_Valid_password_into_the_password_field(String passwordText) 
					{
					    
						driver.findElement(By.id("input-password")).sendKeys(passwordText);
						
					}

					@And("User has Click on Login button")
					public void user_has_click_on_login_button() 
					{
					
						driver.findElement(By.xpath("//input[@value='Login']")).click();
						
					}

					@Then("User should get successfully Logged in")
					public void user_should_get_successfully_logged_in()
					{
						
						Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
			
					}

					@When("User has enters Invalid Email Address {string} into the email Field")
					public void user_has_enters_invalid_email_address_into_the_email_field(String invalidEmailText) 
					{
					   
						driver.findElement(By.id("input-email")).sendKeys(invalidEmailText);
		
					}

					@When("User has enters Invalid Password {string} into the password Field")
					public void user_has_enters_invalid_password_into_the_password_field(String invalidPasswordText) 
					{

						driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
	
					}

					@Then("User should get Warning Message about Credentials mismatch")                                    //   Warning: No match for E-Mail Address and/or Password.
					public void user_should_get_warning_message_about_credentials_mismatch() 
					{
							
						Assert.assertTrue(driver.findElement(By.xpath("//div[(contains(@class, 'alert-danger alert-dismissible'))]")).getText().contains(" Warning: No match for E-Mail Address and/or Password."));
	
					}

					@When("User do not enter Email Address into Email Field")
					public void user_do_not_enter_email_address_into_email_field() 
					{
					    	
						driver.findElement(By.id("input-email")).sendKeys(" ");
						
					}

					
					@When("User do not enter Password into Password Field")
					public void user_do_not_enter_password_into_password_field() 
					{
									
						driver.findElement(By.id("input-password")).sendKeys(" ");
									
					}

					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
		}
