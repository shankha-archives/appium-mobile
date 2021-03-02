@login
Feature: Login scenarios

#get-> verify login-> kill-> validate login page
  @regression @splashscreen @MOB-3204 @Android @ios @done @Done
  Scenario: Verify users is able to view splash screen only on fresh application install
    When the user launches the app
    And the user click on Get Started Button
    Then the substitute user is taken to the Login Page
    When The user kill and relaunch the application
    Then the substitute user is taken to the Login Page

  @regression @login @invalidLogin @MOB-3206 @MOB-3145 @ios  @Android @Done
  Scenario: Verify substitute user couldnt login with invalid credentials
    When the user launches the app
    Then the user click on Get Started Button
    Then the substitute user is taken to the Login Page
    And the substitute enter "invalid" "invalidlogin" username
    And the substitute enter "invalid" "invalidpass" password
    When Click on Sign In with Frontline ID button
    Then Incorrect username and password error message displays
    
  @regression @login @noCredentials @MOB-3206 @MOB-3145 @ios @Android @Done
  Scenario: Verify substitute user couldnt login without credentials
    When the user launches the app
    Then the user click on Get Started Button
    Then the substitute user is taken to the Login Page
    When Click on Sign In with Frontline ID button
    Then Error message displays to the substitute users
    
  @regression @login @validlogin @MOB-3206 @MOB-3145 @ios @Android @Done
  Scenario: Verify substitute user can successfully login with valid credentials
    When the user launches the app
    Then the user click on Get Started Button
    Then the substitute user is taken to the Login Page
    And the substitute enter "valid" "AutomationSubsMOB-4269" username
    And the substitute enter "valid" "FrontlinePassword" password
    When Click on Sign In with Frontline ID button
    Then the substitute navigates to dashboard page

@regression @MOB-3601 @MultiRoleUser @MultiRole @Android @Done
  Scenario: Verify when a user is associated with multiple roles and single organization it should display role picker
    When the user launches the app
    Then the user click on Get Started Button
    And Enter username "AutomationSubMutiRole" and password and click on Sign In button
    Then the user is presented with the role picker
 
 @regression @MOB-3601 @MultiRoleUser @MultiOrg @Android @Done
  Scenario: Verify when a user is associated with multiple roles and multiple organization it should display org picker
    When the user launches the app
    Then the user click on Get Started Button
    And Enter username "AutomationSubMutiOrg" and password and click on Sign In button
    Then the user is presented with the org picker

  @regression @MOB-3682
  Scenario: Verify that substitute user has no access to districts
   When the user launches the app 
	 Then the user click on Get Started Button
   And Enter username "noOrgUsername" and password and click on Sign In button
   Then the system presents a dialog
