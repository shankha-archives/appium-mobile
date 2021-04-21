package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SettingScreen extends BasePage {

    @AndroidFindBy(className = "android.widget.Switch")
    @iOSXCUITFindBy(accessibility = "darkMode")
    public MobileElement darkMode;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/log_out_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
    public MobileElement logoutBtn;

    // click on Feedback
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Feedback']")
    //@iOSXCUITFindBy(accessibility = "Feedback_MenuOption")
    public MobileElement feedback;

    // click on Feedback Header
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Frontline Education would love to hear from you!']")
    //@iOSXCUITFindBy(accessibility = "Feedback_MenuOption")
    public MobileElement feedbackHeader;

    //Click  on Cross button
    @AndroidFindBy(className = "android.widget.ImageButton")
    //@iOSXCUITFindBy
    public MobileElement feedbackClose;




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

    //Mob-6665
    public void clickFeedBackBtn() {
        click(feedback, "Clicking Feedback button");
    }

    //Mob-6665
    public String validateFeedBackHeaderBtn() {
         //return isElementdisplayed(feedbackHeader);
        return getElementText(feedbackHeader, "Extracting FeedBack Header ");

     }

}
