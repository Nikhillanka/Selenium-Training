Feature: FlipKart Application login

Scenario: FlipKart Home page default login

Given User is on FlipKart Login page
When User login into Flipkart application with username and password
Then FlipKart Home page is populated
And Browser Close

Scenario: FlipKart logout

Given User is on FlipKart Login page
When User login into Flipkart application with username and password
Then FlipKart Home page is populated
And Flipkart Account is logged out
And Browser Close
