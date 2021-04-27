package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateAbsenceScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Why?']")
    @iOSXCUITFindBy(accessibility = "Why?")
    public MobileElement absenceReasonVerification;

    @AndroidFindBy(xpath = "(//android.widget.LinearLayout)[4]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[3]")
    public MobileElement reason;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/progress_footer_forward_circle")
    @iOSXCUITFindBy(accessibility = "Create_Absence_NextStep_Button")
    public MobileElement forwardCaret;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='When?']")
    @iOSXCUITFindBy(accessibility = "When?")
    public MobileElement datePageVerification;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How Long?']")
    @iOSXCUITFindBy(accessibility = "How Long?")
    public MobileElement durationPageVerification;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/shift_type_full_day")
    @iOSXCUITFindBy(accessibility = "CreateAbsence_FullDay_Button")
    public MobileElement selectDuration;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Substitute']")
    @iOSXCUITFindBy(accessibility = "Substitute")
    public MobileElement subAssignPageVerification;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Review']")
    @iOSXCUITFindBy(accessibility = "Review")
    public MobileElement reviewPageVerification;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/progress_footer_submit_button")
    @iOSXCUITFindBy(accessibility = "Submit_Absence")
    public MobileElement submitAbsence;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your absence was created successfully.']")
    public MobileElement createdAbsenceVerificationMsg;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/shift_type_half_day_pm")
    @iOSXCUITFindBy(accessibility = "CreateAbsence_HalfDayPM_Button")
    public MobileElement halfDayDuration;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/progress_footer_submit_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit_Absence']")
    public MobileElement saveChanges;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/view_absence_button")
    @iOSXCUITFindBy(accessibility = "View Absence")
    public MobileElement viewAbsence;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Who?']")
    @iOSXCUITFindBy(accessibility = "Who?")
    public MobileElement absenceRequiredFor;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/search_view_edit_text")
    @iOSXCUITFindBy(accessibility = "Search employees by last name")
    public MobileElement serachEditText;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/create_absence_list_cell_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
    public MobileElement selectReqName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Next: Choose Reason']")
    @iOSXCUITFindBy(xpath = "(//*[@type='XCUIElementTypeStaticText'])[3]")
    public MobileElement whoAbsencePageWaittoClickCaret;

    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement Done;

    String nextWorkingDate;
    public WebElement scrolledToElement;

    public CreateAbsenceScreen() {
    }

    public boolean waitForAsbsenceReasonPage() {
        return isElementDisplayed(absenceReasonVerification, "Waiting for absence reason page");
    }

    public void absenceReason() throws Exception {
        click(reason, "Clicking on Absence Reason");
    }

    public void clickNext() throws InterruptedException {
        click(forwardCaret, "Clicking forward btn");
    }

    public boolean waitForAsbsenceDatePage() {
        return isElementDisplayed(datePageVerification, "Waiting for date page to display");
    }

    public void selectDate(String absenceDay) throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            nextWorkingDate = nextWorkingDay(absenceDay, "MMMM dd, yyyy");
            scrolledToElement = androidScrollToElementUsingUiScrollable("description", nextWorkingDate, "Scrolling to the require date");
            scrolledToElement.click();
        } else {
            nextWorkingDate = nextWorkingDay(absenceDay, "MM/dd/yyyy");
            By absenceDate = By.xpath("//XCUIElementTypeCell[contains(@name,'" + nextWorkingDate + "')]");
            scrollToElement(absenceDate, "up","Scrolling to the required date");
            click(absenceDate, "Clicking on Absence Date");
        }
    }

    public void editDate(String absenceDay) throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            nextWorkingDate = nextWorkingDay(absenceDay, "MMMM dd, yyyy");
            scrolledToElement = androidScrollToElementUsingUiScrollable("description", nextWorkingDate, "Scrolling to the require date");
            scrolledToElement.click();
        } else {
            nextWorkingDate = nextWorkingDay(absenceDay, "MM/dd/yyyy");
            By absenceDate = By.xpath("//XCUIElementTypeCell[contains(@name,'" + nextWorkingDate + "')]");
            scrollToElement(absenceDate, "up","Scrolling to the required date");
        }
    }

    public boolean waitForAsbsenceDuratioPage() {
        return isElementDisplayed(durationPageVerification, "Waiting for duration page to load");
    }

    public void selectDuration() throws Exception {
        click(selectDuration, "Clicking on full day duration");
    }

    public boolean substituteAssignPageVerification() throws Exception {
        return isElementDisplayed(subAssignPageVerification, "Waiting for assign substitute page to display");
    }

    public boolean waitForReviewAbsencePage() {
        return isElementDisplayed(reviewPageVerification, "Waiting for review page to display");
    }

    public void submitAbsence() throws Exception {
        click(submitAbsence, "Clicking on submit absence");
    }

    public boolean waitForAbsenceCreationPopup() {
        return isElementDisplayed(createdAbsenceVerificationMsg,"Waiting for absence verification messgae");
    }

    public void editDuration() {
        click(halfDayDuration, "Clicking on half day duration btn");
    }

    public void clickSaveAbsence() {
        click(saveChanges, "Clicking on Save changes button");
    }

    public void clickViewAbsence() {
        click(viewAbsence, "Clicking on view Absence");
    }

    public boolean waitForWhoPage() {
        return isElementDisplayed(absenceRequiredFor,"Waiting for selecting employee page ");
    }

    public void enterTeachersName(String teacher) throws Exception {
        sendKeys(serachEditText, teacher, "Entering the employee's name for which absence is created");
    }

    public void selectTeachersName(String teacher) throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            isElementDisplayed(selectReqName,"Waiting for the required employee name to appear");
            By teacherNameAndroid = By.xpath("//android.widget.TextView[contains(@text,'" + teacher + "')]");
            scrollToElement(teacherNameAndroid, "up");
            click(teacherNameAndroid, "Clicking Teacher name");
        } else {
            isElementDisplayed(whoAbsencePageWaittoClickCaret,"Waiting for the text to appear");
            By teacherName = By.xpath("//XCUIElementTypeButton[contains(@name,'" + teacher + "')]");
            click(Done, "Clicking on Done button");
            scrollToElement(teacherName, "up");
            click(teacherName, "Clicking Teacher name");
        }
    }

    public boolean waitForForwardBtn() {
        return isElementDisplayed(whoAbsencePageWaittoClickCaret, "Waiting for who absence page to display");
    }
}
