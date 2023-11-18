@signUp @REGRESSION
Feature: Sign Up a new user



  Background: Common steps for all scenarios
    Given The user clicks on the sign up link






  @US-123
  @SMOKE
  Scenario: Sign up with valid information
    When The user fills up the fields with valid info
    Then The user should be able to sign up successfully

  @SMOKE
  @temp
  Scenario: User enters invalid email address
    When the user enters an invalid email address
    Then the user should see an error message for email



#  Scenario: User enters a weak password
#    Given The user clicks on the sign up link
#    When the user enters a weak password
#    And clicks on the sign-up button
#    Then the user should see an error message for password
#    And the sign-up process should not proceed
#
#
#  Scenario: User password and confirm password do not match
#    Given The user clicks on the sign up link
#    When the user enters a password and enters a different password in the confirm password field
#    And clicks on the sign-up button
#    Then the user should see an error message for confirm password
#    And the sign-up process should not proceed
#
#  Scenario: User already has an account
#    Given The user clicks on the sign up link
#    When the user enters an email address that is already associated with an account
#    And clicks on the sign-up button
#    Then the user should see an error message for an already used email
#    And the sign-up process should not proceed