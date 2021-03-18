package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OrgPickerScreen extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select an Organization']")
    @iOSXCUITFindBy(accessibility = "Select an Organization")
    public MobileElement orgPickerPageHeader;

  public  OrgPickerScreen(){}

    public boolean orgPickerPageLoads() {
//        isElementDisplayed(orgPickerPageHeader);
//        Assert.assertTrue("Organization picker page is not displayed", orgPickerPageHeader.isDisplayed());
//        utils.log().info("Organization picker page is displayed");
        return isElementDisplayed(orgPickerPageHeader,"Waiting for Organization picker page to load") ;
    }
}
