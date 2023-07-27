package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Result_Page
{
			
		WebDriver driver;
		
		public Search_Result_Page(WebDriver driver1)                         // Create Constructor , when create object  Search_Page_Class, is called/invoked.
		{
			this.driver = driver1;
			
			PageFactory.initElements(driver,  this) ;                    // initialize driver and webElements
		}
	
	
// Identify WebElement
		
		@FindBy (linkText = "HP LP3065" )
		private WebElement validProductHP;
		
		
		
		@FindBy (xpath = "//input[@id='button-search']/following-sibling::p")
		private WebElement messageNoProductMatch;
		
		
		
		
		
		
		
		
		
 // Actions  --- Methods
	
	
	public boolean displayStatudOfValidProduct_HP()
	{
		     return   validProductHP.isDisplayed();
	}
	
	
	
	
	public String getmessageNoProductMatchText()
	{
		return messageNoProductMatch.getText() ;
	}
	
	
	
	
	
	
	
	
}
