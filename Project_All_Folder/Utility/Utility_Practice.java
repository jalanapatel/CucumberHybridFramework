package Utility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility_Practice
{

WebDriver driver = null;
	
	public Utility_Practice(WebDriver driver1)																																												// automatically catch/initiate driver So we can create Constructor
	{
		this.driver = driver1;
	}
	
	
	public void clickOn_Element( WebElement element,  long durationInSeconds)                                                             // Create method to perform click, on WebElement and accept two parameter (WebElement,  duraton of Time)
	{
		
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));                                              // create webDriverWait object ---> it is explicit wait in Selenium
						
						WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element)) ;                                  // .elementToBeClickble(element) --   checking an element is visible and enabled such that you can click it. and Return --> WebElement
		
						webElement.click();

	}
	
	
	
	public void typeTextInto_Element ( WebElement element, long durationInSecond, String textToBeType) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecond)) ;
		
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element)) ;                                                                                     // Wait for elements is visible, enable and clickable.  and return WebElement
		
		webElement.click();                                                                                                                                       // Click inside Element
		
		webElement.clear();                                                                                                                                   //  After Clicking, clear Element, (Remove value from element, if present) and reset value
		
		webElement.sendKeys(textToBeType);                                                                                                      // type/enter/write value inside element and which may set its value of Element
		
	}
	
	// Create Common Explicit_Wait
	
	public void waitFor_Element ( WebElement element, long durationInSeconds)                                               //  create method for Explicit_Wait,   --->>>  create webDriverWait object ---> it is explicit wait in Selenium
	{
			WebDriverWait  wait = new WebDriverWait( driver, Duration.ofSeconds(durationInSeconds));
			
			WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element)) ;                                                        // .elementToBeClickble(element) --   checking an element is visible and enabled such that you can click it. and Return --> WebElement
			
	}	
	
	

	/*   *************************      waitForElement() Method      --->>> Returns  --->> WebElement   ****************************************************************  */
	
	public WebElement  waitForElement ( WebElement element, long durationInSeconds)                                               //  create method for Explicit_Wait,   --->>>  create webDriverWait object ---> it is explicit wait in Selenium
	{
		WebElement webElement = null;	
		
		try 
		{
			WebDriverWait  wait = new WebDriverWait( driver, Duration.ofSeconds(durationInSeconds));
			
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element)) ;                                                        // .elementToBeClickble(element) --   checking an element is visible and enabled such that you can click it. and Return --> WebElement
			
			return webElement;      
            																																	// Use try-catch Block, to handle Exception.
		}
		catch ( Throwable e)
		{
			e.printStackTrace();
			System.out.println(e);
			
			return webElement;      
		}
		
		
	}
	
	/*   *************************     clickOnElement() Method  ===>> Takes two Parameter      ****************************************************************  */
	
	public void clickOnElement( WebElement element,  long durationInSeconds)                                                             // Create method to perform click, on WebElement and accept two parameter (WebElement,  duraton of Time)
	{
		
																																															// create webDriverWait object ---> it is explicit wait in Selenium
						
						WebElement webElement =  waitForElement( element, durationInSeconds) ;      //  call wait method, return WebElement,                   // .elementToBeClickble(element) --   checking an element is visible and enabled such that you can click it. and Return --> WebElement
		
						webElement.click();

	}
	
	/*   *************************      typeTextIntoElement() Method     ===>> Takes two Parameter   ***********************************************************  */
	
	public void typeTextIntoElement ( WebElement element, long durationInSeconds, String textToBeType) 
	{

		WebElement webElement =  waitForElement( element, durationInSeconds) ;      //  call wait method, return WebElement,                                                                                      // Wait for elements is visible, enable and clickable.  and return WebElement
		
		webElement.click();                                                                                                                                       // Click inside Element
		
		webElement.clear();                                                                                                                                   //  After Clicking, clear Element, (Remove value from element, if present) and reset value
		
		webElement.sendKeys(textToBeType);                                                                                                      // type/enter/write value inside element and which may set its value of Element
		
	}
	
	
	/*   *************************      selectOptionInDropdown() Method     ===>> Takes three Parameter   ***********************************************************  */
	
	
	public void selectOptionInDropdown ( WebElement element, String dropDownOption, long durationInSeconds)
	{
		WebElement webElement = waitForElement ( element, durationInSeconds) ;                                          // call waitForElement() Method and return WebElement
		
			Select select = new Select(webElement) ;                                                                                              // Create Object of Select_Class, and pass webElement as parameter
			
			select.selectByVisibleText(dropDownOption) ;			
						
	}
	
	
	/*   *************************      waitForAlert() Method     ===>> Takes two Parameter   ====>>>  return Alert ***********************************************************  */
	
		  
	public Alert waitForAlert( long durationInSeconds)                                                                            // Create wait_method for Alert, which return Alert
	{																																														// Use try/catch block to handle, Exceptions
				Alert alert = null;
		
		try
		{
				WebDriverWait waitAlert = new WebDriverWait( driver, Duration.ofSeconds(durationInSeconds));
				
				 alert = waitAlert.until(ExpectedConditions.alertIsPresent()) ;
				
				return alert ;
		}
		catch ( Throwable e)
				{
					e.printStackTrace() ;
					
					System.out.println(e);
					
					return alert;
				}
			
	}
	
	
