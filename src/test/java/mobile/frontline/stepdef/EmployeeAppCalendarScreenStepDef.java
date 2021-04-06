package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import mobile.Frontline.utils.GlobalParams;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.EmployeeAppCalendarScreen;
import org.junit.Assert;

public class EmployeeAppCalendarScreenStepDef {
    BasePage common = new BasePage();
    EmployeeAppCalendarScreen employeeAppCalendarScreen = new EmployeeAppCalendarScreen();

    @And("verify calendar the search result {string}")
    public void verifyCalendarTheSearchResult(String searchText) throws Exception {
        Assert.assertTrue("Searched text did not match with the result", employeeAppCalendarScreen.verifySearchResult(searchText));
    }

//    @Then("Choose the required month")
//    public void chooseTheRequiredMonth() {
//        employeeAppCalendarScreen.verifyMonthInCalendar(nextWorkingDay(absenceDay, "MMMM dd, yyyy").split(" ")[0]);
//       // verifyEventInCalendar(nextWorkingDate, nextWorkingDay(absenceDay, "MMMM dd, yyyy").split(" ")[0]);
//
//    }
//
//    @And("Click on the event day")
//    public void clickOnTheEventDay() {
//    }

    @Then("Choose the required month {string}")
    public void chooseTheRequiredMonth(String absenceDay) throws Exception {
        employeeAppCalendarScreen.getRequiredMonthInCalendar(common.nextWorkingDay(absenceDay, "MMMM dd, yyyy").split(" ")[0]);
    }

    @And("Click on the event day {string}")
    public void clickOnTheEventDay(String absenceDay) throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            employeeAppCalendarScreen.clickCalendarEventDay(common.nextWorkingDay(absenceDay, "MMMM dd, yyyy"));
        else
            employeeAppCalendarScreen.clickCalendarEventDay(common.nextWorkingDay(absenceDay, "MM/dd/yyyy"));
    }

    @And("Tap on the event title")
    public void tapOnTheEventTitle() throws Exception {
        employeeAppCalendarScreen.clickOnEvent_absences();
      //  Thread.sleep(10000);
    }
}
