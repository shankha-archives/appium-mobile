package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import mobile.frontline.pages.TimeEventScreen;
import org.junit.Assert;

public class TimeEventScreenStepDef {

TimeEventScreen timeEventScreen = new TimeEventScreen();


    @And("Click on edit timesheet btn")
    public void clickOnEditTimesheetBtn() {
        timeEventScreen.timeEntryEditBtnClick();
    }

    @When("Navigate back to dayView")
    public void navigateBackToDayView() {
        Assert.assertTrue("Edit btn is not displayed",timeEventScreen.verifyEditbtnVisible());
        timeEventScreen.navigateToDayView();
    }
}
