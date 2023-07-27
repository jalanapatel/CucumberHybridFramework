package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Common_Utility_Class;
import Utility.Element_Utility_Class;

/*    
  			
  			// durationInSeconds = Commom_Utility_Class.EXPLICIT_WAIT_BASIC_TIME  = 30
 
 */


public class Home_Page 
{

	
	WebDriver driver;                                                                           // Create global Webdriver
	
	private Element_Utility_Class element_Utils_Object ;                  // Create Object of Element_Utility_Class so we use different methods multiple time 


	
	
	public Home_Page( WebDriver driver1)                   								                // Create Constructor, with parameter of WebDriver
	{
		  this.driver = driver1;                                                     								   // When we create Object of Home_Page class, this constructor is called and initialize driver and all webElements of Page 
		  
		  PageFactory.initElements(driver, this) ;                         								 // Initialize webElements, this = Home_Page.class 
		  
		  element_Utils_Object = new  Element_Utility_Class(driver);                              // Initiate Object of Element_Utility_Class, into Constructor
		  
	}
	
// Identify WebElement   ----   Object 	
	
	@FindBy (xpath = ("//span[text()= 'My Account']"))                           // Create WebElement of My Account
	private WebElement myAccountDropMenu; 
	
	
	@FindBy ( linkText = "Login")
	private WebElement loginOption;
	
	
	@FindBy ( linkText = "Register" )
	private WebElement registerOption;
	
	@FindBy ( name = "search")
	private WebElement searchBoxField;
	
	
	@FindBy (xpath = "//button[contains(@class,'btn btn-default btn-lg')]" )
	private WebElement searchButton;
	


//  Actions  ---  Methods
	
	
	public void clickOnMyAccount()                                                   // Create Method to Click on My_Account DropMenu
	{
		
		element_Utils_Object.clickOnElement(myAccountDropMenu, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME );                                 // .clickOnElement( webElement, durationInSeconds) method is available in Element_Utils_Class  ---> click on WebElement, and wait for 15 seconds 

	}
	
	
	public Login_Page  selectLoginoption()                                           // Create Method to Click on Login_Option
	{

		element_Utils_Object.clickOnElement(loginOption, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME );
		
		return new Login_Page(driver);
	}
	
	 
	public Register_Page selectRegisterOption()
	{
		
		element_Utils_Object.clickOnElement(registerOption,  Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME );
		
		return new Register_Page(driver);
	}
	
	
	public void enterProductIntoSearchBox(String productText)
	{
		
		element_Utils_Object.typeTextIntoElement(searchBoxField,  Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME , productText);                            // .typeTextIntoElement ( WebElement element, long durationInSeconds, String textToBeType)  method is available in Element_Utility_Class, which accecpt input in textToBeType_Variable like .sendKey() Method
		
	}

	
	public Search_Result_Page clickOnSearchButton()
	{
		
		element_Utils_Object.clickOnElement(searchButton,  Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME );
																																							
		return new Search_Result_Page(driver);
	}
	
	
	
	
	
	
}
