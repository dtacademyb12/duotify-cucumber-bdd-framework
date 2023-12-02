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

  @smoke
  Scenario: Unsuccessful login with incorrect credentials
    When the user enters a valid email and password
    And the user clicks on the login button
    Then the user should see an error message indicating incorrect login details

  @smoke
  @redirect
  Scenario: Redirect to dashboard after successful login
    When the user enters a valid email and password
    When the user clicks on the login button
    Then the user should be directed to their personal dashboard


  @login
  Scenario: Successful login with valid username and password
    When the user enters a valid username as "duotech2023" and password as "duotech"
    And the user clicks on the login button
    Then the user should be directed to their personal dashboard

#  @login
#  Scenario: Successful login with valid username and password
#    When the user enters a valid username as "duotech2020" and password as "duotech2020"
#    And the user clicks on the login button
#    Then the user should be directed to their personal dashboard

  @sc_outline
  Scenario Outline: Successful login with valid username and password
    When the user enters a valid username as "<username>" and password as "<password>"
    And the user clicks on the login button
    Then the user should be directed to their personal dashboard

    Examples:
      | username       | password    |
      | duotech2023    | duotech     |
      | duotech2020    | duotech2020 |
      | johnnycash2023 | johnnycash  |
      | stevejobs2023  | stevejobs   |









