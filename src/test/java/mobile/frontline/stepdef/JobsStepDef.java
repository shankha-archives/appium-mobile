package mobile.frontline.stepdef;

import java.util.Properties;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.PropertyManager;
import mobile.Frontline.utils.TestDataManager;
import mobile.Frontline.utils.TestUtils;
import mobile.frontline.pages.*;
import org.junit.Assert;

public class JobsStepDef {

	public LoginPage loginPage = new LoginPage();
	public JobsMethods jobulatorPage = new JobsMethods();
	public TestDataManager testdata = new TestDataManager();
	public APIServices apiService = new APIServices();
	public Homescreen homescreen = new Homescreen();
	public JobsScreen jobsScreen = new JobsScreen();
	public BasePage basePage = new BasePage();
	public JobDetailScreen jobDetailScreen = new JobDetailScreen();
	public  APIStepDef api = new APIStepDef();

	Properties props;
	TestUtils utils = new TestUtils();

	//String confirmationNumber;

	@And("^click on the Available Jobs and view job list$")
	public void click_on_the_available_jobs_and_view_job_list() throws Throwable {
		jobulatorPage.clickOnAvailableJobs_displayed();
	}

//	@And("^Click on the job \"([^\"]*)\" and accept it$")
//	public void click_on_the_job_something_and_accept_it(String jobByEmp) throws Throwable {
//		//jobulatorPage.clickOnAvailableJobs(jobByEmp);
//		jobsScreen.clickOnAvailableJobs(jobByEmp);
//		String jobDate = jobDetailScreen.storeJobDetails();
//		//Assert.assertEquals(jobDate,"");
//		//jobulatorPage.clickOnAcceptJobsBtn();
//
//	}

//	@Then("^click okay on Success Message overlay$")
//	public void click_okay_on_success_message() throws Throwable {
//		jobulatorPage.successMsgPOPUP();
//		jobulatorPage.clickOnOkBtn_successMsg();
//	}

//	@And("^visit available jobs page again$")
//	public void visit_available_jobs_page() throws Throwable {
//		jobulatorPage.clickOnHomeButton();
//		jobulatorPage.clickOnAvailableJobs_displayed();
//	}




//	@Then("^the user choose the sub role of one org and verify the created jobs$")
//	public void the_user_choose_the_sub_role_of_one_org_and_verify_the_created_jobs() throws Throwable {
//		jobulatorPage.selectOrg();
//		jobulatorPage.clickOnAvailableJobs_displayed();
//		jobulatorPage.checkAvailablejob();
//		jobulatorPage.clickOnHomeButton();
//	}
//
//	@When("^the user choose the sub role of another org and verify the created jobs$")
//	public void the_user_choose_the_sub_role_of_another_org_and_verify_the_created_jobs() throws Throwable {
//		jobulatorPage.clickSwitchbtn();
//		jobulatorPage.switchToAnotherOrg();
//		jobulatorPage.clickOnAvailableJobs_displayed();
//		jobulatorPage.checkAvailablejob();
//	}

//	@And("^the dashboard displays all available jobs from all districts$")
//	public void the_dashboard_displays_all_available_jobs_from_all_districts() throws Throwable {
//		jobulatorPage.clickOnAvailableJobs_displayed();
//		jobulatorPage.multiDistrictVerification();
//	}

//	@When("^Create absence for employee \"([^\"]*)\" with workerid \"([^\"]*)\" for \"([^\"]*)\" with \"([^\"]*)\" \"([^\"]*)\" and delete the existing absence$")
//	public void create_absence_for_employee_something_with_workerid_something_for_something_with_something_something_and_delete_the_existing_absence(
//			String apiLoginID, String workerID, String absenceDay, String schoolID, String reasonID) throws Throwable {
//		props = new PropertyManager().getProps();
//		if (!props.getProperty("testdata").contains("prod")) {
//			apiService.apiTokenGeneration(apiLoginID);
//			apiService.apiGetConfirmationIds(workerID, absenceDay);
//			apiService.apiDeleteAbsence();
//			confirmationNumber = apiService.apiCreateAbsence(workerID, absenceDay, schoolID, reasonID);
//		} else
//			utils.log().info("The environment selected is prodution");
//	}

//	@And("^Verify the created jobs are available in the list$")
//	public void verify_the_created_jobs_are_available_in_the_list() throws Throwable {
//		jobulatorPage.verifyCreatedJobsAreVisibleintheList();
//	}

	@When("Substitute accepts the job with required details {string} {string}")
	public void substituteAcceptsTheJobWithRequiredDetails(String tokenUser, String xrefOrgID) throws Throwable {
		props = new PropertyManager().getProps();
		if (!props.getProperty("testdata").contains("prod")) {
			apiService.apiBearerTokenGeneration(tokenUser);
			apiService.apiAcceptSubstituteJob(APIServices.confirmationNumber, xrefOrgID);
		} else
			utils.log().info("The environment selected is prodution");
	}
}