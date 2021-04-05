package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.DecimalFormat;
import java.util.List;

public class TimesheetWeekViewScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'TUE')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_0")
    public MobileElement tuesday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'MON')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_6")
    public MobileElement monday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'WED')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_1")
    public MobileElement wednesday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'THU')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_2")
    public MobileElement thursday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'FRI')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_3")
    public MobileElement friday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'SAT')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_4")
    public MobileElement saturday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'SUN')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_5")
    public MobileElement sunday;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_time_sheet_day_total_time")
    // @iOSXCUITFindBy(accessibility = "")
    public List<MobileElement> dayTotalTime;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_sheet_week_view_total_amount")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[3]")
    public MobileElement totalWeekTotalAmount;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/submit_time_sheet_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='TimesheetWeekView_Submit_Button']")
    public MobileElement submittimesheetsbtn;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/undo_icon")
    @iOSXCUITFindBy(accessibility = "TimesheetSummaryView_UndoContainer_View")
    public MobileElement undoicon;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/review_dialog_decline_button")
    @iOSXCUITFindBy(accessibility = "Not Now")
    public MobileElement declinebtn;

    public static String totalExpectedTimeofWeek;
    public static String initialWeekTotalTime;
    public TimesheetWeekViewScreen() {
    }

    public void selectCurrentDayForTimesheet() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            // String nextWorkingDate = nextWorkingDay("current day", "M/dd");
            //isElementdisplayed(monday);
            click(By.xpath("//android.widget.TextView[contains(@text,'" + nextWorkingDay("current day", "M/dd") + "')]"), "Clicking current day on timesheetscreen");
            //click();
        } else {
            //   String nextWorkingDate = nextWorkingDay("current day", "M/dd");
           // isElementdisplayed(tuesday);
            //driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@value,'" + nextWorkingDate + "')]").click();
            click(By.xpath("//XCUIElementTypeStaticText[contains(@value,'" + nextWorkingDay("current day", "M/dd") + "')]"), "Clicking current day on timesheetscreen");
        }
    }

    public void weekTotalTime() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            //isElementDisplayed(monday, "Waiting for Monday ");
            int hours = 0;
            int minutes = 0;
            DecimalFormat formatter = new DecimalFormat("00");

            for (MobileElement mobElement : dayTotalTime) {
                hours = hours + Integer.parseInt(getElementText(mobElement).split(":")[0]);
                minutes = minutes + Integer.parseInt(getElementText(mobElement).split(":")[1]);
            }
            hours = hours + (minutes / 60);
            minutes = minutes % 60;
            totalExpectedTimeofWeek = hours + ":" + formatter.format(minutes);
        } else
            totalExpectedTimeofWeek = getElementText(totalWeekTotalAmount,"Extracting total time of the week");
    }

//    public void getTotalExpectedTimeofWeek1() throws InterruptedException {
//        isElementDisplayed(totalWeekTotalAmount);
//        isElementDisplayed(monday);
//        //Thread.sleep(10000);
//        initialWeekTotalTime = getElementText(totalWeekTotalAmount, "Extracting the total time of the week");
//        Assert.assertEquals(initialWeekTotalTime,"   12");
//       // return getElementText(totalWeekTotalAmount, "Extracting the total time of the week");
//    }

    public String getTotalExpectedTimeofWeek() {
        //initialWeekTotalTime = getElementText(totalWeekTotalAmount, "Extracting the total time of the week");
         return getElementText(totalWeekTotalAmount, "Extracting the total time of the week");
    }

    public void clickWeekTimesheetSubmitBtn(){
        click(submittimesheetsbtn, "Clicking on submit timesheet button");
    }

    public void clickUndoWeekTimesheet() throws Exception {
       // verifyUndoBtn();
        click(undoicon, "Clicked on undo timesheet icon");
       // click(undobtn, "Clicked on undo button");
    }

    public void declinePopUp() {
       if( isElementDisplayed(declinebtn, "Waiting for decline pop up"))
        click(declinebtn, "Clicking on undo decline button");
    }

    public boolean verifySubmitTimesheetBtn() {
       return isElementDisplayed(submittimesheetsbtn, "Waiting for submit timesheet btn");
    }

    public boolean verifyMonday() {
       return isElementDisplayed(monday, "Waiting for Monday to display");
       // Assert.assertTrue("Monday timesheet is not displayed", monday.isDisplayed());
    }

    public boolean verifySunday() {
       return isElementDisplayed(sunday, "Waiting for Sunday to display");
      //  Assert.assertTrue("Sunday timesheet is not displayed", sunday.isDisplayed());
    }

    public boolean verifySaturday() {
      return  isElementDisplayed(saturday, "Waiting for Saturday to display");
     //   Assert.assertTrue("Saturday timesheet is not displayed", saturday.isDisplayed());
    }

    public boolean verifyTuesday() {
       return isElementDisplayed(tuesday,"Waiting for Tuesday to display");
      //  Assert.assertTrue("Tuesday timesheet is not displayed", tuesday.isDisplayed());
    }

    public boolean verifyWednesday() {
      return  isElementDisplayed(wednesday,"Waiting for Wednesday to display");
     //   Assert.assertTrue("Wednesday timesheet is not displayed", wednesday.isDisplayed());
    }

    public boolean verifyThrusday() {
    return  isElementDisplayed(thursday,"Waiting for Thursday to display");
      //  Assert.assertTrue("Thursday timesheet is not displayed", thursday.isDisplayed());
    }

    public boolean verifyFriday() {
        return isElementDisplayed(friday,"Waiting for Friday to display");
      //  Assert.assertTrue("Friday timesheet is not displayed", friday.isDisplayed());
    }
}
