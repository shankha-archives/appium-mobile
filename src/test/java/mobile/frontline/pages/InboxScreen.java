package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;

public class InboxScreen extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Inbox']")
    @iOSXCUITFindBy(accessibility = "Inbox_TabBar_Button")
    public MobileElement inboxTab;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/inbox_notification_snippet_text")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[2]")
    public MobileElement inboxMsg;

    public  InboxScreen(){}

    public boolean verifyInboxPage() throws Exception {
       return isElementDisplayed(inboxTab,"Waiting for inbox page to display");
//        Assert.assertTrue("Inbox page is not displayed", inboxTab.isDisplayed());
//        utils.log().info("Inbox page is displayed");
    }

    public void clickInboxAlert() {
//        String msg = getElementText(inboxMsg).trim();
        click(inboxMsg,"Clicking on Inbox Message");
//        Assert.assertEquals(getElementText(msgData), "Smoke Test Case of inbox");
//        utils.log().info("MEssage is displayed");
    }
}
