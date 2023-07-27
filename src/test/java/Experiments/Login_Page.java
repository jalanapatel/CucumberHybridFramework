package Experiments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page
{
			
			WebDriver driver;
			
			public Login_Page (WebDriver driver1)                          // Create constructor  with WebDriver as parameter, and webElements into class, initialize as object of Login_Page_Class is created.
					{
						this.driver = driver1;
						
						PageFactory.initElements(driver, this);                       // initialize driver and WebElements
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
				emailField.sendKeys(emailText);
			}
	
			
			public void enterPassword (String passwordText)
			{
				passwordField.sendKeys(passwordText);
			}
			
			
			public void clickonLoginButton()
			{
				loginButton.click();
			}
			
			
			public String warningMessageOfMisMatchCredentialsText()
			{
				return warningMessageNoMatchCredentials.getText();
			}
		
			
}
