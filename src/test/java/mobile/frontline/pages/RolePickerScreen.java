package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RolePickerScreen extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select a Role']")
    @iOSXCUITFindBy(accessibility = "Select a Role")
    public MobileElement rolePickerPageHeader;

    public RolePickerScreen(){}

    public boolean rolePickerPageLoads() {
//        isElementDisplayed(rolePickerPageHeader);
//        Assert.assertTrue("Role picker page is not displayed", rolePickerPageHeader.isDisplayed());
//        utils.log().info("Role picker page is displayed");
        return isElementDisplayed(rolePickerPageHeader,"Searcing for role picker header");
    }
}
