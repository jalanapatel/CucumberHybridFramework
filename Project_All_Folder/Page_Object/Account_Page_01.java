package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Element_Utility_Class;

public class Account_Page_01 
		{
		
			WebDriver driver;                                                              // Create WebDriver
			
			private Element_Utility_Class element_Utils_Object;                            // Create Object of Element_Utility_Class
			
			
			public Account_Page_01(WebDriver driver1)                     // Create Constructor
			{
				 this.driver = driver1;
				 
				 PageFactory.initElements(driver, this);                // initialize webElements and driver
				 
				 element_Utils_Object = new Element_Utility_Class(driver);                   // initiate  element_Utils_Object and pass driver as parameter

			}
			
// WebElement
			
			@FindBy ( linkText = "Edit your account information")
			private WebElement editYourAccountInformationOption;
			
			
			
// Actions  -- Methods
			
			public boolean displayStatus_EditYourAccountInformationOption()                   // create method of displayStatus and return type is boolean
			{
				 return element_Utils_Object.displayStatusOfElement(editYourAccountInformationOption, 30) ;                            // .dispalyStatusOfElement( webElement, durationInSeconds) method is available in Element_Utility_Class -- return true if Element is Present				

			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
