package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;
import sun.security.mscapi.CPublicKey;

public class TimeEntryScreen extends BasePage {

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/fl_spinner_selection")
    @iOSXCUITFindBy(accessibility = "EventType_1")
    public MobileElement workDetails;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/out_time")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Edit'])[3]")
    public MobileElement timeSheetOutTime;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Yes")
    public MobileElement okBtn;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_entry_save_button")
    @iOSXCUITFindBy(accessibility = "Add")
    public MobileElement saveTimesheets;

    @iOSXCUITFindBy(accessibility = "Save")
    public MobileElement saveButton;

    @AndroidFindBy(id = "android:id/hours")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[1]")
    public MobileElement outTimeEntry;

    @AndroidFindBy(id = "android:id/am_label")
    // @iOSXCUITFindBy(xpath = "")
    public MobileElement am_label;

    @AndroidFindBy(id = "android:id/pm_label")
    // @iOSXCUITFindBy(xpath = "")
    public MobileElement pm_label;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/save")
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement saveOrderWidgetbtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Add a Comment']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='TimesheetEventDetailView_Other']/XCUIElementTypeCell[5]/XCUIElementTypeTextView")
    public MobileElement inTimeComment;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name='Error']")
    public MobileElement timesheetErrorMessage;

    public static String outTime;

    public TimeEntryScreen() {
    }

    public boolean verifyWorkDetails() {
        return isElementdisplayed(workDetails);
    }

    public void clickOutTimesheet() {
        click(timeSheetOutTime, "Clicked on Timesheet out time");
    }

//    public void clickOkPopup() {
//        click(okBtn, "Clicked on Ok Button ");
//    }

    public void getOutTimeText() {
        outTime = getElementText(timeSheetOutTime);
    }

    public void clickSaveTimesheet() {
        click(saveTimesheets, "Clicking on Save Timesheet button");
    }

    public void addAnHourToTimesheets() {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {

            String OutTime = getElementText(outTimeEntry);
            int out = Integer.parseInt(OutTime);
            int changeHourClock = out;
            if (out == 12)
                out = 1;
            else
                out = out + 1;
            driver.findElementByXPath(
                    "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='" + out + "']")
                    .click();

            if (changeHourClock == 11) {
                if (Boolean.parseBoolean(am_label.getAttribute("checked").toString()))
                    click(pm_label);
                else
                    click(am_label);
            }
        } else {
            //outTime.click();
            //dragClock();
        }
    }

    public void clickOkonOuttime() {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            click(okBtn, "Clicking on OK btn");
        else
            click(saveOrderWidgetbtn, "Clicking on save out time btn");

    }
    public void editTimeCommentToTimesheet() throws Throwable {
        sendKeys(inTimeComment, "Automation Smoke Test","Sending text to the timesheet comment box");
    }

    public String timesheetNonEditablePopup() {
        return getElementText(timesheetErrorMessage,"Fetching the timesheet error pop up");
    }

}
