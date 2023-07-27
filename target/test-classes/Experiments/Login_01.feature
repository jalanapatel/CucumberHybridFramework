Feature: Login functionality

 # to run feature, hold ctrl, and click ---> Take you to respective Method

Scenario: Login with Valid Credentials
	Given User has navigates to Login Page                                                                                                      
	When  User has enters  Valid Email Address "jalanapatel0301@gmail.com" into the email Field
	And User  has enters Valid password "123456789" into the password Field
	And User has Click on Login button
	Then User should get successfully Logged in


Scenario: Login with invalid credentials
	Given User has navigates to Login Page
	When User has enters Invalid Email Address "jalanapatel12567@gmail.com" into the email Field
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
	When User has enters Invalid Email Address "jalanapatel6567@gmail.com" into the email Field
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
