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
    @iOSXCUITFindBy(accessibility = "Available Jobs_ModuleHeader")
    public MobileElement availableJobs;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/widget_footer_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement viewAllAvailableJobsBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Jobs']")
    @iOSXCUITFindBy(accessibility = "view_header")
    public MobileElement availableJobsHeader;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/job_cell_information_inner_cointainer")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Frontline\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]")
    public MobileElement jobslist;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Accept']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Accept\"]")
    public MobileElement jobAcceptBtn;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(accessibility = "You have successfully accepted this job.")
    public MobileElement successMsg;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Okay")
    public MobileElement successOkBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Job Detail']")
    @iOSXCUITFindBy(accessibility = "//XCUIElementTypeApplication[@name=\"Frontline\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")    
    public MobileElement jobDetailsHeader;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Conf')]") 
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Conf')]")    
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH 'Conf '")
    public MobileElement confirmationNumber;
    
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='VeriTime Automation Org 20 - DO NOT USE']")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement veritimeorg;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Substitute']")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement SubtituteUser;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Alphabet School District']")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement chesterorg;
	
	
	//////////////////////////////////////////////555555555
	@AndroidFindBy(xpath = "//[@class='android.widget.RelativeLayout' and @resource-id='com.frontline.frontlinemobile:id/fragment_card_widget_header']//[@index='1']")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement noavailablejobs;

	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement contbtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Switch']")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement switchbtn;

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
	
	 public void selectOrg()
		{
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fluentWait(veritimeorg);
			 Assert.assertTrue("Available Organizations are not displayed", veritimeorg.isDisplayed());
		     utils.log().info("Available Organizations are  displayed");
		     click(veritimeorg);
		     click(contbtn);
		     try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     fluentWait(SubtituteUser);
			 Assert.assertTrue("Available roles are not displayed", veritimeorg.isDisplayed());
		     utils.log().info("Available roles are  displayed");
		     click(SubtituteUser);
		     click(contbtn);

		}
	    
	    public String checkAvailablejob() {
	    	 try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	fluentWait(availableJobs);
		     common.isElementDisplayed(availableJobs);
		        Assert.assertTrue("Available Jobs option is not displayed Home page", availableJobs.isDisplayed());
		        utils.log().info("Available Jobs option is displayed on Home page");
		        
		        try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        ////////////Extract the available jobs
		        String jobs=getElementText(noavailablejobs);
		        //Assert.assertEquals(jobs, "16");
		        return jobs;
		        //System.out.println(jobs);
		        
		     
	    }
	    public void switchToAnotherOrg()
	    {
	    	click(switchbtn);	
	    	try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fluentWait(chesterorg);
			 Assert.assertTrue("Available Organizations are not displayed", chesterorg.isDisplayed());
		     utils.log().info("Available Organizations are  displayed");
		     click(chesterorg);
		     click(contbtn);
		     try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     fluentWait(SubtituteUser);
			 Assert.assertTrue("Available roles are not displayed", chesterorg.isDisplayed());
		     utils.log().info("Available roles are  displayed");
		     click(SubtituteUser);
		     click(contbtn);
	    }
}
