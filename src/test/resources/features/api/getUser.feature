@API
Feature: GET /user API endpoint features


  Scenario: Retrieve a single user with a valid id

    Given the request is authenticated with a valid API key
    And the request "Accept" header is set to "application/json"
    And the request "id" query parameter is set to "47"
    When I send a "GET" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 2000 ms
    And the response body should have "id" field with value "47"
    And the response body should have "username" field with value "SherlockHolmes"
    And the response body should have "firstName" field with value "Duotech"
    And the response body should have "lastName" field with value "Batch"
    And the response body should have "email" field with value "Dtacademy20@gmail.com"
    And the response body should have "createdAt" field with value "2022-09-28 00:00:00"



  Scenario: Missing API Key

    Given the request has an invalid or missing API key
    Given the request "Accept" header is set to "application/json"

    When I send a "GET" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 401
    And the response body should have "message" field with value "Invalid or missing API Key. API key must be provided as an 'api_key' query parameter."


  Scenario: Missing User ID

    Given the request is authenticated with a valid API key
    Given the request "Accept" header is set to "application/json"
    When I send a "GET" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 400
    And the response body should have "message" field with value "Bad request. User id is not provided."


  Scenario: Invalid User ID

    Given the request is authenticated with a valid API key
    Given the request "Accept" header is set to "application/json"
    And the request "id" query parameter is set to "999999"
    When I send a "GET" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 404
    And the response body should have "message" field with value "User not found."



#  Scenario Outline: Retrieve a single user data driven
#    Given the request is authenticated with a valid API key
#    And the request "Content-type" header is set to "application/json"
#    And the request "id" query parameter is set to "<id>"
#    When I send a "GET" request to the endpoint "/user"
#    Then the response log should be displayed
#    Then the response status code should be 200
#    And the response "Content-Type" header should be "application/json"
#    And the response time should be less than 1000 ms
#    And the response body should have "id" field with value "<id>"
#    And the response body should have "username" field with value "<username>"
#    And the response body should have "firstName" field with value "<firstName>"
#    And the response body should have "lastName" field with value "<lastName>"
#    And the response body should have "email" field with value "<email>"
#    And the response body should have "createdAt" field with value "<createdAt>"
#    Examples:
#      | id | username | firstName| lastName| email | createdAt|
#      | 47 | SherlockHolmes | Duotech| Batch| Dtacademy20@gmail.com | 2022-09-28 00:00:00|
#      | 56 | johnSmith | John| Smith| Robeh31450@bongcs.com | 2022-09-28 00:00:00|
#  Scenario: Retrieve a single user with invalid id, negative test with valid input
#    Given the request is authenticated with a valid API key
#    And the request "Content-type" header is set to "application/json"
#    And the request "id" query parameter is set to "1"
#    When I send a "GET" request to the endpoint "/user"
#    Then the response log should be displayed
#    Then the response status code should be 404
#    And the response "Content-Type" header should be "application/json"
#    And the response time should be less than 1000 ms
#    And the response body should have "message" field with value "User not found."
#  Scenario: Retrieve a single user with no id, negative test with invalid input, missing id
#    Given the request is authenticated with a valid API key
#    And the request "Content-type" header is set to "application/json"
#    When I send a "POST" request to the endpoint "/user"
#    Then the response log should be displayed
#    Then the response status code should be 400
#    And the response "Content-Type" header should be "application/json"
#    And the response time should be less than 1000 ms
#    And the response body should have "message" field with value "Bad request. User id is not provided."