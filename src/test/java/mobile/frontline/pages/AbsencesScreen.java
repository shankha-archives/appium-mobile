package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbsencesScreen extends BasePage {

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/add_absence")
    @iOSXCUITFindBy(accessibility = "iconPlus")
    public MobileElement addAbsence;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Absences']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Absences']")
    public MobileElement AbsencePageHeader;

    public WebElement scrolledToElement;

    public AbsencesScreen() {
    }

    public void clickAddAbsence() {
        click(addAbsence, "Clicking on Add Absence option");
    }

    public void waitFortheSpinner1() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.xpath("//android.widget.ProgressBar[@content-desc='Progress_Bar']")));
    }

    public void clickUnfilledUnassignedAbsence(String userToSearch) throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            waitFortheSpinner1();
            scrolledToElement = androidScrollToElementUsingUiScrollable("text", userToSearch, "Scrolling to the required person to be searched");
            scrolledToElement.click();
        } else {
            By unfilledabsenceDate = By.xpath("//XCUIElementTypeStaticText[@name = '" + userToSearch + "']");
            scrollToElement_iOS(unfilledabsenceDate, "up","Scrolling to the required person to be searched");
            click(unfilledabsenceDate, "Clicking on Unfilled Absence Date");
        }
    }

    public boolean verifyAbsencesPage() {
       return isElementDisplayed(AbsencePageHeader,"Waiting for absence header to display");
    }
}
