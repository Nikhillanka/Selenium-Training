Feature: Application login

Scenario: Home page default login

Given User is on landing page
When User login into application with username and password
Then Home page is populated
And cards displayed


Scenario: Home page default login

Given User is on landing page
When User login into application with Wrong username and password
Then Home page is not populated
And cards displayed