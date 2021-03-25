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
        isElementDisplayed(darkMode,"Waiting for dask mode btn to be visible");
        return getElementText(darkMode, "Extracting text msg of dark mode btn");
    }

    public void clickDarkModeBtn() {
        click(darkMode, "Clicking dark mode button");
    }

    public void clickLogoutbtn() {
        click(logoutBtn, "Clicking on logout btn");
    }
}
