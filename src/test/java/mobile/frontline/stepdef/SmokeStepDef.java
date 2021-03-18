package mobile.frontline.stepdef;

import java.util.Properties;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.PropertyManager;
import mobile.Frontline.utils.TestDataManager;
import mobile.Frontline.utils.TestUtils;
import mobile.frontline.pages.*;
//import mobile.frontline.pages.JobsMethods;

//import mobile.frontline.pages.TimesheetMethods;

public class SmokeStepDef {

	public LoginPage loginPage = new LoginPage();
	//public JobsMethods jobulatorPage = new JobsMethods();
	public BasePage basePage = new BasePage();
	public TestDataManager testdata = new TestDataManager();
	public SmokeMethods smokePage = new SmokeMethods();
	public APIServices apiService = new APIServices();
	public LoginScreen loginMethods = new LoginScreen();
	//public TimesheetMethods timesheetpage = new TimesheetMethods();

	TestUtils utils = new TestUtils();
	Properties props;

//	@And("^Enter username and password and click on Sign In button$")
//	public void enter_username_and_password_and_click_on_sign_in_button() throws Throwable {
//		loginPage.verify_loginPageLoaded();
//		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "substitutelogin"));
//		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "substitutepass"));
//		loginPage.clickOnLoginBtn();
//	}



