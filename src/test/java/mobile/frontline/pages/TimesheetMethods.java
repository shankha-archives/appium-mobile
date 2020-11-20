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
	//@iOSXCUITFindBy(xpath = "")
	public MobileElement timesheetDaySubmitBtn;
	
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
}
