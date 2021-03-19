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

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(accessibility = "You have successfully accepted this job.")
    public MobileElement successMsg;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Okay")
    public MobileElement successOkBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You have accepted this job']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Job Detail']")
    public MobileElement jobDetailsConfirmation;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Conf')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Conf')]")
    public MobileElement confirmationNo;

    public static String job_date;

    public JobDetailScreen() {
    }

    public void storeJobDetails() {
        if (new GlobalParams().getPlatformName().contains("Android")) {
             job_date = getElementText(jobDateOnJobDescription).split(", ")[1];
            //return job_date;
        }
       // return null;
    }

    public void clickOnAcceptJobsBtn() {
        Assert.assertTrue("Accept job btn is not displayed", isElementDisplayed(jobAcceptBtn));
        click(jobAcceptBtn, "Accept job btn is displayed");
    }

    public String successMsgPOPUP() throws Exception {
        isElementDisplayed(successMsg);
        return getElementText(successMsg);
    }
    public void clickOnOkBtn_successMsg() {
        click(successOkBtn,"Clicking on Success OK button is displayed");
    }

    public boolean jobAcceptConfirmationMsg() {

        return  isElementDisplayed(jobDetailsConfirmation);
//        isElementDisplayed(jobDetailsConfirmation);
//        Assert.assertTrue("Job Details page is not displayed", jobDetailsConfirmation.isDisplayed());
//        utils.log().info("Job Details page is displayed");
    }

    public boolean confirmationPresent() {
//        Assert.assertTrue("Confirmation number is not displayed",
//                getElementText(confirmationNo).contains(APIServices.confirmationNumber));

        return getElementText(confirmationNo).contains(APIServices.confirmationNumber);
    }

}
