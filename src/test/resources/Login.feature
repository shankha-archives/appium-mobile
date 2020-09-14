@login
Feature: Login scenarios

@regression @splashscreen @MOB-3204 @Android @ios
 Scenario: First time user experience or fresh app install
     When The substitute user launches the app
     And The substitute user lands on the splash screen
     When The substitute user taps the Get Started Button
     Then The substitute user arrives on the PIN entry screen

  @regression @pinunclok @pinunclok_1 @MOB-3205 @Android @ios
  Scenario: First time user experience / fresh app install
    When the substitute user launches the app
    Then the substitute user passes the splash screen
    Then the substitute user arrives on the PIN entry screen
    When the substitute user enters the PIN code 7354
    Then the substitute user is taken to the Login Page

  @regression @pinunclok @pinunclok_2 @MOB-3205 @ios @Android
  Scenario: Failed Attempts
    When the substitute user launches the app
    Then the substitute user passes the splash screen
    When the substitute user enters a incorrect PIN code '3333'
    Then the substitute user enter a incorrect PIN code '7777'
    Then the substitute user enters a incorrect PIN code '5555'
    Then the substitute user is prompted with a “You may not have access yet” dialog

  @regression @login @invalidLogin @MOB-3206 @MOB-3145 @ios  @Android
  Scenario Outline: Login with invalid credentials
    When the substitute user launches the app
    Then the substitute user passes the splash screen
    When the substitute user enters the PIN code 7354
    Then the substitute user is taken to the Login Page
    And the substitute enter invalid username"<userName>"
    And the substitute enter invalid password"<userPassword>"
    When Click on Sign In with Frontline ID button
    Then Incorrect username and password error message displays
    Examples:
      | userName   | userPassword   |
      | rupakumari | xyz@abc |

  @regression @login @noCredentials @MOB-3206 @MOB-3145 @ios @Android
  Scenario: The substitute clicked on Login button when user is not entered userId and Password
    When the substitute user launches the app
    Then the substitute user passes the splash screen
    When the substitute user enters the PIN code 7354
    Then the substitute user is taken to the Login Page
    When Click on Sign In with Frontline ID button
    Then Error message displays to the substitute users

  @regression @login @validlogin @MOB-3206 @MOB-3145 @ios @Android 
  Scenario Outline: Login with valid credentials
    When the substitute user launches the app
    Then the substitute user passes the splash screen
    When the substitute user enters the PIN code 7354
    Then the substitute user is taken to the Login Page
    And the substitute enter valid username"<userName>"
    And the substitute enter valid password"<userPassword>"
    When Click on Sign In with Frontline ID button
    Then the substitute navigates to dashboard page
    Examples:
      | userName   | userPassword   |
      | StageSubAhmed | FLultra1! |
  
  @regression @MOB-3601 @MultiRoleUser @MultiRole @Android
  Scenario Outline: user has only one enabled organization with multiple roles within that organization including substitute
    When The substitute user launches the app
    Then the substitute user click on Get Started Button and enter the pin
    And Enter username"<userName>" and password"<userPassword>" and click on Sign In button
    Then the user is presented with the role picker
    Examples:
      | userName   | userPassword   |
      | alexaOrgMultirole | FLultra1! |

  @regression @MOB-3601 @MultiRoleUser @MultiOrg @Android
  Scenario Outline: user has multiple organization with multiple roles within these organizations
    When The substitute user launches the app
    Then the substitute user click on Get Started Button and enter the pin
    And Enter username"<userName>" and password"<userPassword>" and click on Sign In button
    Then the user is presented with the org picker
    Examples:
      | userName   | userPassword   |
      | stageMultiMulti | FLultra1! |
      
  @regression @login @MOB-3682   
  Scenario Outline: Feature flags access-No Districts associated with Sub
    When the substitute user launches the app
    Then the substitute user click on Get Started Button and enter the pin
    And Enter username"<userName>" and password"<userPassword>" and click on Sign In button
    Then the system presents a dialog
    Examples:
      | userName   | userPassword   |
      | stageNoOrg | frontline1!|
      
  @regression @MOB-3776 @MultiOrg   
  Scenario Outline: Feature flags access- Multi District & Multi Role User
    When the substitute user launches the app
    Then the substitute user click on Get Started Button and enter the pin
    And Enter username"<userName>" and password"<userPassword>" and click on Sign In button
    Then the user is presented with the org picker
    When user selects the org with only role as sub
    Then a dialogue box is displayed
    When user clicks on back button
    Then the user is presented with the org picker
    Examples:
      | userName   | userPassword   |
      |  | |

  @regression @MOB-3776 @MultiOrg @SubRole   
  Scenario Outline: Feature flags access- Multi District & Multi Role User
    When the substitute user launches the app
    Then the substitute user click on Get Started Button and enter the pin
    And Enter username"<userName>" and password"<userPassword>" and click on Sign In button
    Then the user is presented with the org picker
    When user selects the org with only role as sub
    Then a dialogue box is displayed
    When user clicks on back button
    Then the user is presented with login page
    Examples:
      | userName   | userPassword   |
      |  | |

  @regression @MOB-3776 @MultiOrg @MultiRole   
  Scenario Outline: Feature flags access- Multi District & Multi Role User
    When the substitute user launches the app
    Then the substitute user click on Get Started Button and enter the pin
    And Enter username"<userName>" and password"<userPassword>" and click on Sign In button
    Then the user is presented with the org picker
    When user selects the org with only role as sub
    Then a dialogue box is displayed
    When user clicks on back button
    Then the user is presented with the role picker
    Examples:
      | userName   | userPassword   |
      |  | |
   
