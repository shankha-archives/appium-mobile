package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import mobile.frontline.pages.InboxScreen;
import org.junit.Assert;

public class InboxScreenStepDef {

    InboxScreen inboxScreen = new InboxScreen();

    @And("Verify inbox screen is display")
    public void verifyInboxScreenIsDisplay() throws Exception {
        Assert.assertTrue("Inbox page is not displayed", inboxScreen.verifyInboxPage());
    }

    @And("Click on inbox alert")
    public void clickOnInboxAlert() {
        inboxScreen.clickInboxAlert();
    }

}
