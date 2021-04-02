package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.JobsScreen;
import org.junit.Assert;

public class JobScreenStepDef {
        public JobsScreen jobsScreen = new JobsScreen();
        public BasePage basePage = new BasePage();

        @Then("view job list")
        public void viewJobList() throws Throwable {
            Assert.assertTrue("Job Screen is displayed",jobsScreen.verifyJobPageDisplayed());
        }


//    @And("view job list")
//    public void viewJobList() throws Throwable {
//        Assert.assertTrue("Job Screen is displayed",jobsScreen.verifyJobPageDisplayed());
//       // basePage.scrollDown();
//    }

//    @And("Click on the job {string}")
//    public void clickOnTheJob(String jobByEmp) throws Throwable {
//        jobsScreen.clickOnAvailableJobs(jobByEmp);
//        //Assert.assertEquals(jobDate,"");
//        //jobulatorPage.clickOnAcceptJobsBtn();
//    }

        @Then("Click on the job {string}")
        public void clickOnTheJob(String jobByEmp) throws Throwable {
            jobsScreen.clickOnAvailableJobs(jobByEmp);
        }

        @Then("^verify if accepted job is still present$")
        public void verify_if_accepted_job_is_still_present() throws Throwable {
            //jobulatorPage.verifyAcceptedJob();
            Assert.assertTrue("Accepted job still present in the jobs list", jobsScreen.verifyAcceptedJob());
        }

        @Then("Verify the created jobs")
        public void verifyTheCreatedJobs() throws Throwable {
            //  jobsScreen.checkAvailablejob();
        }

        @Then("Verify available jobs from all districts")
        public void verifyAvailableJobsFromAllDistricts() throws Exception {
            //   jobsScreen.multiDistrictVerification();
        }

        @And("Verify the created jobs are available in the list")
        public void verifyTheCreatedJobsAreAvailableInTheList() throws Throwable {
            //  jobsScreen.verifyCreatedJobsAreVisibleintheList();
        }

        @Then("Verify the created jobs {string} is present")
        public void verifyTheCreatedJobsIsPresent(String employeeName) throws Exception {
          Assert.assertTrue( "The required jobs are not present", jobsScreen.verifyJobIsAvailable(employeeName));
        }

        @And("Verify job list on Jobs page")
        public void verifyJobListOnJobsPage() {
            Assert.assertTrue("Job is not present in the list",jobsScreen.verifyJobListPresent());
        }

        @And("Verify school {string} is associated with {string}")
        public void verifySchoolIsAssociatedWith(String schoolName, String employeeName) throws Exception {
            Assert.assertTrue("Job with associated school is not present in the list",jobsScreen.checkSchoolisPresent(schoolName, employeeName));
        }
    }