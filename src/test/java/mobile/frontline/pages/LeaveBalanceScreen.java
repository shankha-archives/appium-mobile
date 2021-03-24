package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LeaveBalanceScreen extends BasePage {
    public LeaveBalanceScreen(){}
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Leave Balances']")
    @iOSXCUITFindBy(accessibility = "Absences")
    public MobileElement availableLeaveBalanceHeader;

    public boolean verfyLeaveBalanceHeader(){
        return  isElementdisplayed(availableLeaveBalanceHeader);
    }
}