	@And("^The user kill and relaunch the application$")
	public void the_user_kill_and_relaunch_the_application() throws Throwable {
		basePage.bgRunningApp();
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

	@And("^Enter admin username \"([^\"]*)\" and password and click on Sign In button$")
	public void enter_admin_username_something_and_password_and_click_on_sign_in_button(String userName)
			throws Throwable {
		loginPage.verify_loginPageLoaded();
		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", userName));
		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "FrontlinePassword"));
		loginPage.clickOnLoginBtn();
	}



	@When("^the user waits and launches the app$")
	public void the_user_waits_and_launches_the_app() throws Throwable {
		loginPage.waitAndverify_splashScreenLoaded();
	}

	@Then("^the admin user click on Get Started Button and enter the pin$")
	public void the_admin_user_click_on_get_started_button_and_enter_the_pin() throws Throwable {
		loginPage.clickOnGetStartedBtn();
	}

	@Then("^the admin navigates to dashboard page$")
	public void the_admin_navigates_to_dashboard_page() throws Throwable {
		loginPage.verify_homeScreen_displayedWithoutPushVerify();
	}

	// MOB-4259
	@And("^click on timesheets widget and view timesheets$")
	public void click_on_timesheets_widget_and_view_timesheets() throws Throwable {
		smokePage.viewWeekTimesheets();
	}

	@Then("^click on any day to view timesheet$")
	public void click_on_any_day_to_view_timesheet() throws Throwable {
		smokePage.viewDayTimesheets();
	}

	// MOB-4255
	@And("^Enter employee username and password and click on SignIn button$")
	public void enter_employee_username_and_password_and_click_on_sign_in_button() throws Throwable {
		loginPage.verify_loginPageLoaded();
		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "employeelogin"));
		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "employeepass"));
		loginPage.clickOnLoginBtn();
	}

	@Then("Enter employee username and password with directory access and click on SignIn button")
	public void enterEmployeeUsernameAndPasswordWithDirectoryAccessAndClickOnSignInButton() throws Throwable {
		loginPage.verify_loginPageLoaded();
		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "directoryLogin"));
		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "directorypass"));
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

	// MOB-4253
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

	// @MOB-4233 // @MOB-4234
	@When("^click on menu bar$")
	public void click_on_menu() throws Throwable {
		smokePage.clickOnMenuTab();
	}

	@Then("^enter the search text in bar and click on result$")
	public void enter_search_text() throws Throwable {
		smokePage.enterSearchText(testdata.read_property("testingData", "users", "searchText"));
		smokePage.clickOnResult();
	}

	@And("^verify the search result$")
	public void verify_the_search_result() throws Throwable {
		smokePage.verifySearchResult();
	}

	// @MOB-4235
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

	@When("^enter \"([^\"]*)\" select reason date length summary for \"([^\"]*)\"$")
	public void enter_something_select_reason_date_length_summary_for_something(String empAbsence, String absenceDay)
			throws Throwable {// page 1
		smokePage.enterTeachersName(testdata.read_property("testingData", "users", empAbsence));
		smokePage.selectTeachersName(testdata.read_property("testingData", "users", empAbsence));

		smokePage.clickNext();
		// page 3
		smokePage.absenceReason();
		smokePage.clickNext();
		// page 4
		smokePage.selectDate(absenceDay);
		smokePage.clickNext();
		// page 5
		smokePage.selectReason();
		smokePage.clickNext();
		// page 6
		smokePage.substituteAssignPageVerification();
		smokePage.clickNext();
	}

	@Then("^submit view absence and get confirmation number of employee$")
	public void submit_view_absence_and_get_confirmation_number_of_employee() throws Throwable {
		smokePage.submitAbsence();
		smokePage.viewAbsence();
		String confNumber = smokePage.getConfirmationForEmployee();
	}

	@Then("^submit absence and verify the alert$")
	public void submit_absence_and_verify_the_alert() throws Throwable {
		smokePage.submitAbsence();
		smokePage.verifyAbsenceCreationPopup();
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
	public void clickOnTheApprovalWidgetAndNavigatesToTheApprovalAbsencePage() throws Throwable {
		smokePage.selectAbsenceApprovalWidget();
		smokePage.verifyAbsenceApprovalPage();
	}

	@When("selected approved a job")
	public void selectedApprovedAJob() throws Exception {
		smokePage.storeAbsenceDetails();
		smokePage.selectApproveConfirmAbsence();
	}

	@Then("the job is no longer in the list for approval")
	public void theJobIsNoLongerInTheListForApproval() throws Exception {
		smokePage.verifyAcceptedAbsence();
	}

	// @MOB-4269
	@When("^the user clicks on Menu tab and click on Settings$")
	public void the_user_clicks_on_Menu_tab_and_click_on_Settings() throws Throwable {
		smokePage.clickOnSetting();
	}

	// @MOB-4269
	@Then("^the user toggle the Dark Mode$")
	public void the_user_toggle_the_dark_mode() throws Throwable {
		smokePage.toggleDarkMode();
		smokePage.screenshotCapture();
	}

	@Then("^Verify the dark mode btn and toggle the Dark Mode and Logout from app$")
	public void verify_the_dark_mode_btn_and_toggle_the_dark_mode_and_logout_from_app() throws Throwable {
		smokePage.toggleDarkMode();
		smokePage.clickLogoutbtn();
	}

	@Then("^Verify the dark mode button$")
	public void verify_the_dark_mode_button() throws Throwable {
		smokePage.verifytoggledDarkMode();
	}

	@And("^pulls to refresh the page$")
	public void pulls_to_refresh_the_page() throws Throwable {
		smokePage.pullToRefresh();
	}



	@Then("Enter employee username and password and click on Sign In button")
	public void enterEmployeeUsernameAndPasswordAndClickOnSignInButton() throws Throwable {
		loginPage.verify_loginPageLoaded();
		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "teacherlogin"));
		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "teacherpass"));
		loginPage.clickOnLoginBtn();
	}

	@And("^Enter employee username \"([^\"]*)\" and password and click on Sign In button$")
	public void enter_employee_username_something_and_password_and_click_on_sign_in_button(String AutomationEmployee)
			throws Throwable {
		loginPage.verify_loginPageLoaded();
		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", AutomationEmployee));
		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "FrontlinePassword"));
		loginPage.clickOnLoginBtn();
	}

	@Then("Enter employee username and password for inbox and click on Sign In button")
	public void enterEmployeeUsernameAndPasswordForInboxAndClickOnSignInButton() throws Throwable {
		loginPage.verify_loginPageLoaded();
		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "inboxteachlogin"));
		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "inboxteachpass"));
		loginPage.clickOnLoginBtn();
	}

	@Then("the employee navigates to dashboard page")
	public void theEmployeeNavigatesToDashboardPage() throws Throwable {
		loginPage.verify_homeScreen_displayedWithoutPushVerify();
	}

	@And("^click on the create absences$")
	public void click_on_the_create_absences() throws Throwable {
		smokePage.clickCreateAbs();
	}

	@When("^select reason date length summary for \"([^\"]*)\"$")
	public void select_reason_date_length_summary_for_something(String absenceDay) throws Throwable {
		smokePage.absenceReason();
		smokePage.clickNext();
		// page 4
		smokePage.selectDate(absenceDay);
		smokePage.clickNext();
		// page 5
		smokePage.selectReason();
		smokePage.clickNext();
		// page 6
		smokePage.substituteAssignPageVerification();
		smokePage.clickNext();
	}

	// @MOB-4275
	@When("^the user clicks on Back button and click on Feedback$")
	public void the_user_clicks_on_Back_btn_and_click_on_Feedback() throws Throwable {
		smokePage.clickOnFeedback();
	}

	// @MOB-4275
	@Then("^the user send the feedback$")
	public void the_user_send_the_Feedback() throws Throwable {
		smokePage.sendFeedback();
	}

	// MOB-4265
	@When("click on the inbox")
	public void clickOnTheInbox() throws Throwable {
		smokePage.clickInbox();
		smokePage.verifyInboxPage();
	}

	@Then("view the message in the inbox")
	public void viewTheMessageInTheInbox() {
		smokePage.viewText();
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

	@Then("verify the order of widgets")
	public void verifyTheOrderOfWidgets() {
		smokePage.verifyWidgetsOrder();
	}

	// MOB-4261
	@When("employee clicks on the timesheet widget")
	public void employeeClicksOnTheTimesheetWidget() throws Throwable {
		smokePage.clickTimesheetWidget();
	}

	@Then("^Verify total time of the Week$")
	public void verify_total_time_of_the_week() throws Throwable {
		smokePage.clickOnBack();
		smokePage.weekTotalTime();
		smokePage.verifyWeekTotalTime();
	}

	@When("click back button and open the past day timesheet and add a new time sheet")
	public void openThePastDayTimesheetAndAddANewTimeSheet() throws Throwable {
		smokePage.clickOnBack();
		smokePage.addTimeSheet();
		smokePage.goToEditDeleteTimeSheetOption();
	}

	@Then("user edits the timesheet")
	public void userEditsTheTimesheet() throws Throwable {
		smokePage.editTimeCommentToTimesheet();
		smokePage.verifyEditedComment();
	}

	@Then("Delete the timesheet")
	public void deleteTheTimesheet() throws Throwable {
		smokePage.deleteTimesheet();
	}

	// MOB-4237
	@When("^the employee creates an absence for \"([^\"]*)\"$")
	public void the_employee_creates_an_absence_for_something(String absenceDay) throws Throwable {
		smokePage.clickCreateAbs();

		smokePage.selectLocation();
		smokePage.clickNext();

		smokePage.absenceReason();
		smokePage.clickNext();
		// page 4
		smokePage.selectDate(absenceDay);
		smokePage.clickNext();
		// page 5
		smokePage.selectReason();
		smokePage.clickNext();
		// page 6
		smokePage.substituteAssignPageVerification();
		smokePage.clickNext();
		smokePage.submitAbsence();
		smokePage.viewAbsence();
	}

	@When("the user opens the calendar through menu")
	public void theUserOpensTheCalendarThroughMenu() throws Throwable {
		smokePage.getAbsenceDetailsForCalendar();
		loginPage.verify_homeScreen_displayedWithoutPushVerify();
	}

	@Then("tap on the day when absence was created")
	public void tapOnTheDayWhenAbsenceWasCreated() throws Exception {
		smokePage.clickCalender();
	}

	@Then("the event will be displayed tap on it to view or verify the details")
	public void theEventWillBeDisplayedTapOnItToViewOrVerifyTheDetails() {
		smokePage.verifyAbsenceConfandDuration();
	}

	@When("Employee clicks on the clockin btn")
	public void employeeClicksOnTheClockinBtn() throws Throwable {
		smokePage.clockInVerification();
	}

	@Then("the user clocks out through timesheet")
	public void the_user_clocks_out_through_timesheet() throws Throwable {
		smokePage.clockOutThroughTimesheet();
		smokePage.verifyClockOut();
	}

	// MOB-4277
	@When("Select the required organization")
	public void selectTheRequiredOrganization() {
		loginPage.orgPickerPageLoads();
		smokePage.selectOrganization();
	}

	@Then("click on People widget")
	public void clickOnPeopleWidget() throws Throwable {
		smokePage.clickPeopleWidget();
	}

	@When("search for a person")
	public void searchForAPerson() throws Exception {
		smokePage.SerachName(testdata.read_property("testingData", "users", "lastName"));
	}

	@Then("user details are displayed")
	public void userDetailsAreDisplayed() {
		smokePage.verifyContactDetails();
	}

	@When("click on reorder widget and rearrange the widget")
	public void clickOnReorderWidgetAndRearrangeTheWidget() throws Throwable {
		loginPage.verify_homeScreen_displayedWithoutPushVerify();
		smokePage.getListOrderAfterReorder();
	}

	@When("^Click on reorder widget$")
	public void click_on_reorder_widget() throws Throwable {
		smokePage.getListOrderBeforeReorder();
		smokePage.clickReorderWidget();
	}

	@And("^Rearrange the widets$")
	public void rearrange_the_widets() throws Throwable {
		smokePage.draganddrop();
		smokePage.saveReorderedWidget();
	}

	@Then("^Verify the order of widgets and footers present$")
	public void verify_the_order_of_widgets_and_footers_present() throws Throwable {
		loginPage.verify_homeScreen_displayedWithoutPushVerify();
		smokePage.getListOrderAfterReorder();
	}

	@And("logouts out from the application")
	public void logoutsOutFromTheApplication() {
		smokePage.logoutApplication();
	}

	@Then("verify all the widgets and footers present")
	public void verifyAllTheWidgetsAndFootersPresent() throws Exception {
		smokePage.verify_footerPresent();
	}

	@Then("click on approve btn approve a job")
	public void clickOnApproveBtnApproveAJob() {
		smokePage.selectApproveConfirmAbsence();
	}

	@And("^verify absences page is displayed$")
	public void verify_absences_page_is_displayed() throws Throwable {
		smokePage.verifyAbsencesPage();
	}

	@Then("click on the home button to navigate back to dashboard")
	public void clickOnTheHomeButtonToNavigateBackToDashboard() throws Exception {
		smokePage.clickOnHomeButtonFooter();
		loginPage.verify_homeScreen_displayedWithoutReLaunch();
	}

	@When("^Click on edit btn and edit the absence for \"([^\"]*)\"$")
	public void click_on_edit_btn_and_edit_the_absence_for_something(String absenceDay) throws Throwable {
		smokePage.editCreatedAbsence(absenceDay);
		smokePage.saveEditedAbsence();
	}

	@Then("^Verify the absence details$")
	public void verify_the_absence_details() throws Throwable {
		smokePage.verifyAbsenceConfandDuration();
	}

	@When("^Verify if absences present for employee \"([^\"]*)\" with workerid \"([^\"]*)\" for \"([^\"]*)\" and delete them$")
	public void verify_if_absences_present_for_employee_something_with_workerid_something_for_something_and_delete_them(
			String apiLoginID, String workerID, String absenceDay) throws Throwable {
		props = new PropertyManager().getProps();
		if (!props.getProperty("testdata").contains("prod")) {
			apiService.apiTokenGeneration(apiLoginID);
			apiService.apiGetConfirmationIds(workerID, absenceDay);
			apiService.apiDeleteAbsence();
		} else
			utils.log().info("The environment selected is prodution");
	}

	@When("^Create absence for employee \"([^\"]*)\" with workerid \"([^\"]*)\" for \"([^\"]*)\" with \"([^\"]*)\" \"([^\"]*)\" and delete the existing ones$")
	public void create_absence_for_employee_something_with_workerid_something_for_something_with_something_something_and_delete_the_existing_ones(
			String apiLoginID, String workerID, String absenceDay, String schoolID, String reasonID) throws Throwable {
		props = new PropertyManager().getProps();
		if (!props.getProperty("testdata").contains("prod")) {
			apiService.apiTokenGeneration(apiLoginID);
			apiService.apiGetConfirmationIds(workerID, absenceDay);
			apiService.apiDeleteAbsence();
			apiService.apiCreateAbsence(workerID, absenceDay, schoolID, reasonID);
		} else
			utils.log().info("The environment selected is prodution");
	}

	@Then("^Tap on the day of created absence for \"([^\"]*)\" in the app Calendar$")
	public void tap_on_the_day_of_created_absence_for_something_in_the_app_calendar(String absenceDay)
			throws Throwable {
		smokePage.getAbsenceDateForCalendar(absenceDay);
	}

	@And("^Verify the absence in Calendar$")
	public void verify_the_absence_in_calendar() throws Throwable {
		smokePage.verifyAbsence();
	}

	@And("^Select an unfilled and unassigned absence for \"([^\"]*)\"$")
	public void select_an_unfilled_and_unassigned_absence_for_something(String absenceDay) throws Throwable {
		smokePage.selectAbsenceWidget();
		smokePage.selectUnfilledUnassignedAbsence(testdata.read_property("testingData", "users", "UnFilledUnassigned"),
				absenceDay);
	}

	@When("^Verify if timesheet present for an employee and delete it using information \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_if_timesheet_present_for_an_employee_and_delete_it_using_information_something_something_something_something_something(
			String automationEmployee, String workerID, String orgID, String apiLoginID, String timesheetDay)
			throws Throwable {
		props = new PropertyManager().getProps();
		if (!props.getProperty("testdata").contains("prod")) {
			apiService.apiTokenGeneration(apiLoginID);
			apiService.apiBearerTokenGeneration(automationEmployee);
			apiService.apiGetTimesheetsForWeek(timesheetDay, orgID, workerID);
			apiService.apiDeleteTimeEvents(orgID, workerID);
			apiService.apiCreateTimesheet(orgID, workerID, timesheetDay);
		} else
			utils.log().info("The environment selected is prodution");
	}
}
