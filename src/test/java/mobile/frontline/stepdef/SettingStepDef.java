package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.TestDataManager;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.JobsMethods;
import mobile.frontline.pages.LoginPage;
import mobile.frontline.pages.SettingsPage;
import mobile.frontline.pages.SmokeMethods;
import org.junit.Assert;

public class SettingStepDef {

	public SettingsPage settingsPage = new SettingsPage();
	public LoginPage loginPage = new LoginPage();
	public BasePage common = new BasePage();
	public TestDataManager testdata = new TestDataManager();
	public SmokeMethods smokePage = new SmokeMethods();
	public JobsMethods jobPage = new JobsMethods();

	@When("^click on menu and tap the Calendar link$")
	public void click_on_menu_and_cakendar() throws Throwable {
		settingsPage.openMenuCalendar();
	}

	@Then("^verify the calendar$")
	public void verify_the_calendar() throws Throwable {
		settingsPage.verifyCalendar();
	}

	@When("^click on Avalaible Jobs link")
	public void click_on_available_jobs_link() throws Throwable {
		settingsPage.avaialbleJobsLink();
	}

	@Then("^verify Job List tab bar for available and accepted jobs")
	public void verify_Job_List_tab() throws Throwable {
		settingsPage.jobListTab();
	}

	// MOB-4809
	@Then("^User click on the send Diagnostics option and click on Okay button$")
	public void user_click_on_the_send_diagnostics_option_and_click_on_okay_button() throws Throwable {
		settingsPage.clickOnSendDiagnosticBtn();
	}

	@And("^Long press on Frontline Logo at bottom of the screen$")
	public void long_press_on_frontline_logo_at_bottom_of_the_screen() throws Throwable {
		settingsPage.LongPressOnFrontline_setting();
	}

	// MOB-4803
	@When("click on available job widget")
	public void clickOnAvailableJobWidget() throws Throwable {
		settingsPage.avaialbleJobsLink();
		jobPage.clickOnAvailableJobs();
	}

	@When("accept the job")
	public void acceptTheJob() throws Throwable {
		settingsPage.viewDetails();
		jobPage.clickOnAcceptJobsBtn();
		jobPage.clickOnOkBtn_successMsg();
	}

	@Then("go to calender and view the accepted job")
	public void goToCalenderAndViewTheAcceptedJob() throws Exception {
		settingsPage.viewInCalendar();
	}

	// 4808
	@Then("^The user moves to Next Scheduled Job widget and verify it")
	public void user_verifies_next_scheduled_job_widget() throws Throwable {
		settingsPage.verifyNextScheduledJobWidget();
	}

	// 4796
	@And("^the user verify that Unlock code page should not displayed")
	public void user_verify_unlock_code_page_should_not_displayed() throws Throwable {
		settingsPage.verifyUnlockCodePage();
	}

	@Then("Enter multiorg username and password and click on SignIn button")
	public void enterMultiorgUsernameAndPasswordAndClickOnSignInButton() throws Throwable {
		loginPage.verify_loginPageLoaded();
		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "multiorglogin"));
		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "multiorgpass"));
		loginPage.clickOnLoginBtn();
	}

	@When("Select the Organization")
	public void selectTheOrganization() {
		settingsPage.selectOrg();
	}

	@When("click on switch")
	public void clickOnSwitch() {
		jobPage.clickSwitchbtn();
	}
	
	//MOB-6033
	@Then("^click and verify the Denied panel$")
	public void click_and_verify_denied_panel() throws Throwable {
		settingsPage.clickAndVerifyDeniedPanel();
	}
	
	//MOB-6019
	@Then("^click on add timesheet and change InTime$")
	public void click_on_add_timesheet_and_change_InTime() throws Throwable {
		settingsPage.addTimesheetAndChangeIntime();
	}
		
	@Then("^Verify that InTime should not changes$")
	public void verify_that_InTime_should_not_changes() throws Throwable {
		settingsPage.verifyInTime();
	}
}
