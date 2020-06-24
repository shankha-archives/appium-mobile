Feature : Login Scenarios

  @login
  Scenario : Login with Valid credentials
    Given User is on Home Page
    When User enter the UserID<username>
    And User enter the Password<password>
    And Click on login button
    Then User navigate to next screen

  @login
  Scenario : Login with invalid userName
    Given User is on Home Page
    When User enter the invalid UserID<username>
    And User enter the Password<password>
    And Click on login button
    Then User will get the error messgae<loginerror>


