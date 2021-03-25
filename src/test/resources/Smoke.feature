@smoke
Feature: Smoke scenarios 

@MOB-4227 @MOB-4229 @AndroidSmoke @iOSSmoke @MOB-4228 @MOB-4230 @AndroidRegression @iOSRegression
Scenario: Verify user remains login when application sent to background or gets relaunched 
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter username "AutomationEmployeeMOB-4227" and password and click on Sign In button
	Then the user navigates to dashboard page
	And The user minimize and relaunch the application 
	Then the user navigates to dashboard page
	And The user kill and relaunch the application 
	Then the user navigates to dashboard page

@MOB-4269 @MOB-4270 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify the user toggle the Dark mode 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button
	Then the substitute navigates to dashboard page 
#	When the user clicks on Menu tab and click on Settings
	When the user clicks on Menu tab
	And Click on Settings
	Then Verify the dark mode btn is OFF
	When Toggle the Dark Mode
	And Logout from app
#	Then Verify the dark mode btn and toggle the Dark Mode and Logout from app
	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button
	Then the substitute navigates to dashboard page
	When the user clicks on Menu tab
	And Click on Settings
#	When the user clicks on Menu tab and click on Settings
#	Then Verify the dark mode button
	Then Verify the dark mode button is ON

##	//change leaves through aPI or web, then check the balance Not valid for ios
@MOB-4255 @AndroidSmoke @MOB-4256 @iOSSmoke @AndroidRegression
Scenario: View leave balances and check available days
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter username "AutomationEmployeeMOB-4255" and password and click on Sign In button
	Then the user navigates to dashboard page
	When click on Available Leave Balances
	Then View leave balance screen
#	And click on Available Leave Balances and view leave balances
	Then verify available days

@MOB-4233 @MOB-4235 @AndroidSmoke @MOB-4234 @MOB-4236 @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Entered text should be searchable when user perform search operation 
	When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4237" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter username "AutomationEmployeeMOB-4233" and password and click on Sign In button
	Then the user navigates to dashboard page
	When the user clicks on Menu tab
#	When click on menu bar
	Then Enter search text "searchText"
	When Click on calendar search result
#	Then enter the search text in bar and click on result
	And verify calendar the search result "searchText"
#	Then click on the home button to navigate back to dashboard
	Then Navigate to dashboard
	Then the user navigates to dashboard page
	When the user clicks on Menu tab
	Then Enter search text "absenceKeyword"
#	Then enter the absence search text in bar
	And click the absence search result
	Then verify the absence detail page

##	//text validation //one admin user is missing
@MOB-4257 @MOB-4265 @MOB-4267 @AndroidSmoke @MOB-4258 @MOB-4266 @MOB-4268 @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify a user can visit inbox and view messages 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username "AutomationSubsMOB-4265" and password and click on Sign In button
	Then the substitute navigates to dashboard page
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
	And Enter username "AutomationAdminMOB-4267" and password and click on Sign In button
	Then the user navigates to dashboard page
	When click on the inbox
	And Verify inbox screen is display
	And Click on inbox alert
	Then Verify the inbox message

@smoke @MOB-4243 @MOB-4244 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify an employee should be able to clock in and clock out
	When Verify if timesheet present for an employee and delete it using information "AutomationEmployeeMOB-4243" "APIWorkerID_MOB-4243" "APIOrgID" "APILoginID" "current day"
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter employee username "AutomationEmployeeMOB-4243" and password and click on Sign In button
	Then the user navigates to dashboard page
	When Employee clicks on the clockin btn 
	Then the user clocks out through timesheet
	
 @MOB-4263 @MOB-4264 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify an employee can submit weekly timesheet and then undo a timesheet 
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter employee username "AutomationEmployeeMOB-4263" and password and click on Sign In button
	Then the user navigates to dashboard page
	When employee clicks on the timesheet widget
	And Add a new timesheet
	Then Verify total time of the Week
	Then click on submit timesheet option
	And undo the timesheet
	
 @MOB-4259 @AndroidSmoke @MOB-4260 @iOSSmoke @AndroidRegression
