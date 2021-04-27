package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;

public class OrgPickerScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select an Organization']")
    @iOSXCUITFindBy(accessibility = "Select an Organization")
    public MobileElement orgPickerPageHeader;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    public MobileElement associatedOrgForSub1;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
    @iOSXCUITFindBy(accessibility = "Continue")
    public MobileElement contbtn;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]")
    public MobileElement associatedOrgForSub2;

    public OrgPickerScreen() {
    }

    public boolean orgPickerPageLoads() {
        return isElementDisplayed(orgPickerPageHeader, "Waiting for Organization picker page to load");
    }

    public void clickFirstOrganization() {
        click(associatedOrgForSub1, "Clicking on to the organization btn");
    }

    public void clickContinueBtn() {
        click(contbtn, "Clicking on continue btn");
    }

    public void clickSecondOrganization() {
        click(associatedOrgForSub2, "Clicking on to the organization btn");
    }

}
