package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*
  To run Cucumber_Project, in@CucumberOptions ---> features and glue are Mandatory.
 */


@RunWith(Cucumber.class)
@CucumberOptions( features = "src\\test\\resources\\features_Files"
								, glue =  {  "Step_Difinations" ,  "Hooks"} 
								,monochrome = true								                                                                               // Make console Output is more readable,( no more gibberish Format )
								, plugin = { "pretty" , "html:target/CucumberReport/CucumberReport.html  "}                                                                            // pretty is plugin, which gives different color Console OutPut, very easy to understood and Read
	                                                                                                                                                       // html is plugin, which generate report in HTML format, at location as defined  in target_Folder
	                            )

public class My_Runner_01
		{
					
			
			
			
			
		}

