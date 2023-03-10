package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.Homescreen;
import org.junit.Assert;

public class HomePageScreenStepDef {

    public Homescreen homescreen = new Homescreen();
    public BasePage basePage = new BasePage();
    public static String initailWeekTotal;


    @Then("^The substitute navigates to dashboard page$")
    public void the_substitute_navigates_to_dashboard_page() throws Throwable {
        Assert.assertTrue("Dashboard header page is not displayed", homescreen.verify_homeScreen_displayed());

    }
    //loginPage.verify_homeScreen_displayed();


    @And("Click on the Available Jobs")
    public void clickOnTheAvailableJobs() throws Exception {
        homescreen.clickJobWidget();
    }

    @And("Navigate to dashboard")
    public void navigateToDashboard() throws InterruptedException {
        homescreen.clickOnHomeButton();
    }

    @And("Click on switch btn")
    public void clickOnSwitchBtn() {
        homescreen.clickSwitchbtn();
    }

    @Then("the user navigates to dashboard page")
    public void theUserNavigatesToDashboardPage() throws Throwable {
        Assert.assertTrue("The dashboard is not loaded", homescreen.verify_homeScreen_displayedWithoutPushVerify());
    }

    @And("^The user minimize and relaunch the application$")
    public void the_user_minimize_and_relaunch_the_application() throws Throwable {
        basePage.bgRunningApp();
    }

    @And("^The user kill and relaunch the application$")
    public void the_user_kill_and_relaunch_the_application() throws Throwable {
        basePage.bgRunningApp();
    }

    @When("click on Available Leave Balances")
    public void clickOnAvailableLeaveBalances() throws Exception {
        homescreen.clickOnAvailableLeaveBalanceWidget();
    }

    @When("click on the inbox")
    public void clickOnTheInbox() {
        homescreen.clickInbox();
    }

    @When("The employee clicks on clockin btn")
    public void theEmployeeClicksOnClockinBtn() throws Exception {
        homescreen.clickClockInBtn();
    }

    @And("Approve the required permissions")
    public void approveTheRequiredPermissions() {
        homescreen.clickOnAllowLocationAccess();
        homescreen.clickAllowPermissionPopUp();
    }

    @Then("Verify the employee is clocked in")
    public void verifyTheEmployeeIsClockedIn() throws Exception {
        Assert.assertTrue("The time sheet did not get clocked out", homescreen.waitClockInVerifictionBubble());
    }

    @When("The user navigates to timesheet widget")
    public void theUserNavigatesToTimesheetWidget() throws Throwable {
        homescreen.clickTimesheetWidget();
    }

    @And("Verify the timesheet is clocked out")
    public void verifyTheTimesheetIsClockedOut() throws Exception {
        Assert.assertTrue("The time sheet did not get clocked out", homescreen.waitClockInBtn());
    }

    @And("Verify the Timesheet total on dashboard")
    public void verifyTheTimesheetTotalOnDashboard() throws Exception {
        Assert.assertEquals("Total time on dashboard and total time is not equal", TimesheetWeekViewScreenStepDef.initialWeekTotalTime, homescreen.getWeekTimeText());
    }

    @Then("click on People widget")
    public void clickOnPeopleWidget() throws Throwable {
        homescreen.clickPeopleWidget();
    }

    @When("Fetch the list of widgets before reordering")
    public void fetchTheListOfWidgetsBeforeReordering() throws Throwable {
        homescreen.getListOrderBeforeReorder();
    }

    @When("Click on reorder widget button")
    public void clickOnReorderWidgetButton() {
        homescreen.clickReorderWidget();
    }

    @When("Fetch the list of widgets after reordering")
    public void fetchTheListOfWidgetsAfterReordering() throws Throwable {
        homescreen.getListOrderAfterReorder();
    }

    @Then("verify the order of widgets")
    public void verifyTheOrderOfWidgets() {
        Assert.assertNotEquals("The widgets order did not change", Homescreen.widgetlistbeforeReorder, Homescreen.widgetlistafterReorder);
    }

    @And("^click on the create absences$")
    public void click_on_the_create_absences() throws Throwable {
        homescreen.clickCreateAbs();
    }

    @When("Click on absences today widget")
    public void clickOnAbsencesTodayWidget() throws Throwable {
        homescreen.clickAbsencesWidget();
    }

    @Then("^The user moves to Next Scheduled Job widget and verify it")
    public void user_verifies_next_scheduled_job_widget() throws Throwable {
        homescreen.waitNextScheduledJobWidget();
    }

    @Then("^The user verify most recent Job in Next Scheduled Job widget")
    public void user_verifies_next_scheduled_job() throws Throwable {
        homescreen.waitNextScheduledJobInWidget();
    }
    
    @When("the user clicks on Menu tab")
    public void theUserClicksOnMenuTab() {
        homescreen.clickOnMenuTab();
    }

    @When("The user click on Add timesheet btn on dashboard")
    public void theUserClickOnAddTimesheetBtnOnDashboard() throws Throwable {
        homescreen.clickAddTimeBtn();
    }

    @When("Get the week total time from dashboard before adding timesheet")
    public void getTheWeekTotalTimeFromDashboardBeforeAddingTimesheet() throws Exception {
      initailWeekTotal =  homescreen.getWeekTimeText();
    }

    @And("Verify week total time from dashboard after adding timesheet")
    public void verifyWeekTotalTimeFromDashboardAfterAddingTimesheet() throws Exception {
        Assert.assertEquals("The calculated time and total time is not equal", homescreen.calculateTotalTime(), homescreen.getWeekTimeText());
    }

    @When("the user clicks on Timeclock widget")
    public void theUserClicksOnTimeclockWidget() {
        homescreen.clickTimeClock();
    }
}
