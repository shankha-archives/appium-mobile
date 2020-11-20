package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.SmokeMethods;
import mobile.frontline.pages.TimesheetMethods;

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

}
