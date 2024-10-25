Feature: Login functionality for SauceDemo

  Scenario: UC-1 Test Login form with empty credentials
    Given I am on the login page
    When I enter "some_username" as username and "some_password" as password
    And I clear the username and password fields
    And I click the login button
    Then I should see an error message "Epic sadface: Username is required"

  Scenario: UC-2 Test Login form with only username
    Given I am on the login page
    When I enter "some_username" as username and "some_password" as password
    And I clear the password field
    And I click the login button
    Then I should see an error message "Epic sadface: Password is required"

  Scenario: UC-3 Test Login form with valid credentials
    Given I am on the login page
    When I enter "standard_user" as username and "secret_sauce" as password
    And I click the login button
    Then I should be redirected to the dashboard with the title containing "Swag Labs"
