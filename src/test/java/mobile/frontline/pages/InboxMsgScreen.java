package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class InboxMsgScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
    public MobileElement msgData;

    public InboxMsgScreen() { }

    public String validateInboxMsg() {
        return getElementText(msgData, "Extracting inbox alert message");
    }
}
