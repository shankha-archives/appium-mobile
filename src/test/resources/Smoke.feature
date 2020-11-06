@smoke 
Feature: Smoke scenarios 

@MOB-4227 @AndroidSmoke @iOSSmoke @MOB-4228
Scenario: Need to restrict login once the application is killed and relaunched 
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	And The user kill and relaunch the application 
	Then the substitute navigates to dashboard page 
	
@MOB-4229 @AndroidSmoke @iOSSmoke @MOB-4230
Scenario:  Need to restrict login if application is running in background and then opened 
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	And The user minimize and relaunch the application 
	Then the substitute navigates to dashboard page 
	
@MOB-4271 @AndroidSmoke @MOB-4272 @iOSSmoke
Scenario: Pull to refresh 
	When the user launches the app
	Then the user click on Get Started Button 
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	And pulls to refresh the page 
	
@MOB-4249 @AndroidSmoke @MOB-4250 @iOSSmoke
Scenario: Admin creates an absence for another user 
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter admin username and password and click on Sign In button 
	Then the admin navigates to dashboard page 
	And click on the absences then add absence 
	When enter teacher select reason date length summary 
	Then submit and view absence 
	And verify absence 
	
@MOB-4251 @AndroidSmoke @MOB-4252 @iOSSmoke
Scenario: Admin can approve the absence 
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter admin username and password and click on Sign In button 
	Then the admin navigates to dashboard page 
	And click on the approval widget and navigates to the approval absence page 
	When selected approved a job 
	Then the job is no longer in the list for approval 
	
@MOB-4269 @MOB-4275 @AndroidSmoke @MOB-4270 @MOB-4276 @iOSSmoke
Scenario: The user toggle the Dark mode from setting and then send the Feedback
	When the user launches the app 
	Then the user click on Get Started Button  
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When the user clicks on Menu tab and click on Settings 
	Then the user toggle the Dark Mode
	Then the user clicks on Back button and click on Feedback
	Then the user send the feedback
	
@MOB-4245 @AndroidSmoke @MOB-4246 @iOSSmoke
 Scenario: Employee creates an absence for himself
    When the user launches the app
    Then the user click on Get Started Button
    And Enter employee username and password and click on Sign In button
    Then the employee navigates to dashboard page
    And click on the create absences
    When select reason date length summary
    Then submit and view absence
    And verify absence 
    
@MOB-4253 @AndroidSmoke @MOB-4254 @iOSSmoke
 Scenario: Admin can assign a substitute to an unfilled absence
    When the user launches the app
    Then the user click on Get Started Button
    And Enter admin username and password and click on Sign In button
    Then the admin navigates to dashboard page
    And click on unfilled absence in absence widget
    Then click on Tap to Assign and select Assign substitute
    And click Assign again to confirm
    
@MOB-4255 @AndroidSmoke @MOB-4256 @iOSSmoke @prod
Scenario: View leave balances and check available days 
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter employee username and password and click on SignIn button 
	Then the employee navigates to dashboard page 
	And click on Available Leave Balances and view leave balances 
	Then verify available days  
	
@MOB-4233 @MOB-4235  @AndroidSmoke @MOB-4234 @MOB-4236 @iOSSmoke
Scenario: Entered text should be searchable when user perform search operation 
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When click on menu bar
	Then enter the search text in bar and click on result
	And verify the search result
	Then click on the home button to navigate back to dashboard
	When click on menu bar
	Then enter the absence search text in bar
	And click the absence search result
	Then verify the absence detail page

@MOB-4259 @AndroidSmoke @MOB-4260 @iOSSmoke
Scenario: An employee can view week of timesheets and timesheets for selected date
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	And click on timesheets widget and view timesheets
	Then click on any day to view timesheet 
	
@MOB-4263 @AndroidSmoke @iOSSmoke @MOB-4264
Scenario: An employee can submit a timesheet and then undo a timesheet 
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When click on menu then click on timesheet option
	Then click on submit timesheet option 
	And undo the timesheet
	
@MOB-4257 @MOB-4265 @MOB-4267 @AndroidSmoke @MOB-4258 @MOB-4266 @MOB-4268 @iOSSmoke @sprint8
Scenario: A user can visit inbox and view messages 
	When the user launches the app 
	Then the user click on Get Started Button  
	And Enter username and password and click on Sign In button 
	Then the substitute navigates to dashboard page 
	When click on the inbox 
	Then view the message in the inbox
	And  logouts out from the application
	And Enter employee username and password for inbox and click on Sign In button 
	Then the employee navigates to dashboard page 
	When click on the inbox 
	Then view the message in the inbox
	And  logouts out from the application
	And Enter admin username and password and click on Sign In button 
	Then the admin navigates to dashboard page 
	When click on the inbox 
	Then view the message in the inbox

