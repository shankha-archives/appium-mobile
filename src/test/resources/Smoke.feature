@smoke
Feature: Smoke scenarios

@MOB-4227 @smoke @Android
Scenario: Need to restrict login once the application is killed and relaunched
	When the substitute user launches the app
    Then the substitute user passes the splash screen
    When the substitute user enters the PIN code 7354
    Then the substitute user is taken to the Login Page
    And Enter username and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And The user kill and relaunch the application
    Then the substitute navigates to dashboard page

@MOB-4229 @smoke @Android
Scenario: Need to restrict login if application is running in background and then opened
	When the substitute user launches the app
    Then the substitute user passes the splash screen
    When the substitute user enters the PIN code 7354
    Then the substitute user is taken to the Login Page
    And Enter username and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And The user minimize and relaunch the application
    Then the substitute navigates to dashboard page
        
  @MOB-4271 @smoke @Android 
  Scenario Outline: Pull to refresh
    When the substitute user launches the app
    Then the substitute user passes the splash screen
    When the substitute user enters the PIN code 7354
    Then the substitute user is taken to the Login Page
    And Enter username and password and click on Sign In button
    Then the substitute navigates to dashboard page
    And pulls to refresh the page
    
@smoke @MOB-4249 @Android
  Scenario: Admin creates an absence for another user
    When the admin user launches the app
    Then the admin user click on Get Started Button and enter the pin
    And Enter admin username and password and click on Sign In button
    Then the admin navigates to dashboard page
    And click on the absences then add absence
    When enter teacher select reason date length summary
    Then submit and view absence
    And verify absence
    
@smoke @MOB-4251 @Android 
Scenario: Admin can approve the absence 
	When the admin user launches the app 
	Then the admin user click on Get Started Button and enter the pin 
	And Enter admin username and password and click on Sign In button 
	Then the admin navigates to dashboard page 
	And click on the approval widget and navigates to the approval absence page 
	When selected approved a job 
	Then the job is no longer in the list for approval 
	
 
