package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.SubmitTimesheetScreen;

public class SubmitTimesheetScreenStepDef {
SubmitTimesheetScreen submitTimesheetScreen = new SubmitTimesheetScreen();

    @Then("Click on submit timesheet")
    public void clickOnSubmitTimesheet() {
        submitTimesheetScreen.submitTimesheet();
    }

    @Then("Click on undo option")
    public void clickOnUndoOption() throws Exception {
        submitTimesheetScreen.clickUndoTimesheet();
        Thread.sleep(10000);
    }
}
