@jobs
Feature: Job scenarios

@AndroidRegression @MOB-3325 @iOSRegression
Scenario: Verify substitute success message while accepting job is dismissed revealing accepted job details page
  When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
  When The user waits and launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationSubsJobOperations" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  And Click on the Available Jobs
  And View job list
  And Click on the job "Create Job"
  And accept the job
  Then the Success Message overlay is displayed
  When Clicked on Okay
  Then Success Message is dismissed revealing accepted job details page

@AndroidRegression  @MOB-3324 @MOB-3326 @iOSRegression
Scenario: Verify substitute views the success Confirmation Number on accepting a job
  When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs2" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
  When The user waits and launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationSubsJobOperations2" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  And Click on the Available Jobs
  And View job list
  And Click on the job "Create Job2"
  And accept the job
  Then the Success Message overlay is displayed
  When Clicked on Okay
  Then Success Message is dismissed revealing accepted job details page
  Then Verify the confirmation number present on the job details page

@AndroidRegression  @MOB-4174 @iOSRegression
Scenario: Verify substitute cannot view accepted job in job list
  When Create absence for employee "APILoginID" with workerid "APIWorkerIDCreateJobs3" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
  When The user waits and launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationSubsJobOperations3" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  And Click on the Available Jobs
  And View job list
  And Click on the job "Create Job3"
  And accept the job
  Then the Success Message overlay is displayed
  When Clicked on Okay
  And Navigate to dashboard
  And Click on the Available Jobs
  And View job list
  Then Validate job "CreateJob3" is not visible in Job List

@MOB-3681 @AndroidRegression @iOSRegression
Scenario: Verify that substitute user is able to view all job information from all organizations
  When Create absence for employee "APILoginID_GLorg5" with workerid "APIWorkerID_MOB-3681_GLorg5" for "upcoming day" with "APISchoolID_GLorg5" "APIReasonID_GLorg5" and delete the existing ones
  When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-3681" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
  When The user waits and launches the app
  Then The user click on Get Started Button
  When Enter username "AutomationSubMutiOrg" and password and click on Sign In button
  Then The user choose the one organization
  Then The substitute navigates to dashboard page
  When Click on the Available Jobs
  And Verify job list on Jobs page
  Then Verify the created jobs "AutomationEmp 3681" is present
  #And Verify school "schoolNameOrg4" is associated with "AutomationEmp 3681"
  Then Verify the created jobs "AutomationEmpOrg5 3681" is present
  #And Verify school "schoolNameOrg5" is associated with "AutomationEmpOrg5 3681"
   When Navigate to dashboard
  And Click on switch btn
  Then The user choose the second organization
  Then The substitute navigates to dashboard page
  When Click on the Available Jobs
  And Verify job list on Jobs page
  And View job list
  Then Verify the created jobs "AutomationEmp 3681" is present
  #And Verify school "schoolNameOrg4" is associated with "AutomationEmp 3681"
  Then Verify the created jobs "AutomationEmpOrg5 3681" is present
  #And Verify school "schoolNameOrg5" is associated with "AutomationEmpOrg5 3681"

@MOB-3683 @AndroidRegression @iOSRegression
Scenario: Verify that substitute user is able to view jobs of multiple districts
  When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-3683_District1" for "upcoming day" with "APISchoolID_ChildCare" "APIReasonID" and delete the existing ones
  When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-3683_District2" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
  When The user waits and launches the app
  Then The user click on Get Started Button
  When Enter username "AutomationSubsMOB-3683" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  When Click on the Available Jobs
  And View job list
  And Verify job list on Jobs page
  Then Verify the created jobs "AutomationEmp 3683" is present
  #And Verify school "schoolNameOrg4_OtherDistrict" is associated with "AutomationEmp 3683"
  Then Verify the created jobs "AutomationEmp2 3683" is present
  #And Verify school "schoolNameOrg4" is associated with "AutomationEmp2 3683"

@MOB-4173 @MOB-4172 @AndroidRegression @iOSRegression
Scenario: Verify that substitute is able to view job widget and jobs in job list
  When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4173" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
  When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4172" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
  When the user launches the app
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
  When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-7775" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
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
  When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-6680" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
  When The user waits and launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationSubsMOB-6680" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  And Click on the Available Jobs
  And View job list
  And Click on the job "AutomationE 6680"
  And accept the job
  Then the Success Message overlay is displayed
  When Clicked on Okay
  And Navigate Back toward Scheduled Jobs
  And Click on the Scheduled Jobs
  And Verify job list on Jobs page
  Then Verify the created jobs is present in Scheduled jobs

