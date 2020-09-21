package mobile.frontline.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
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
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='']")
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
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement timesheetsbtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/submit_time_sheet_button")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement submittimesheetsbtn;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter PIN']")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement enterPin;
	
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/timesheet_checkbox")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement checkbox;
	
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/submit_time_sheets_button")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement submitTimesheet;
	
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_sheet_week_undo_submission_text")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement undoSubmission;
	
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/undo_icon")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement undoicon;
	
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/undo_time_sheets_button")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement undobtn;
	
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/review_dialog_decline_button")
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement declinebtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
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

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/widget_name")
	@iOSXCUITFindBy(xpath = "")
	public List<MobileElement> WidgetOrderList;
	
	public String absence_Ename;
	public String absence_day;
	public String absence_month;
	public String searchResultText;
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
		fluentWait(addAbsence);
		common.isElementDisplayed(addAbsence);
		Assert.assertTrue("Add Absence button is not displayed absence page", addAbsence.isDisplayed());
		utils.log().info("Add Absence option is displayed on absence page");
		click(addAbsence);
	}

	// Create Absence Page 1
	public void verifyWhoPage() {
		fluentWait(absenceRequiredFor);
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

	}

	public void clickNext() {
		// fluentWait(forwardCaret);
		common.isElementClickable(forwardCaret);
		// forwardCaret.isEnabled();
		forwardCaret.click();
	}

	public void absenceReason() {
		fluentWait(absenceReasonVerification);
		common.isElementDisplayed(absenceReasonVerification);
		Assert.assertTrue("Create Absence Page 3 is not displayed", absenceReasonVerification.isDisplayed());
		utils.log().info("Create Absence Page 3 is displayed");
		reason.click();

	}

	public void selectDate() throws Exception {
		fluentWait(datePageVerification);
		common.isElementDisplayed(datePageVerification);
		Assert.assertTrue("Create Absence Page 4 is not displayed", datePageVerification.isDisplayed());
		utils.log().info("Create Absence Page 4 is displayed");
		// dateVerification.click();

		String cdate = common.currentDate();
		String nd = common.nextDate(cdate);
		MobileElement date = driver
				.findElementByXPath("//android.widget.TextView[contains(@content-desc, '" + nd + "')]");
		String tagName = date.getAttribute("content-desc").toString();

		while (tagName.contains("Saturday") || tagName.contains("Sunday") || tagName.contains("This day has one")) {
			nd = common.nextDate(nd);
			date = driver.findElementByXPath("//android.widget.TextView[contains(@content-desc, '" + nd + "')]");
			tagName = date.getAttribute("content-desc").toString();
		}
		driver.findElementByXPath("//android.widget.TextView[contains(@content-desc, '" + nd + "')]").click();

	}

	public void selectReason() {
		fluentWait(durationPageVerification);
		common.isElementDisplayed(durationPageVerification);
		Assert.assertTrue("Create Absence Page 5 is not displayed", durationPageVerification.isDisplayed());
		utils.log().info("Create Absence Page 5 is displayed");
		selectDuration.click();
	}

	public void submitAbsence() {
		fluentWait(reviewPageVerification);
		common.isElementDisplayed(reviewPageVerification);
		Assert.assertTrue("Create Absence Page 6 is not displayed", reviewPageVerification.isDisplayed());
		utils.log().info("Create Absence Page 6 is displayed");
		submitAbsence.click();
	}

	public void viewAbsence() {
		fluentWait(viewAbsence);
		viewAbsence.click();
	}

	public void verifyAbsence() {
		fluentWait(confirmationNumber);
		Assert.assertTrue("Confirmation number is not displayed", confirmationNumber.isDisplayed());
		utils.log().info("Confirmation number is displayed");
	}

	public void selectAbsenceApprovalWidget() {

		common.swipeUpSlowly();
		common.isElementDisplayed(absenceApprovalwidget);
		Assert.assertTrue("Absence approval option is not displayed Home page", absenceApprovalwidget.isDisplayed());
		utils.log().info("Absence approval option is displayed on Home page");
		click(absenceApprovalwidget);

	}

	public void verifyAbsenceApprovalPage() {
		fluentWait(verifyAbsencePage);
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
		fluentWait(approvebtn);
		approvebtn.click();
		fluentWait(okBtn);
		okBtn.click();
	}

	public void verifyAcceptedAbsence() {

		fluentWait(verifyAbsencePage);
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
		fluentWait(menuTab);
		click(menuTab);
		fluentWait(settings);
		click(settings);
	}

	public void toggleDarkMode() {
		fluentWait(darkMode);
		click(darkMode);
	}
	
	public void screenshotcapture() throws IOException {
		File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
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

	public void clickCreateAbs() {
		fluentWait(createAbsBtn);
		Assert.assertTrue("Create Absence button is not displayed", createAbsBtn.isDisplayed());
		utils.log().info("Create Absence button is displayed");
		createAbsBtn.click();
	}

	public void clickOnFeedback() {
		fluentWait(menuTab);
		click(menuTab);
		fluentWait(feedback);
		click(feedback);
	}

	public void sendFeedback() throws Exception {
			fluentWait(topic);
			click(topic);
			int size = itemsInDropDown.size();
			int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
			itemsInDropDown.get(randomNumber).click();
			fluentWait(title);
			title.click();
			driver.getKeyboard().sendKeys("Automation Test");
			fluentWait(message);
			click(message);
			driver.getKeyboard().sendKeys("This is a Test message");
			fluentWait(saveBtn);
			click(saveBtn);
	}

	public void clickInbox() {
		fluentWait(inboxTab);
		click(inboxTab);
	}

	public void verifyInboxPage() throws Exception {
		fluentWait(inboxTab);
		Assert.assertTrue("Inbox page is not displayed", inboxTab.isDisplayed());
		utils.log().info("Inbox page is displayed");

	}

	public void viewText() {
		fluentWait(inboxMsg);
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
	
	public void clickTimesheetOption() {
		//click(menuTab);
		common.swipeUpSlowly();
		common.swipeUpSlowly();
		common.swipeUpSlowly();
		fluentWait(timesheetsbtn);
		click(timesheetsbtn);
	}
	
	public void submitTimesheet() throws Throwable {	
		//Thread.sleep(20000);
		fluentWait(submittimesheetsbtn);
		Assert.assertTrue("Submit timesheet option is not displayed", submittimesheetsbtn.isDisplayed());
		utils.log().info("Submit timesheet option is not displayed");
		click(submittimesheetsbtn);
	}
	
	public void enterTimeSheetdetails() {
		fluentWait(enterPin);
		click(enterPin);
		driver.getKeyboard().sendKeys("3661");
		click(checkbox);
		common.swipeUpSlowly();
		click(submitTimesheet);
	}
	
	public void undoTimesheet() {
		fluentWait(undoSubmission);
		Assert.assertTrue("Undo timesheet option is not displayed", undoSubmission.isDisplayed());
		utils.log().info("Undo timesheet option is not displayed");
		undoicon.click();
		fluentWait(undobtn);
		undobtn.click();	
	}
	
	public void verifyUndo() {
		fluentWait(declinebtn);
		declinebtn.click();
		fluentWait(submittimesheetsbtn);
		Assert.assertTrue("Submit timesheet option is not displayed", submittimesheetsbtn.isDisplayed());
		utils.log().info("Submit timesheet option is not displayed");
	}

	public void openMenuSearchBar() {
		fluentWait(menuTab);
		click(menuTab);
		fluentWait(searchBar);
		click(searchBar);
	}

	public void enterSearchText(String searchText) {
		common.isElementDisplayed(searchBar);
		searchResultText = searchText;
		searchBar.click();
		searchBar.clear();
		searchBar.sendKeys(searchText);
		
//		fluentWait(searchBar);
//		click(searchBar);
//		driver.getKeyboard().sendKeys("3661");
		
	}

	public void verifySearchResult() {
		common.isElementDisplayed(searchResult);
		String result = getElementText(searchResult);
		
		Assert.assertTrue("Entered text does not match", result.equalsIgnoreCase(searchResultText));
		utils.log().info("Entered text matches with result");
	}

	public void clickReorderWidget() throws Throwable {
		reOrderWidgetbtn = common.scrollToElement(reOrderWidgetbtn, "up");
		//common.swipeUpSlowly();
		common.isElementDisplayed(reOrderWidgetbtn);
		click(reOrderWidgetbtn);
		
		for(MobileElement widgetlistele : WidgetOrderList )
		{
			widgetlistbeforeReorder.add(common.getElementText(widgetlistele));
		}
	}

	public void draganddrop() throws Throwable {

		common.isElementDisplayed(dragableEle);
		TouchAction action = new TouchAction(driver);
		int dragX = dragableEle.getLocation().x + (dragableEle.getSize().width / 2);
		int dragY = dragableEle.getLocation().y + (dragableEle.getSize().height / 2);

//		  int dropX= ele2.getLocation().x + (ele2.getSize().width/2); 
//		  int dropY= ele2.getLocation().y + (ele2.getSize().height/2); 

		action.press(PointOption.point(dragX, dragY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(dragX, dragY + 400)).release().perform();

	}

	public void saveReorderedWidget() {

		for(MobileElement widgetlistele : WidgetOrderList )
		{
			widgetlistafterReorder.add(common.getElementText(widgetlistele));
		}
		//Assert.assertEquals(widgetlist.get(1),"2");
		click(saveOrderWidgetbtn);
	}

	public void verifyWidgetsOrder() {
		
		Assert.assertNotEquals(widgetlistbeforeReorder,widgetlistafterReorder);
	}

	public void viewWeekTimesheets() {
		clickTimesheetOption();
		
		common.isElementDisplayed(monday);
		Assert.assertTrue("Monday timesheet is not displayed", monday.isDisplayed());
		common.isElementDisplayed(tuesday);
		Assert.assertTrue("Tuesday timesheet is not displayed", tuesday.isDisplayed());
		common.isElementDisplayed(wednesday);
		Assert.assertTrue("Wednesday timesheet is not displayed", wednesday.isDisplayed());
		common.isElementDisplayed(thursday);
		Assert.assertTrue("Thursday timesheet is not displayed", thursday.isDisplayed());
		common.isElementDisplayed(friday);
		Assert.assertTrue("Friday timesheet is not displayed", friday.isDisplayed());
		common.isElementDisplayed(saturday);
		Assert.assertTrue("Saturday timesheet is not displayed", saturday.isDisplayed());
		common.isElementDisplayed(sunday);
		Assert.assertTrue("Sunday timesheet is not displayed", sunday.isDisplayed());
		utils.log().info("Timesheets for entire week is displayed");
	}

	public void viewDayTimesheets() {
		fluentWait(friday);
		click(friday);
		fluentWait(commonDayTotal);
		Assert.assertTrue("Timesheet for the day is not displayed", commonDayTotal.isDisplayed());
		utils.log().info("Timesheets for the day is displayed");
	}

}
