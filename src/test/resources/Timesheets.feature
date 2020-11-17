@timesheet
Feature: Timesheet scenarios 

@MOB-5210 @AndroidSmoke @MOB-5209 @iOSSmoke
Scenario: Timesheet day view 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget 
	And open the past day timesheet and add a new time sheet 
	Then user edits the timesheet 
	
@MOB-5208 @AndroidSmoke
Scenario: Timesheet week view
 	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	And click on timesheets widget and view timesheets