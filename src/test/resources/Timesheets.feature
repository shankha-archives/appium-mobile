@timesheet
Feature: Timesheet scenarios

@smoke @MOB-4243 @MOB-4244 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify an employee should be able to clock in and clock out
  When Verify if timesheet present for an employee and delete it using information "AutomationEmployeeMOB-4243" "APIWorkerID_MOB-4243" "APIOrgID" "APILoginID" "current day"
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-4243" and password and click on Sign In button
  Then the user navigates to dashboard page
  When The employee clicks on clockin btn
#    And Approve the required permissions
#    When The employee clicks on clockin btn
  Then Verify the employee is clocked in
  When The user navigates to timesheet widget
  And Select the current day
  And Verify time event is visible
  And Click on time event
  And Click on edit timesheet btn
  And Wait for time entry page to load
  Then edit the timesheet outtime
  And Save edited timeevent
  When Navigate back to dayView
  And Verify time event is visible
  Then Verify the added event
  And Navigate to dashboard
  Then the user navigates to dashboard page
  And Verify the timesheet is clocked out

@MOB-5577 @AndroidRegression @iOSRegression
Scenario: Verify an employee user can submit day timesheet
  When Undo submitted timesheets "AutomationEmployeeMOB-5577" "APIWorkerID_MOB-5577" "APIOrgID" "APILoginID" "current day" "locationID_Org1" "shiftID_Org1" "eventID_Org1"
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-5577" and password and click on Sign In button
  Then the user navigates to dashboard page
  When The user navigates to timesheet widget
  And Select the current day
  Then Click on submit day timesheet
  Then Click on submit timesheet
  And Verify submission of timesheet

@MOB-4263 @MOB-4264 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify an employee can submit weekly timesheet and then undo a timesheet
  When Undo submitted timesheets "AutomationEmployeeMOB-4263" "APIWorkerID_MOB-4263" "APIOrgID" "APILoginID" "current day" "locationID_Org1" "shiftID_Org1" "eventID_Org1"
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-4263" and password and click on Sign In button
  Then the user navigates to dashboard page
  When The user navigates to timesheet widget
  And Select the current day
  And Click on add new time event
  And Wait for time entry page to load
  Then Add one hour of out time to the event
  And Click ok after adding out time event
  And Save timeevent
  When Navigate back to week View
  Then Calculate the week total
  And Verify the total time of the week
  When Click on submit week timesheet option
  Then Click on submit timesheet
#    When Decline review pop up
  When Click on undo week timesheet btn
  Then Click on undo option
  When Decline review pop up
  Then Verify undo timesheet

@MOB-4259 @AndroidSmoke @MOB-4260 @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify an employee can view week of timesheets
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-4263" and password and click on Sign In button
  Then the user navigates to dashboard page
  When The user navigates to timesheet widget
  Then Verify days of the week

@MOB-5568  @MOB-5569 @AndroidRegression @iOSRegression
Scenario: Verify an employee cannot add new timeevent when timesheet is in submit state
  When Undo submitted timesheets "AutomationEmployeeMOB-5568" "APIWorkerID_MOB-5568" "APIOrgID" "APILoginID" "current day" "locationID_Org1" "shiftID_Org1" "eventID_Org1"
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-5568" and password and click on Sign In button
  Then the user navigates to dashboard page
  When The user navigates to timesheet widget
  When Click on submit week timesheet option
  Then Click on submit timesheet
  And Verify submission of timesheet
  And Select the current day
  And Click on add new time event
  And Wait for time entry page to load
  Then edit the timesheet outtime
  And Save timeevent
  Then Verify the pop up that timesheet is not editable

@MOB-5578  @MOB-5579 @AndroidRegression @iOSRegression
Scenario: Verify when an employee adds a timeevent the total time on the dashboard should increase
  When Verify if timesheet present for an employee delete and create it using information "AutomationEmployeeMOB-5578" "APIWorkerID_MOB-5378" "APIOrgID" "APILoginID" "current day" "locationID_Org1" "shiftID_Org1" "eventID_Org1"
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-5578" and password and click on Sign In button
  Then the user navigates to dashboard page
  When The user navigates to timesheet widget
  Then Get the total week total time
  And Select the current day
  And Click on add new time event
  And Wait for time entry page to load
  Then Add one hour of out time to the event
  And Click ok after adding out time event
  And Save timeevent
  When Calculating the total week time value
  When Navigate back to week View
  Then Get the total week total time
  And Verify the total time with the calculated time
  And Navigate to dashboard
  Then the user navigates to dashboard page
  And Verify the Timesheet total on dashboard

