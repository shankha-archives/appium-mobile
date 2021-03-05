package mobile.frontline.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	@iOSXCUITFindBy(accessibility = "Jobs_ModuleHeader")
	public MobileElement availableJobs;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Jobs']")
	@iOSXCUITFindBy(accessibility = "view_header")
	public MobileElement availableJobsHeader;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/job_cell_information_inner_cointainer")
	@iOSXCUITFindBy(accessibility = "jobListingCell_right_angle_arrow")
	public MobileElement jobslist;

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

	@AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement associatedOrgForSub1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Substitute']")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement SubtituteUser;

	@AndroidFindBy(xpath = "(//android.widget.TextView)[3]")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement associatedOrgForSub2;

//	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/widget_header_right_bubble")
//	// @iOSXCUITFindBy(accessibility = "")
//	public MobileElement noavailablejobs;

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

//	@AndroidFindBy(xpath = "(//android.widget.TextView)[4]")
//	public MobileElement jobEmployeeNameOnJobDescription;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_job_detail_date")
	public MobileElement jobDateOnJobDescription;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='There are no available jobs right now']")
	@iOSXCUITFindBy(accessibility = "There are no available jobs right now")
	public MobileElement jobPageWithNoJob;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
	@iOSXCUITFindBy(accessibility = "Home_TabBar_Button")
	public MobileElement homeButton;

//	@AndroidFindBy(xpath = "//android.widget.TextView[@index=3]")
//	public MobileElement AllDistrict;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='AutomationEmp 3681']/following:: android.widget.TextView[@text='GL_Performance_4CF65528C-ACCA-4ED7-9E19-D8C553C344'])[1]")
	public MobileElement jobSchoolValidationOrg1;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='AutomationEmpOrg5 3681']/following:: android.widget.TextView[@text='GL_Performance_50468ED78-1019-4F46-97AB-801A3C4AC5'])[1]")
	public MobileElement jobSchoolValidationOrg2;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='AutomationEmp 3683']/following:: android.widget.TextView[@text='ChildCareCenter'])[1]")
	public MobileElement jobSchoolMultidistrict1;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='AutomationEmp2 3683']/following:: android.widget.TextView[@text='GL_Performance_4CF65528C-ACCA-4ED7-9E19-D8C553C344'])[1]")
	public MobileElement jobSchoolMultidistrict2;
	
	public String job_date;
	// public String job_jobEmployeeName;
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
		// job_jobEmployeeName = getElementText(jobEmployeeNameOnJobDescription);
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

			By findJob = By.xpath("//XCUIElementTypeStaticText[contains(@label,'" + jobByEmp + "')]");
			scrollToElement(findJob, "up");
			click(findJob, "Clicked on on Required Job");

			// scrollToElement(jobslist, "up");

			// click(jobslist, "Clicking available job Widget");
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

	public void successMsgPOPUP() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
		isElementDisplayed(successMsg);
		Assert.assertEquals("Success message is not displayed", getElementText(successMsg),
				"You have Successfully accepted this Job");
		utils.log().info("Success message is displayed");
		break;
			case "iOS":
				isElementDisplayed(successMsg);
				Assert.assertEquals("Success message is not displayed", getElementText(successMsg),
						"You have successfully accepted this job.");
				utils.log().info("Success message is displayed");
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
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
		isElementdisplayed(associatedOrgForSub1);
		Assert.assertTrue("Available Organizations are not displayed", associatedOrgForSub1.isDisplayed());
		utils.log().info("Available Organizations are  displayed");
		click(associatedOrgForSub1);
		click(contbtn);

