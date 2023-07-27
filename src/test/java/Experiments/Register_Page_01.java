package Experiments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Element_Utility_Class;

public class Register_Page_01 
		{
		
			WebDriver driver;
			
			private Element_Utility_Class element_Utils_Object;                                    // Create Object of Element_Utility_Class
			
			public Register_Page_01(WebDriver driver1)
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
				return element_Utils_Object.getTextFromElement(warningMessagePassword, 30);
				
			}
			
			
			public String getTelephoneWarningMessage()
			{
				return element_Utils_Object.getTextFromElement(warningMessageTelephone, 30) ;
			}
			
			
			
			public String getEmailWarningMessage()
			{
				return element_Utils_Object.getTextFromElement(warningMessageEmail, 30) ;
			}
	
			
		public String getLastNameWarningMessage()
		{
			 return element_Utils_Object.getTextFromElement(warningMessageLastName, 30) ;
		}
			
			
			
		public String getFirstNameWarningMessage()
		{
			return element_Utils_Object.getTextFromElement(warningMessageFirstName, 30) ;
			
		}
			
			
		public String getPrivacyPolicyWarningMessage()
		{
			return element_Utils_Object.getTextFromElement(warningMassagePrivacyPolicy, 30) ;
		}
			
		public String getduplicateAccountMessage()
		{
			return element_Utils_Object.getTextFromElement(warningMessageDuplicateAccount, 30) ;
		}
			
		public void selectYesNewsLetterSubscriptio()
		{
			element_Utils_Object.clickOnElement(yesNewslettetSubscribeOption, 30);
		}
			
		public Account_Success_Page clickContinueButton()
		{
			element_Utils_Object.clickOnElement(continueButton, 30);

			return new Account_Success_Page(driver);
		}
			
			
		public void selectPrivacyPolicy()
		{
			element_Utils_Object.clickOnElement(privacyPolicyOption, 30);
			
		}
			
			
		public void enterConfirmPassword(String confirmPasswordText)
		{
			element_Utils_Object.typeTextIntoElement(confirmPasswordField, 30, confirmPasswordText);
		}
			
		public void enterPassword(String passwordText)
		{
			element_Utils_Object.typeTextIntoElement(passwordField, 30, passwordText);
		}
			
		public void enterTelephone(String telephoneText)
		{
			element_Utils_Object.typeTextIntoElement(telephoneField, 30, telephoneText);
		}
			
			
		public void enterEmail(String emailText)
		{
			element_Utils_Object.typeTextIntoElement(emailField, 30, emailText);
			
		}
			
			
			
		public void enterLastName(String lastNameText)
		{
				element_Utils_Object.typeTextIntoElement(lastNameField,  30,  lastNameText);
		}
			
			
			
		public void enterFirstName(String firstNameText)
		{
			element_Utils_Object.typeTextIntoElement(firstNameField, 30, firstNameText);
		}
			
			
		
			
			
			
			
			
			
			
			
		}
