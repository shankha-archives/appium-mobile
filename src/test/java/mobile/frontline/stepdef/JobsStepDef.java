package mobile.frontline.stepdef;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.JobsMethods;
import mobile.frontline.pages.LoginPage;

public class JobsStepDef {

    public LoginPage loginPage = new LoginPage();
    public JobsMethods jobulatorPage = new JobsMethods();
    public String OrgJob1, OrgJob2;

    @Then("^the substitute user click on Get Started Button and enter the pin$")
    public void the_substitute_user_click_on_get_started_button_and_enter_the_pin() throws Throwable {
        loginPage.clickOnGetStartedBtn();
        loginPage.enterUnlockCode();
    }

    @And("^Enter username\"([^\"]*)\" and password\"([^\"]*)\" and click on Sign In button$")
    public void enter_username_and_password_and_click_on_sign_in_button(String username, String userpassword) throws Throwable {
        loginPage.verify_loginPageLoaded();
        loginPage.enterUserID_OnLoginPage(username);
        loginPage.enterUserPassword_onLoginPage(userpassword);
        loginPage.clickOnLoginBtn();
    }

    @And("^click on the Available Jobs and view job list$")
    public void click_on_the_available_jobs_and_view_job_list() throws Throwable {
        jobulatorPage.clickOnAvailableJobs_displayed();
    }

    @And("^Click on the job and accept it$")
    public void click_on_the_job_and_accept_it() throws Throwable {
        jobulatorPage.clickOnAvailableJobs();
        jobulatorPage.clickOnAcceptJobsBtn();
    }

    @Then("^the Success Message overlay is displayed$")
    public void the_success_message_overlay_is_displayed() throws Throwable {
       jobulatorPage.successMsgPOPUP();
    }
    
    @When("^I click Okay$")
    public void i_click_okay() throws Throwable {
       jobulatorPage.clickOnOkBtn_successMsg();
    }

    @Then("^Success Message is dismissed revealing accepted job details page$")
    public void success_message_is_dismissed_revealing_accepted_job_details_page() throws Throwable {
        jobulatorPage.jobDetailsPageLoads();
    }
    
    @Then("^Verify the confirmation number present on the job details page$")
    public void verify_the_confirmation_number_present_on_the_job_details_page() throws Throwable {
        jobulatorPage.confirmationPresent();
    }
    
    @Then("^the user choose the sub user of one org and extract the jobs$")
    public void the_user_choose_the_sub_user_of_one_org_and_extract_the_jobs()  {
    	jobulatorPage.selectOrg();
    	OrgJob1= jobulatorPage.checkAvailablejob();
    }
    
    @When("^the user choose the sub user of another org and extract the jobs$")
    public void the_user_choose_the_sub_user_of_another_org_and_extract_the_jobs()  {
    	jobulatorPage.switchToAnotherOrg();
    	OrgJob2=jobulatorPage.checkAvailablejob();
    }

    @Then("^verify the jobs$")
    public void verify_the_jobs() {
     Assert.assertEquals(OrgJob1, OrgJob2);
    }
    
    
//  @Then("^the substitute navigates to dashboard page$")
//  public void the_substitute_navigates_to_dashboard_page() throws Throwable {
//  	jobulatorPage.clickOnAvailableJobs();
//  }


  @And("^the dashboard displays all available jobs from all districts$")
  public void the_dashboard_displays_all_available_jobs_from_all_districts() throws Throwable {
  	jobulatorPage.clickOnAvailableJobs_displayed();
  }
}