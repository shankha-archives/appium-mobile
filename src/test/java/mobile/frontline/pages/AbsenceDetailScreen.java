package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AbsenceDetailScreen extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Conf')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Conf')]")
    public MobileElement confirmationNumber;

    public AbsenceDetailScreen(){}

    public boolean verifydisplayConfirmationNumber() {
        return isElementDisplayed(confirmationNumber, "Waiting for confirmation number to be displayed");
    }
}