Scenario: Verify an employee can view week of timesheets 
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter employee username "AutomationEmployeeMOB-4263" and password and click on Sign In button
	Then the user navigates to dashboard page
	And click on timesheets widget and view timesheets 

@MOB-4261 @AndroidSmoke @MOB-4262 @iOSSmokes @AndroidRegression @iOSRegression
Scenario: Verify an employee can edit and delete the time from the timesheet 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username "AutomationEmployeeMOB-4261" and password and click on Sign In button
	Then the user navigates to dashboard page
	When employee clicks on the timesheet widget 
	And open the past day timesheet and add a new time sheet 
	Then user edits the timesheet 
	And Delete the timesheet 

@MOB-4277 @AndroidSmoke @MOB-4278 @iOSSmoke @AndroidRegression @iOSRegression
Scenario: The user with directory access can view the full directory list and details 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter admin username "AutomationAdminMOB-4277" and password and click on Sign In button
	Then the user navigates to dashboard page
	And click on People widget 
	When search for a person 
	Then user details are displayed 
	
@MOB-4242 @MOB-4240 @MOB-4239 @MOB-4241 @iOSSmoke @AndroidSmoke @AndroidRegression
Scenario: Need to rearrange the widgets on the dashboard 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username "AutomationSubsMOB-4265" and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When Click on reorder widget 
	And Rearrange the widets
	Then Verify the order of widgets and footers present 
	And verify the order of widgets 
	And  logouts out from the application 
	And Enter employee username "AutomationEmployeeMOB-4257" and password and click on Sign In button
	Then the user navigates to dashboard page
	When Click on reorder widget 
	And Rearrange the widets
	Then Verify the order of widgets and footers present 
	And verify the order of widgets 
	And  logouts out from the application 
	And Enter admin username "AutomationAdminMOB-4267" and password and click on Sign In button 
	Then the admin navigates to dashboard page 
	When Click on reorder widget 
	And Rearrange the widets
	Then Verify the order of widgets and footers present 
	And verify the order of widgets 

@MOB-4245 @MOB-4246 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify employee can create absence
	When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-4245" for "next day" and delete them
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username "AutomationEmployeeMOB-4245" and password and click on Sign In button
	Then the user navigates to dashboard page
	And click on the create absences 
	When select reason date length summary for "next day"
	Then submit absence and verify the alert
	
@MOB-4237 @MOB-4238 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify created absence is displayed in calendar
	When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4237" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username "AutomationEmployeeMOB-4237" and password and click on Sign In button
	Then the user navigates to dashboard page
	Then Tap on the day of created absence for "next day" in the app Calendar
	And Verify the absence in Calendar
	
@MOB-4247 @MOB-4248 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify user is able to edit the absence
	When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4247" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username "AutomationEmployeeMOB-4247" and password and click on Sign In button
	Then the user navigates to dashboard page
	Then Tap on the day of created absence for "next day" in the app Calendar
	When Click on edit btn and edit the absence for "next day"
	Then Verify the absence details

	@MOB-4249 @AndroidSmoke @MOB-4250 @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify that admin creates an absence for another user 
	When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-4249" for "next day" and delete them
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter admin username "AutomationAdminMOB-4249" and password and click on Sign In button
	Then the user navigates to dashboard page
	And click on the absences then add absence
	When enter "Emp-4249" select reason date length summary for "next day"
	Then submit absence and verify the alert
	 
	@AndroidSmoke @iOSSmoke @MOB-4251 @MOB-4252 @MOB-4253 @MOB-4254 @AndroidRegression @iOSRegression
Scenario: Verify admin assigns substitute and also approve absence
	When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4249" for "current day" with "APISchoolID" "APIReasonID" and delete the existing ones
	When the user launches the app
	Then the user click on Get Started Button
	And Enter admin username "AutomationAdminMOB-4251" and password and click on Sign In button
	Then the user navigates to dashboard page
	And Select an unfilled and unassigned absence for "next day"
	When click on Tap to Assign and select Assign substitute
	And click Assign again to confirm
	Then click on approve btn approve a job
	And verify absences page is displayed