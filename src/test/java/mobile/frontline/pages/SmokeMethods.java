package mobile.frontline.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SmokeMethods extends LoginPage {

	TestUtils utils = new TestUtils();
	BasePage common = new BasePage();
	LoginPage loginPage = new LoginPage();
	String cdate;

	// click //homepage
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Absences Today']")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement absenceWidget;

	// click //in absence widget
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/add_absence")
	//	@iOSXCUITFindBy(accessibility = "Create Absence")
	public MobileElement addAbsence;

	// page 1 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Who?']")
	//	@iOSXCUITFindBy(accessibility = "Create Absence")
	public MobileElement absenceRequiredFor;

	// sendkey //com.frontline.frontlinemobile:id/who_search_view
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/search_view_edit_text")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement serachEditText;

	// click
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/create_absence_list_cell_name")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement selectReqName;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/progress_footer_forward_circle")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement forwardCaret;

	// page 3 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Why?']")
	//		@iOSXCUITFindBy(accessibility = "Create Absence")
	public MobileElement absenceReasonVerification;

	// click //page 3 reason
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='*Personal']")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement reason;

	// page 4 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='When?']")
	//			@iOSXCUITFindBy(accessibility = "Create Absence")
	public MobileElement datePageVerification;

	// also check the date which is taken
	// page 5 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='How Long?']")
	//				@iOSXCUITFindBy(accessibility = "Create Absence")
	public MobileElement durationPageVerification;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/shift_type_full_day")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement selectDuration;

	// page 6 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Review']")
	//					@iOSXCUITFindBy(accessibility = "Create Absence")
	public MobileElement reviewPageVerification;

	// click next
	// click
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/progress_footer_submit_button")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement submitAbsence;

	// click
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/view_absence_button")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement viewAbsence;

	// verify conf number is present
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Conf')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH 'Conf '")
	public MobileElement confirmationNumber;

	// click on approvals
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'awaiting approval')]")
	@iOSXCUITFindBy(accessibility = "Available Jobs_ModuleHeader")
	public MobileElement absenceApprovalwidget;

	// verify approvals
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Approvals']")
	@iOSXCUITFindBy(accessibility = "Available Jobs_ModuleHeader")
	public MobileElement verifyAbsencePage;

	// employee name for verification
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/absence_approval_employee_name")
	@iOSXCUITFindBy(accessibility = "Available Jobs_ModuleHeader")
	public MobileElement employeeName;

	// day of absence name for verification
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/absence_to_date_day_text")
	@iOSXCUITFindBy(accessibility = "Available Jobs_ModuleHeader")
	public MobileElement dayName;

	// month of absence name for verification
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/absence_to_date_month_text")
	@iOSXCUITFindBy(accessibility = "Available Jobs_ModuleHeader")
	public MobileElement monthName;

	// click on approve btn
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/absence_approve_button")
	@iOSXCUITFindBy(accessibility = "Available Jobs_ModuleHeader")
	public MobileElement approvebtn;

	// month of absence name for verification
	@AndroidFindBy(id = "android:id/button1")
	@iOSXCUITFindBy(accessibility = "Available Jobs_ModuleHeader")
	public MobileElement okBtn;

	// click on Menu tab
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Menu']")
	@iOSXCUITFindBy(accessibility = "Menu_TabBar_Button")
	public MobileElement menuTab;

	// click on search bar
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Search Frontline Mobile']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search Frontline Mobile']")
	public MobileElement searchBar;

	// click on Settings
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
	@iOSXCUITFindBy(accessibility = "Settings_MenuOption")
	public MobileElement settings;

	// toggle dark mode
	@AndroidFindBy(xpath = "//android.widget.Switch[@text='OFF']")
	@iOSXCUITFindBy(accessibility = "darkMode")
	public MobileElement darkMode;

	// create absence btn //click
	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'Create Absence']")
	@iOSXCUITFindBy(accessibility = "Available Jobs_ModuleHeader")
	public MobileElement createAbsBtn;

	// click on Feedback
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Feedback']")
	@iOSXCUITFindBy(accessibility = "Feedback_MenuOption")
	public MobileElement feedback;

	// click on drop down icon
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/fl_spinner_icon")
	@iOSXCUITFindBy(accessibility = "Feature Request")
	public MobileElement topic;

	// selecting value from drop down
	@AndroidFindBy(xpath = "//android.widget.TextView[@index= 0]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Topic']")
	public List<MobileElement> itemsInDropDown;

	// enter text in Title
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Title']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@value, 'Title')]")
	public MobileElement title;

	// enter text in message
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Message']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[contains(@value, 'Message')]")
	public MobileElement message;

	// click on save
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/save")
	@iOSXCUITFindBy(accessibility = "Submit")
	public MobileElement saveBtn;

	// click on inbox tab
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Inbox']")
	// @iOSXCUITFindBy(xpath = "")
	public MobileElement inboxTab;

	// click on inbox message
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/inbox_notification_snippet_text")
	// @iOSXCUITFindBy(xpath = "")
	public MobileElement inboxMsg;

	// click on inbox tab
	@AndroidFindBy(xpath = "//android.view.View")
	// @iOSXCUITFindBy(xpath = "")
	public MobileElement msgData;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Leave Balances']")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement availableLeaveBalance;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Leave Balances']")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement availableLeaveBalanceHeader;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/leave_balance_duration")
	public MobileElement availableDays;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='UNFILLED']")
	public MobileElement unfilledAbsence;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Tap to Assign']")
	public MobileElement assignSubstitute;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Assign']")
	public MobileElement selectSubstitute;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Assign']")
	public MobileElement confirmAssignSub;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Timesheets']")
	@iOSXCUITFindBy(accessibility = "Timesheets_ModuleHeader")
	public MobileElement timesheetsbtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/submit_time_sheet_button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='TimesheetWeekView_Submit_Button']")
	public MobileElement submittimesheetsbtn;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter PIN']")
	@iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_EnterPin_TextField")
	public MobileElement enterPin;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/timesheet_checkbox")
	@iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_CertifyCheckBox_Other")
	public MobileElement checkbox;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/submit_time_sheets_button")
	@iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_Submit_Button")
	public MobileElement submitTimesheet;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_sheet_week_undo_submission_text")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Undo Submission'])[1]")
	public MobileElement undoSubmission;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/undo_icon")
	@iOSXCUITFindBy(accessibility = "TimesheetWeekView_UndoSubmit_Button")
	public MobileElement undoicon;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/undo_time_sheets_button")
	@iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_UndoSubmit_Button")
	public MobileElement undobtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/review_dialog_decline_button")
	@iOSXCUITFindBy(accessibility = "Not Now")
	public MobileElement declinebtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Calendar_NavSearchResult']")
	public MobileElement searchResult;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/edit_widget_order_button")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement reOrderWidgetbtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/save")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement saveOrderWidgetbtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/drag_handle")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement dragableEle;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'TUE')]")
	//	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH 'Conf '")
	public MobileElement tuesday;
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'MON')]")
	public MobileElement monday;
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'WED')]")
	public MobileElement wednesday;
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'THU')]")
	public MobileElement thursday;
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'FRI')]")
	public MobileElement friday;
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'SAT')]")
	public MobileElement saturday;
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'SUN')]")
	public MobileElement sunday;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Day Total']")
	public MobileElement commonDayTotal;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'AbsReason')]")
	public MobileElement searchAbsReason;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Substitute']")
	public MobileElement absenceDetailPageSubstitute;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Approval Status']")
	public MobileElement absenceDetailPageApproval;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/widget_name")
	//	@iOSXCUITFindBy(xpath = "")
	public List<MobileElement> WidgetOrderList;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='6']")
	@iOSXCUITFindBy(accessibility = "Timesheet_Table")
	public MobileElement selectDayToFillTimesheet;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/menu_item_add_time")
	@iOSXCUITFindBy(accessibility = "Add Time")
	public MobileElement addTimeSheets;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/fl_spinner_selection")
	@iOSXCUITFindBy(accessibility = "JOBtypeEmp")
	public MobileElement workDetails;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_entry_save_button")
	@iOSXCUITFindBy(accessibility = "Add")
	public MobileElement saveTimesheets;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/in_time")
	@iOSXCUITFindBy(accessibility = "Time_Event_Cell_0")
	public MobileElement timeSheetInTime;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/day_view_submit_time_sheet_button")
	@iOSXCUITFindBy(accessibility = "TimesheetsSubmissionView_Submit_Button")
	public MobileElement dailytimeSheetsubmitbtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/edit_menu_item")
	@iOSXCUITFindBy(accessibility = "Edit")
	public MobileElement dailytimeSheetedittbtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/out_time")
	//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement timeSheetOutTime;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/delete_event_button")
	@iOSXCUITFindBy(accessibility = "Delete Event")
	public MobileElement timeSheetDeletebtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Time Event']")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement timeSheetTimeEventPage;

	@AndroidFindBy(className = "android.widget.ImageButton")
	public MobileElement backButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='AbsReason_0']")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement absenceReason;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/shift_type_time_absent")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement absenceshifttime;

	@AndroidFindBy(xpath = "//android.widget.TextView")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement getdate;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_title")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement calendertitle;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_event_cell_line_one")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement eventTitle;

	// page 6 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Substitute']")
