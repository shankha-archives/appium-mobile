package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;

public class OrgPickerScreen extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select an Organization']")
    @iOSXCUITFindBy(accessibility = "Select an Organization")
    public MobileElement orgPickerPageHeader;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    public MobileElement associatedOrgForSub1;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
    @iOSXCUITFindBy(accessibility = "Continue")
    public MobileElement contbtn;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]")
    public MobileElement associatedOrgForSub2;

  public  OrgPickerScreen(){}

    public boolean orgPickerPageLoads() {
//        isElementDisplayed(orgPickerPageHeader);
//        Assert.assertTrue("Organization picker page is not displayed", orgPickerPageHeader.isDisplayed());
//        utils.log().info("Organization picker page is displayed");
        return isElementDisplayed(orgPickerPageHeader,"Waiting for Organization picker page to load") ;
    }

//    public void selectOrg() {
//        isElementdisplayed(associatedOrgForSub1);
//        Assert.assertTrue("Available Organizations are not displayed", associatedOrgForSub1.isDisplayed());
//        utils.log().info("Available Organizations are  displayed");
//        click(associatedOrgForSub1);
//        click(contbtn);
//    }

    public void clickFirstOrganization(){
        click(associatedOrgForSub1);
    }
    public void clickContinueBtn(){
        click(contbtn);
    }

    public void clickSecondOrganization() {
        click(associatedOrgForSub2);
    }

}
