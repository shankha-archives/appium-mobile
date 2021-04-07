package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.PeopleDetailScreen;

public class PeopleDetailScreenStepDef {

    PeopleDetailScreen peopleDetailScreen = new PeopleDetailScreen();

    @Then("Verify user details are displayed")
    public void verifyUserDetailsAreDisplayed() {
        peopleDetailScreen.verifyContactDetails();
    }
}
