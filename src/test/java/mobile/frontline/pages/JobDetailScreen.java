package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;

public class JobDetailScreen extends BasePage {

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_job_detail_date")
    public MobileElement jobDateOnJobDescription;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Accept']")
    @iOSXCUITFindBy(accessibility = "JobDetailVC_AcceptButton")
    public MobileElement jobAcceptBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reject']")
    @iOSXCUITFindBy(accessibility = "Reject")
    public MobileElement jobRejectBtn;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(accessibility = "You have successfully accepted this job.")
    public MobileElement successMsg;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reject']")
    @iOSXCUITFindBy(accessibility = "Reject Job")
    public MobileElement jobRejectConfirmBtn;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Are you sure you want to reject this job?']")
    public MobileElement rejectDialogMsg;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Okay")
    public MobileElement successOkBtn;

    @AndroidFindBy(xpath = "//*[@content-desc='Navigate up']")
    @iOSXCUITFindBy(accessibility = "Back")
    public MobileElement backFromAcceptedJob;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You have accepted this job']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Job Detail']")
    public MobileElement jobDetailsConfirmation;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Conf')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Conf')]")
    public MobileElement confirmationNo;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_job_detail_date")
    @iOSXCUITFindBy(accessibility = "JobDetailDayView_JobDate_Label")
    public MobileElement jobDetailDate;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='AutomationEmp 8328']")
    public MobileElement jobDetailEmployee;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GL_Performance_4CF65528C-ACCA-4ED7-9E19-D8C553C344']")
    public MobileElement jobDetailSchoolName;


    public static String job_date;

    public JobDetailScreen() {
    }

    public void storeJobDetails() {
        if (new GlobalParams().getPlatformName().contains("Android")) {
            job_date = getElementText(jobDateOnJobDescription, "Extracting job date from job detail page").split(", ")[1];
        }
    }

    public void clickOnAcceptJobsBtn() {
        click(jobAcceptBtn, "Clicking on Accept job button");
    }

    public void clickOnRejectJobsBtn() {
        click(jobRejectBtn, "Clicking on Reject btn");
    }

    public String successMsgPOPUP() {
        isElementDisplayed(successMsg, "Waiting from accept job success message");
        return getElementText(successMsg, "Extracting job success message");
    }

    public String rejectMsgPopUp() {
        isElementDisplayed(rejectDialogMsg, "Waiting from reject job  message popup");
        return getElementText(rejectDialogMsg, "Extracting job Reject message");
    }

    public void clickOnOkBtn_successMsg() {
        click(successOkBtn, "Clicking on Success OK button is displayed");
    }

    public void clickOnOkRejectBtn_successMsg() {
        click(jobRejectConfirmBtn, "Clicking on Success OK button is displayed");
    }


    public boolean jobAcceptConfirmationMsg() {
        return isElementDisplayed(jobDetailsConfirmation, "Waiting for confirmation number to be displayed");
    }

    public String confirmationPresent() {
        isElementDisplayed(confirmationNo, "Waiting for confirmation number to be displayed");
        return getElementText(confirmationNo, "Extracting confirmation number");
    }

    public String getJobDate() {
        isElementDisplayed(jobDetailDate, "Waiting for job date details to display");
        return getElementText(jobDetailDate, "Extracting job date text");
    }

    public void backButtonToAvailableJobScreen() throws Throwable {
        click(backFromAcceptedJob , "Clicking on Navigating back to Jobs");
    }

    public boolean waitForEmployeeName() {
        return  isElementDisplayed(jobDetailEmployee, "Waiting for job employee name details to display");
    }

    public boolean waitForSchoolName() {
        return  isElementDisplayed(jobDetailSchoolName, "Waiting for job school name details to display");
    }

}
