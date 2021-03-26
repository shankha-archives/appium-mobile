package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TimeEventScreen extends BasePage{

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/edit_menu_item")
    @iOSXCUITFindBy(accessibility = "Edit")
    public MobileElement dailytimeSheetedittbtn;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    @iOSXCUITFindBy(accessibility = "Week")
    public MobileElement backBtn;

    public TimeEventScreen(){}

    public void timeEntryEditBtnClick() {
        click(dailytimeSheetedittbtn, "Clicking on Daily Timesheet Edit Button");
    }

    public boolean verifyEditbtnVisible(){
      return isElementDisplayed(dailytimeSheetedittbtn, "Waiting for edit btn to be visible");
    }

    public void navigateToDayView(){
        click(backBtn, "Clicking on back btn");
    }
}
