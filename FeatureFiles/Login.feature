Feature: Login Scenarios

Scenario: Login functionality validation

When I loggin into primusbank url on Chrome

When I select branch dropdown 

And I enter uid in usernameField

And I enter pwd in passwordField

When I click on loginButton

When I wait for LogoutButton

Then I validate the title of the Home page

Then I close the browser