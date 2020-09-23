package mobile.frontline.stepdef;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.TestDataManager;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.JobsMethods;
import mobile.frontline.pages.LoginPage;
import mobile.frontline.pages.SmokeMethods;

public class SmokeStepDef {

	public LoginPage loginPage = new LoginPage();
	public JobsMethods jobulatorPage = new JobsMethods();
	public BasePage basePage = new BasePage();
	public TestDataManager testdata = new TestDataManager();
	public SmokeMethods smokePage = new SmokeMethods();

	@And("^Enter username and password and click on Sign In button$")
	public void enter_username_and_password_and_click_on_sign_in_button() throws Throwable {
		loginPage.verify_loginPageLoaded();
		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "substitutelogin"));
		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "substitutepass"));
		loginPage.clickOnLoginBtn();
	}

	@And("^The user kill and relaunch the application$")
	public void the_user_kill_and_relaunch_the_application() throws Throwable {
		basePage.killAndRelaunch();
	}

	// @MOB-4229
	@And("^The user minimize and relaunch the application$")
	public void the_user_minimize_and_relaunch_the_application() throws Throwable {
		basePage.bgRunningApp();
	}

	@And("^Enter admin username and password and click on Sign In button$")
	public void enter_admin_username_and_password_and_click_on_sign_in_button() throws Throwable {
		loginPage.verify_loginPageLoaded();
		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "adminlogin"));
		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "adminpass"));
		loginPage.clickOnLoginBtn();
	}

	@When("^the admin user launches the app$")
	public void the_admin_user_launches_the_app() throws Throwable {
		loginPage.verify_splashScreenLoaded();
	}

	@Then("^the admin user click on Get Started Button and enter the pin$")
	public void the_admin_user_click_on_get_started_button_and_enter_the_pin() throws Throwable {
		loginPage.clickOnGetStartedBtn();
		loginPage.enterUnlockCode();
	}
	
	
	@Then("^the admin navigates to dashboard page$")
	public void the_admin_navigates_to_dashboard_page() throws Throwable {
		loginPage.verify_homeScreen_displayed();

	}
	
	//MOB-4259
	@And("^click on timesheets widget and view timesheets$")
	public void click_on_timesheets_widget_and_view_timesheets() throws Throwable {
		smokePage.viewWeekTimesheets();
	}
	
	@Then("^click on any day to view timesheet$")
	public void click_on_any_day_to_view_timesheet() throws Throwable {
		smokePage.viewDayTimesheets();
	}
	
	//MOB-4255
	@And("^Enter employee username and password and click on SignIn button$")
	public void enter_employee_username_and_password_and_click_on_sign_in_button() throws Throwable {
		loginPage.verify_loginPageLoaded();
		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "employeelogin"));
		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "employeepass"));
		loginPage.clickOnLoginBtn();
	}
	
	@And("^click on Available Leave Balances and view leave balances$")
	public void click_on_available_leave_balance() throws Throwable {
		smokePage.clickOnAvailableLeaveBalance_displayed();
	}
	
	@Then("^verify available days$")
	public void verify_available_days() throws Throwable {
		smokePage.verify_availableDays();
	}

	@And("^click on the absences then add absence$")
	public void click_on_the_absences_then_add_absence() throws Throwable {
		smokePage.selectAbsenceWidget();
		smokePage.addAbsence();
	}

	//MOB-4253
	@And("^click on unfilled absence in absence widget$")
	public void click_on_absences_and_select_unfilled_absence() throws Throwable {
		smokePage.selectUnfilledAbsence();
	}

	@Then("^click on Tap to Assign and select Assign substitute$")
	public void click_on_tap_to_assign_substitute() throws Throwable {
		smokePage.click_tapToAssign();
		smokePage.assignSubstitute();
	}
	
	@And("^click Assign again to confirm$")
	public void click_assign_to_select_substitute() throws Throwable {
		smokePage.confirmAssignSubstitute();
	}
	
	//@MOB-4233
	@When("^click on menu and tap the search bar$")
	public void click_on_menu_and_search_bar() throws Throwable {
		smokePage.openMenuSearchBar();
	}
	
	@Then("^enter the search text in bar$")
	public void enter_search_text() throws Throwable {
		smokePage.enterSearchText(testdata.read_property("testingData", "users", "searchText"));
	}
	
	@And("^verify the search result$")
	public void verify_the_search_result() throws Throwable {
		smokePage.verifySearchResult();
	}
	
	//@MOB-4235
	@Then("^enter the absence search text in bar$")
	public void enter_absence_search_text_in_bar() throws Throwable {
		smokePage.enterSearchText(testdata.read_property("testingData", "users", "absenceKeyword"));
	}
	
	@And("^click the absence search result$")
	public void click_the_absence_search_result() throws Throwable {
		smokePage.click_searchResult();
	}
	
	@Then("^verify the absence detail page$")
	public void verify_the_absence_detail_page() throws Throwable {
		smokePage.verifyAbsenceDetailPage();
	}

	@When("^enter teacher select reason date length summary$")
	public void enter_teacher_select_reason_date_length_summary() throws Throwable {// page 1
		smokePage.enterTeachersName(testdata.read_property("testingData", "users", "teacher"));
		smokePage.selectTeachersName();
		smokePage.clickNext();
		// page 3
		smokePage.absenceReason();
		smokePage.clickNext();
		// page 4
		smokePage.selectDate();
		smokePage.clickNext();
		// page 5
		smokePage.selectReason();
		smokePage.clickNext();
		// page 6
		smokePage.clickNext();
	}

	@Then("^submit and view absence$")
	public void submit_and_view_absence() throws Throwable {
		smokePage.submitAbsence();
		smokePage.viewAbsence();
	}

	@And("^verify absence$")
	public void verify_absence() throws Throwable {
		smokePage.verifyAbsence();
	}

	@Then("click on the approval widget and navigates to the approval absence page")
	public void clickOnTheApprovalWidgetAndNavigatesToTheApprovalAbsencePage() {
		smokePage.selectAbsenceApprovalWidget();
		smokePage.verifyAbsenceApprovalPage();
	}

	@When("selected approved a job")
	public void selectedApprovedAJob() {
		smokePage.storeAbsenceDetails();
		smokePage.selectApproveConfirmAbsence();
	}

	@Then("the job is no longer in the list for approval")
	public void theJobIsNoLongerInTheListForApproval() {
		smokePage.verifyAcceptedAbsence();
	}
	
	 //@MOB-4269
	 @When("^the user clicks on Menu tab and click on Settings$")
	 public void the_user_clicks_on_Menu_tab_and_click_on_Settings() throws Throwable {
		 smokePage.clickOnSetting();
	 }
	 
	 //@MOB-4269
	 @Then("^the user toggle the Dark Mode$")
	 public void the_user_toggle_the_dark_mode() throws Throwable {
		 smokePage.toggleDarkMode();
         smokePage.screenshotcapture();
	 }
  
	@And("^pulls to refresh the page$")
	public void pulls_to_refresh_the_page() throws Throwable {
		smokePage.pullToRefresh();
	}
	
	//MOB-4245
	@When("the employee user launches the app")
	public void theEmployeeUserLaunchesTheApp() {
		loginPage.verify_splashScreenLoaded();   
	}

	@Then("the employee user click on Get Started Button and enter the pin")
	public void theEmployeeUserClickOnGetStartedButtonAndEnterThePin() throws Throwable {
		loginPage.clickOnGetStartedBtn();
		loginPage.enterUnlockCode();
	}

	@Then("Enter employee username and password and click on Sign In button")
	public void enterEmployeeUsernameAndPasswordAndClickOnSignInButton() throws Throwable {
		
		loginPage.verify_loginPageLoaded();
		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "teacherlogin"));
		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "teacherpass"));
		loginPage.clickOnLoginBtn();
	}

	@Then("the employee navigates to dashboard page")
	public void theEmployeeNavigatesToDashboardPage() throws Throwable {
		loginPage.verify_homeScreen_displayed();
	}

	@And("^click on the create absences$")
    public void click_on_the_create_absences() throws Throwable {
		smokePage.clickCreateAbs();
    }
	
	@When("select reason date length summary")
	public void selectReasonDateLengthSummary() throws Throwable {
		smokePage.absenceReason();
		smokePage.clickNext();
		// page 4
		smokePage.selectDate();
		smokePage.clickNext();
		// page 5
		smokePage.selectReason();
		smokePage.clickNext();
		// page 6
		smokePage.clickNext();
	}
	
	 //@MOB-4275
	 @When("^the user clicks on Menu tab and click on Feedback$")
	 public void the_user_clicks_on_Menu_tab_and_click_on_Feedback() throws Throwable {
		 smokePage.clickOnFeedback();
	 }
	 
	 //@MOB-4275
	 @Then("^the user send the feedback$")
	 public void the_user_send_the_Feedback() throws Throwable {
		 smokePage.sendFeedback();
	 }
	 
	//MOB-4265
	@When("click on the inbox")
	public void clickOnTheInbox() throws Throwable {
		smokePage.clickInbox();
		smokePage.verifyInboxPage();
	}
	
	@Then("view the message in the inbox")
	public void viewTheMessageInTheInbox() {
		smokePage.viewText();
	}
	
	//MOB-4263
	@When("click on menu then click on timesheet option")
	public void clickOnMenuThenClickOnTimesheetOption() throws Throwable {
		smokePage.clickTimesheetOption();
	}
	
	@Then("click on submit timesheet option")
	public void clickOnSubmitTimesheetOption() throws Throwable {
		smokePage.submitTimesheet();
		smokePage.enterTimeSheetdetails();
	}

	@Then("undo the timesheet")
	public void undoTheTimesheet() throws Exception {
		smokePage.undoTimesheet();
		smokePage.verifyUndo();
	}

	@When("click on reorder widget")
	public void clickOnReorderWidget() throws Throwable {
		smokePage.clickReorderWidget();
		smokePage.draganddrop();
	}

	@Then("rearrange the widget")
	public void rearrangeTheWidget() throws Throwable {
		smokePage.saveReorderedWidget();
		loginPage.verify_homeScreen_displayed();
	}

	@Then("verify the order of widgets")
	public void verifyTheOrderOfWidgets() {
		smokePage.verifyWidgetsOrder() ;
	}
	
	//MOB-4261
	@When("employee clicks on the timesheet widget")
	public void employeeClicksOnTheTimesheetWidget() throws Exception {
		smokePage.clickTimesheetOption();
	}

	@When("open the past day timesheet and add a new time sheet")
	public void openThePastDayTimesheetAndAddANewTimeSheet() throws Throwable {
		smokePage.addTimeSheet();
		smokePage.goToEditDeleteTimeSheetOption();
	  
	}

	@Then("user edits the timesheet")
	public void userEditsTheTimesheet() throws Throwable {
		smokePage.editTimesheet();    
	}

	@Then("Delete the timesheet")
	public void deleteTheTimesheet() throws Throwable {
		smokePage.deleteTimesheet();   
	}
}

