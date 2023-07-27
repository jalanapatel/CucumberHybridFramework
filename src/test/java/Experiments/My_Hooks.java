package Experiments;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import FactoryName.Driver_Factory;
import io.cucumber.java.After;
import io.cucumber.java.Before;



/*
			Here, Some data is HardCode like BrowserName and url,  So we Will remove hardCoding of data, Using Config.Properties files.
 */



public class My_Hooks 
{
	WebDriver driver;
	
	
	@Before
	public void setUp()
					{
						Driver_Factory.initializeBrowser("chrome");                                 // Initialize driver 
						
						driver = Driver_Factory.getDriver();                                              // Return driver
						
						driver.manage().deleteAllCookies();
						
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	//					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
						
						driver.get("https://tutorialsninja.com/demo/");
					}
	
	
	@After
	public void tearDown()
				{
					driver.close();
				}
				
	
}
