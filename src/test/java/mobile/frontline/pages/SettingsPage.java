package mobile.frontline.pages;

import org.junit.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import mobile.Frontline.utils.TestUtils;

public class SettingsPage extends LoginPage {

	TestUtils utils = new TestUtils();
	SmokeMethods smoke = new SmokeMethods();
	LoginPage loginPage = new LoginPage();
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
	public MobileElement calendar;
	
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

}
