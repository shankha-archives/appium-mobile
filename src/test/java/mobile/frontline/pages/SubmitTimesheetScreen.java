package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SubmitTimesheetScreen extends BasePage {

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/submit_time_sheets_button")
    @iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_Submit_Button")
    public MobileElement submitTimesheet;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/undo_time_sheets_button")
    @iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_UndoSubmit_Button")
    public MobileElement undobtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter PIN']")
    @iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_EnterPin_TextField")
    public MobileElement enterPin;

    @iOSXCUITFindBy(accessibility = "Invalid PIN")
    public MobileElement inValidPin;

    public void submitTimesheet() {
        click(submitTimesheet, "Clicked on submit submit timesheet");
    }

    public void clickUndoTimesheet() throws Exception {
        // verifyUndoBtn();
        // click(undoicon, "Clicked on undo timesheet icon");
        click(undobtn, "Clicked on undo button");
    }

    public void enterTimesheetsWithIncorrectPin() {
        sendKeys(enterPin, "3661", "Entering digital Pin");
        //driver.getKeyboard().sendKeys("3661");
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
        //
    }
}
