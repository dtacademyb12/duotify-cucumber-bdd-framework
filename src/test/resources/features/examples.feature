Feature: Example scenarios fro demo purposes


 Scenario:  Cucumber parameter example
   Given  I have 100 cucumbers in my belly
   When I add 100.5 more
   Then I should have 200.5 cucumbers
   And I should have also have some squashes

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
