package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.TestDataManager;
import mobile.frontline.pages.PeopleScreen;

public class PeopleScreenStepDef {

    PeopleScreen peopleScreen = new PeopleScreen();
    public TestDataManager testdata = new TestDataManager();

    @When("Enter the last name of the person to be searched")
    public void enterTheLastNameOfThePersonToBeSearched() throws Exception {
        peopleScreen.enterLastNameTobeSearched(testdata.read_property("testingData", "users", "lastName"));
    }

    @And("Click on the searched person")
    public void clickOnTheSearchedPerson() {
        peopleScreen.clickOnSearchedUser(testdata.read_property("testingData", "users", "lastName"));
    }
}
