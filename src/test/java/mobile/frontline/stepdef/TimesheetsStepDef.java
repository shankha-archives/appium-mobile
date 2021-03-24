package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.PropertyManager;
import mobile.Frontline.utils.TestUtils;
import mobile.frontline.pages.APIServices;
import mobile.frontline.pages.SmokeMethods;
import mobile.frontline.pages.TimesheetMethods;

import java.io.IOException;
import java.util.Properties;

public class TimesheetsStepDef {

    public SmokeMethods smokePage = new SmokeMethods();
    public TimesheetMethods timesheetPage = new TimesheetMethods();
    Properties props;
    public APIServices apiService = new APIServices();
    TestUtils utils = new TestUtils();

    @When("open the past day timesheet and add a new time sheet")
    public void openThePastDayTimesheetAndAddANewTimeSheet() throws Throwable {
        smokePage.addTimeSheet();
        smokePage.goToEditDeleteTimeSheetOption();
    }

    @When("click on timesheet option")
    public void clickOnTimesheetOption() throws Throwable {
        smokePage.clickTimesheetWidget();
    }

    @Then("Submit day timesheet option and verify submission")
    public void clickOnDayAndSubmitDayTimesheetOptionAndVerifySubmission() throws Throwable {
        smokePage.selectCurrentDayForTimesheet();

        timesheetPage.submitDayTimesheet();
        timesheetPage.verifySubmission();
    }

    @Then("Take the screenshot")
    public void takeTheScreenshot() throws IOException {
        smokePage.screenshotCapture();
    }

    @Then("verify no timesheet added and no submit btn is displayed")
    public void verifyNoTimesheetAddedAndNoSubmitBtnIsDisplayed() throws Throwable {
       // timesheetPage.verifySubmitTimesheetBtnNotDisplayed();
        smokePage.addTimeSheet();
        timesheetPage.timesheetNonEditablePopup();
    }

    @When("Add a new timesheet")
    public void addANewTimesheet() throws Throwable {
        smokePage.selectCurrentDayForTimesheet();
        timesheetPage.AddTimesheet();
    }

    @And("add timesheet and verify time event")
    public void addTimesheetAndVerifyTimeEvent() throws Throwable {
        String Intime = timesheetPage.addNewTimesheet();
        timesheetPage.verifyTimesheet(Intime);
    }

    @Then("verify the deleted timesheet")
    public void verifyDeletedTimesheet() throws Throwable {
        timesheetPage.verifyDeletedTimesheet();
    }

    @Then("Timesheets is not submitted")
    public void timesheetsIsNotSubmitted() throws Throwable {
        smokePage.submitTimesheet();
    }

    @And("^verify timesheets submit btn not displayed$")
    public void verify_timesheets_submit_btn_not_displayed() throws Throwable {
        timesheetPage.verifySubmitTimesheetBtnNotDisplayed();
    }

    @And("^user verify the current pay period of timesheet on dashboard$")
    public void user_verify_current_pay_period() throws Throwable {
        timesheetPage.verifyPayPeriod();
    }

    @And("^Verify the View More link under Absence Widget$")
    public void verify_ViewMore_Link() throws Throwable {
        timesheetPage.verifyViewMore();
    }

    @When("^Click on submit btn with wrong entering pin$")
    public void click_on_submit_btn_with_wrong_entering_pin() throws Throwable {
        smokePage.submitTimesheet();
        timesheetPage.submitTimesheetsWithIncorrectPin();
    }

    @Then("^verify the invalid pin message$")
    public void verify_the_invalid_pin_message() throws Throwable {
        timesheetPage.toastMessge();
    }

    @And("^Navigate to menu links$")
    public void navigate_to_menu_links() throws Throwable {
        timesheetPage.clickBack();
    }

    @Then("^verify the time format$")
    public void verify_the_time_format() throws Throwable {
        timesheetPage.verifyTimeFormat();
    }

    @Then("Verify Week Total after adding a timesheet")
    public void verifyWeekTotalAfterAddingATimesheet() throws Exception {
        timesheetPage.calculateTotalTimeAfterAddingTimesheet();
        smokePage.clickOnBack();
        timesheetPage.validateTotalTimeAfterAddingTimesheet();
    }

    @Then("Get the initial week total time")
    public void getTheInitialWeekTotalTime() {
        timesheetPage.getInitialWeekTotal();
    }


    @And("Verify the Timesheet total on dashboard")
    public void verifyTheTimesheetTotalOnDashboard() throws Exception {
        timesheetPage.verifyWeekTime();
    }

    @And("Select a day and add timesheet")
    public void selectADayAndAddTimesheet() throws Throwable {
        smokePage.selectCurrentDayForTimesheet();
        smokePage.addTimeSheet();
    }

//    @When("Undo submitted timesheets {string} {string} {string} {string} {string}")
//    public void undoSubmittedTimesheets(String automationEmployee, String workerID, String orgID, String apiLoginID, String timesheetDay) throws Throwable {
//		props = new PropertyManager().getProps();
//		if (!props.getProperty("testdata").contains("prod")) {
//			apiService.apiTokenGeneration(apiLoginID);
//			apiService.apiBearerTokenGeneration(automationEmployee);
//		//	apiService.apiGetTimesheetsForWeek(timesheetDay, orgID, workerID);
//		//	apiService.apiDeleteTimeEvents(orgID, workerID);
//		//	apiService.apiCreateTimesheet(orgID, workerID, timesheetDay);
//			apiService.apiUndoSubmittedTimesheets(timesheetDay, orgID, workerID);
//			apiService.apiGetTimesheetsForWeek(timesheetDay, orgID, workerID);
//			apiService.apiDeleteTimeEvents(orgID, workerID);
//			apiService.apiCreateTimesheet(orgID, workerID, timesheetDay);
//		} else
//			utils.log().info("The environment selected is prodution");
//	}

    @When("Undo submitted timesheets {string} {string} {string} {string} {string} {string} {string} {string}")
    public void undoSubmittedTimesheets(String automationEmployee, String workerID, String orgID, String apiLoginID, String timesheetDay, String locationID, String shiftID, String eventID) throws Throwable {
        props = new PropertyManager().getProps();
        if (!props.getProperty("testdata").contains("prod")) {
            apiService.apiTokenGeneration(apiLoginID);
            apiService.apiBearerTokenGeneration(automationEmployee);
            //	apiService.apiGetTimesheetsForWeek(timesheetDay, orgID, workerID);
            //	apiService.apiDeleteTimeEvents(orgID, workerID);
            //	apiService.apiCreateTimesheet(orgID, workerID, timesheetDay);
            apiService.apiUndoSubmittedTimesheets(timesheetDay, orgID, workerID);
            apiService.apiGetTimesheetsForWeek(timesheetDay, orgID, workerID);
            apiService.apiDeleteTimeEvents(orgID, workerID);
            apiService.apiCreateTimesheet(orgID, workerID, timesheetDay, locationID, shiftID, eventID);
        } else
            utils.log().info("The environment selected is prodution");
    }

    @Then("verify the decimal format")
    public void verifyTheDecimalFormat() throws Exception {
        timesheetPage.verifyDecimalFormat();
    }
}