@login
Feature: Login scenarios

@regression @splashscreen @MOB-3204 @Android @ios @done
 Scenario: Verify users experience on fresh app install
  When the user launches the app 
	Then the user click on Get Started Button 

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

@regression @login @invalidLogin @MOB-3206 @MOB-3145 @ios  @Android @done
  Scenario: Verify when substitue user logs in with invalid credentials
  When the user launches the app 
	Then the user click on Get Started Button
  Then the substitute user is taken to the Login Page
  And the substitute enter "invalid" "invalidlogin" username
  And the substitute enter "invalid" "invalidpass" password
  When Click on Sign In with Frontline ID button
  Then Incorrect username and password error message displays
 
  @regression @login @noCredentials @MOB-3206 @MOB-3145 @ios @Android @done
  Scenario: Verify when substitue user logs in without credentials
    When the user launches the app 
		Then the user click on Get Started Button
    Then the substitute user is taken to the Login Page
    When Click on Sign In with Frontline ID button
    Then Error message displays to the substitute users

  @regression @login @validlogin @MOB-3206 @MOB-3145 @ios @Android @done
  Scenario: Verify when substitue user logs in with valid credentials
   When the user launches the app 
	 Then the user click on Get Started Button
    Then the substitute user is taken to the Login Page
    And the substitute enter "valid" "AutomationSubsMOB-4269" username
  	And the substitute enter "valid" "FrontlinePassword" password
    When Click on Sign In with Frontline ID button
    Then the substitute navigates to dashboard page
  
  @regression @MOB-3601 @MultiRoleUser @MultiRole @Android
  Scenario: Verify substitute has only one enabled organization with multiple roles within that organization
   When the user launches the app 
	 Then the user click on Get Started Button
	 And Enter username "multiOrgSubsUser" and password and click on Sign In button
   #And Enter username and password for multiple roles including substitute and organization and click on Sign In button
   Then the user is presented with the role picker

  @regression @MOB-3601 @MultiRoleUser @MultiOrg @Android
  Scenario: Verify substitute has multiple enabled organization with multiple roles within that organization
  When the user launches the app 
	Then the user click on Get Started Button
  And Enter username "MultiOrgUser" and password and click on Sign In button
  #And Enter username and password for multiple organization and click on Sign In button
  Then the user is presented with the org picker

  @regression @login @MOB-3682   
  Scenario: Verify that substitute user has no access to districts
   When the user launches the app 
	 Then the user click on Get Started Button
   And Enter username "noOrgUsername" and password and click on Sign In button
    Then the system presents a dialog
      
   @regression @MOB-3676 @MultiOrg   
  Scenario: Verify Multi District & Multi Role user displays org picker on login
 When the user launches the app 
	 Then the user click on Get Started Button
    And Enter username "" and password and click on Sign In button
    Then the user is presented with the org picker
    When user selects the org with only role as sub
    Then a dialogue box is displayed
    When user clicks on back button
    Then the user is presented with the org picker

  @regression @MOB-3676 @MultiOrg @SubRole   
  Scenario: Verify Multi District & Multi Role user displays login when clicked back on org picker
   When the user launches the app 
	 Then the user click on Get Started Button
   And Enter username "" and password and click on Sign In button
    Then the user is presented with the org picker
    When user selects the org with only role as sub
    Then a dialogue box is displayed
    When user clicks on back button
    Then the user is presented with login page
   
  @regression @MOB-3676 @MultiOrg @MultiRole   
  Scenario: Verify Multi District & Multi Role user displays role picker when selected an org
    When the user launches the app 
	 Then the user click on Get Started Button
   And Enter username "" and password and click on Sign In button
    Then the user is presented with the org picker
    When user selects the org with only role as sub
    Then a dialogue box is displayed
    When user clicks on back button
    Then the user is presented with the role picker
   
   
