package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SubmitTimesheetScreen extends BasePage {

    @AndroidFindBy(id = "submit_time_sheets_button")
    @iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_Submit_Button")
    public MobileElement submitTimesheet;

    @AndroidFindBy(id = "undo_icon")
    @iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_UndoSubmit_Button")
    public MobileElement undobtn;

    @AndroidFindBy(id ="undo_time_sheets_button")
    @iOSXCUITFindBy(accessibility = "To be done later")
    public MobileElement undoButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter PIN']")
    @iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_EnterPin_TextField")
    public MobileElement enterPin;

    @iOSXCUITFindBy(accessibility = "Invalid PIN")
    public MobileElement inValidPin;

    public void submitTimesheet() {
        click(submitTimesheet, "Clicking on submit timesheet");
    }

    public void clickUndoTimesheet() throws Exception {
        click(undobtn, "Clicking on undo button");
    }

    public void enterTimesheetsWithIncorrectPin() {
        sendKeys(enterPin, "3661", "Entering digital Pin");
        hideKeyboard();
    }

    public String toastMessge() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            Thread.sleep(2000);
            WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
            return toastView.getAttribute("name");
        } else {
            isElementDisplayed(inValidPin,"Waiting for invalid pip pop up");
            return getElementText(inValidPin);
        }
    }

    public void clickUndoButton() {
        click(undoButton, "Clicking on undo button");
    }
}
