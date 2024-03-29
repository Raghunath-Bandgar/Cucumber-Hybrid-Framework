@all
Feature: User Registration

# Below statement the demostrate the use of Background Gharkin keyword

Background:
Given User navigate to Register account page

@register @manedatoryfields @smoke @regression
Scenario: Register with manedatory fields	
When User enter the below details into the field
|firstname       |Raghunath|
|lastname        |Bandgar|
|mobilenumber    |9673655693|
|password        |1234|
|passwordconfirm |1234|

# When User enter the first name "Raghunath" into the first name field
# And  User enter the last name "Bandgar" into the last name field
# And  User enter the email id "raghuBandgar@gmail.com" into the email id field
# And  User enter the mobile number 967365569 into the mobile number field
# And  User enter the password 1234 into the password field
# And  User enter the password confirm field 1234 into the password confirm field

And select privacy policy 
And click on continue button
Then Account should get successfully created

@register @allfields @smoke @regression
Scenario: Register with All fields	
When User enter the below details into the field
|firstname       |Raghunath|
|lastname        |Bandgar|
|mobilenumber    |9673655692|
|password        |1234|
|passwordconfirm |1234|

And Select Yes for Newslatter	
And select privacy policy 
And click on continue button
Then Account should get successfully created

@register @withoutanyfields @regression
Scenario: Register without providing any fields	
Given  User navigate to Register account page
When User dont enters details into the any fields
And click on continue button
Then warning messages should be displayed under all mandatory fields

@register @duplicateemail @regression
Scenario: Register with duplicate email address	
When User enter the below details into the field with duplicate Email address
|firstname       |Raghunath|
|lastname        |Bandgar|
|emailid         |raghunathBandgar2002@gmail.com|
|mobilenumber    |9673655693|
|password        |1234|
|passwordconfirm |1234|

And Select Yes for Newslatter	
And select privacy policy 
And click on continue button
Then warning message informing to the user about duplicate email address
