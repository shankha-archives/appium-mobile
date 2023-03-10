package mobile.frontline.stepdef;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.PropertyManager;
import mobile.Frontline.utils.TestUtils;
import mobile.frontline.pages.APIServices;
import mobile.frontline.pages.BasePage;

import java.util.Properties;

public class APIStepDef {

    Properties props;
    TestUtils utils = new TestUtils();
    public APIServices apiService = new APIServices();
    BasePage basePage = new BasePage();

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

    @When("^Verify if timesheet present for an employee and delete it using information \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void verify_if_timesheet_present_for_an_employee_and_delete_it_using_information_something_something_something_something_something(
            String automationEmployee, String workerID, String orgID, String apiLoginID, String timesheetDay)
            throws Throwable {
        props = new PropertyManager().getProps();
        if (!props.getProperty("testdata").contains("prod")) {
            apiService.apiTokenGeneration(apiLoginID);
            apiService.apiBearerTokenGeneration(automationEmployee);
            apiService.apiGetTimesheetsForWeek(timesheetDay, orgID, workerID);
            apiService.apiDeleteTimeEvents(orgID, workerID);
        } else
            utils.log().info("The environment selected is prodution");
    }

    @When("Undo submitted timesheets {string} {string} {string} {string} {string} {string} {string} {string}")
    public void undoSubmittedTimesheets(String automationEmployee, String workerID, String orgID, String apiLoginID, String timesheetDay, String locationID, String shiftID, String eventID) throws Throwable {
        props = new PropertyManager().getProps();
        if (!props.getProperty("testdata").contains("prod")) {
            apiService.apiTokenGeneration(apiLoginID);
            apiService.apiBearerTokenGeneration(automationEmployee);
            apiService.apiUndoSubmittedTimesheets(timesheetDay, orgID, workerID);
            apiService.apiGetTimesheetsForWeek(timesheetDay, orgID, workerID);
            apiService.apiDeleteTimeEvents(orgID, workerID);
            apiService.apiCreateTimesheet(orgID, workerID, timesheetDay, locationID, shiftID, eventID);
        } else
            utils.log().info("The environment selected is prodution");
    }

    @When("Verify if timesheet present for an employee delete and create it using information {string} {string} {string} {string} {string} {string} {string} {string}")
    public void verifyIfTimesheetPresentForAnEmployeedeleteandcreateItUsingInformation
            (String automationEmployee, String workerID, String orgID, String apiLoginID, String timesheetDay, String locationID, String shiftID, String eventID) throws Throwable {
        props = new PropertyManager().getProps();
        if (!props.getProperty("testdata").contains("prod")) {
            apiService.apiTokenGeneration(apiLoginID);
            apiService.apiBearerTokenGeneration(automationEmployee);
            apiService.apiGetTimesheetsForWeek(timesheetDay, orgID, workerID);
            apiService.apiDeleteTimeEvents(orgID, workerID);
            apiService.apiCreateTimesheet(orgID, workerID, timesheetDay, locationID, shiftID, eventID);
        } else
            utils.log().info("The environment selected is prodution");
    }

    @When("^Verify if absences present for employee \"([^\"]*)\" with workerid \"([^\"]*)\" for \"([^\"]*)\" and delete them$")
    public void verify_if_absences_present_for_employee_something_with_workerid_something_for_something_and_delete_them(
            String apiLoginID, String workerID, String absenceDay) throws Throwable {
        props = new PropertyManager().getProps();
        if (!props.getProperty("testdata").contains("prod")) {
            apiService.apiTokenGeneration(apiLoginID);
            apiService.apiGetConfirmationIds(workerID, absenceDay);
            apiService.apiDeleteAbsence();
        } else
            utils.log().info("The environment selected is prodution");
    }

    @When("Substitute accepts the job with required details {string} {string}")
    public void substituteAcceptsTheJobWithRequiredDetails(String tokenUser, String xrefOrgID) throws Throwable {
        props = new PropertyManager().getProps();
        if (!props.getProperty("testdata").contains("prod")) {
            apiService.apiBearerTokenGeneration(tokenUser);
            apiService.apiAcceptSubstituteJob(APIServices.confirmationNumber, xrefOrgID);
        } else
            utils.log().info("The environment selected is prodution");
    }

    @When("Create multiday absence for employee {string} with user {string} workerid {string} for {string} with {string} {string} days {string} {string} and delete the existing ones")
    public void createMultidayAbsenceForEmployeeWithUserWorkeridForWithDaysAndDeleteTheExistingOnes
            (String apiLoginID,String automationEmployee, String workerID, String absenceDay, String schoolID, String reasonID, String startDay, String endDay) throws Throwable {
        props = new PropertyManager().getProps();
        if (!props.getProperty("testdata").contains("prod")) {
            apiService.apiTokenGeneration(apiLoginID);
            apiService.apiBearerTokenGeneration(automationEmployee);
            apiService.apiGetConfirmationIds(workerID, absenceDay);
            apiService.apiDeleteAbsence();
            if(endDay.equals("2")&&basePage.workingDay("current day","EEE", 0).equals("Fri"))
                endDay = "4";
            apiService.apiCreateMultidayAbsence (workerID, schoolID, reasonID,  absenceDay, startDay, endDay);
        } else
            utils.log().info("The environment selected is prodution");
    }
}
