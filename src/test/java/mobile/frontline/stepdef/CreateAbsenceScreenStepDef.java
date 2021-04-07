package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.TestDataManager;
import mobile.frontline.pages.CreateAbsenceScreen;
import org.junit.Assert;

public class CreateAbsenceScreenStepDef {

    CreateAbsenceScreen createAbsenceScreen= new CreateAbsenceScreen();
    public TestDataManager testdata = new TestDataManager();

    @When("Select absence reason and click on next btn")
    public void selectAbsenceReasonAndClickOnNext() throws Exception {
        Assert.assertTrue("Create Absence Page 3 is not displayed", createAbsenceScreen.verifyAsbsenceReasonPage()) ;
        createAbsenceScreen.absenceReason();
        createAbsenceScreen.clickNext();
    }

    @And("Select absence day {string} and click on next btn")
    public void selectAbsenceDayAndClickOnNextBtn(String absenceDay) throws Throwable {
        Assert.assertTrue("Create Absence Page 4 is not displayed", createAbsenceScreen.verifyAsbsenceDatePage()) ;
        createAbsenceScreen.selectDate(absenceDay);
        createAbsenceScreen.clickNext();
    }

    @And("Select absence duration and click on next btn")
    public void selectAbsenceDurationAndClickOnNextBtn() throws Exception {
        Assert.assertTrue("Create Absence Page 5 is not displayed", createAbsenceScreen.verifyAsbsenceDuratioPage()) ;
        createAbsenceScreen.selectDuration();
        createAbsenceScreen.clickNext();
    }

    @And("Select if the substitute required and click on next btn")
    public void selectIfTheSubstituteRequiredAndClickOnNextBtn() throws Exception {
        Assert.assertTrue("Create Absence Page 5 is not displayed",createAbsenceScreen.substituteAssignPageVerification()) ;
        createAbsenceScreen.clickNext();
    }

    @And("Click on submit absence")
    public void clickOnSubmitAbsence() throws Exception {
        Assert.assertTrue(  "Create Absence Page 6 is not displayed",createAbsenceScreen.verifyReviewAbsencePage());
        createAbsenceScreen.submitAbsence();
    }

    @Then("Verify the absence creation pop up")
    public void verifyTheAbsenceCreationPopUp() {
      Assert.assertTrue("Create Absence pop up message is not displayed",createAbsenceScreen.verifyAbsenceCreationPopup());
    }

    @And("Verify absence reason page and click next")
    public void verifyAbsenceReasonPageAndClickNext() throws InterruptedException {
        Assert.assertTrue("Create Absence Page 3 is not displayed", createAbsenceScreen.verifyAsbsenceReasonPage()) ;
        createAbsenceScreen.clickNext();
    }

    @And("Edit absence day {string} and click next")
    public void editAbsenceDayAndClickNext(String absenceDay) throws Throwable {
        Assert.assertTrue("Create Absence Page 4 is not displayed", createAbsenceScreen.verifyAsbsenceDatePage()) ;
        createAbsenceScreen.selectDate(absenceDay);
        createAbsenceScreen.clickNext();
    }

    @And("Verify absence duration and click next")
    public void verifyAbsenceDurationAndClickNext() throws Exception {
        Assert.assertTrue("Create Absence Page 5 is not displayed", createAbsenceScreen.verifyAsbsenceDuratioPage()) ;
        createAbsenceScreen.editDuration();
        createAbsenceScreen.clickNext();
    }

    @And("Click on save edited absence")
    public void clickOnSaveEditedAbsence() {
        createAbsenceScreen.clickSaveAbsence();
    }

    @Then("Click on view absence btb")
    public void clickOnViewAbsenceBtb() {
        createAbsenceScreen.clickViewAbsence();
    }

    @And("Enter and select employee name {string} and click on next")
    public void enterAndSelectEmployeeNameAndClickOnNext(String empAbsence) throws Throwable {
        Assert.assertTrue("Create Absence Page 1 is not displayed",  createAbsenceScreen.verifyWhoPage());
        createAbsenceScreen.enterTeachersName(testdata.read_property("testingData", "users", empAbsence));
        createAbsenceScreen.selectTeachersName(testdata.read_property("testingData", "users", empAbsence));
        Assert.assertTrue("Who text is not displayed", createAbsenceScreen.waitForForwardBtn());
        createAbsenceScreen.clickNext();
    }
}
