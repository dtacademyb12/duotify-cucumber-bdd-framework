@API
Feature:


  @api_only
  @playlists
  Scenario: Get playlists for a specific user

#    obtain JWT token through POST /login endpoint
    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    And the request body is set to the following payload as map
      | username  | duotech2023 |
      | password | duotech      |
    When I send a "POST" request to the endpoint "/login"
    Then the response log should be displayed
    Then the response status code should be 200
    And JWT token is extracted from the response

#   send a request to GET /playlists endpoint
    Given the request specifications are reset
    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    And the JWT token is set in the header
    When I send a "GET" request to the endpoint "/playlists"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json; charset=UTF-8"
    And the response time should be less than 2000 ms
    And the response body should contain the following fields
      | id          |
      | name        |
      | owner       |
      | dateCreated |
    And the response body should contain a playlist with an id 2411