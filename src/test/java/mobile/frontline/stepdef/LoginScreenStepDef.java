package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.TestDataManager;
import mobile.frontline.pages.*;
import org.junit.Assert;

public class LoginScreenStepDef {

	public LoginPage loginPage = new LoginPage();
	public TestDataManager testdata = new TestDataManager();
	public LoginScreen loginMethods = new LoginScreen();

	public RolePickerScreen  rolePickerScreen = new RolePickerScreen();

	// @MOB-3204
//	@When("^The substitute user launches the app$")
//	public void the_substitute_user_launches_the_app() throws Throwable {
//		loginPage.verify_splashScreenLoaded();
//	}
//
//	@And("^The substitute user lands on the splash screen$")
//	public void the_substitute_user_lands_on_the_splash_screen() throws Throwable {
//		loginPage.verify_splashScreenLoaded();
//	}
//
//	@When("^The substitute user taps the Get Started Button$")
//	public void the_substitute_user_taps_the_get_started_button() throws Throwable {
//		loginPage.clickOnGetStartedBtn();
//	}
//
//	@Then("^the substitute user passes the splash screen$")
//	public void the_substitute_user_passes_the_splash_screen() throws Throwable {
//		loginPage.clickOnGetStartedBtn();
//	}

	@When("the user launches the app")
	public void theUserLaunchesTheApp() throws Throwable {
		Assert.assertTrue("Splash screen is not loading",loginMethods.verifySplashScreenLoaded());
		//loginPage.verify_splashScreenLoaded();
	}

	@When("^the user waits and launches the app$")
	public void the_user_waits_and_launches_the_app() throws Throwable {
		Assert.assertTrue("Waiting and searching for get started",loginMethods.waitAndverify_splashScreenLoaded());
		//loginPage.waitAndverify_splashScreenLoaded();
	}

	@Then("the user click on Get Started Button")
	public void user_click_on_get_started_button() throws Throwable {
		//loginPage.clickOnGetStartedBtn();
		loginMethods.clickOnGetStartedBtn();
	}

	@Then("^the substitute user is taken to the Login Page$")
	public void the_substitute_user_is_taken_to_the_login_page() throws Throwable {
		Assert.assertTrue("Login page is not loaded",loginMethods.verify_loginPageLoaded());
		//loginPage.verify_loginPageLoaded();
	}

	@And("^Enter username \"([^\"]*)\" and password and click on Sign In button$")
	public void enter_username_something_and_password_and_click_on_sign_in_button(String username) throws Throwable {
//		loginPage.verify_loginPageLoaded();
//		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", username));
//		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "FrontlinePassword"));
//		loginPage.clickOnLoginBtn();
		loginMethods.loginToApplication(testdata.read_property("Account", "valid", username),testdata.read_property("Account", "valid", "FrontlinePassword") );
	}

//	@When("^the substitute user launches the app$")
//	public void theSubstituteUserLaunchesTheApp() throws Throwable {
//		loginPage.verify_splashScreenLoaded();
//	}

//	@Then("^the substitute user is prompted with a “You may not have access yet” dialog$")
//	public void theSubstituteUserIsPromptedWithAYouMayNotHaveAccessYetDialog() {
//		loginPage.verify_pinUnlokError();
//	}

	// MOB-3206
	// scenario 1
//	@And("^the substitute enter invalid username$")
//	public void the_substitute_enter_invalid_username() throws Throwable {
//		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "invalid", "invalidlogin"));
//	}
//
//	@And("^the substitute enter invalid password$")
//	public void the_substitute_enter_invalid_password() throws Throwable {
//		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "invalid", "invalidpass"));
//	}

	@And("^the substitute enter \"([^\"]*)\" \"([^\"]*)\" username$")
	public void the_substitute_enter_something_something_username(String type, String username) throws Throwable {
		// loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", type, username));
		loginMethods.enterUserName(testdata.read_property("Account", type, username));
	}

