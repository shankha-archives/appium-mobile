package mobile.frontline.stepdef;

import java.util.Properties;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.PropertyManager;
import mobile.Frontline.utils.TestDataManager;
import mobile.Frontline.utils.TestUtils;
import mobile.frontline.pages.APIServices;
import mobile.frontline.pages.JobsMethods;
import mobile.frontline.pages.LoginPage;

public class JobsStepDef {

	public LoginPage loginPage = new LoginPage();
	public JobsMethods jobulatorPage = new JobsMethods();
	public String OrgJob1, OrgJob2;
	public TestDataManager testdata = new TestDataManager();
	public APIServices apiService = new APIServices();
	Properties props;
	TestUtils utils = new TestUtils();

	String confirmationNumber;
//    @Then("^the substitute user click on Get Started Button and enter the pin$")
//    public void the_substitute_user_click_on_get_started_button_and_enter_the_pin() throws Throwable {
//        loginPage.clickOnGetStartedBtn();
//    }

	@And("^click on the Available Jobs and view job list$")
	public void click_on_the_available_jobs_and_view_job_list() throws Throwable {
		jobulatorPage.clickOnAvailableJobs_displayed();
	}

//    @And("^Click on the job and accept it$")
//    public void click_on_the_job_and_accept_it() throws Throwable {
//        jobulatorPage.clickOnAvailableJobs(jobByEmp);
//        jobulatorPage.clickOnAcceptJobsBtn();
//    }

	@And("^Click on the job \"([^\"]*)\" and accept it$")
	public void click_on_the_job_something_and_accept_it(String jobByEmp) throws Throwable {
		jobulatorPage.clickOnAvailableJobs(jobByEmp);
		jobulatorPage.clickOnAcceptJobsBtn();

	}

	@Then("^the Success Message overlay is displayed$")
	public void the_success_message_overlay_is_displayed() throws Throwable {
		jobulatorPage.successMsgPOPUP();
	}

	@When("^Clicked on Okay$")
	public void i_click_okay() throws Throwable {
		jobulatorPage.clickOnOkBtn_successMsg();
	}

	@Then("^click okay on Success Message overlay$")
	public void click_okay_on_success_message() throws Throwable {
		jobulatorPage.successMsgPOPUP();
		jobulatorPage.clickOnOkBtn_successMsg();
	}

	@And("^visit available jobs page again$")
	public void visit_available_jobs_page() throws Throwable {
		jobulatorPage.clickOnHomeButton();
		jobulatorPage.clickOnAvailableJobs_displayed();
	}

	@Then("^verify if accepted job is still present$")
	public void verify_if_accepted_job_is_still_present() throws Throwable {
		jobulatorPage.verifyAcceptedJob();
	}

	@Then("^Success Message is dismissed revealing accepted job details page$")
	public void success_message_is_dismissed_revealing_accepted_job_details_page() throws Throwable {
		jobulatorPage.jobDetailsPageLoads();
	}

	@Then("^Verify the confirmation number present on the job details page$")
	public void verify_the_confirmation_number_present_on_the_job_details_page() throws Throwable {
		jobulatorPage.confirmationPresent(confirmationNumber);
	}

	@And("^Enter multiorg multirole username and password and click on Sign In button$")
	public void enter_multiorg_multirole_username_and_password_and_click_on_sign_in_button() throws Throwable {
		loginPage.verify_loginPageLoaded();
		loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "MultiOrgUser"));
		loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "MultiOrgPass"));
		loginPage.clickOnLoginBtn();
	}

	@Then("^the user choose the sub user of one org and extract the jobs$")
	public void the_user_choose_the_sub_user_of_one_org_and_extract_the_jobs() {
		jobulatorPage.selectOrg();
		OrgJob1 = jobulatorPage.checkAvailablejob();
	}

	@When("^the user choose the sub user of another org and extract the jobs$")
	public void the_user_choose_the_sub_user_of_another_org_and_extract_the_jobs() {
		jobulatorPage.switchToAnotherOrg();
		OrgJob2 = jobulatorPage.checkAvailablejob();
	}

	@Then("^verify the jobs$")
	public void verify_the_jobs() {
		Assert.assertEquals(OrgJob1, OrgJob2);
	}

	@And("^the dashboard displays all available jobs from all districts$")
	public void the_dashboard_displays_all_available_jobs_from_all_districts() throws Throwable {
		jobulatorPage.clickOnAvailableJobs_displayed();
		jobulatorPage.multiDistrictVerification();
	}

	@When("^Create absence for employee \"([^\"]*)\" with workerid \"([^\"]*)\" for \"([^\"]*)\" and delete the existing absence$")
	public void create_absence_for_employee_something_with_workerid_something_for_something_and_delete_the_existing_absence(
			String apiLoginID, String workerID, String absenceDay) throws Throwable {
		props = new PropertyManager().getProps();
		if (!props.getProperty("testdata").contains("prod")) {
			apiService.apiTokenGeneration(apiLoginID);
			apiService.apiGetConfirmationIds(workerID, absenceDay);
			apiService.apiDeleteAbsence();
			confirmationNumber = apiService.apiCreateAbsence(workerID, absenceDay);
		} else
			utils.log().info("The environment selected is prodution");
	}
}
