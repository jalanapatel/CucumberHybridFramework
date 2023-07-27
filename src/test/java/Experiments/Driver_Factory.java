package Experiments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver_Factory
{
	
	static WebDriver driver;

				public static void  initializeBrowser(String browserName)
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
							
			
				}
	
	/*   *********************************************************************************  */
	
				public static WebDriver getDriver()                            // Return driver 
				{
					return driver;
				}
				
				
				
	
}
