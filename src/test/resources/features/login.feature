@REGRESSION
Feature: User Login for Music Streaming App

  As a music app user,
  I want to be able to securely log in to my account,
  So that I can access my personalized music playlists, preferences, and subscription details.

  @redirect
  Scenario: Successful login with email and password
    When the user enters a valid email and password
    And the user clicks on the login button
    Then the user should be directed to their personal dashboard

  @SMOKE
  Scenario: Unsuccessful login with incorrect credentials
    When the user enters a valid email and password
    And the user clicks on the login button
    Then the user should see an error message indicating incorrect login details

  @SMOKE
  @redirect
  Scenario: Redirect to dashboard after successful login
    When the user enters a valid email and password
    When the user clicks on the login button
    Then the user should be directed to their personal dashboard

