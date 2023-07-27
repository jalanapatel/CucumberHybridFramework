package Experiments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Element_Utility_Class;

public class Account_Success_Page_01
{

		WebDriver driver;
		
		private Element_Utility_Class element_Utils_Object;                                    // Create Object of Element_Utility_Class, so we can use methods
		
		
		public Account_Success_Page_01(WebDriver driver1)      // Create Constructor
				{
					this.driver = driver1;
					
					PageFactory.initElements(driver, this);                 // initialize webElement and Driver
					
					element_Utils_Object = new Element_Utility_Class(driver) ;                     // Initiate element_Utility_Object
				}
	

		
//    Identify WebElements   ---  Objects
		
		@FindBy (xpath = "//div[@id='content']/h1" )
		private WebElement accountSuccessPageHeading;
		
		
		

		
		
// Actions  --- Methods
		
		public String  accountSuccessPageHeading()
		{
			return element_Utils_Object.getTextFromElement(accountSuccessPageHeading, 30) ;                       //  .getTextFromElemetn( webElement, durationInSeconds) method is available in Element_Utility_Class  -- return visible_Text of Element

		}
	
	
	
	
	
	
	
	
	
	
	
	
}
