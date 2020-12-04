package mobile.frontline.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.junit.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestUtils;

public class TimesheetMethods extends BasePage {

	TestUtils utils = new TestUtils();
	BasePage common = new BasePage();
	LoginPage loginPage = new LoginPage();
	JobsMethods jobPage = new JobsMethods();
	SmokeMethods smoke = new SmokeMethods();

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/day_view_submit_time_sheet_button")
	// @iOSXCUITFindBy(xpath = "")
	public MobileElement timesheetDaySubmitBtn;

	@AndroidFindBy(id = "android:id/message")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name='Error']")
	public MobileElement timesheetErrorMessage;
  
	@AndroidFindBy(id = "android:id/hours")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[1]")
	public MobileElement outTime;

	@AndroidFindBy(id = "android:id/am_label")
	// @iOSXCUITFindBy(xpath = "")
	public MobileElement am_label;

	@AndroidFindBy(id = "android:id/pm_label")
	// @iOSXCUITFindBy(xpath = "")
	public MobileElement pm_label;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[contains(@content-desc,'Total Time This Week')]/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[3]")
	public MobileElement totalWeekTime;

	MobileElement currentTimesheet;
	String OutTime;
	String Intime;
	String weekTotal;
	Date d;

	public void submitDayTimesheet() throws Exception {
		isElementdisplayed(timesheetDaySubmitBtn);
		timesheetDaySubmitBtn.click();
		isElementdisplayed(smoke.submitTimesheet);
		smoke.submitTimesheet.click();
	}

	public void verifySubmission() {
		isElementdisplayed(smoke.undoicon);
		Assert.assertTrue("Day Timesheet is submitted", smoke.undoicon.isDisplayed());
		utils.log().info("Day Timesheet is not submitted");
	}

	public void timesheetNonEditablePopup() {
		isElementDisplayed(timesheetErrorMessage);
		Assert.assertTrue("The timesheet requested is not in an editable state", timesheetErrorMessage.isDisplayed());
		utils.log().info("The timesheet requested is in editable state");
	}

	public void verifySubmitTimesheetBtnNotDisplayed() {
		if (isElementdisplayed(smoke.submittimesheetsbtn))
			Assert.assertTrue("Submit timesheet option is not displayed", !smoke.submittimesheetsbtn.isDisplayed());
	}

	public String addNewTimesheet() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			common.isElementdisplayed(smoke.selectDayToFillTimesheet);
			click(smoke.selectDayToFillTimesheet);
			click(smoke.addTimeSheets);
			common.isElementdisplayed(smoke.workDetails);
			Intime = common.getElementText(smoke.timeSheetInTime);
			click(smoke.saveTimesheets);
			break;
		case "iOS":
			common.isElementdisplayed(smoke.selectDayToFillTimesheet);
			click(smoke.selectDayToFillTimesheet);
			click(smoke.addTimeSheets);
			common.isElementdisplayed(smoke.workDetails);
			smoke.clickonEditButton2();
			smoke.clickOnEditBtton3();
			String Intime = common.currentTime();
			click(smoke.saveTimesheets);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		return Intime;
	}

	public void verifyTimesheet(String Intime) throws Throwable {
		common.isElementdisplayed(smoke.commonDayTotal);
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			currentTimesheet = driver.findElementByXPath("//android.widget.TextView[contains(@text,'" + Intime + "')]");
			break;
		case "iOS":
			currentTimesheet = driver.findElementByXPath("//XCUIElementTypeCell[contains(@label, '" + Intime + "')]");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		Assert.assertTrue("current Timesheet is not displayed", currentTimesheet.isDisplayed());
		currentTimesheet.click();
	}

	public void verifyDeletedTimesheet() throws Exception {
		if (isElementdisplayed(smoke.declinebtn)) {
			click(smoke.declinebtn);
		}

		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			if (isElementdisplayed(currentTimesheet)) {
				utils.log().info("Time sheet is not deleted");
			} else
				utils.log().info("Time sheet is deleted");
			break;
		case "iOS":
			isElementdisplayed(smoke.commonDayTotal);
			Assert.assertTrue("Time sheet is not deleted", !currentTimesheet.isDisplayed());
			utils.log().info("Time sheet is deleted");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void AddTimesheet() throws Throwable {
		click(smoke.addTimeSheets);
		common.isElementdisplayed(smoke.workDetails);
		click(smoke.timeSheetOutTime);
		
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
		OutTime = common.getElementText(outTime);
		int out = Integer.parseInt(OutTime);
		int changeHourClock = out;
		if (out == 12)
			out = 1;
		else
			out = out + 1;
		driver.findElementByXPath(
				"//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='" + out + "']").click();

		if (changeHourClock == 11) {
			if (Boolean.parseBoolean(am_label.getAttribute("checked").toString()))
				click(pm_label);
			else
				click(am_label);
		}
		click(smoke.okBtn);
		click(smoke.saveTimesheets);
		if (isElementdisplayed(smoke.okBtn)) {
			click(smoke.okBtn);
			click(smoke.backBtn);
		}
		break;
	case "iOS":
		outTime.click();
		dragClock();
		smoke.saveOrderWidgetbtn.click();
		click(smoke.saveTimesheets);
		break;
	default:
		throw new Exception("Invalid platform Name");
		}
	}

	public void verifyWeekTime() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("h:mm");
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
		click(smoke.homeTab);
		common.scrollToElement(totalWeekTime, "up");
		weekTotal = common.getElementText(totalWeekTime);
		d = dateFormat.parse(weekTotal);
		Assert.assertNotEquals(d, dateFormat.parse("0:00"));
		utils.log().info("Total time of the week is displayed");
		    break;
		case "iOS":
			isElementdisplayed(totalWeekTime);
			weekTotal = totalWeekTime.getAttribute("name").toString();
			d = dateFormat.parse(weekTotal);
			Assert.assertNotEquals(d, dateFormat.parse("0:00"));
			utils.log().info("Total time of the week is displayed");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}
	
	public void dragClock() throws Throwable {
		TouchAction action = new TouchAction(driver);
		int dragX = outTime.getLocation().x + (outTime.getSize().width / 2);
		int dragY = outTime.getLocation().y + (outTime.getSize().height / 2);
		action.press(PointOption.point(dragX, dragY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(dragX, dragY - 50)).release().perform();
	}
}
