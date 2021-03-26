package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;

public class TimeEntryScreen extends BasePage{

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/fl_spinner_selection")
    @iOSXCUITFindBy(accessibility = "EventType_1")
    public MobileElement workDetails;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/out_time")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Edit'])[3]")
    public MobileElement timeSheetOutTime;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Yes")
    public MobileElement okBtn;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_entry_save_button")
    @iOSXCUITFindBy(accessibility = "Add")
    public MobileElement saveTimesheets;

    @iOSXCUITFindBy(accessibility = "Save")
    public MobileElement saveButton;

    public static String outTime;

    public TimeEntryScreen(){}

    public boolean verifyWorkDetails(){
        return  isElementdisplayed(workDetails);
    }

    public void clickOutTimesheet(){
        click(timeSheetOutTime, "Clicked on Timesheet out time");
    }

    public void clickOkPopup(){
        click(okBtn, "Clicked on Ok Button ");
    }

    public void getOutTimeText(){
        outTime = getElementText(timeSheetOutTime);
    }

    public void clickSaveTimesheet(){
        click(saveTimesheets, "Clicked on Save Timesheet button");
    }

//    public void editTimesheetForClockOut() throws Throwable {
//        switch (new GlobalParams().getPlatformName()) {
//            case "Android":
//
//                isElementdisplayed(workDetails);
//                click(timeSheetOutTime, "Clicked on Timesheet out time");
//                click(okBtn, "Clicked on Ok Button ");
//                outTime = getElementText(timeSheetOutTime);
//                click(saveTimesheets, "Clicked on Save Timesheet button");
//                break;
//            case "iOS":
////                timeEntryEditBtnClick();
////                clickonEditButton1();
////                clickonEditButton2();
////                AddTextonCommentSection();
//                click(saveButton, "Clicked on Save Timesheet button");
////                if (isElementdisplayed(declinebtn)) {
////                    click(declinebtn, "Clicked on Decline button");
////                }
//                break;
//            default:
//                throw new Exception("Invalid platform Name");
//        }
//    }

}
