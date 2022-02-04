Feature:LoginFeature
  This feature tests the Login functionality.

  Scenario: Check login with username and password
    Given I have navigated to the application
    When I enter emailid and click on Next button
    |emailid|
    |bharati.shastri@gmail.com|
    Then Check that the Page Title is what you expect and close the App
    


