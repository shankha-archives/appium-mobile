package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import mobile.frontline.pages.AppCalendarScreen;
import org.junit.Assert;

public class AppCalendarScreenStepDef {

    AppCalendarScreen appCalendarScreen = new AppCalendarScreen();

    @And("verify calendar the search result {string}")
    public void verifyCalendarTheSearchResult(String searchText) throws Exception {
        Assert.assertTrue("Searched text did not match with the result", appCalendarScreen.verifySearchResult(searchText));
    }
}
