@all
Feature: login functionality
Users should be able to access his/her account using login functionality

Background:
Given user has opened the application URL
And navigated to login page

@login @validcredentials @smoke @regression
Scenario Outline: login with valid credentials
When user enters valid email <email> address
And user enters valid <password> password
And click on login button
Then user should be able to successfully login
Examples:
|email                          |password   |
|Rishaan@gmail.com              |1234       |
|Ritvika@gmail.com              |5678       |


@login @invalidcredentials @smoke @regression
Scenario: login with Invalid credentials
When user enters Invalid email address
And user enters Invalid "12345" password
And click on login button
Then user should get proper warning message

@login @validusernameandinvalispassword @regression	
Scenario: login with valid username and invalid password
When user enters valid email "Rishaan@gmail.com" address
And user enters Invalid "12345" password
And click on login button
Then user should get proper warning message

@login @invalidusernameandvalidpassword @regression
Scenario: login with Invalid username and valid password
When user enters Invalid email address
And user enters valid "12345" password
And click on login button
Then user should get proper warning message

@login @nocredentials @regression
Scenario: login without providing any creditials
When user don’t enters any email address
And user don’t enters any  password
And click on login button
Then user should get proper warning message



