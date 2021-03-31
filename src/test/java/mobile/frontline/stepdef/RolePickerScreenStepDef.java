package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.RolePickerScreen;
import org.junit.Assert;

public class RolePickerScreenStepDef {

    public RolePickerScreen rolePickerScreen = new RolePickerScreen();

    @Then("^the user is presented with the role picker$")
    public void role_picker_page_displayed() throws Throwable {
        //loginPage.rolePickerPageLoads();
        Assert.assertTrue("Role picker is not displayed", rolePickerScreen.rolePickerPageLoads());
    }
}