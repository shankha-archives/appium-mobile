package mobile.frontline.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestUtils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SmokeMethods extends LoginPage {

	TestUtils utils = new TestUtils();
	BasePage common = new BasePage();
	LoginPage loginPage = new LoginPage();
	JobsMethods jobPage = new JobsMethods();
	String cdate;

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
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='*Personal']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='*Personal']")
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
	@AndroidFindBy(xpath = "//android.widget.Switch[@text='OFF']")
	@iOSXCUITFindBy(accessibility = "darkMode")
	public MobileElement darkMode;

	// create absence btn //click
	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'Create Absence']")
	@iOSXCUITFindBy(accessibility = "AbsencesThisYearModule_Schedule_Button")
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
	@iOSXCUITFindBy(accessibility = "Inbox_TabBar_Button")
	public MobileElement inboxTab;

	// click on inbox message
	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/inbox_notification_snippet_text")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='FLAlertView_Table']/XCUIElementTypeCell")
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
	// @iOSXCUITFindBy(accessibility = "AbsenceDetailBaseView_Tap to
	// Assign_StaticText")
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

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'AbsReason')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'AbsReason')][1]")
	public MobileElement searchAbsReason;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Substitute']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Substitute']")
	public MobileElement absenceDetailPageSubstitute;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Approval Status']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Approval Status']")
	public MobileElement absenceDetailPageApproval;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/widget_name")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, '')]")
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
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement timeSheetOutTime;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/delete_event_button")
	@iOSXCUITFindBy(accessibility = "Delete Event")
	public MobileElement timeSheetDeletebtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Time Event']")
	// @iOSXCUITFindBy(accessibility = "")
	public MobileElement timeSheetTimeEventPage;

//	@AndroidFindBy(className = "android.widget.ImageButton")
//	@iOSXCUITFindBy(accessibility = "Done")
//	public MobileElement backButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='AbsReason_2']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='AbsReason_1']")
	public MobileElement absenceReason;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/shift_type_time_absent")
	@iOSXCUITFindBy(accessibility = "Time_Absence_TextField")
	public MobileElement absenceshifttime;

	@AndroidFindBy(xpath = "//android.widget.TextView")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[4]")
	public MobileElement getdate;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_title")
	@iOSXCUITFindBy(accessibility = "Calendar_MenuOption")
	public MobileElement calendertitle;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_event_cell_line_two")
	@iOSXCUITFindBy(accessibility = "EventView_Absence_Other")
	public MobileElement eventTitle;

	// page 6 verification
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Substitute']")
	// @iOSXCUITFindBy(accessibility = "Create Absence")
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
	@iOSXCUITFindBy(accessibility = "Edit")
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

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/location_services_permit_access_button")
	@iOSXCUITFindBy(accessibility = "Enable Location Services")
	public MobileElement permissionGrantbtn;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	@iOSXCUITFindBy(accessibility = "Allow Once")
	public MobileElement permissionGrantonlyForApp;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/widget_header_right_bubble")
	@iOSXCUITFindBy(accessibility = "Clock Out")
	public MobileElement clockedInVerification;

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

	@AndroidFindBy(xpath = "(//android.widget.TextView) [4]")
	@iOSXCUITFindBy(accessibility = "Other Phone")
	public MobileElement OtherPhone;

	@AndroidFindBy(xpath = "(//android.widget.TextView) [5]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[3]")
	public MobileElement OtherPhoneData;

	@AndroidFindBy(xpath = "(//android.widget.TextView) [6]")
	@iOSXCUITFindBy(accessibility = "Personal Phone")
	public MobileElement PersonalPhone;

	@AndroidFindBy(xpath = "(//android.widget.TextView) [7]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[4]")
	public MobileElement PersonalPhoneData;

	@AndroidFindBy(xpath = "(//android.widget.TextView) [8]")
	@iOSXCUITFindBy(accessibility = "Work Phone")
	public MobileElement WorkPhone;

	@AndroidFindBy(xpath = "(//android.widget.TextView) [9]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[5]")
	public MobileElement WorkPhoneData;

	@AndroidFindBy(xpath = "(//android.widget.TextView) [10]")
	@iOSXCUITFindBy(accessibility = "Work Email")
	public MobileElement WorkEmail;

	@AndroidFindBy(xpath = "(//android.widget.TextView) [11]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[6]")
	public MobileElement WorkEmailData;

	@AndroidFindBy(xpath = "(//android.widget.TextView) [12]")
	@iOSXCUITFindBy(accessibility = "Personal Email")
	public MobileElement PersonalEmail;

	@AndroidFindBy(xpath = "(//android.widget.TextView) [12]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[7]")
	public MobileElement PersonalEmailData;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile App Testing District (Absence Only)']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'Absence Only')]")
	public MobileElement peopleWidgetOrg;

