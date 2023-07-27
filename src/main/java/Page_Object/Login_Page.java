package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Common_Utility_Class;
import Utility.Element_Utility_Class;

/*    
	
	// durationInSeconds = Commom_Utility_Class.EXPLICIT_WAIT_BASIC_TIME  = 30

*/

public class Login_Page
{
			
			WebDriver driver;
			
			private Element_Utility_Class element_Utils_Object ;
			
			public Login_Page (WebDriver driver1)                          // Create constructor  with WebDriver as parameter, and webElements into class, initialize as object of Login_Page_Class is created.
					{
						this.driver = driver1;
						
						PageFactory.initElements(driver, this);                                                   // initialize driver and WebElements
						
						element_Utils_Object = new Element_Utility_Class(driver) ;                // Initiate  Object of Element_Utility_Class and pass driver as parameter
					}
			
	
	
// Identify WebElement  --- Object
			
			@FindBy (id = "input-email")                                            // Create WebElement of Email_Field
			private WebElement emailField;
			
			
			@FindBy (id = "input-password")
			private WebElement passwordField;
			
			
			@FindBy ( xpath = "//input[@value='Login']")
			private WebElement loginButton;
			
			
			@FindBy ( xpath = "//div[(contains(@class, 'alert-danger alert-dismissible'))]")
			private WebElement warningMessageNoMatchCredentials;
			


//  Create Actions  --- Methods
			
			
			public void enterEmailAddress(String emailText)
			{
				element_Utils_Object.typeTextIntoElement(emailField, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME,  emailText);                        // .typeTextIntoElement(webElement, durationInSeconds, textTobeType) method, available in Element_Utility_Class, enter text into webElement like sendKey() Methods
			}
	
			
			public void enterPassword (String passwordText)
			{
				element_Utils_Object.typeTextIntoElement(passwordField, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME, passwordText);
				
			}
			
			
			public Account_Page  clickonLoginButton()
			{
				element_Utils_Object.clickOnElement(loginButton, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME );                                            // .clickOnElement(webElement, durationInSeconds) method, available in Element_Utility_Class
			
				return new  Account_Page(driver);
			}
			
			
			public String warningMessageOfMisMatchCredentialsText()
			{
				  return  element_Utils_Object.getTextFromElement( warningMessageNoMatchCredentials, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME) ;
				
				
			}
		
			
}
