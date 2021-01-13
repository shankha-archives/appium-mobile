@regression 
Feature: Regression scenarios 

@regression @MOB-4789 @android @sprint8 @MOB-4791 @iOS 
Scenario: Show calendar link in substitute Menu 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on menu and tap the Calendar link 
	Then verify the calendar 
	
@regression @MOB-4806 @iOS @sprint9 @MOB-4805 @android
Scenario: Show Job List tab bar 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on Avalaible Jobs link 
	Then verify Job List tab bar for available and accepted jobs 
	
@regression @MOB-4809 @iOS @sprint9 @MOB-4810 @android
Scenario: Allow user to submit diagnostic data 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on menu bar 
	And Long press on Frontline Logo at bottom of the screen 
	Then User click on the send Diagnostics option and click on Okay button 
		
@sprint10 @MOB-4803 @android
Scenario: SHOW Accepted Jobs in-app Calendar 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on available job widget 
	And accept the job 
	Then go to calender and view the accepted job 
  
@regression @MOB-4808 @iOS @sprint10 @MOB-4807 @android
Scenario: Show Next Scheduled Job widget
	 When the user launches the app 
	 Then the user click on Get Started Button
	 Then the substitute user is taken to the Login Page 
	 And Enter username and password and click on Sign In button 
	 Then the substitute navigates to dashboard page 
	 Then The user moves to Next Scheduled Job widget and verify it
	   
@regression @MOB-4796 @iOS @sprint10 @MOB-4797
Scenario: Remove Unlock Code Page
	When the user launches the app 
	Then the user click on Get Started Button
	Then the substitute user is taken to the Login Page
	And the user verify that Unlock code page should not displayed
	
@MOB-6023 @Android
Scenario: Switch for mult-org user will always show role picker
    When the user launches the app 
	Then the user click on Get Started Button 
	And Enter multiorg username and password and click on SignIn button 
    Then the user is presented with the org picker
    When Select the Organization
    Then the substitute navigates to dashboard page
    When click on switch
    Then the user is presented with the org picker
	   
@MOB-6033 @iOS
Scenario: Denied tab in absences view reads as no upcoming absences
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	And click on Available Leave Balances and view leave balances
	Then click and verify the Denied panel 
	
@MOB-6030 @Android
Scenario: Application crashes after tapping on todays absences
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter admin username and password and click on Sign In button 
	Then the admin navigates to dashboard page 
	When Click on add Absence Widget
	Then Click on any created absence and verify if crash happens