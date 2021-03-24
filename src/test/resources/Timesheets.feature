@timesheet
Feature: Timesheet scenarios

#	#remove
# @MOB-5210 @MOB-5255 @MOB-5257  @MOB-5209 @MOB-5254 @MOB-5256
# Scenario: Timesheet day view, add and edit
#	 When the user launches the app
#	 Then the user click on Get Started Button
#	 And Enter employee username and password and click on Sign In button
#	 Then the employee navigates to dashboard page
#	 When employee clicks on the timesheet widget
#	 And open the past day timesheet and add a new time sheet
#	 Then user edits the timesheet
#
#	#remove
# @MOB-5208  @MOB-5207
#	Scenario: Timesheet week view
#		When the user launches the app
#		Then the user click on Get Started Button
#		And Enter employee username and password and click on Sign In button
#		Then the employee navigates to dashboard page
#		And click on timesheets widget and view timesheets
#
#	#remove
#	@MOB-5259  @MOB-5258
#	Scenario: Submit Timesheets
#		When the user launches the app
#		Then the user click on Get Started Button
#		And Enter employee username and password and click on Sign In button
#		Then the employee navigates to dashboard page
#		When click on timesheet option
#		Then click on submit timesheet option
#		And undo the timesheet

	#submit: week page, day page, undo
	@MOB-5577 @AndroidRegression @iOSRegression
	Scenario: Verify an employee user can submit day timesheet
		When Undo submitted timesheets "AutomationEmployeeMOB-5577" "APIWorkerID_MOB-5577" "APIOrgID" "APILoginID" "current day" "locationID_Org1" "shiftID_Org1" "eventID_Org1"
		When the user launches the app
		Then the user click on Get Started Button
		And Enter employee username "AutomationEmployeeMOB-5577" and password and click on Sign In button
		Then the user navigates to dashboard page
		When employee clicks on the timesheet widget
		Then Submit day timesheet option and verify submission

#	#remove
#	@MOB-5595  @MOB-5596
#	Scenario: Dark Mode for Timesheets
#		When the user launches the app
#		Then the user click on Get Started Button
#		And Enter employee username and password and click on Sign In button
#		Then the employee navigates to dashboard page
#		When the user clicks on Menu tab and click on Settings
#		Then the user toggle the Dark Mode
#		Then Navigate to menu links
#		When click on timesheet option
#		Then Take the screenshot

	# delete-> add api/manual-> undo verify-> submit-> verify add-> undo
	@MOB-5568  @MOB-5569 @AndroidRegression
	Scenario: Verify an employee cannot add new timeevent when timesheet is in submit state
		When Undo submitted timesheets "AutomationEmployeeMOB-5568" "APIWorkerID_MOB-5568" "APIOrgID" "APILoginID" "current day" "locationID_Org1" "shiftID_Org1" "eventID_Org1"
		When the user launches the app
		Then the user click on Get Started Button
		And Enter employee username "AutomationEmployeeMOB-5568" and password and click on Sign In button
		Then the user navigates to dashboard page
		When employee clicks on the timesheet widget
		Then click on submit timesheet option
		And verify no timesheet added and no submit btn is displayed

#	#remove #done in smoke
#	@MOB-5580  @MOB-5581
#	Scenario: Timesheet widget not updating after time events are added/removed
#		When the user launches the app
#		Then the user click on Get Started Button
#		And Enter employee username and password and click on Sign In button
#		Then the user navigates to dashboard page
#		When employee clicks on the timesheet widget
#		And add timesheet and verify time event
#		And Delete the timesheet
#		Then verify the deleted timesheet
#
#	#remove
#	@MOB-5587  @MOB-5586
#	Scenario: Automate editing of timesheet to delete clock in entry
#		When the user launches the app
#		Then the user click on Get Started Button
#		And Enter employee username and password and click on Sign In button
#		Then the user navigates to dashboard page
#		When employee clicks on the timesheet widget
#		And open the past day timesheet and add a new time sheet
#		Then user edits the timesheet
#		And Delete the timesheet

	#get value -> add time -> get total value... should increase
	@MOB-5578  @MOB-5579 @AndroidRegression
	Scenario: Verify when an employee adds a timeevent the total time on the dashboard should increase
		When Verify if timesheet present for an employee delete and create it using information "AutomationEmployeeMOB-5578" "APIWorkerID_MOB-5378" "APIOrgID" "APILoginID" "current day" "locationID_Org1" "shiftID_Org1" "eventID_Org1"
		When the user launches the app
		Then the user click on Get Started Button
		And Enter employee username "AutomationEmployeeMOB-5578" and password and click on Sign In button
		Then the user navigates to dashboard page
		When employee clicks on the timesheet widget
		Then Get the initial week total time
		And Add a new timesheet
		Then Verify Week Total after adding a timesheet
		And Verify the Timesheet total on dashboard

