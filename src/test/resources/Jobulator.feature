@jobs
Feature: Jobulator scenarios

  @regression @jobs @MOB-3325 @iOS @done @Android
  Scenario: Verify the success pop up message on accepting a job
 	  When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs" for "next day" and delete the existing ones
    When the user launches the app 
		Then the user click on Get Started Button
    And Enter username "AutomationSubsJobOperations" and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And click on the Available Jobs and view job list
    And Click on the job and accept it
    Then the Success Message overlay is displayed
    When I click Okay
    Then Success Message is dismissed revealing accepted job details page
      
  @regression @jobs @MOB-3324 @MOB-3326 @done @Android @iOS
  Scenario: Verify the success Confirmation Number on accepting a job
  When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs" for "next day" and delete the existing ones
    When the user launches the app 
		Then the user click on Get Started Button
    And Enter username "AutomationSubsJobOperations" and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And click on the Available Jobs and view job list
    And Click on the job and accept it
    Then the Success Message overlay is displayed
    When I click Okay
    Then Success Message is dismissed revealing accepted job details page
    Then Verify the confirmation number present on the job details page
      
  @regression @jobs @MOB-4174 @done @Android @iOS
  Scenario: Verify accepted job is Removeed from job list
   When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs" for "next day" and delete the existing ones
    When the user launches the app 
		Then the user click on Get Started Button
    And Enter username "AutomationSubsJobOperations" and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And click on the Available Jobs and view job list
    And Click on the job and accept it
    Then click okay on Success Message overlay
    And visit available jobs page again
    Then verify if accepted job is still present
   
  @regression @MOB-3681
  Scenario: Login with valid credentials
    When the user launches the app 
		Then the user click on Get Started Button
    And Enter multiorg multirole username and password and click on Sign In button
    Then the user choose the sub user of one org and extract the jobs
    When the user choose the sub user of another org and extract the jobs
    Then verify the jobs
      
  @regression @MOB-3683
  Scenario: Feature flags access- Multi District User
    When the user launches the app 
		Then the user click on Get Started Button
    And Enter username and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And the dashboard displays all available jobs from all districts
      
  @regression @jobs @MOB-4173 @MOB-4172 @Android @iOS @done
  Scenario: Verify that substitute is able to view job widget and job list
   When the user launches the app 
		Then the user click on Get Started Button
    And Enter username "AutomationSubsJobOperations" and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And click on the Available Jobs and view job list
  