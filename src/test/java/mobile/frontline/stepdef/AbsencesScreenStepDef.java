package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import mobile.Frontline.utils.TestDataManager;
import mobile.frontline.pages.AbsencesScreen;
import org.junit.Assert;

public class AbsencesScreenStepDef {

    AbsencesScreen absencesScreen = new AbsencesScreen();
    public TestDataManager testdata = new TestDataManager();

    @And("Click on add absence btn")
    public void clickOnAddAbsenceBtn() {
        absencesScreen.clickAddAbsence();
    }

    @And("Select an unfilled and unassigned absence")
    public void selectAnUnfilledAndUnassignedAbsence() throws Throwable {
        absencesScreen.clickUnfilledUnassignedAbsence(testdata.read_property("testingData", "users", "UnFilledUnassigned"));
    }
    @And("^verify absences page is displayed$")
    public void verify_absences_page_is_displayed() throws Throwable {
        Assert.assertTrue("Absences page is not displayed", absencesScreen.verifyAbsencesPage());
    }
}
