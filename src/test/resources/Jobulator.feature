@jobs
Feature: Jobulator scenarios

  @AndroidRegression @MOB-3325 @iOSRegression
  Scenario: Verify substitute success message while accepting job is dismissed revealing accepted job details page
   	When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs" for "next day" and delete the existing ones
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
  When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs2" for "next day" and delete the existing absence
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
   When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs3" for "next day" and delete the existing ones
    When the user waits and launches the app 
	Then the user click on Get Started Button
    And Enter username "AutomationSubsJobOperations3" and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And click on the Available Jobs and view job list
    And Click on the job "CreateJob3" and accept it
    Then click okay on Success Message overlay
    And visit available jobs page again
    Then verify if accepted job is still present
   
   @MOB-3681
  Scenario: Login with valid credentials
    When the user launches the app 
		Then the user click on Get Started Button
    And Enter multiorg multirole username and password and click on Sign In button
    Then the user choose the sub user of one org and extract the jobs
    When the user choose the sub user of another org and extract the jobs
    Then verify the jobs
      
   @MOB-3683
  Scenario: Feature flags access- Multi District User
    When the user launches the app 
		Then the user click on Get Started Button
    And Enter username and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And the dashboard displays all available jobs from all districts
      
    @MOB-4173 @MOB-4172 @iOSRegression
  Scenario: Verify that substitute is able to view job widget and job list
   When the user launches the app
		Then the user click on Get Started Button
    And Enter username "AutomationSubsJobOperations" and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And click on the Available Jobs and view job list
  