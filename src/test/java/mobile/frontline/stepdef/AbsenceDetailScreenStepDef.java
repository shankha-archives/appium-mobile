package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.APIServices;
import mobile.frontline.pages.AbsenceDetailScreen;
import org.junit.Assert;

public class AbsenceDetailScreenStepDef {

    AbsenceDetailScreen absenceDetailScreen = new AbsenceDetailScreen();

    @Then("^verify the absence detail page$")
    public void verify_the_absence_detail_page() throws Throwable {
        Assert.assertTrue("Confirmation number is not displayed", absenceDetailScreen.verifydisplayConfirmationNumber());
    }

    @And("Verify absence confirmation number")
    public void verifyAbsenceConfirmationNumber() {
        Assert.assertTrue("Confirmation number is not displayed", absenceDetailScreen.verifydisplayConfirmationNumber());
        Assert.assertTrue("The confirmation numbers are different",absenceDetailScreen.getAbsenceDetails().contains(APIServices.confirmationNumber));
    }

    @When("Click on edit absence")
    public void clickOnEditAbsence() {
        absenceDetailScreen.clickEditAbsenceBtn();
    }

    @And("Verify the edited absence details")
    public void verifyTheEditedAbsenceDetails() {
        Assert.assertTrue("Confirmation number is not displayed", absenceDetailScreen.verifydisplayConfirmationNumber());
        Assert.assertTrue("Half Day Duration is not displayed", absenceDetailScreen.verifyEditedDuration().contains("Half Day")); ;
    }

    @And("Click on Tap to Assign link")
    public void clickOnTapToAssignLink() {
        absenceDetailScreen.click_tapToAssign();
    }

    @And("Select Substitute to assign absence")
    public void selectSubstituteToAssignAbsence() {
        absenceDetailScreen.assignSubstitute();
    }

    @And("Click Assign again to confirm")
    public void clickAssignAgainToConfirm() {
        absenceDetailScreen.clickConfirmAssignSubstitute();
    }

    @Then("Click on approve btn and click ok")
    public void clickOnApproveBtnAndClickOk() {
        absenceDetailScreen.clickApproveBtnOnAbsence();
        absenceDetailScreen.clickonOkBtn();
    }
}
