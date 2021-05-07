package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.JobsScreen;
import org.junit.Assert;

public class JobScreenStepDef {
    public JobsScreen jobsScreen = new JobsScreen();
    public BasePage basePage = new BasePage();

    @Then("View job list")
    public void viewJobList() throws Throwable {
        Assert.assertTrue("Job Screen is displayed", jobsScreen.waitForJobPageDisplayed());
    }

    @Then("Click on the job {string}")
    public void clickOnTheJob(String jobByEmp) throws Throwable {
        jobsScreen.clickOnAvailableJobs(jobByEmp);
    }

    @Then("Verify the created jobs {string} is present")
    public void verifyTheCreatedJobsIsPresent(String employeeName) throws Exception {
        Assert.assertTrue("The required jobs are not present", jobsScreen.waitForJobIsAvailable(employeeName));
    }

    @And("Verify job list on Jobs page")
    public void verifyJobListOnJobsPage() {
        Assert.assertTrue("Job is not present in the list", jobsScreen.waitForJobListPresent());
    }

    @And("Verify school {string} is associated with {string}")
    public void verifySchoolIsAssociatedWith(String schoolName, String employeeName) throws Exception {
        Assert.assertTrue("Job with associated school is not present in the list", jobsScreen.checkSchoolisPresent(schoolName, employeeName));
    }

    @Then("Verify available job tab")
    public void verifyAvailableJobTab() {
        Assert.assertTrue("Available job tab is not displayed", jobsScreen.waitForAvailableTab());
    }

    @And("Verify accepted job tab")
    public void verifyAcceptedJobTab() {
        Assert.assertTrue("Accepted job tab is not displayed", jobsScreen.waitForAcceptedTab());
    }

    @Then("Validate job {string} is not visible in Job List")
    public void validateJobIsNotVisibleInJobList(String employeeName) throws Exception {
        Assert.assertFalse("The required job is present", jobsScreen.waitForJobIsAvailable(employeeName));
    }

    @And("Click on the Scheduled Jobs")
    public void clickOnTheScheduledJobs() throws Throwable {
        jobsScreen.clickOnScheduledJobPageHeader();
    }

    @Then("Verify the created jobs is present in Scheduled jobs")
    public void verifyTheCreatedJobsIsPresentInScheduledJos() throws Exception {
        Assert.assertTrue("Accepted job is not displayed In Scheduled Tab",jobsScreen.waitForJobInScheduledTab());
    }

    @And("Click on the job {string} with absence {string}")
    public void clickOnTheJobWithAbsence(String employeeName, String jobDate) throws Exception {
        jobsScreen.clickOnAvailableJob(employeeName, jobDate);
    }
}