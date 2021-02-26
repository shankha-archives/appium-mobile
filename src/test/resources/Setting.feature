@Regression
Feature: Regression scenarios 

@Setting @MOB-4789 @AndroidRegression @MOB-4791 @iOSRegression @Regression @done 
Scenario: Verify calendar link in substitute Menu 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on menu and tap the Calendar link 
	Then verify the calendar 
	
@Setting @MOB-4806 @AndroidRegression @MOB-4805 @iOSRegression @Regression @done 
Scenario: Verify Job List tab bar in substitutes page 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on Avalaible Jobs link 
	Then verify Job List tab bar for available and accepted jobs 
	
@Setting @MOB-4809 @AndroidRegression @MOB-4810 @iOSRegression @Regression @done 
Scenario: Verify that substitute user is allowed to submit diagnostic data 
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on menu bar 
	And Long press on Frontline Logo at bottom of the screen 
	Then User click on the send Diagnostics option and click on Okay button 
		
@Setting @MOB-4803 @AndroidRegression @Regression @done 
Scenario: Verify a substitute can view accepted job in-app Calendar
	When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs4" for "next day" and delete the existing ones 
	When the user waits and launches the app  
	Then the user click on Get Started Button 
	And Enter username "AutomationSubsJobOperations4" and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on job widget and select the job "CreateJob4"
	And accept the job
	Then go to calender and view the accepted job 
  
@Setting @MOB-4808 @AndroidRegression @MOB-4807 @iOSRegression @Regression @done 
Scenario: Verify that a substitute can view next scheduled Job widget
	 When the user launches the app 
	 Then the user click on Get Started Button
	 Then the substitute user is taken to the Login Page 
	 And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button 
	 Then the substitute navigates to dashboard page 
	 Then The user moves to Next Scheduled Job widget and verify it
	   
@Setting @MOB-4796 @AndroidRegression @MOB-4797 @iOSRegression @Regression @done 
Scenario: Verify that Unlock Code page is removed from the application
	When the user launches the app 
	Then the user click on Get Started Button
	Then the substitute user is taken to the Login Page
	And the user verify that Unlock code page should not displayed
	
@Setting @MOB-6023 @AndroidRegression @MOB-6024 @iOSRegression @Regression @multiOrg @done
Scenario: Verify role picker option should not displayed when user account has only one role
    When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username "AutomationSubMutiOrg" and password and click on Sign In button 
    Then the user is presented with the org picker
    When Select the Organization
    Then the substitute navigates to dashboard page
    When click on switch
    Then the user is presented with the org picker
	   
@Setting @MOB-6033 @iOSRegression @Regression @MOB-6034 @AndroidRegression @done 
Scenario: Verify that in employee user no upcoming absences tab is renamed as Denied tab in available Leave Balances widget
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username "AutomationEmployeeMOB-4255" and password and click on Sign In button 
	Then the employee navigates to dashboard page
	And click on Available Leave Balances and view leave balances
	Then click and verify the Denied panel
	
@Setting @MOB-6019 @AndroidRegression @Regression @done 
Scenario: Verify an employee can view same Intime event value in Timesheet even after relaunching the app
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter employee username "AutomationEmployeeMOB-4263" and password and click on Sign In button 
	Then the employee navigates to dashboard page
	When employee clicks on the timesheet widget
	Then click on add timesheet and change InTime
	And The user minimize and relaunch the application
	Then Verify that InTime should not changes

@Setting @MOB-6025 @iOSRegression @Regression @done 
Scenario: Verify that application is able to open Login page on app startup or log-off
	When the user launches the app 
	Then the user click on Get Started Button
	Then The user verifies that Login page is displayed 
	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	And  logouts out from the application
	Then Verify that Login page is displayed after logout
	
@Setting @MOB-6030 @AndroidRegression @done 
Scenario: Verify application does not crashe after tapping on todays absence tab in admin user
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter admin username and password and click on Sign In button 
	Then the admin navigates to dashboard page 
	When Click on add Absence Widget
	Then Click on any created absence and verify if crash happens 

@Setting @MOB-6021 @AndroidRegression @Regression @done
Scenario: Verify absences should be visible in Absences Today widget
	When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-4257" for "current day" and delete them
	When the user launches the app 
	Then the user click on Get Started Button 
	And Enter username "AutomationAdminMOB-6021" and password and click on Sign In button 
	Then the admin navigates to dashboard page
	And click on the absences then add absence
	When enter "Emp-4257" select reason date length summary for "current day"
	Then submit absence and verify the alert
	Then Click on View Absence and move to dashboard
	Then Move to absence today widget and verify the absence
	Then Verify that absences are visible
