package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;

public class AbsenceDetailScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Conf')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Conf')]")
    public MobileElement confirmationNumber;

//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit']")
    @AndroidFindBy(id = "edit_absence_menu_item")
    @iOSXCUITFindBy(accessibility = "AbsenceDetail_Edit_Button")
    public MobileElement editTab;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@index=1])[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Half Day')]")
    public MobileElement durationHalfDay;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tap to Assign']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]//XCUIElementTypeStaticText[3]")
    public MobileElement assignSubstitute;

    @AndroidFindBy(id = "substitute_assign_btn")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='SubstituteSearchTableCell_Assign_Button'])[1]")
    public MobileElement selectSubstitute;

    @AndroidFindBy(id = "assign_substitute_button")
    @iOSXCUITFindBy(accessibility = "AbsenceSubstituteSearchView_FinalAssign_Button")
    public MobileElement confirmAssignSub;

    @AndroidFindBy(id = "absence_approve_button")
    @iOSXCUITFindBy(accessibility = "AbsenceRequestDetailView_Approve_Button")
    public MobileElement approvebtn;

    // month of absence name for verification
    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Yes")
    public MobileElement okBtn;

    public AbsenceDetailScreen() {
    }

    public boolean verifydisplayConfirmationNumber() {
        return isElementDisplayed(confirmationNumber, "Waiting for confirmation number to be displayed");
    }

    public String getAbsenceDetails() {
        return getElementText(confirmationNumber, "Extracting confirmation number");
    }

    public void clickEditAbsenceBtn() {
        click(editTab, "Clicking on edit tab");
    }

    public String verifyEditedDuration() {
        return getElementText(durationHalfDay, "Extracting half day duration text");
    }

    public void click_tapToAssign() {
        click(assignSubstitute, "Clicking on Assign Substitute");
    }

    public void assignSubstitute() {
        click(selectSubstitute, "Clicking on Select Substitute");
    }

    public void clickConfirmAssignSubstitute() {
         click(confirmAssignSub, "Clicking on Confirm Assign Substitute");
    }

    public void clickApproveBtnOnAbsence() {
        click(approvebtn, "Cliking on Approve button");
    }

    public void clickonOkBtn() {
        click(okBtn, "Clicking on Ok Button");
    }
}
