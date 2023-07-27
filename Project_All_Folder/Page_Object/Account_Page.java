package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_Page 
		{
		
			WebDriver driver;                                                              // Create WebDriver
			
			public Account_Page(WebDriver driver1)                     // Create Constructor
			{
				 this.driver = driver1;
				 
				 PageFactory.initElements(driver, this);                // initialize webElements and driver
				
			}
			
// WebElement
			
			@FindBy ( linkText = "Edit your account information")
			private WebElement editYourAccountInformationOption;
			
			
			
// Actions  -- Methods
			
			public boolean displayStatus_EditYourAccountInformationOption()                   // create method of displayStatus and return type is boolean
			{
				return editYourAccountInformationOption.isDisplayed();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
