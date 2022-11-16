Feature: Premium MVP scenarios

  @MOB-8144 @MOB-8184 @android @iOS
  Scenario: Verify subscription detail page after purchase
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsMOB-8144" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    When the user clicks on Menu tab
    And Click on Settings
    When Click on subscription detail button
    Then Validate the active Subscription details Screen

  @MOB-8091 @MOB-8099 @android @iOS
  Scenario: Verify expired premium subscription feature set
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsMOB-8091" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    When Click on the Available Jobs
    And Click on sort filter btn
    Then Validate the sort by pop up
    When Click on post job filter
    Then Validate the expired Subscription details Screen

  #This iOS story may Fail on Simulator.
  #If the device has previously subscribed any user, then the status of this account will also become active
  @MOB-8029 @iOS @MOB-8036 @android
  Scenario: Verify Free Trail Page for new substitute
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsMOB-8029" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    And Click on the Available Jobs
    And Click on sort filter btn
    When Click on post job filter
    Then Validate the Subscription Free Trail Screen