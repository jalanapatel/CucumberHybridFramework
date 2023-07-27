package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Common_Utility_Class;
import Utility.Element_Utility_Class;

/*    

// durationInSeconds = Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME  = 30

*/

public class Register_Page 
		{
		
			WebDriver driver;
			
			private Element_Utility_Class element_Utils_Object;                                    // Create Object of Element_Utility_Class
			
			public Register_Page(WebDriver driver1)
			{
				this.driver = driver1;
				
				PageFactory.initElements(driver, this);                          // Initialize webDriver and WebElements -- this = Register_Class.class				
				
				element_Utils_Object = new Element_Utility_Class(driver) ;
			}
			
//  Identify WebElements  -- Objects
			
			
			@FindBy (id = "input-firstname")
			private WebElement firstNameField;
			
			
			@FindBy ( id = "input-lastname")
			private WebElement lastNameField;
			
			
			@FindBy (id = "input-email")
			private WebElement  emailField;
			
			
			@FindBy (id = "input-telephone")
			private WebElement telephoneField;
			
			
			@FindBy (id = "input-password")
			private WebElement passwordField;
			
			
			@FindBy (id = "input-confirm")
			private WebElement confirmPasswordField;
			
			
			@FindBy (name = "agree")
			private WebElement privacyPolicyOption;
			
			@FindBy (xpath = "//input[@value = 'Continue']" )
			private WebElement continueButton;
			
			
			@FindBy (xpath = "//input[@name='newsletter'][@value = '1']")
			private WebElement yesNewslettetSubscribeOption;
			
			@FindBy (xpath = "//div[contains(@class,'alert-dismissible')]")
			private WebElement warningMessageDuplicateAccount;
			
					
			@FindBy (xpath = "//div[contains(@class,'alert-dismissible')]")
			private WebElement warningMassagePrivacyPolicy;
			
			
			@FindBy (xpath = "//input[@id='input-firstname']/following-sibling::div")
			private WebElement warningMessageFirstName;
			
			
			@FindBy (xpath = "//input[@id='input-lastname']/following-sibling::div" )
			private WebElement warningMessageLastName;
			
			
			@FindBy (xpath = "//input[@id='input-email']/following-sibling::div" )
			private WebElement warningMessageEmail;
			
			
			@FindBy (xpath = "//input[@id='input-telephone']/following-sibling::div") 
			private WebElement warningMessageTelephone;
			
			@FindBy (xpath = "//input[@id='input-password']/following-sibling::div" )
			private WebElement warningMessagePassword;
			
// Actions  --- Methods
			
			
			public String getPasswordWarningMessage()
			{
				return element_Utils_Object.getTextFromElement(warningMessagePassword, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME);
				
			}
			
			
			public String getTelephoneWarningMessage()
			{
				return element_Utils_Object.getTextFromElement(warningMessageTelephone, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME) ;
			}
			
			
			
			public String getEmailWarningMessage()
			{
				return element_Utils_Object.getTextFromElement(warningMessageEmail, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME) ;
			}
	
			
		public String getLastNameWarningMessage()
		{
			 return element_Utils_Object.getTextFromElement(warningMessageLastName, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME) ;
		}
			
			
			
		public String getFirstNameWarningMessage()
		{
			return element_Utils_Object.getTextFromElement(warningMessageFirstName, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME) ;
			
		}
			
			
		public String getPrivacyPolicyWarningMessage()
		{
			return element_Utils_Object.getTextFromElement(warningMassagePrivacyPolicy, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME) ;
		}
			
		public String getduplicateAccountMessage()
		{
			return element_Utils_Object.getTextFromElement(warningMessageDuplicateAccount, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME) ;
		}
			
		public void selectYesNewsLetterSubscriptio()
		{
			element_Utils_Object.clickOnElement(yesNewslettetSubscribeOption, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME);
		}
			
		public Account_Success_Page clickContinueButton()
		{
			element_Utils_Object.clickOnElement(continueButton, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME);

			return new Account_Success_Page(driver);
		}
			
			
		public void selectPrivacyPolicy()
		{
			element_Utils_Object.clickOnElement(privacyPolicyOption, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME);
			
		}
			
			
		public void enterConfirmPassword(String confirmPasswordText)
		{
			element_Utils_Object.typeTextIntoElement(confirmPasswordField, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME, confirmPasswordText);
		}
			
		public void enterPassword(String passwordText)
		{
			element_Utils_Object.typeTextIntoElement(passwordField, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME, passwordText);
		}
			
		public void enterTelephone(String telephoneText)
		{
			element_Utils_Object.typeTextIntoElement(telephoneField, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME, telephoneText);
		}
			
			
		public void enterEmail(String emailText)
		{
			element_Utils_Object.typeTextIntoElement(emailField, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME, emailText);
			
		}
			
			
			
		public void enterLastName(String lastNameText)
		{
				element_Utils_Object.typeTextIntoElement(lastNameField,  Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME,  lastNameText);
		}
			
			
			
		public void enterFirstName(String firstNameText)
		{
			element_Utils_Object.typeTextIntoElement(firstNameField, Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME, firstNameText);
		}
			
			

		
			
		}
