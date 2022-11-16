package mobile.frontline.stepdef;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.TimesheetWeekViewScreen;
import org.junit.Assert;

public class TimesheetWeekViewScreenStepDef extends  BasePage{

    TimesheetWeekViewScreen timesheetWeekViewScreen = new TimesheetWeekViewScreen();
    public static String initialWeekTotalTime;

    @And("Select the current day")
    public void selectTheCurrentDay() throws Exception {
//       Assert.assertTrue("Tuesday timesheet is not displayed", timesheetWeekViewScreen.verifyTuesday());
        timesheetWeekViewScreen.selectCurrentDayForTimesheet();
    }

    @Then("Calculate the week total")
    public void calculateTheWeekTotal() throws Exception {
        Assert.assertTrue("Monday timesheet is not displayed", timesheetWeekViewScreen.verifyMonday());
        timesheetWeekViewScreen.weekTotalTime();
    }

    @And("Verify the total time of the week")
    public void verifyTheTotalTimeOfTheWeek() {
        Assert.assertEquals("Total week time did not match with the expected result", timesheetWeekViewScreen.getTotalExpectedTimeofWeek(), timesheetWeekViewScreen.totalExpectedTimeofWeek);
    }

    @When("Click on submit week timesheet option")
    public void clickOnSubmitWeekTimesheetOption() throws InterruptedException {
        Assert.assertTrue("Friday timesheet is not displayed", timesheetWeekViewScreen.verifyFriday());
        timesheetWeekViewScreen.clickWeekTimesheetSubmitBtn();
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
        Assert.assertTrue("Timesheet did not go in submit state", timesheetWeekViewScreen.verifySubmitTimesheetBtn());
    }

    @Then("Verify days of the week")
    public void verifyDaysOfTheWeek() {
        Assert.assertTrue("Monday timesheet is not displayed", timesheetWeekViewScreen.verifyMonday());
        Assert.assertTrue("Tuesday timesheet is not displayed", timesheetWeekViewScreen.verifyTuesday());
        Assert.assertTrue("Wednesday timesheet is not displayed", timesheetWeekViewScreen.verifyWednesday());
        Assert.assertTrue("Thursday timesheet is not displayed", timesheetWeekViewScreen.verifyThrusday());
        Assert.assertTrue("Friday timesheet is not displayed", timesheetWeekViewScreen.verifyFriday());
        Assert.assertTrue("Saturday timesheet is not displayed", timesheetWeekViewScreen.verifySaturday());
        Assert.assertTrue("Sunday timesheet is not displayed", timesheetWeekViewScreen.verifySunday());
    }

    @Then("Get the total week total time")
    public void getTheTotalWeekTotalTime() throws InterruptedException {
        Assert.assertTrue("Tuesday timesheet is not displayed", timesheetWeekViewScreen.verifyTuesday());
        initialWeekTotalTime = timesheetWeekViewScreen.getTotalExpectedTimeofWeek();
    }

    @And("Verify the total time with the calculated time")
    public void verifyTheTotalTimeWithTheCalculatedTime() {
        Assert.assertEquals("The calculated time and total time is not equal", TimesheetDayViewScreenStepDef.actualTime, initialWeekTotalTime);
    }
}
