package Experiments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_Success_Page
{

		WebDriver driver;
		
		public Account_Success_Page(WebDriver driver1)      // Create Constructor
				{
					this.driver = driver1;
					
					PageFactory.initElements(driver, this);                 // initialize webElement and Driver
				}
	

		
//    Identify WebElements   ---  Objects
		
		@FindBy (xpath = "//div[@id='content']/h1" )
		private WebElement accountSuccessPageHeading;
		
		
		
		
		
		
		
		
		
		
		
		
// Actions  --- Methods
		
		public String  accountSuccessPageHeading()
		{
			return accountSuccessPageHeading.getText();
		}
	
	
	
	
	
	
	
	
	
	
	
	
}