	@And("^the substitute enter \"([^\"]*)\" \"([^\"]*)\" password$")
	public void the_substitute_enter_something_something_password(String type, String password) throws Throwable {
		loginMethods.enterUserPassword(testdata.read_property("Account", type, password));
		//loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", type, password));
	}

	@When("^Click on Sign In with Frontline ID button$")
	public void click_on_sign_in_with_frontline_id_button() throws Throwable {
		loginMethods.clickOnLoginBtn();
		//loginPage.clickOnLoginBtn();
	}

	@Then("^Incorrect username and password error message displays$")
	public void incorrect_username_and_password_error_message_displays() throws Throwable {
		Assert.assertTrue("No Invalid Credentials error message is displayed", loginMethods.verifyInvalidCredentials_errorMessage());
		//loginPage.verifyInvalidCredentials_errorMessage();
	}

	// scenario 2
	@Then("^Error message displays to the substitute users$")
	public void error_message_displays_to_the_substitute_users() throws Throwable {
		Assert.assertTrue("Your username is required error message is not displayed", loginMethods.verifyNoUserName_errorMessage());
		Assert.assertTrue("Your username is required error message is not displayed",loginMethods.verifyNoPassword_errorMessage());
//		loginPage.verifyNoUserName_errorMessage();
//		loginPage.verifyNoPassword_errorMessage();
	}
	// Scenario 3

//	@And("^the substitute enter valid username$")
//	public void the_substitute_enter_valid_username() throws Throwable {
//		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "substitutelogin"));
//	}
//
//	@And("^the substitute enter valid password$")
//	public void the_substitute_enter_valid_password() throws Throwable {
//		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "substitutepass"));
//	}



//	@And("^Enter username and password for multiple roles including substitute and organization and click on Sign In button$")
//	public void enter_username_and_password_for_multiple_roles_including_substitute_and_organization_and_click_on_sign_in_button()
//			throws Throwable {
//		loginPage.verify_loginPageLoaded();
//		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "multiOrgSubsUser"));
//		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "multiOrgSubsPass"));
//		loginPage.clickOnLoginBtn();
//	}

//	@And("^Enter username and password for multiple organization and click on Sign In button$")
//	public void enter_username_and_password_for_multiple_organization_and_click_on_sign_in_button() throws Throwable {
//		loginPage.verify_loginPageLoaded();
//		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "MultiOrgUser"));
//		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "MultiOrgPass"));
//		loginPage.clickOnLoginBtn();
//	}

//	@And("^Enter username and password access No Districts associated with Sub and click on Sign In button$")
//	public void enter_username_and_password_access_no_districts_associated_with_sub_and_click_on_sign_in_button()
//			throws Throwable {
//		loginPage.verify_loginPageLoaded();
//		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "NoDistrictUser"));
//		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "NoDistrictPass"));
//		loginPage.clickOnLoginBtn();
//	}





	@Then("^the system presents a dialog$")
	public void the_system_presents_a_dialog() throws Throwable {
		//loginPage.verifyNoLoginDialogbox();
		//loginMethods.verifyNoLoginDialogbox();
		Assert.assertEquals("You have been granted access to any organizations that use the Frontline Insights Platform",
				loginMethods.verifyNoLoginDialogbox(),"You have not been granted access to any organizations that use the Frontline Insights Platform.");

	}

	@And("^the user verify that Unlock code page should not displayed")
	public void user_verify_unlock_code_page_should_not_displayed() throws Throwable {
		Assert.assertTrue("Unlock code page is displayed", loginMethods.verifyUnlockCodePage());
	}

//	@When("^user selects the org with only role as sub$")
//	public void user_selects_the_org_with_only_role_as_sub() throws Throwable {
//		loginPage.orgWithOnlySubRole();
//	}
//
//	@When("^user clicks on back button$")
//	public void user_clicks_on_back_button() throws Throwable {
//		loginPage.clickBackBtn();
//	}
//
//	@Then("^a dialogue box is displayed$")
//	public void a_dialogue_box_is_displayed() throws Throwable {
//		loginPage.VerifyMessage();
//	}
}
