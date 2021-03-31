package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.GlobalParams;
import mobile.frontline.pages.TimesheetDayViewScreen;
import org.junit.Assert;

public class TimesheetDayViewScreenStepDef {

    TimesheetDayViewScreen timesheetDayViewScreen = new TimesheetDayViewScreen();

    @And("Verify time event is visible")
    public void verifyTimeEventIsVisible() {
        Assert.assertTrue("There is no timeevent", timesheetDayViewScreen.verifyTimeEventPresent());
    }

    @And("Click on time event")
    public void clickOnTimeEvent() throws InterruptedException {
        timesheetDayViewScreen.clickTimeEvent();
    }

    @Then("Verify the added event")
    public void verifyTheAddedEvent() {
        timesheetDayViewScreen.verifyTimeEvent();
    }

    @And("Click on add new time event")
    public void clickOnAddNewTimeEvent() {
        timesheetDayViewScreen.clickAddTimeEvent();
    }

    @When("Navigate back to week View")
    public void navigateBackToWeekView() throws InterruptedException {
        Assert.assertTrue("Day view page is not displayed", timesheetDayViewScreen.waitForDayViewScreen());
        timesheetDayViewScreen.clickBackBtn();
    }

    @Then("Verify deleted time event")
    public void verifyDeletedTimeEvent() {
        Assert.assertTrue("No time event pop up is not displayed", timesheetDayViewScreen.verifyNoTimeEventExist());
    }
}