@MOB-8328 @MOB-8443 @AndroidRegression @iOSRegression
Scenario: Verify job details on job detail page
  When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-8328" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
  When The user waits and launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationSubsMOB-8328" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  And Click on the Available Jobs
  And View job list
  And Click on the job "AutomationEmp 8328" with absence "next day"
  Then Validate the job detail page "next day"

@MOB-6028 @AndroidRegression @MOB-9079 @iOSRegression
Scenario: Substitute can accept multiday absence
  When Create multiday absence for employee "APILoginID" with user "AutomationEmployeeMOB-9079" workerid "APIWorkerID_MOB-9079" for "upcoming day" with "APISchoolID" "APIReasonID" days "1" "2" and delete the existing ones
  When The user waits and launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationSubsMOB-9079" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  And Click on the Available Jobs
  And View job list
  #Then Verify the created jobs "AutomationEmp 9079" is present
  #And Verify the job duration "AutomationEmp 9079" "2 Days"
  And Click on the job "AutomationEmp 9079"
  And accept the job
  Then the Success Message overlay is displayed
  When Clicked on Okay
  Then Verify the job event details for "upcoming day" "1" "2"

@MOB-5593 @AndroidRegression @MOB-9169 @iOSRegression
Scenario: Accept job in one org substitute and verify in scheduled jobs of other org substitute
  When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-5593" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
  When The user waits and launches the app
  Then The user click on Get Started Button
  When Enter username "AutomationSubsMOB-5593" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  When Click on the Available Jobs
  And Verify job list on Jobs page
  And Click on the job "AutomationEmp 5593"
  And accept the job
  Then the Success Message overlay is displayed
  When Clicked on Okay
  When Navigate to dashboard
  And Click on switch btn
  Then The user choose the second organization
  Then The substitute navigates to dashboard page
  When Click on the Available Jobs
  And Click on the Scheduled Jobs
  And Verify job list on Jobs page
  Then Verify the created jobs is present in Scheduled jobs

#This Scenario may Fail for iOS as there is Caching Known Issue deu to which data not reflecting quicky.
@MOB-8750 @iOSRegression @MOB-9143 @AndroidRegression
Scenario: Verify substitute can Accept job and check in next schedule widget
  When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-8751" for "current day" with "APISchoolID" "APIReasonID" and delete the existing ones
  When The user waits and launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationSubsMOB-8750" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  And Click on the Available Jobs
  And View job list
  And Click on the job "AutomationEmp 8751"
  And accept the job
  Then the Success Message overlay is displayed
  And Clicked on Okay
  And Navigate to dashboard
  Then The user moves to Next Scheduled Job widget and verify it
  And The user verify most recent Job in Next Scheduled Job widget

@MOB-6670 @AndroidRegression @MOB-6668 @iOSRegression
Scenario: Verify Available Jobs Display by Job and Post Date
  When Create absence for employee "APILoginID_GLorg5" with workerid "APIWorkerID_MOB-6670" for "upcoming day" with "APISchoolID_GLorg5" "APIReasonID_GLorg5" and delete the existing ones
  When The user waits and launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationSubsMOB-6670" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  And Click on the Available Jobs
  And Validate the up down arrows
  And Click on sort filter btn
  When Validate the job selected filter
  When Click on post job filter
  Then Verify sort by post header
  And Click on post sort filter btn
  And Validate the post selected filter

@MOB-6672 @android @MOB-6671 @iOS
Scenario: Verify Scheduled Jobs Display by Job and Post Date
  When Create absence for employee "APILoginID_GLorg5" with workerid "APIWorkerID_MOB-6672" for "upcoming day" with "APISchoolID_GLorg5" "APIReasonID_GLorg5" and delete the existing ones
  When Substitute accepts the job with required details "AutomationSubsMOB-6672" "APIXrefIDOrg2"
  When The user waits and launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationSubsMOB-6672" and password and click on Sign In button
  Then The substitute navigates to dashboard page
  And Click on the Available Jobs
  And Verify job list on Jobs page
  And Click on the Scheduled Jobs
  And Validate the up down arrows
  And Click on sort filter btn
  When Validate the job selected filter
  When Click on post job filter
  Then Verify sort by post header
  And Click on post sort filter btn
  And Validate the post selected filter

  Scenario: Verify substitute user can reject available job
    Given Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4247" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
    When The user waits and launches the app
    And The user click on Get Started Button
    And Enter username "AutomationSubsMOB-4265" and password and click on Sign In button
    And The substitute navigates to dashboard page
    And Click on the Available Jobs
    And View job list
    And Click on the job "Automation 4247"
    And Click on Reject button
    And Clicked on Okay
    And View job list
    Then Validate job "AutomationEmp 4247" is not visible in Job List

