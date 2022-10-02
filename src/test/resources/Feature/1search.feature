@All
Feature: to validate home page of amazon

Background: 
Given the user should be in home page
@smoke
Scenario: to validate search box with valid creditionals
When the user has to fill the valid details in the search box 
|product|
|ironbox|
|headphone|
|ledtv|
And click the search button
Then the user should navigate to the product page
@regression
Scenario: to validate the prefered language section
When  the user will click language option 
And the user select the prefered language in language section
When the user click the save changes option
Then the language for shopping and communication should be changed