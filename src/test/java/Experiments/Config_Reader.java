package Experiments;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



/*
 			here configure ---> config.properties file for browser level data like browserName, Url .
 			
             Project_PatH ==>>  System.getProperty("user.dir") 
             
             File_Path in Project ==>>  \\src\\test\\resources\\Config\\config.properties 
						
 
 */


public class Config_Reader                                                                  // Create Class to  Read config.properties file
{
		
			public static Properties  initializeProperties()                              // create method to initialize config.properties fiel for browser level data and return type is Properties.
			{
						Properties prop = new Properties();                                        
						
						String file_Path_config_Properties = System.getProperty("user.dir") + "\\src\\test\\resources\\Config\\config.properties"; 
						
						File prop_File = new File(file_Path_config_Properties);
						
						FileInputStream fis_config;
						try 
							{
									fis_config = new FileInputStream(prop_File);
								
									prop.load(fis_config);                                                                                  // Read config.properties file
							} 
						
						catch (Throwable  e) 
						{
									e.printStackTrace();
									
									System.out.println(e);
						}
						
						
						return prop;
			}
	
	
	
	
	
}
