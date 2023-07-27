package Utility;

import java.util.Date;

/*
        Utility_Class is created, for common Utility.
        
        like Create Email Address with Time Stamp
        
        
        Constants are created to avoid hardCode of value into code.
        
        Update value at one place only, makes work easy and maintain.
     
 */



public class Common_Utility_Class 
{
	
	// Create Constant 
	
	public static final int IMPLICIT_WAIT_TIME = 10 ;                      //  Create CONSTANT  and it is static (use without creating Class_Object) and final ( cannot Change )   ----> use in Driver_Facotoy_Class ==>> impliciWait( Duration.ofSeconds( IMPLICIT_WAIT_TIME ) )
	
	public static final int PAGE_LOAD_TIME = 15 ;                             //   Create CONSTANT and it is static and final  ---->>> Use in Driver_Factory_Class ==>>  use in Driver_Factory_Class ===>>> PageLoadTimeOut ( Duration.ofSeconds ( PAGE_LOAD_TIMe ) )
	
	public static final int EXPLICIT_WAIT_BASIC_TIME = 30 ;             //   Use in Page_Object_Class as  Explicit_Wait_Time in Methods and for every place for example   ==>>>  durationInSeconds = 30  ===> Common_Utility_Class.EXPLICIT_WAIT_BASIC_TIME
	
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
