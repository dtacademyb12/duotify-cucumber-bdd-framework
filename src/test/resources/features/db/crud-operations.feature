@DB
Feature: Testing CRUD Operations

  @db_crud
  Scenario: Verify User Creation - CREATE

    Given The user clicks on the sign up link
    When The user fills up the fields with valid info
    Then The user should be able to sign up successfully
    Then The user should be stored in the database correctly and the user details should be correct
