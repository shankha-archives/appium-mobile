package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.OrgPickerScreen;
import org.junit.Assert;

public class OrganizationPickerScreenStepDef {

    public OrgPickerScreen orgPickerScreen = new OrgPickerScreen();

    @Then("^the user is presented with the org picker$")
    public void org_picker_page_displayed() throws Throwable {
        Assert.assertTrue("Organization picker is not displayed",orgPickerScreen.orgPickerPageLoads());
    }

    @Then("The user choose the one organization")
    public void theUserChooseTheOneOrganization() {
        orgPickerScreen.clickFirstOrganization();
        orgPickerScreen.clickContinueBtn();
    }

    @Then("The user choose the second organization")
    public void theUserChooseTheSecondOrganization() {
        orgPickerScreen.clickSecondOrganization();
        orgPickerScreen.clickContinueBtn();
    }
}
