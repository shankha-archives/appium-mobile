package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import mobile.frontline.pages.SubmitTimesheetScreen;
import org.junit.Assert;

public class SubmitTimesheetScreenStepDef {
SubmitTimesheetScreen submitTimesheetScreen = new SubmitTimesheetScreen();

    @Then("Click on submit timesheet")
    public void clickOnSubmitTimesheet() {
        submitTimesheetScreen.submitTimesheet();
    }

    @Then("Click on undo option")
    public void clickOnUndoOption() throws Exception {
        submitTimesheetScreen.clickUndoTimesheet();
    }

    @And("Enter digital pin")
    public void enterDigitalPin() {
        submitTimesheetScreen.enterTimesheetsWithIncorrectPin();
    }

    @Then("^verify the invalid pin message$")
    public void verify_the_invalid_pin_message() throws Throwable {
        Assert.assertEquals("The message for invalid pin is incorrect","Invalid PIN", submitTimesheetScreen.toastMessge());
    }

    @Then("Click on undo again")
    public void clickOnUndoAgain() {
        submitTimesheetScreen.clickUndoButton();
    }
}
