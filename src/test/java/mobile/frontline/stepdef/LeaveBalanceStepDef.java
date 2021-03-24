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
}
