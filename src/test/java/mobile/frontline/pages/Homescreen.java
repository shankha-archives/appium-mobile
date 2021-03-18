package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;

public class Homescreen extends BasePage{

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/welcome_user_text")
    @iOSXCUITFindBy(accessibility = "What's New_ModuleHeader")
    public MobileElement homePageHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    public MobileElement PushNotificationAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Okay']")
    public MobileElement PushNotificationOK;

    public Homescreen(){

    }

    public boolean verify_homeScreen_displayed() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            Thread.sleep(8000);
            switchToNativeApp();
          //  isElementdisplayed(homePageHeader);
        }
        else {
            if (isElementDisplayed(PushNotificationAllow, "Waiting for Push notification Allow pop-up"))
                clickPushNotificationAllow();
//             else
//                utils.log().info("Push Notification pop-up not displayed");

            if (isElementDisplayed(PushNotificationOK, "Waiting for Push notification OK pop-up"))
                clickPushNotificationOK();
//            else
//                utils.log().info("Push Notification pop-up not displayed");
            switchToNativeApp();
        }
        return isElementDisplayed(homePageHeader, "Waiting for header page to load");
        }

        public void clickPushNotificationAllow(){
            click(PushNotificationAllow,"Push Notification pop-up displayed");
        }
        public void clickPushNotificationOK(){
        click(PushNotificationOK,"Push Notification pop-up displayed");
        }
    }

