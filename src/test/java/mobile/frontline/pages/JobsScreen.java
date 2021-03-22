package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import static mobile.frontline.pages.APIServices.*;

public class JobsScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Jobs']")
    @iOSXCUITFindBy(accessibility = "view_header")
    public MobileElement availableJobsHeader;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/job_cell_information_inner_cointainer")
    @iOSXCUITFindBy(accessibility = "jobListingCell_right_angle_arrow")
    public MobileElement jobslist;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='AutomationEmp 3681']/following:: android.widget.TextView[@text='GL_Performance_4CF65528C-ACCA-4ED7-9E19-D8C553C344'])[1]")
    public MobileElement jobSchoolValidationOrg1;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='AutomationEmpOrg5 3681']/following:: android.widget.TextView[@text='GL_Performance_50468ED78-1019-4F46-97AB-801A3C4AC5'])[1]")
    public MobileElement jobSchoolValidationOrg2;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='AutomationEmp 3683']/following:: android.widget.TextView[@text='ChildCareCenter'])[1]")
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@label = 'AutomationEmp 3683'])[1]/following::XCUIElementTypeStaticText[@label = 'ChildCareCenter'])[1]")
    public MobileElement jobSchoolMultidistrict1;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='AutomationEmp2 3683']/following:: android.widget.TextView[@text='GL_Performance_4CF65528C-ACCA-4ED7-9E19-D8C553C344'])[1]")
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@label = 'AutomationEmp2 3683'])[1]/following::XCUIElementTypeStaticText[@label = 'GL_Performance_4CF65528C-ACCA-4ED7-9E19-D8C553C344'])[1]")
    public MobileElement jobSchoolMultidistrict2;

    public WebElement scrolledToElement;

    public JobsScreen() {
    }


    public boolean verifyJobPageDisplayed() throws Throwable {
        return isElementDisplayed(availableJobsHeader);
//                isElementDisplayed(availableJobsHeader);
//                Assert.assertTrue("Available Jobs list page is not displayed", availableJobsHeader.isDisplayed());
//
//                swipeDown();
    }

    public void clickOnAvailableJobs(String jobByEmp) throws Throwable {

        if (new GlobalParams().getPlatformName().contains("Android")) {
            scrolledToElement = androidScrollToElementUsingUiScrollable("text", jobByEmp);
            scrolledToElement.click();
        }
        // storeJobDetails();
        else {
            By findJob = By.xpath("//XCUIElementTypeStaticText[contains(@label,'" + jobByEmp + "')]");
            scrollToElement(findJob, "up");
            click(findJob, "Clicking on on Required Job");
        }
    }

    public boolean verifyAcceptedJob() {
        By jobDate = By.xpath(
                "(//android.widget.TextView[@text='AutomationEmp CreateJob3']/following:: android.widget.TextView[@text='"
                        + JobDetailScreen.job_date + "'])[1]");
        return IsElementNotPresent(jobDate);
        // Assert.assertTrue("Accepted job still present in the jobs list", IsElementNotPresent(jobDate));
    }

    public void checkAvailablejob() throws Throwable {
        if (new GlobalParams().getPlatformName().contains("Android")) {
            isElementdisplayed(jobslist);

            By jobDate = By.xpath(
                    "(//android.widget.TextView[@text='AutomationEmp 3681']/following:: android.widget.TextView[@text='"
                            + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
            utils.log().info("jobDate");

            scrollToElement_iOS(jobDate, "up");
            Assert.assertTrue("Created Job is visible in the Substitutes list", IsElementPresent(jobDate) || IsElementPresent(jobSchoolValidationOrg1));

            jobDate = By.xpath(
                    "(//android.widget.TextView[@text='AutomationEmpOrg5 3681']/following:: android.widget.TextView[@text='"
                            + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
            scrollToElement_iOS(jobDate, "up");
            Assert.assertTrue("Created Job is visible in the Substitutes list", IsElementPresent(jobDate) || IsElementPresent(jobSchoolValidationOrg2));
        } else {
//			By findJob = By.xpath("//XCUIElementTypeStaticText[contains(@label,'AutomationEmp 4173')]");
//			scrollToElement(findJob, "up");
//			click(findJob, "Clicked on on Required Job");
            //throw new Exception("Invalid platform Name");
        }

    }

    public void multiDistrictVerification() throws Exception {
        switch (new GlobalParams().getPlatformName()) {
            case "Android":
                isElementdisplayed(jobslist);
                By jobDate = By.xpath(
                        "(//android.widget.TextView[@text='AutomationEmp 3683']/following:: android.widget.TextView[@text='"
                                + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
                scrollToElement_iOS(jobDate, "up");
                Assert.assertTrue("Created Job is not visible in the list", IsElementPresent(jobDate) || IsElementPresent(jobSchoolMultidistrict1));

                jobDate = By.xpath(
                        "(//android.widget.TextView[@text='AutomationEmp2 3683']/following:: android.widget.TextView[@text='"
                                + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
                scrollToElement_iOS(jobDate, "up");
                Assert.assertTrue("Created Job is not visible in the list", IsElementPresent(jobDate) || IsElementPresent(jobSchoolMultidistrict2));
                break;
            case "iOS":
                isElementdisplayed(jobslist);
                By jobDate_iOS = By.xpath(
                        "((//XCUIElementTypeStaticText[@label = 'AutomationEmp 3683'])[1]/following::XCUIElementTypeStaticText[@label = " +
                                "'" + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM d") + " • 7:00 AM'])[1]");
                scrollToElement_iOS(jobDate_iOS, "up");
                Assert.assertTrue("Created Job is not visible in the list", IsElementPresent(jobDate_iOS) || IsElementPresent(jobSchoolMultidistrict1));

                jobDate_iOS = By.xpath(
                        "((//XCUIElementTypeStaticText[@label = 'AutomationEmp2 3683'])[1]/following::XCUIElementTypeStaticText[@label = " +
                                "'" + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM d") + " • 8:00 AM'])[1]");

                scrollToElement_iOS(jobDate_iOS, "up");
                Assert.assertTrue("Created Job is not visible in the list", IsElementPresent(jobDate_iOS) || IsElementPresent(jobSchoolMultidistrict2));
                break;
            default:
                throw new Exception("Invalid platform Name");
        }
    }

    public void verifyCreatedJobsAreVisibleintheList() throws Throwable {
        switch (new GlobalParams().getPlatformName()) {
            case "Android":
                isElementdisplayed(jobslist);
                By jobDate = By.xpath(
                        "(//android.widget.TextView[@text='AutomationEmp 4173']/following:: android.widget.TextView[@text='"
                                + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
                scrollToElement_iOS(jobDate, "up");
                Assert.assertTrue("Created Job is not visible in the list", IsElementPresent(jobDate));

                jobDate = By.xpath(
                        "(//android.widget.TextView[@text='AutomationEmp 4172']/following:: android.widget.TextView[@text='"
                                + changeDateFormat(nextWorkingDay("next day", "MM/dd/yyyy"), "MM/dd/yyyy", "MMMM dd") + "'])[1]");
                scrollToElement_iOS(jobDate, "up");
                Assert.assertTrue("Created Job is not visible in the list", IsElementPresent(jobDate));
                break;
            case "iOS":
                isElementdisplayed(jobslist);
                By jobDate_iOS = By.xpath(
                        "((//XCUIElementTypeStaticText[@label = 'AutomationEmp 4173'])[1]/following::XCUIElementTypeStaticText[@label = " +
                                "'" + nextWorkingDay("next day", "MMMM d") + " • 8:00 AM'])[1]");
                scrollToElement_iOS(jobDate_iOS, "up");
                Assert.assertTrue("Created Job is not visible in the list", IsElementPresent(jobDate_iOS));

                jobDate_iOS = By.xpath(
                        "((//XCUIElementTypeStaticText[@label = 'AutomationEmp 4172'])[1]/following::XCUIElementTypeStaticText[@label = " +
                                "'" + nextWorkingDay("next day", "MMMM d") + " • 8:00 AM'])[1]");
                scrollToElement_iOS(jobDate_iOS, "up");
                Assert.assertTrue("Created Job is not visible in the list", IsElementPresent(jobDate_iOS));

                break;
            default:
                throw new Exception("Invalid platform Name");
        }
    }

//
//    public void clickOnAvailableJobs_displayed() throws Throwable {
//        switch (new GlobalParams().getPlatformName()) {
//            case "Android":
//                click(availableJobs, "Clicking available job Widget");
//                isElementDisplayed(availableJobsHeader);
//                Assert.assertTrue("Available Jobs list page is not displayed", availableJobsHeader.isDisplayed());
//                utils.log().info("Available Jobs list Page is displayed");
//                swipeDown();
//                break;
//            case "iOS":
//                verify_homeScreen_displayed();
//                click(availableJobs, "Clicking available job Widget");
//                isElementDisplayed(availableJobsHeader);
//                Assert.assertTrue("Available Jobs list page is not displayed", availableJobsHeader.isDisplayed());
//                utils.log().info("Available Jobs list Page is displayed");
//                swipeDown();
//                break;
//            default:
//                throw new Exception("Invalid platform Name");
//        }
//    }
//

}
