package mobile.frontline.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestUtils;

public class JobsMethods extends LoginPage {
	TestUtils utils = new TestUtils();
	BasePage common = new BasePage();

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Jobs']")
	@iOSXCUITFindBy(accessibility = "Available Jobs_ModuleHeader")
	public MobileElement availableJobs;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Jobs']")
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

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='You have accepted this job']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Job Detail']")
	public MobileElement jobDetailsConfirmation;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Conf')]")
	@iOSXCUITFindBy(xpath = "//*[contains(@name, 'Conf')]")
	public MobileElement confirmationNo;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='VeriTime Automation Org 20 - DO NOT USE']")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement veritimeorg;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Substitute']")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement SubtituteUser;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Alphabet School District']")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement chesterorg;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/widget_header_right_bubble")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement noavailablejobs;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
	@iOSXCUITFindBy(accessibility = "Continue")
	public MobileElement contbtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Switch']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[1]")
	public MobileElement switchbtn;

//	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'AutomationEmp CreateJob3')]")
//	public MobileElement jobEmployeeName;

//	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text, 'AutomationEmp CreateJob3')]/following:: android.widget.TextView)[1]")
//	public MobileElement jobDate;

	@AndroidFindBy(xpath = "(//android.widget.TextView)[4]")
	public MobileElement jobEmployeeNameOnJobDescription;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_job_detail_date")
	public MobileElement jobDateOnJobDescription;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='There are no available jobs right now']")
	public MobileElement jobPageWithNoJob;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
	public MobileElement homeButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@index=3]")
	public MobileElement AllDistrict;

	public String job_date;
	public String job_jobEmployeeName;
	public WebElement scrolledToElement;

	public JobsMethods() {
	}

	public void clickOnAvailableJobs_displayed() throws Throwable {
		click(availableJobs, "Clicking available job Widget");
		isElementDisplayed(availableJobsHeader);
		Assert.assertTrue("Available Jobs list page is not displayed", availableJobsHeader.isDisplayed());
		utils.log().info("Available Jobs list Page is displayed");
		swipeDown();
	}

	private void storeJobDetails() {
		job_date = getElementText(jobDateOnJobDescription).split(", ")[1];
		// Assert.assertEquals(job_date, "");
		job_jobEmployeeName = getElementText(jobEmployeeNameOnJobDescription);
	}

	public void verifyAcceptedJob() {
		By jobDate = By.xpath(
				"(//android.widget.TextView[@text='AutomationEmp CreateJob3']/following:: android.widget.TextView[@text='"
						+ job_date + "'])[1]");
		Assert.assertTrue("Accepted job still present in the jobs list", IsElementNotPresent(jobDate));

	}

	public void clickOnAvailableJobs(String jobByEmp) throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			scrolledToElement = androidScrollToElementUsingUiScrollable("text", jobByEmp);
			scrolledToElement.click();
			storeJobDetails();
			break;
		case "iOS":
			scrollToElement(jobslist, "up");
			click(jobslist, "Clicking available job Widget");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
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
		Assert.assertEquals("Success message is not displayed", getElementText(successMsg),
				"You have Successfully accepted this Job");
		utils.log().info("Success message is displayed");
	}

	public void clickOnOkBtn_successMsg() {
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
		isElementDisplayed(jobDetailsConfirmation);
		Assert.assertTrue("Job Details page is not displayed", jobDetailsConfirmation.isDisplayed());
		utils.log().info("Job Details page is displayed");
	}

	public void confirmationPresent(String confirmationNumber) {
		Assert.assertTrue("Confirmation number is not displayed",
				getElementText(confirmationNo).contains(confirmationNumber));
		utils.log().info("Confirmation number is displayed");
	}

	public void selectOrg() {
		isElementdisplayed(veritimeorg);
		Assert.assertTrue("Available Organizations are not displayed", veritimeorg.isDisplayed());
		utils.log().info("Available Organizations are  displayed");
		click(veritimeorg);
		click(contbtn);

		isElementdisplayed(SubtituteUser);
		Assert.assertTrue("Available roles are not displayed", SubtituteUser.isDisplayed());
		utils.log().info("Available roles are  displayed");
		click(SubtituteUser);
		click(contbtn);
	}

	public String checkAvailablejob() {
		isElementdisplayed(availableJobs);
		common.isElementDisplayed(availableJobs);
		Assert.assertTrue("Available Jobs option is not displayed Home page", availableJobs.isDisplayed());
		utils.log().info("Available Jobs option is displayed on Home page");

		isElementdisplayed(noavailablejobs);
		//////////// Extract the available jobs
		String jobs = getElementText(noavailablejobs);
		return jobs;
	}

	public void clickSwitchbtn() {
		click(switchbtn);
	}

	public void switchToAnotherOrg() {
		isElementdisplayed(chesterorg);
		Assert.assertTrue("Available Organizations are not displayed", chesterorg.isDisplayed());
		utils.log().info("Available Organizations are  displayed");
		click(chesterorg);
		click(contbtn);

		isElementdisplayed(SubtituteUser);
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
		isElementdisplayed(AllDistrict);
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
