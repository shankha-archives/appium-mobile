@smoke
Feature: Smoke scenarios

  @MOB-4227 @MOB-4229 @AndroidSmoke @iOSSmoke @MOB-4228 @MOB-4230 @AndroidRegression @iOSRegression
  Scenario: Verify user remains login when application sent to background or gets relaunched
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationEmployeeMOB-4227" and password and click on Sign In button
    Then the user navigates to dashboard page
    And The user minimize and relaunch the application
    Then the user navigates to dashboard page
    And The user kill and relaunch the application
    Then the user navigates to dashboard page

  @MOB-4269 @MOB-4270 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
  Scenario: Verify the user toggle the Dark mode
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    When the user clicks on Menu tab
    And Click on Settings
    Then Verify the dark mode btn is OFF
    When Toggle the Dark Mode
    And Logout from app
    And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    When the user clicks on Menu tab
    And Click on Settings
    Then Verify the dark mode button is ON

  @MOB-4255 @AndroidSmoke @MOB-4256 @iOSSmoke @AndroidRegression @iOSRegression
  Scenario: View leave balances and check available days
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationEmployeeMOB-4255" and password and click on Sign In button
    Then the user navigates to dashboard page
    When click on Available Leave Balances
    Then View leave balance screen
    Then verify available days

  @MOB-4233 @MOB-4235 @AndroidSmoke @MOB-4234 @MOB-4236 @iOSSmoke @AndroidRegression @iOSRegression
  Scenario: Entered text should be searchable when user perform search operation
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4237" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationEmployeeMOB-4233" and password and click on Sign In button
    Then the user navigates to dashboard page
    When the user clicks on Menu tab
    Then Enter search text "searchText"
    When Click on calendar search result
    And verify calendar the search result "searchText"
    Then Navigate to dashboard
    Then the user navigates to dashboard page
    When the user clicks on Menu tab
    Then Enter search text "absenceKeyword"
    And click the absence search result
    Then verify the absence detail page

  @MOB-4257 @MOB-4265 @MOB-4267 @AndroidSmoke @MOB-4258 @MOB-4266 @MOB-4268 @iOSSmoke @AndroidRegression @iOSRegression
  Scenario: Verify a user can visit inbox and view messages
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsMOB-4265" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    When click on the inbox
    And Verify inbox screen is display
    And Click on inbox alert
    Then Verify the inbox message
    When the user clicks on Menu tab
    And Click on Settings
    And Logout from app
    And Enter username "AutomationEmployeeMOB-4257" and password and click on Sign In button
    Then the user navigates to dashboard page
    When click on the inbox
    And Verify inbox screen is display
    And Click on inbox alert
    Then Verify the inbox message
    When the user clicks on Menu tab
    And Click on Settings
    And Logout from app
    And Enter username "AutomationAdmin" and password and click on Sign In button
    Then the user navigates to dashboard page
    When click on the inbox
    And Verify inbox screen is display
    And Click on inbox alert
    Then Verify the inbox message

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
    When Decline review pop up
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

  @MOB-4277 @AndroidSmoke @MOB-4278 @iOSSmoke @AndroidRegression @iOSRegression
  Scenario: The user with directory access can view the full directory list and details
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationAdminMOB-4277" and password and click on Sign In button
    Then the user navigates to dashboard page
    And click on People widget
    When Enter the last name of the person to be searched
    And Click on the searched person
    Then Verify user details are displayed

  @MOB-4242 @MOB-4240 @MOB-4239 @MOB-4241 @iOSSmoke @AndroidSmoke @AndroidRegression
  Scenario: Need to rearrange the widgets on the dashboard
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsMOB-4265" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    When Fetch the list of widgets before reordering
    When Click on reorder widget button
    And Change the widget order
    And Click on save arranged widgets button
    Then the user navigates to dashboard page
    When Fetch the list of widgets after reordering
    Then verify the order of widgets
    When the user clicks on Menu tab
    And Click on Settings
    And Logout from app
    And Enter username "AutomationEmployeeMOB-4257" and password and click on Sign In button
    Then the user navigates to dashboard page
    When Fetch the list of widgets before reordering
    When Click on reorder widget button
    And Change the widget order
    And Click on save arranged widgets button
    Then the user navigates to dashboard page
    When Fetch the list of widgets after reordering
    Then verify the order of widgets
    When the user clicks on Menu tab
    And Click on Settings
    And Logout from app
    And Enter username "AutomationAdminMOB-4267" and password and click on Sign In button
    Then the user navigates to dashboard page
    When Fetch the list of widgets before reordering
    When Click on reorder widget button
    And Change the widget order
    And Click on save arranged widgets button
    Then the user navigates to dashboard page
    When Fetch the list of widgets after reordering
    Then verify the order of widgets

  @MOB-4245 @MOB-4246 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
  Scenario: Verify employee can create absence
    When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-4245" for "upcoming day" and delete them
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationEmployeeMOB-4245" and password and click on Sign In button
    Then the user navigates to dashboard page
    And click on the create absences
    When Select absence reason and click on next btn
    And Select absence day "upcoming day"  "1"
    And click on next btn
    And Select absence duration and click on next btn
    And Select if the substitute required and click on next btn
    And Click on submit absence
    Then Verify the absence creation pop up

  @MOB-4237 @MOB-4238 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
  Scenario: Verify created absence is displayed in calendar
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4237" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationEmployeeMOB-4237" and password and click on Sign In button
    Then the user navigates to dashboard page
    When the user clicks on Menu tab
    When Click on calendar in menu link
    And verify calendar the search result "searchText"
    Then Choose the required month "next day"
    And Click on the event day "next day"
    And Tap on the event title
    And Verify absence confirmation number

  @MOB-4247 @MOB-4248 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
  Scenario: Verify user is able to edit the absence
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4247" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationEmployeeMOB-4247" and password and click on Sign In button
    Then the user navigates to dashboard page
    When the user clicks on Menu tab
    When Click on calendar in menu link
    And verify calendar the search result "searchText"
    Then Choose the required month "next day"
    And Click on the event day "next day"
    And Tap on the event title
    When Click on edit absence
    And Verify absence reason page and click next
    And Edit absence day "next day" and click next
    And Verify absence duration and click next
    And Select if the substitute required and click on next btn
    And Click on save edited absence
    Then Click on view absence btb
    And Verify the edited absence details

  @MOB-4249 @AndroidSmoke @MOB-4250 @iOSSmoke @AndroidRegression @iOSRegression
  Scenario: Verify that admin creates an absence for another user
    When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-4249" for "upcoming day" and delete them
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationAdminMOB-4249" and password and click on Sign In button
    Then the user navigates to dashboard page
    When Click on absences today widget
    And Click on add absence btn
    And Enter and select employee name "Emp-4249" and click on next
    When Select absence reason and click on next btn
    And Select absence day "upcoming day"  "1"
    And click on next btn
    And Select absence duration and click on next btn
    And Select if the substitute required and click on next btn
    And Click on submit absence
    Then Verify the absence creation pop up

  @AndroidSmoke @iOSSmoke @MOB-4251 @MOB-4252 @MOB-4253 @MOB-4254 @AndroidRegression @iOSRegression
  Scenario: Verify admin assigns substitute and also approve absence
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4249" for "current day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationAdminMOB-4251" and password and click on Sign In button
    Then the user navigates to dashboard page
    When Click on absences today widget
    And Select an unfilled and unassigned absence
    And Click on Tap to Assign link
    And Select Substitute to assign absence
    And Click Assign again to confirm
    Then Click on approve btn and click ok
    And verify absences page is displayed