package Experiments;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import FactoryName.Driver_Factory;
import Utility.Config_Reader;
import io.cucumber.java.After;
import io.cucumber.java.Before;



/*
			Here, Some data is HardCode like BrowserName and url,  So we Will remove hardCoding of data, Using Config.Properties files.
			
			config_Data --->> browserName, url
 */



public class My_Hooks_01 
{
	WebDriver driver;
	
	Config_Reader Config_Reader = new Config_Reader();                                    // As static remove for Config_Reader, here Create Object of Config_Reader_Class
	
	
	@Before
	public void setUp()
					{

						Properties prop = Config_Reader.initializeProperties() ;                                                     // Load Properties File and Return Object of Properties_Class, using Config_Reader_Class																
	
						driver = Driver_Factory.initializeBrowser(prop.getProperty("browserName"));                // Initialize driver -- using Config_Reader Class, and get/read BrowserName
						                                              				                                                                                // Return driver

						driver.get(prop.getProperty("url"));                                                                          // Read/get Url --- Using Config_Readet_Class and config.properties file
						
				}
	
	
	@After
	public void tearDown()
				{
					driver.quit();
				}
				
	
}
