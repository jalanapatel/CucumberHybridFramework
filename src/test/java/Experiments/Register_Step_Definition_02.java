package Experiments;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import FactoryName.Driver_Factory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register_Step_Definition_02 
{
	WebDriver driver;
	
	private String getEmailWithTimeStamp()
					{
						Date date = new Date();
						
						String email_TimeStamp = "jammyPatel_" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
						
						return email_TimeStamp ;
					}
	
	@Given ("User has navigates to Register Account Page")
	public void User_has_navigates_to_Register_Account_Page()
	{
		
		driver = Driver_Factory.getDriver();
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		driver.findElement(By.linkText("Register")).click();
	
		
	}
	
	
	@When("User enters the details into below Fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) 
	{
	     Map <String, String>  dataMap = dataTable.asMap(String.class, String.class);
		
	     driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("FirstName"));
	     
	     driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("LastName"));
		
	     driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());                       // Get new email address from  .getEmailWithTimeStamp() method
	
	     driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("Telephone"));
	
	     driver.findElement(By.id("input-password")).sendKeys(dataMap.get("Password"));
	
	     driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("Password"));
	     
	 
	}
	
	
	@When("User enters the details into below Fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) 
	{
	     Map <String, String>  dataMap = dataTable.asMap(String.class, String.class);
		
	     driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("FirstName"));
	     
	     driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("LastName"));
		
	     driver.findElement(By.id("input-email")).sendKeys(dataMap.get("Email"));                       // Get duplicate  email address from  Register.feature File
	
	     driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("Telephone"));
	
	     driver.findElement(By.id("input-password")).sendKeys(dataMap.get("Password"));
	
	     driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("Password"));
	     
	 
	}
	

	@When("User selects Privact Policy box")
	public void user_selects_privact_policy_box()
	{
	    	    driver.findElement(By.name("agree")).click();
	}

	@When("Clicks on Continue button")
	public void clicks_on_continue_button()
	{
	  
		driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
		
	}

	@Then("User account should get created Successfully")                                            //  Your Account Has Been Created!
	public void user_account_should_get_created_successfully() 
	{
	
		Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//div[@id='content']/h1")).getText() );
		
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/h1")).getText().contains("Your Account Has Been Created!"));

	}

	@When("User selects  Yes  Newsletter subscribe")
	public void user_selects_yes_newsletter_subscribe() 
	{
		//label[@class='radio-inline']/input[@value='1']
		
		//input[@name='newsletter'][@value = '1']
		
		driver.findElement(By.xpath("//input[@name='newsletter'][@value = '1']")).click();
				
	}

	@Then("User should get proper Waring Message about duplicate Account {string}")                                 // Warning: E-Mail Address is already registered!
	public void user_should_get_proper_waring_message_about_duplicate_account(String string)
	{
		//div[@class ='alert alert-danger alert-dismissible']
		
		//div[contains(@class,'alert-dismissible')]
	    
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
		
	}

	@When("User do not enter any details into fields")
	public void user_do_not_enter_any_details_into_fields()
	{
	    
		// Intentionally Left Blank    ====>>>   As details are not entered  ---- Directly click on Continue Button
		
	}

	@Then("User should get proper Warning Messages for every Mandatory fields")
	public void user_should_get_proper_warning_messages_for_every_mandatory_fields() 
	{
	    // Privacy-Policy Warning  -->> Warning: You must agree to the Privacy Policy!
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
		
		
		
		
		//  First Name Warning   --->>   First Name must be between 1 and 32 characters!
		//Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getTagName().contains("First Name must be between 1 and 32 characters!"));
		
		Assert.assertEquals("First Name must be between 1 and 32 characters!" , driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText() );
		
		
		
		//  Last Name Warning  --->>  Last Name must be between 1 and 32 characters!
		//Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText().contains("Last Name must be between 1 and 32 characters!"));
		
		Assert.assertEquals( "Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
		
		
		//  E-mail Warning  --->>  E-Mail Address does not appear to be valid!
		// Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText().contains("E-Mail Address does not appear to be valid!"));
		
		Assert.assertEquals("E-Mail Address does not appear to be valid!" , driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
		
		
		
		// Telephone Warning   --->>  Telephone must be between 3 and 32 characters!
		// Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText().contains("Telephone must be between 3 and 32 characters!"));
		
		Assert.assertEquals("Telephone must be between 3 and 32 characters!" , driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText() );
		
		
		
		//  Password Warning  --->>  Password must be between 4 and 20 characters!
		//Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText().contains("Password must be between 4 and 20 characters!"));
		
		Assert.assertEquals("Password must be between 4 and 20 characters!",driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
