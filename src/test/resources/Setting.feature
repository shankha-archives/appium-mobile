@Settings
Feature: Regression scenarios 

@Setting @MOB-4789  @MOB-4791  @AndroidRegression @iOSRegression
Scenario: Verify calendar link in substitute Menu 
	When the user launches the app 
	Then The user click on Get Started Button
	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button 
	Then The substitute navigates to dashboard page
#	When click on menu and tap the Calendar link
	When the user clicks on Menu tab
	When Click on calendar search result
	And verify calendar the search result "searchText"
	
@Setting @MOB-4806  @MOB-4805  @AndroidRegression @iOSRegression
Scenario: Verify Job List tab bar in substitutes page 
	When the user launches the app 
	Then The user click on Get Started Button
	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button 
	Then The substitute navigates to dashboard page
	When click on Avalaible Jobs link
	Then Verify available job tab
	And Verify accepted job tab
#	Then verify Job List tab bar for available and accepted jobs

@Setting @MOB-4809  @MOB-4810 @AndroidRegression @iOSRegression
Scenario: Verify that substitute user is allowed to submit diagnostic data 
	When the user launches the app 
	Then The user click on Get Started Button
	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button 
	Then The substitute navigates to dashboard page
	When the user clicks on Menu tab
#	When click on menu bar
	And Long press on Frontline Logo
	And User click on the send Diagnostics btn
	Then Verify the toast message of sent diagnostic
#	And Long press on Frontline Logo at bottom of the screen
#	Then User click on the send Diagnostics option and click on Okay button
		
  ##Accept job through API -> only very through calendar
@Setting @MOB-4803 @AndroidRegression @iOSRegression
Scenario: Verify a substitute can view accepted job in-app Calendar
	When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs4" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
	When Substitute accepts the job with required details "AutomationSubsJobOperations4" "APIXrefIDOrg1"
	When The user waits and launches the app
	Then The user click on Get Started Button
	And Enter username "AutomationSubsJobOperations4" and password and click on Sign In button
	Then The substitute navigates to dashboard page
	When the user clicks on Menu tab
#	When click on menu bar
	When Click on calendar search result
#	Then enter the search text in bar and click on result
	And verify calendar the search result "searchText"
	Then Choose the required month "next day"
	And Click on the event day "next day"
	And Tap on substitutes job event
	Then Verify the job event details "next day"
#	Then go to calendar and view the accepted job for "next day"
  
@Setting @MOB-4808  @MOB-4807 @AndroidRegression @iOSRegression
Scenario: Verify that a substitute can view next scheduled Job widget
	 When the user launches the app 
	 Then The user click on Get Started Button
	 Then the substitute user is taken to the Login Page 
	 And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button 
	 Then The substitute navigates to dashboard page
	 Then The user moves to Next Scheduled Job widget and verify it
	
	#Remove   
@Setting @MOB-4796  @MOB-4797 @done
Scenario: Verify that Unlock Code page is removed from the application
	When the user launches the app 
	Then The user click on Get Started Button
	Then the substitute user is taken to the Login Page
	And the user verify that Unlock code page should not displayed
	
	#verify for both orgs
@Setting @MOB-6023  @MOB-6024 @multiOrg @AndroidRegression @iOSRegression
Scenario: Verify role picker option should not displayed when user account has only one role
    When the user launches the app 
	Then The user click on Get Started Button
	And Enter username "AutomationSubMutiOrg" and password and click on Sign In button 
    Then the user is presented with the org picker
#    When Select the Organization
	Then The user choose the one organization
    Then The substitute navigates to dashboard page
#    When click on switch
	And Click on switch btn
	Then The user choose the second organization
	Then The substitute navigates to dashboard page
	
#	#remove
#@Setting @MOB-6033 @MOB-6034  @done
#Scenario: Verify that in employee user no upcoming absences tab is renamed as Denied tab in available Leave Balances widget
#	When the user launches the app
#	Then the user click on Get Started Button
#	And Enter employee username "AutomationEmployeeMOB-4255" and password and click on Sign In button
#	Then the employee navigates to dashboard page
#	And click on Available Leave Balances and view leave balances
#	Then click and verify the Denied panel
	
@Setting @MOB-6019 @AndroidRegression
Scenario: Verify an employee can view same Intime event value in Timesheet even after relaunching the app
	When the user launches the app
	Then The user click on Get Started Button
	And Enter username "AutomationEmployeeMOB-4263" and password and click on Sign In button
	Then the user navigates to dashboard page
	When The user navigates to timesheet widget
	And Select the current day
	And Click on add new time event
	And Wait for time entry page to load
#	Then Add one hour of out time to the event
	Then Add one hour to in time of the event
	And Click ok after adding out time event
	And Get the changes in time
#	When employee clicks on the timesheet widget
#	Then click on add timesheet and change InTime
	And The user minimize and relaunch the application
	And Verify in time after relaunching application
#	Then Verify that InTime should not changes

##Remove ?// covered in dark mode
#@Setting @MOB-6025 @done
#Scenario: Verify that application is able to open Login page on app startup or log-off
#	When the user launches the app
#	Then the user click on Get Started Button
#	Then The user verifies that Login page is displayed
#	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button
#	Then the substitute navigates to dashboard page
#	And  logouts out from the application
#	Then Verify that Login page is displayed after logout
#
#	#Remove // already covered in assign absence
#@Setting @MOB-6030  @done
#Scenario: Verify application does not crashe after tapping on todays absence tab in admin user
#	When the user launches the app
#	Then the user click on Get Started Button
#	And Enter admin username and password and click on Sign In button
#	Then the admin navigates to dashboard page
#	When Click on add Absence Widget
#	Then Click on any created absence and verify if crash happens
#
#	# remove covered in @MOB-4251
#@Setting @MOB-6021 @done
#Scenario: Verify absences should be visible in Absences Today widget
#	When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-4257" for "current day" and delete them
#	When the user launches the app
#	Then the user click on Get Started Button
#	And Enter username "AutomationAdminMOB-6021" and password and click on Sign In button
#	Then the admin navigates to dashboard page
#	And click on the absences then add absence
#	When enter "Emp-4257" select reason date length summary for "current day"
#	Then submit absence and verify the alert
#	Then Click on View Absence and move to dashboard
#	Then Move to absence today widget and verify the absence
#	Then Verify that absences are visible