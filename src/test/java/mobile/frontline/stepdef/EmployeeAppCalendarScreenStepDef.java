package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestDataManager;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.EmployeeAppCalendarScreen;
import org.junit.Assert;

public class EmployeeAppCalendarScreenStepDef {
    BasePage common = new BasePage();
    EmployeeAppCalendarScreen employeeAppCalendarScreen = new EmployeeAppCalendarScreen();
    public TestDataManager testdata = new TestDataManager();

    @And("verify calendar the search result {string}")
    public void verifyCalendarTheSearchResult(String searchText) throws Exception {
        Assert.assertTrue("Searched text did not match with the result", employeeAppCalendarScreen.waitForSearchResult().equalsIgnoreCase(testdata.read_property("testingData", "users", searchText)));
    }

    @Then("Choose the required month {string}")
    public void chooseTheRequiredMonth(String absenceDay) throws Exception {
        employeeAppCalendarScreen.getRequiredMonthInCalendar(common.workingDay(absenceDay, "MMMM", 1));
    }

    @And("Click on the event day {string}")
    public void clickOnTheEventDay(String absenceDay) throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            employeeAppCalendarScreen.clickCalendarEventDay(common.workingDay(absenceDay, "E, MMM d, yyyy", 1));
        else
            employeeAppCalendarScreen.clickCalendarEventDay(common.workingDay(absenceDay, "MM/dd/yyyy",1));
    }

    @And("Tap on the event title")
    public void tapOnTheEventTitle() throws Exception {
        employeeAppCalendarScreen.clickOnEvent_absences();
    }
}