//	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/welcomeRoleName")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther//XCUIElementTypeStaticText[2]")
//	public MobileElement homePageRoleHeader;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/calendar_right_button_image")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='DatePicker_RightTapArea_Other']")
	public MobileElement nextMonthCalender;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeStaticText)[2]")
	public MobileElement monthVerify;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/log_out_button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
	public MobileElement logoutBtn;

  @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	@iOSXCUITFindBy(accessibility = "Home")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
	@iOSXCUITFindBy(accessibility = "Home_TabBar_Button")
	public MobileElement homeBtnFooter;

	@iOSXCUITFindBy(accessibility = "Week")
	public MobileElement week;
	
	public String absence_Ename;
	public String absence_day;
	public String absence_month;
	public String searchResultText;
	public String Intime;
	ArrayList<String> widgetlistbeforeReorder = new ArrayList<String>();
	ArrayList<String> widgetlistafterReorder = new ArrayList<String>();

	public SmokeMethods() {
	}

	public void selectAbsenceWidget() throws Exception {
		common.scrollToElement(absenceWidget, "up");
		click(absenceWidget);
	}

	public void addAbsence() {
		isElementdisplayed(addAbsence);
		click(addAbsence);
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

		serachEditText.click();
		driver.getKeyboard().sendKeys(teacher);
	}

	public void selectTeachersName(String teacher) throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			common.isElementdisplayed(selectReqName);
			selectReqName.click();
			common.isElementdisplayed(whoAbsencePageWaittoClickCaret);
			break;
		case "iOS":
			//common.isElementdisplayed(whoAbsencePageWaittoClickCaret);
			driver.findElementByXPath("//XCUIElementTypeButton[contains(@name, '" + teacher + "')]").click();
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clickNext() {
		common.isElementClickable(forwardCaret);
		forwardCaret.click();
	}

	public void selectLocation() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			isElementdisplayed(selectLocation);
			click(selectLocation);
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
			if (isElementdisplayed(reason)) {
				click(reason);
			} else {
				click(absenceReason);
			}
			break;
		case "iOS":
			if (isElementClickable(reason)) {
				click(reason);
			} else {
				click(absenceReason);
			}
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

	public String currentDateTimesheet() throws Exception {
		DateTimeFormatter dtf;
		dtf = DateTimeFormatter.ofPattern("M/dd");
		return dtf.format(LocalDateTime.now());
	}
	
	public String currentDate() throws Exception {
		DateTimeFormatter dtf;
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			dtf = DateTimeFormatter.ofPattern("dd, yyyy");
			break;
		case "iOS":
			dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		return dtf.format(LocalDateTime.now());
	}

	public String nextDate(String date) throws Exception {
		SimpleDateFormat dateFormat;
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			dateFormat = new SimpleDateFormat("dd, yyyy");
			break;
		case "iOS":
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(dateFormat.parse(date));
		c.add(Calendar.DAY_OF_MONTH, 1);
		String newDate = dateFormat.format(c.getTime());
		return newDate;
	}

	public void selectDate() throws Throwable {
		Calendar cal = Calendar.getInstance();
		int res = cal.getActualMaximum(Calendar.DATE);
		String cdate = currentDate();
		String nd = nextDate(cdate);
		MobileElement date;
		String tagName;
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			verifyAsbsenceDatePage();
			date = driver.findElementByXPath("//android.widget.TextView[contains(@content-desc, '" + nd + "')]");
			tagName = date.getAttribute("content-desc").toString();
			while (tagName.contains("Saturday") || tagName.contains("Sunday") || tagName.contains("This day has one")) {
				nd = nextDate(nd);
				date = driver.findElementByXPath("//android.widget.TextView[contains(@content-desc, '" + nd + "')]");
				if (nd.contains(Integer.toString(res))) {
					common.swipeUpSlowly();
					common.swipeUpSlowly();
				}
				tagName = date.getAttribute("content-desc").toString();
			}
			driver.findElementByXPath("//android.widget.TextView[contains(@content-desc, '" + nd + "')]").click();
			break;
		case "iOS":
			date = driver.findElementByXPath("//XCUIElementTypeCell[contains(@name, '" + nd + "')]");
			tagName = date.getAttribute("label").toString();
			while (tagName.contains("unavailable") || tagName.contains("events")) {
				if (nd.contains(Integer.toString(res))) {
					common.swipeUpSlowly();
				}
				nd = nextDate(nd);
				date = driver.findElementByXPath("//XCUIElementTypeCell[contains(@name, '" + nd + "')]");
				tagName = date.getAttribute("label").toString();
			}
			driver.findElementByXPath("//XCUIElementTypeCell[contains(@name, '" + nd + "')]").click();
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void verifyAsbsenceDuratioPage() {
		Assert.assertTrue("Create Absence Page 5 is not displayed", durationPageVerification.isDisplayed());
		utils.log().info("Create Absence Page 5 is displayed");
	}

	public void selectReason() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			verifyAsbsenceDuratioPage();
			selectDuration.click();
			if (common.isElementClickable(absenceshifttime)) {
				absenceshifttime.click();
				hideKeyboard();
				driver.getKeyboard().sendKeys("1000");
			} else {
				utils.log().info("Time Absence shift type not displayed");
			}
			break;
		case "iOS":
			selectDuration.click();
			if (common.isElementdisplayed(absenceshifttime)) {
				absenceshifttime.click();
				driver.getKeyboard().sendKeys("1000");
				click(Done);
			} else {
				utils.log().info("Time Absence shift type not displayed");
			}
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void substituteAssignPageVerification() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			common.isElementdisplayed(subAssignPageVerification);
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
			common.isElementdisplayed(reviewPageVerification);
			Assert.assertTrue("Create Absence Page 6 is not displayed", reviewPageVerification.isDisplayed());
			utils.log().info("Create Absence Page 6 is displayed");
			submitAbsence.click();
			break;
		case "iOS":
			submitAbsence.click();
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void viewAbsence() {
		if (common.isElementdisplayed(viewAbsence)) {
			viewAbsence.click();
		} else {
			click(okay);
		}
	}

	public void verifyAbsence() {
		if (common.isElementdisplayed(confirmationNumber)) {
			Assert.assertTrue("Confirmation number is not displayed", confirmationNumber.isDisplayed());
			utils.log().info("Confirmation number is displayed");
		} else {
			utils.log().info("Absence Created");
		}
	}

	public void selectAbsenceApprovalWidget() throws Throwable {
		common.scrollToElement(absenceApprovalwidget, "up");
		click(absenceApprovalwidget);
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
		employeeName.click();
		approveBtnOnAbsence();
		clickonOkBtn();
	}

	public void clickonOkBtn() {
		isElementdisplayed(okBtn);
		okBtn.click();
	}

	public void approveBtnOnAbsence() {
		isElementdisplayed(approvebtn);
		approvebtn.click();
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

	public void clickOnSetting() {
		clickOnMenuTab();
		settingOption();
	}

	public void settingOption() {
		Assert.assertTrue("Settings tab is not displayed", settings.isDisplayed());
		click(settings);
	}

	public void toggleDarkMode() {
		Assert.assertTrue("Dark mode tab is not displayed", darkMode.isDisplayed());
		click(darkMode);
	}

	public void screenshotcapture() throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("screenshot/DarkMode.jpg"));
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
		common.scrollToElement(createAbsBtn, "up");
		createAbsBtn.click();
	}

	public void clickOnFeedback() {
		click(backBtn);
		clickOnMenuTab();
		clickOnFeedbackOption();
	}

	public void clickOnMenuTab() {
		Assert.assertTrue("Menu tab is not displayed", menuTab.isDisplayed());
		click(menuTab);
	}

	public void clickOnFeedbackOption() {
		Assert.assertTrue("Feedback tab is not displayed", feedback.isDisplayed());
		click(feedback);
	}

	public void sendFeedback() throws Exception {
		Assert.assertTrue("Topic tab is not displayed", topic.isDisplayed());
		click(topic);
		int size = itemsInDropDown.size();
		int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
		itemsInDropDown.get(randomNumber).click();
		sendFeedbackTitle();
		sendFeedbackMessage();
	}

	public void sendFeedbackTitle() {
		Assert.assertTrue("Title tab is not displayed", title.isDisplayed());
		title.click();
		driver.getKeyboard().sendKeys("Automation Test");
	}

	public void sendFeedbackMessage() {
		Assert.assertTrue("message tab is not displayed", message.isDisplayed());
		click(message);
		driver.getKeyboard().sendKeys("This is a Test message");
		click(saveBtn);
	}

	public void clickInbox() {
		Assert.assertTrue("Inbox tab is not displayed", inboxTab.isDisplayed());
		click(inboxTab);
	}

	public void verifyInboxPage() throws Exception {
		isElementdisplayed(inboxTab);
		Assert.assertTrue("Inbox page is not displayed", inboxTab.isDisplayed());
		utils.log().info("Inbox page is displayed");
	}

	public void viewText() {
		click(inboxMsg);
		Assert.assertTrue("Message is not displayed", getElementText(msgData).length() > 1);
		utils.log().info("MEssage is displayed");
	}

	public void selectUnfilledAbsence() throws Exception {
		scrollToElement(unfilledAbsence, "up");
		Assert.assertTrue("No Unfilled Absence is present", unfilledAbsence.isDisplayed());
		utils.log().info("Unfilled Absence is present");
		click(unfilledAbsence);
	}

	public void click_tapToAssign() {
		Assert.assertTrue("Assign substitute btn is not displayed", assignSubstitute.isDisplayed());
		click(assignSubstitute);
	}

	public void assignSubstitute() {
		Assert.assertTrue("Select substitute btn is not displayed", selectSubstitute.isDisplayed());
		click(selectSubstitute);
	}

	public void confirmAssignSubstitute() {
		Assert.assertTrue("Confirm substitute btn is not displayed", confirmAssignSub.isDisplayed());
		click(confirmAssignSub);
	}

	public void clickTimesheetOption() throws Exception {
		common.scrollToElement(timesheetsbtn, "up");
		click(timesheetsbtn);
	}

	public void verifySubmitTimesheetBtn() {
		isElementdisplayed(submittimesheetsbtn);
		Assert.assertTrue("Submit timesheet option is not displayed", submittimesheetsbtn.isDisplayed());
	}

	public void submitTimesheet() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			isElementdisplayed(tuesday);
			break;
		case "iOS":
			isElementdisplayed(addTimeSheets);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		verifySubmitTimesheetBtn();
		click(submittimesheetsbtn);
	}

	public void verifySubmitTimesheet() {
		Assert.assertTrue("Timesheet button not displayed", submitTimesheet.isDisplayed());
		utils.log().info("Timesheet button displayed");
	}

	public void enterTimeSheetdetails() {
		if (isElementdisplayed(enterPin)) {
			click(enterPin);
			driver.getKeyboard().sendKeys("3661");
			hideKeyboard();
			click(checkbox);
		} else {
			utils.log().info("Digital signature not displayed");
		}
		// verifySubmitTimesheet();
		// common.swipeUpSlowly();
		click(submitTimesheet);
	}

	public void undoTimesheet() throws Exception {
		verifyUndoBtn();
		undoicon.click();
		undobtn.click();
	}

	public void verifyUndoBtn() {
		isElementdisplayed(undoSubmission);
		Assert.assertTrue("Undo timesheet option is not displayed", undoSubmission.isDisplayed());
		utils.log().info("Undo timesheet option is not displayed");
	}

	public void verifyUndo() {
		isElementdisplayed(declinebtn);
		declinebtn.click();
		verifySubmitTimesheetBtn();
		utils.log().info("Submit timesheet option is not displayed");
	}

	// MOB-4233 //MOB-4234
	public void enterSearchText(String searchText) {
		Assert.assertTrue("search Bar option is not displayed", searchBar.isDisplayed());
		searchResultText = searchText;
		searchBar.click();
		searchBar.clear();
		searchBar.sendKeys(searchText);
	}

	public void clickOnResult() {
		Assert.assertTrue("search Result option is not displayed", searchResult.isDisplayed());
		searchResult.click();
	}

	public void verifySearchResult() {
		Assert.assertTrue("calendar is not displayed", calendar.isDisplayed());
		String result = getElementText(calendar);
		Assert.assertTrue("Entered text does not match", result.equalsIgnoreCase(searchResultText));
		utils.log().info("Entered text matches with result");
	}

	public void clickReorderWidget() throws Throwable {
		common.scrollToElement(reOrderWidgetbtn, "up");
		click(reOrderWidgetbtn);
		for (MobileElement widgetlistele : WidgetOrderList) {
			widgetlistbeforeReorder.add(common.getElementText(widgetlistele));
		}
	}

	public void draganddrop() throws Throwable {
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
		widgetlistbeforeReorder.clear();
		widgetlistafterReorder.clear();
	}

	public void viewWeekTimesheets() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			clickTimesheetOption();
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
			clickTimesheetOption();
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
		click(friday);
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
			click(selectDayToFillTimesheet);
			Assert.assertTrue("Timesheet for the day is not displayed", commonDayTotal.isDisplayed());
			utils.log().info("Timesheets for the day is displayed");
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void addTimeSheet() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			common.isElementdisplayed(selectDayToFillTimesheet);
			click(selectDayToFillTimesheet);
			click(addTimeSheets);
			common.isElementdisplayed(workDetails);
			Intime = common.getElementText(timeSheetInTime);
			click(saveTimesheets);
			break;
		case "iOS":
			common.isElementdisplayed(selectDayToFillTimesheet);
			click(selectDayToFillTimesheet);
			click(addTimeSheets);
			common.isElementdisplayed(workDetails);
			clickonEditButton2();
			clickOnEditBtton3();
			Intime = common.currentTime();
			click(saveTimesheets);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clickOnEditBtton3() {
		click(timeInEdit3);
		click(Done);
	}

	public void goToEditDeleteTimeSheetOption() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			common.isElementdisplayed(dailytimeSheetsubmitbtn);
			timeSheetInTime = driver.findElementByXPath("//android.widget.TextView[contains(@text,'" + Intime + "')]");
			click(timeSheetInTime);
			break;
		case "iOS":
			common.isElementdisplayed(dailytimeSheetsubmitbtn);
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
			common.isElementdisplayed(workDetails);
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
			if (isElementdisplayed(declinebtn)) {
				click(declinebtn);
			}
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clickonEditButton1() {
		click(timeInEdit1);
		click(Done);
	}

	public void AddTextonCommentSection() {
		click(commentBox);
		driver.getKeyboard().sendKeys("Checking Edit Functionality");
	}

	public void clickonEditButton2() {
		click(timeInEdit2);
		click(Done);
	}

	public void clickOnNotNowBtn() {
		isElementdisplayed(declinebtn);
		click(declinebtn);
	}

	public void timEntryEditBtnClick() {
		isElementdisplayed(dailytimeSheetedittbtn);
		click(dailytimeSheetedittbtn);
	}

	public void clickOnDeleteTimesheet() {
		common.isElementdisplayed(timeSheetDeletebtn);
		click(timeSheetDeletebtn);
	}

	public void deleteTimesheet() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			common.isElementDisplayed(dailytimeSheetedittbtn);
			clickOnDeleteTimesheet();
			click(okBtn);
			common.isElementdisplayed(dailytimeSheetsubmitbtn);
			Assert.assertFalse("Time sheet is not deleted", common.isElementNotPresent(timeSheetInTime));
			utils.log().info("Time sheet is deleted");
			break;
		case "iOS":
			click(timeSheetInTime);
			if (isElementdisplayed(PushNotificationOK)) {
				click(PushNotificationOK);
			}
			isElementdisplayed(dailytimeSheetedittbtn);
			click(timeSheetDeletebtn);
			click(okay);
			isElementdisplayed(dailytimeSheetsubmitbtn);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void click_searchResult() {
		click(searchAbsReason);
	}

	public void verifyAbsenceDetailPage() {
		Assert.assertTrue("confirmation Number Page is not displayed", confirmationNumber.isDisplayed());
		Assert.assertTrue("Absence Detail Page Substitute is not displayed", absenceDetailPageSubstitute.isDisplayed());
		Assert.assertTrue("Absence Details Page is not displayed", absenceDetailPageApproval.isDisplayed());
		utils.log().info("Absence Details Page is displayed");
	}

	// MOB-4239
