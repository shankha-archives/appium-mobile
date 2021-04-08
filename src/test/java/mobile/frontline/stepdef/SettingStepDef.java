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

public class SettingStepDef {

	public SettingsPage settingsPage = new SettingsPage();
	public LoginPage loginPage = new LoginPage();
	public BasePage common = new BasePage();
	public TestDataManager testdata = new TestDataManager();
	public SmokeMethods smokePage = new SmokeMethods();
	public JobsMethods jobPage = new JobsMethods();
	
	String confNumber;

	@When("^click on menu and tap the Calendar link$")
	public void click_on_menu_and_cakendar() throws Throwable {
		settingsPage.openMenuCalendar();
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

//	@When("^click on job widget and select the job \"([^\"]*)\"$")
//    public void click_on_job_widget_and_select_the_job_something(String jobByEmp) throws Throwable {
//        jobPage.clickOnAvailableJobs_displayed();
//		jobPage.clickOnAvailableJobs(jobByEmp);
//    }

	
//	@When("accept the job")
//	public void acceptTheJob() throws Throwable {
//		settingsPage.viewDetails();
//		jobPage.clickOnAcceptJobsBtn();
//		jobPage.clickOnOkBtn_successMsg();
//	}

//	@Then("go to calendar and view the accepted job")
//	public void goToCalenderAndViewTheAcceptedJob() throws Exception {
//		settingsPage.viewInCalendar();
//	}

	// 4808


	// 4796

	@When("Select the Organization")
	public void selectTheOrganization() {
		jobPage.selectOrg();
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
	
	//MOB-6025 
    @Then("^The user verifies that Login page is displayed$")
	public void User_verifies_login_page() throws Throwable {
		loginPage.verify_loginPageLoaded();
	}
	
	@Then("^Verify that Login page is displayed after logout$")
	public void Verify_login_page_after_logout() throws Throwable {
		loginPage.verify_loginPageLoaded();
	}
	
	//MOB-6021
	 @Then("^Click on View Absence and move to dashboard$")
	    public void click_on_view_absence_and_move_to_dashboard() throws Throwable {
		 smokePage.viewAbsence();
		 confNumber = smokePage.getConfirmationForEmployee();
		 settingsPage.getEmployeeName();
	 }
	 
	 @Then("^Move to absence today widget and verify the absence$")
	    public void move_to_absence_today_widget_and_verify_the_absence() throws Throwable {
	    settingsPage.verifyAbsenceOnDashboard();    
	 }
	 
	 @Then("^Verify that absences are visible$")
	 public void verify_that_absences_are_visible() throws Throwable {
	     settingsPage.verifyAbsenceIsVisible(confNumber);
	 }
	 
	// MOB-6030
		@When("Click on add Absence Widget")
		public void clickOnAddAbsenceWidget() throws Throwable {
			smokePage.selectAbsenceWidget();
			smokePage.verifyAbsencesPage();	
		}

		@Then("Click on any created absence and verify if crash happens")
		public void clickOnAnyCreatedAbsenceAndVerifyIfCrashHappens() {
			settingsPage.selectTodaysAbsence();
			smokePage.verifyAbsence();
		}

	@Then("go to calendar and view the accepted job for {string}")
	public void goToCalendarAndViewTheAcceptedJobFor(String absenceDay) throws Exception {
		settingsPage.viewInCalendar(absenceDay);
	}

	@When("Select other Organization")
	public void selectOtherOrganization() {
		jobPage.switchToAnotherOrg();
	}
}

