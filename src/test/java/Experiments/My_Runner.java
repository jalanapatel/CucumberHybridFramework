package Experiments;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions( features = "src\\test\\resources\\features_Files"
													, glue =  {  "Hooks", "Step_Difinations"} 
								)

public class My_Runner
		{
					
			
			
			
			
		}

