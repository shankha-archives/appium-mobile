package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MenuScreen extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    @iOSXCUITFindBy(accessibility = "Settings_MenuOption")
    public MobileElement settings;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search Frontline Mobile']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search Frontline Mobile']")
    public MobileElement searchBar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Feedback']")
    @iOSXCUITFindBy(accessibility = "Feedback_MenuOption")
    public MobileElement feedback;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Frontline Education would love to hear from you!']")
    @iOSXCUITFindBy(accessibility = "Frontline Education would love to hear from you.")
    public MobileElement feedbackHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Calendar_NavSearchResult']")
    public MobileElement searchResult;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@index=1])[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ABSENCES']/following-sibling::XCUIElementTypeOther[2]//XCUIElementTypeOther[1]")
    public MobileElement searchAbsReason;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage)[2]")
    @AndroidFindBy(className = "android.widget.ImageView")
    public MobileElement frontlineLogo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Send Diagnostics']")
    @AndroidFindBy(id = "send_diagnostics_button")
    public MobileElement sendDiagnosticsBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
    @iOSXCUITFindBy(accessibility = "Calendar_MenuOption")
    public MobileElement calendarLink;

    @iOSXCUITFindBy(accessibility = "Okay")
    public MobileElement okay;

    @iOSXCUITFindBy(accessibility = "Your diagnostic information has been successfully sent.")
    public MobileElement diagnosticPopup;


    public TestDataManager testdata = new TestDataManager();

    public MenuScreen(){}

    public void clickSettingsOption() throws Exception {
        scrollToElement(settings, "up", "Scrolling to the settings menu link");
        click(settings, "Clicking on setting btn");
    }

    public void enterSearchText(String searchText) {
        isElementDisplayed(searchBar,"Waiting for search bar to be visible");
        click(searchBar,"Clicking on Search Bar");
        clearTextField(searchBar);
        sendKeys(searchBar, testdata.read_property("testingData", "users", searchText), "Entering result to be searched");
    }

    public void clickOnCalendarResult() {
        click(searchResult, "Clicking on calendar Search Result");
    }

    public void clickOnAbsenceSearchResult() {
        click(searchAbsReason,"Clicking on Absence Reason Search Result");
    }

    public void longPressFrontlineLogo() throws Exception {
        TouchAction action = new TouchAction(driver);
        if( (new GlobalParams().getPlatformName()).contains("Android")) {
            int startX = frontlineLogo.getLocation().getX();
            int startY = frontlineLogo.getLocation().getY();
            action.press(PointOption.point(startX, startY)).perform();
        }
        else{
                int dragX = frontlineLogo.getLocation().x + (frontlineLogo.getSize().width / 2);
                int dragY = frontlineLogo.getLocation().y + (frontlineLogo.getSize().height / 2);
                action.press(PointOption.point(dragX, dragY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                        .release().perform();
        }
    }

    public void clickSendDiagnosticsBtn(){
        click(sendDiagnosticsBtn,"Clicking on send diagnostics btn");
    }

    public String getSendDiagnosticToastMsg() throws Throwable {
        if( (new GlobalParams().getPlatformName()).contains("Android")) {
            Thread.sleep(2000);
            WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
            return toastView.getAttribute("name");
        }else {
           isElementDisplayed(diagnosticPopup,"Waiting for diagnostic pop to load");
           return getElementText(diagnosticPopup, "Extracting text from diagnostics pop up");
        }
    }

    public void clickOnCalendarLink() {
        click(calendarLink, "Clicking on calendar link");
    }

    public void clickFeedBackBtn() {
        click(feedback, "Clicking Feedback button");
    }

    public boolean waitForFeedbackHeader() {
        return isElementDisplayed(feedbackHeader, "Waiting for feedback header");
    }

}
