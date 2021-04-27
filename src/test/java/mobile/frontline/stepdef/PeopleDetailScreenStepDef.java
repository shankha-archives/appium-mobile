package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.PeopleDetailScreen;
import org.junit.Assert;

public class PeopleDetailScreenStepDef {

    PeopleDetailScreen peopleDetailScreen = new PeopleDetailScreen();

    @Then("Verify user details are displayed")
    public void verifyUserDetailsAreDisplayed() {
        Assert.assertTrue("Work Phone is not displayed", (
                peopleDetailScreen.waitForEmployeeName() ||
                        peopleDetailScreen.waitWorkEmail() || peopleDetailScreen.getWorkEmailText().length() > 0
                        || peopleDetailScreen.waitPersonalPhone() || peopleDetailScreen.getPersonalPhoneText().length() > 0
                        || peopleDetailScreen.waitPersonalEmail() || peopleDetailScreen.getPersonalEmailText().length() > 0));
    }
}
