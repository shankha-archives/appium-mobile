package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SubmitTimesheetScreen extends BasePage {

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/submit_time_sheets_button")
    @iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_Submit_Button")
    public MobileElement submitTimesheet;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/undo_time_sheets_button")
    @iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_UndoSubmit_Button")
    public MobileElement undobtn;

    public void submitTimesheet() {
        click(submitTimesheet, "Clicked on submit submit timesheet");
    }

    public void clickUndoTimesheet() throws Exception {
        // verifyUndoBtn();
        // click(undoicon, "Clicked on undo timesheet icon");
        click(undobtn, "Clicked on undo button");
    }
}
