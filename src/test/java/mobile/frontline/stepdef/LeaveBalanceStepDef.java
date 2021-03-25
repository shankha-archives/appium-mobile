package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.LeaveBalanceScreen;
import org.junit.Assert;

public class LeaveBalanceStepDef {

    LeaveBalanceScreen leaveBalanceScreen = new LeaveBalanceScreen();

    @Then("View leave balance screen")
    public void viewLeaveBalanceScreen() {
       Assert.assertTrue("Available Leave Balance page is not displayed", leaveBalanceScreen.verfyLeaveBalanceHeader());
    }

    @Then("^verify available days$")
    public void verify_available_days() throws Throwable {
       // smokePage.verify_availableDays();
        Assert.assertTrue("Available Leaves are invalid", Float.parseFloat(leaveBalanceScreen.verify_availableDays()) >= 0);
    }
}
