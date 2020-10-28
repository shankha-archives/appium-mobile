@regression
Feature: Regression scenarios 
	
  @regression @MOB-4789 @Android @sprint8 @MOB-4791 @iOS
  Scenario: Show calendar link in substitute Menu 
	  When the user launches the app  
	  Then the user click on Get Started Button 
	  And Enter username and password and click on Sign In button 
	  Then the substitute navigates to dashboard page 
	  When click on menu and tap the Calendar link
	  Then verify the calendar 
	
 @regression @MOB-4806 @iOS @sprint9 @MOB-4805
  Scenario: Show Job List tab bar
  	  When the user launches the app  
	  Then the user click on Get Started Button 
	  And Enter username and password and click on Sign In button 
	  Then the substitute navigates to dashboard page 
	  When click on Avalaible Jobs link
	  Then verify Job List tab bar for available and accepted jobs

	@regression @MOB-4809 @iOS @sprint9
	Scenario: Show Job List tab bar
		When the user launches the app
		Then the user click on Get Started Button
		And Enter username and password and click on Sign In button
		Then the substitute navigates to dashboard page
		When click on menu bar
		And Long press on Frontline Logo at bottom of the screen
		Then User click on the send Diagnostics option and click on Okay button
		
	@regression @MOB-4808 @iOS @sprint10
	Scenario: Show Next Scheduled Job widget
	   When the user launches the app 
	   Then the user click on Get Started Button
	   Then the substitute user is taken to the Login Page 
	   And Enter username and password and click on Sign In button 
	   Then the substitute navigates to dashboard page 
	   Then The user moves to Next Scheduled Job widget and verify it
		
