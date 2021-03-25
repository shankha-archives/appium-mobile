package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.AbsenceDetailScreen;
import org.junit.Assert;

public class AbsenceDetailStepDef {

    AbsenceDetailScreen absenceDetailScreen = new AbsenceDetailScreen();

    @Then("^verify the absence detail page$")
    public void verify_the_absence_detail_page() throws Throwable {
        Assert.assertTrue("Confirmation number is not displayed", absenceDetailScreen.verifydisplayConfirmationNumber());
       // smokePage.verifyAbsenceDetailPage();
    }
}
