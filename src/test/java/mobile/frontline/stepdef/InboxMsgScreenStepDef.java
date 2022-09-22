package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.InboxMsgScreen;
import org.junit.Assert;

public class InboxMsgScreenStepDef {
    InboxMsgScreen inboxMsgScreen = new InboxMsgScreen();

    @Then("Verify the inbox message")
    public void verifyTheInboxMessage() {
//        Assert.assertEquals(inboxMsgScreen.getInboxMsg(), "Smoke Test Case of inbox");
        Assert.assertEquals(inboxMsgScreen.getInboxMsg(), "WEB ALERT.......................");
    }
}
