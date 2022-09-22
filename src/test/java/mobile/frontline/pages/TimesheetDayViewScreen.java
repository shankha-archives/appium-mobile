package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import mobile.frontline.stepdef.TimesheetWeekViewScreenStepDef;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.DecimalFormat;

public class TimesheetDayViewScreen extends BasePage {

    @AndroidFindBy(id = "time_sheet_summary_event_name")
    @iOSXCUITFindBy(accessibility = "Time_Event_Cell_0")
    public MobileElement eventSummary;

    @AndroidFindBy(id = "time_sheet_summary_right_chevron")
    @iOSXCUITFindBy(accessibility = "TIME EVENT")
    public MobileElement timeEvent;

    @AndroidFindBy(id = "review_dialog_decline_button")
    @iOSXCUITFindBy(accessibility = "Not Now")
    public MobileElement declinebtn;

    @AndroidFindBy(id = "menu_item_add_time")
    @iOSXCUITFindBy(accessibility = "Add Time")
    public MobileElement addTimeSheets;

    @AndroidFindBy(id = "timesheet_day_text")
    @iOSXCUITFindBy(accessibility = "TimesheetWeekView_Submit_Button")
    public MobileElement timesheetDayView;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    @iOSXCUITFindBy(accessibility = "Week")
    public MobileElement backBtn;

    @AndroidFindBy(id = "no_time_events")
    @iOSXCUITFindBy(accessibility = "You have no time events for this timesheet.")
    public MobileElement noTimeEvent;

    @AndroidFindBy(id = "day_view_submit_time_sheet_button")
    @iOSXCUITFindBy(accessibility = "TimesheetWeekView_Submit_Button")
    public MobileElement timesheetDaySubmitBtn;

    @AndroidFindBy(id = "undo_icon")
    @iOSXCUITFindBy(accessibility = "TimesheetSummaryView_UndoContainer_View")
    public MobileElement undoicon;

    @AndroidFindBy(id = "time_sheet_day_view_total_amount")
    @iOSXCUITFindBy(accessibility = "TimesheetSummaryView_WorkHours_Label")
    public MobileElement dayTotalTimesheet;

    public TimesheetDayViewScreen() {

    }

    public boolean verifyTimeEventPresent() {
        return isElementDisplayed(eventSummary, "Waiting for the time event to be displayed");
    }

    public void clickTimeEvent() {
        click(timeEvent, "Clicking on required time event");
    }

    public boolean verifyTimeEvent() {
        //Assert.assertTrue("Required Time Event is visible ",
        return isElementDisplayed(timeEvent, "Waiting for the time event to display");
    }

    public void clickAddTimeEvent() {
        click(addTimeSheets, "Clicking on add time event btn");
    }

    public boolean waitForDayViewScreen() {
        return isElementDisplayed(timesheetDayView, "Waiting for timesheet Day view age");
    }

    public void clickBackBtn() {
        click(backBtn, "Clicking on back btn to navigate to week view page");
    }

    public boolean verifyNoTimeEventExist() {
        return isElementDisplayed(noTimeEvent, "Waiting for for the no time event banner");
    }

    public void clickSubmitDayTimesheetBtn() {
        click(timesheetDaySubmitBtn, "Clicking on day timesheet btn");
    }

    public boolean verifySubmission() {
        return isElementDisplayed(undoicon, "Waiting for Undo btn to be displayed");
    }

    public String calculateTotalTimeAfterAddingTimesheet() {
        isElementDisplayed(dayTotalTimesheet, "waiting for day time event total");
        String dayTotalTime = getElementText(dayTotalTimesheet, "Extracting day total timesheet text");
        int hours = 0;
        int minutes = 0;
        DecimalFormat formatter = new DecimalFormat("00");
        hours = hours + Integer.parseInt(dayTotalTime.split(":")[0]) + Integer.parseInt(TimesheetWeekViewScreenStepDef.initialWeekTotalTime.split(":")[0]);
        minutes = minutes + Integer.parseInt(dayTotalTime.split(":")[1]) + Integer.parseInt(TimesheetWeekViewScreenStepDef.initialWeekTotalTime.split(":")[1]);
        hours = hours + (minutes / 60);
        minutes = minutes % 60;
        return (hours + ":" + formatter.format(minutes));
    }

    public String verifyTimeFormat() {
        isElementDisplayed(dayTotalTimesheet, "Waiting for day total of timesheet to display");
        return getElementText(dayTotalTimesheet, "Extracting values of day timesheet total");
    }
}
