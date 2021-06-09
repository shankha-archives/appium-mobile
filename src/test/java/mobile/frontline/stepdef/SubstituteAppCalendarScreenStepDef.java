package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import mobile.frontline.pages.SubstituteAppCalendarScreen;

public class SubstituteAppCalendarScreenStepDef {

    SubstituteAppCalendarScreen substituteAppCalendarScreen = new SubstituteAppCalendarScreen();

    @And("Tap on substitutes job event")
    public void tapOnSubstitutesJobEvent() throws Exception {
        substituteAppCalendarScreen.clickOnEvent_job();
    }
}
