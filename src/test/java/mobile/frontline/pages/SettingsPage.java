package mobile.frontline.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
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
	public MobileElement availableJobs;
	
	@iOSXCUITFindBy(accessibility = "Available")
	public MobileElement available;
	
	@iOSXCUITFindBy(accessibility = "Accepted")
	public MobileElement accepted;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage)[2]")
//XCUIElementTypeApplication[@name="Frontline"]/XCUIElementTypeWindow[1]
	public MobileElement frontlineLogo;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Diagnostics']")
	public MobileElement diagnosticsHeader;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Send Diagnostics']")
	public MobileElement sendDiagnosticsBtn;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Menu']")
	public MobileElement MenuHeader;

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
	
	public void avaialbleJobsLink() {
		common.swipeUpSlowly();
		common.isElementDisplayed(availableJobs);
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
	public void longPress() throws InterruptedException {
/*
		utils.log().info("============== Entered in code ====================");
		MobileElement recBtn = frontlineLogo; //driver.findElement(MobileBy.xpath("//XCUIElementTypeImage)[2]"));
		utils.log().info("============== Entered in 2nd line of code ===================="+recBtn);
		Point location = recBtn.getLocation();
		utils.log().info("Element location is============="+location);
		new TouchAction(driver).press(PointOption.point(location.getX(), location.getY())).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(20))).release().perform();
		utils.log().info("============START==================");*/
		utils.log().info("============START==================");
		TouchAction action = new TouchAction(driver);
		int dragX = frontlineLogo.getLocation().x + (frontlineLogo.getSize().width / 2);
		utils.log().info("============dragX=================="+dragX);
		int dragY = frontlineLogo.getLocation().y + (frontlineLogo.getSize().height / 2);
		utils.log().info("============dragY=================="+dragY);
		action.press(PointOption.point(dragX, dragY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.release().perform();

		utils.log().info("============END==================");
		Thread.sleep(1000);
	}

	public void LongPressOnFrontline_setting() throws InterruptedException {
        common.isElementdisplayed(MenuHeader);
	   longPress();
		common.isElementdisplayed(diagnosticsHeader);
		Assert.assertTrue("Diagnostic Header is not displayed", diagnosticsHeader.isDisplayed());
		utils.log().info("Diagnostic Header is displayed");
	}

	public void clickOnSendDiagnosticBtn(){
		click(sendDiagnosticsBtn);
		click(smoke.okay);
	}

}