//	public void goBack() {
//		common.isElementdisplayed(backButton);
//		click(backButton);
//	}

	public void verify_widgetsPresent() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
				widgetlistafterReorder.forEach(widget -> {
					if (widget.equals("What's New")) {
						return;
					}
					MobileElement widgetElement = driver
							.findElementByXPath("//android.widget.TextView[@text='" + widget + "']");
					Assert.assertTrue("Widget is not displayed", widgetElement.isDisplayed());
					utils.log().info("Widget is present");
					swipeUpSlowlyOnDashboard();
				});
				break;
			case "iOS":
				widgetlistafterReorder.forEach(widget -> {
					if (widget.equals("New Version Available") || widget.equals("Customize Home")) {
						return;
					}
					MobileElement widgetElement = driver.findElementByAccessibilityId(widget + "_ModuleHeader");
					Assert.assertTrue("Widget is not displayed", widgetElement.isDisplayed());
					utils.log().info("Widget is present");
					swipeUpSlowlyOnDashboard();
				});
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	public void verify_footerPresent() {
		common.isElementdisplayed(homeTab);
		common.isElementdisplayed(menuTab);
		common.isElementdisplayed(inboxTab);
		Assert.assertTrue("Footers are not displayed",
				homeTab.isDisplayed() && menuTab.isDisplayed() && inboxTab.isDisplayed());
		utils.log().info("Footers are present");
	}

	public void getDate() throws Throwable {
		common.isElementdisplayed(getdate);
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			absence_day = common.getElementText(getdate).substring(9);
			absence_month = common.getElementText(getdate).substring(5, 8);
			click(homeTab);
			pullToRefresh();
			break;
		case "iOS":
			absence_day = common.getElementText(getdate).substring(8);
			absence_month = common.getElementText(getdate).substring(5, 8);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clickOnHomeButtonFooter(){
		Assert.assertTrue("Footer fails to display", homeBtnFooter.isDisplayed());
		click(homeBtnFooter);
	}
	
	public void clickOnSeachResult() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			Assert.assertTrue("search Result fails to display", searchResult.isDisplayed());
			click(searchResult);
			break;
		case "iOS":
			Assert.assertTrue("search Result fails to display", calendertitle.isDisplayed());
			click(calendertitle);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void clickCalender() throws Exception {
		verifyEventInCalender(absence_day, absence_month);
	}

	public void verifyEventInCalender(String absence_day, String absence_month) throws Exception {
		click(menuTab);
		clickOnSeachResult();
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			common.isElementdisplayed(calendertitle);
			if (!getElementText(calendertitle).contains(absence_month)) {
				click(nextMonthCalender);
				common.isElementdisplayed(calendertitle);
			}
			driver.findElementByXPath("//android.widget.TextView[contains(@content-desc,'" + absence_day + "')]")
					.click();

			break;
		case "iOS":
			common.isElementdisplayed(calendar);
			isElementdisplayed(monthVerify);
			if (!getElementText(monthVerify).contains(absence_month)) {
				click(nextMonthCalender);
				common.isElementdisplayed(calendar);
			}
			driver.findElementByXPath("//XCUIElementTypeCell[contains(@label, '" + absence_day + "')]").click();
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		clickOnEvent();
	}

	public void clickOnEvent() {
		common.isElementdisplayed(eventTitle);
		click(eventTitle);
	}

	// MOB-4247 //MOB-4248
	public void clickOnAbsence() throws Throwable {
		common.scrollToElement(clickOnAbsenceWidget, "up");
		click(clickOnAbsenceWidget);
		common.scrollToElement(reasonAbsence, "up");
		click(reasonAbsence);
	}

	public void editVacationAbsence() throws Throwable {

		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			String date = getElementText(fullDateAbsence).substring(9, 11);
			common.isElementdisplayed(editTab);
			click(editTab);
			isElementdisplayed(selectLocation);
			click(forwardCaret);
			verifyAsbsenceReasonPage();
			click(forwardCaret);
			verifyAsbsenceDatePage();
			driver.findElementByXPath("//android.widget.TextView[@text=" + date + "]").click();
			click(forwardCaret);
			break;
		case "iOS":
			common.isElementdisplayed(editTab);
			click(editTab);
			isElementdisplayed(selectLocation);
			click(forwardCaret);
			isElementdisplayed(absenceReasonVerification);
			click(forwardCaret);
			isElementdisplayed(datePageVerification);
			click(forwardCaret);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void editAbsence() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			verifyAsbsenceDuratioPage();
			common.isElementdisplayed(absenceshifttime);
			absenceshifttime.click();
			hideKeyboard();
			driver.getKeyboard().sendKeys("1000");
			click(forwardCaret);
			substituteAssignPageVerification();
			click(forwardCaret);
			break;
		case "iOS":
			isElementdisplayed(durationPageVerification);
			// common.isElementdisplayed(absenceshifttime);
			absenceshifttime.click();
			driver.getKeyboard().sendKeys("1000");
			isElementdisplayed(Done);
			click(Done);
			click(forwardCaret);
			isElementdisplayed(subAssignPageVerification);
			click(forwardCaret);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
		common.isElementdisplayed(saveChanges);
		click(saveChanges);
		click(viewAbsence);
	}

	public void allowClockInPermissions() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
		common.isElementdisplayed(clockInbtn);
		click(clockInbtn);
		common.isElementdisplayed(permissionGrantbtn);
		click(permissionGrantbtn);
		common.isElementdisplayed(permissionGrantonlyForApp);
		click(permissionGrantonlyForApp);
		break;
			case "iOS":
				click(clockInbtn);
				click(permissionGrantbtn);
				click(permissionGrantonlyForApp);
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	public void clockInbtn() throws Throwable {
		Assert.assertTrue("Clock In button fails to display", clockInbtn.isDisplayed());
		click(clockInbtn);
		common.isElementdisplayed(clockedInVerification);
	}

	public void clockOutThroughTimesheet() throws Throwable {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
		Intime = common.getElementText(clockedInTime).substring(1);
		clickTimesheetOption();
		//String date = currentDate().substring(0, 2);
	     String date = currentDateTimesheet();
		common.isElementdisplayed(monday);
		driver.findElementByXPath("//android.widget.TextView[contains(@text,'" + date + "')]").click();
		common.isElementdisplayed(eventSummary);
		clockedInTime = driver.findElementByXPath("//android.widget.TextView[contains(@text,'" + Intime + "')]");
		clockedInTime.click();
		editTimesheet();
		break;
			case "iOS":
				clickTimesheetOption();
				viewDayTimesheets();
				addTimeSheet();
				break;
			default:
				throw new Exception("Invalid platform Name");
		}
	}

	public void verifyClockOut() {
		common.isElementdisplayed(timeSheetTimeEventPage);
		click(homeTab);
		isElementdisplayed(clockInbtn);
		Assert.assertTrue("Didnt not get Clocked out", clockInbtn.isDisplayed());
		utils.log().info("Clocked out successfully");
	}

	// MOB-4277
	public void selectOrganization() {
		common.isElementdisplayed(peopleWidgetOrg);
		click(peopleWidgetOrg);
		click(jobPage.contbtn);
	}

	public void clickPeopleWidget() throws Exception {
		common.scrollToElement(PeopleWidget, "up");
		Assert.assertTrue("People Widget is not displayed", PeopleWidget.isDisplayed());
		utils.log().info("People Widget is displayed");
		PeopleWidget.click();
	}

	public void SerachName(String lastName) throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			common.isElementdisplayed(PeopleWidget);
			click(SearchPeople);
			driver.getKeyboard().sendKeys(lastName);
			common.hideKeyboard();
			driver.findElementByXPath("//android.widget.TextView[contains(@text,'" + lastName + "')]").click();
			break;
		case "iOS":
			click(serachEditText);
			driver.getKeyboard().sendKeys(lastName);
			click(SearchPeople);
			break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}

	public void verifyContactDetails() {
		Assert.assertTrue("Work Phone is not displayed",
				(WorkPhone.isDisplayed() || getElementText(WorkPhoneData).length() > 0 || WorkEmail.isDisplayed()
						|| getElementText(WorkEmailData).length() > 0) || OtherPhone.isDisplayed()
						|| getElementText(OtherPhoneData).length() > 0 || PersonalPhone.isDisplayed()
						|| getElementText(PersonalPhoneData).length() > 0 || PersonalEmail.isDisplayed()
						|| getElementText(PersonalEmailData).length() > 0);
		utils.log().info("Details are displayed");
	}

	public void logoutApplication() {
		clickOnMenuTab();
		click(settings);
		click(logoutBtn);
	}
	
	public void clickOnBack() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
		click(backBtn);
		break;
		case "iOS":
		click(week);
		break;
		default:
			throw new Exception("Invalid platform Name");
		}
	}
	
	public void swipeUpSlowlyOnDashboard() {
		Dimension size = driver.manage().window().getSize();
		int startX = size.width / 2;
		int startY = (int) (size.height * .6);
		int endY = (int) (size.height * .35);
		if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
			(new TouchAction<>(driver)).press(PointOption.point(startX, startY))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(700))).moveTo(PointOption.point(startX, endY))
					.release().perform();
			if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios")) {
				(new TouchAction<>(driver)).press(PointOption.point(startX, startY))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(700))).moveTo(PointOption.point(startX, endY))
						.release().perform();
			}
		}
	}
}