package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.By;

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
          return IsElementPresent(By.xpath("//android.widget.TextView[contains(@text,'" + TimeEntryScreen.outTime + "')]"));

    }
}
