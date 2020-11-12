package mobile.frontline.stepdef;

import io.cucumber.java.en.When;
import mobile.frontline.pages.SmokeMethods;

public class TimesheetsStepDef {

	public SmokeMethods smokePage = new SmokeMethods();

	@When("open the past day timesheet and add a new time sheet")
	public void openThePastDayTimesheetAndAddANewTimeSheet() throws Throwable {
		smokePage.addTimeSheet();
		smokePage.goToEditDeleteTimeSheetOption();
	}
}
