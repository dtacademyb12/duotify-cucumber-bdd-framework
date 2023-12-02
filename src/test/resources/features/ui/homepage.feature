@homepage
Feature: Music Streaming App Homepage

  As a music lover, I want to be able to access and explore music easily through a music streaming app. The homepage of the app should display 9 albums on the main page and have a left sidebar with links to Search, Browse, Your Music, and Edit User profile options.

  Background:
    When the user enters a valid email and password
    And the user clicks on the login button
    Then the user should be directed to their personal dashboard



  Scenario: User opens the app and sees certain number of recommended albums on the homepage
    Then the user should see 9 recommended albums displayed on the main page



  Scenario: User clicks on the Your Music link in the sidebar
    When the user clicks on the "Your Music" link in the sidebar
    Then the user should be able to access their personal music library, where they can view, create, edit and delete playlists.
  @smoke
  Scenario: User clicks on the Username link in the sidebar
    When the user clicks on the "Duotech Academy" link in the sidebar
    Then the user should be able to view and edit their user profile information, such as their name, email address, password and should be able to log out.

#
  Scenario: User clicks on the Browse link in the sidebar
    When the user clicks on the "Browse" link in the sidebar
    Then the user should be able to view recommended albums
#
#
  Scenario: User clicks on the Search link in the sidebar
    When the user clicks on the "Search" link in the sidebar
    Then the user should be able to search for an artist, album or tracks

  @ex
  Scenario Outline: User clicks on the Search link in the sidebar
    When the user clicks on the "<link>" link in the sidebar
    Then the expected url should be  "<url>"


    Examples:
      | link            | url                                                          |
      | Your Music      | http://duotify.us-east-2.elasticbeanstalk.com/yourMusic.php? |
      | Browse          | http://duotify.us-east-2.elasticbeanstalk.com/browse.php?    |
      | Duotech Academy | http://duotify.us-east-2.elasticbeanstalk.com/settings.php?  |
      | Search          | http://duotify.us-east-2.elasticbeanstalk.com/search.php?    |




    @albumNames
    Scenario: Verify all album names
#      Then the recommended album names should be "Cruel Summer" "Clouds" "Marisa"
#      Datatable is a way to pass complex data structure(List, Map) into a single step
      Then the recommended album names should be
        | Cruel summer        |
        | Clouds              |
        | Marisa              |
        | Oscillation         |
        | Ultimatum           |
        | Fenix               |
        | Escape              |
        | Werk                |
        | I Am...Sasha Fierce |
