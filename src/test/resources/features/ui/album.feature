Feature: Album features


  Background:
    When the user enters a valid email and password
    And the user clicks on the login button
    Then the user should be directed to their personal dashboard

 @smoke
  Scenario: Verify single album details
    When the user clicks on the album "Ultimatum"
    Then the album name should be "Ultimatum"
    And the album artist should be "Disclosure"
    And the album song count should be 1

  @album
  Scenario Outline: Verify multiple album details
    When the user clicks on the album "<album>"
    Then the album name should be "<album>"
    And the album artist should be "<artist>"
    And the album song count should be <songCount>

    Examples:
      | album                | artist           | songCount |
      | Ultimatum            | Disclosure       | 1         |
      | Oscillation          | Four Tet         | 1         |
      | Escape               | Enrique Iglesias | 5         |
      | Fenix                | Nicky Jam        | 1         |
      | Cruel Summer         | Ace Of Base      | 1         |
      | I Am...Sasha  Fierce | Beyonce          | 1         |
      | Clouds               | Miguel Migs      | 1         |
      | Werk                 | Maya Jane Coles  | 1         |

