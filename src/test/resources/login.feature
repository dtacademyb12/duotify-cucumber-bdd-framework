Feature: Login functionality


  Scenario: Positive login
    Given I am on the homepage of the app
    When I provide valid username and password
    Then I should be able to login successfully