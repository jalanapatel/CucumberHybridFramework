package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Common_Utility_Class;
import Utility.Element_Utility_Class;

/*    

//durationInSeconds = Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME  = 30

*/

public class Search_Result_Page
{
			
		WebDriver driver;
		
		private Element_Utility_Class element_Utils_Object;
		
		public Search_Result_Page(WebDriver driver1)                         // Create Constructor , when create object  Search_Page_Class, is called/invoked.
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
		return element_Utils_Object.displayStatusOfElement(validProductHP, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME ) ;
		
	}
	
	
	
	
	public String getmessageNoProductMatchText()
	{
		 return element_Utils_Object.getTextFromElement(messageNoProductMatch, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME  ) ; 
		
	}
	
	
	
	
	
	
	
	
}
