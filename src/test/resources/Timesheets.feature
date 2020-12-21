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
	
@MOB-5568 @AndroidRegression @MOB-5569 @iOSRegression
Scenario: Submit time sheets no timesheets to add state
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget 
	Then click on submit timesheet option
	And verify no timesheet added and no submit btn is displayed 
	
@MOB-5580 @iOSRegression @MOB-5581 @AndroidRegression
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
	
@MOB-5578 @AndroidRegression @MOB-5579 @iOSRegression
Scenario: Timesheet Submission Week View
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget 
	And Add a new timesheet
	Then verify work total time this week to be greater than zero

@MOB-5574 @iOSRegression @MOB-5575 @AndroidRegression
Scenario: Timesheets unsubmit Week view
	When the user launches the app
	Then the user click on Get Started Button
	And Enter employee username and password and click on Sign In button
	Then the employee navigates to dashboard page
	When employee clicks on the timesheet widget
	Then Timesheets is not submitted

@MOB-5206 @AndroidRegression @MOB-5205 @iOSRegression
Scenario: Timesheets landing page
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	And click on timesheets widget and view timesheets
	And Add a new timesheet
	Then click on submit timesheet option 
	And verify timesheets submit btn not displayed
	
@MOB-5203 @iOSRegression @MOB-5204 @AndroidRegression
Scenario: Timesheet Widget
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	And user verify the current pay period of timesheet on dashboard 
	And Add a new timesheet
	
@MOB-4794 @iOSRegression
Scenario: View More Link should be present under Absence Widget
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	And Verify the View More link under Absence Widget
	
@MOB-5585 @AndroidRegression @MOB-5584 @iOSRegression
Scenario: Make mobile error status code for incorrect pin when submitting a timesheet
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	When employee clicks on the timesheet widget
	When Click on submit btn with wrong entering pin
	Then verify the invaid pin message
	
@MOB-5541 @iOSRegression @MOB-5551 @iOSRegression
Scenario: Undo Button working on Day view
 	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	And click on timesheets widget and view timesheets
	Then click on submit timesheet option
	And undo the timesheet
	
@MOB-5583 @iOSRegression
Scenario: Format timesheet display in accordance with durationFormat
 	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	And click on timesheets widget and view timesheets
	Then verify the time format