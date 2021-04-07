package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;

public class PeopleDetailScreen extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ATMobile ATMobile']")
    @iOSXCUITFindBy(accessibility = "EmployeeDetailView_FullName_StaticText")
    public MobileElement fullEmployeeName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Personal Phone']")
    @iOSXCUITFindBy(accessibility = "Personal Phone")
    public MobileElement PersonalPhone;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='7846948974 ext: 123']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[4]")
    public MobileElement PersonalPhoneData;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Work Email']")
    @iOSXCUITFindBy(accessibility = "Work Email")
    public MobileElement WorkEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='mohit.singla1@frontlineed.com']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[6]")
    public MobileElement WorkEmailData;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Personal Email']")
    @iOSXCUITFindBy(accessibility = "Personal Email")
    public MobileElement PersonalEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='mohit.singla1@frontlineed.com']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[7]")
    public MobileElement PersonalEmailData;

    public PeopleDetailScreen(){}

    public void verifyContactDetails() {
        Assert.assertTrue("Work Phone is not displayed", (// WorkPhone.isDisplayed() ||
                // getElementText(WorkPhoneData).length() > 0 ||
                fullEmployeeName.isDisplayed() ||
                        WorkEmail.isDisplayed() || getElementText(WorkEmailData).length() > 0)
                // || OtherPhone.isDisplayed()|| getElementText(OtherPhoneData).length() > 0
                || PersonalPhone.isDisplayed() || getElementText(PersonalPhoneData).length() > 0
                || PersonalEmail.isDisplayed() || getElementText(PersonalEmailData).length() > 0);
        utils.log().info("Details are displayed");
    }
}
