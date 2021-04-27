package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.TimeEntryScreen;
import mobile.frontline.pages.TimeEventScreen;
import org.junit.Assert;

public class TimeEntryScreenStepDef {

    TimeEntryScreen timeEntryScreen = new TimeEntryScreen();
    String expectedInTime;

    @Then("edit the timesheet outtime")
    public void editTheTimesheetOuttime() {
        timeEntryScreen.clickOutTimesheetinEditState();
        timeEntryScreen.clickOkonOuttime();
    }

    @And("Wait for time entry page to load")
    public void waitForTimeEntryPageToLoad() {
        Assert.assertTrue("Work details did not load", timeEntryScreen.verifyWorkDetails());
    }

    @Then("Add one hour of out time to the event")
    public void addOneHourOfOutTimeToTheEvent() {
        timeEntryScreen.clickOutTimesheet();
        timeEntryScreen.addAnHourToTimesheets();
    }

    @And("Save timeevent")
    public void saveTimeevent() throws InterruptedException {
        timeEntryScreen.clickSaveTimesheet();
    }

    @Then("Save edited timeevent")
    public void saveEditedTimeevent() throws InterruptedException {
        timeEntryScreen.clickSaveEditedTimesheet();
    }

    @And("Click ok after adding out time event")
    public void clickOkAfterAddingOutTimeEvent() {
        timeEntryScreen.clickOkonOuttime();
    }


    @When("The comment is edited to the time event")
    public void theCommentIsEditedToTheTimeEvent() throws Throwable {
        timeEntryScreen.editTimeCommentToTimesheet();
    }

    @Then("Verify the pop up that timesheet is not editable")
    public void verifyThePopUpThatTimesheetIsNotEditable() {
        Assert.assertEquals("The timesheet is not submitted", "The timesheet requested is not in an editable state", timeEntryScreen.timesheetNonEditablePopup());
        ;
    }

    @Then("Add one hour to in time of the event")
    public void addOneHourToInTimeOfTheEvent() {
        timeEntryScreen.clickIntimeLink();
        timeEntryScreen.addAnHourToTimesheets();
    }

    @And("Get the changes in time")
    public void getTheChangesInTime() {
        expectedInTime = timeEntryScreen.getInTime();
    }

    @And("Verify in time after relaunching application")
    public void verifyInTimeAfterRelaunchingApplication() {
        Assert.assertEquals("", expectedInTime, timeEntryScreen.getInTime());
    }

}
