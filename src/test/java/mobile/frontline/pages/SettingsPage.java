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
	// XCUIElementTypeApplication[@name="Frontline"]/XCUIElementTypeWindow[1]
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
//	@iOSXCUITFindBy(accessibility = "")
	public MobileElement jobDetailDate;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Next Scheduled Job_ModuleHeader']")
	public MobileElement nextScheduledJobWidget;
  
	public String job_day;
	public String job_month;
	
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
			/*
			 * utils.log().info("============== Entered in code ====================");
			 * MobileElement recBtn = frontlineLogo;
			 * //driver.findElement(MobileBy.xpath("//XCUIElementTypeImage)[2]"));
			 * utils.log().
			 * info("============== Entered in 2nd line of code ===================="+recBtn
			 * ); Point location = recBtn.getLocation();
			 * utils.log().info("Element location is============="+location); new
			 * TouchAction(driver).press(PointOption.point(location.getX(),
			 * location.getY())).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(20)))
			 * .release().perform();
			 * utils.log().info("============START==================");
			 */
			utils.log().info("============START==================");
			// TouchAction action = new TouchAction(driver);
			int dragX = frontlineLogo.getLocation().x + (frontlineLogo.getSize().width / 2);
			utils.log().info("============dragX==================" + dragX);
			int dragY = frontlineLogo.getLocation().y + (frontlineLogo.getSize().height / 2);
			utils.log().info("============dragY==================" + dragY);
			action.press(PointOption.point(dragX, dragY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
					.release().perform();

			utils.log().info("============END==================");
			Thread.sleep(1000);
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
	
	public void viewInCalender() throws Exception {
		smoke.verifyEventInCalender(job_day,job_month);		
	}
	
	public void verifyNextScheduledJobWidget() throws Throwable{
		common.scrollToElement(nextScheduledJobWidget, "up");
		common.isElementdisplayed(nextScheduledJobWidget);
		Assert.assertTrue("Next Scheduled Job is not displayed", nextScheduledJobWidget.isDisplayed());
		utils.log().info("Next Scheduled Job is displayed");
	}
}
