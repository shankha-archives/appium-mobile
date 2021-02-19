package mobile.frontline.pages;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestDataManager;
import mobile.Frontline.utils.TestUtils;

public class SmokeMethods extends LoginPage {

	TestUtils utils = new TestUtils();
	BasePage common = new BasePage();
	SmokeMethods smoke;
	JobsMethods jobs = new JobsMethods();

	public TestDataManager testdata = new TestDataManager();

	// click //homepage
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Absences Today']")
	@iOSXCUITFindBy(accessibility = "Absences Today_ModuleHeader")
	public MobileElement absenceWidget;

	// click //in absence widget
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/add_absence")
	@iOSXCUITFindBy(accessibility = "iconPlus")
	public MobileElement addAbsence;

	// page 1 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Who?']")
	public MobileElement absenceRequiredFor;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/search_view_edit_text")
	@iOSXCUITFindBy(accessibility = "Search employees by last name")
	public MobileElement serachEditText;

	// click
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/create_absence_list_cell_name")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
	public MobileElement selectReqName;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/progress_footer_forward_circle")
	@iOSXCUITFindBy(accessibility = "Create_Absence_NextStep_Button")
	public MobileElement forwardCaret;

	// page 3 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Why?']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeStaticText[1])[2]")
	public MobileElement absenceReasonVerification;

	// click //page 3 reason
	@AndroidFindBy(xpath = "(//android.widget.LinearLayout)[4]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[3]")
	public MobileElement reason;

	// page 4 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='When?']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeStaticText[1])[2]")
	public MobileElement datePageVerification;

	// also check the date which is taken
	// page 5 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='How Long?']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeStaticText[1])[2]")
	public MobileElement durationPageVerification;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/shift_type_full_day")
	@iOSXCUITFindBy(accessibility = "CreateAbsence_FullDay_Button")
	public MobileElement selectDuration;

	// page 6 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Review']")
	public MobileElement reviewPageVerification;

	// click next
	// click
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/progress_footer_submit_button")
	@iOSXCUITFindBy(accessibility = "Submit_Absence")
	public MobileElement submitAbsence;

	// click
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/view_absence_button")
	@iOSXCUITFindBy(accessibility = "View Absence")
	public MobileElement viewAbsence;

