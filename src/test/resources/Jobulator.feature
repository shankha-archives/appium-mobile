@jobs
Feature: Jobulator scenarios

  @regression @jobs @MOB-3325
  Scenario Outline: Login with valid credentials
    When the substitute user launches the app
    Then the substitute user click on Get Started Button and enter the pin
    And Enter username"<userName>" and password"<userPassword>" and click on Sign In button
    Then the substitute navigates to dashboard page
    And click on the Available Jobs and view job list
    And Click on the job and accept it
    Then the Success Message overlay is displayed
    When I click Okay
    Then Success Message is dismissed revealing accepted job details page
    Examples:
      | userName   | userPassword   |
      | Tietjens@district.com | Tietjens23 |
      
  @regression @jobs @MOB-3324
  Scenario Outline: Success Confirmation Number
    When the substitute user launches the app
    Then the substitute user click on Get Started Button and enter the pin
    And Enter username"<userName>" and password"<userPassword>" and click on Sign In button
    Then the substitute navigates to dashboard page
    And click on the Available Jobs and view job list
    And Click on the job and accept it
    Then the Success Message overlay is displayed
    When I click Okay
    Then Success Message is dismissed revealing accepted job details page
    Then Verify the confirmation number present on the job details page
    Examples:
      | userName   | userPassword   |
      | Addams@district.com | Addams23 |