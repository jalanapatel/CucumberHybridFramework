package Experiments;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Utility.Config_Reader;

public class Driver_Factory_01
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
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					

					//					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
					
					return driver;

				}
	
	/*   *********************************************************************************  */
	
				public static WebDriver getDriver()                            // Return driver 
				{
					return driver;
				}
				
				
				
	
}
