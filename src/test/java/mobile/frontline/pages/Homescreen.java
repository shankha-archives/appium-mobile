package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

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

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[contains(@content-desc,'Total Time This Week')]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[3]")
    public MobileElement totalWeekTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People']")
    @iOSXCUITFindBy(accessibility = "People_ModuleHeader")
    public MobileElement PeopleWidget;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/edit_widget_order_button")
    @iOSXCUITFindBy(accessibility = "Edit button: double-tap to go to dashboard widget reordering page")
    public MobileElement reOrderWidgetbtn;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/widget_header_title")
    @iOSXCUITFindBy(xpath = "//	XCUIElementTypeButton[contains(@name, 'ModuleHeader')]")
    public List<MobileElement> widgetListFromDashboard;

    @AndroidFindBy(xpath = "//android.widget.Button[@text = 'Create Absence']")
    @iOSXCUITFindBy(accessibility = "AbsencesModule_Create_Button")
    public MobileElement createAbsBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Absences Today']")
    @iOSXCUITFindBy(accessibility = "Absences Today_ModuleHeader")
    public MobileElement absenceWidget;

    public static String inTime;
    public WebElement scrolledToElement;
    public static ArrayList<String> widgetlistbeforeReorder;
    public static ArrayList<String> widgetlistafterReorder;

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
            return isElementDisplayed(clockInbtn, "Clicking on Clock In button");
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
            return isElementDisplayed(clockedInVerification, "Waiting for clocked in bubble");
        else {
            scrollToElement(ScrollToClockInbtn, "up", "Scrolling up to clockin btn");
            return isElementDisplayed(clockedOutBtn, "Waiting for clockout btn");
        }
    }

    public void getInTimeOfTimeClock() {
        inTime = getElementText(clockedInTime, "Extracting the value of clock in time text").substring(1);
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

    public String verifyWeekTime() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            // click(smoke.homeTab);
            scrollToElement(totalWeekTime, "up", "Scrolling to the total week time on dashboard");
            return getElementText(totalWeekTime, "Extracting the value of total week time");
//                Assert.assertEquals("Week total on dashboard is not same as on Timesheet page", weekTotal, weekTotalActual);
//                break;
        } else {
            isElementDisplayed(totalWeekTime, "Waiting for total week time to display on dashboard");
            return totalWeekTime.getAttribute("name").toString();
            //d = dateFormat.parse(weekTotal);
        }
    }

    public void clickPeopleWidget() throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            scrolledToElement = androidScrollToElementUsingUiScrollable("text", "People", "Scrolling to the people's widget");
            scrolledToElement.click();
            // click(PeopleWidget, "Click on people widget");
        } else {
            scrollToElement(PeopleWidget, "up");
            click(PeopleWidget, "Clicking on People Widget");
        }
    }

    public void getListOrderBeforeReorder() throws Throwable {
        widgetlistbeforeReorder = new ArrayList<String>(
                getTheOrderListByScrolling(reOrderWidgetbtn, "up", widgetListFromDashboard));
    }

    public void clickReorderWidget() {
        click(reOrderWidgetbtn, "Clicking on reorder widget btn");
    }

    public void getListOrderAfterReorder() throws Throwable {
        widgetlistafterReorder = new ArrayList<String>(
                getTheOrderListByScrolling(reOrderWidgetbtn, "up", widgetListFromDashboard));
    }

    public void clickCreateAbs() throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            scrolledToElement = androidScrollToElementUsingUiScrollable("text", "Create Absence", "Scrolling to create absence btn");
            scrolledToElement.click();
        } else {
            scrollToElement(createAbsBtn, "up");
            click(createAbsBtn,"Clicking on create absence btn");
        }
    }

    public void clickAbsencesWidget() throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            scrolledToElement = androidScrollToElementUsingUiScrollable("text", "Absences Today", "Scrolling to absence today widget");
            scrolledToElement.click();
        } else {
            scrollToElement(absenceWidget, "up");
            click(absenceWidget, "Clicking on Absence Widget");
        }
    }
}