package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import mobile.frontline.stepdef.TimesheetWeekViewScreenStepDef;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.DecimalFormat;

public class TimesheetDayViewScreen extends BasePage{

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_sheet_summary_event_name")
    // @iOSXCUITFindBy(accessibility = "")
    public MobileElement eventSummary;

    //@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index=0]")
    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_sheet_summary_right_chevron")
    // @iOSXCUITFindBy(accessibility = "")
    public MobileElement timeEvent;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/review_dialog_decline_button")
    @iOSXCUITFindBy(accessibility = "Not Now")
    public MobileElement declinebtn;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/menu_item_add_time")
    @iOSXCUITFindBy(accessibility = "Add Time")
    public MobileElement addTimeSheets;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/timesheet_day_text")
    @iOSXCUITFindBy(accessibility = "TimesheetWeekView_Submit_Button")
    public MobileElement timesheetDayView;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    @iOSXCUITFindBy(accessibility = "Week")
    public MobileElement backBtn;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/no_time_events")
   // @iOSXCUITFindBy(accessibility = "")
    public MobileElement noTimeEvent;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/day_view_submit_time_sheet_button")
    @iOSXCUITFindBy(accessibility = "TimesheetWeekView_Submit_Button")
    public MobileElement timesheetDaySubmitBtn;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/undo_icon")
    @iOSXCUITFindBy(accessibility = "TimesheetSummaryView_UndoContainer_View")
    public MobileElement undoicon;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_sheet_day_view_total_amount")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[3]")
    public MobileElement dayTotalTimesheet;

    public TimesheetDayViewScreen(){

    }
    public boolean verifyTimeEventPresent(){
        return  isElementDisplayed(eventSummary, "Waiting for the time event to be displayed");
    }

    public void clickTimeEvent(){
        click(timeEvent, "Clicking on required time event");
    }

    public boolean verifyTimeEvent(){
        //Assert.assertTrue("Required Time Event is visible ",
        return isElementDisplayed(timeEvent,"Waiting for the time event to display");
    }

    public void clickAddTimeEvent(){
        click(addTimeSheets, "Clicking on add time event btn");
    }

    public boolean waitForDayViewScreen(){
        return isElementDisplayed(timesheetDayView, "Waiting for timesheet Day view age");
    }

    public void clickBackBtn(){
        click(backBtn,"Clicking on back btn to navigate to week view page");
    }

    public boolean verifyNoTimeEventExist(){
       return isElementDisplayed(noTimeEvent,"Waiting for for the no time event banner");
    }

    public void clickSubmitDayTimesheetBtn(){
        click(timesheetDaySubmitBtn, "Clicking on day timesheet btn");
    }

    public boolean verifySubmission() {
       return isElementDisplayed(undoicon, "Waiting for Undo btn to be displayed");
//        Assert.assertTrue("Day Timesheet is submitted", smoke.undoicon.isDisplayed());
//        utils.log().info("Day Timesheet is not submitted");
    }

    public String calculateTotalTimeAfterAddingTimesheet() throws InterruptedException {
       isElementDisplayed(dayTotalTimesheet, "waiting for day time event total");
     //  Assert.assertEquals(TimesheetWeekViewScreen.initialWeekTotalTime,"  ");
        String dayTotalTime = getElementText(dayTotalTimesheet,"Extracting day total timesheet text");
        int hours = 0;
        int minutes = 0;
        DecimalFormat formatter = new DecimalFormat("00");
        hours = hours + Integer.parseInt(dayTotalTime.split(":")[0])+ Integer.parseInt(TimesheetWeekViewScreenStepDef.initialWeekTotalTime.split(":")[0]);
        minutes = minutes + Integer.parseInt(dayTotalTime.split(":")[1])+ Integer.parseInt(TimesheetWeekViewScreenStepDef.initialWeekTotalTime.split(":")[1]);
        hours = hours + (minutes/60);
        minutes = minutes%60;
//        totalActualTimeofWeek = hours + ":" +formatter.format(minutes);
        return (hours + ":" +formatter.format(minutes));


        //	weekTotalAfter = getElementText(totalWeekTotalAmount);
//        return null;
    }

    public String verifyTimeFormat() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            isElementDisplayed(dayTotalTimesheet,"Waiting for day total of timesheet to display");
            return getElementText(dayTotalTimesheet,"Extracting values of day timesheet total");
        }
        else {
//                isElementdisplayed(totalWeekTime);
//                return totalWeekTime.getAttribute("name").toString();
            return null;
        }
    }


//    public void verifyTimeFormat() throws Exception {
//        switch (new GlobalParams().getPlatformName()) {
//            case "Android":
//                isElementdisplayed(dayTotalTimesheet);
//                dayTotalTime = common.getElementText(dayTotalTimesheet);
//                break;
//
//            case "iOS":
//                isElementdisplayed(totalWeekTime);
//                weekTotal = totalWeekTime.getAttribute("name").toString();
//                break;
//            default:
//                throw new Exception("Invalid platform Name");
//        }
//        //d = dateFormat.parse(weekTotal);
//        Assert.assertTrue("Time is not in h:mm format",dayTotalTime.equals("1:00") );
//        utils.log().info("Timesheet Date Format");
//    }
}
