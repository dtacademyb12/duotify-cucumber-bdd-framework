@DB
Feature: Data mapping and business rules scenarios


  @data-mapping
  Scenario: Verify data mapping of playlist for a specific user

    When the user enters a valid email and password
    And the user clicks on the login button
    Then the user should be directed to their personal dashboard
    And the user clicks on the "Your Music" link in the sidebar
    And the user creates a new playlist with random name
    Then the data should be mapped correctly in the corresponding table