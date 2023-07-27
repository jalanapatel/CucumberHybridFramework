package Experiments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Page 
		{
		
			WebDriver driver;
			
			public Register_Page(WebDriver driver1)
			{
				this.driver = driver1;
				
				PageFactory.initElements(driver, this);                          // Initialize webDriver and WebElements -- this = Register_Class.class				
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
				return warningMessagePassword.getText();
			}
			
			
			public String getTelephoneWarningMessage()
			{
				return warningMessageTelephone.getText();
			}
			
			
			
			public String getEmailWarningMessage()
			{
				return warningMessageEmail.getText();
			}
			
			
			
			
		public String getLastNameWarningMessage()
		{
			return warningMessageLastName.getText();
		}
			
			
			
		public String getFirstNameWarningMessage()
		{
			return warningMessageFirstName.getText() ;
		}
			
			
		public String getPrivacyPolicyWarningMessage()
		{
			return warningMassagePrivacyPolicy.getText();
		}
			
		public String getduplicateAccountMessage()
		{
			 return warningMessageDuplicateAccount.getText();
		}
			
		public void selectYesNewsLetterSubscriptio()
		{
			yesNewslettetSubscribeOption.click();
		}
			
		public void clickContinueButton()
		{
			continueButton.click();
		}
			
			
		public void selectPrivacyPolicy()
		{
			privacyPolicyOption.click();
		}
			
			
		public void enterConfirmPassword(String confirmPasswordText)
		{
			confirmPasswordField.sendKeys(confirmPasswordText);
		}
			
		public void enterPassword(String passwordText)
		{
			passwordField.sendKeys(passwordText);
		}
			
		public void enterTelephone(String telephoneText)
		{
			telephoneField.sendKeys(telephoneText);
		}
			
			
		public void enterEmail(String emailText)
		{
			emailField.sendKeys(emailText);
		}
			
			
			
		public void enterLastName(String lastNameText)
		{
				lastNameField.sendKeys(lastNameText);
		}
			
			
			
		public void enterFirstName(String firstNameText)
		{
			firstNameField.sendKeys(firstNameText);
		}
			
			
		
			
			
			
			
			
			
			
			
		}
