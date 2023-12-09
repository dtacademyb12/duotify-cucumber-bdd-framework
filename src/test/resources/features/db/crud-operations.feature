@DB
Feature: Testing CRUD Operations

  @db_crud
  Scenario: Verify User Creation UI to DB flow - CREATE

    Given The user clicks on the sign up link
    When The user fills up the fields with valid info
    Then The user should be able to sign up successfully
    Then The user should be stored in the database correctly and the user details should be correct

  @db_read @db_only
  Scenario: Retrieving User Account Information UI to DB flow - READ
    When a request is made to retrieve details of a particular user with a username "roselle.schimmel"
    Then the correct user details should be
      | ID         | 1709873362                       |
      | USERNAME   | roselle.schimmel                 |
      | firstName  | Rubin                            |
      | lastName   | Larson                           |
      | email      | Kim.volkman@hotmail.com          |
      | profilePic | assets/images/profile-pics/head_ |

  @db_update
  Scenario: Updating User Profile Information UI to DB flow - UPDATE
    When the user enters a valid email and password
    And the user clicks on the login button
    And the user clicks on the "Duotech Academy" link in the sidebar
    And the user clicks on the "USER DETAILS" link in the user details page
    And the user updates the email field
    Then the corresponding email column in the 'users' table should be updated


  @db_delete
  Scenario: Deleting User DB to UI flow - DELETE
    Given The user clicks on the sign up link
    And The user fills up the fields with valid info
    And The user should be able to sign up successfully
    When the user with the same username is deleted from the database
    Then the database should not contain a user with the same username
    And the user should not be able to login with the same credentials on the UI


  @db_create
  Scenario: Verify User Creation DB to UI flow - CREATE

    Given The a new user with random credentials is created in the DB
    When The user logs in with the same credentials
    Then the user should be directed to their personal dashboard
    And the user is cleaned up from the database


  @db_update_db_ui
  Scenario: Verify Album Update DB to UI flow - UPDATE

    Given The album is updated in the database
    When the user enters a valid email and password
    And the user clicks on the login button
    Then the user should be directed to their personal dashboard
    Then the updated album name should be correctly reflected on the homepage

