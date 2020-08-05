package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.MultiRolePickerPage;

public class MultiOrgRoleStepDef {

    public MultiRolePickerPage rolePicker = new MultiRolePickerPage();
    
    @Then("^the user is presented with the role picker$")
    public void role_picker_page_displayed() throws Throwable {
        rolePicker.rolePickerPageLoads();
    }
    
    @Then("^the user is presented with the org picker$")
    public void org_picker_page_displayed() throws Throwable {
        rolePicker.orgPickerPageLoads();
    }

}
