package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;

public class SettingScreen extends BasePage {

    @AndroidFindBy(className = "android.widget.Switch")
    @iOSXCUITFindBy(accessibility = "darkMode")
    public MobileElement darkMode;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/log_out_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
    public MobileElement logoutBtn;

    public SettingScreen() {
    }

    public String verifyDarkModeBtn() throws Exception {
        isElementDisplayed(darkMode);
        return getElementText(darkMode);
    }

    public void clickDarkModeBtn() {
        click(darkMode);
    }

    public void clickLogoutbtn() {
        click(logoutBtn, "logout btn");
    }
}
