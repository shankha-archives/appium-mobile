package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.MenuScreen;

public class MenuLinksScreenStepDef {

    public MenuScreen menuScreen  = new MenuScreen();

    @And("Click on Settings")
    public void clickOnSettings() throws Exception {
        menuScreen.clickSettingsOption();
    }

    @Then("Enter search text {string}")
    public void enterSearchText(String searchResullt) {
        menuScreen.enterSearchText(searchResullt);
        
    }

    @When("Click on calendar search result")
    public void clickOnCalendarSearchResult() {
        menuScreen.clickOnCalendarResult();
    }

    @And("^click the absence search result$")
    public void click_the_absence_search_result() throws Throwable {
     //   smokePage.click_searchResult();
        menuScreen.clickOnAbsenceSearchResult();
    }
}
