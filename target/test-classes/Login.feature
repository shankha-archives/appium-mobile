@login
Feature: Login scenarios

@regression @splashscreen @MOB-3204
 Scenario: First time user experience or fresh app install
     When The substitute user launches the app
     And The substitute user lands on the splash screen
     When The substitute user taps the Get Started Button
     Then The substitute user arrives on the PIN entry screen

  @regression @pinunclok @pinunclok_1 @MOB-3205
  Scenario: First time user experience / fresh app install
    When the substitute user launches the app
    Then the substitute user passes the splash screen
    Then the substitute user arrives on the PIN entry screen
    When the substitute user enters the PIN code 7354
    Then the substitute user is taken to the Login Page

  @regression @pinunclok @pinunclok_2 @MOB-3205
  Scenario: Failed Attempts
    When the substitute user launches the app
    Then the substitute user passes the splash screen
    When the substitute user enters a incorrect PIN code '3333'
    Then the substitute user enter a incorrect PIN code '7777'
    Then the substitute user enters a incorrect PIN code '5555'
    Then the substitute user is prompted with a “You may not have access yet” dialog
    