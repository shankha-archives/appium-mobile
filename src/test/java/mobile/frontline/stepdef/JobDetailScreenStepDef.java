package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.GlobalParams;
import mobile.frontline.pages.APIServices;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.JobDetailScreen;
import org.junit.Assert;

public class JobDetailScreenStepDef {

    public JobDetailScreen jobDetailScreen = new JobDetailScreen();
    public BasePage basePage = new BasePage();

    @And("accept the job")
    public void acceptTheJob() {
        jobDetailScreen.storeJobDetails();
        jobDetailScreen.clickOnAcceptJobsBtn();
    }

    @And("Confirm the Reject job Popup")
    public void confirmRejectPopup() throws Exception {
       // jobDetailScreen.clickOnOkBtn_successMsg();
        if (new GlobalParams().getPlatformName().contains("Android"))
        {
            jobDetailScreen.clickOnOkBtn_successMsg();
        }
        else
            {
            jobDetailScreen.clickOnOkRejectBtn_successMsg();
        }
    }

    @Then("^the Success Message overlay is displayed$")
    public void the_success_message_overlay_is_displayed() throws Throwable {
        if (new GlobalParams().getPlatformName().contains("Android")) {
            Assert.assertEquals("Success message is not displayed", jobDetailScreen.successMsgPOPUP(),
                    "You have Successfully accepted this Job");
        } else {
            Assert.assertEquals("Success message is not displayed", jobDetailScreen.successMsgPOPUP(),
                    "You have successfully accepted this job.");
        }
    }

    @And("^Clicked on Okay$")
    public void i_click_okay() throws Throwable {
        jobDetailScreen.clickOnOkBtn_successMsg();
    }

    @Then("^Success Message is dismissed revealing accepted job details page$")
    public void success_message_is_dismissed_revealing_accepted_job_details_page() throws Throwable {
        Assert.assertTrue("Job Details page is not displayed", jobDetailScreen.jobAcceptConfirmationMsg());
    }

    @Then("^Verify the confirmation number present on the job details page$")
    public void verify_the_confirmation_number_present_on_the_job_details_page() throws Throwable {
        Assert.assertTrue("Confirmation number is not displayed", jobDetailScreen.confirmationPresent().contains(APIServices.confirmationNumber));
    }

//    @Then("Verify the job event details {string}")
//    public void verifyTheJobEventDetails(String absenceDay) throws Exception {
//        if (new GlobalParams().getPlatformName().contains("Android"))
//            Assert.assertTrue("Job date is not displayed", jobDetailScreen.getJobDate().contains(common.nextWorkingDay(absenceDay, "MMMM dd, yyyy")));
//        else
//            Assert.assertTrue("Job date is not displayed", jobDetailScreen.getJobDate().contains(common.nextWorkingDay(absenceDay, "MMMM d, yyyy")));
//    }

    @And("Validate the Reject Popup Message")
    public void validateTheRejectPopup() throws Exception {
        jobDetailScreen.rejectMsgPopUp();
        Assert.assertEquals("Success message is not displayed", jobDetailScreen.rejectMsgPopUp(),
                "Are you sure you want to reject this job?");
    }

    @And("Navigate Back toward Scheduled Jobs")
    public void navigateBackTowardScheduledJobs() throws Throwable {
        jobDetailScreen.backButtonToAvailableJobScreen();
    }

    @Then("Validate the job detail page {string}")
    public void validateTheJobDetailPage(String absenceDay) throws Exception {
        Assert.assertTrue("Correct employee name is not displayed", jobDetailScreen.waitForEmployeeName());
        Assert.assertTrue("Correct school name is not displayed", jobDetailScreen.waitForSchoolName());
        if (new GlobalParams().getPlatformName().contains("Android"))
            Assert.assertTrue("Job date is not displayed", jobDetailScreen.getJobDate().contains(basePage.workingDay(absenceDay, "MMMM dd, yyyy",1)));
        else
            Assert.assertTrue("Job date is not displayed", jobDetailScreen.getJobDate().contains(basePage.workingDay(absenceDay, "MMMM d, yyyy",1)));
    }

    @And("Reject the job")
    public void rejectTheJob() throws Exception {
        jobDetailScreen.clickOnRejectJobsBtn();
    }

    @Then("Verify the job event details for {string} {string} {string}")
    public void verifyTheJobEventDetailsFor(String absenceDay, String startDay, String endDay) throws Exception {
        Assert.assertTrue("The date didnt get displayed",jobDetailScreen.waitForJobDate(absenceDay,startDay));
        if(endDay.equals("2")&&basePage.workingDay("current day","EEE", 0).equals("Fri"))
            endDay = "4";
        Assert.assertTrue("The date didnt get displayed",jobDetailScreen.waitForJobDate(absenceDay,endDay));
    }
}
