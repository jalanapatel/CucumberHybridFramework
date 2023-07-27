package Utility;

import java.util.Date;

/*
        Utility_Class is created, for common Utility.
        
        like Create Email Address with Time Stamp
     
 */



public class Common_Utility_Class 
{
	//    public static String  getEmailAddressWithTimeStamp()                            -----> FYI  --> avoid static as much as possible, instead of create Object of class
	
	public  String  getEmailAddressWithTimeStamp()
	
	{
		Date date = new Date();
        
																					// 	System.out.println(date);                                                                // 	Fri Jul 21 17:29:47 EDT 2023
		
		String email_TimeStamp = "jammyPatel_" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
		
																						// System.out.println(email_TimeStamp);                                         //  	jammyPatel_Fri_Jul_21_17_29_47_EDT_2023@gmail.com
		
		return email_TimeStamp;
		
	}
	        
	


	
}
