@Settings
Feature: Regression scenarios 

@Setting @MOB-4789  @MOB-4791  @AndroidRegression @iOSRegression
Scenario: Verify calendar link in substitute Menu 
	When the user launches the app 
	Then The user click on Get Started Button
	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button 
	Then The substitute navigates to dashboard page
	When the user clicks on Menu tab
	When Click on calendar in menu link
	And verify calendar the search result "searchText"
	
@Setting @MOB-4806  @MOB-4805  @AndroidRegression @iOSRegression
Scenario: Verify Job List tab bar in substitutes page 
	When the user launches the app 
	Then The user click on Get Started Button
	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button 
	Then The substitute navigates to dashboard page
	And Click on the Available Jobs
	Then Verify available job tab
	And Verify accepted job tab

@Setting @MOB-4809  @MOB-4810 @AndroidRegression @iOSRegression
Scenario: Verify that substitute user is allowed to submit diagnostic data 
	When the user launches the app 
	Then The user click on Get Started Button
	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button 
	Then The substitute navigates to dashboard page
	When the user clicks on Menu tab
	And Long press on Frontline Logo
	And User click on the send Diagnostics btn
	Then Verify the toast message of sent diagnostic

@Setting @MOB-4803 @AndroidRegression @iOSRegression
Scenario: Verify a substitute can view accepted job in-app Calendar
	When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs4" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
	When Substitute accepts the job with required details "AutomationSubsJobOperations4" "APIXrefIDOrg1"
	When The user waits and launches the app
	Then The user click on Get Started Button
	And Enter username "AutomationSubsJobOperations4" and password and click on Sign In button
	Then The substitute navigates to dashboard page
	When the user clicks on Menu tab
	When Click on calendar in menu link
	And verify calendar the search result "searchText"
	Then Choose the required month "upcoming day"
	And Click on the event day "upcoming day"
	And Tap on substitutes job event
	Then Validate the job detail page "upcoming day"

@Setting @MOB-4808  @MOB-4807 @AndroidRegression @iOSRegression
Scenario: Verify that a substitute can view next scheduled Job widget
	 When the user launches the app 
	 Then The user click on Get Started Button
	 Then the user is taken to the Login Page
#	 And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button
	And Enter username "stageSubAnuj" and password and click on Sign In button
	 Then The substitute navigates to dashboard page
	 Then The user moves to Next Scheduled Job widget and verify it
	
	#Remove   
@Setting @MOB-4796  @MOB-4797 @done
Scenario: Verify that Unlock Code page is removed from the application
	When the user launches the app 
	Then The user click on Get Started Button
	Then the user is taken to the Login Page
	And the user verify that Unlock code page should not displayed

@Setting @MOB-6023  @MOB-6024 @multiOrg @AndroidRegression @iOSRegression
Scenario: Verify role picker option should not displayed when user account has only one role
    When the user launches the app 
	Then The user click on Get Started Button
	And Enter username "AutomationSubMutiOrg" and password and click on Sign In button 
    Then the user is presented with the org picker
	Then The user choose the one organization
    Then The substitute navigates to dashboard page
	And Click on switch btn
	Then The user choose the second organization
	Then The substitute navigates to dashboard page

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
	Then Add one hour to in time of the event
	And Click ok after adding out time event
	And Get the changes in time
	And The user minimize and relaunch the application
	And Verify in time after relaunching application

@MOB-6665 @MOB-6666 @AndroidRegression @iOSRegression
Scenario: Verify substitute user can validate Feedback form heading
	When the user launches the app
	Then The user click on Get Started Button
	And Enter username "AutomationSubsMOB-7775" and password and click on Sign In button
	Then The substitute navigates to dashboard page
	When the user clicks on Menu tab
	Then The user clicks on Feedback
	Then Validate Feedback Header

@MOB-8595 @AndroidRegression @MOB-8725 @iOSRegression
Scenario: Verify employee user is able to create multiday absence
	When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-8595" for "upcoming day" and delete them
	When the user launches the app
	Then The user click on Get Started Button
	And Enter username "AutomationEmployeeMOB-8595" and password and click on Sign In button
	Then the user navigates to dashboard page
	And click on the create absences
	When Select absence reason and click on next btn
	And Select absence day "upcoming day"  "1"
	And Select absence day "upcoming day"  "2"
	And click on next btn
	And Select absence duration and click on next btn
	And Select if the substitute required and click on next btn
	And Click on submit absence
	Then Verify the absence creation pop up