	// verify conf number is present
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Conf')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Conf')]")
	public MobileElement confirmationNumber;

	// click on approvals
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'awaiting approval')]")
	@iOSXCUITFindBy(accessibility = "awaiting approval")
	public MobileElement absenceApprovalwidget;

	// verify approvals
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Approvals']")
	@iOSXCUITFindBy(accessibility = "Approvals")
	public MobileElement verifyAbsencePage;

	// employee name for verification
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/absence_approval_employee_name")
	@iOSXCUITFindBy(accessibility = "ApprovalsView_UnapprovedCell_0")
	public MobileElement employeeName;

	// day of absence name for verification
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/absence_to_date_day_text")
	public MobileElement dayName;

	// month of absence name for verification
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/absence_to_date_month_text")
	public MobileElement monthName;

	// click on approve btn
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/absence_approve_button")
	@iOSXCUITFindBy(accessibility = "AbsenceRequestDetailView_Approve_Button")
	public MobileElement approvebtn;

	// month of absence name for verification
	@AndroidFindBy(id = "android:id/button1")
	@iOSXCUITFindBy(accessibility = "Yes")
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
	@AndroidFindBy(className = "android.widget.Switch")
	@iOSXCUITFindBy(accessibility = "darkMode")
	public MobileElement darkMode;

	// create absence btn //click
	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'Create Absence']")
	@iOSXCUITFindBy(accessibility = "AbsencesModule_Create_Button")
	public MobileElement createAbsBtn;

	// create absence btn //click
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/create_absence_list_cell_name")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeStaticText[1])[2]")
	public MobileElement selectLocation;

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
	// @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Topic']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
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
	@iOSXCUITFindBy(accessibility = "Inbox_TabBar_Button")
	public MobileElement inboxTab;

	// click on inbox message
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/inbox_notification_snippet_text")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[2]")
	public MobileElement inboxMsg;

	// click on inbox tab
	@AndroidFindBy(xpath = "//android.view.View")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
	public MobileElement msgData;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Leave Balances']")
	@iOSXCUITFindBy(accessibility = "Available Leave Balances_ModuleHeader")
	public MobileElement availableLeaveBalance;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Leave Balances']")
	@iOSXCUITFindBy(accessibility = "Absences")
	public MobileElement availableLeaveBalanceHeader;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/leave_balance_duration")
	public MobileElement availableDays;

	@iOSXCUITFindBy(accessibility = "Schedule_Absence_Button")
	public MobileElement absenceBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='UNFILLED']")
	@iOSXCUITFindBy(accessibility = "UNFILLED")
	public MobileElement unfilledAbsence;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Tap to Assign']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]//XCUIElementTypeStaticText[3]")
	public MobileElement assignSubstitute;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Assign']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='SubstituteSearchTableCell_Assign_Button'])[1]")
	public MobileElement selectSubstitute;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Assign']")
	@iOSXCUITFindBy(accessibility = "AbsenceSubstituteSearchView_FinalAssign_Button")
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
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Undo Submission'])[1]")
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
	@iOSXCUITFindBy(accessibility = "Edit button: double-tap to go to dashboard widget reordering page")
	public MobileElement reOrderWidgetbtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/save")
	@iOSXCUITFindBy(accessibility = "Done")
	public MobileElement saveOrderWidgetbtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/drag_handle")
	@iOSXCUITFindBy(accessibility = "Reorder New Version Available")
	public MobileElement dragableEle;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'TUE')]")
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
	@iOSXCUITFindBy(accessibility = "Day Total")
	public MobileElement commonDayTotal;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@index=1])[3]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ABSENCES']/following-sibling::XCUIElementTypeOther[2]//XCUIElementTypeOther[1]")
	public MobileElement searchAbsReason;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Substitute']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Substitute']")
	public MobileElement absenceDetailPageSubstitute;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Approval Status']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Approval Status']")
	public MobileElement absenceDetailPageApproval;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='2']")
	@iOSXCUITFindBy(accessibility = "Timesheet_Table")
	public MobileElement selectDayToFillTimesheet;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/menu_item_add_time")
	@iOSXCUITFindBy(accessibility = "Add Time")
	public MobileElement addTimeSheets;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/fl_spinner_selection")
	@iOSXCUITFindBy(accessibility = "EventType_1")
	public MobileElement workDetails;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_entry_save_button")
	@iOSXCUITFindBy(accessibility = "Add")
	public MobileElement saveTimesheets;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/in_time")
	@iOSXCUITFindBy(accessibility = "Time_Event_Cell_0")
	public MobileElement timeSheetInTime;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/day_view_submit_time_sheet_button")
	@iOSXCUITFindBy(accessibility = "TimesheetWeekView_Submit_Button")
	public MobileElement dailytimeSheetsubmitbtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/edit_menu_item")
	@iOSXCUITFindBy(accessibility = "Edit")
	public MobileElement dailytimeSheetedittbtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/out_time")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Edit'])[3]")
	public MobileElement timeSheetOutTime;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/delete_event_button")
	@iOSXCUITFindBy(accessibility = "Delete Event")
	public MobileElement timeSheetDeletebtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Time Event']")
	 @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Time Entry']")
	public MobileElement timeSheetTimeEventPage;

	@AndroidFindBy(xpath = "//android.widget.TextView")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[4]")
	public MobileElement getdate;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_title")
	@iOSXCUITFindBy(accessibility = "Calendar_MenuOption")
	public MobileElement calendartitle;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_title")
	@iOSXCUITFindBy(accessibility = "Calendar_MenuOption")
	public List<MobileElement> calendarMonthlist;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_event_cell_line_two")
	@iOSXCUITFindBy(accessibility = "EventView_Absence_Other")
	public MobileElement eventTitle;

	// page 6 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Substitute']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeStaticText[1])[2]")
	public MobileElement subAssignPageVerification;

	// click on home tab
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
	@iOSXCUITFindBy(accessibility = "Home_TabBar_Button")
	public MobileElement homeTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Next: Choose Reason']")
	@iOSXCUITFindBy(xpath = "(//*[@type='XCUIElementTypeStaticText'])[3]")
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

	// Edit Absence //HomePage
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Absences']")
	@iOSXCUITFindBy(accessibility = "Absences_ModuleHeader")
	public MobileElement clickOnAbsenceWidget;

	// selecting editable Absence
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='NewReason']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'NewReason')][1]")
	public MobileElement reasonAbsence;

	// clicking edit tab
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit']")
	@iOSXCUITFindBy(accessibility = "AbsenceDetail_Edit_Button")
	public MobileElement editTab;

	// selecting absence date
	@AndroidFindBy(xpath = "//android.view.ViewGroup/child::android.widget.TextView[@index=1][1]")
	public MobileElement fullDateAbsence;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/progress_footer_submit_button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit_Absence']")
	public MobileElement saveChanges;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Clock In']")
	@iOSXCUITFindBy(accessibility = "Clock In")
	public MobileElement clockInbtn;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[3]")
	public MobileElement ScrollToClockInbtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/location_services_permit_access_button")
	@iOSXCUITFindBy(accessibility = "Enable_Location_Services_Button")
	public MobileElement permissionGrantbtn;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	@iOSXCUITFindBy(accessibility = "Allow Once")
	public MobileElement permissionGrantonlyForApp;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CLOCKED IN']")
	@iOSXCUITFindBy(accessibility = "Clock Out")
	public MobileElement clockedInVerification;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Clock Out']")
	@iOSXCUITFindBy(accessibility = "Clock Out")
	public MobileElement clockedOutBtn;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/clock_in_time_text_widget")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement clockedInTime;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_sheet_summary_event_name")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement eventSummary;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Calendar']")
	public MobileElement calendar;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='People']")
	@iOSXCUITFindBy(accessibility = "People_ModuleHeader")
	public MobileElement PeopleWidget;

	@AndroidFindBy(className = "android.widget.EditText")
	@iOSXCUITFindBy(accessibility = "DirectoryView_EmployeeCell_0")
	public MobileElement SearchPeople;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ATMobile ATMobile']")
	 @iOSXCUITFindBy(accessibility = "EmployeeDetailView_FullName_StaticText")
	public MobileElement fullEmployeeName;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Personal Phone']")
	@iOSXCUITFindBy(accessibility = "Personal Phone")
	public MobileElement PersonalPhone;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='7846948974 ext: 123']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[4]")
	public MobileElement PersonalPhoneData;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Work Email']")
	@iOSXCUITFindBy(accessibility = "Work Email")
	public MobileElement WorkEmail;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='mohit.singla1@frontlineed.com']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[6]")
	public MobileElement WorkEmailData;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Personal Email']")
	@iOSXCUITFindBy(accessibility = "Personal Email")
	public MobileElement PersonalEmail;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='mohit.singla1@frontlineed.com']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[7]")
	public MobileElement PersonalEmailData;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile App Testing District (Absence Only)']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'Absence Only')]")
	public MobileElement peopleWidgetOrg;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_right_button_image")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='DatePicker_RightTapArea_Other']")
	public MobileElement nextMonthCalender;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_right_button_image")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='DatePicker_RightTapArea_Other']")
	public MobileElement nextMonthCalendar;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeStaticText)[2]")
	public MobileElement monthVerify;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/log_out_button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
	public MobileElement logoutBtn;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	@iOSXCUITFindBy(accessibility = "Week")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
	@iOSXCUITFindBy(accessibility = "Home_TabBar_Button")
	public MobileElement homeBtnFooter;

	@iOSXCUITFindBy(accessibility = "Week")
	public MobileElement week;

	// edition of iOS path remaining
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/shift_type_half_day_pm")
	@iOSXCUITFindBy(accessibility = "CreateAbsence_HalfDayPM_Button")
	public MobileElement halfDayDuration;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@index=1])[3]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Half Day')]")
	public MobileElement durationHalfDay;

	@AndroidFindBy(id = "android:id/message")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your absence was created successfully.']")
	public MobileElement createdAbsenceVerificationMsg;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@index=0])[3]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[3]")
	public MobileElement selectDayOFUnfilledUnassignedAbsence;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index=2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='DatePicker_RightTapArea_Other']")
	public MobileElement traverseToNextDay;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/widget_header_title")
	@iOSXCUITFindBy(xpath = "//	XCUIElementTypeButton[contains(@name, 'ModuleHeader')]")
	public List<MobileElement> widgetListFromDashboard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Absences']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Absences']")
	public MobileElement AbsencePageHeader;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/cell_time_sheet_day_total_time")
	// @iOSXCUITFindBy(accessibility = "")
	public List<MobileElement> dayTotalTime;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/time_sheet_week_view_total_amount")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[3]")
	public MobileElement totalWeekTotalAmount;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/number_of_timesheets_selected")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[7]")
	public MobileElement totalWeekTimeExpected;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Add a Comment']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='TimesheetEventDetailView_Other']/XCUIElementTypeCell[5]/XCUIElementTypeTextView")
	public MobileElement inTimeComment;
	
	
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/in_comment")
	 @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='TimesheetEventDetailView_Other']/XCUIElementTypeCell[5]/XCUIElementTypeTextView")
	public MobileElement inTimeCommentVerify;

	public String absence_Ename;
	public String absence_day;
	public String absence_month;
	public String searchResultText;
	public String Intime;
	public String outTime;
	public String confNumber;
	public String absenceDuration;
	ArrayList<String> widgetlistbeforeReorder;
	ArrayList<String> widgetlistafterReorder;
	public String nextWorkingDate;
	public WebElement scrolledToElement;
	public String totalExpectedTimeofWeek;

	public SmokeMethods() {
	}

	public void selectAbsenceWidget() throws Throwable {

		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			scrolledToElement = androidScrollToElementUsingUiScrollable("text", "Absences Today");
			scrolledToElement.click();
			break;
		case "iOS":
			scrollToElement(absenceWidget, "up");
			click(absenceWidget,"Clicked on Absence Widget");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void addAbsence() {
		isElementdisplayed(addAbsence);
		click(addAbsence,"Clicked on Add Absence option");
	}
	// Create Absence Page 1
	public void verifyWhoPage() {
		isElementdisplayed(absenceRequiredFor);
		Assert.assertTrue("Create Absence Page 1 is not displayed", absenceRequiredFor.isDisplayed());
		utils.log().info("Create Absence Page 1 is displayed");
	}

	public void enterTeachersName(String teacher) throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			verifyWhoPage();
			break;
		case "iOS":
			utils.log().info("Create Absence Page 1 is displayed");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		sendKeys(serachEditText, teacher);
	}

	public void selectTeachersName(String teacher) throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			isElementdisplayed(selectReqName);
			By teacherNameAndroid = By.xpath("//android.widget.TextView[contains(@text,'" + teacher + "')]");
			scrollToElement(teacherNameAndroid, "up");
			click(teacherNameAndroid, "Click Teacher name");
			isElementdisplayed(whoAbsencePageWaittoClickCaret);
			break;
		case "iOS":
			isElementdisplayed(whoAbsencePageWaittoClickCaret);
			By teacherName = By.xpath("//XCUIElementTypeButton[contains(@name,'" + teacher + "')]");
			click(Done,"Clicked on Done button");
			scrollToElement(teacherName, "up");

			click(teacherName, "Click Teacher name");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clickNext() {
		click(forwardCaret, "Clicking forward btn");
	}

	public void selectLocation() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			if (isElementdisplayed(selectLocation))
				click(selectLocation, "Clicked on select Location");
			break;
		case "iOS":
			utils.log().info("Location is selected");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void verifyAsbsenceReasonPage() {
		isElementdisplayed(absenceReasonVerification);
		Assert.assertTrue("Create Absence Page 3 is not displayed", absenceReasonVerification.isDisplayed());
		utils.log().info("Create Absence Page 3 is displayed");
	}

	public void absenceReason() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			verifyAsbsenceReasonPage();
			isElementdisplayed(reason);
			click(reason, "Clicked on Absence Reason");
			break;
		case "iOS":
			isElementdisplayed(reason);
			click(reason,"Clicked on Absence Reason");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void verifyAsbsenceDatePage() {
		isElementdisplayed(datePageVerification);
		common.isElementdisplayed(datePageVerification);
		Assert.assertTrue("Create Absence Page 4 is not displayed", datePageVerification.isDisplayed());
		utils.log().info("Create Absence Page 4 is displayed");
	}

	public String currentDate(String format) throws Exception {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		return dtf.format(LocalDateTime.now());
	}

	public String nextWorkingDay(String absenceDay, String format) throws Exception {
		String cdate = currentDate(format);
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);

		Calendar c = Calendar.getInstance();
		c.setTime(dateFormat.parse(cdate));
		switch (absenceDay) {
		case "next day":
			c.add(Calendar.DAY_OF_YEAR, 1);
			while (c.get(c.DAY_OF_WEEK) == 7 || c.get(c.DAY_OF_WEEK) == 1)
				c.add(Calendar.DAY_OF_YEAR, 1);
			break;
		case "current day":
			c.add(Calendar.DAY_OF_YEAR, 0);
			break;
		case "past day":
			break;
		default:
			throw new Exception("Invalid date");
		}
		return dateFormat.format(c.getTime());
	}

	public void selectDate(String absenceDay) throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			nextWorkingDate = nextWorkingDay(absenceDay, "MMMM dd, yyyy");
			verifyAsbsenceDatePage();
			scrolledToElement = androidScrollToElementUsingUiScrollable("description", nextWorkingDate);
			scrolledToElement.click();
			break;
		case "iOS":
			nextWorkingDate = nextWorkingDay(absenceDay, "MM/dd/yyyy");
			By absenceDate = By.xpath("//XCUIElementTypeCell[contains(@name,'" + nextWorkingDate + "')]");
			scrollToElement(absenceDate, "up");
			click(absenceDate, "Clicked on Absence Date");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void verifyAsbsenceDuratioPage() {
		isElementdisplayed(durationPageVerification);
		Assert.assertTrue("Create Absence Page 5 is not displayed", durationPageVerification.isDisplayed());
		utils.log().info("Create Absence Page 5 is displayed");
	}

	public void selectReason() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			verifyAsbsenceDuratioPage();
			break;
		case "iOS":
			utils.log().info("Verify the Absence Duration Page");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		click(selectDuration);
	}

	public void substituteAssignPageVerification() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			isElementdisplayed(subAssignPageVerification);
			Assert.assertTrue("Create Absence Page 5 is not displayed", subAssignPageVerification.isDisplayed());
			utils.log().info("Create Absence Page 5 is displayed");
			break;
		case "iOS":
			utils.log().info("Subtitute page is displayed");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void submitAbsence() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			isElementdisplayed(reviewPageVerification);
			Assert.assertTrue("Create Absence Page 6 is not displayed", reviewPageVerification.isDisplayed());
			utils.log().info("Create Absence Page 6 is displayed");
			click(submitAbsence, "Click on submit absence");
			break;
		case "iOS":
			click(submitAbsence, "Click on submit absence");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void verifyAbsenceCreationPopup() {
		isElementdisplayed(createdAbsenceVerificationMsg);
		Assert.assertTrue("Create Absence pop up message is not displayed",
				createdAbsenceVerificationMsg.isDisplayed());
		utils.log().info("Create Absence pop up message is displayed");
	}

	public void viewAbsence() {
		if (common.isElementdisplayed(viewAbsence)) {
			click(viewAbsence, "Click on view Absence");
		} else {
			click(okay);
		}
	}

	public String getConfirmationForEmployee() {

		isElementdisplayed(confirmationNumber);
		confNumber = getElementText(confirmationNumber);
		return confNumber;
	}

	public void verifyAbsenceConfandDuration() {
		isElementdisplayed(confirmationNumber);
		Assert.assertTrue("Confirmation number is not displayed", confirmationNumber.isDisplayed());
		Assert.assertTrue("Half Day Duration is not displayed", getElementText(durationHalfDay).contains("Half Day"));
	}

	public void verifyAbsence() {
		if (isElementdisplayed(confirmationNumber)) {
			Assert.assertTrue("Confirmation number is not displayed", confirmationNumber.isDisplayed());
			utils.log().info("Confirmation number is displayed");
		} else {
			utils.log().info("Absence Created");
		}
	}

	public void selectAbsenceApprovalWidget() throws Throwable {
		common.scrollToElement(absenceApprovalwidget, "up");
		click(absenceApprovalwidget, "Clicked on Absence Approve Widget");
	}

	public void verifyAbsenceApprovalPage() {
		Assert.assertTrue("Absence approval page is not displayed", verifyAbsencePage.isDisplayed());
		utils.log().info("Absence approval page is displayed");
	}

	public void storeAbsenceDetails() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			absence_Ename = getElementText(employeeName);
			absence_day = getElementText(dayName);
			absence_month = getElementText(monthName);
			break;
		case "iOS":
			utils.log().info("Absence approval page is displayed");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void selectApproveConfirmAbsence() {
		approveBtnOnAbsence();
		clickonOkBtn();
	}

	public void clickonOkBtn() {
		isElementdisplayed(okBtn);
		click(okBtn, "Clicked on Ok Button");
	}

	public void approveBtnOnAbsence() {
		isElementdisplayed(approvebtn);
		click(approvebtn, "Cliked on Approve button");
	}

	public void verifyAcceptedAbsence() throws Exception {
		isElementdisplayed(verifyAbsencePage);
		Assert.assertTrue("Absence approval page is not displayed", verifyAbsencePage.isDisplayed());
		utils.log().info("Absence approval page is displayed");

		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			String name = getElementText(employeeName);
			String day = getElementText(dayName);
			String month = getElementText(monthName);
			Assert.assertTrue("Approved job still present in the approval list",
					!(absence_Ename == name && absence_day == day && absence_month == month));
			utils.log().info("Approved job removed from jobs list");
			break;
		case "iOS":
			utils.log().info("Approvals page is displayed");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clickOnSetting() throws Exception {
		clickOnMenuTab();
		settingOption();
	}

	public void settingOption() throws Exception {
		common.scrollToElement(settings, "up");
		Assert.assertTrue("Settings tab is not displayed", settings.isDisplayed());
		click(settings);
	}

	public void toggleDarkMode() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			Assert.assertEquals("OFF", getElementText(darkMode));
			break;
		case "iOS":
			Assert.assertEquals("0", getElementText(darkMode));
			break;
		default:
			throw new Exception("Invalid platform Name");
		}

		click(darkMode);
	}

	public void clickLogoutbtn() {
		isElementdisplayed(logoutBtn);
		click(logoutBtn, "logout btn");
	}

	public void verifytoggledDarkMode() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			Assert.assertEquals("ON", getElementText(darkMode));
			break;
		case "iOS":
			Assert.assertEquals("1", getElementText(darkMode));
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void screenshotCapture() throws IOException {
		Date d = new Date();
		String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File("screenshot/" + FileName));
	}

	public void pullToRefresh() {
		common.scrollDown();
	}

	public void clickOnAvailableLeaveBalance_displayed() throws Exception {
		common.scrollToElement(availableLeaveBalance, "up");
		Assert.assertTrue("Available Leave Balances is not displayed on Home page",
				availableLeaveBalance.isDisplayed());
		utils.log().info("Available Leave Balances is displayed on Home page");
		click(availableLeaveBalance);
		isElementdisplayed(availableLeaveBalanceHeader);
		Assert.assertTrue("Available Leave Balance page is not displayed", availableLeaveBalanceHeader.isDisplayed());
		utils.log().info("Available Leave Balance Page is displayed");
	}

	public void verify_availableDays() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			String leaveBalance = getElementText(availableDays);
			Assert.assertTrue("Available Leaves are invalid", Float.parseFloat(leaveBalance) >= 0);
			utils.log().info("Available Days are valid");
			break;
		case "iOS":
			isElementdisplayed(absenceBtn);
			Assert.assertTrue("Absence button is not displayed", absenceBtn.isDisplayed());
			utils.log().info("Absence button is displayed");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clickCreateAbs() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			scrolledToElement = androidScrollToElementUsingUiScrollable("text", "Create Absence");
			scrolledToElement.click();
			break;
		case "iOS":
			scrollToElement(createAbsBtn, "up");
			click(createAbsBtn);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clickOnFeedback() {
		click(backBtn,"Clicked on back button");
		clickOnMenuTab();
		clickOnFeedbackOption();
	}

	public void clickOnMenuTab() {
		Assert.assertTrue("Menu tab is not displayed", menuTab.isDisplayed());
		click(menuTab, "Clicked on Menu Tab");
	}

	public void clickOnFeedbackOption() {
		Assert.assertTrue("Feedback tab is not displayed", feedback.isDisplayed());
		click(feedback,"Clicked on feedback button");
	}

	public void sendFeedback() throws Exception {
		isElementdisplayed(topic);
		Assert.assertTrue("Topic tab is not displayed", topic.isDisplayed());
		click(topic,"Clicked on Feedback Topic");
		isElementdisplayed(itemsInDropDown.get(1));
		click(itemsInDropDown.get(1),"Clicked on Feedback dropdown");
		sendFeedbackTitle();
		sendFeedbackMessage();
	}

	public void sendFeedbackTitle() {
		Assert.assertTrue("Title tab is not displayed", title.isDisplayed());
		sendKeys(title, "Automation Test");
	}

	public void sendFeedbackMessage() {
		Assert.assertTrue("message tab is not displayed", message.isDisplayed());
		click(message,"Clicked on Message tab of Feedback");
		driver.getKeyboard().sendKeys("This is a Test message");
		click(saveBtn, "Click on Save Button");
	}

	public void clickInbox() {
		Assert.assertTrue("Inbox tab is not displayed", inboxTab.isDisplayed());
		click(inboxTab,"Click on Inbox");
	}

	public void verifyInboxPage() throws Exception {
		isElementdisplayed(inboxTab);
		Assert.assertTrue("Inbox page is not displayed", inboxTab.isDisplayed());
		utils.log().info("Inbox page is displayed");
	}

	public void viewText() {
		String msg = getElementText(inboxMsg).trim();
		click(inboxMsg,"Clicked on Inbox Message");
		Assert.assertEquals(msg, getElementText(msgData));
		Assert.assertEquals(getElementText(msgData), "Smoke Test Case of inbox");
		utils.log().info("MEssage is displayed");
	}

	public void selectUnfilledAbsence() throws Exception {
		scrollToElement(unfilledAbsence, "up");
		Assert.assertTrue("No Unfilled Absence is present", unfilledAbsence.isDisplayed());
		utils.log().info("Unfilled Absence is present");
		click(unfilledAbsence,"Clicked on unfilled Absence");
	}

	public void click_tapToAssign() {
		isElementdisplayed(assignSubstitute);
		click(assignSubstitute,"Clicked on Assign Substitute");
	}

	public void assignSubstitute() {
		isElementdisplayed(selectSubstitute);
		Assert.assertTrue("Select substitute btn is not displayed", selectSubstitute.isDisplayed());
		click(selectSubstitute,"Clicked on Select Substitute");
	}

	public void confirmAssignSubstitute() {
		isElementdisplayed(confirmAssignSub);
		Assert.assertTrue("Confirm substitute btn is not displayed", confirmAssignSub.isDisplayed());
		click(confirmAssignSub,"Clicked on Confirm Assign Substitute");
	}

	public void clickTimesheetWidget() throws Throwable {

		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			scrolledToElement = androidScrollToElementUsingUiScrollable("text", "Timesheets");
			scrolledToElement.click();
			utils.log().info("Clicked on Timesheet button");
			break;
		case "iOS":
			common.scrollToElement(timesheetsbtn, "up");
			click(timesheetsbtn, "Clicked on Timesheet button");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void verifySubmitTimesheetBtn() {
		isElementdisplayed(submittimesheetsbtn);
		Assert.assertTrue("Submit timesheet option is not displayed", submittimesheetsbtn.isDisplayed());
	}

	public void submitTimesheet() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			isElementdisplayed(tuesday);
			totalExpectedTimeofWeek = getElementText(totalWeekTotalAmount);
			utils.log().info("Total Expected time of the week = "+totalExpectedTimeofWeek);
			break;
		case "iOS":
			isElementdisplayed(addTimeSheets);
			totalExpectedTimeofWeek = getElementText(totalWeekTotalAmount);
			utils.log().info("Total Expected time of the week = "+totalExpectedTimeofWeek);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		verifySubmitTimesheetBtn();
		click(submittimesheetsbtn, "Clicked on submit timesheet button");
	}

	public void verifySubmitTimesheet() {
		Assert.assertTrue("Timesheet button not displayed", submitTimesheet.isDisplayed());
		utils.log().info("Timesheet button displayed");
	}

	public void enterTimeSheetdetails() {
		Assert.assertTrue("Total timesheet  time is not same while submitting",
				getElementText(totalWeekTimeExpected).contains(totalExpectedTimeofWeek));
		if (isElementdisplayed(enterPin)) {
			sendKeys(enterPin, testdata.read_property("testingData", "users", "AccountingPin"));
			hideKeyboard();
			click(checkbox, "Clicked on PIN checkbox");
		} else {
			utils.log().info("Digital signature not displayed");
		}
		click(submitTimesheet,"Clicked on submit submit timesheet");
	}

	public void undoTimesheet() throws Exception {
		verifyUndoBtn();
		click(undoicon,"Clicked on undo timesheet icon");
		click(undobtn,"Clicked on undo button");
	}

	public void verifyUndoBtn() {
		isElementdisplayed(undoSubmission);
		Assert.assertTrue("Undo timesheet option is not displayed", undoSubmission.isDisplayed());
		utils.log().info("Undo timesheet option is not displayed");
	}

	public void verifyUndo() {
		isElementdisplayed(declinebtn);
		click(declinebtn,"Clicked on undo decline button");
		verifySubmitTimesheetBtn();
		utils.log().info("Submit timesheet option is not displayed");
	}

	// change sendkeys method here
	// MOB-4233 //MOB-4234
	public void enterSearchText(String searchText) {
		isElementdisplayed(searchBar);
		Assert.assertTrue("search Bar option is not displayed", searchBar.isDisplayed());
		searchResultText = searchText;
		utils.log().info("Searched text is : " + searchResultText);
		click(searchBar,"Clicked on Search Bar");
		clearTextField(searchBar);
		sendKeys(searchBar, searchText);
	}

	public void clickOnResult() {
		Assert.assertTrue("search Result option is not displayed", searchResult.isDisplayed());
		click(searchResult, "Click on Search Result");
	}

	public void verifySearchResult() throws Exception {
		isElementDisplayed(calendar);
		Assert.assertTrue("calendar is not displayed", calendar.isDisplayed());
		Assert.assertTrue("Entered text does not match", getElementText(calendar).equalsIgnoreCase(searchResultText));
		utils.log().info("Entered text matches with result");
	}

	public void clickReorderWidget() {
		click(reOrderWidgetbtn);
	}

	public void draganddrop() throws Throwable {
		TouchAction action = new TouchAction(driver);
		int dragX = dragableEle.getLocation().x + (dragableEle.getSize().width / 2);
		int dragY = dragableEle.getLocation().y + (dragableEle.getSize().height / 2);
		action.press(PointOption.point(dragX, dragY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(dragX, dragY + 400)).release().perform();
	}

	public void saveReorderedWidget() {
		click(saveOrderWidgetbtn);
	}

	public void verifyWidgetsOrder() {
		Assert.assertNotEquals(widgetlistbeforeReorder, widgetlistafterReorder);
	}

	public void viewWeekTimesheets() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			clickTimesheetWidget();
			verifyMonday();
			verifyTuesday();
			verifyWednesday();
			verifyThrusday();
			verifyFriday();
			verifySaturday();
			verifySunday();
			utils.log().info("Timesheets for entire week is displayed");
			break;
		case "iOS":
			clickTimesheetWidget();
			utils.log().info("Timesheets for entire week is displayed");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void verifyMonday() {
		common.isElementdisplayed(monday);
		Assert.assertTrue("Monday timesheet is not displayed", monday.isDisplayed());
	}

	public void verifySunday() {
		common.isElementdisplayed(sunday);
		Assert.assertTrue("Sunday timesheet is not displayed", sunday.isDisplayed());
	}

	public void verifySaturday() {
		common.isElementdisplayed(saturday);
		Assert.assertTrue("Saturday timesheet is not displayed", saturday.isDisplayed());
	}

	public void verifyTuesday() {
		common.isElementdisplayed(tuesday);
		Assert.assertTrue("Tuesday timesheet is not displayed", tuesday.isDisplayed());
	}

	public void verifyWednesday() {
		common.isElementdisplayed(wednesday);
		Assert.assertTrue("Wednesday timesheet is not displayed", wednesday.isDisplayed());
	}

	public void verifyThrusday() {
		common.isElementdisplayed(thursday);
		Assert.assertTrue("Thursday timesheet is not displayed", thursday.isDisplayed());
	}

	public void verifyFriday() {
		common.isElementdisplayed(friday);
		Assert.assertTrue("Friday timesheet is not displayed", friday.isDisplayed());
	}

	public void clickOnFriday() {
		common.isElementdisplayed(friday);
		click(friday,"Click on Friday");
	}

	public void viewDayTimesheets() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			clickOnFriday();
			common.isElementdisplayed(commonDayTotal);
			Assert.assertTrue("Timesheet for the day is not displayed", commonDayTotal.isDisplayed());
			utils.log().info("Timesheets for the day is displayed");
			break;
		case "iOS":
			common.isElementdisplayed(selectDayToFillTimesheet);
			click(selectDayToFillTimesheet,"Clicked on the day to fill the Timesheet");
			utils.log().info("Timesheets for the day is displayed");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void addTimeSheet() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			selectCurrentDayForTimesheet();
			click(addTimeSheets);
			common.isElementdisplayed(workDetails);
			Intime = common.getElementText(timeSheetInTime);
			click(timeSheetOutTime,"Clicked on Timesheet Out Time");
			click(okBtn,"Click on Ok Button");
			click(saveTimesheets,"Click on SaveTime");
			break;
		case "iOS":
			common.isElementdisplayed(selectDayToFillTimesheet);
			click(selectDayToFillTimesheet,"Click on day to fill the timesheet");
			click(addTimeSheets,"Click on Add Timesheet option");
			common.isElementdisplayed(workDetails);
			clickonEditButton2();
			clickOnEditBtton3();
			Intime = common.currentTime();
			click(saveTimesheets,"Click on Save Timesheets button");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void editTimeCommentToTimesheet() throws Throwable {
		timeEntryEditBtnClick();
		common.isElementdisplayed(workDetails);
		sendKeys(inTimeComment, "Automation Smoke Test");

		switch (new GlobalParams().getPlatformName()) {
			case "Android":
				Intime = common.getElementText(timeSheetInTime);
				click(saveTimesheets);
				break;
			case "iOS":
				click(saveButton);
				if (isElementdisplayed(declinebtn)) {
					click(declinebtn);
				}

				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	public void verifyEditedComment() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
		isElementDisplayed(timeSheetTimeEventPage);
		click(backBtn,"Click on Back button");
		goToEditDeleteTimeSheetOption();
		Assert.assertEquals(getElementText(inTimeCommentVerify), "Automation Smoke Test");
		break;
			case "iOS":
				isElementDisplayed(timeSheetTimeEventPage);
				goToEditDeleteTimeSheetOption();
				Assert.assertEquals(getElementText(inTimeCommentVerify), "Automation Smoke Test");
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	public void clickOnEditBtton3() {
		click(timeInEdit3,"Clicked on In Time Edit button");
		click(Done,"Click on Done button");
	}

	public void goToEditDeleteTimeSheetOption() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
		//	isElementdisplayed(dailytimeSheetsubmitbtn);
			isElementdisplayed(eventSummary);
			assertTimeEvent(Intime);
			scrolledToElement.click();
			break;
		case "iOS":
			common.isElementdisplayed(dailytimeSheetsubmitbtn);
			click(timeSheetInTime,"Clicked on In Time Edit button");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}
	
	public void editTimesheetForClockOut() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			timeEntryEditBtnClick();
			common.isElementdisplayed(workDetails);
			click(timeSheetOutTime,"Clicked on Timesheet out time");
			click(okBtn,"Clicked on Ok Button ");
			outTime = getElementText(timeSheetOutTime);
			click(saveTimesheets,"Clicked on Save Timesheet button");
			break;
		case "iOS":
			timeEntryEditBtnClick();
			clickonEditButton1();
			clickonEditButton2();
			AddTextonCommentSection();
			click(saveButton,"Clicked on Save Timesheet button");
			if (isElementdisplayed(declinebtn)) {
				click(declinebtn,"Clicked on Decline button");
			}
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clickonEditButton1() {
		click(timeInEdit1, "Clicked on In Time edit button");
		click(Done,"Click on Done button");
	}

	// change sendkeys
	public void AddTextonCommentSection() {
		sendKeys(commentBox, "Checking Edit Functionality");
	}

	public void clickonEditButton2() {
		click(timeInEdit2,"Clicked on In Time Edit button ");
		click(Done,"Clicked on Done Button");
	}

	public void timeEntryEditBtnClick() {
		click(dailytimeSheetedittbtn,"Clicked on Daily Timesheet Edit Button");
	}

	public void clickOnDeleteTimesheet() {
		common.isElementdisplayed(timeSheetDeletebtn);
		click(timeSheetDeletebtn,"Clicked on Timesheet Delete Button");
	}

	public void deleteTimesheet() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			common.isElementDisplayed(dailytimeSheetedittbtn);
			clickOnDeleteTimesheet();
			click(okBtn,"Clicked on Ok Button");
			break;
		case "iOS":
			if (isElementdisplayed(timeSheetInTime)) {
				click(timeSheetInTime,"Clicked on Timesheet In Time");
			}
			if (isElementdisplayed(PushNotificationOK)) {
				click(PushNotificationOK,"Clicked ok button on Push Notification confirmation popup");
			}
			isElementdisplayed(dailytimeSheetedittbtn);
			click(timeSheetDeletebtn,"Click on Timesheet Delete button");
			click(okay,"Click on Ok button ");
			isElementdisplayed(dailytimeSheetsubmitbtn);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void click_searchResult() {
		click(searchAbsReason,"Clicked on Absence Reason Search Result");
	}

	public void verifyAbsenceDetailPage() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			isElementDisplayed(confirmationNumber);
			break;
		case "iOS":
			utils.log().info("Absence Page is displayed");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		Assert.assertTrue("confirmation Number Page is not displayed", confirmationNumber.isDisplayed());
		Assert.assertTrue("Absence Detail Page Substitute is not displayed", absenceDetailPageSubstitute.isDisplayed());
		Assert.assertTrue("Absence Details Page is not displayed", absenceDetailPageApproval.isDisplayed());
		utils.log().info("Absence Details Page is displayed");
	}

	public void verify_footerPresent() {
		isElementdisplayed(homeTab);
		isElementdisplayed(menuTab);
		isElementdisplayed(inboxTab);
		Assert.assertTrue("Footers are not displayed",
				homeTab.isDisplayed() && menuTab.isDisplayed() && inboxTab.isDisplayed());
		utils.log().info("Footers are present");
	}

	public void getAbsenceDetailsForCalendar() throws Throwable {
		isElementDisplayed(getdate);
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			absence_day = getElementText(getdate).substring(9);
			absence_month = getElementText(getdate).substring(5, 8);
			absenceDuration = getElementText(durationHalfDay);
			click(homeTab,"Clicked on Home button");
			if (isElementdisplayed(declinebtn))
				click(declinebtn,"Click on decline button");
			pullToRefresh();
			break;
		case "iOS":
			absence_day = getElementText(getdate).substring(8);
			absence_month = getElementText(getdate).substring(4, 7);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clickOnHomeButtonFooter() {
		Assert.assertTrue("Footer fails to display", homeBtnFooter.isDisplayed());
		click(homeBtnFooter,"Click on Home button from footer");
	}

	public void clickOnSeachResult() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			Assert.assertTrue("search Result fails to display", searchResult.isDisplayed());
			click(searchResult,"Click on search Result");
			break;
		case "iOS":
			isElementDisplayed(calendartitle);
			Assert.assertTrue("search Result fails to display", calendartitle.isDisplayed());
			click(calendartitle,"Click on calendar Title");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clickCalender() throws Exception {
		verifyEventInCalendar(absence_day, absence_month);
	}

	public void verifyEventInCalendar(String absence_day, String absence_month) throws Exception {
		click(menuTab,"Click on Menu Tab");
		clickOnSeachResult();
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			isElementdisplayed(calendartitle);
			for (int i = 0; i < 12; i++) {
				if (!getElementText(calendartitle).contains(absence_month)) {
					click(nextMonthCalendar);
					isElementdisplayed(calendartitle);
				} else
					break;
			}
			driver.findElementByXPath("//android.widget.TextView[contains(@content-desc,'" + absence_day + "')]")
					.click();

			break;
		case "iOS":
			isElementdisplayed(monthVerify);
			String monthName = monthVerify.getAttribute("name").toString();
			for (int i = 0; i < 12; i++) {
				if (!monthName.contains(absence_month)) {
					click(nextMonthCalendar,"Click on next Month Calendar");
					common.isElementdisplayed(calendar);
				}
			}
			driver.findElementByXPath("//XCUIElementTypeCell[contains(@name, '" + absence_day + "')]").click();
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		clickOnEvent();
	}

	public void clickOnEvent() throws Exception {
		common.isElementdisplayed(eventTitle);
		click(eventTitle,"Clicked on Event Title");
	}

	public void selectDateForEdit(String absenceDay) throws Throwable {
		verifyAsbsenceDatePage();
		nextWorkingDate = nextWorkingDay(absenceDay, "MMMM dd, yyyy");
		scrolledToElement = androidScrollToElementUsingUiScrollable("description", nextWorkingDate);
		scrolledToElement.click();
	}

	public void editCreatedAbsence(String absenceDay) throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			isElementdisplayed(editTab);
			click(editTab,"Click on edit tab");
			verifyAsbsenceReasonPage();
			clickNext();
			selectDateForEdit(absenceDay);
			clickNext();
			break;
		case "iOS":
			isElementdisplayed(editTab);
			click(editTab,"Click on Edit Tab");
			isElementdisplayed(absenceReasonVerification);
			clickNext();
			isElementdisplayed(datePageVerification);
			clickNext();
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void saveEditedAbsence() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			verifyAsbsenceDuratioPage();
			click(halfDayDuration,"Click on half Day Duration");
			clickNext();
			substituteAssignPageVerification();
			clickNext();
			break;
		case "iOS":
			isElementdisplayed(durationPageVerification);
			click(halfDayDuration,"Click on half Day Duration");
			clickNext();
			isElementdisplayed(subAssignPageVerification);
			clickNext();
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		isElementdisplayed(saveChanges);
		click(saveChanges,"Click on Save changes button");
		click(viewAbsence,"Click on view Absence");
	}

	public void allowClockInOutAcessPermissions() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			isElementdisplayed(permissionGrantbtn);
			click(permissionGrantbtn,"Click on permission Grant button");
			isElementdisplayed(permissionGrantonlyForApp);
			click(permissionGrantonlyForApp,"Click on permission Grant button only for app");
			break;
		case "iOS":
			click(permissionGrantbtn,"Click on permission Grant button");
			click(permissionGrantonlyForApp,"Click on permission Grant button only for app");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clockInbtn() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
		click(clockInbtn,"Clicked on In Time button");
		isElementdisplayed(clockedInVerification);
		break;
			case "iOS":
				click(clockInbtn,"Clicked on Clock In Button");
				isElementdisplayed(clockedOutBtn);
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	public void clickClockOut() throws Throwable {
		scrolledToElement = androidScrollToElementUsingUiScrollable("text", "Clock Out");
		scrolledToElement.click();
	}

	public void clockInVerification() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
		 if (isElementdisplayed(clockInbtn)) {
			click(clockInbtn,"Click on Clock In button");
			allowClockInOutAcessPermissions();
			clockInbtn();
		} else if (isElementdisplayed(clockedInVerification)) {
			clickClockOut();
			allowClockInOutAcessPermissions();
			clickClockOut();
			Thread.sleep(45000);
			isElementdisplayed(clockInbtn);
			Thread.sleep(30000);
			isElementdisplayed(clockInbtn);
			clockInbtn();
		}
      break;
			case "iOS":
				common.scrollToElement(ScrollToClockInbtn,"up");
				if (isElementdisplayed(clockInbtn)) {
					click(clockInbtn,"Click on Clock In button");
					allowClockInOutAcessPermissions();
				} else if (isElementdisplayed(clockedOutBtn)) {
					click(clockedOutBtn,"Click on Clocked out button");
					allowClockInOutAcessPermissions();
					click(clockedOutBtn,"Click on Clock out button");
					Thread.sleep(45000);
					isElementdisplayed(clockInbtn);
					Thread.sleep(30000);
					isElementdisplayed(clockInbtn);
				}
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	public void selectCurrentDayForTimesheet() throws Exception {
		nextWorkingDate = nextWorkingDay("current day", "M/dd");
		isElementdisplayed(monday);
		driver.findElementByXPath("//android.widget.TextView[contains(@text,'" + nextWorkingDate + "')]").click();
	}

	public void clockOutThroughTimesheet() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			Intime = common.getElementText(clockedInTime).substring(1);
			clickTimesheetWidget();
			selectCurrentDayForTimesheet();
			isElementdisplayed(eventSummary);
			assertTimeEvent(Intime);
			 scrolledToElement = androidScrollToElementUsingUiScrollable("text", Intime);
			scrolledToElement.click();
			editTimesheetForClockOut();
			break;
		case "iOS":
			utils.log().info("No need to go timesheet section");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void assertTimeEvent(String time) throws Throwable {
		scrolledToElement = androidScrollToElementUsingUiScrollable("text", time);
		Assert.assertTrue("Required Time Event is visible ",
				driver.findElementByXPath("//android.widget.TextView[contains(@text,'" + time + "')]").isDisplayed());

	}

	public void verifyClockOut() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
		isElementdisplayed(timeSheetTimeEventPage);
		click(backBtn,"Click on back button");
		isElementdisplayed(eventSummary);
		assertTimeEvent(outTime);
		click(homeTab,"Click on Home Tab");
		isElementdisplayed(clockInbtn);
		Assert.assertTrue("Didnt not get Clocked out", clockInbtn.isDisplayed());
		utils.log().info("Clocked out successfully");
		break;
			case "iOS":
				isElementdisplayed(clockInbtn);
				click(clockInbtn,"Click on Clock In Button");
				Thread.sleep(45000);
				isElementdisplayed(clockedOutBtn);
				common.scrollToElement(clockedOutBtn, "up");
				Thread.sleep(45000);
				click(clockedOutBtn,"Click on Clocked out button");
				isElementdisplayed(clockInbtn);
				Assert.assertTrue("Didnt not get Clocked out", clockInbtn.isDisplayed());
				utils.log().info("Clocked out successfully");
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	// MOB-4277
	public void selectOrganization() {
		common.isElementdisplayed(peopleWidgetOrg);
		click(peopleWidgetOrg,"Click on People Widget");
		click(jobs.contbtn,"Click on Jobs count button");
	}

	public void clickPeopleWidget() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
		scrolledToElement = androidScrollToElementUsingUiScrollable("text", "People");
		scrolledToElement.click();
		Assert.assertTrue("People Widget is not displayed", PeopleWidget.isDisplayed());
		utils.log().info("People Widget is displayed");
		click(PeopleWidget,"Click on people widget");
				break;
			case "iOS":
				scrollToElement(PeopleWidget, "up");
				click(PeopleWidget,"Click on People Widget");
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	public void SerachName(String lastName) throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			common.isElementdisplayed(PeopleWidget);
			sendKeys(SearchPeople, lastName);
			hideKeyboard();
			By searchedEmployee = By.xpath("//android.widget.TextView[contains(@text,'" + lastName + "')]");
			common.scrollToElement(searchedEmployee, "up");
			common.click(searchedEmployee, "Clicking on searched Employee");
			break;
		case "iOS":
			sendKeys(serachEditText, lastName);
			click(SearchPeople,"Click on search People");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void verifyContactDetails() {
		Assert.assertTrue("Work Phone is not displayed", (// WorkPhone.isDisplayed() ||
															// getElementText(WorkPhoneData).length() > 0 ||
															 fullEmployeeName.isDisplayed()||
		WorkEmail.isDisplayed() || getElementText(WorkEmailData).length() > 0)
				// || OtherPhone.isDisplayed()|| getElementText(OtherPhoneData).length() > 0
				|| PersonalPhone.isDisplayed() || getElementText(PersonalPhoneData).length() > 0
				|| PersonalEmail.isDisplayed() || getElementText(PersonalEmailData).length() > 0);
		utils.log().info("Details are displayed");
	}

	public void logoutApplication() {
		clickOnMenuTab();
		click(settings,"Click on Settings option");
		clickLogoutbtn();
	}

	public void verifyAbsencesPage() {
		isElementdisplayed(AbsencePageHeader);
		Assert.assertTrue("Absences page is not displayed", AbsencePageHeader.isDisplayed());
		utils.log().info("Absences page is not displayed");
	}

	public void clickOnBack() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			click(backBtn,"Click on Back button");
			break;
		case "iOS":
			click(week,"Click on week");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public WebElement androidScrollToElementUsingUiScrollable(String attributeType, String attributeText)
			throws Throwable {
		switch (attributeType.toLowerCase()) {
		case "description":
			return ((AndroidDriver) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().descriptionContains(\""
							+ attributeText + "\").instance(0))");

		case "resouceid":
			return ((AndroidDriver) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""
							+ attributeText + "\").instance(0))");

		case "classname":
			return ((AndroidDriver) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().className(\""
							+ attributeText + "\").instance(0))");

		case "text":
			return ((AndroidDriver) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ attributeText + "\").instance(0))");
		default:
			throw new Exception("Invalid platform Name");
		}

	}

	public void getAbsenceDateForCalendar(String absenceDay) throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			nextWorkingDate = nextWorkingDay(absenceDay, "MMMM dd, yyyy");
			break;
		case "iOS":
			nextWorkingDate = nextWorkingDay(absenceDay, "MM/dd/yyyy");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		verifyEventInCalendar(nextWorkingDate, nextWorkingDay(absenceDay, "MMMM dd, yyyy").split(" ")[0]);
	}

	public void selectUnfilledUnassignedAbsence(String userToSearch, String absenceDay) throws Throwable {
		nextWorkingDate = nextWorkingDay(absenceDay, "MMMM d, yyyy");
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
//			for (int i = 0; i < 3; i++) {
//				if (!getElementText(selectDayOFUnfilledUnassignedAbsence).equalsIgnoreCase(nextWorkingDate))
//					click(traverseToNextDay);
//				else
//					break;
//			}
			waitFortheSpinner1();
			scrolledToElement = androidScrollToElementUsingUiScrollable("text", userToSearch);
			scrolledToElement.click();

			break;
		case "iOS":
			nextWorkingDate = nextWorkingDate.split(" ", 2)[1];
//			for (int i = 0; i <= 3; i++) {
//				if (!getElementText(selectDayOFUnfilledUnassignedAbsence).contains(nextWorkingDate)) {// Assert.assertEquals(getElementText(selectDayOFUnfilledUnassignedAbsence),dateAndroid);
//					click(traverseToNextDay);
//				} else
//					break;
//			}
			By unfilledabsenceDate = By.xpath("//XCUIElementTypeStaticText[@name = '" + userToSearch + "']");
			scrollToElement(unfilledabsenceDate, "up");
			click(unfilledabsenceDate, "Clicked on Unfilled Absence Date");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void waitFortheSpinner1() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//android.widget.ProgressBar[@content-desc='Progress_Bar']")));
	}

	public LinkedHashSet<String> getTheOrderListByScrolling(MobileElement elementTill, String direction,
			List<MobileElement> collectListOf) throws Exception {
		LinkedHashSet<String> listOfElementByScrolling = new LinkedHashSet<String>();
		Dimension size = driver.manage().window().getSize();
		int startX = (int) (size.width * 0.5);
		int endX = (int) (size.width * 0.5);
		int startY = 0;
		int endY = 0;
		boolean isFound = false;

		switch (direction) {
		case "up":
			endY = (int) (size.height * 0.4);
			startY = (int) (size.height * 0.6);
			break;

		case "down":
			endY = (int) (size.height * 0.6);
			startY = (int) (size.height * 0.4);
			break;
		}

		for (int i = 0; i < 10; i++) {
			for (MobileElement mobElement : collectListOf) {
				listOfElementByScrolling.add(common.getElementText(mobElement));
			}
			if (find(elementTill, 1)) {
				isFound = true;
				break;
			} else {
				swipe(startX, startY, endX, endY, 1000);
			}
		}
		if (!isFound) {
			throw new Exception("Element not found");
		}
		return listOfElementByScrolling;

	}

	public void getListOrderBeforeReorder() throws Throwable {
		widgetlistbeforeReorder = new ArrayList<String>(
				getTheOrderListByScrolling(reOrderWidgetbtn, "up", widgetListFromDashboard));
	}

	public void getListOrderAfterReorder() throws Throwable {
		widgetlistafterReorder = new ArrayList<String>(
				getTheOrderListByScrolling(reOrderWidgetbtn, "up", widgetListFromDashboard));
	}

	public void weekTotalTime() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
		isElementdisplayed(monday);
		int hours = 0;
		int minutes = 0;
		DecimalFormat formatter = new DecimalFormat("00");

		for (MobileElement mobElement : dayTotalTime) {
			hours = hours + Integer.parseInt(getElementText(mobElement).split(":")[0]);
			minutes = minutes + Integer.parseInt(getElementText(mobElement).split(":")[1]);
		}
		hours = hours + (minutes/60);
		minutes = minutes%60;
		totalExpectedTimeofWeek = hours + ":" +formatter.format(minutes);
		break;
			case "iOS":
				totalExpectedTimeofWeek = getElementText(totalWeekTotalAmount);
			break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	public void verifyWeekTotalTime() {
		Assert.assertEquals(getElementText(totalWeekTotalAmount), totalExpectedTimeofWeek);
	}
}
