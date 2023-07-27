package Experiments;

import java.util.Date;

public class Date_Email {

	public static void main(String[] args) 
	{

		
			Date date = new Date();
			
			System.out.println(date);               // Fri Jul 21 09:47:27 EDT 2023
			
			System.out.println(date.toString().replace(" ", "_"));     //  Fri_Jul_21_09:48:54_EDT_2023
			
			System.out.println(date.toString().replace(" ", "_").replace(":", "_"));      //  Fri_Jul_21_09_50_11_EDT_2023
			
			
		String emailWithTimeStamp = 	"jammyPatel_"+ date.toString().replace(" ", "_").replace(":", "_") +"@gmail.com";
			
		System.out.println(emailWithTimeStamp);    //  jammyPatel_Fri_Jul_21_10_05_21_EDT_2023@gmail.com
			

	
	
	
	
	
	
	
	}

}
