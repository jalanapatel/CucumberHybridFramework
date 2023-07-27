package FactoryName;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Utility.Common_Utility_Class;
import Utility.Config_Reader;

public class Driver_Factory
{
	
	static WebDriver driver;

				public static WebDriver  initializeBrowser(String browserName)
				{
		
					if (browserName.equalsIgnoreCase("Chrome"))
					{
						 driver = new ChromeDriver();
					}
					
	
					else if (browserName.equalsIgnoreCase("Firefox"))
					{
						 driver = new FirefoxDriver();
					}
					
			
					else if(browserName.equalsIgnoreCase("Edge"))
					{
						 driver = new EdgeDriver();
					}
					
	
					else if (browserName.equalsIgnoreCase("safari"))
					{
						 driver = new SafariDriver();
					}
							
					driver.manage().deleteAllCookies();
					
					driver.manage().window().maximize();
					
					driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds( Common_Utility_Class.PAGE_LOAD_TIME) ) ;           //  .pageLoadTimeOut() method  --  Sets the amount of time to wait for a page load to complete before throwing an error.
																																																					//    Common_Utility_Class has created PAGE_LOAD_TIME = 15 Constant 

					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( Common_Utility_Class.IMPLICIT_WAIT_TIME));             //   Common_Utility_Class has created IMPLICIT_WAIT_TIME = 10  Constant 
					

					//					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
					
					return driver;

				}
	
	/*   *********************************************************************************  */
	
				public static WebDriver getDriver()                            // Return driver 
				{
					return driver;
				}
				
				
				
	
}