//	@iOSXCUITFindBy(accessibility = "Create Absence")
	public MobileElement subAssignPageVerification;

	// click on home tab
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement homeTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Next: Choose Reason']")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement whoAbsencePageWaittoClickCaret;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Edit'])[1]")
	public MobileElement timeInEdit1;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Edit'])[2]")
	public MobileElement timeInEdit2;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Edit'])[3]")
	public MobileElement timeInEdit3;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='TimesheetEventDetailView_Other']/XCUIElementTypeCell[5]")
	public MobileElement commentBox;

	@iOSXCUITFindBy(accessibility = "Done")
	public MobileElement Done;

	@iOSXCUITFindBy(accessibility = "Save")
	public MobileElement saveButton;

	@iOSXCUITFindBy(accessibility = "Okay")
	public MobileElement okay;

	public String absence_Ename;
	public String absence_day;
	public String absence_month;
	public String searchResultText;
	public String Intime;
	ArrayList<String> widgetlistbeforeReorder = new ArrayList<String>();
	ArrayList<String> widgetlistafterReorder = new ArrayList<String>();

	public SmokeMethods() {
	}

	public void selectAbsenceWidget() {

		common.swipeUpSlowly();
		common.isElementDisplayed(absenceWidget);
		Assert.assertTrue("Absence option is not displayed Home page", absenceWidget.isDisplayed());
		utils.log().info("Absence option is displayed on Home page");
		click(absenceWidget);
	}

	public void addAbsence() {
		isElementDisplayed(addAbsence);
		common.isElementDisplayed(addAbsence);
		Assert.assertTrue("Add Absence button is not displayed absence page", addAbsence.isDisplayed());
		utils.log().info("Add Absence option is displayed on absence page");
		click(addAbsence);
	}

	// Create Absence Page 1
	public void verifyWhoPage() {
		isElementDisplayed(absenceRequiredFor);
		common.isElementDisplayed(absenceRequiredFor);
		Assert.assertTrue("Create Absence Page 1 is not displayed", absenceRequiredFor.isDisplayed());
		utils.log().info("Create Absence Page 1 is displayed");
	}

	public void enterTeachersName(String teacher) {
		serachEditText.click();
		driver.getKeyboard().sendKeys(teacher);
	}

	public void selectTeachersName() {
		common.isElementDisplayed(selectReqName);
		selectReqName.click();
		common.isElementDisplayed(whoAbsencePageWaittoClickCaret);
	}

	public void clickNext() {
		common.isElementClickable(forwardCaret);
		forwardCaret.click();
	}

	public void absenceReason() {
		isElementDisplayed(absenceReasonVerification);
		common.isElementDisplayed(absenceReasonVerification);
		Assert.assertTrue("Create Absence Page 3 is not displayed", absenceReasonVerification.isDisplayed());
		utils.log().info("Create Absence Page 3 is displayed");
		if (isElementDisplayed(reason)) {
			click(reason);
		} else {
			click(absenceReason);
		}

	}

	public void selectDate() throws Exception {
		Calendar cal = Calendar.getInstance();
		int res = cal.getActualMaximum(Calendar.DATE);
		isElementDisplayed(datePageVerification);
		common.isElementDisplayed(datePageVerification);
		Assert.assertTrue("Create Absence Page 4 is not displayed", datePageVerification.isDisplayed());
		utils.log().info("Create Absence Page 4 is displayed");

		String cdate = common.currentDate();
		String nd = common.nextDate(cdate);

		MobileElement date = driver
				.findElementByXPath("//android.widget.TextView[contains(@content-desc, '" + nd + "')]");
		String tagName = date.getAttribute("content-desc").toString();

		while (tagName.contains("Saturday") || tagName.contains("Sunday") || tagName.contains("This day has one")) {
			nd = common.nextDate(nd);
			date = driver.findElementByXPath("//android.widget.TextView[contains(@content-desc, '" + nd + "')]");
			if (nd.contains(Integer.toString(res))) {
				common.swipeUpSlowly();
			}
			tagName = date.getAttribute("content-desc").toString();
		}
		driver.findElementByXPath("//android.widget.TextView[contains(@content-desc, '" + nd + "')]").click();

	}

	public void selectReason() {
		isElementDisplayed(durationPageVerification);
		common.isElementDisplayed(durationPageVerification);
		Assert.assertTrue("Create Absence Page 5 is not displayed", durationPageVerification.isDisplayed());
		utils.log().info("Create Absence Page 5 is displayed");
		selectDuration.click();
		if (common.isElementDisplayed(absenceshifttime)) {
			absenceshifttime.click();
			hideKeyboard();
			driver.getKeyboard().sendKeys("1000");
		} else {
			utils.log().info("Time Absence shift type not displayed");
		}
	}

	public void substituteAssignPageVerification() {
		common.isElementDisplayed(subAssignPageVerification);
		Assert.assertTrue("Create Absence Page 5 is not displayed", subAssignPageVerification.isDisplayed());
		utils.log().info("Create Absence Page 5 is displayed");
	}

	public void submitAbsence() {
		isElementDisplayed(reviewPageVerification);
		common.isElementDisplayed(reviewPageVerification);
		Assert.assertTrue("Create Absence Page 6 is not displayed", reviewPageVerification.isDisplayed());
		utils.log().info("Create Absence Page 6 is displayed");
		submitAbsence.click();
	}

	public void viewAbsence() {
		isElementDisplayed(viewAbsence);
		viewAbsence.click();
	}

	public void verifyAbsence() {
		isElementDisplayed(confirmationNumber);
		Assert.assertTrue("Confirmation number is not displayed", confirmationNumber.isDisplayed());
		utils.log().info("Confirmation number is displayed");
	}

	public void selectAbsenceApprovalWidget() throws Throwable {
		common.scrollToElement(absenceApprovalwidget, "up");
		Assert.assertTrue("Absence approval option is not displayed Home page", absenceApprovalwidget.isDisplayed());
		utils.log().info("Absence approval option is displayed on Home page");
		click(absenceApprovalwidget);
	}

	public void verifyAbsenceApprovalPage() {
		isElementDisplayed(verifyAbsencePage);
		Assert.assertTrue("Absence approval page is not displayed", verifyAbsencePage.isDisplayed());
		utils.log().info("Absence approval page is displayed");
	}

	public void storeAbsenceDetails() {
		absence_Ename = getElementText(employeeName);
		absence_day = getElementText(dayName);
		absence_month = getElementText(monthName);
	}

	public void selectApproveConfirmAbsence() {
		employeeName.click();
		approveBtnOnAbsence();
		clickonOkBtn();
	}

	public void clickonOkBtn(){
		isElementDisplayed(okBtn);
		okBtn.click();
	}
	public void approveBtnOnAbsence()
	{
		isElementDisplayed(approvebtn);
		approvebtn.click();
	}

	public void verifyAcceptedAbsence() {
		isElementDisplayed(verifyAbsencePage);
		Assert.assertTrue("Absence approval page is not displayed", verifyAbsencePage.isDisplayed());
		utils.log().info("Absence approval page is displayed");
		String name = getElementText(employeeName);
		String day = getElementText(dayName);
		String month = getElementText(monthName);
		Assert.assertTrue("Approved job still present in the approval list",
				!(absence_Ename == name && absence_day == day && absence_month == month));
		utils.log().info("Approved job removed from jobs list");
	}

	public void clickOnSetting() {
		clickOnMenuTab();
		settingOption();
	}

	public void settingOption(){
		isElementDisplayed(settings);
		click(settings);
	}
	public void toggleDarkMode() {
		isElementDisplayed(darkMode);
		click(darkMode);
	}

	public void screenshotcapture() throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("screenshot/DarkMode.jpg"));
	}

	public void pullToRefresh() {
		common.scrollDown();
	}

	public void clickOnAvailableLeaveBalance_displayed() {
		common.swipeUpSlowly();
		common.swipeUpSlowly();
		common.isElementDisplayed(availableLeaveBalance);
		Assert.assertTrue("Available Leave Balances is not displayed on Home page",
				availableLeaveBalance.isDisplayed());
		utils.log().info("Available Leave Balances is displayed on Home page");
		click(availableLeaveBalance);
		isElementDisplayed(availableLeaveBalanceHeader);
		Assert.assertTrue("Available Leave Balance page is not displayed", availableLeaveBalanceHeader.isDisplayed());
		utils.log().info("Available Leave Balance Page is displayed");
	}

	public void verify_availableDays() {
		String leaveBalance = getElementText(availableDays);
		Assert.assertTrue("Available Leaves are invalid", Float.parseFloat(leaveBalance) >= 0);
		utils.log().info("Available Days are valid");
	}

	public void clickCreateAbs() throws Throwable {
		common.scrollToElement(createAbsBtn, "up");
		Assert.assertTrue("Create Absence button is not displayed", createAbsBtn.isDisplayed());
		utils.log().info("Create Absence button is displayed");
		createAbsBtn.click();
	}

	public void clickOnFeedback() {
		clickOnMenuTab();
		clickOnFeedbackOption();
	}

	public void clickOnMenuTab(){
		isElementDisplayed(menuTab);
		click(menuTab);
	}

	public void clickOnFeedbackOption(){
		isElementDisplayed(feedback);
		click(feedback);
	}
	public void sendFeedback() throws Exception {
		isElementDisplayed(topic);
		click(topic);
		int size = itemsInDropDown.size();
		int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
		itemsInDropDown.get(randomNumber).click();
		sendFeedbackTitle();
		sendFeedbackMessage();
	}

	public void sendFeedbackTitle(){
		isElementDisplayed(title);
		title.click();
		driver.getKeyboard().sendKeys("Automation Test");
	}
	public void sendFeedbackMessage(){
		isElementDisplayed(message);
		click(message);
		driver.getKeyboard().sendKeys("This is a Test message");
		isElementDisplayed(saveBtn);
		click(saveBtn);
	}
	public void clickInbox() {
		isElementDisplayed(inboxTab);
		click(inboxTab);
	}

	public void verifyInboxPage() throws Exception {
		isElementDisplayed(inboxTab);
		Assert.assertTrue("Inbox page is not displayed", inboxTab.isDisplayed());
		utils.log().info("Inbox page is displayed");

	}

	public void viewText() {
		isElementDisplayed(inboxMsg);
		click(inboxMsg);
		Assert.assertTrue("Message is not displayed", getElementText(msgData).length() > 1);
		utils.log().info("MEssage is displayed");
	}

	public void selectUnfilledAbsence() {
		common.swipeUpSlowly();
		common.swipeUpSlowly();
		common.isElementDisplayed(unfilledAbsence);
		Assert.assertTrue("No Unfilled Absence is present", unfilledAbsence.isDisplayed());
		utils.log().info("Unfilled Absence is present");
		click(unfilledAbsence);
	}

	public void click_tapToAssign() {
		common.isElementDisplayed(assignSubstitute);
		click(assignSubstitute);
	}

	public void assignSubstitute() {
		common.isElementDisplayed(selectSubstitute);
		click(selectSubstitute);
	}

	public void confirmAssignSubstitute() {
		common.isElementDisplayed(confirmAssignSub);
		click(confirmAssignSub);
	}

	public void clickTimesheetOption() throws Exception {
		common.scrollToElement(timesheetsbtn, "up");
		isElementDisplayed(timesheetsbtn);
		click(timesheetsbtn);
	}

	public void verifySubmitTimesheetBtn() {
		isElementDisplayed(submittimesheetsbtn);
		Assert.assertTrue("Submit timesheet option is not displayed", submittimesheetsbtn.isDisplayed());
	}

	public void submitTimesheet() throws Throwable {
		verifySubmitTimesheetBtn();
		click(submittimesheetsbtn);
	}

	public void verifySubmitTimesheet() {
		Assert.assertTrue("Timesheet button not displayed", submitTimesheet.isDisplayed());
		utils.log().info("Timesheet button displayed");
	}

	public void enterTimeSheetdetails() {
		if (isElementDisplayed(enterPin)) {
			click(enterPin);
			driver.getKeyboard().sendKeys("3661");
			hideKeyboard();
			click(checkbox);
		} else {
			utils.log().info("Digital signature not displayed");
		}
		verifySubmitTimesheet();
		common.swipeUpSlowly();
		click(submitTimesheet);
	}

	public void undoTimesheet() throws Exception {
		verifyUndoBtn();
		undoicon.click();
		isElementDisplayed(undobtn);
		undobtn.click();
	}

	public void verifyUndoBtn() {
		isElementDisplayed(undoSubmission);
		Assert.assertTrue("Undo timesheet option is not displayed", undoSubmission.isDisplayed());
		utils.log().info("Undo timesheet option is not displayed");
	}

	public void verifyUndo() {
		isElementDisplayed(declinebtn);
		declinebtn.click();
		verifySubmitTimesheetBtn();
		utils.log().info("Submit timesheet option is not displayed");
	}

	public void openMenuSearchBar() {
		isElementDisplayed(menuTab);
		click(menuTab);
		clickOnSearchBar();
	}

	public void clickOnSearchBar()
	{
		isElementDisplayed(searchBar);
		click(searchBar);
	}
	public void enterSearchText(String searchText) {
		common.isElementDisplayed(searchBar);
		searchResultText = searchText;
		searchBar.click();
		searchBar.clear();
		searchBar.sendKeys(searchText);
	}

	public void verifySearchResult() {
		common.isElementDisplayed(searchResult);
		String result = getElementText(searchResult);
		Assert.assertTrue("Entered text does not match", result.toLowerCase().contains(searchResultText.toLowerCase()));
		utils.log().info("Entered text matches with result");
	}

	public void clickReorderWidget() throws Throwable {
		reOrderWidgetbtn = common.scrollToElement(reOrderWidgetbtn, "up");
		common.isElementDisplayed(reOrderWidgetbtn);
		click(reOrderWidgetbtn);

		for (MobileElement widgetlistele : WidgetOrderList) {
			widgetlistbeforeReorder.add(common.getElementText(widgetlistele));
		}
	}

	public void draganddrop() throws Throwable {
		common.isElementDisplayed(dragableEle);
		TouchAction action = new TouchAction(driver);
		int dragX = dragableEle.getLocation().x + (dragableEle.getSize().width / 2);
		int dragY = dragableEle.getLocation().y + (dragableEle.getSize().height / 2);
		action.press(PointOption.point(dragX, dragY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(dragX, dragY + 400)).release().perform();
	}

	public void saveReorderedWidget() {
		for (MobileElement widgetlistele : WidgetOrderList) {
			widgetlistafterReorder.add(common.getElementText(widgetlistele));
		}
		click(saveOrderWidgetbtn);
	}

	public void verifyWidgetsOrder() {
		Assert.assertNotEquals(widgetlistbeforeReorder, widgetlistafterReorder);
	}

	public void viewWeekTimesheets() throws Exception {
		clickTimesheetOption();
		verifyMonday();
		verifyTuesday();
		verifyWednesday();
		verifyThrusday();
		verifyFriday();
		verifySaturday();
		verifySunday();
		utils.log().info("Timesheets for entire week is displayed");
	}

	public void verifyMonday() {
		common.isElementDisplayed(monday);
		Assert.assertTrue("Monday timesheet is not displayed", monday.isDisplayed());
	}

	public void verifySunday(){
	common.isElementDisplayed(sunday);
		Assert.assertTrue("Sunday timesheet is not displayed",sunday.isDisplayed());
    }
	public void verifySaturday(){
		common.isElementDisplayed(saturday);
		Assert.assertTrue("Saturday timesheet is not displayed", saturday.isDisplayed());
	}
	public void verifyTuesday() {
		common.isElementDisplayed(tuesday);
		Assert.assertTrue("Tuesday timesheet is not displayed", tuesday.isDisplayed());
	}

	public void verifyWednesday() {
		common.isElementDisplayed(wednesday);
		Assert.assertTrue("Wednesday timesheet is not displayed", wednesday.isDisplayed());
	}

	public void verifyThrusday() {
		common.isElementDisplayed(thursday);
		Assert.assertTrue("Thursday timesheet is not displayed", thursday.isDisplayed());
	}

	public void verifyFriday() {
	common.isElementDisplayed(friday);
		Assert.assertTrue("Friday timesheet is not displayed",friday.isDisplayed());
}

	public void clickOnFriday(){
		common.isElementDisplayed(friday);
		click(friday);
	}
	public void viewDayTimesheets() {
		clickOnFriday();
		common.isElementDisplayed(commonDayTotal);
		Assert.assertTrue("Timesheet for the day is not displayed", commonDayTotal.isDisplayed());
		utils.log().info("Timesheets for the day is displayed");
	}

	public void addTimeSheet() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
				common.isElementDisplayed(selectDayToFillTimesheet);
				click(selectDayToFillTimesheet);
				click(addTimeSheets);
				common.isElementDisplayed(workDetails);
				Intime = common.getElementText(timeSheetInTime);
				click(saveTimesheets);
				break;
			case "iOS":
				common.isElementDisplayed(selectDayToFillTimesheet);
				click(selectDayToFillTimesheet);
				click(addTimeSheets);
				common.isElementDisplayed(workDetails);
				clickonEditButton2();
				clickOnEditBtton3();
				Intime = common.currentTime();
				click(saveTimesheets);
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	public void clickOnEditBtton3(){
		click(timeInEdit3);
		click(Done);
	}

	public void goToEditDeleteTimeSheetOption() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
				common.isElementDisplayed(dailytimeSheetsubmitbtn);
				timeSheetInTime = driver.findElementByXPath("//android.widget.TextView[contains(@text,'" + Intime + "')]");
				click(timeSheetInTime);
				break;
			case "iOS":
				common.isElementDisplayed(dailytimeSheetsubmitbtn);
				click(timeSheetInTime);
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	public void editTimesheet() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
				timEntryEditBtnClick();
				common.isElementDisplayed(workDetails);
				click(timeSheetOutTime);
				click(okBtn);
				click(saveTimesheets);
				break;
			case "iOS":
				timEntryEditBtnClick();
				clickonEditButton1();
				clickonEditButton2();
				AddTextonCommentSection();
				click(saveButton);
				clickOnNotNowBtn();
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}
	public void clickonEditButton1(){
		click(timeInEdit1);
		click(Done);
	}

	public void AddTextonCommentSection(){
		click(commentBox);
		driver.getKeyboard().sendKeys("Checking Edit Functionality");
	}

	public void clickonEditButton2(){
		click(timeInEdit2);
		click(Done);
	}

	public void clickOnNotNowBtn() {
		isElementDisplayed(declinebtn);
		click(declinebtn);
	}

	public void timEntryEditBtnClick() {
		isElementDisplayed(dailytimeSheetedittbtn);
		click(dailytimeSheetedittbtn);
	}

	public void clickOnDeleteTimesheet() {
	common.isElementDisplayed(timeSheetDeletebtn);
	click(timeSheetDeletebtn);
	}

	public void deleteTimesheet() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
				common.isElementDisplayed(timeSheetTimeEventPage);
				common.isElementDisplayed(dailytimeSheetedittbtn);
				clickOnDeleteTimesheet();
				click(okBtn);
				common.isElementDisplayed(dailytimeSheetsubmitbtn);
				Assert.assertFalse("Time sheet is not deleted", common.isElementNotPresent(timeSheetInTime));
				utils.log().info("Time sheet is deleted");
				break;
			case "iOS":
				click(timeSheetInTime);
				isElementDisplayed(dailytimeSheetedittbtn);
				click(timeSheetDeletebtn);
				click(okay);
				isElementDisplayed(dailytimeSheetsubmitbtn);
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	public void click_searchResult() {
		common.isElementDisplayed(searchAbsReason);
		click(searchAbsReason);
	}

	public void verifyAbsenceDetailPage() {
		common.isElementDisplayed(confirmationNumber);
		common.isElementDisplayed(absenceDetailPageSubstitute);
		common.isElementDisplayed(absenceDetailPageApproval);
		Assert.assertTrue("Absence Details Page is not displayed", confirmationNumber.isDisplayed());
		utils.log().info("Absence Details Page is displayed");
	}

	//MOB-4239
	public void goBack() {
		common.isElementDisplayed(backButton);
		click(backButton);
	}

	public void verify_widgetsPresent() throws Exception {
		widgetlistbeforeReorder.forEach(widget->{
			if(widget.equals("What's New")) {
				return;
			}
			common.swipeUpSlowly();
			MobileElement widgetElement = driver
					.findElementByXPath("//android.widget.TextView[@text='"+widget+"']");
			common.isElementDisplayed(widgetElement);
			Assert.assertTrue("Widget is not displayed", widgetElement.isDisplayed());
			utils.log().info("Widget is present");
		});
	}

	public void verify_footerPresent() {
		common.isElementDisplayed(homeTab);
		common.isElementDisplayed(menuTab);
		common.isElementDisplayed(inboxTab);
		Assert.assertTrue("Footers are not displayed", homeTab.isDisplayed() && menuTab.isDisplayed() && inboxTab.isDisplayed());
		utils.log().info("Footers are present");
	}
	
	public void getDate() throws Throwable {
		common.isElementDisplayed(getdate);
		absence_day = common.getElementText(getdate).substring(9, 11);
		click(homeTab);
		pullToRefresh();
	}

	public void clickOnSeachResult(){
		common.isElementDisplayed(searchResult);
		click(searchResult);
	}
	public void clickCalender() {
		click(menuTab);
		clickOnSeachResult();
		common.isElementDisplayed(calendertitle);
		driver.findElementByXPath("//android.widget.TextView[@text='" + absence_day + "']").click();
		clickOnEvent();
	}

	public void clickOnEvent(){
		common.isElementDisplayed(eventTitle);
		click(eventTitle);
	}
}
