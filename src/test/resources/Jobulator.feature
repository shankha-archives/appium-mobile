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

  @regression @MOB-3681
  Scenario Outline: Login with valid credentials
    When the substitute user launches the app
    Then the substitute user click on Get Started Button and enter the pin
    And Enter username"<userName>" and password"<userPassword>" and click on Sign In button
    Then the user choose the sub user of one org and extract the jobs
    When the user choose the sub user of another org and extract the jobs
    Then verify the jobs
    Examples:
      | userName   | userPassword   |
      | multimulti  | FLultra1! |
      
    @regression @MOB-3683
  Scenario Outline: Feature flags access- Multi District User
    When the substitute user launches the app
    Then the substitute user click on Get Started Button and enter the pin
    And Enter username"<userName>" and password"<userPassword>" and click on Sign In button
    Then the substitute navigates to dashboard page
    And the dashboard displays all available jobs from all districts
    Examples:
      | userName   | userPassword   |
      | stageSubShivani | FLultra1! |
  