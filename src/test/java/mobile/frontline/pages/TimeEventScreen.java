package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;

public class TimeEventScreen extends BasePage {

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/edit_menu_item")
    @iOSXCUITFindBy(accessibility = "Edit")
    public MobileElement dailytimeSheetedittbtn;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    @iOSXCUITFindBy(accessibility = "Week")
    public MobileElement backBtn;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/in_comment")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='TimesheetEventDetailView_Other']/XCUIElementTypeCell[5]/XCUIElementTypeTextView")
    public MobileElement inTimeCommentVerify;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/delete_event_button")
    @iOSXCUITFindBy(accessibility = "Delete Event")
    public MobileElement timeSheetDeletebtn;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Okay")
    public MobileElement okBtn;

    public TimeEventScreen() {
    }

    public void timeEntryEditBtnClick() {
        click(dailytimeSheetedittbtn, "Clicking on Daily Timesheet Edit Button");
    }

    public boolean verifyEditbtnVisible() {
        return isElementDisplayed(dailytimeSheetedittbtn, "Waiting for edit btn to be visible");
    }

    public void navigateToDayView() {
        click(backBtn, "Clicking on back btn");
    }

    public String verifyEditedComment() throws Throwable {
        return getElementText(inTimeCommentVerify, "Getting text of the added comment");
    }

    public void clickDeleteTimesheet() throws Throwable {
        click(timeSheetDeletebtn, "Clicking on Timesheet Delete Button");
    }

    public void clickOkPopUp() {
        click(okBtn, "Clicking on Ok Button");
    }

}
