Feature: Demo RestAssured code

  @api_demo
  Scenario: Demo API Test

    Given a path parameter "username" is set to "dtacademyb11"
    And a header "Accept" is set to "*/*"
    And a header "Content-Type" is set to "application/json"
    When I send a GET request to "/users/{username}" endpoint
    Then the status code should be 201
    And the response time should be less than 2000 ms
