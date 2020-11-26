@timesheet
Feature: Timesheet scenarios 

@MOB-5210 @MOB-5255 @MOB-5257 @AndroidRegression @MOB-5209 @MOB-5254 @MOB-5256 @iOSRegression
Scenario: Timesheet day view, add and edit
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget 
	And open the past day timesheet and add a new time sheet 
	Then user edits the timesheet 
	

@MOB-5208 @AndroidRegression @MOB-5207 @iOSRegression
Scenario: Timesheet week view
 	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	And click on timesheets widget and view timesheets

@MOB-5259 @AndroidRegression @MOB-5258 @iOSRegression
Scenario: Submit Timesheets
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When click on timesheet option 
	Then click on submit timesheet option 
	And undo the timesheet

@MOB-5577 @AndroidRegression
Scenario: Timesheets Submission Day View
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget
	Then click on day and submit day timesheet option 

@MOB-5595 @AndroidRegression @MOB-5596 @iOSRegression
	Scenario: Dark Mode for Timesheets
	When the user launches the app
	Then the user click on Get Started Button
	And Enter employee username and password and click on Sign In button
	Then the employee navigates to dashboard page
	When the user clicks on Menu tab and click on Settings
	Then the user toggle the Dark Mode
	Then click on the home button to navigate back to dashboard
	When click on timesheet option
	Then Take the screenshot
	
@MOB-5568 @AndroidRegression
Scenario: Submit time sheets no timesheets to add state
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget 
	Then click on submit timesheet option
	And verify no timesheet added and no submit btn is displayed 
	
@MOB-5580 @iOSRegression
Scenario: Timesheet widget not updating after time events are added/removed
	 When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	When employee clicks on the timesheet widget
	And add timesheet and verify time event
	And Delete the timesheet
	Then verify the deleted timesheet
	
@MOB-5587 @AndroidRegression @MOB-5586 @iOSRegression
Scenario: Automate editing of timesheet to delete clock in entry
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget 
	And open the past day timesheet and add a new time sheet 
	Then user edits the timesheet 
	And Delete the timesheet 
