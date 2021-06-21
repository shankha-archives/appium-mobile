package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @And("Verify the job duration {string} {string}")
    public void verifyTheJobDuration(String employeeName, String duration) throws Exception {
        Assert.assertTrue("Job is not available in joblist",jobsScreen.checkJobDurationisPresent(duration, employeeName));
    }

    @And("Click on sort filter btn")
    public void clickOnSortFilterBtn() {
        jobsScreen.clickJobSortBtn();
    }

    @Then("Validate the sort by pop up")
    public void validateTheSortByPopUp() throws Exception {
        Assert.assertTrue("Job is not available in joblist",jobsScreen.waitForSortByPopUp());
        Assert.assertTrue("Job is not available in joblist",jobsScreen.waitForJobDateFilter());
        Assert.assertTrue("Job is not available in joblist",jobsScreen.waitForJobDateSelection());
        Assert.assertEquals("The subscription is inactive with other plan",jobsScreen.getPostDateDetails(),"Post Date (Premium)");
    }

    @When("Click on post job filter")
    public void clickOnPostJobFilter() {
        jobsScreen.clickPostJobFilterOption();
    }

    @When("Validate the job selected filter")
    public void validateTheJobSelectedFilter() {
        Assert.assertTrue("Job is not available in joblist",jobsScreen.waitForJobDateSelection());
    }

    @When("Validate the post selected filter")
    public void validateThePostSelectedFilter() {
        Assert.assertTrue("Job is not available in joblist",jobsScreen.waitForPostDateSelection());
    }

    @And("Click on post sort filter btn")
    public void clickOnPostSortFilterBtn() {
        jobsScreen.clickPostSortBtn();
    }

    @Then("Verify sort by post header")
    public void verifySortByPostHeader() throws Exception {
        Assert.assertEquals("The post job header is not displayed",jobsScreen.getPostJobHeader(),"Most Recently Posted");
    }

    @And("Validate the up\\/down arrows")
    public void validateTheUpDownArrows() {
        Assert.assertTrue("Job filter up down arrow is not displayed",jobsScreen.waitForUpDownArrow());
    }
}