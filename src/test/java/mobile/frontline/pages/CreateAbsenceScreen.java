package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateAbsenceScreen extends BasePage {

    @AndroidFindBy(accessibility = "why are you absent... choose from the list")
    @iOSXCUITFindBy(accessibility = "Why?")
    public MobileElement absenceReasonVerification;

    @AndroidFindBy(xpath = "(//android.widget.LinearLayout)[4]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[3]")
    public MobileElement reason;

    @AndroidFindBy(id = "create_absence_forward_button")
    @iOSXCUITFindBy(accessibility = "Create_Absence_NextStep_Button")
    public MobileElement forwardCaret;

    @AndroidFindBy(accessibility = "When?")
    @iOSXCUITFindBy(accessibility = "When?")
    public MobileElement datePageVerification;

    @AndroidFindBy(accessibility = "How Long will you be absent... choose from the following options")
    @iOSXCUITFindBy(accessibility = "How Long?")
    public MobileElement durationPageVerification;

    @AndroidFindBy(id = "shift_type_full_day")
    @iOSXCUITFindBy(accessibility = "CreateAbsence_FullDay_Button")
    public MobileElement selectDuration;

    @AndroidFindBy(id = "shift_type_custom")
    @iOSXCUITFindBy(accessibility = "CreateAbsence_Custom_Button")
    public MobileElement selectCustomDuration;

    @AndroidFindBy(accessibility = "Substitute")
    @iOSXCUITFindBy(accessibility = "Substitute")
    public MobileElement subAssignPageVerification;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Review']")
    @iOSXCUITFindBy(accessibility = "Review")
    public MobileElement reviewPageVerification;

    @AndroidFindBy(id = "progress_footer_submit_button")
    @iOSXCUITFindBy(accessibility = "Submit_Absence")
    public MobileElement submitAbsence;

    @AndroidFindBy(xpath = "//*[@text='Your absence was created successfully.']")
    @iOSXCUITFindBy(accessibility ="Your absence was created successfully.")
    public MobileElement createdAbsenceVerificationMsg;

    @AndroidFindBy(id = "shift_type_half_day_pm")
    @iOSXCUITFindBy(accessibility = "CreateAbsence_HalfDayPM_Button")
    public MobileElement halfDaypmDuration;

    @AndroidFindBy(id = "shift_type_half_day_am")
    @iOSXCUITFindBy(accessibility = "CreateAbsence_HalfDayAM_Button")
    public MobileElement halfDayamDuration;

    @AndroidFindBy(id = "progress_footer_submit_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit_Absence']")
    public MobileElement saveChanges;

    @AndroidFindBy(id = "view_absence_button")
    @iOSXCUITFindBy(accessibility = "View Absence")
    public MobileElement viewAbsence;

    @AndroidFindBy(accessibility = "Who?")
    @iOSXCUITFindBy(accessibility = "Who?")
    public MobileElement absenceRequiredFor;

    @AndroidFindBy(id = "search_view_edit_text")
    @iOSXCUITFindBy(accessibility = "Search employees by last name")
    public MobileElement serachEditText;

    @AndroidFindBy(id = "create_absence_list_cell_name")
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

    public void selectDate(String absenceDay, String amount) throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            nextWorkingDate = workingDay(absenceDay, "MMM d, yyyy", Integer.parseInt(amount));
            scrolledToElement = androidScrollToElementUsingUiScrollable("description", nextWorkingDate, "Scrolling to the require date");
            scrolledToElement.click();
        } else {
            nextWorkingDate = workingDay(absenceDay, "MM/dd/yyyy", Integer.parseInt(amount));
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

    public void selectCustomDuration() throws Exception {
        click(selectCustomDuration, "Clicking on custom day duration");
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

    public void clickHalfDayPMDuration() {
        click(halfDaypmDuration, "Clicking on half day duration btn");
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

    public void clickHalfDayAMDuration() {
        click(halfDayamDuration, "Clicking on half day duration btn");
    }
}
