package mobile.frontline.pages;

import org.junit.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.TestUtils;

public class TimesheetMethods extends LoginPage {

	TestUtils utils = new TestUtils();
	BasePage common = new BasePage();
	LoginPage loginPage = new LoginPage();
	JobsMethods jobPage = new JobsMethods();
	SmokeMethods smoke = new SmokeMethods();

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/day_view_submit_time_sheet_button")
	// @iOSXCUITFindBy(xpath = "")
	public MobileElement timesheetDaySubmitBtn;

	@AndroidFindBy(id = "android:id/message")
	// @iOSXCUITFindBy(xpath = "")
	public MobileElement timesheetErrorMessage;
	
	MobileElement currentTimesheet;

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
		if(isElementdisplayed(smoke.submittimesheetsbtn))
		Assert.assertTrue("Submit timesheet option is not displayed",!smoke.submittimesheetsbtn.isDisplayed());
	}
	
	public String addNewTimesheet() {
		common.isElementdisplayed(smoke.selectDayToFillTimesheet);
		click(smoke.selectDayToFillTimesheet);
		click(smoke.addTimeSheets);
		common.isElementdisplayed(smoke.workDetails);
		smoke.clickonEditButton2();
		smoke.clickOnEditBtton3();
		String Intime = common.currentTime();
		click(smoke.saveTimesheets);
		return Intime;
	}
	
	public void verifyTimesheet(String Intime) throws Throwable {
		common.isElementdisplayed(smoke.commonDayTotal);
	    currentTimesheet = driver.findElementByXPath("//XCUIElementTypeCell[contains(@label, '" + Intime + "')]");
	    Assert.assertTrue("current Timesheet is not displayed", currentTimesheet.isDisplayed());
	    currentTimesheet.click();
	}
	
	public void verifyDeletedTimesheet() {
		if (isElementdisplayed(smoke.declinebtn)) {
			click(smoke.declinebtn);
		}
		isElementdisplayed(smoke.commonDayTotal);
		Assert.assertTrue("Time sheet is not deleted", !currentTimesheet.isDisplayed());
		utils.log().info("Time sheet is deleted");
	}
}
