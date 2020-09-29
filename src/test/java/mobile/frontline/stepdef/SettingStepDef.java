package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.SettingsPage;

public class SettingStepDef {
	
	public SettingsPage settingsPage = new SettingsPage();

	@When("^click on menu and tap the Calendar link$")
	public void click_on_menu_and_cakendar() throws Throwable {
		settingsPage.openMenuCalendar();
	}
	
	@Then("^verify the calendar$")
	public void verify_the_calendar() throws Throwable {
		settingsPage.verifyCalendar();
	}
}
