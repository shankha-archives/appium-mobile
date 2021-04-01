package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.TimeEntryScreen;
import mobile.frontline.pages.TimeEventScreen;
import org.junit.Assert;

public class TimeEntryScreenStepDef {

    TimeEntryScreen timeEntryScreen = new TimeEntryScreen();

    @Then("edit the timesheet outtime")
    public void editTheTimesheetOuttime() {
//      Assert.assertTrue("Work details did not load",timeEntryScreen.verifyWorkDetails());
        timeEntryScreen.clickOutTimesheet();
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
      //  Thread.sleep(10000);
    }

    @And("Click ok after adding out time event")
    public void clickOkAfterAddingOutTimeEvent() {
        timeEntryScreen.clickOkonOuttime();
    }


    @When("The comment is edited to the time event")
    public void theCommentIsEditedToTheTimeEvent() throws Throwable {
        timeEntryScreen.editTimeCommentToTimesheet();
    }

}
