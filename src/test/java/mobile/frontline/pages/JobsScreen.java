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
  //  public APIServices apiService = new APIServices();

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
        else
            {
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
}