/*   *************************      acceptAlert() Method     ===>> Takes one Parameter   ***********************************************************  */
	
	
	public void acceptAlert ( long durationInSeconds) 
			{
				Alert alert  = waitForAlert(  durationInSeconds) ;                                       // call waitForAlert() method and return Alert_Class_Object
				
				alert.accept() ;                                                                                           // perform Accept Action on Alert.
			}
	
	
/*   *************************      dismissAlert() Method     ===>> Takes one Parameter   ***********************************************************  */
		
	
		public void dismissAlert ( long durationInSeconds)
		{
			 
				Alert alert = waitForAlert(durationInSeconds);                                     // Call/Invoke waitForAlert() Method and return Alert_Class_Object
			
				alert.dismiss();                                                                                      // perform Dismiss Action on Alert.
			
		}
	
/*   *************************      waitForVisibilityOfElement() Method   ===>> Takes  two   Parameter   ***********************************************************  */

		// Create WebElement Visibility Methods,  and use multiple times
		
		public WebElement waitForVisibilityOfElement (WebElement element, long durationInSeconds)
					{
									WebElement webElement = null;
									
									try
									{
									WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));                            // create wait methods, for visibility of WebElement
																																																			// Use try/catch to handle Exceptions
									webElement = wait.until(ExpectedConditions.visibilityOf(element));
									
									return webElement;
									
									}
									
									catch (Throwable e)
									{
										e.printStackTrace();
										System.out.println(e);
										
										return webElement ;
									}
				
					}
	
/*   *************************      mouseHoverAndClick() Method     ===>> Takes  two   Parameter  ===>> Perform Mouse Actions  ***********************************************************  */
		
	
		public void mouseHoverAndClick( WebElement element, long durationInSeconds)                                                         // click Action is perform by Mouse ( Not by Selenium command, not using  .click() method)
		{
				 
	//		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(durationInSeconds));                     // Create wait_Method , until WebElement is visible
			
	//		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element) ) ;                                // .visibilityOf(element) method   --  checking that an element, present on  page, is visible and Returns  ===>>> the (same) WebElement once it is visible
			
			
			WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
			
			
			Actions actions = new Actions(driver); 																						 // Create object of Action_Class.
			
			actions.moveToElement(webElement).click().build().perform() ;
		}
	
	
/* ******************************    javaScriptClick() Method ===>>> takes two parameter  ===>> perform Actions    ************************************************************* */		

		// when .click() method or Actions_Class_Click or any other selenium code is not working then javaScriptExecutor is Used and start working on it.
		
		public void javaScriptClick( WebElement element, long durationInSeconds)
				{
						WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
						
					JavascriptExecutor java_Script_Exe  = ( (JavascriptExecutor)driver) ;                                                                    // Type case driver with JavascriptExecutor
				
					java_Script_Exe.executeScript("argument[0].click(); ",  webElement) ;                                                           //  .executeScript() method  -- Executes JavaScript in the context of the currently selected frame or window. 
				
				}
	
	
		/* ******************************    javaScriptClick() Method ===>>> takes two parameter  ===>> perform Actions    ************************************************************* */		

		// when .click() method or Actions_Class_Click or any other selenium code is not working then javaScriptExecutor is Used and start working on it.
		
		public void javaScript_Click( WebElement element, long durationInSeconds)
				{
						WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
						
					JavascriptExecutor java_Script_Exe  = ( (JavascriptExecutor)driver) ;                                                                    // Type case driver with JavascriptExecutor
				
					java_Script_Exe.executeScript("argument[0].click(); ",  webElement) ;                                                           //  .executeScript() method  -- Executes JavaScript in the context of the currently selected frame or window. 
				
				}


		/* ******************************    javaScriptClick() Method ===>>> takes two parameter  ===>> perform Actions    ************************************************************* */		
		
				//  .sendKey() method  is not working, than javascroptType()  method is worked.
		
			public void javaScriptType ( WebElement element, long durationInSeconds, String textToBeTyped)
			{
					WebElement webElement = waitForVisibilityOfElement ( element, durationInSeconds);
				
					JavascriptExecutor jse = ( (JavascriptExecutor)driver) ;
				
					jse.executeScript("argument[0].value = ' "+textToBeTyped+" ' ", webElement);                                // textToBeTyped = Input_Value  for sendKey() Method
		
		
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
