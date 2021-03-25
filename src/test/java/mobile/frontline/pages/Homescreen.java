package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Homescreen extends BasePage {

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/welcome_user_text")
    @iOSXCUITFindBy(accessibility = "What's New_ModuleHeader")
    public MobileElement homePageHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    public MobileElement PushNotificationAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Okay']")
    public MobileElement PushNotificationOK;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Jobs']")
    @iOSXCUITFindBy(accessibility = "Jobs_ModuleHeader")
    public MobileElement availableJobs;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    @iOSXCUITFindBy(accessibility = "Home_TabBar_Button")
    public MobileElement homeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Switch']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[1]")
    public MobileElement switchbtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Menu']")
    @iOSXCUITFindBy(accessibility = "Menu_TabBar_Button")
    public MobileElement menuTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Leave Balances']")
    @iOSXCUITFindBy(accessibility = "Available Leave Balances_ModuleHeader")
    public MobileElement availableLeaveBalance;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Inbox']")
    @iOSXCUITFindBy(accessibility = "Inbox_TabBar_Button")
    public MobileElement inboxTab;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Clock In']")
    @iOSXCUITFindBy(accessibility = "Clock In")
    public MobileElement clockInbtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CLOCKED IN']")
    @iOSXCUITFindBy(accessibility = "Clock Out")
    public MobileElement clockedInVerification;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[3]")
    public MobileElement ScrollToClockInbtn;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/location_services_permit_access_button")
    @iOSXCUITFindBy(accessibility = "Enable_Location_Services_Button")
    public MobileElement permissionGrantbtn;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    @iOSXCUITFindBy(accessibility = "Allow Once")
    public MobileElement permissionGrantonlyForApp;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Clock Out']")
    @iOSXCUITFindBy(accessibility = "Clock Out")
    public MobileElement clockedOutBtn;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/clock_in_time_text_widget")
    // @iOSXCUITFindBy(accessibility = "")
    public MobileElement clockedInTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Timesheets']")
    @iOSXCUITFindBy(accessibility = "Timesheets_ModuleHeader")
    public MobileElement timesheetsbtn;


    public static String inTime;
    public WebElement scrolledToElement;

    public Homescreen() {

    }

    public boolean verify_homeScreen_displayed() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            Thread.sleep(8000);
            switchToNativeApp();
            //  isElementdisplayed(homePageHeader);
        } else {
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


//    public void verify_homeScreen_displayedWithoutReLaunch() throws Exception {
//        switch (new GlobalParams().getPlatformName()) {
//            case "Android":
//                isElementdisplayed(homePageHeader);
//                Assert.assertTrue("Home Page is not displayed", homePageHeader.isDisplayed());
//                utils.log().info("Home Page is displayed");
//                break;
//            case "iOS":
//                if(isElementdisplayed(homePageHeader))
//                    Assert.assertTrue("Home Page is not displayed", homePageHeader.isDisplayed());
//                else {
//                    utils.log().info("Home Page displayed");}
//                break;
//            default:
//                throw new Exception("Invalid platform Name");
//        }
//    }

    public boolean verify_homeScreen_displayedWithoutPushVerify() throws Exception {
        Thread.sleep(8000);
        switchToNativeApp();
        return isElementDisplayed(homePageHeader, "Waiting for header page to load");
    }

    public void clickPushNotificationAllow() {
        click(PushNotificationAllow, "Push Notification pop-up displayed");
    }

    public void clickPushNotificationOK() {
        click(PushNotificationOK, "Push Notification pop-up displayed");
    }

    public void clickJobWidget() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            click(availableJobs, "Clicking available job Widget");
        else {
            //  verify_homeScreen_displayed();
            click(availableJobs, "Clicking available job Widget");
        }

    }

    public void clickOnHomeButton() throws InterruptedException {
        click(homeButton, "Clicking on home btn");
    }

    public void clickSwitchbtn() {
        click(switchbtn, "Clicking on switch btn");
    }

    public void clickOnMenuTab() {
        // Assert.assertTrue("Menu tab is not displayed", menuTab.isDisplayed());
        click(menuTab, "Clicking on Menu Tab");
    }

    public void clickOnAvailableLeaveBalanceWidget() throws Exception {
        scrollToElement(availableLeaveBalance, "up", "Scrolling to available leave balances");
//        Assert.assertTrue("Available Leave Balances is not displayed on Home page",
//                availableLeaveBalance.isDisplayed());
//        utils.log().info("Available Leave Balances is displayed on Home page");
        click(availableLeaveBalance, "Clicking on available leave balance widget");
//        isElementdisplayed(availableLeaveBalanceHeader);
//        Assert.assertTrue("Available Leave Balance page is not displayed", availableLeaveBalanceHeader.isDisplayed());
//        utils.log().info("Available Leave Balance Page is displayed");
    }

    public void clickInbox() {
        click(inboxTab, "Clicking on Inbox footer");
    }

    public void clickClockInBtn() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            click(clockInbtn, "Clicking on Clock In button");
        else {
            scrollToElement(ScrollToClockInbtn, "up", "Scrolling up to clockin btn");
            click(clockInbtn, "Click on Clock In button");
        }
    }

    public boolean verifyClockInBtn() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
          return   isElementDisplayed(clockInbtn, "Clicking on Clock In button");
        else {
            scrollToElement(ScrollToClockInbtn, "up", "Scrolling up to clockin btn");
           return isElementDisplayed(clockInbtn, "Click on Clock In button");
        }
    }

    public void clickOnAllowLocationAccess() {
        click(permissionGrantbtn, "Clicking on permission Grant button");
    }

    public void clickAllowPermissionPopUp() {
        click(permissionGrantonlyForApp, "Click on permission Grant button only for app");
    }

    public boolean verifyClockIn() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            return isElementdisplayed(clockedInVerification);
        else {
            scrollToElement(ScrollToClockInbtn, "up", "Scrolling up to clockin btn");
            return isElementdisplayed(clockedOutBtn);
        }
    }

    public void verifyClockOutBtn() {

    }

    public void getInTimeOfTimeClock() {
        inTime = getElementText(clockedInTime).substring(1);
    }


    public void clickTimesheetWidget() throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            scrolledToElement = androidScrollToElementUsingUiScrollable("text", "Timesheets", "Scrolling to timesheet widget");
            scrolledToElement.click();
        } else {
            scrollToElement(timesheetsbtn, "up", "Scrollinng up to the timesheet widget");
            click(timesheetsbtn, "Clicked on Timesheet button");
        }
    }


