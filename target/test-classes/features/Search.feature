@all
Feature:Search functionality

Background:
Given user opens the application

@search @validproduct @smoke @regression
Scenario: Search for the valid product
When user enter valid product "HP" into the search field
And user click on search button
Then valid product should get displayed in search result

@search @nonexistingproduct @regression
Scenario: Search for the non existing product
When user enter non existing product "Honda" into the search field 
And user click on search button
Then proper text formating the user about no product matching should be displayed

@search @noproduct @regression
Scenario: Search without providing any product
When user dont enter product into the search field
And user click on search button
Then proper text formating the user about no product matching should be displayed