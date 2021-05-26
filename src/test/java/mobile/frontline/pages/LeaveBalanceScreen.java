package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.junit.Assert;

public class LeaveBalanceScreen extends BasePage {
    public LeaveBalanceScreen(){}
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Available Leave Balances']")
    @iOSXCUITFindBy(accessibility = "Absences")
    public MobileElement availableLeaveBalanceHeader;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/leave_balance_duration")
    @iOSXCUITFindBy(accessibility = "Absence_TableView_Cell_Absence_Hours_Text_Label")
    public MobileElement availableDays;

    public boolean waitLeaveBalanceHeader(){
        return  isElementDisplayed(availableLeaveBalanceHeader,"Waiting for leave balance header to display");
    }

    public String get_availableDays() throws Exception {
        isElementDisplayed(availableDays,"Waiting for available leave balance");
            return getElementText(availableDays, "Extracting available leaves");
    }
}