//    public void clockOutThroughTimesheet() throws Throwable {
//        switch (new GlobalParams().getPlatformName()) {
//            case "Android":
//                Intime = common.getElementText(clockedInTime).substring(1);
//                clickTimesheetWidget();
//                selectCurrentDayForTimesheet();
//                isElementdisplayed(eventSummary);
//                assertTimeEvent(Intime);
//                scrolledToElement = androidScrollToElementUsingUiScrollable("text", Intime, "Scrolling to the required timeevent");
//                scrolledToElement.click();
//                editTimesheetForClockOut();
//                break;
//            case "iOS":
//                utils.log().info("No need to go timesheet section");
//                break;
//            default:
//                throw new Exception("Invalid platform Name");
//        }
//    }

//    public void allowClockInOutAcessPermissions() throws Throwable {
//        switch (new GlobalParams().getPlatformName()) {
//            case "Android":
//                isElementdisplayed(permissionGrantbtn);
//                click(permissionGrantbtn,"Click on permission Grant button");
//                isElementdisplayed(permissionGrantonlyForApp);
//                click(permissionGrantonlyForApp,"Click on permission Grant button only for app");
//                break;
//            case "iOS":
//                click(permissionGrantbtn,"Click on permission Grant button");
//                click(permissionGrantonlyForApp,"Click on permission Grant button only for app");
//                break;
//            default:
//                throw new Exception("Invalid platform Name");
//        }
//    }
//
//
//    public void clockInVerification() throws Throwable {
//        switch (new GlobalParams().getPlatformName()) {
//            case "Android":
////                if (isElementdisplayed(clockInbtn)) {
//                    click(clockInbtn,"Click on Clock In button");
//              //      allowClockInOutAcessPermissions();
//             //       clockInbtn();
////                } else if (isElementdisplayed(clockedInVerification)) {
////                    clickClockOut();
////                    allowClockInOutAcessPermissions();
////                    clickClockOut();
////                    Thread.sleep(45000);
////                    isElementdisplayed(clockInbtn);
////                    Thread.sleep(30000);
////                    isElementdisplayed(clockInbtn);
////                    clockInbtn();
////                }
//                break;
//            case "iOS":
//                scrollToElement(ScrollToClockInbtn,"up", "Scrolling up to clockin btn");
////                if (isElementdisplayed(clockInbtn)) {
//                    click(clockInbtn,"Click on Clock In button");
////                    allowClockInOutAcessPermissions();
////                } else if (isElementdisplayed(clockedOutBtn)) {
////                    click(clockedOutBtn,"Click on Clocked out button");
////                    allowClockInOutAcessPermissions();
////                    click(clockedOutBtn,"Click on Clock out button");
////                    Thread.sleep(45000);
////                    isElementdisplayed(clockInbtn);
////                    Thread.sleep(30000);
////                    isElementdisplayed(clockInbtn);
////                }
//                break;
//            default:
//                throw new Exception("Invalid platform Name");
//        }
//    }
//
//    public void clockInbtn() throws Throwable {
//        switch (new GlobalParams().getPlatformName()) {
//            case "Android":
//                click(clockInbtn,"Clicked on In Time button");
//                isElementdisplayed(clockedInVerification);
//                break;
//            case "iOS":
//                click(clockInbtn,"Clicked on Clock In Button");
//                isElementdisplayed(clockedOutBtn);
//                break;
//            default:
//                throw new Exception("Invalid platform Name");
//        }
//    }
//

}

