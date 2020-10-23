package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.TestDataManager;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.LoginPage;
import mobile.frontline.pages.SettingsPage;
import mobile.frontline.pages.SmokeMethods;
import org.junit.Assert;

public class SettingStepDef {
	
	public SettingsPage settingsPage = new SettingsPage();
	public LoginPage loginPage = new LoginPage();
	public BasePage common = new BasePage();
	public TestDataManager testdata = new TestDataManager();
	public SmokeMethods smokePage = new SmokeMethods();

	@When("^click on menu and tap the Calendar link$")
	public void click_on_menu_and_cakendar() throws Throwable {
		settingsPage.openMenuCalendar();
	}
	
	@Then("^verify the calendar$")
	public void verify_the_calendar() throws Throwable {
		settingsPage.verifyCalendar();
	}
	
	@When("^click on Avalaible Jobs link")
	public void click_on_available_jobs_link() throws Throwable {
		settingsPage.avaialbleJobsLink();
	}
	
	@Then("^verify Job List tab bar for available and accepted jobs")
	public void verify_Job_List_tab() throws Throwable {
		settingsPage.jobListTab();
	}
	//MOB-4809
	@Then("^User click on the send Diagnostics option and click on Okay button$")
	public void user_click_on_the_send_diagnostics_option_and_click_on_okay_button() throws Throwable {
		settingsPage.clickOnSendDiagnosticBtn();
	}
	@And("^Long press on Frontline Logo at bottom of the screen$")
	public void long_press_on_frontline_logo_at_bottom_of_the_screen() throws Throwable {
		settingsPage.LongPressOnFrontline_setting();
	}
}
