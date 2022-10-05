@absence
Feature: Absence scenarios

@MOB-4255 @AndroidSmoke @MOB-4256 @iOSSmoke @AndroidRegression @iOSRegression
Scenario: View leave balances and check available days
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-4255" and password and click on Sign In button
  Then the user navigates to dashboard page
  When click on Available Leave Balances
  Then View leave balance screen
  Then verify available days

@MOB-9794 @MOB-9798 @AndroidRegression @iOSRegression
Scenario: Verify that admin creates half day am absence for another user
  When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-4249" for "upcoming day" and delete them
  When the user launches the app
  Then The user click on Get Started Button
#    And Enter username "AutomationAdminMOB-9794" and password and click on Sign In button
  And Enter username "AutomationAdminMOB-4249" and password and click on Sign In button
  Then the user navigates to dashboard page
  When Click on absences today widget
  And Click on add absence btn
  And Enter and select employee name "Emp-4249" and click on next
  When Select absence reason and click on next btn
  And Select absence day "upcoming day"  "1"
  And click on next btn
  And Select half day am absence duration and click on next btn
  And Select if the substitute required and click on next btn
  And Click on submit absence
  Then Verify the absence creation pop up

@MOB-9794 @MOB-9798 @AndroidRegression @iOSRegression
Scenario: Verify that admin creates half day pm absence for another user
  When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-4249" for "upcoming day" and delete them
  When the user launches the app
  Then The user click on Get Started Button
#    And Enter username "AutomationAdminMOB-9794" and password and click on Sign In button
  And Enter username "AutomationAdminMOB-4249" and password and click on Sign In button
  Then the user navigates to dashboard page
  When Click on absences today widget
  And Click on add absence btn
  And Enter and select employee name "Emp-4249" and click on next
  When Select absence reason and click on next btn
  And Select absence day "upcoming day"  "1"
  And click on next btn
  And Verify absence duration and click next
  And Select if the substitute required and click on next btn
  And Click on submit absence
  Then Verify the absence creation pop up

@MOB-4245 @MOB-4246 @AndroidSmoke @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Verify employee can create full day absence
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
#  And verify calendar the search result "searchText"
#  Then Choose the required month "next day"
#  And Click on the event day "next day"
  And Click on the event day "upcoming day"
  And Tap on the event title
  And Verify absence confirmation number

@MOB-9794 @MOB-9798 @AndroidRegression @iOSRegression
Scenario: Verify employee can create half day am absence
  When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-9798" for "upcoming day" and delete them
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-9798" and password and click on Sign In button
  Then the user navigates to dashboard page
  And click on the create absences
  When Select absence reason and click on next btn
  And Select absence day "upcoming day"  "1"
  And click on next btn
  And Select half day am absence duration and click on next btn
  And Select if the substitute required and click on next btn
  And Click on submit absence
  Then Verify the absence creation pop up

@MOB-9794 @MOB-9798 @AndroidRegression @iOSRegression
Scenario: Verify employee can create half day pm absence
  When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-9798" for "upcoming day" and delete them
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-9798" and password and click on Sign In button
  Then the user navigates to dashboard page
  And click on the create absences
  When Select absence reason and click on next btn
  And Select absence day "upcoming day"  "1"
  And click on next btn
  And Verify absence duration and click next
  And Select if the substitute required and click on next btn
  And Click on submit absence
  Then Verify the absence creation pop up

   #IDM server is down Ticket "OPS-17893" so using AutomationEmployeeMOB-4245 will create AutomationEmp_9814 once IDM is Up
@MOB-9814 @iOSRegression @AndroidRegression @MOB-9809
Scenario: Verify employee can create custom absence
When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-4245" for "upcoming day" and delete them
When the user launches the app
Then The user click on Get Started Button
And Enter username "AutomationEmployeeMOB-4245" and password and click on Sign In button
Then the user navigates to dashboard page
And click on the create absences
When Select absence reason and click on next btn
And Select absence day "upcoming day"  "1"
And click on next btn
And Select custom absence duration and click on next btn
And Select if the substitute required and click on next btn
And Click on submit absence
Then Verify the absence creation pop up

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


   #IDM server is down Ticket "OPS-17893" so using AutomationEmployeeMOB-4245 will create AutomationEmp_9814 once IDM is Up
@MOB-9814 @MOB-9809  @AndroidRegression @iOSRegression
Scenario: Verify that admin creates custom absence for another user
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
  And Select custom absence duration and click on next btn
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