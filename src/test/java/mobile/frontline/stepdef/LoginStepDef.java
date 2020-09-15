package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import mobile.Frontline.utils.TestDataManager;
import mobile.frontline.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

	public LoginPage loginPage = new LoginPage();
	public TestDataManager testdata = new TestDataManager();
	//private String password;

	//@MOB-3204
	@When("^The substitute user launches the app$")
	public void the_substitute_user_launches_the_app() throws Throwable {
		loginPage.verify_splashScreenLoaded();
	}

	@And("^The substitute user lands on the splash screen$")
	public void the_substitute_user_lands_on_the_splash_screen() throws Throwable {
		loginPage.verify_splashScreenLoaded();
	}

	@When("^The substitute user taps the Get Started Button$")
	public void the_substitute_user_taps_the_get_started_button() throws Throwable {
		loginPage.clickOnGetStartedBtn();
	}

	@Then("^The substitute user arrives on the PIN entry screen$")
	public void the_substitute_user_arrives_on_the_pin_entry_screen() throws Throwable {
		loginPage.verify_enterUnlockCodeScreen();
	}

	// MOB-3205
	// Scenario-1
	@When("^the substitute user enters the PIN code 7354$")
	public void the_substitute_user_enters_the_pin_code_7354() throws Throwable {
		loginPage.enterUnlockCode();
	}

	@Then("^the substitute user passes the splash screen$")
	public void the_substitute_user_passes_the_splash_screen() throws Throwable {
		loginPage.clickOnGetStartedBtn();
	}

	@Then("^the substitute user is taken to the Login Page$")
	public void the_substitute_user_is_taken_to_the_login_page() throws Throwable {
		loginPage.verify_loginPageLoaded();
	}

	@When("^the substitute user launches the app$")
	public void theSubstituteUserLaunchesTheApp() throws Throwable {
		loginPage.verify_splashScreenLoaded();
	}

	@Then("^the substitute user arrives on the PIN entry screen$")
	public void theSubstituteUserArrivesOnThePINEntryScreen() {
		loginPage.verify_enterUnlockCodeScreen();
	}

	// Scenario-2
	@When("^the substitute user enters a incorrect PIN code '3333'$")
	public void the_substitute_user_enters_a_incorrect_pin_code_3333() throws Throwable {
		loginPage.enterUnlockCode3();
	}

	@Then("^the substitute user enter a incorrect PIN code '7777'$")
	public void the_substitute_user_enter_a_incorrect_pin_code_7777() throws Throwable {
		loginPage.enterUnlockCode7();
	}

	@Then("^the substitute user enters a incorrect PIN code '5555'$")
	public void the_substitute_user_enters_a_incorrect_pin_code_5555() throws Throwable {
		loginPage.enterUnlockCode5();
	}

	@Then("^the substitute user is prompted with a “You may not have access yet” dialog$")
	public void theSubstituteUserIsPromptedWithAYouMayNotHaveAccessYetDialog() {
		loginPage.verify_pinUnlokError();
	}

	//MOB-3206
	//scenario 1
	 @And("^the substitute enter invalid username$")
	    public void the_substitute_enter_invalid_username() throws Throwable {
		 loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "invalid", "invalidlogin"));
	    }
	  @And("^the substitute enter invalid password$")
	    public void the_substitute_enter_invalid_password() throws Throwable {
		  loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "invalid", "invalidpass"));
	    }

	@When("^Click on Sign In with Frontline ID button$")
	public void click_on_sign_in_with_frontline_id_button() throws Throwable {
		loginPage.clickOnLoginBtn();
	}

	@Then("^Incorrect username and password error message displays$")
	public void incorrect_username_and_password_error_message_displays() throws Throwable {
		loginPage.verifyInvalidCredentials_errorMessage();
	}
	//scenario 2
	@Then("^Error message displays to the substitute users$")
	public void error_message_displays_to_the_substitute_users() throws Throwable {
		loginPage.verifyNoUserName_errorMessage();
		loginPage.verifyNoPassword_errorMessage();
	}
	//Scenario 3

	 @And("^the substitute enter valid username$")
	    public void the_substitute_enter_valid_username() throws Throwable {
		 loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "substitutelogin"));
	    }

	 @And("^the substitute enter valid password$")
	    public void the_substitute_enter_valid_password() throws Throwable {
		 loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "substitutepass"));
	    }
	
	@Then("^the substitute navigates to dashboard page$")
	public void the_substitute_navigates_to_dashboard_page() throws Throwable {
		loginPage.verify_homeScreen_displayed();
	}
	
    @Then("^the user is presented with the role picker$")
    public void role_picker_page_displayed() throws Throwable {
    	loginPage.rolePickerPageLoads();
    }
    
    @Then("^the user is presented with the org picker$")
    public void org_picker_page_displayed() throws Throwable {
    	loginPage.orgPickerPageLoads();
    }
    
    @Then("^the system presents a dialog$")
    public void the_system_presents_a_dialog() throws Throwable {
       loginPage.verifyNoLoginDialogbox();
    }
    
    @When("^user selects the org with only role as sub$")
    public void user_selects_the_org_with_only_role_as_sub() throws Throwable {
    	loginPage.orgWithOnlySubRole();
    }

    @When("^user clicks on back button$")
    public void user_clicks_on_back_button() throws Throwable {
    	loginPage.clickBackBtn();
    }

    @Then("^a dialogue box is displayed$")
    public void a_dialogue_box_is_displayed() throws Throwable {
      loginPage.VerifyMessage();
    }
     
   
}
