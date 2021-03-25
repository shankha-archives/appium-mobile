package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.TestDataManager;
import org.junit.Assert;

public class AppCalendarScreen extends BasePage{

    public TestDataManager testdata = new TestDataManager();

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Calendar']")
    public MobileElement calendar;

    public boolean verifySearchResult(String searchResultText) throws Exception {
        isElementDisplayed(calendar, "Waiting for application calendar to display");
//        Assert.assertTrue("calendar is not displayed", calendar.isDisplayed());
        return getElementText(calendar, "Getting text of App Calendar").equalsIgnoreCase(testdata.read_property("testingData", "users", searchResultText));
      //  Assert.assertTrue("Entered text does not match", getElementText(calendar).equalsIgnoreCase(testdata.read_property("testingData", "users", searchResultText)));
       // utils.log().info("Entered text matches with result");
    }
}
