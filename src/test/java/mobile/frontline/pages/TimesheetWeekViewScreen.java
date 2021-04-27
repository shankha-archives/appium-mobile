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

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

public class TimesheetWeekViewScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'TUE')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_1")
    public MobileElement tuesday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'MON')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_0")
    public MobileElement monday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'WED')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_2")
    public MobileElement wednesday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'THU')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_3")
    public MobileElement thursday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'FRI')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_4")
    public MobileElement friday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'SAT')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_5")
    public MobileElement saturday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'SUN')]")
    @iOSXCUITFindBy(accessibility = "TimesheetDashboard_TableViewCell_DateSpan_Label_6")
    public MobileElement sunday;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_time_sheet_day_total_time")
    // @iOSXCUITFindBy(accessibility = "")
    public List<MobileElement> dayTotalTime;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_sheet_week_view_total_amount")
    @iOSXCUITFindBy(accessibility = "TimesheetSummaryView_TotalHoursLabel")
    public MobileElement totalWeekTotalAmount;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/submit_time_sheet_button")
    @iOSXCUITFindBy(accessibility = "TimesheetWeekView_Submit_Button")
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
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            click(By.xpath("//android.widget.TextView[contains(@text,'" + nextWorkingDay("current day", "M/dd") + "')]"), "Clicking current day on timesheetscreen");
        else
            click(By.xpath("//XCUIElementTypeStaticText[contains(@value,'" + nextWorkingDay("current day", "M/dd") + "')]"), "Clicking current day on timesheetscreen");
    }

    public void weekTotalTime() throws Exception {
        int hours = 0;
        int minutes = 0;
        DecimalFormat formatter = new DecimalFormat("00");
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            for (MobileElement mobElement : dayTotalTime) {
                hours = hours + Integer.parseInt(getElementText(mobElement).split(":")[0]);
                minutes = minutes + Integer.parseInt(getElementText(mobElement).split(":")[1]);
            }
            hours = hours + (minutes / 60);
            minutes = minutes % 60;
            totalExpectedTimeofWeek = hours + ":" + formatter.format(minutes);
        } else {
            for (int i = 0; i <= 6; i++) {
                if (i == 5) scrollWeekDays();
                MobileElement ele = driver.findElementByAccessibilityId("TimesheetDashboard_TableViewCell_Hours_Label_" + i);
                hours = hours + Integer.parseInt(getElementText(ele).split(":")[0]);
                minutes = minutes + Integer.parseInt(getElementText(ele).split(":")[1]);
            }
            hours = hours + (minutes / 60);
            minutes = minutes % 60;
            totalExpectedTimeofWeek = hours + ":" + formatter.format(minutes);
        }
    }

    public String getTotalExpectedTimeofWeek() {
        return getElementText(totalWeekTotalAmount, "Extracting the total time of the week");
    }

    public void clickWeekTimesheetSubmitBtn() {
        click(submittimesheetsbtn, "Clicking on submit timesheet button");
    }

    public void clickUndoWeekTimesheet() throws Exception {
        click(undoicon, "Clicked on undo timesheet icon");
    }

    public void declinePopUp() {
        if (isElementDisplayed(declinebtn, "Waiting for decline pop up"))
            click(declinebtn, "Clicking on undo decline button");
    }

    public boolean verifySubmitTimesheetBtn() {
        return isElementDisplayed(submittimesheetsbtn, "Waiting for submit timesheet btn");
    }

    public boolean verifyMonday() {
        return isElementDisplayed(monday, "Waiting for Monday to display");
    }

    public boolean verifySunday() {
        return isElementDisplayed(sunday, "Waiting for Sunday to display");
    }

    public boolean verifySaturday() {
        scrollWeekDays();
        return isElementDisplayed(saturday, "Waiting for Saturday to display");
    }

    public boolean verifyTuesday() {
        return isElementDisplayed(tuesday, "Waiting for Tuesday to display");
    }

    public boolean verifyWednesday() {
        return isElementDisplayed(wednesday, "Waiting for Wednesday to display");
    }

    public boolean verifyThrusday() {
        return isElementDisplayed(thursday, "Waiting for Thursday to display");
    }

    public boolean verifyFriday() {
        return isElementDisplayed(friday, "Waiting for Friday to display");
    }

    public void scrollWeekDays() {
        TouchAction action = new TouchAction(driver);
        int dragX = friday.getLocation().x + (friday.getSize().width / 2);
        int dragY = friday.getLocation().y + (friday.getSize().height / 2);
        action.press(PointOption.point(dragX, dragY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(dragX, dragY - 150)).release().perform();
    }
}
