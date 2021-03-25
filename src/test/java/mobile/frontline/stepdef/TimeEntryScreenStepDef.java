package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.TimeEntryScreen;
import mobile.frontline.pages.TimeEventScreen;
import org.junit.Assert;

public class TimeEntryScreenStepDef {

  TimeEntryScreen timeEntryScreen = new TimeEntryScreen();

    @Then("edit the timesheet outtime")
    public void editTheTimesheetOuttime() {
      Assert.assertTrue("Work details did not load",timeEntryScreen.verifyWorkDetails());
      timeEntryScreen.clickOutTimesheet();
      timeEntryScreen.clickOkPopup();
      timeEntryScreen.clickSaveTimesheet();
    }


}