@MOB-4261 @AndroidSmoke @MOB-4262 @iOSSmokes @AndroidRegression @iOSRegression
Scenario: Verify an employee can edit and delete the time from the timesheet
  When Verify if timesheet present for an employee and delete it using information "AutomationEmployeeMOB-4261" "APIWorkerID_MOB-4261" "APIOrgID" "APILoginID" "current day"
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-4261" and password and click on Sign In button
  Then the user navigates to dashboard page
  When The user navigates to timesheet widget
  And Select the current day
  And Click on add new time event
  And Wait for time entry page to load
  Then edit the timesheet outtime
  And Save timeevent
  And Verify time event is visible
  And Click on time event
  And Click on edit timesheet btn
  And Wait for time entry page to load
  When The comment is edited to the time event
  And Save edited timeevent
  When Navigate back to dayView
#    When Decline review pop up
  And Verify time event is visible
  Then Verify the added event
  And Click on time event
  And Verify the added comment
  When Delete time event
  Then Verify deleted time event


@MOB-5585  @MOB-5584 @AndroidRegression @iOSRegression
Scenario: Verify the message when employee enters wrong pin while submiting timesheet
  When Verify if timesheet present for an employee delete and create it using information "AutomationEmployeeMOB-5584" "APIWorkerID_MOB-5584" "APIOrgID_Aut3" "APILoginID_Aut3" "current day" "locationID_Org3" "shiftID_Org3" "eventID_Org3"
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-5584" and password and click on Sign In button
  Then the user navigates to dashboard page
  When The user navigates to timesheet widget
  When Click on submit week timesheet option
  And Enter digital pin
  Then Click on submit timesheet
  Then verify the invalid pin message

@MOB-5583  @MOB-5582 @AndroidRegression @iOSRegression
Scenario: Verify that an employee can view timesheet display with decimal durationFormat
  When Verify if timesheet present for an employee and delete it using information "AutomationEmployeeMOB-5583" "APIWorkerID_MOB-5583" "APIOrgID_Aut3" "APILoginID_Aut3" "current day"
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-5583" and password and click on Sign In button
  Then the user navigates to dashboard page
  When The user navigates to timesheet widget
  And Select the current day
  And Click on add new time event
  And Wait for time entry page to load
  Then Add one hour of out time to the event
  And Click ok after adding out time event
  And Save timeevent
  Then verify the decimal format

@MOB-7529 @AndroidRegression @iOSRegression
Scenario: Verify that an employee can view timesheet display with time durationFormat
  When Verify if timesheet present for an employee and delete it using information "AutomationEmployeeMOB-7529" "APIWorkerID_MOB-7529" "APIOrgID" "APILoginID" "current day"
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-7529" and password and click on Sign In button
  Then the user navigates to dashboard page
  When The user navigates to timesheet widget
  And Select the current day
  And Click on add new time event
  And Wait for time entry page to load
  Then Add one hour of out time to the event
  And Click ok after adding out time event
  And Save timeevent
  Then verify the time format

@MOB-8452 @MOB-8641 @AndroidRegression @iOSRegression
Scenario: Verify that after adding timesheet from dashboard the total time in widget should increase
  When Verify if timesheet present for an employee and delete it using information "AutomationEmployeeMOB-8452" "APIWorkerID_MOB-8452" "APIOrgID" "APILoginID" "current day"
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-8452" and password and click on Sign In button
  Then the user navigates to dashboard page
  When Get the week total time from dashboard before adding timesheet
  When The user click on Add timesheet btn on dashboard
  And Wait for time entry page to load
  Then Add one hour of out time to the event
  And Click ok after adding out time event
  And Save timeevent
  And Verify week total time from dashboard after adding timesheet