//		isElementdisplayed(SubtituteUser);
//		Assert.assertTrue("Available roles are not displayed", SubtituteUser.isDisplayed());
//		utils.log().info("Available roles are  displayed");
//		click(SubtituteUser);
//		click(contbtn);
	}

	public String changeDateFormat(String dateToBeFormated, String formatOriginal, String formatTarget) throws Exception {
	DateFormat originalFormat = new SimpleDateFormat(formatOriginal);
	DateFormat targetFormat = new SimpleDateFormat(formatTarget);
	Date date = originalFormat.parse(dateToBeFormated);
	return targetFormat.format(date);
	}
	
	public void checkAvailablejob() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			isElementdisplayed(jobslist);

			By jobDate = By.xpath(
					"(//android.widget.TextView[@text='AutomationEmp 3681']/following:: android.widget.TextView[@text='"
							+ changeDateFormat( nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
			utils.log().info("jobDate");
			
			scrollToElement(jobDate, "up");
			Assert.assertTrue("Created Job is visible in the Substitutes list", IsElementPresent(jobDate)||IsElementPresent(jobSchoolValidationOrg1));
			
			 jobDate = By.xpath(
					"(//android.widget.TextView[@text='AutomationEmpOrg5 3681']/following:: android.widget.TextView[@text='"
							+ changeDateFormat( nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
			 scrollToElement(jobDate, "up");
			 Assert.assertTrue("Created Job is visible in the Substitutes list", IsElementPresent(jobDate)||IsElementPresent(jobSchoolValidationOrg2));
			break;
		case "iOS":

//			By findJob = By.xpath("//XCUIElementTypeStaticText[contains(@label,'AutomationEmp 4173')]");
//			scrollToElement(findJob, "up");
//			click(findJob, "Clicked on on Required Job");
			break;
		default:
			//throw new Exception("Invalid platform Name");
		}
	
	}

	public void clickSwitchbtn() {
		click(switchbtn);
	}

	public void switchToAnotherOrg() {
		isElementdisplayed(associatedOrgForSub2);
		Assert.assertTrue("Available Organizations are not displayed", associatedOrgForSub2.isDisplayed());
		utils.log().info("Available Organizations are  displayed");
		click(associatedOrgForSub2);
		click(contbtn);

//		isElementdisplayed(SubtituteUser);
//		Assert.assertTrue("Available roles are not displayed", SubtituteUser.isDisplayed());
//		utils.log().info("Available roles are  displayed");
//		click(SubtituteUser);
//		click(contbtn);
	}

	public ArrayList<MobileElement> findElements() {
		List<MobileElement> districts = driver.findElementsByXPath("//android.widget.TextView[@index=3]");
		return (ArrayList<MobileElement>) districts;
	}

	public void multiDistrictVerification() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
	case "Android":
		isElementdisplayed(jobslist);
		By jobDate = By.xpath(
				"(//android.widget.TextView[@text='AutomationEmp 3683']/following:: android.widget.TextView[@text='"
						+ changeDateFormat( nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
		scrollToElement(jobDate, "up");
		Assert.assertTrue("Created Job is not visible in the list", IsElementPresent(jobDate)||IsElementPresent(jobSchoolMultidistrict1));
		
		jobDate = By.xpath(
				"(//android.widget.TextView[@text='AutomationEmp2 3683']/following:: android.widget.TextView[@text='"
						+ changeDateFormat( nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
		scrollToElement(jobDate, "up");
		Assert.assertTrue("Created Job is not visible in the list", IsElementPresent(jobDate)||IsElementPresent(jobSchoolMultidistrict2));
		break;
	case "iOS":

//		By findJob = By.xpath("//XCUIElementTypeStaticText[contains(@label,'AutomationEmp 4173')]");
//		scrollToElement(findJob, "up");
//		click(findJob, "Clicked on on Required Job");
		break;
	default:
		throw new Exception("Invalid platform Name");
	}
	}

	public void verifyCreatedJobsAreVisibleintheList() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			isElementdisplayed(jobslist);
			By jobDate = By.xpath(
					"(//android.widget.TextView[@text='AutomationEmp 4173']/following:: android.widget.TextView[@text='"
							+ changeDateFormat( nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
			scrollToElement(jobDate, "up");
			Assert.assertTrue("Created Job is not visible in the list", IsElementPresent(jobDate));
			
			jobDate = By.xpath(
					"(//android.widget.TextView[@text='AutomationEmp 4172']/following:: android.widget.TextView[@text='"
							+ changeDateFormat( nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
			scrollToElement(jobDate, "up");
			Assert.assertTrue("Created Job is not visible in the list", IsElementPresent(jobDate));
			break;
		case "iOS":

//			By findJob = By.xpath("//XCUIElementTypeStaticText[contains(@label,'AutomationEmp 4173')]");
//			scrollToElement(findJob, "up");
//			click(findJob, "Clicked on on Required Job");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}
}
