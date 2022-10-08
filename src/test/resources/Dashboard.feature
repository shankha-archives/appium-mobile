@Dashboard
Feature: Dashboard Scenarios
#More test scenarios would be added here in future

@MOB-4242 @MOB-4240 @MOB-4239 @MOB-4241 @iOSSmoke @AndroidSmoke @AndroidRegression
Scenario: Need to rearrange the widgets on the dashboard
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationSubsMOB-4265" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  When Fetch the list of widgets before reordering
  When Click on reorder widget button
  And Change the widget order
  And Click on save arranged widgets button
  Then the user navigates to dashboard page
  When Fetch the list of widgets after reordering
  Then verify the order of widgets
  When the user clicks on Menu tab
  And Click on Settings
  And Logout from app
  And Enter username "AutomationEmployeeMOB-4257" and password and click on Sign In button
  Then the user navigates to dashboard page
  When Fetch the list of widgets before reordering
  When Click on reorder widget button
  And Change the widget order
  And Click on save arranged widgets button
  Then the user navigates to dashboard page
  When Fetch the list of widgets after reordering
  Then verify the order of widgets
  When the user clicks on Menu tab
  And Click on Settings
  And Logout from app
  And Enter username "AutomationAdminMOB-4267" and password and click on Sign In button
  Then the user navigates to dashboard page
  When Fetch the list of widgets before reordering
  When Click on reorder widget button
  And Change the widget order
  And Click on save arranged widgets button
  Then the user navigates to dashboard page
  When Fetch the list of widgets after reordering
  Then verify the order of widgets

@MOB-4257 @MOB-4265 @MOB-4267 @AndroidSmoke @MOB-4258 @MOB-4266 @MOB-4268 @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify a user can visit inbox and view messages
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationSubsMOB-4265" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  When click on the inbox
  And Verify inbox screen is display
  And Click on inbox alert
  Then Verify the inbox message
  When the user clicks on Menu tab
  And Click on Settings
  And Logout from app
  And Enter username "AutomationEmployeeMOB-4257" and password and click on Sign In button
  Then the user navigates to dashboard page
  When click on the inbox
  And Verify inbox screen is display
  And Click on inbox alert
  Then Verify the inbox message
  When the user clicks on Menu tab
  And Click on Settings
  And Logout from app
  And Enter username "AutomationAdmin" and password and click on Sign In button
  Then the user navigates to dashboard page
  When click on the inbox
  And Verify inbox screen is display
  And Click on inbox alert
  Then Verify the inbox message


