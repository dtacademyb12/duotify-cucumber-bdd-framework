Feature: Example scenarios fro demo purposes

 @test
 Scenario:  Cucumber parameter example
   Given  I have 100 cucumbers in my belly
   And I have a cucumber of type "mexican"
   And I also have 3000000000 tomatoes
   When I add 100.5 more
   Then I should have 200.5 cucumbers
   And I should have also have some squashes
   And I should have also have some cherries
   And I should have also have some berries
   And I ate some bananas
   And I ate some apples
#   And I have another step
   And I want to buy "socks"
   And I want to buy hats


  @example
   Scenario Outline: example scenario outline
     Given I click on a link "<linkName>"
     When I check for the the "<URL>" in a step
     Then I verify the "<status>" in a step

    Examples:
      | linkName   | URL                   | status |
      | Your music | www.myUrl.com         | fail   |
      | Browse     | www.myUrlBrowse.com   | pass   |
      | Search     | www.myUrlsearch.com   | skip   |
      | User Info  | www.myUrluserInfo.com | fail   |


    @multilineString  @docString
  Scenario:  Database test 1

#    Given I have a connection to db
    When I send the following query to db
    """
    UPDATE User
    SET UserId = 12345
    , Name = 'J Doe'
    , Location = 'USA'
    , Bio='my bio
    spans
    multiple
    lines!'
    WHERE UserId = 12345
    """
#    Then I should have the correct info

#  @datatable
  Scenario: Datatable example as map

    Given I have the following data as map
      | 123-08-5678 | John Smith   |
      | 123-03-4232 | John Carty   |
      | 234-23-3422 | James Carter |
      | 323-08-2323 | Jack Daniels |
    When I do something
    Then something should happen

#  @datatable
  Scenario: Datatable example as wrong list

    Given I have the following data as list
#    the following does not correspond to a List
      | John Smith | John Carty | James Carter | Jack Daniels |
    When I do something
    Then something should happen

  @listOfLists
  Scenario: Datatable example as list of lists

    Given I have the following data as list of lists
      | John Smith  | 09-08-1995 | 123-09-3456 | 123 Main St    |
      | Alice Smith | 11-08-1985 | 234-34-2326 | 234 Fairfax St |
      | Jane Doe    | 12-03-1954 | 123-45-1234 | 567 Lisbon St  |
    When I do something
    Then something should happen

  @listOfLists
  Scenario: Datatable example as list of lists

    Given I have the following data as about a person
      | John Smith  | 09-08-1995 | 123-09-3456 | 123 Main St    |
    When I do something
    Then something should happen



  Scenario: Datatable example as list of maps

    Given I have the following data as list of maps
      | Name        | DOB        | SSN         | Address        |
      | John Smith  | 09-08-1995 | 123-09-3456 | 123 Main St    |
      | Alice Smith | 11-08-1985 | 234-34-2326 | 234 Fairfax St |
      | Jane Doe    | 12-03-1954 | 123-45-1234 | 567 Lisbon St  |
    When I do something
    Then something should happen

    @listOfMaps
  Scenario: Datatable example as list of maps

    Given I have the following data for a single user
      | Name        | DOB        | SSN         | Address        |
      | John Smith  | 09-08-1995 | 123-09-3456 | 123 Main St    |
    When I do something
    Then something should happen

  @datatable
  Scenario: Datatable example as map

    Given I have the following data as map dsdssd
      | 123-08-5678 | John Smith   | 123 Main st    | 23 |
      | 123-03-4232 | John Carty   | 322 Fairfax st | 67 |
      | 234-23-3422 | James Carter | 422 Lisbon st  | 55 |
      | 323-08-2323 | Jack Daniels | 212 Vista st   | 45 |
    When I do something
    Then something should happen


    @shareData
    Scenario: Sharing data between steps

      Given The user has 50 cucumbers
      When The user adds 50 more cucumbers
      Then The user should have 100 cucumbers