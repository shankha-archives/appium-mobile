package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.TestDataManager;
import org.junit.Assert;

public class MenuScreen extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    @iOSXCUITFindBy(accessibility = "Settings_MenuOption")
    public MobileElement settings;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search Frontline Mobile']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search Frontline Mobile']")
    public MobileElement searchBar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Calendar_NavSearchResult']")
    public MobileElement searchResult;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@index=1])[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ABSENCES']/following-sibling::XCUIElementTypeOther[2]//XCUIElementTypeOther[1]")
    public MobileElement searchAbsReason;

    public TestDataManager testdata = new TestDataManager();

    public MenuScreen(){}

    public void clickSettingsOption() throws Exception {
        scrollToElement(settings, "up", "Scrolling to the settings menu link");
       // Assert.assertTrue("Settings tab is not displayed", settings.isDisplayed());
        click(settings, "Clicking on setting btn");
    }

    public void enterSearchText(String searchText) {
        isElementDisplayed(searchBar,"Waiting for search bar to be visible");
       // Assert.assertTrue("search Bar option is not displayed", searchBar.isDisplayed());
        //searchResultText = searchText;
        //utils.log().info("Searched text is : " + searchResultText);
        click(searchBar,"Clicking on Search Bar");
        clearTextField(searchBar);
        sendKeys(searchBar, testdata.read_property("testingData", "users", searchText), "Entering result to be searched");
    }

    public void clickOnCalendarResult() {
      //  Assert.assertTrue("search Result option is not displayed", searchResult.isDisplayed());
        click(searchResult, "Clicking on calendar Search Result");
    }

    public void clickOnAbsenceSearchResult() {
        click(searchAbsReason,"Clicking on Absence Reason Search Result");
    }
}
