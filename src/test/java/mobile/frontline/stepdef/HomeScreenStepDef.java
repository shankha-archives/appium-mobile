package mobile.frontline.stepdef;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import mobile.frontline.pages.Homescreen;

public class HomeScreenStepDef {

    public Homescreen homescreen = new Homescreen();



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
    public void navigateToDashboard() {
        homescreen.clickOnHomeButton();
    }
}
