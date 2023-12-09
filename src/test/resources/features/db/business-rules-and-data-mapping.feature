@DB
Feature: Data mapping and business rules scenarios


  @data-mapping @smoke
  Scenario: Verify data mapping of playlist for a specific user

    When the user enters a valid email and password
    And the user clicks on the login button
    Then the user should be directed to their personal dashboard
    And the user clicks on the "Your Music" link in the sidebar
    And the user creates a new playlist with random name
    Then the data should be mapped correctly in the corresponding table

 @smoke
  Scenario: verify column names for songs table
    When I retrieve the column names from the "songs" table
    Then it should have the following
      | id         |
      | title      |
      | artist     |
      | album      |
      | genre      |
      | duration   |
      | path       |
      | albumOrder |
      | plays      |


  @business_rule @db_only
  Scenario: verify email column for duplicates
    When I retrieve the emails from "users" table
    Then it should not contain duplicates