package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.GlobalParams;
import mobile.frontline.pages.APIServices;
import mobile.frontline.pages.JobDetailScreen;
import org.junit.Assert;

public class JobDetailScreenStepDef {

    public JobDetailScreen jobDetailScreen = new JobDetailScreen();

    @And("accept the job")
    public void acceptTheJob() {
      //  String jobDate = jobDetailScreen.storeJobDetails();
        jobDetailScreen.storeJobDetails();
        jobDetailScreen.clickOnAcceptJobsBtn();
    }

    @Then("^the Success Message overlay is displayed$")
    public void the_success_message_overlay_is_displayed() throws Throwable {
        //jobulatorPage.successMsgPOPUP();
        if (new GlobalParams().getPlatformName().contains("Android")) {
            Assert.assertEquals("Success message is not displayed", jobDetailScreen.successMsgPOPUP(),
                    "You have Successfully accepted this Job");
        }
        else{
            Assert.assertEquals("Success message is not displayed", jobDetailScreen.successMsgPOPUP(),
                    "You have successfully accepted this job.");
        }
    }
    @When("^Clicked on Okay$")
    public void i_click_okay() throws Throwable {

        //jobulatorPage.clickOnOkBtn_successMsg();
        jobDetailScreen.clickOnOkBtn_successMsg();
    }
    @Then("^Success Message is dismissed revealing accepted job details page$")
    public void success_message_is_dismissed_revealing_accepted_job_details_page() throws Throwable {
        Assert.assertTrue("Job Details page is not displayed", jobDetailScreen.jobAcceptConfirmationMsg());
        //jobulatorPage.jobDetailsPageLoads();
    }
    @Then("^Verify the confirmation number present on the job details page$")
    public void verify_the_confirmation_number_present_on_the_job_details_page() throws Throwable {
        Assert.assertTrue("Confirmation number is not displayed", jobDetailScreen.confirmationPresent().contains(APIServices.confirmationNumber));
        //jobulatorPage.confirmationPresent(apiService.getConfirmationNumber());
    }


}
