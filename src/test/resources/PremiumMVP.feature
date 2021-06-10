@premiumMvp
Feature: Premium MVP scenarios

  @MOB-8144
  Scenario: Verify subscription detail page after purchase
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsMOB-8144" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    When the user clicks on Menu tab
    And Click on Settings
    When Click on subscription detail button
    Then Validate the Subscription details Screen

