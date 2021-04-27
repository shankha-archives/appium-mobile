package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestDataManager;
import org.junit.Assert;
import org.openqa.selenium.By;

public class EmployeeAppCalendarScreen extends BasePage {

    public TestDataManager testdata = new TestDataManager();

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Calendar']")
    public MobileElement calendar;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeStaticText)[2]")
    public MobileElement calendartitle;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_right_button_image")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='DatePicker_RightTapArea_Other']")
    public MobileElement nextMonthCalendar;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_event_cell_line_two")
    @iOSXCUITFindBy(accessibility = "EventView_Absence_Other")
    public MobileElement eventTitle_absences;

    public EmployeeAppCalendarScreen() {

    }

    public String waitForSearchResult() throws Exception {
        isElementDisplayed(calendar, "Waiting for application calendar to display");
        return getElementText(calendar, "Getting text of App Calendar");
    }

    public void getRequiredMonthInCalendar(String absence_month) throws Exception {
        isElementDisplayed(calendartitle, "Waiting for calendar month to display");
        String monthName;

        if ((new GlobalParams().getPlatformName()).contains("Android"))
            monthName = getElementText(calendartitle, "Extracting month name in calendar");
        else
            monthName = calendartitle.getAttribute("name").toString();

        for (int i = 0; i < 12; i++) {
            if (!monthName.contains(absence_month)) {
                click(nextMonthCalendar, "Clicking on next Month Calendar");
                isElementDisplayed(calendartitle, "Waiting for calendar month to display");
            } else
                break;
        }
    }

    public void clickCalendarEventDay(String absence_day) {
        By eventDay;
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            eventDay = By.xpath("//android.widget.TextView[contains(@content-desc,'" + absence_day + "')]");
        else
            eventDay = By.xpath("//XCUIElementTypeCell[contains(@name, '" + absence_day + "')]");

        click(eventDay, "Clicking on the required event");
    }

    public void clickOnEvent_absences() throws Exception {
        click(eventTitle_absences, "Clicking on Event Title");
    }
}
