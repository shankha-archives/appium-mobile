@login
Feature: Login scenarios

@MOB-3204 @AndroidRegression @Done
  Scenario: Verify users is able to view splash screen only on fresh application install
    When the user launches the app
    And the user click on Get Started Button
    Then the substitute user is taken to the Login Page
    When The user kill and relaunch the application
    Then the substitute user is taken to the Login Page

@MOB-3206 @MOB-3145 @AndroidRegression @Done
  Scenario: Verify substitute user couldnt login with invalid credentials
    When the user launches the app
    Then the user click on Get Started Button
    Then the substitute user is taken to the Login Page
    And the substitute enter "invalid" "invalidlogin" username
    And the substitute enter "invalid" "invalidpass" password
    When Click on Sign In with Frontline ID button
    Then Incorrect username and password error message displays
    
@MOB-3206 @MOB-3145 @AndroidRegression @Done
  Scenario: Verify substitute user couldnt login without credentials
    When the user launches the app
    Then the user click on Get Started Button
    Then the substitute user is taken to the Login Page
    When Click on Sign In with Frontline ID button
    Then Error message displays to the substitute users
    
@MOB-3206 @MOB-3145 @AndroidRegression @Done
  Scenario: Verify substitute user can successfully login with valid credentials
    When the user launches the app
    Then the user click on Get Started Button
    Then the substitute user is taken to the Login Page
    And the substitute enter "valid" "AutomationSubsMOB-4269" username
    And the substitute enter "valid" "FrontlinePassword" password
    When Click on Sign In with Frontline ID button
    Then the substitute navigates to dashboard page

@MOB-3601 @AndroidRegression @Done
  Scenario: Verify when a user is associated with multiple roles and single organization it should display role picker
    When the user launches the app
    Then the user click on Get Started Button
    And Enter username "AutomationSubMutiRole" and password and click on Sign In button
    Then the user is presented with the role picker
 
@MOB-3601  @AndroidRegression @Done
  Scenario: Verify when a user is associated with multiple roles and multiple organization it should display org picker
    When the user launches the app
    Then the user click on Get Started Button
    And Enter username "AutomationSubMutiOrg" and password and click on Sign In button
    Then the user is presented with the org picker

  @MOB-3682
  Scenario: Verify that substitute user has no access to districts
   When the user launches the app 
	 Then the user click on Get Started Button
   And Enter username "noOrgUsername" and password and click on Sign In button
   Then the system presents a dialog
