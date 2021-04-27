package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;

public class PeopleDetailScreen extends BasePage {

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

    public PeopleDetailScreen() {
    }

    public boolean waitForEmployeeName(){
      return isElementDisplayed(fullEmployeeName,"Waiting for employee name to display");
    }

    public boolean waitWorkEmail(){
       return isElementDisplayed(WorkEmail,"Waiting for work email detail to display");
    }

    public String getWorkEmailText(){
       return getElementText(WorkEmailData,"Extracting work email data");
    }

    public boolean waitPersonalPhone(){
       return isElementDisplayed(PersonalPhone,"Waiting for personal phone detail to display");
    }

    public String getPersonalPhoneText(){
        return getElementText(PersonalPhoneData,"Extracting personal phone data");
    }

    public boolean waitPersonalEmail(){
        return isElementDisplayed(PersonalEmail,"Waiting for personal email detail to display");
    }

    public String getPersonalEmailText(){
        return getElementText(PersonalEmailData,"Extracting personal email data");
    }
}
