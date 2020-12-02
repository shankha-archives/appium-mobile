package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.SmokeMethods;
import mobile.frontline.pages.TimesheetMethods;

import java.io.IOException;

public class TimesheetsStepDef {

	public SmokeMethods smokePage = new SmokeMethods();
	public TimesheetMethods timesheetPage = new TimesheetMethods();

	@When("open the past day timesheet and add a new time sheet")
	public void openThePastDayTimesheetAndAddANewTimeSheet() throws Throwable {
		smokePage.addTimeSheet();
		smokePage.goToEditDeleteTimeSheetOption();
	}

	@When("click on timesheet option")
	public void clickOnTimesheetOption() throws Exception {
		smokePage.clickTimesheetOption();
	}

	@Then("click on day and submit day timesheet option")
	public void clickOnDayAndSubmitDayTimesheetOption() throws Throwable {
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
		timesheetPage.verifySubmitTimesheetBtnNotDisplayed();
		smokePage.addTimeSheet();
		timesheetPage.timesheetNonEditablePopup();
	}

	@When("Add a new timesheet")
	public void addANewTimesheet() throws Throwable {
		timesheetPage.AddTimesheet();
	}

	@Then("verify work total time this week to be greater than zero")
	public void verifyWorkTotalTimeThisWeekToBeGreaterThanZero() throws Exception {
		timesheetPage.verifyWeekTime();
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
}