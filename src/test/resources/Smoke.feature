@smoke 
Feature: Smoke scenarios 

@MOB-4227 @smoke @Android @iOS @MOB-4228 @sprint7onlyiOS 
Scenario: Need to restrict login once the application is killed and relaunched 
	When the substitute user launches the app 
	Then the substitute user passes the splash screen 
	When the substitute user enters the PIN code 7354 
	Then the substitute user is taken to the Login Page 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	And The user kill and relaunch the application 
	Then the substitute navigates to dashboard page 
	
@MOB-4229 @smoke @Android @iOS @MOB-4230 @sprint7onlyiOS 
Scenario:
Need to restrict login if application is running in background and then opened 
	When the substitute user launches the app 
	Then the substitute user passes the splash screen 
	When the substitute user enters the PIN code 7354 
	Then the substitute user is taken to the Login Page 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	And The user minimize and relaunch the application 
	Then the substitute navigates to dashboard page 
	
@MOB-4271 @smoke @Android @MOB-4272 @iOS @sprint7iOSonly
Scenario: Pull to refresh 
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
	
@smoke @MOB-4251 @Android @sprint7AndroidOnly 
Scenario: Admin can approve the absence 
	When the admin user launches the app 
	Then the admin user click on Get Started Button and enter the pin 
	And Enter admin username and password and click on Sign In button 
	Then the admin navigates to dashboard page 
	And click on the approval widget and navigates to the approval absence page 
	When selected approved a job 
	Then the job is no longer in the list for approval 
	
@MOB-4269 @smoke @Android @MOB-4270 @iOS @sprint7Androidonly @sprint7iOSonly
Scenario: The user can toggle the Dark mode from setting 
	When the substitute user launches the app 
	Then the substitute user passes the splash screen 
	When the substitute user enters the PIN code 7354 
	Then the substitute user is taken to the Login Page 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When the user clicks on Menu tab and click on Settings 
	Then the user toggle the Dark Mode 
	
 @smoke @MOB-4245 @Android
 Scenario: Employee creates an absence for himself
    When the employee user launches the app
    Then the employee user click on Get Started Button and enter the pin
    And Enter employee username and password and click on Sign In button
    Then the employee navigates to dashboard page
    And click on the create absences
    When select reason date length summary
    Then submit and view absence
    And verify absence 
    
 @smoke @MOB-4253 @sprint7 @Android
 Scenario: Admin can assign a substitute to an unfilled absence
    When the admin user launches the app
    Then the admin user click on Get Started Button and enter the pin
    And Enter admin username and password and click on Sign In button
    Then the admin navigates to dashboard page
    And click on unfilled absence in absence widget
    Then click on Tap to Assign and select Assign substitute
    And click Assign again to confirm
    
@MOB-4255 @smoke @sprint7 @Android @sprint7AndroidOnly
Scenario: View leave balances and check available days 
	When the employee user launches the app 
	Then the employee user click on Get Started Button and enter the pin 
	And Enter employee username and password and click on SignIn button 
	Then the employee navigates to dashboard page 
	And click on Available Leave Balances and view leave balances 
	Then verify available days 
	
@MOB-4275 @smoke @Android @MOB-4276 @iOS @sprint7Androidonly @sprint7iOSonly
Scenario: The user can send the Feedback 
	When the substitute user launches the app 
	Then the substitute user passes the splash screen 
	When the substitute user enters the PIN code 7354 
	Then the substitute user is taken to the Login Page 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When the user clicks on Menu tab and click on Feedback 
	Then the user send the feedback 
	
@smoke @MOB-4265 @Android @sprint7 
Scenario: An employee can visit inbox and view messages 
	When the employee user launches the app 
	Then the employee user click on Get Started Button and enter the pin 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When click on the inbox 
	Then view the message in the inbox 
	
@smoke @MOB-4233 @Android @sprint7 
Scenario: Entered text should be searchable when user perform search operation 
	When the employee user launches the app 
	Then the employee user click on Get Started Button and enter the pin 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When click on menu and tap the search bar
	Then enter the search text in bar 
	And verify the search result
	
@smoke @MOB-4267 @Android @sprint7 
Scenario: An admin can visit inbox and view messages 
	When the admin user launches the app 
	Then the admin user click on Get Started Button and enter the pin 
	And Enter admin username and password and click on Sign In button 
	Then the admin navigates to dashboard page 
	When click on the inbox 
	Then view the message in the inbox 

@smoke @MOB-4259 @Android @sprint7 
Scenario: An employee can view week of timesheets and timesheets for selected date
	When the employee user launches the app 
	Then the employee user click on Get Started Button and enter the pin 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	And click on timesheets widget and view timesheets
	Then click on any day to view timesheet 
	
@smoke @MOB-4263 @Android @iOS @MOB-4264 @sprint7Android @sprint7iOS
Scenario: An employee can submit a timesheet and then undo a timesheet 
	When the employee user launches the app 
	Then the employee user click on Get Started Button and enter the pin 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When click on menu then click on timesheet option
	Then click on submit timesheet option 
	And undo the timesheet
	
@smoke @MOB-4257 @Android @sprint7 
Scenario: A user can visit inbox and view messages 
	When the substitute user launches the app 
	Then the substitute user passes the splash screen 
	When the substitute user enters the PIN code 7354 
	Then the substitute user is taken to the Login Page 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on the inbox 
	Then view the message in the inbox 

@smoke @MOB-4241 @Android @sprint7 @subtitute 
Scenario: Substitute Need to rearrange the widgets on the dashboard 
	When the substitute user launches the app 
	Then the substitute user passes the splash screen 
	When the substitute user enters the PIN code 7354 
	Then the substitute user is taken to the Login Page 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on reorder widget 
	Then rearrange the widget
	And verify the order of widgets

@smoke @MOB-4241 @Android @sprint7 @employee
Scenario: Employee Need to rearrange the widgets on the dashboard 
	When the employee user launches the app 
	Then the employee user click on Get Started Button and enter the pin 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	When click on reorder widget 
	Then rearrange the widget
	And verify the order of widgets
	
@smoke @MOB-4241 @Android @sprint7 @admin 
Scenario: Admin Need to rearrange the widgets on the dashboard 
	When the admin user launches the app 
	Then the admin user click on Get Started Button and enter the pin 
	And Enter admin username and password and click on Sign In button 
	Then the admin navigates to dashboard page 
	When click on reorder widget 
	Then rearrange the widget
	And verify the order of widgets
	
@smoke @MOB-4261 @Android @sprint7 
Scenario: An employee can add time to a timesheet and edit and delete the time from the timesheet
	When the employee user launches the app 
	Then the employee user click on Get Started Button and enter the pin 
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	When employee clicks on the timesheet widget 
	And open the past day timesheet and add a new time sheet
	Then user edits the timesheet
	And Delete the timesheet 


