package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.LeaveBalanceScreen;
import org.junit.Assert;

public class LeaveBalanceScreenStepDef {

    LeaveBalanceScreen leaveBalanceScreen = new LeaveBalanceScreen();

    @Then("View leave balance screen")
    public void viewLeaveBalanceScreen() {
       Assert.assertTrue("Available Leave Balance page is not displayed", leaveBalanceScreen.waitLeaveBalanceHeader());
    }

    @Then("^verify available days$")
    public void verify_available_days() throws Throwable {
        Assert.assertTrue("Available Leaves are invalid", Float.parseFloat(leaveBalanceScreen.get_availableDays()) >= 0);
    }
}
