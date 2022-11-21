package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.GlobalParams;
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
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            Assert.assertTrue("Edit btn is not displayed",timeEventScreen.verifyEditbtnVisible());
            timeEventScreen.navigateToDayView();
        }
    }

    @And("Verify the added comment")
    public void verifyTheAddedComment() throws Throwable {
        Assert.assertEquals("The comment displayed is not matching",timeEventScreen.verifyEditedComment(), "Automation Smoke Test");
    }

    @When("Delete time event")
    public void deleteTimeEvent() throws Throwable {
        timeEventScreen.clickDeleteTimesheet();
        timeEventScreen.clickOkPopUp();
    }

    @Then("Time event details page must load")
    public void timeEventDetailsPageMustLoad() {
        Assert.assertTrue("Verifying in TimeEvent details page is loaded", timeEventScreen.verifyEventDetailsLoaded());
    }
}
