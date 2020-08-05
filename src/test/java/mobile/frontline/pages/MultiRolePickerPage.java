package mobile.frontline.pages;

import org.junit.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.TestUtils;

public class MultiRolePickerPage extends LoginPage {
	
    TestUtils utils = new TestUtils();
	
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select a Role']")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement rolePickerPageHeader;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select an Organization']")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement orgPickerPageHeader;
    
    public MultiRolePickerPage(){
    }
    
	public void rolePickerPageLoads() {
        fluentWait(rolePickerPageHeader);
        Assert.assertTrue("Role picker page is not displayed", rolePickerPageHeader.isDisplayed());
        utils.log().info("Role picker page is displayed");
	}
	
	public void orgPickerPageLoads() {
        fluentWait(orgPickerPageHeader);
        Assert.assertTrue("Organization picker page is not displayed", orgPickerPageHeader.isDisplayed());
        utils.log().info("Organization picker page is displayed");
	}

}
