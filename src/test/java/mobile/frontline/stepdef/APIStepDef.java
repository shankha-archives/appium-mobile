package mobile.frontline.stepdef;

import io.cucumber.java.en.When;
import mobile.Frontline.utils.PropertyManager;
import mobile.Frontline.utils.TestUtils;
import mobile.frontline.pages.APIServices;

import java.util.Properties;

public class APIStepDef {

    Properties props;
    TestUtils utils = new TestUtils();
    public APIServices apiService = new APIServices();
//    private String confirmationNumber;
//
//    public String getConfirmationNumber() {
//        return confirmationNumber;
//    }
//
//    public void setConfirmationNumber(String confNumber) {
//        this.confirmationNumber = confNumber;
//    }

    @When("^Create absence for employee \"([^\"]*)\" with workerid \"([^\"]*)\" for \"([^\"]*)\" with \"([^\"]*)\" \"([^\"]*)\" and delete the existing absence$")
    public void create_absence_for_employee_something_with_workerid_something_for_something_with_something_something_and_delete_the_existing_absence(
            String apiLoginID, String workerID, String absenceDay, String schoolID, String reasonID) throws Throwable {
        props = new PropertyManager().getProps();
        if (!props.getProperty("testdata").contains("prod")) {
            apiService.apiTokenGeneration(apiLoginID);
            apiService.apiGetConfirmationIds(workerID, absenceDay);
            apiService.apiDeleteAbsence();
            apiService.apiCreateAbsence(workerID, absenceDay, schoolID, reasonID);
        } else
            utils.log().info("The environment selected is prodution");
    }

    @When("^Create absence for employee \"([^\"]*)\" with workerid \"([^\"]*)\" for \"([^\"]*)\" with \"([^\"]*)\" \"([^\"]*)\" and delete the existing ones$")
    public void create_absence_for_employee_something_with_workerid_something_for_something_with_something_something_and_delete_the_existing_ones(
            String apiLoginID, String workerID, String absenceDay, String schoolID, String reasonID) throws Throwable {
        props = new PropertyManager().getProps();
        if (!props.getProperty("testdata").contains("prod")) {
            apiService.apiTokenGeneration(apiLoginID);
            apiService.apiGetConfirmationIds(workerID, absenceDay);
            apiService.apiDeleteAbsence();
            apiService.apiCreateAbsence(workerID, absenceDay, schoolID, reasonID);
        } else
            utils.log().info("The environment selected is prodution");
    }
}
