@All
Feature: To validate home page of amazon with invalid creditionals
@smoke
Scenario: to validate search box with valid and invalid creditionals

Given the user should be in home page
When the user has to fill the  invalid details in the search box 
|$$$$$$$$$$|@@@@@@@@|
And click the search button
Then the user should navigate to the invalid page 

@sanity
Scenario: to validate signIn feature with invalid creditionals

Given the user should be in home page
When the user click the sign in button 
Then the signin page displayed
When the user fill the invalid creditionals 
|12345|54321|
And click signIn button 
Then the error message will displayed