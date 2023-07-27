package Hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import FactoryName.Driver_Factory;
import Utility.Config_Reader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



/*
			Here, Some data is HardCode like BrowserName and url,  So we Will remove hardCoding of data, Using Config.Properties files.
			
			config_Data --->> browserName, url
 */



public class My_Hooks 
{
	WebDriver driver;
	
	private Config_Reader config_Reader;
	
	
	@Before
	public void setUp()
					{
						config_Reader = new Config_Reader();                                                        // Create Object of Config_Reader_Class
		
						Properties prop = config_Reader.initializeProperties() ;                                                     // Load Properties File and Return Object of Properties_Class, using Config_Reader_Class																
	
						driver = Driver_Factory.initializeBrowser(prop.getProperty("browserName"));                // Initialize driver -- using Config_Reader Class, and get/read BrowserName
						                                              				                                                                                // Return driver

						driver.get(prop.getProperty("url"));                                                                          // Read/get Url --- Using Config_Readet_Class and config.properties file
						
				}
	
	
//  Take ScreenShot of Failed_Test  ====>>>  Make Changes in @After  Annotation and Method
	
		@After
		public void tearDown( Scenario scenario)
		{
																											// Take ScreenShot, before Close driver
			
			String scenarioName = scenario.getName().replace(" ", "_");                                           // get Name of Failed Scenario, So we can attach  name  of Failed Scenario, with SreenShot
			
			if ( scenario.isFailed())
					{
						byte[] src_ScreenShot =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);                         //   Capture the screenshot and store it in the specified location and return byte [] array
						 
						scenario.attach(src_ScreenShot, "image/png", scenarioName);                                                           // Attach Screenshot, with Report.
																																												// "image/png"  will be extension of screenshot like it will convert byte[] array form of screenshot into .png format and attach with report.						
						
						
					}
			
			
			driver.quit();
		}
	
	
	
	
/*	
	@After
	public void tearDown()
				{
					driver.quit();
					                                                                                                       // driver.close();   ---> working fine not failing Test or stopping test, but in console it will shows Socket Exception -- Connection reset.
				}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
