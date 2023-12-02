Feature: Playlist Feature


  Background:
    When the user enters a valid email and password
    And the user clicks on the login button
    Then the user should be directed to their personal dashboard
    And the user clicks on the "Your Music" link in the sidebar

  @smoke
  Scenario: Verify single playlist details
    When the user clicks on "Popular" playlist
    Then the playlist details should be the following
        | Name    | Username    | Count |
        | Popular | duotech2023 | 2     |


  @playlist
  Scenario Outline: Verify multiple playlist details
    When the user clicks on "<playlistName>" playlist
#       """
#         name: <username>
#         age: <songCount>
#       """
    Then the playlist details should be the following
      | Name           | Username   | Count       |
      | <playlistName> | <username> | <songCount> |

    Examples:
      | playlistName | username    | songCount |
      | Popular      | duotech2023 | 2         |
      | Workout      | duotech2023 | 1         |
      | Intense      | duotech2023 | 0         |
      | House        | duotech2023 | 26        |