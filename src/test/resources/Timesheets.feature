@timesheet
Feature: Timesheet scenarios 

@MOB-5210 @MOB-5255 @MOB-5257  @MOB-5209 @MOB-5254 @MOB-5256 
Scenario: Timesheet day view, add and edit
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget 
	And open the past day timesheet and add a new time sheet 
	Then user edits the timesheet	

@MOB-5208  @MOB-5207 
Scenario: Timesheet week view
 	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	And click on timesheets widget and view timesheets

@MOB-5259  @MOB-5258 
Scenario: Submit Timesheets
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When click on timesheet option 
	Then click on submit timesheet option 
	And undo the timesheet

@MOB-5577 
Scenario: Timesheets Submission Day View
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget
	Then click on day and submit day timesheet option 

@MOB-5595  @MOB-5596 
	Scenario: Dark Mode for Timesheets
	When the user launches the app
	Then the user click on Get Started Button
	And Enter employee username and password and click on Sign In button
	Then the employee navigates to dashboard page
	When the user clicks on Menu tab and click on Settings
	Then the user toggle the Dark Mode
	Then Navigate to menu links
	When click on timesheet option
	Then Take the screenshot
	
@MOB-5568  @MOB-5569 
Scenario: Submit time sheets no timesheets to add state
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget 
	Then click on submit timesheet option
	And verify no timesheet added and no submit btn is displayed 
	
@MOB-5580  @MOB-5581 
Scenario: Timesheet widget not updating after time events are added/removed
	 When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	When employee clicks on the timesheet widget
	And add timesheet and verify time event
	And Delete the timesheet
	Then verify the deleted timesheet
	
@MOB-5587  @MOB-5586 
Scenario: Automate editing of timesheet to delete clock in entry
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget 
	And open the past day timesheet and add a new time sheet 
	Then user edits the timesheet 
	And Delete the timesheet
	
@MOB-5578  @MOB-5579 
Scenario: Timesheet Submission Week View
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When employee clicks on the timesheet widget 
	And Add a new timesheet
	Then verify work total time this week to be greater than zero

@MOB-5574  @MOB-5575 
Scenario: Timesheets unsubmit Week view
	When the user launches the app
	Then the user click on Get Started Button
	And Enter employee username and password and click on Sign In button
	Then the employee navigates to dashboard page
	When employee clicks on the timesheet widget
	Then Timesheets is not submitted

@MOB-5206  @MOB-5205 
Scenario: Timesheets landing page
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	And click on timesheets widget and view timesheets
	And Add a new timesheet
	Then click on submit timesheet option 
	And verify timesheets submit btn not displayed
	
@MOB-5203  @MOB-5204 
Scenario: Timesheet Widget
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	And user verify the current pay period of timesheet on dashboard 
	And Add a new timesheet
	
@MOB-4794  @MOB-5718 
Scenario: View More Link should be present under Absence Widget
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	And Verify the View More link under Absence Widget
	
@MOB-5585  @MOB-5584 
Scenario: Make mobile error status code for incorrect pin when submitting a timesheet
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	When employee clicks on the timesheet widget
	When Click on submit btn with wrong entering pin
	Then verify the invaid pin message
	
@MOB-5541  @MOB-5551 
Scenario: Undo Button working on Day view
 	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	And click on timesheets widget and view timesheets
	Then click on submit timesheet option
	And undo the timesheet
	
@MOB-5583  @MOB-5582 
Scenario: Format timesheet display in accordance with durationFormat
 	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	And click on timesheets widget and view timesheets
	Then verify the time format
