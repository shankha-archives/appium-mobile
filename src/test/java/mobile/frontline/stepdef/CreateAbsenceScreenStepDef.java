package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.TestDataManager;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.CreateAbsenceScreen;
import org.junit.Assert;

public class CreateAbsenceScreenStepDef {

    CreateAbsenceScreen createAbsenceScreen= new CreateAbsenceScreen();
    public TestDataManager testdata = new TestDataManager();
    BasePage basePage = new BasePage();

    @When("Select absence reason and click on next btn")
    public void selectAbsenceReasonAndClickOnNext() throws Exception {
        Assert.assertTrue("Create Absence Page 3 is not displayed", createAbsenceScreen.waitForAsbsenceReasonPage()) ;
        createAbsenceScreen.absenceReason();
        createAbsenceScreen.clickNext();
    }

    @And("Select absence duration and click on next btn")
    public void selectAbsenceDurationAndClickOnNextBtn() throws Exception {
        Assert.assertTrue("Create Absence Page 5 is not displayed", createAbsenceScreen.waitForAsbsenceDuratioPage()) ;
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
        Assert.assertTrue(  "Create Absence Page 6 is not displayed",createAbsenceScreen.waitForReviewAbsencePage());
        createAbsenceScreen.submitAbsence();
    }

    @Then("Verify the absence creation pop up")
    public void verifyTheAbsenceCreationPopUp() {
      Assert.assertTrue("Create Absence pop up message is not displayed",createAbsenceScreen.waitForAbsenceCreationPopup());
    }

    @And("Verify absence reason page and click next")
    public void verifyAbsenceReasonPageAndClickNext() throws InterruptedException {
        Assert.assertTrue("Create Absence Page 3 is not displayed", createAbsenceScreen.waitForAsbsenceReasonPage()) ;
        createAbsenceScreen.clickNext();
    }

    @And("Edit absence day {string} and click next")
    public void editAbsenceDayAndClickNext(String absenceDay) throws Throwable {
        Assert.assertTrue("Create Absence Page 4 is not displayed", createAbsenceScreen.waitForAsbsenceDatePage()) ;
        createAbsenceScreen.editDate(absenceDay);
        createAbsenceScreen.clickNext();
    }

    @And("Verify absence duration and click next")
    public void verifyAbsenceDurationAndClickNext() throws Exception {
        Assert.assertTrue("Create Absence Page 5 is not displayed", createAbsenceScreen.waitForAsbsenceDuratioPage()) ;
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
        Assert.assertTrue("Create Absence Page 1 is not displayed",  createAbsenceScreen.waitForWhoPage());
        createAbsenceScreen.enterTeachersName(testdata.read_property("testingData", "users", empAbsence));
        createAbsenceScreen.selectTeachersName(testdata.read_property("testingData", "users", empAbsence));
        Assert.assertTrue("Who text is not displayed", createAbsenceScreen.waitForForwardBtn());
        createAbsenceScreen.clickNext();
    }

    @And("Select absence day {string}  {string}")
    public void selectAbsenceDay(String absenceDay, String count) throws Throwable {
        Assert.assertTrue("Create Absence Page 4 is not displayed", createAbsenceScreen.waitForAsbsenceDatePage()) ;
       if(count.equals("2")&&basePage.workingDay("current day","EEE", 0).equals("Fri"))
        count = "4";
       createAbsenceScreen.selectDate(absenceDay, count);
    }

    @And("click on next btn")
    public void clickOnNextBtn() throws InterruptedException {
        createAbsenceScreen.clickNext();
    }
}
