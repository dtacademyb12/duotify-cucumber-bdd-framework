Feature: Sign Up a new user


  @temp
  Scenario: Sign up with valid information
    Given I click on the sign up link
    When I fill up the fields with valid info
    Then I should be able to sign up successfully