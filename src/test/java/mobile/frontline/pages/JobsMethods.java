package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.TestUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;

public class JobsMethods extends LoginPage {
	TestUtils utils = new TestUtils();
	BasePage common = new BasePage();
	//LoginPage loginPage = new LoginPage();

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Jobs']")
	@iOSXCUITFindBy(accessibility = "Available Jobs_ModuleHeader")
	public MobileElement availableJobs;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Jobs']")
	@iOSXCUITFindBy(accessibility = "view_header")
	public MobileElement availableJobsHeader;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/job_cell_information_inner_cointainer")
	@iOSXCUITFindBy(accessibility = "jobListingCell_right_angle_arrow")
	public MobileElement jobslist;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Accept']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Accept']")
	public MobileElement jobAcceptBtn;

	@AndroidFindBy(id = "android:id/message")
	@iOSXCUITFindBy(accessibility = "You have successfully accepted this job.")
	public MobileElement successMsg;

	@AndroidFindBy(id = "android:id/button1")
	@iOSXCUITFindBy(accessibility = "Okay")
	public MobileElement successOkBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Job Detail']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Job Detail']")
	public MobileElement jobDetailsHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Conf')]")
	@iOSXCUITFindBy(xpath = "//*[contains(@name, 'Conf')]")
	// @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND
	// name BEGINSWITH 'Conf '")
	public MobileElement confirmationNumber;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='VeriTime Automation Org 20 - DO NOT USE']")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement veritimeorg;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Substitute']")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement SubtituteUser;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Alphabet School District']")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement chesterorg;

	////////////////////////////////////////////// 555555555

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/widget_header_right_bubble")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement noavailablejobs;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement contbtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Switch']")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement switchbtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/job_listing_cell_duration_date")
	public MobileElement jobDate;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/job_listing_cell_time")
	public MobileElement jobTime;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/job_listing_cell_location")
	public MobileElement jobOrg;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
	public MobileElement homeButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index=3]")
	public MobileElement AllDistrict;

	public String job_date;
	public String job_time;
	public String job_org;

	// String jobs=getElementText(noavailablejobs);
//#########################################################################################################################
	public JobsMethods() {
	}

	public void clickOnAvailableJobs_displayed() throws Exception {
		common.scrollToElement(availableJobs, "up");
		common.isElementDisplayed(availableJobs);
		Assert.assertTrue("Available Jobs option is not displayed Home page", availableJobs.isDisplayed());
		utils.log().info("Available Jobs option is displayed on Home page");
		click(availableJobs);
		isElementDisplayed(availableJobsHeader);
		Assert.assertTrue("Available Jobs list page is not displayed", availableJobsHeader.isDisplayed());
		utils.log().info("Available Jobs list Page is displayed");

		storeJobDetails();

	}

	private void storeJobDetails() {
		job_date = getElementText(jobDate);
		job_time = getElementText(jobTime);
		job_org = getElementText(jobOrg);
	}

	public void verifyAcceptedJob() {
		String date = getElementText(jobDate);
		String time = getElementText(jobTime);
		String org = getElementText(jobOrg);

		Assert.assertTrue("Accepted job still present in the jobs list",
				!(date == job_date && time == job_time && org == job_org));
		utils.log().info("Accepted job removed from jobs list");
	}

	public void clickOnAvailableJobs() {
		isElementDisplayed(jobslist);
		Assert.assertTrue("Available Jobs list not displayed", jobslist.isDisplayed());
		utils.log().info("Available Jobs list is displayed");
		click(jobslist);
		utils.log().info("clicked on Job ");
	}

	public void clickOnAcceptJobsBtn() {
		isElementDisplayed(jobAcceptBtn);
		Assert.assertTrue("Accept job btn is not displayed", jobAcceptBtn.isDisplayed());
		utils.log().info("Accept job btn is displayed");
		click(jobAcceptBtn);
		utils.log().info("clicked on Accept button");
	}

	public void successMsgPOPUP() {
		isElementDisplayed(successMsg);
		Assert.assertTrue("Success message is not displayed", successMsg.isDisplayed());
		utils.log().info("Success message is displayed");
	}

	public void clickOnOkBtn_successMsg() {
		Assert.assertTrue("Okay button is not displayed", successOkBtn.isDisplayed());
		utils.log().info("Success OK button is displayed");
		click(successOkBtn);
		utils.log().info("Click on Success OK button is displayed");
	}

	public void clickOnHomeButton() {
		Assert.assertTrue("Home button is not displayed", homeButton.isDisplayed());
		utils.log().info("Home button is displayed");
		click(homeButton);
		utils.log().info("Click on Home button is displayed");
	}

	public void jobDetailsPageLoads() {
		isElementDisplayed(jobDetailsHeader);
		Assert.assertTrue("Job Details page is not displayed", jobDetailsHeader.isDisplayed());
		utils.log().info("Job Details page is displayed");
	}

	public void confirmationPresent() {
		Assert.assertTrue("Confirmation number is not displayed", confirmationNumber.isDisplayed());
		utils.log().info("Confirmation number is displayed");
	}

	public void selectOrg() {
		fluentWait(veritimeorg);
		Assert.assertTrue("Available Organizations are not displayed", veritimeorg.isDisplayed());
		utils.log().info("Available Organizations are  displayed");
		click(veritimeorg);
		click(contbtn);

		fluentWait(SubtituteUser);
		Assert.assertTrue("Available roles are not displayed", SubtituteUser.isDisplayed());
		utils.log().info("Available roles are  displayed");
		click(SubtituteUser);
		click(contbtn);

	}

	public String checkAvailablejob() {
		fluentWait(availableJobs);
		common.isElementDisplayed(availableJobs);
		Assert.assertTrue("Available Jobs option is not displayed Home page", availableJobs.isDisplayed());
		utils.log().info("Available Jobs option is displayed on Home page");

		fluentWait(noavailablejobs);
		//////////// Extract the available jobs
		String jobs = getElementText(noavailablejobs);
		// Assert.assertEquals(jobs, "16");
		return jobs;
		// System.out.println(jobs);

	}

	public void switchToAnotherOrg() {
		click(switchbtn);
		fluentWait(chesterorg);
		Assert.assertTrue("Available Organizations are not displayed", chesterorg.isDisplayed());
		utils.log().info("Available Organizations are  displayed");
		click(chesterorg);
		click(contbtn);

		fluentWait(SubtituteUser);
		Assert.assertTrue("Available roles are not displayed", SubtituteUser.isDisplayed());
		utils.log().info("Available roles are  displayed");
		click(SubtituteUser);
		click(contbtn);
	}

	public ArrayList<MobileElement> findElements() {
	List<MobileElement> districts = driver.findElementsByXPath("//android.widget.TextView[@index=3]");
		return (ArrayList<MobileElement>) districts;
	}

	public void multiDistrictVerification() {
		fluentWait(AllDistrict);
		ArrayList<MobileElement> district = findElements();
		ArrayList<String> districtNames = new ArrayList<String>();
		int count = 0;
		for (MobileElement districtName : district) {
			String dname = getElementText(districtName);
			districtNames.add(dname);
		}
		HashSet<String> districts = new HashSet(districtNames);
		Assert.assertTrue("It is not an multi district account", districts.size() > 1);

	}

}
