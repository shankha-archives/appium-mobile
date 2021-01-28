package mobile.frontline.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestUtils;
import org.openqa.selenium.Point;

import java.time.Duration;

public class SettingsPage extends LoginPage {

	TestUtils utils = new TestUtils();
	SmokeMethods smoke = new SmokeMethods();
	LoginPage loginPage = new LoginPage();
	JobsMethods jobs = new JobsMethods();
	TimesheetMethods timesheet = new TimesheetMethods();

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
	@iOSXCUITFindBy(accessibility = "Calendar")
	public MobileElement calendar;

	@iOSXCUITFindBy(accessibility = "Available Jobs_ModuleHeader")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Jobs']")
	public MobileElement availableJobs;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Available']")
	@iOSXCUITFindBy(accessibility = "Available")
	public MobileElement available;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Accepted']")
	@iOSXCUITFindBy(accessibility = "Accepted")
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
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Next Scheduled Job']")
//	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_job_detail_date")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement jobDetailDate;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Next Scheduled Job_ModuleHeader']")
	public MobileElement nextScheduledJobWidget;
  
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_org_role_name")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
	public MobileElement orgSelection;
	
	//@AndroidFindBy(xpath = "")
	@iOSXCUITFindBy(accessibility = "Denied")
	public MobileElement deniedLeaveBalanceHeader;
	
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/in_time")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement InTimeEdit;
	
	@AndroidFindBy(xpath = "((//android.widget.LinearLayout)[5]//android.widget.TextView)[1]")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement absenceTextOut;
	
	@AndroidFindBy(xpath = "((//android.widget.RelativeLayout)[7]//android.widget.TextView)[1]")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement absenceTextIn;
	
	public String job_day;
	public String job_month;
	public String expectedInTime;
	public String actualInTime;
	public String textAbsencesOut;
	public String textAbsencesIn;
	
	public void openMenuCalendar() {
		common.isElementDisplayed(smoke.menuTab);
		click(smoke.menuTab);
		common.isElementDisplayed(calendar);
		click(calendar);
	}

	public void verifyCalendar() {
		common.isElementDisplayed(calendar);
		Assert.assertTrue("Calendar Page is not displayed", calendar.isDisplayed());
		utils.log().info("Calendar Page is displayed");
	}

	public void avaialbleJobsLink() throws Throwable {
		common.scrollToElement(availableJobs, "up");
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
		common.isElementdisplayed(MenuHeader);
		longPress();
		common.isElementdisplayed(diagnosticsHeader);
		Assert.assertTrue("Diagnostic Header is not displayed", diagnosticsHeader.isDisplayed());
		utils.log().info("Diagnostic Header is displayed");
	}

	public void clickOnSendDiagnosticBtn() throws Throwable {
		click(sendDiagnosticsBtn);
  switch (new GlobalParams().getPlatformName()) {
		case "Android":
			utils.log().info("Diagnostic is sent");
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
        String[] dateDetails = date.split(", ",2); 
        dateDetails = dateDetails[1].split(" ",2);
        job_day = dateDetails[1];
        job_month = dateDetails[0];
	}
	
	public void viewInCalendar() throws Exception {
		smoke.verifyEventInCalendar(job_day,job_month);		
	}
	
	public void verifyNextScheduledJobWidget() throws Throwable{
		common.scrollToElement(nextScheduledJobWidget, "up");
		Assert.assertTrue("Next Scheduled Job is not displayed", nextScheduledJobWidget.isDisplayed());
		utils.log().info("Next Scheduled Job is displayed");
	}
	
	public void verifyUnlockCodePage() throws Throwable{
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
		Assert.assertEquals(expectedInTime+ "is not same as" +actualInTime, expectedInTime, actualInTime);
		utils.log().info("InTime is not back to default");	
	}
	
	public void clickOnAbsencesTodayWidget() throws Exception {
		scrollToElement(smoke.absenceWidget, "up");
		textAbsencesOut = getElementText(absenceTextOut);
		Assert.assertNotEquals(textAbsencesOut+ "is not same as No upcoming Absences", textAbsencesOut, "No upcoming Absences");
		utils.log().info("Absences are not visible");
		click(smoke.absenceWidget);
	}
	
	public void verifyAbsenceAreVisible() throws Exception {
		textAbsencesIn = getElementText(absenceTextIn);
		Assert.assertNotEquals(textAbsencesIn+ "is not same as No Absences", textAbsencesIn, "No Absences");
		utils.log().info("Absences are not visible");
	}
}
