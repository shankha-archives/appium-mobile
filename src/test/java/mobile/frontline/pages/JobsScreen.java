package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JobsScreen extends BasePage {

    public TestDataManager testdata = new TestDataManager();

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Jobs']")
    @iOSXCUITFindBy(accessibility = "view_header")
    public MobileElement availableJobsHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Scheduled']")
    @iOSXCUITFindBy(accessibility = "Scheduled")
    public MobileElement scheduledJobHeader;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/job_cell_information_inner_cointainer")
    @iOSXCUITFindBy(accessibility = "jobListingCell_right_angle_arrow")
    public MobileElement jobslist;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Available']")
    @iOSXCUITFindBy(accessibility = "Available")
    public MobileElement available;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Job']")
   // @iOSXCUITFindBy(accessibility = "Available")
    public MobileElement jobSortBtn;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/sort_by_header")
    // @iOSXCUITFindBy(accessibility = "Available")
    public MobileElement sortByPopUp;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/job_date_selection_text")
    // @iOSXCUITFindBy(accessibility = "Available")
    public MobileElement jobDateFilter;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/job_check")
    // @iOSXCUITFindBy(accessibility = "Available")
    public MobileElement jobDateSelection;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/post_date_selection_text")
    // @iOSXCUITFindBy(accessibility = "Available")
    public MobileElement postDateFilter;

    public WebElement scrolledToElement;

    public JobsScreen() {
    }

    public boolean waitForJobPageDisplayed() throws Throwable {
        return isElementDisplayed(availableJobsHeader, "Waiting for job page header");
    }

    public void clickOnAvailableJobs(String jobByEmp) throws Throwable {
        if (new GlobalParams().getPlatformName().contains("Android")) {
            scrolledToElement = androidScrollToElementUsingUiScrollable("text", jobByEmp, "Scrolling to  the required job");
            scrolledToElement.click();
        } else {
            By findJob = By.xpath("//XCUIElementTypeStaticText[contains(@label,'" + jobByEmp + "')]");
            scrollToElement_iOS(findJob, "up","Scrolling to the required available job");
            click(findJob, "Clicking on on Required Job");
        }
    }

    public void clickOnAvailableJob(String jobByEmp, String jobDay) throws Exception {
        By availableJob;
        if (new GlobalParams().getPlatformName().contains("Android"))
            availableJob  = By.xpath(
                    "(//android.widget.TextView[@text='"+jobByEmp+"']/following:: android.widget.TextView[@text='"
                            + changeDateFormat(nextWorkingDay(jobDay, "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM d")  + "'])[1]");
        else
            availableJob  = By.xpath("((//XCUIElementTypeStaticText[@label = '"+jobByEmp+"'])[1]/following::XCUIElementTypeStaticText[@label = " +
                    "'" + changeDateFormat(nextWorkingDay(jobDay, "MM/d/yyyy"), "MM/d/yyyy", "MMMM d") + " • 8:00 AM'])[1]");
        scrollToElement_iOS(availableJob, "up","Scrolling to the required available job");
        click(availableJob,"Clicking on available job");
    }

    public boolean waitForJobListPresent() {
        return isElementDisplayed(jobslist,"Waiting for joblist to display");
    }

    public boolean checkSchoolisPresent(String schoolName, String employeeName) throws Exception {
        if (new GlobalParams().getPlatformName().contains("Android")) {
            By employeeSchool = By.xpath("(//android.widget.TextView[@text='" + employeeName + "']/following:: android.widget.TextView[@text='" + testdata.read_property("testingData", "users", schoolName) + "'])[1]");
            return isElementPresent(scrollToElement_iOS(employeeSchool, "up", "Scrolling to the required job"));
        } else {
            By employeeSchool = By.xpath("((//XCUIElementTypeStaticText[@label = '" + employeeName + "'])[1]/following::XCUIElementTypeStaticText[@label='" + testdata.read_property("testingData", "users", schoolName) + "'])[1]");
            return isElementPresent(scrollToElement_iOS(employeeSchool, "up", "Scrolling to the required job"));
        }
    }

    public boolean checkJobDurationisPresent(String duration, String employeeName) throws Exception {
        if (new GlobalParams().getPlatformName().contains("Android")) {
            By jobDuration = By.xpath("(//android.widget.TextView[@text='" + employeeName + "']/following:: android.widget.TextView[@text='" + duration + "'])[1]");
            return isElementPresent(scrollToElement_iOS(jobDuration, "up", "Scrolling to the required job"));
        } else {
            By jobDuration = By.xpath("((//XCUIElementTypeStaticText[@label = '" + employeeName + "'])[1]/following::XCUIElementTypeStaticText[@label='" + duration + "'])[1]");
            return isElementPresent(scrollToElement_iOS(jobDuration, "up", "Scrolling to the required job"));
        }
    }

    public boolean waitForJobIsAvailable(String employeeName) throws Exception {
        By jobDate;
        if (new GlobalParams().getPlatformName().contains("Android")) {
            jobDate = By.xpath(
                    "(//android.widget.TextView[@text='" + employeeName + "']/following:: android.widget.TextView[@text='"
                            + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
        } else {
            jobDate = By.xpath(
                    "((//XCUIElementTypeStaticText[@label = '" + employeeName + "'])[1]/following::XCUIElementTypeStaticText[@label = " +
                            "'" + changeDateFormat(nextWorkingDay("next day", "MM/d/yyyy"), "MM/d/yyyy", "MMMM d") + " • 8:00 AM'])[1]");
        }
        return scrollToVerifyElement(jobDate, "up", "Scrolling to the required job");
    }

    public boolean waitForJobInScheduledTab() throws Exception {
        By jobDate;
        if (new GlobalParams().getPlatformName().contains("Android")) {
            jobDate = By.xpath(
                    "(//android.widget.TextView[@text='"
                            + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
        } else {
            jobDate = By.xpath(
                    "(//XCUIElementTypeStaticText[@label = " +
                            "'" + changeDateFormat(nextWorkingDay("next day", "MM/d/yyyy"), "MM/d/yyyy", "MMMM d") + " • 8:00 AM'])[1]");
        }
        return scrollToVerifyElement(jobDate, "up", "Scrolling to the required job");
    }

    public boolean waitForAcceptedTab() {
        return isElementDisplayed(scheduledJobHeader, "Waiting for accepted job tab to be visible ");
    }

    public boolean waitForAvailableTab() {
        return isElementDisplayed(available, "Waiting for available job tab to be visible");
    }

    public void clickOnScheduledJobPageHeader() throws Throwable {
        click(scheduledJobHeader, "Clicking on Scheduled job page header");
    }

    public void clickJobSortBtn(){
        click(jobSortBtn, "Clicking on Job sort filter btn");
    }

    public boolean waitForJobDateFilter() {
        return isElementDisplayed(jobDateFilter, "Waiting for job Date Filter to be visible ");
    }

    public boolean waitForSortByPopUp() {
        return isElementDisplayed(sortByPopUp, "Waiting for SortBy Pop Up to be visible ");
    }

    public boolean waitForJobDateSelection() {
        return isElementDisplayed(jobDateSelection, "Waiting for Job Date Selection to be visible ");
    }

    public String getPostDateDetails() throws Exception {
        isElementDisplayed(postDateFilter, "Waiting for Post Date Details to be visible");
        return getElementText(postDateFilter, "Extracting text details of post date filter");
    }

    public void clickPostJobFilterOption(){
        click(postDateFilter, "Clicking on post Date Filter filter btn");
    }
}
