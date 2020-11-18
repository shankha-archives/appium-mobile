@timesheet
Feature: Timesheet scenarios 

@MOB-5210 @MOB-5257 @MOB-5255 @AndroidSmoke @MOB-5209 @MOB-5254 @MOB-5256 @iOSSmoke
Scenario: Timesheet day view, add and edit
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

@MOB-5259 @AndroidSmoke
Scenario: Submit Timesheets 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When click on timesheet option 
	Then click on submit timesheet option 
	And undo the timesheet