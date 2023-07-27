Feature: Login functionality

 #   to run feature, hold ctrl, and click ---> Take you to respective Method
 #   dynamically enter email address, every time new email address using method of 'emailaddresswithtimestamp'
 #   Remove data hardcoding, using Page Object Model and Page Factory    --  Removind hardcoding of Locators.
 #   Config Data into Separate Property File
 #   In Cucmber -- Reading Data from Exce file is not required, like External file with data is  not requiered, Generally data passed from Feature_File, 
 #   Data drivern Framework,   --> Integrating Data Driven Scenario  ----> means scenario is written once, but executed multiple times, depen on no of data set passing into scenario. (Excel file not required at all)
 #   from Features_Files pass multiple dataset to Scenario 
 #   Use " Scenario Outline " keyword to convert data driven scenario,  and  " Examples: " and provide Datasets as show below for first Scenario: Login with Valid Credentials.
 #  and  make changed in data with  ' < > '  like <username>   < password > 
 #  here provide 3 dataset of username and password, so same scenario run three times.
 
 
Scenario Outline: Login with Valid Credentials
	Given User has navigates to Login Page                                                                                                      
	When  User has enters  Valid Email Address <username> into the email Field of data
	And User  has enters Valid password <password> into the password Field of data
	And User has Click on Login button
	Then User should get successfully Logged in
Examples:
	|username|password|
  |jalanapatel5678@gmail.com|1234|
  |jalanapatel1234@gmail.com|1234|
  |jalanapatel0301@gmail.com|12345|
  
  
Scenario: Login with invalid credentials
	Given User has navigates to Login Page
	When User has enters Invalid Email Address into the email Field
	And User has enters Invalid Password "56234789" into the password Field
	And User has Click on Login button
	Then User should get Warning Message about Credentials mismatch


Scenario: Login with Valid Email and Invalid Password
	Given User has navigates to Login Page
	When  User has enters  Valid Email Address "jalanapatel0301@gmail.com" into the email Field
	And User has enters Invalid Password "568974230" into the password Field
	And User has Click on Login button
	Then User should get Warning Message about Credentials mismatch

Scenario: Login with Invalid Email and valid Password
	Given User has navigates to Login Page
	When User has enters Invalid Email Address into the email Field
	And User  has enters Valid password "123456789" into the password Field
	And User has Click on Login button
Then User should get Warning Message about Credentials mismatch

Scenario: Login WithOut provid and credentials
Given User has navigates to Login Page
When User do not enter Email Address into Email Field
And User do not enter Password into Password Field
And User has Click on Login button
Then User should get Warning Message about Credentials mismatch


# "Warning: No match for E-Mail Address and/or Password."
