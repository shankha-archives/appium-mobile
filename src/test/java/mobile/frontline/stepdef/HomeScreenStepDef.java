package mobile.frontline.stepdef;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.Homescreen;
import org.jsoup.Connection;

public class HomeScreenStepDef {

    public Homescreen homescreen = new Homescreen();
    public BasePage basePage = new BasePage();


    @Then("^the substitute navigates to dashboard page$")
    public void the_substitute_navigates_to_dashboard_page() throws Throwable {
        homescreen.verify_homeScreen_displayed();
        //loginPage.verify_homeScreen_displayed();
    }

    @And("click on the Available Jobs")
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
        homescreen.verify_homeScreen_displayedWithoutPushVerify();
    }
    @And("^The user minimize and relaunch the application$")
    public void the_user_minimize_and_relaunch_the_application() throws Throwable {
        basePage.bgRunningApp();
    }

    @And("^The user kill and relaunch the application$")
    public void the_user_kill_and_relaunch_the_application() throws Throwable {
        basePage.bgRunningApp();
    }

    @When("the user clicks on Menu tab")
    public void theUserClicksOnMenuTab() {
        homescreen.clickOnMenuTab();
    }
}
