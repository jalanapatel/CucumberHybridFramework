Feature: Registeration Functionality

Scenario: User creates an account with only Mandatory Fields
	Given User has navigates to Register Account Page
	When User enters the details into below Fields
	
	|  FirstName | Jammy 							  										 |
	|  LastName  | Patel 																				 |
	|  Email 	 			 | jalanapatel127458@gmail.com	 |
	|  Telephone |  2356147895 													 |
	|  Password  | 235641  																		 |
	
	And User selects Privact Policy box
	And Clicks on Continue button
	Then User account should get created Successfully
	



Scenario: User creates an account with All Fields
	Given User has navigates to Register Account Page
	When User enters the details into below Fields
	
	|  FirstName | Jammy 																		 |
	|  LastName  | Patel 																				 |
	|  Email 				 | jalanapatel123@gmail.com	 |
	|  Telephone |  2356147895 													 |
	|  Password  | 235641  																		 |
	
	
	And User selects  Yes  Newsletter subscribe
	And User selects Privact Policy box
	And Clicks on Continue button
	Then User account should get created Successfully
	
	
	
	
Scenario: User creates duplicate account
	Given User has navigates to Register Account Page
	When User enters the details into below Fields
	
				|  FirstName  |   Jammy  |
				|  LastName   |  Patel      |
				|  Email       |  jalanapatel0301@gmail.com |
				|  Telephone | 2154506985  |
				|		Password  | 562314 |
	
	And User selects  Yes  Newsletter subscribe
	And User selects Privact Policy box
	And Clicks on Continue button
	Then User should get proper Waring Message about duplicate Account "Warning: Eamil Address already registered."
	
	
	
	
	Scenario: User Created Account WithOut filling any Details
		Given User has navigates to Register Account Page
		When User do not enter any details into fields
		And Clicks on Continue button
		Then User should get proper Warning Messages for every Mandatory fields
	
	
	
	
	
	
	
	
	
	
	
	