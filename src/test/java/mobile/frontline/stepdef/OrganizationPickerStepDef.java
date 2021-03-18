package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.OrgPickerScreen;
import org.junit.Assert;

public class OrganizationPickerStepDef {

    public OrgPickerScreen orgPickerScreen = new OrgPickerScreen();

    @Then("^the user is presented with the org picker$")
    public void org_picker_page_displayed() throws Throwable {
        //loginPage.orgPickerPageLoads();
        Assert.assertTrue("Organization picker is not displayed",orgPickerScreen.orgPickerPageLoads());
    }
}
