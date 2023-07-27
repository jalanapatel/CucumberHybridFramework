Feature: Search Functonality

Scenario: User searches with the valid Product
	Given  User open application to navigate at Home Page
	When User enters valid product "HP" into search box field
	And User clicks on search button 
	Then user should get valid product displayed in search results
	
	
	Scenario: User searches for Invalid Product
	Given  User open application to navigate at Home Page
	When User enter Invalid product "Honda" into search box field
	And User clicks on search button 
	Then User should get a message about no product matching
	
	Scenario: User searches without any Product
	Given  User open application to navigate at Home Page
	When User do not enter any product name into Search box field
	And User clicks on search button 
	Then User should get a message about no product matching
	