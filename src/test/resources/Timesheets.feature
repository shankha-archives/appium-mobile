@timesheet
Feature: Timesheet scenarios 

@MOB-5210 @AndroidSmoke
Scenario: Timesheet day view 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget 
	And open the past day timesheet and add a new time sheet 
	Then user edits the timesheet 
	
@MOB-5259 @AndroidSmoke
Scenario: Submit Timesheets 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When click on timesheet option 
	Then click on submit timesheet option 
	And undo the timesheet 