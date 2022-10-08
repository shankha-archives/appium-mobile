package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.TestDataManager;
import mobile.frontline.pages.*;
import org.junit.Assert;

public class LoginScreenStepDef {

	public TestDataManager testdata = new TestDataManager();
	public LoginScreen loginMethods = new LoginScreen();

//	public RolePickerScreen  rolePickerScreen = new RolePickerScreen();

	@When("the user launches the app")
	public void theUserLaunchesTheApp() throws Throwable {
		Assert.assertTrue("Splash screen is not loading",loginMethods.waitSplashScreenLoaded());
//		Thread.sleep(3000);
	}

	@When("^The user waits and launches the app$")
	public void the_user_waits_and_launches_the_app() throws Throwable {
		Assert.assertTrue("Waiting and searching for get started",loginMethods.waitAndverify_splashScreenLoaded());
	}

	@Then("The user click on Get Started Button")
	public void user_click_on_get_started_button() throws Throwable {
//		Thread.sleep(3000);
		loginMethods.clickOnGetStartedBtn();
	}

	@Then("^the user is taken to the Login Page$")
	public void the_substitute_user_is_taken_to_the_login_page() throws Throwable {
		Thread.sleep(10000);
		Assert.assertTrue("Login page is not loaded",loginMethods.verify_loginPageLoaded());
	}

	@And("^Enter username \"([^\"]*)\" and password and click on Sign In button$")
	public void enter_username_something_and_password_and_click_on_sign_in_button(String username) throws Throwable {
		Thread.sleep(10000);
		loginMethods.loginToApplication(testdata.read_property("Account", "valid", username),testdata.read_property("Account", "valid", "FrontlinePassword") );
	}

/*	@And("^the substitute enter \"([^\"]*)\" \"([^\"]*)\" username$")
	public void the_substitute_enter_something_something_username(String type, String username) throws Throwable {
		loginMethods.enterUserName(testdata.read_property("Account", type, username));
	}*/

/*	@And("^the substitute enter \"([^\"]*)\" \"([^\"]*)\" password$")
	public void the_substitute_enter_something_something_password(String type, String password) throws Throwable {
		loginMethods.enterUserPassword(testdata.read_property("Account", type, password));
	}*/

	@When("^Click on Sign In with Frontline ID button$")
	public void click_on_sign_in_with_frontline_id_button() throws Throwable {
		loginMethods.clickOnLoginBtn();
	}

	
	@Then("^Incorrect username and password error message displays$")
	public void incorrect_username_and_password_error_message_displays() throws Throwable {
		Assert.assertTrue("No Invalid Credentials error message is displayed", loginMethods.waitForInvalidCredentials_errorMessage());
	}

	@Then("^Error message displays to the substitute users$")
	public void error_message_displays_to_the_substitute_users() throws Throwable {
		Assert.assertTrue("Your username is required error message is not displayed", loginMethods.waitNoUserName_errorMessage());
		Assert.assertTrue("Your username is required error message is not displayed",loginMethods.waitNoPassword_errorMessage());
	}

	@Then("^the system presents a dialog$")
	public void the_system_presents_a_dialog() {
		Assert.assertEquals("You have been granted access to any organizations that use the Frontline Insights Platform",
				loginMethods.waitNoLoginDialogbox(),"You have not been granted access to any organizations that use the Frontline Insights Platform.");
	}

	@And("^the user verify that Unlock code page should not displayed")
	public void user_verify_unlock_code_page_should_not_displayed() throws Throwable {
		Assert.assertTrue("Unlock code page is displayed", loginMethods.waitUnlockCodePage());
	}
}
