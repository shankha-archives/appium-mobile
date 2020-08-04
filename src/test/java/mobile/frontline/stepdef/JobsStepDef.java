package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.frontline.pages.JobsMethods;
import mobile.frontline.pages.LoginPage;

public class JobsStepDef {

    public LoginPage loginPage = new LoginPage();
    public JobsMethods jobulatorPage = new JobsMethods();

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
}
