@login
Feature: Login scenarios

#get-> verify login-> kill-> validate login page 
 @splashscreen @MOB-3204 @AndroidRegression @done
 Scenario: Verify users is able to view splash screen only on fresh application install
  When the user launches the app 
	And the user click on Get Started Button 
	Then the substitute user is taken to the Login Page
	When The user kill and relaunch the application
	Then the substitute user is taken to the Login Page
	
  #@regression @pinunclok @pinunclok_1 @MOB-3205 @Android @ios
  #Scenario: First time user experience / fresh app install
    #When the substitute user launches the app
    #Then the substitute user passes the splash screen
    #Then the substitute user arrives on the PIN entry screen
    #When the substitute user enters the PIN code 7354
    #Then the substitute user is taken to the Login Page
#
  #@regression @pinunclok @pinunclok_2 @MOB-3205 @ios @Android
  #Scenario: Failed Attempts
    #When the substitute user launches the app
    #Then the substitute user passes the splash screen
    #When the substitute user enters a incorrect PIN code '3333'
    #Then the substitute user enter a incorrect PIN code '7777'
    #Then the substitute user enters a incorrect PIN code '5555'
    #Then the substitute user is prompted with a “You may not have access yet” dialog

 @login @invalidLogin @MOB-3206 @MOB-3145 @AndroidRegression @done
  Scenario: Verify substitute user couldnt login with invalid credentials
  When the user launches the app 
	Then the user click on Get Started Button
  Then the substitute user is taken to the Login Page
  And the substitute enter "invalid" "invalidlogin" username
  And the substitute enter "invalid" "invalidpass" password
  When Click on Sign In with Frontline ID button
  Then Incorrect username and password error message displays
 
   @login @noCredentials @MOB-3206 @MOB-3145 @AndroidRegression @done
  Scenario: Verify substitute user couldnt login without credentials
    When the user launches the app 
		Then the user click on Get Started Button
    Then the substitute user is taken to the Login Page
    When Click on Sign In with Frontline ID button
    Then Error message displays to the substitute users

   @login @validlogin @MOB-3206 @MOB-3145 @AndroidRegression @done
  Scenario: Verify substitute user can successfully login with valid credentials
   When the user launches the app 
	 Then the user click on Get Started Button
    Then the substitute user is taken to the Login Page
    And the substitute enter "valid" "AutomationSubsMOB-4269" username
  	And the substitute enter "valid" "FrontlinePassword" password
    When Click on Sign In with Frontline ID button
    Then the substitute navigates to dashboard page
  
   @MOB-3601 @MultiRoleUser @MultiRole @AndroidRegression  @done
  Scenario: Verify when a user is associated with multiple roles and single organization it should display role picker
   When the user launches the app 
	 Then the user click on Get Started Button
	 And Enter username "AutomationSubMutiRole" and password and click on Sign In button
   Then the user is presented with the role picker

   @MOB-3601 @MultiRoleUser @MultiOrg @AndroidRegression @done
  Scenario: Verify when a user is associated with multiple roles and multiple organization it should display org picker
  When the user launches the app 
	Then the user click on Get Started Button
  And Enter username "AutomationSubMutiOrg" and password and click on Sign In button
  Then the user is presented with the org picker

   @login @MOB-3682   
  Scenario: Verify that substitute user has no access to districts
   When the user launches the app 
	 Then the user click on Get Started Button
   And Enter username "noOrgUsername" and password and click on Sign In button
   Then the system presents a dialog