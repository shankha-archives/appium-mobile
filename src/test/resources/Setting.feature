@regression
Feature: Regression scenarios 
	
  @regression @MOB-4789 @Android @sprint8 
  Scenario: Show calendar link in substitute Menu 
	  When the user launches the app  
	  Then the user click on Get Started Button 
	  And Enter username and password and click on Sign In button 
	  Then the substitute navigates to dashboard page 
	  When click on menu and tap the Calendar link
	  Then verify the calendar 
	
