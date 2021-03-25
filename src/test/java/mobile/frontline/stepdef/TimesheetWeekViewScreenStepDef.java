package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import mobile.frontline.pages.TimesheetWeekViewScreen;

public class TimesheetWeekViewScreenStepDef {

    TimesheetWeekViewScreen timesheetWeekViewScreen = new TimesheetWeekViewScreen();

    @And("Select the current day")
    public void selectTheCurrentDay() throws Exception {
        timesheetWeekViewScreen.selectCurrentDayForTimesheet();
    }
}
