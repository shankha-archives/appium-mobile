package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.Duration;

public class TimeEntryScreen extends BasePage {

    @AndroidFindBy(id = "fl_spinner_selection")
    @iOSXCUITFindBy(accessibility = "EventType_1")
    public MobileElement workDetails;

    @AndroidFindBy(id = "out_time")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Edit'])[2]")
    public MobileElement timeSheetOutTimeEditState;

    @AndroidFindBy(id = "out_label")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Edit'])[3]")
    public MobileElement timeSheetOutTime;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Yes")
    public MobileElement okBtn;

    @AndroidFindBy(accessibility = "Save")
    @iOSXCUITFindBy(accessibility = "Add")
    public MobileElement saveTimesheets;

    @AndroidFindBy(id = "time_entry_save_button")
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

    @AndroidFindBy(id = "save")
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement saveOrderWidgetbtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Add a Comment']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='TimesheetEventDetailView_Other']/XCUIElementTypeCell[5]/XCUIElementTypeTextView")
    public MobileElement inTimeComment;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(accessibility = "The timesheet requested is not in an editable state")
    public MobileElement timesheetErrorMessage;

    @AndroidFindBy(id = "in_time")
//	@iOSXCUITFindBy(accessibility = "")
    public MobileElement inTimeEdit;

    @AndroidFindBy(id = "android:id/hours")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[1]")
    public MobileElement outTime;

    public TimeEntryScreen() {
    }

    public boolean verifyWorkDetails() {
        return isElementDisplayed(workDetails,"Waiting for work detail page to load");
    }

    public void clickOutTimesheetinEditState() {
        click(timeSheetOutTimeEditState, "Clicking on Timesheet out time");
    }

    public void clickOutTimesheet(){
        click(timeSheetOutTime, "Clicking on Timesheet out time");
    }

    public void clickSaveTimesheet() {
        click(saveTimesheets, "Clicking on Save Timesheet button");
    }

    public void clickSaveEditedTimesheet() {
        click(saveButton, "Clicking on Save Timesheet button");
    }

    public void addAnHourToTimesheets() {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            String OutTime = getElementText(outTimeEntry, "Extracting out time text");
            int out = Integer.parseInt(OutTime);
            int changeHourClock = out;
            if (out == 12)
                out = 1;
            else
                out = out + 1;
            By selectTime= By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='" + out + "']");
                click(selectTime,"Clicking on radial time picker");

            if (changeHourClock == 11) {
                if (Boolean.parseBoolean(am_label.getAttribute("checked").toString()))
                    click(pm_label, "Clicking on PM label");
                else
                    click(am_label,"Clicking on AM label");
            }
        } else {
                TouchAction action = new TouchAction(driver);
                int dragX = outTime.getLocation().x + (outTime.getSize().width / 2);
                int dragY = outTime.getLocation().y + (outTime.getSize().height / 2);
                action.press(PointOption.point(dragX, dragY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                        .moveTo(PointOption.point(dragX, dragY - 50)).release().perform();
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

    public String getInTime(){
        return getElementText(inTimeEdit,"Getting in TimeText");
    }

    public void clickIntimeLink(){
        click(inTimeEdit,"Clicking on intime");
    }
}
