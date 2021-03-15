@jobs
Feature: Jobulator scenarios

  @AndroidRegression @MOB-3325 @iOSRegression
  Scenario: Verify substitute success message while accepting job is dismissed revealing accepted job details page
   	When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When the user waits and launches the app 
	  Then the user click on Get Started Button
    And Enter username "AutomationSubsJobOperations" and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And click on the Available Jobs and view job list
    And Click on the job "CreateJob" and accept it
    Then the Success Message overlay is displayed
    When Clicked on Okay
    Then Success Message is dismissed revealing accepted job details page
      
  @AndroidRegression  @MOB-3324 @MOB-3326 @iOSRegression
  Scenario: Verify substitute views the success Confirmation Number on accepting a job
  	When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs2" for "next day" with "APISchoolID" "APIReasonID" and delete the existing absence
    When the user waits and launches the app
    Then the user click on Get Started Button
    And Enter username "AutomationSubsJobOperations2" and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And click on the Available Jobs and view job list
    And Click on the job "CreateJob2" and accept it
    Then the Success Message overlay is displayed
    When Clicked on Okay
    Then Success Message is dismissed revealing accepted job details page
    Then Verify the confirmation number present on the job details page
      
  @AndroidRegression  @MOB-4174 @iOSRegression
  Scenario: Verify substitute cannot view accepted job in job list
   	When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs3" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When the user waits and launches the app 
		Then the user click on Get Started Button
    And Enter username "AutomationSubsJobOperations3" and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And click on the Available Jobs and view job list
    And Click on the job "CreateJob3" and accept it
    Then click okay on Success Message overlay
    And visit available jobs page again
    Then verify if accepted job is still present
  
@MOB-3681 @AndroidRegression @iOSRegression
  Scenario: Verify that substitute user is able to view all job information from all organizations
  	When Create absence for employee "APILoginID_GLorg5" with workerid "APIWorkerID_MOB-3681_GLorg5" for "next day" with "APISchoolID_GLorg5" "APIReasonID_GLorg5" and delete the existing ones
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-3681" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When the user waits and launches the app
    Then the user click on Get Started Button
    When Enter username "AutomationSubMutiOrg" and password and click on Sign In button
    Then the user choose the sub role of one org and verify the created jobs
    When the user choose the sub role of another org and verify the created jobs
      
@MOB-3683 @AndroidRegression @iOSRegression
  Scenario: Verify that substitute user is able to view jobs of multiple districts
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-3683_District1" for "next day" with "APISchoolID_ChildCare" "APIReasonID" and delete the existing ones
  	When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-3683_District2" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
  	When the user waits and launches the app 
		Then the user click on Get Started Button
    When Enter username "AutomationSubsMOB-3683" and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And the dashboard displays all available jobs from all districts
      
@MOB-4173 @MOB-4172 @Done @AndroidRegression @iOSRegression
  Scenario: Verify that substitute is able to view job widget and jobs in job list
  	When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4173" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
  	When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4172" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
  	When the user waits and launches the app
	Then the user click on Get Started Button
  	And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button
  	Then the substitute navigates to dashboard page
  	And click on the Available Jobs and view job list
  	And Verify the created jobs are available in the list
