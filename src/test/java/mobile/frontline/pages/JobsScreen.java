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
    //@iOSXCUITFindBy(accessibility = "view_header")
    public MobileElement scheduledJobHeader;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/job_cell_information_inner_cointainer")
    @iOSXCUITFindBy(accessibility = "jobListingCell_right_angle_arrow")
    public MobileElement jobslist;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='AutomationEmp 3681']/following:: android.widget.TextView[@text='GL_Performance_4CF65528C-ACCA-4ED7-9E19-D8C553C344'])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label = 'AutomationEmp 3681'])[1]/following::XCUIElementTypeStaticText[@label='GL_Performance_4CF65528C-ACCA-4ED7-9E19-D8C553C344'])[1]")
    public MobileElement jobSchoolValidationOrg1;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='AutomationEmpOrg5 3681']/following:: android.widget.TextView[@text='GL_Performance_50468ED78-1019-4F46-97AB-801A3C4AC5'])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label = 'AutomationEmpOrg5 3681'])[1]/following::XCUIElementTypeStaticText[@label='GL_Performance_4CF65528C-ACCA-4ED7-9E19-D8C553C344'])[1]")
    public MobileElement jobSchoolValidationOrg2;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='AutomationEmp 3683']/following:: android.widget.TextView[@text='ChildCareCenter'])[1]")
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@label = 'AutomationEmp 3683'])[1]/following::XCUIElementTypeStaticText[@label = 'ChildCareCenter'])[1]")
    public MobileElement jobSchoolMultidistrict1;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='AutomationEmp2 3683']/following:: android.widget.TextView[@text='GL_Performance_4CF65528C-ACCA-4ED7-9E19-D8C553C344'])[1]")
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@label = 'AutomationEmp2 3683'])[1]/following::XCUIElementTypeStaticText[@label = 'GL_Performance_4CF65528C-ACCA-4ED7-9E19-D8C553C344'])[1]")
    public MobileElement jobSchoolMultidistrict2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Available']")
    @iOSXCUITFindBy(accessibility = "Available")
    public MobileElement available;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Scheduled']")
    @iOSXCUITFindBy(accessibility = "Scheduled")
    public MobileElement accepted;

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
            scrollToElement_iOS(findJob, "up");
            click(findJob, "Clicking on on Required Job");
        }
    }

    public boolean waitForAcceptedJob() throws Exception {
        if (new GlobalParams().getPlatformName().contains("Android")) {
            By jobDate = By.xpath(
                    "(//android.widget.TextView[@text='AutomationEmp CreateJob3']/following:: android.widget.TextView[@text='"
                            + JobDetailScreen.job_date + "'])[1]");
            return IsElementNotPresent(jobDate);
        } else {
            By jobDate = By.xpath("((//XCUIElementTypeStaticText[@label = 'AutomationEmp CreateJob3'])[1]/following::XCUIElementTypeStaticText[@label = " +
                    "'" + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM d") + " • 8:00 AM'])[1]");

            return IsElementNotPresent(jobDate);
        }
    }

    public boolean waitForJobListPresent() {
        return isElementdisplayed(jobslist);
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

    public boolean waitForJobIsAvailable(String employeeName) throws Exception {
        By jobDate;
        if (new GlobalParams().getPlatformName().contains("Android")) {
            jobDate = By.xpath(
                    "(//android.widget.TextView[@text='" + employeeName + "']/following:: android.widget.TextView[@text='"
                            + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
        } else {
            jobDate = By.xpath(
                    "((//XCUIElementTypeStaticText[@label = '" + employeeName + "'])[1]/following::XCUIElementTypeStaticText[@label = " +
                            "'" + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM d") + " • 8:00 AM'])[1]");
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
                    "((//XCUIElementTypeStaticText[@label = " +
                            "'" + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM d") + " • 8:00 AM'])[1]");
        }
        return scrollToVerifyElement(jobDate, "up", "Scrolling to the required job");
    }

    public boolean waitForAcceptedTab() {
        return isElementDisplayed(accepted, "Waiting for accepted job tab to be visible ");
    }

    public boolean waitForAvailableTab() {
        return isElementDisplayed(available, "Waiting for available job tab to be visible");
    }

    public void clickOnScheduledJobPageHeader() throws Throwable {
        click(scheduledJobHeader, "Clicking on Scheduled job page header");
    }
}
