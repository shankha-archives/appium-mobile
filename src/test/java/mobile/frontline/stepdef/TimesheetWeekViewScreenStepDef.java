package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.TimesheetWeekViewScreen;
import org.junit.Assert;

public class TimesheetWeekViewScreenStepDef {

    TimesheetWeekViewScreen timesheetWeekViewScreen = new TimesheetWeekViewScreen();

    @And("Select the current day")
    public void selectTheCurrentDay() throws Exception {
        timesheetWeekViewScreen.selectCurrentDayForTimesheet();
    }

    @Then("Calculate the week total")
    public void calculateTheWeekTotal() throws Exception {
        timesheetWeekViewScreen.weekTotalTime();
    }

    @And("Verify the total time of the week")
    public void verifyTheTotalTimeOfTheWeek() {
        Assert.assertEquals("Total week time did not match with the expected result",timesheetWeekViewScreen.getTotalExpectedTimeofWeek(), timesheetWeekViewScreen.totalExpectedTimeofWeek);
    }

    @When("Click on submit week timesheet option")
    public void clickOnSubmitWeekTimesheetOption() throws InterruptedException {
        timesheetWeekViewScreen.clickWeekTimesheetSubmitBtn();
       // Thread.sleep(10000);
    }

    @When("Click on undo week timesheet btn")
    public void clickOnUndoWeekTimesheetBtn() throws Exception {
        timesheetWeekViewScreen.clickUndoWeekTimesheet();
    }

    @When("Decline review pop up")
    public void declineReviewPopUp() {
        timesheetWeekViewScreen.declinePopUp();
    }

    @Then("Verify undo timesheet")
    public void verifyUndoTimesheet() {
        timesheetWeekViewScreen.verifySubmitTimesheetBtn();
    }

    @Then("Verify days of the week")
    public void verifyDaysOfTheWeek() {
        Assert.assertTrue("Monday timesheet is not displayed",  timesheetWeekViewScreen.verifyMonday());
        Assert.assertTrue("Sunday timesheet is not displayed",  timesheetWeekViewScreen.verifySunday());
        Assert.assertTrue("Saturday timesheet is not displayed",  timesheetWeekViewScreen.verifySaturday());
        Assert.assertTrue("Tuesday timesheet is not displayed",  timesheetWeekViewScreen.verifyTuesday());
        Assert.assertTrue("Wednesday timesheet is not displayed",  timesheetWeekViewScreen.verifyWednesday());
        Assert.assertTrue("Thursday timesheet is not displayed",  timesheetWeekViewScreen.verifyThrusday());
        Assert.assertTrue("Friday timesheet is not displayed",  timesheetWeekViewScreen.verifyFriday());
    }

}