#	#remove
#	@MOB-5574  @MOB-5575
#	Scenario: Timesheets unsubmit Week view
#		When the user launches the app
#		Then the user click on Get Started Button
#		And Enter employee username and password and click on Sign In button
#		Then the employee navigates to dashboard page
#		When employee clicks on the timesheet widget
#		Then Timesheets is not submitted
#
#	#remove
#	@MOB-5206  @MOB-5205
#	Scenario: Timesheets landing page
#		When the user launches the app
#		Then the user click on Get Started Button
#		And Enter employee username and password and click on Sign In button
#		Then the employee navigates to dashboard page
#		And click on timesheets widget and view timesheets
#		And Add a new timesheet
#		Then click on submit timesheet option
#		And verify timesheets submit btn not displayed
#
#	###???? Not present anymore
#	@MOB-5203  @MOB-5204
#	Scenario: Timesheet Widget
#		When the user launches the app
#		Then the user click on Get Started Button
#		And Enter employee username and password and click on Sign In button
#		Then the user navigates to dashboard page
#		And user verify the current pay period of timesheet on dashboard
#		And Add a new timesheet
#
#	#only for ios
#	@MOB-4794  @MOB-5718
#	Scenario: View More Link should be present under Absence Widget
#		When the user launches the app
#		Then the user click on Get Started Button
#		And Enter employee username and password and click on Sign In button
#		Then the user navigates to dashboard page
#		And Verify the View More link under Absence Widget

	#GL_5 org
	@MOB-5585  @MOB-5584 @AndroidRegression
	Scenario: Verify the message when employee enters wrong pin while submiting timesheet
		When the user launches the app
		Then the user click on Get Started Button
		And Enter employee username "AutomationEmployeeMOB-5584" and password and click on Sign In button
		Then the user navigates to dashboard page
		When employee clicks on the timesheet widget
		When Click on submit btn with wrong entering pin
		Then verify the invalid pin message

##	#remove
#	@MOB-5541  @MOB-5551
#	Scenario: Undo Button working on Day view
#		When the user launches the app
#		Then the user click on Get Started Button
#		And Enter employee username and password and click on Sign In button
#		Then the user navigates to dashboard page
#		And click on timesheets widget and view timesheets
#		Then click on submit timesheet option
#		And undo the timesheet

	#how to convert time format..
	@MOB-5583  @MOB-5582 @AndroidRegression
	Scenario: Verify that an employee can view timesheet display with decimal durationFormat
		When Verify if timesheet present for an employee and delete it using information "AutomationEmployeeMOB-5583" "APIWorkerID_MOB-5583" "APIOrgID_Aut3" "APILoginID_Aut3" "current day"
		When the user launches the app
		Then the user click on Get Started Button
		And Enter employee username "AutomationEmployeeMOB-5583" and password and click on Sign In button
		Then the user navigates to dashboard page
		And click on timesheets widget and view timesheets
		And Add a new timesheet
		Then verify the decimal format

	@MOB-7529 @AndroidRegression
	Scenario: Verify that an employee can view timesheet display with time durationFormat
		When Verify if timesheet present for an employee and delete it using information "AutomationEmployeeMOB-7529" "APIWorkerID_MOB-7529" "APIOrgID" "APILoginID" "current day"
		When the user launches the app
		Then the user click on Get Started Button
		And Enter employee username "AutomationEmployeeMOB-7529" and password and click on Sign In button
		Then the user navigates to dashboard page
		And click on timesheets widget and view timesheets
		And Add a new timesheet
		Then verify the time format

