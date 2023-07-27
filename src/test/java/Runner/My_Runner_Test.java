package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// Advantage of Cucumber is generate report very clear along with Pass/Fail and Attach ScreenShot , Like we do not need any other third-party Tool ( Extent_Report )


/*
  To run Cucumber_Project, in@CucumberOptions ---> features and glue are Mandatory.
  							
   publish = true  -----> Create URL of Report so we can publish report in cloud
    we can Publish report by configure Cucumber Properties 
	
 	View your Cucumber Report at:  ===>>>     https://reports.cucumber.io/reports/2ecd0894-e033-438a-acc8-84fb5c6d551e │
                                                                         │
   This report will self-destruct in 24h.    ===>>>     Keep reports forever: https://reports.cucumber.io/profile  
 */


@RunWith(Cucumber.class)
@CucumberOptions( features = "src\\test\\resources\\features_Files"
								, glue =  {  "Step_Difinations" ,  "Hooks"} 
								,monochrome = true							                                                                               // Make console Output is more readable,( no more gibberish Format )
								, plugin = { "pretty" , "html:target/CucumberReport/CucumberReport.html  "}                                                                            // pretty is plugin, which gives different color Console OutPut, very easy to understood and Read
	                                                                                                                                                       // html is plugin, which generate report in HTML format, at location as defined  in target_Folder
								
								, publish = true                                                                                                  // publish = create Url of Report so we can publish report in cloud
																	)

public class My_Runner_Test
		{
					
			
			
			
			
		}















