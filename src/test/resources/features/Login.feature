Feature : Login Scenarios

  @login @android
  Scenario : Login with Valid credentials
    Given User is on Home Page
    When User enter the UserID
    And User enter the Password
    And Click on login button
    Then User navigate to next screen

  @login @ios @android
  Scenario : Login with invalid userName
    Given User is on Home Page
    When User enter the invalid UserID
    And User enter the invalid Password
    And Click on login button
    Then User will get the error message