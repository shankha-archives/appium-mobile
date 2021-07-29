@absence
Feature: Absence scenarios

  #need to create an admin user
  @MOB-9794 @AndroidRegression
  Scenario: Verify that admin creates half day am absence for another user
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
    And Select half day am absence duration and click on next btn
    And Select if the substitute required and click on next btn
    And Click on submit absence
    Then Verify the absence creation pop up

    #need to create an admin user
  @MOB-9794 @AndroidRegression
  Scenario: Verify that admin creates half day pm absence for another user
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
    And Verify absence duration and click next
    And Select if the substitute required and click on next btn
    And Click on submit absence
    Then Verify the absence creation pop up

    #need to create an employee user
  @MOB-9794 @AndroidRegression
  Scenario: Verify employee can create half day am absence
    When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-4245" for "upcoming day" and delete them
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationEmployeeMOB-4245" and password and click on Sign In button
    Then the user navigates to dashboard page
    And click on the create absences
    When Select absence reason and click on next btn
    And Select absence day "upcoming day"  "1"
    And click on next btn
    And Select half day am absence duration and click on next btn
    And Select if the substitute required and click on next btn
    And Click on submit absence
    Then Verify the absence creation pop up

    #need to create an employee user
  @MOB-9794 @AndroidRegression
  Scenario: Verify employee can create half day pm absence
    When Verify if absences present for employee "APILoginID" with workerid "APIWorkerID_MOB-4245" for "upcoming day" and delete them
    When the user launches the app
    Then The user click on Get Started Button
    And Enter username "AutomationEmployeeMOB-4245" and password and click on Sign In button
    Then the user navigates to dashboard page
    And click on the create absences
    When Select absence reason and click on next btn
    And Select absence day "upcoming day"  "1"
    And click on next btn
    And Verify absence duration and click next
    And Select if the substitute required and click on next btn
    And Click on submit absence
    Then Verify the absence creation pop up