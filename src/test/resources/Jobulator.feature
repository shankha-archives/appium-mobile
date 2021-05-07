@jobs
Feature: Jobulator scenarios

  @AndroidRegression @MOB-3325 @iOSRegression
  Scenario: Verify substitute success message while accepting job is dismissed revealing accepted job details page
    When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When The user waits and launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsJobOperations" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    And Click on the Available Jobs
    And View job list
    And Click on the job "CreateJob"
    And accept the job
    Then the Success Message overlay is displayed
    When Clicked on Okay
    Then Success Message is dismissed revealing accepted job details page

  @AndroidRegression  @MOB-3324 @MOB-3326 @iOSRegression
  Scenario: Verify substitute views the success Confirmation Number on accepting a job
    When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs2" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When The user waits and launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsJobOperations2" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    And Click on the Available Jobs
    And View job list
    And Click on the job "CreateJob2"
    And accept the job
    Then the Success Message overlay is displayed
    When Clicked on Okay
    Then Success Message is dismissed revealing accepted job details page
    Then Verify the confirmation number present on the job details page

  @AndroidRegression  @MOB-4174 @iOSRegression
  Scenario: Verify substitute cannot view accepted job in job list
    When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs3" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When The user waits and launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsJobOperations3" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    And Click on the Available Jobs
    And View job list
    And Click on the job "CreateJob3"
    And accept the job
    Then the Success Message overlay is displayed
    When Clicked on Okay
    And Navigate to dashboard
    And Click on the Available Jobs
    And View job list
    Then Validate job "CreateJob3" is not visible in Job List

  @MOB-3681 @AndroidRegression @iOSRegression
  Scenario: Verify that substitute user is able to view all job information from all organizations
    When Create absence for employee "APILoginID_GLorg5" with workerid "APIWorkerID_MOB-3681_GLorg5" for "next day" with "APISchoolID_GLorg5" "APIReasonID_GLorg5" and delete the existing ones
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-3681" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When The user waits and launches the app
    Then The user click on Get Started Button
    When Enter username "AutomationSubMutiOrg" and password and click on Sign In button
    Then The user choose the one organization
    Then The substitute navigates to dashboard page
    When Click on the Available Jobs
    And Verify job list on Jobs page
    Then Verify the created jobs "AutomationEmp 3681" is present
     And Verify school "schoolNameOrg4" is associated with "AutomationEmp 3681"
    Then Verify the created jobs "AutomationEmpOrg5 3681" is present
    And Verify school "schoolNameOrg5" is associated with "AutomationEmpOrg5 3681"
     When Navigate to dashboard
    And Click on switch btn
    Then The user choose the second organization
    Then The substitute navigates to dashboard page
    When Click on the Available Jobs
    And Verify job list on Jobs page
    And View job list
    Then Verify the created jobs "AutomationEmp 3681" is present
    And Verify school "schoolNameOrg4" is associated with "AutomationEmp 3681"
    Then Verify the created jobs "AutomationEmpOrg5 3681" is present
    And Verify school "schoolNameOrg5" is associated with "AutomationEmpOrg5 3681"

  @MOB-3683 @AndroidRegression @iOSRegression
  Scenario: Verify that substitute user is able to view jobs of multiple districts
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-3683_District1" for "next day" with "APISchoolID_ChildCare" "APIReasonID" and delete the existing ones
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-3683_District2" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When The user waits and launches the app
    Then The user click on Get Started Button
    When Enter username "AutomationSubsMOB-3683" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    When Click on the Available Jobs
    And View job list
    And Verify job list on Jobs page
    Then Verify the created jobs "AutomationEmp 3683" is present
    And Verify school "schoolNameOrg4_OtherDistrict" is associated with "AutomationEmp 3683"
    Then Verify the created jobs "AutomationEmp2 3683" is present
    And Verify school "schoolNameOrg4" is associated with "AutomationEmp2 3683"

  @MOB-4173 @MOB-4172 @Done @AndroidRegression @iOSRegression
  Scenario: Verify that substitute is able to view job widget and jobs in job list
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4173" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4172" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When The user waits and launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsMOB-4269" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    And Click on the Available Jobs
    And View job list
    And Verify job list on Jobs page
    Then Verify the created jobs "AutomationEmp 4173" is present
    Then Verify the created jobs "AutomationEmp 4172" is present

  @MOB-7775 @MOB-6673 @iOSRegression @AndroidRegression
  Scenario: Verify substitute user can reject available job and dont see that job in available job list
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-7775" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When The user waits and launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsMOB-7775" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    And Click on the Available Jobs
    And View job list
    And Click on the job "AutomationEmp 7775"
    And Reject the job
    And Validate the Reject Popup Message
    And Confirm the Reject job Popup
    And View job list
    Then Validate job "AutomationEmp 7777" is not visible in Job List

  @MOB-6680 @MOB-6679 @AndroidRegression @iOSRegression
  Scenario: Verify substitute can Accept job and check it in scheduled jobs List
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-6680" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When The user waits and launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsMOB-6680" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    And Click on the Available Jobs
    And View job list
    And Click on the job "6680 AutomationE_"
    And accept the job
    Then the Success Message overlay is displayed
    When Clicked on Okay
    And Navigate Back toward Scheduled Jobs
    And Click on the Scheduled Jobs
    And Verify job list on Jobs page
    Then Verify the created jobs is present in Scheduled jobs

  @MOB-8328 @AndroidRegression
  Scenario: Verify job details on job detail page
    When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-8328" for "next day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When The user waits and launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationSubsMOB-8328" and password and click on Sign In button
    Then The substitute navigates to dashboard page
    And Click on the Available Jobs
    And View job list
    And Click on the job "AutomationEmp 8328"
    Then Validate the job detail page "next day"