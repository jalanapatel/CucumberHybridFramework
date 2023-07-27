package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Element_Utility_Class;

public class Search_Result_Page_01
{
			
		WebDriver driver;
		
		private Element_Utility_Class element_Utils_Object;
		
		public Search_Result_Page_01(WebDriver driver1)                         // Create Constructor , when create object  Search_Page_Class, is called/invoked.
		{
			this.driver = driver1;
			
			PageFactory.initElements(driver,  this) ;                    // initialize driver and webElements
			
			element_Utils_Object = new Element_Utility_Class(driver) ;                  //  Initiate Object of Element_Utility_Class
		}
	
	
// Identify WebElement
		
		@FindBy (linkText = "HP LP3065" )
		private WebElement validProductHP;
		
		
		
		@FindBy (xpath = "//input[@id='button-search']/following-sibling::p")
		private WebElement messageNoProductMatch;
		
		
		
		
		
		
		
		
		
 // Actions  --- Methods
	
	
	public boolean displayStatudOfValidProduct_HP()
	{
		return element_Utils_Object.displayStatusOfElement(validProductHP, 30) ;
		
	}
	
	
	
	
	public String getmessageNoProductMatchText()
	{
		 return element_Utils_Object.getTextFromElement(messageNoProductMatch, 30) ; 
		
	}
	
	
	
	
	
	
	
	
}
