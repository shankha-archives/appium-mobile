package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.openqa.selenium.By;

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

    public TimesheetWeekViewScreen() {
    }

    public void selectCurrentDayForTimesheet() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
           // String nextWorkingDate = nextWorkingDay("current day", "M/dd");
            isElementdisplayed(monday);
            click(By.xpath("//android.widget.TextView[contains(@text,'" + nextWorkingDay("current day", "M/dd") + "')]"), "Clicking current day on timesheetscreen");
           //click();
        } else {
         //   String nextWorkingDate = nextWorkingDay("current day", "M/dd");
            isElementdisplayed(tuesday);
            //driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@value,'" + nextWorkingDate + "')]").click();
            click(By.xpath("//XCUIElementTypeStaticText[contains(@value,'" + nextWorkingDay("current day", "M/dd") + "')]"),"Clicking current day on timesheetscreen");
        }
    }
}
