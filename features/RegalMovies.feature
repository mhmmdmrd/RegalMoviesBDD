Feature: Regal Movies Promos Validation and Login with Fails

@promo
Scenario: Log in With Bad Credentials
Given User in homepage 
When user verify homepage logo
And User clicks user icon
Then User will be in log in page
And user will input bad "wick@420" in email
And user will input bad 123 in password
And user will click on log in
And user will verify error text is "Bad user name or password."

@dataDriven
Scenario Outline: Log in With Bad Credentials
Given User in homepage 
When user verify homepage logo
And User clicks user icon
Then User will be in <Log In> page
And user will input bad <email> in email
And user will input bad <password> in password
And user will click on log in
And user will verify error text is <error msg>
Examples: 
|Log In	              |email         |password |error msg                             |
|"Regal - Log In" |"wick@420" |123        |"Bad user name or password." |
|"Regal - Log In" |"john@420" |456        |"Bad user name or password." |
|"Regal - Log In" |"rahat@420" |789        |"Bad user name or password." |


