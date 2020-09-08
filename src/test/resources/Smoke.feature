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