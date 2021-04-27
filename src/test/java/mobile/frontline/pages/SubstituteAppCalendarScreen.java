package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SubstituteAppCalendarScreen extends BasePage{

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_event_cell_line_two")
    @iOSXCUITFindBy(accessibility = "EventView_Job_Other")
    public MobileElement eventTitle_job;

    public SubstituteAppCalendarScreen(){}

    public void clickOnEvent_job() throws Exception {
        click(eventTitle_job, "Clicking on Event Title");
    }
}
