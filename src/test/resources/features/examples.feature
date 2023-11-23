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