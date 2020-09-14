package mobile.frontline.pages;

import java.util.List;

import org.junit.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.TestUtils;

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

}
