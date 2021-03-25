package mobile.frontline.stepdef;

import io.cucumber.java.bs.I;
import io.cucumber.java.en.Then;
import mobile.frontline.pages.InboxMsgScreen;
import org.junit.Assert;

public class InboxMsgPageStepDef {
    InboxMsgScreen inboxMsgScreen = new InboxMsgScreen();

    @Then("Verify the inbox message")
    public void verifyTheInboxMessage() {
        Assert.assertEquals(inboxMsgScreen.validateInboxMsg(), "Smoke Test Case of inbox");
    }
}
