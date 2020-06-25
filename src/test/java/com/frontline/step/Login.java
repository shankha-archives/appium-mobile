package com.frontline.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import com.afpluscucumbermobile.config.AFPlusCucumber;
import com.frontline.pages.LoginPageMethods;

public class Login extends AFPlusCucumber {
	AppiumDriver<MobileElement> driver;
	public LoginPageMethods loginPage;
		

	public Login() throws Exception {
	}

	//Scenario-1
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
	
	}

	@When("^User enter the UserID$")
	public void user_enter_the_UserID() throws Throwable {

	}

	@When("^User enter the Password$")
	public void user_enter_the_Password() throws Throwable {

	}

	@When("^Click on login button$")
	public void click_on_login_button() throws Throwable {
	
	}

	@Then("^User navigate to next screen$")
	public void user_navigate_to_next_screen() throws Throwable {

	}
	
	//Scenario-2
	

	@When("^User enter the invalid UserID$")
	public void user_enter_the_invalid_UserID() throws Throwable {
	
	    
	}

	@When("^User enter the invalid Password$")
	public void user_enter_the_invalid_Password() throws Throwable {
	
	    
	}



	@Then("^User will get the error$")
	public void user_will_get_the_error() throws Throwable {
	
	    
	}
}
