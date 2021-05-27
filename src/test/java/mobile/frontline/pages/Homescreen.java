package mobile.frontline.pages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import mobile.frontline.stepdef.HomePageScreenStepDef;
import mobile.frontline.stepdef.TimesheetWeekViewScreenStepDef;
import org.openqa.selenium.WebElement;
import java.text.DecimalFormat;
import java.util.ArrayList;
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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Leave Balances']")
    @iOSXCUITFindBy(accessibility = "Available Leave Balances_ModuleHeader")
    public MobileElement availableLeaveBalance;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Inbox']")
    @iOSXCUITFindBy(accessibility = "Inbox_TabBar_Button")
    public MobileElement inboxTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Menu']")
    @iOSXCUITFindBy(accessibility = "Menu_TabBar_Button")
    public MobileElement menuTab;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Clock In']")
    @iOSXCUITFindBy(accessibility = "Clock In")
    public MobileElement clockInbtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CLOCKED IN']")
    @iOSXCUITFindBy(accessibility = "Dashboard_TimeClock_Status_Image")
    public MobileElement clockedInVerification;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[3]")
    public MobileElement ScrollToClockInbtn;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/location_services_permit_access_button")
    @iOSXCUITFindBy(accessibility = "Enable_Location_Services_Button")
    public MobileElement permissionGrantbtn;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    @iOSXCUITFindBy(accessibility = "Allow Once")
    public MobileElement permissionGrantonlyForApp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Timesheets']")
    @iOSXCUITFindBy(accessibility = "Timesheets_ModuleHeader")
    public MobileElement timesheetsbtn;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[contains(@content-desc,'Total Time This Week')]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Dashboard_Timesheet_Total_Hour_Label']")
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

    // @AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_job_detail_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Next Scheduled Job_ModuleHeader']")
    public MobileElement nextScheduledJobWidget;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Scheduled']")
    public MobileElement nextScheduledJobInWidget;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='TimesheetsModule_AddTime_Button'][1]")
    public MobileElement addTimeButtonTimesheet;

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
        } else {
            if (isElementDisplayed(PushNotificationAllow, "Waiting for Push notification Allow pop-up"))
                clickPushNotificationAllow();
            if (isElementDisplayed(PushNotificationOK, "Waiting for Push notification OK pop-up"))
                clickPushNotificationOK();
            switchToNativeApp();
        }
        return isElementDisplayed(homePageHeader, "Waiting for header page to load");
    }

    public boolean verify_homeScreen_displayedWithoutPushVerify() throws Exception {
        Thread.sleep(8000);
        switchToNativeApp();
        swipeDown();
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
            click(availableJobs, "Clicking available job Widget");
        }
    }

    public void clickOnHomeButton() throws InterruptedException {
        click(homeButton, "Clicking on home btn");
    }

    public void clickSwitchbtn() {
        click(switchbtn, "Clicking on switch btn");
    }


    public void clickOnAvailableLeaveBalanceWidget() throws Exception {
        scrollToElement(availableLeaveBalance, "up", "Scrolling to available leave balances");
        click(availableLeaveBalance, "Clicking on available leave balance widget");
    }

    public void clickInbox() {
        click(inboxTab, "Clicking on Inbox footer");
    }

    public void clickClockInBtn() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            click(clockInbtn, "Clicking on Clock In button");
        else
            click(clockInbtn, "Click on Clock In button");
    }

    public boolean waitClockInBtn() throws Exception {
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

    public boolean waitClockInVerifictionBubble() throws Exception {
        return isElementDisplayed(clockedInVerification, "Waiting for clocked in bubble");
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

    public String getWeekTimeText() throws Exception {
        scrollToElement(totalWeekTime, "up", "Scrolling to the total week time on dashboard");
        return getElementText(totalWeekTime, "Extracting the value of total week time");
    }

    public void clickPeopleWidget() throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            scrolledToElement = androidScrollToElementUsingUiScrollable("text", "People", "Scrolling to the people's widget");
            scrolledToElement.click();
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
            click(createAbsBtn, "Clicking on create absence btn");
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

    public void waitNextScheduledJobWidget() throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            scrolledToElement = androidScrollToElementUsingUiScrollable("text", "Next Scheduled Job", "Scrolling to the next Scheduled Job widget ");
        else
            scrollToElement(nextScheduledJobWidget, "up","Scrolling to next schedule job wid");
    }

    public void waitNextScheduledJobInWidget() throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            scrolledToElement = androidScrollToElementUsingUiScrollable("text", "Next Scheduled Job", "Scrolling to the next Scheduled Job widget ");
        else
            scrollToElement(nextScheduledJobInWidget, "up","Scrolling to next schedule job wid");
    }

    public void clickOnMenuTab() {
        click(menuTab, "Clicking on Menu Tab");
    }

    public void clickAddTimeBtn() throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            scrolledToElement = androidScrollToElementUsingUiScrollable("text", "Add Time", "Scrolling to the Add time btn ");
            scrolledToElement.click();
        }
        else{
            scrollToElement(addTimeButtonTimesheet, "up","Scrolling to Add Time button");
            click(addTimeButtonTimesheet,"Clicking on Add Button");
        }

    }

    public String calculateTotalTime(){
            int hours = 0;
            int minutes = 0;
            DecimalFormat formatter = new DecimalFormat("00");
            hours = hours + Integer.parseInt(HomePageScreenStepDef.initailWeekTotal.split(":")[0])+1;
            minutes = minutes + Integer.parseInt(HomePageScreenStepDef.initailWeekTotal.split(":")[1]);
            hours = hours + (minutes / 60);
            minutes = minutes % 60;
            return (hours + ":" + formatter.format(minutes));
    }
}