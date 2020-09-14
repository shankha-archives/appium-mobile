@smoke
Feature: Smoke scenarios

@MOB-4227 @smoke @Android
Scenario: Need to restrict login once the application is killed and relaunched
	When the substitute user launches the app
    Then the substitute user passes the splash screen
    When the substitute user enters the PIN code 7354
    Then the substitute user is taken to the Login Page
    And Enter username and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And The user kill and relaunch the application
    Then the substitute navigates to dashboard page

@MOB-4229 @smoke @Android
Scenario: Need to restrict login if application is running in background and then opened
	When the substitute user launches the app
    Then the substitute user passes the splash screen
    When the substitute user enters the PIN code 7354
    Then the substitute user is taken to the Login Page
    And Enter username and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And The user minimize and relaunch the application
    Then the substitute navigates to dashboard page
        
 @smoke @MOB-4271 @ios @Android 
  Scenario Outline: Pull to refresh
    When the substitute user launches the app
    Then the substitute user passes the splash screen
    When the substitute user enters the PIN code 7354
    Then the substitute user is taken to the Login Page
    And the substitute enter valid username"<userName>"
    And the substitute enter valid password"<userPassword>"
    When Click on Sign In with Frontline ID button
    Then the substitute navigates to dashboard page
    And pulls to refresh the page
    Examples:
      | userName   | userPassword   |
      | StageSubAhmed | FLultra1! |