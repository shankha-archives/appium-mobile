@login
Feature: Login scenarios

@MOB-3204 @AndroidRegression @iOSRegression
  Scenario: Verify users is able to view splash screen only on fresh application install
    When the user launches the app
    And The user click on Get Started Button
    Then the user is taken to the Login Page
    When The user kill and relaunch the application
    Then the user is taken to the Login Page

@MOB-3206 @MOB-3145 @AndroidRegression @iOSRegression
  Scenario: Verify substitute user couldnt login with invalid credentials
    When the user launches the app
    Then The user click on Get Started Button
    Then the user is taken to the Login Page
    And the substitute enter "invalid" "invalidlogin" username
    And the substitute enter "invalid" "invalidpass" password
    When Click on Sign In with Frontline ID button
    Then Incorrect username and password error message displays
    
@MOB-3206 @MOB-3145 @AndroidRegression @iOSRegression
  Scenario: Verify substitute user couldnt login without credentials
    When the user launches the app
    Then The user click on Get Started Button
    Then the user is taken to the Login Page
    When Click on Sign In with Frontline ID button
    Then Error message displays to the substitute users
    
@MOB-3206 @MOB-3145 @AndroidRegression @iOSRegression
  Scenario: Verify substitute user can successfully login with valid credentials
    When the user launches the app
    Then The user click on Get Started Button
    Then the user is taken to the Login Page
    And the substitute enter "valid" "AutomationSubsMOB-4269" username
    And the substitute enter "valid" "FrontlinePassword" password
    When Click on Sign In with Frontline ID button
    Then The substitute navigates to dashboard page

@MOB-4227 @MOB-4229 @AndroidSmoke @iOSSmoke @MOB-4228 @MOB-4230 @AndroidRegression @iOSRegression
  Scenario: Verify user remains login when application sent to background or gets relaunched
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationEmployeeMOB-4227" and password and click on Sign In button
    Then the user navigates to dashboard page
    And The user minimize and relaunch the application
    Then the user navigates to dashboard page
    And The user kill and relaunch the application
    Then the user navigates to dashboard page

@MOB-3601 @AndroidRegression @iOSRegression
  Scenario: Verify when a user is associated with multiple roles and single organization it should display role picker
    When the user launches the app
    Then The user click on Get Started Button
    Then the user is taken to the Login Page
    And Enter username "multirole" and password and click on Sign In button
    Then the user is presented with the role picker

  @MOB-3601  @AndroidRegression @iOSRegression
  Scenario: Verify when a user is associated with multiple roles and multiple organization it should display org picker
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubMutiOrg" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    And Click on switch btn
    Then the user is presented with the org picker

 @MOB-3682 @AndroidRegression @iOSRegression
  Scenario: Verify that substitute user has no access to districts
   When the user launches the app
    Then The user click on Get Started Button
   And Enter username "AutomationSubsJobOperations3" and password and click on Sign In button
   Then the system presents a dialog