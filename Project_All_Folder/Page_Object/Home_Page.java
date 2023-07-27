package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page 
{

	
	WebDriver driver;                                                                    // Create global Webdriver
	
	public Home_Page( WebDriver driver1)                                // Create Constructor, with parameter of WebDriver
	{
		  this.driver = driver1;                                                        // When we create Object of Home_Page class, this constructor is called and initialize driver and all webElements of Page 
		  
		  PageFactory.initElements(driver, this) ;                          // Initialize webElements, this = Home_Page.class 
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
		myAccountDropMenu.click();
	}
	
	
	public Login_Page  selectLoginoption()
	{
		loginOption.click();
		
		return new Login_Page(driver);
	}
	
	 
	public Register_Page selectRegisterOption()
	{
		registerOption.click();
		
		return new Register_Page(driver);
	}
	
	
	public void enterProductIntoSearchBox(String productText)
	{
		searchBoxField.sendKeys(productText);
	}

	
	public Search_Result_Page clickOnSearchButton()
	{
		searchButton.click();
		
		return new Search_Result_Page(driver);
	}
	
	
	
	
	
	
}
