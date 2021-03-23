package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;

public class MenuScreen extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    @iOSXCUITFindBy(accessibility = "Settings_MenuOption")
    public MobileElement settings;

    public MenuScreen(){}

    public void clickSettingsOption() throws Exception {
        scrollToElement(settings, "up");
       // Assert.assertTrue("Settings tab is not displayed", settings.isDisplayed());
        click(settings);
    }

}
