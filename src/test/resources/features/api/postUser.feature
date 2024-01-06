
@API
Feature: POST /user API endpoint features


#  @api_only
  Scenario: Create a new user using String as payload

    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    And the request body is set to the following payload
      """
      {
        "username": "coolherc364826321",
        "firstName": "Cool",
        "lastName": "Herc",
        "email": "coolherc364826321@mail.com",
        "password": "coolherc"
      }
      """

    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 201
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 2000 ms

#    Cleanup the user
    And the request "id" query parameter is set to the id extracted from POST request
    When I send a "DELETE" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response body should have "message" field with value "User deleted successfully"