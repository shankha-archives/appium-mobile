@Regression 
Feature: Regression scenarios 

@Setting @MOB-4789 @AndroidRegression @MOB-4791 @iOSRegression @Regression 
Scenario: Show calendar link in substitute Menu 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on menu and tap the Calendar link 
	Then verify the calendar 
	
@Setting @MOB-4806 @AndroidRegression @MOB-4805 @iOSRegression @Regression 
Scenario: Show Job List tab bar 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on Avalaible Jobs link 
	Then verify Job List tab bar for available and accepted jobs 
	
@Setting @MOB-4809 @AndroidRegression @MOB-4810 @iOSRegression @Regression 
Scenario: Allow user to submit diagnostic data 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on menu bar 
	And Long press on Frontline Logo at bottom of the screen 
	Then User click on the send Diagnostics option and click on Okay button 
		
@Setting @MOB-4803 @AndroidRegression @Regression
Scenario: SHOW Accepted Jobs in-app Calendar 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on available job widget 
	And accept the job 
	Then go to calender and view the accepted job 
  
@Setting @MOB-4808 @AndroidRegression @MOB-4807 @iOSRegression @Regression 
Scenario: Show Next Scheduled Job widget
	 When the user launches the app 
	 Then the user click on Get Started Button
	 Then the substitute user is taken to the Login Page 
	 And Enter username and password and click on Sign In button 
	 Then the substitute navigates to dashboard page 
	 Then The user moves to Next Scheduled Job widget and verify it
	   
@Setting @MOB-4796 @AndroidRegression @MOB-4797 @iOSRegression @Regression 
Scenario: Remove Unlock Code Page
	When the user launches the app 
	Then the user click on Get Started Button
	Then the substitute user is taken to the Login Page
	And the user verify that Unlock code page should not displayed
	
@Setting @MOB-6023 @AndroidRegression @MOB-6024 @iOSRegression @Regression
Scenario: Verify role picker option should not displayed when user account has only one role
    When the user launches the app 
	Then the user click on Get Started Button 
	And Enter multiorg username and password and click on SignIn button 
    Then the user is presented with the org picker
    When Select the Organization
    Then the substitute navigates to dashboard page
    When click on switch
    Then the user is presented with the org picker
	   
@Setting @MOB-6033 @iOSRegression @regression
Scenario: Denied tab in absences view reads as no upcoming absences
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	And click on Available Leave Balances and view leave balances
	Then click and verify the Denied panel
	
@Setting @MOB-6019 @AndroidRegression @Regression 
Scenario: Verify add Intime event value in Timesheet should remain same after relaunching the app
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	When employee clicks on the timesheet widget
	Then click on add timesheet and change InTime
	And The user minimize and relaunch the application
	Then Verify that InTime should not changes