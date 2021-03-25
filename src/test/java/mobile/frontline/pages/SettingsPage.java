package mobile.frontline.pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestUtils;

public class SettingsPage extends LoginPage {

	TestUtils utils = new TestUtils();
	SmokeMethods smoke = new SmokeMethods();
	LoginPage loginPage = new LoginPage();
	JobsMethods jobs = new JobsMethods();
	TimesheetMethods timesheet = new TimesheetMethods();

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
	@iOSXCUITFindBy(accessibility = "Calendar")
	public MobileElement calendar;

	@iOSXCUITFindBy(accessibility = "Jobs_Module_Title_StaticText")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Jobs']")
	public MobileElement availableJobs;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Available']")
	@iOSXCUITFindBy(accessibility = "Available")
	public MobileElement available;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Scheduled']")
	@iOSXCUITFindBy(accessibility = "Scheduled")
	public MobileElement accepted;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage)[2]")
	@AndroidFindBy(className = "android.widget.ImageView")
	public MobileElement frontlineLogo;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Diagnostics']")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Diagnostics']")
	public MobileElement diagnosticsHeader;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Send Diagnostics']")
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/send_diagnostics_button")
	public MobileElement sendDiagnosticsBtn;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Menu']")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Menu']")
	public MobileElement MenuHeader;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_job_detail_date")
	@iOSXCUITFindBy(accessibility = "JobDetailDayView_JobDate_Label")
	public MobileElement jobDetailDate;

	// @AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_job_detail_date")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Next Scheduled Job_ModuleHeader']")
	public MobileElement nextScheduledJobWidget;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_org_role_name")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
	public MobileElement orgSelection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Denied']")
	@iOSXCUITFindBy(accessibility = "Denied")
	public MobileElement deniedLeaveBalanceHeader;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/in_time")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement InTimeEdit;

	@AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement empName;

	@AndroidFindBy(xpath = "((//android.widget.LinearLayout)[5]//android.widget.TextView)[1]")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement absenceTextOut;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@index='1'])[4]")
	@iOSXCUITFindBy(accessibility = "Denied")
	public MobileElement todayAbsence;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/fl_spinner_selection")
	@iOSXCUITFindBy(accessibility = "EventType_1")
	public MobileElement workDetails;

	public String job_day;
	public String job_month;
	public String expectedInTime;
	public String actualInTime;
	public String employeeName;
	MobileElement absenceName;
	public WebElement scrolledToElement;

	public void openMenuCalendar() {
		//common.isElementDisplayed(smoke.menuTab);
		click(smoke.menuTab, "Click on Menu Link");
		isElementDisplayed(calendar);
		Assert.assertTrue("Calendar Page is not displayed", calendar.isDisplayed());
		//common.isElementDisplayed(calendar);
//		click(calendar, "Click on Calendar in menu Link");
	}

