package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;

public class RolePickerScreen extends BasePage{

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/role_picker_title")
    @iOSXCUITFindBy(accessibility = "Select a Role")
    public MobileElement rolePickerPageHeader;

    public RolePickerScreen(){}

    public boolean rolePickerPageLoads() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            Thread.sleep(8000);
            switchToNativeApp();
        }
        return isElementDisplayed(rolePickerPageHeader,"Searcing for role picker header");
    }
}