#@MOB-4241 @AndroidSmoke @MOB-4242 @iOSSmoke 
#Scenario: Need to rearrange the widgets on the dashboard
#   When the user launches the app
#   Then the user click on Get Started Button
#   Then the substitute user is taken to the Login Page
#   And Enter username and password and click on Sign In button
#   Then the substitute navigates to dashboard page
#   When click on reorder widget and rearrange the widget
#   And verify the order of widgets
#   And  logouts out from the application
#   And Enter employee username and password and click on Sign In button
#   Then the employee navigates to dashboard page
#   When click on reorder widget and rearrange the widget
#   And verify the order of widgets
#   And  logouts out from the application
#   And Enter admin username and password and click on Sign In button
#   Then the admin navigates to dashboard page
#   When click on reorder widget and rearrange the widget
#   And verify the order of widgets
#	
#@MOB-4239 @iOSSmoke @AndroidSmoke @MOB-4240 
#Scenario: Need to tap on footer buttons and all widgets
#   When the user launches the app
#   Then the user click on Get Started Button
#   And Enter employee username and password and click on Sign In button
#   Then the employee navigates to dashboard page
#   When click on reorder widget & get back
#   Then verify all the widgets and footers present
#   And  logouts out from the application
#   And Enter username and password and click on Sign In button
#   Then the substitute navigates to dashboard page
#   When click on reorder widget & get back
#   Then verify all the widgets and footers present
#   And  logouts out from the application
#   And Enter admin username and password and click on Sign In button
#   Then the admin navigates to dashboard page
#   When click on reorder widget & get back
#   Then verify all the widgets and footers present

@MOB-4261 @AndroidSmoke @MOB-4262 @iOSSmoke @sprint8iOS
Scenario: An employee can add time to a timesheet and edit and delete the time from the timesheet
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	When employee clicks on the timesheet widget 
	And open the past day timesheet and add a new time sheet
	Then user edits the timesheet
	And Delete the timesheet 

@MOB-4237 @AndroidSmoke @MOB-4238 @iOSSmoke
Scenario: Event should be display when user taps on any event, on any day from calendar
	When the user launches the app
	Then the user click on Get Started Button
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page 
	When the employee creates an absence 
	And the user opens the calendar through menu
	Then tap on the day when absence was created
	And the event will be displayed tap on it to view or verify the details
	
@smoke @MOB-4247 @AndroidSmoke @sprint7 @MOB-4248 @iOSSmoke
Scenario: An employee can edit an Absence for himself
    When the user launches the app
    Then the user click on Get Started Button
    And Enter employee username and password and click on Sign In button
    Then the employee navigates to dashboard page
    When click on Absences
    When click on editable absence and click on Edit tab
    Then edit the absence

@smoke @MOB-4243 @AndroidSmoke @sprint7 @MOB-4243 @iOSSmoke
Scenario: An employee should be clock in and clock out
	When the user launches the app 
	Then the user click on Get Started Button
	And Enter employee username and password and click on Sign In button 
	Then the employee navigates to dashboard page
	When employee clicks on the clockin btn 
   # Then the user clocks out through timesheet

@MOB-4277 @AndroidSmoke @MOB-4278 @prod @iOSSmoke
 Scenario: The user with directory access can view the full directory list and details
    When the user launches the app
    Then the user click on Get Started Button
    And Enter employee username and password with directory access and click on SignIn button
    When Select the required organization
    Then the employee navigates to dashboard page
    And click on People widget
    When search for a person
    Then user details are displayed

@MOB-4242 @MOB-4240 @MOB-4239 @MOB-4241 @iOSSmoke @AndroidSmoke
Scenario: Need to rearrange the widgets on the dashboard
   When the user launches the app
   Then the user click on Get Started Button
   And Enter username and password and click on Sign In button
   Then the substitute navigates to dashboard page
   When click on reorder widget and rearrange the widget
   Then verify all the widgets and footers present
   And verify the order of widgets
   And  logouts out from the application
   And Enter employee username and password and click on Sign In button
   Then the employee navigates to dashboard page
   When click on reorder widget and rearrange the widget
   Then verify all the widgets and footers present
   And verify the order of widgets
   And  logouts out from the application
   And Enter admin username and password and click on Sign In button
   Then the admin navigates to dashboard page
   When click on reorder widget and rearrange the widget
   Then verify all the widgets and footers present
   And verify the order of widgets
	