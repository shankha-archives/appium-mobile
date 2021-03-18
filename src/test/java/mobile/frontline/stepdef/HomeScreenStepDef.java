package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.Homescreen;

public class HomeScreenStepDef {

    public Homescreen homescreen = new Homescreen();

    @Then("^the substitute navigates to dashboard page$")
    public void the_substitute_navigates_to_dashboard_page() throws Throwable {
        homescreen.verify_homeScreen_displayed();
        //loginPage.verify_homeScreen_displayed();
    }
}
