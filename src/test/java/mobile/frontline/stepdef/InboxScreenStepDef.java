package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import mobile.frontline.pages.InboxScreen;
import org.junit.Assert;

public class InboxScreenStepDef {

    InboxScreen inboxScreen = new InboxScreen();

    @And("Verify inbox screen is display")
    public void verifyInboxScreenIsDisplay() throws Exception {
        Assert.assertTrue("Inbox page is not displayed", inboxScreen.waitForInboxPage());
    }

    @And("Click on inbox alert")
    public void clickOnInboxAlert() {
        inboxScreen.clickInboxAlert();
    }

}