//	public void verifyCalendar() {
//		isElementDisplayed(calendar);
//		Assert.assertTrue("Calendar Page is not displayed", calendar.isDisplayed());
//		utils.log().info("Calendar Page is displayed");
//	}

	public void avaialbleJobsLink() throws Throwable {
		scrollToElement(availableJobs, "up");
		click(availableJobs);
	}

	public void jobListTab() {
		common.isElementDisplayed(available);
		Assert.assertTrue("Available tab is not displayed", available.isDisplayed());
		utils.log().info("Available tab is displayed");
		click(accepted);
		common.isElementDisplayed(accepted);
		Assert.assertTrue("Accepted tab is not displayed", accepted.isDisplayed());
		utils.log().info("Accepted tab is displayed");
	}

	public void longPress() throws Exception {
		TouchAction action = new TouchAction(driver);
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			int startX = frontlineLogo.getLocation().getX();
			int startY = frontlineLogo.getLocation().getY();
			action.press(PointOption.point(startX, startY)).perform();
			break;
		case "iOS":
			int dragX = frontlineLogo.getLocation().x + (frontlineLogo.getSize().width / 2);
			int dragY = frontlineLogo.getLocation().y + (frontlineLogo.getSize().height / 2);
			action.press(PointOption.point(dragX, dragY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
					.release().perform();
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void LongPressOnFrontline_setting() throws Throwable {
		isElementdisplayed(MenuHeader);
		longPress();
		isElementdisplayed(diagnosticsHeader);
		Assert.assertTrue("Diagnostic Header is not displayed", diagnosticsHeader.isDisplayed());
		utils.log().info("Diagnostic Header is displayed");
	}

	public void clickOnSendDiagnosticBtn() throws Throwable {
		click(sendDiagnosticsBtn);
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			Thread.sleep(2000);
			WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
			String actualDiagnosticMsg = toastView.getAttribute("name");
			Assert.assertEquals("Diagnostic is not sent", "Diagnostics sent!",actualDiagnosticMsg);
			utils.log().info("Diagnostic is sent :"+ actualDiagnosticMsg);
			break;
		case "iOS":
			click(smoke.okay);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void viewDetails() {
		String date = common.getElementText(jobDetailDate);
		String[] dateDetails = date.split(", ", 2);
		dateDetails = dateDetails[1].split(" ", 2);
		job_day = dateDetails[1];
		job_month = dateDetails[0];
	}

	public void viewInCalendar(String absenceDay) throws Exception {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
				smoke.verifyEventInCalendar(nextWorkingDay(absenceDay, "MMMM dd, yyyy"), nextWorkingDay(absenceDay, "MMMM dd, yyyy").split(" ")[0]);
				smoke.clickOnEvent_job();
				isElementdisplayed(jobDetailDate);
				Assert.assertTrue("Confirmation number is not displayed", getElementText(jobDetailDate).contains(nextWorkingDay(absenceDay, "MMMM dd, yyyy")));
				break;
			case "iOS":
				smoke.verifyEventInCalendar(nextWorkingDay(absenceDay, "MM/dd/yyyy"), nextWorkingDay(absenceDay, "MMMM dd, yyyy").split(" ")[0]);
				smoke.clickOnEvent_job();
				isElementdisplayed(jobDetailDate);
				Assert.assertTrue("Confirmation number is not displayed", getElementText(jobDetailDate).contains(nextWorkingDay(absenceDay, "MMMM dd, yyyy")));
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
		utils.log().info("Next Scheduled Job is displayed");
	}

	public void verifyNextScheduledJobWidget() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			scrolledToElement = androidScrollToElementUsingUiScrollable("text", "Next Scheduled Job","Scrolling to the next Scheduled Job widget ");
			break;
		case "iOS":
			scrollToElement(nextScheduledJobWidget, "up");
			Assert.assertTrue("Next Scheduled Job is not displayed", nextScheduledJobWidget.isDisplayed());
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		utils.log().info("Next Scheduled Job is displayed");
	}

	public void verifyUnlockCodePage() throws Throwable {
		Assert.assertTrue("Unlock code page is not displayed", IsElementNotPresent(loginPage.enterUnlockCode));
		utils.log().info("Unlock code page is not displayed");
	}

	public void selectOrg() {
		click(orgSelection);
		click(jobs.contbtn);
	}

	public void clickAndVerifyDeniedPanel() throws Throwable {
		click(deniedLeaveBalanceHeader);
		String panel = deniedLeaveBalanceHeader.getAttribute("name").toString();
		Assert.assertEquals(panel, "Denied");
	}

	public void addTimesheetAndChangeIntime() throws Throwable {
		click(smoke.addTimeSheets);
		isElementdisplayed(workDetails);
		click(InTimeEdit);
		int inTime = Integer.parseInt(common.getElementText(timesheet.outTime));
		int changeHourClock = inTime;
		if (inTime == 12)
			inTime = 1;
		else
			inTime++;
		driver.findElementByXPath(
				"//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='" + inTime + "']")
				.click();

		if (changeHourClock == 11) {
			if (Boolean.parseBoolean(timesheet.am_label.getAttribute("checked").toString()))
				click(timesheet.pm_label);
			else
				click(timesheet.am_label);
		}
		click(smoke.okBtn);
		expectedInTime = getElementText(InTimeEdit);
	}

	public void verifyInTime() throws Throwable {
		isElementdisplayed(InTimeEdit);
		actualInTime = getElementText(InTimeEdit);
		Assert.assertEquals(expectedInTime + "is not same as" + actualInTime, expectedInTime, actualInTime);
		utils.log().info("InTime is not back to default");
	}

//	public void scrollTo(String text) {
//		((AndroidDriver) driver).findElementByAndroidUIAutomator(
//				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
//						+ text + "\").instance(0))");
//	}

	public void getEmployeeName() {
		isElementdisplayed(empName);
		employeeName = getElementText(empName);
		click(smoke.homeTab);
	}

	public void verifyAbsenceOnDashboard() throws Throwable {
		androidScrollToElementUsingUiScrollable("text", "Absences Today", "Scrolling to the absence widget");
		Assert.assertNotEquals(getElementText(absenceTextOut) + "is not same as No upcoming Absences",
				getElementText(absenceTextOut), "No upcoming Absences");
		utils.log().info("Absences are not visible");
		click(smoke.absenceWidget);
	}

	public void verifyAbsenceIsVisible(String confNumber) throws Throwable {
		androidScrollToElementUsingUiScrollable("text", employeeName,"scrolling to employee absence");
		absenceName = driver.findElementByXPath("//android.widget.TextView[contains(@text,'" + employeeName + "')]");
		Assert.assertNotEquals(employeeName + "is not same as No Absences", employeeName, "No Absences");
		utils.log().info("Absences are not visible");
		click(absenceName);
		isElementdisplayed(smoke.confirmationNumber);
		Assert.assertTrue("Confirmation number is not displayed", smoke.confirmationNumber.isDisplayed());
	}

	public void selectTodaysAbsence() {
		click(todayAbsence);
	}
}
