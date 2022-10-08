@menu
Feature: Smoke scenarios

@MOB-4233 @MOB-4235 @AndroidSmoke @MOB-4234 @MOB-4236 @iOSSmoke @AndroidRegression @iOSRegression
Scenario: Entered text should be searchable when user perform search operation
  When Create absence for employee "APILoginID" with workerid "APIWorkerID_MOB-4237" for "upcoming day" with "APISchoolID" "APIReasonID" and delete the existing ones
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationEmployeeMOB-4233" and password and click on Sign In button
  Then the user navigates to dashboard page
  When the user clicks on Menu tab
  Then Enter search text "searchText"
  When Click on calendar search result
  And verify calendar the search result "searchText"
  Then Navigate to dashboard
  Then the user navigates to dashboard page
  When the user clicks on Menu tab
  Then Enter search text "absenceKeyword"
  And click the absence search result
  Then verify the absence detail page

@MOB-4277 @AndroidSmoke @MOB-4278 @iOSSmoke @AndroidRegression @iOSRegression
Scenario: The user with directory access can view the full directory list and details
  When the user launches the app
  Then The user click on Get Started Button
  And Enter username "AutomationAdminMOB-4277" and password and click on Sign In button
  Then the user navigates to dashboard page
  And click on People widget
  When Enter the last name of the person to be searched
  And Click on the searched person
  Then Verify user details are displayed

