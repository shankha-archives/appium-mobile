package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.TestUtils;
import org.junit.Assert;

public class JobsMethods extends LoginPage{
    TestUtils utils = new TestUtils();
    BasePage common = new BasePage();
    LoginPage loginPage = new LoginPage();

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Jobs']")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement availableJobs;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/widget_footer_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement viewAllAvailableJobsBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Jobs']")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement availableJobsHeader;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/job_cell_information_inner_cointainer")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement jobslist;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Accept']")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement jobAcceptBtn;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement successMsg;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement successOkBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Job Detail']")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement jobDetailsHeader;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Conf')]") 
    public MobileElement confirmationNumber;

//#########################################################################################################################
    public JobsMethods(){
    }

    public void clickOnAvailableJobs_displayed() {
        common.swipeUpSlowly();
        common.swipeUpSlowly();
        common.swipeUpSlowly();
        common.swipeUpSlowly();
        common.isElementDisplayed(availableJobs);
        Assert.assertTrue("Available Jobs option is not displayed Home page", availableJobs.isDisplayed());
        utils.log().info("Available Jobs option is displayed on Home page");
        click(availableJobs);
        Assert.assertTrue("Available Jobs list page is not displayed", availableJobsHeader.isDisplayed());
        utils.log().info("Available Jobs list Page is displayed");
    }

    public void clickOnAvailableJobs(){
        Assert.assertTrue("Available Jobs list not displayed", jobslist.isDisplayed());
        utils.log().info("Available Jobs list is displayed");
        click(jobslist);
        utils.log().info("clicked on Job ");
    }
    public void clickOnAcceptJobsBtn(){
        fluentWait(jobAcceptBtn);
        Assert.assertTrue("Accept job btn is not displayed", jobAcceptBtn.isDisplayed());
        utils.log().info("Accept job btn is displayed");
        click(jobAcceptBtn);
        utils.log().info("clicked on Accept button");
    }

    public void successMsgPOPUP()
    {
        fluentWait(successMsg);
        Assert.assertTrue("Success message is not displayed", successMsg.isDisplayed());
        utils.log().info("Success message is displayed");
    }

    public void clickOnOkBtn_successMsg()
    {
        Assert.assertTrue("Okay button is not displayed", successOkBtn.isDisplayed());
        utils.log().info("Success OK button is displayed");
        click(successOkBtn);
        utils.log().info("Click on Success OK button is displayed");
    }

    public void jobDetailsPageLoads()
    {
        fluentWait(jobDetailsHeader);
        Assert.assertTrue("Job Details page is not displayed", jobDetailsHeader.isDisplayed());
        utils.log().info("Job Details page is displayed");
    }
    
	public void confirmationPresent() {
        Assert.assertTrue("Confirmation number is not displayed", confirmationNumber.isDisplayed());
        utils.log().info("Confirmation number is displayed");
	}
}
