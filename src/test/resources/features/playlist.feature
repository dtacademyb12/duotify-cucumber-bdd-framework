Feature: Playlist Feature


  Background:
    When the user enters a valid email and password
    And the user clicks on the login button
    Then the user should be directed to their personal dashboard
    And the user clicks on the "Your Music" link in the sidebar

  @playlist
  Scenario: Verify playlist details

    When the user clicks on "Popular" playlist
    Then the playlist details should be the following
        | Name    | Username    | Count |
        | Popular | duotech2023 | 2     |

    
    