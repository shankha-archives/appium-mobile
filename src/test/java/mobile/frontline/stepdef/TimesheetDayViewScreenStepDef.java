package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.TimesheetDayViewScreen;
import org.junit.Assert;

public class TimesheetDayViewScreenStepDef {

    TimesheetDayViewScreen timesheetDayViewScreen = new TimesheetDayViewScreen();
    public static String actualTime;

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
        Assert.assertTrue("The time event is not displayed",timesheetDayViewScreen.verifyTimeEvent());
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

    @Then("Click on submit day timesheet")
    public void clickOnSubmitDayTimesheet() {
        timesheetDayViewScreen.clickSubmitDayTimesheetBtn();
    }

    @And("Verify submission of timesheet")
    public void verifySubmissionOfTimesheet() {
        Assert.assertTrue("Day Timesheet is not submitted", timesheetDayViewScreen.verifySubmission());
    }

    @When("Calculating the total week time value")
    public void calculatingTheTotalWeekTimeValue() throws InterruptedException {
        Assert.assertTrue("There is no timeevent", timesheetDayViewScreen.verifyTimeEventPresent());
        actualTime = timesheetDayViewScreen.calculateTotalTimeAfterAddingTimesheet();
    }

    @Then("verify the decimal format")
    public void verifyTheDecimalFormat() throws Exception {
        Assert.assertTrue("Time is not in h.mm format",timesheetDayViewScreen.verifyTimeFormat().equals("1.00") );
    }

    @Then("^verify the time format$")
    public void verify_the_time_format() throws Throwable {
        Assert.assertTrue("Time is not in h:mm format",timesheetDayViewScreen.verifyTimeFormat().equals("1:00") );
    }


    @Then("Verify time events are visible")
    public void verifyTimeEventsAreVisible() {
        Assert.assertTrue("Verifying if timeevents are visibile on the Timeclock screen", timesheetDayViewScreen.verifyTimeEventVisible());

    }

    @When("the user clicks on any of the events")
    public void theUserClicksOnAnyOfTheEvents() {
        timesheetDayViewScreen.clickOnTimeEvent();
    }

}
