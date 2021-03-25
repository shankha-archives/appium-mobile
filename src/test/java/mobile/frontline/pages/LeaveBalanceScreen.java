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
    public MobileElement availableDays;

//    @iOSXCUITFindBy(accessibility = "Schedule_Absence_Button")
//    public MobileElement absenceBtn;

    public boolean verfyLeaveBalanceHeader(){
        return  isElementdisplayed(availableLeaveBalanceHeader);
    }

    public String verify_availableDays() throws Exception {
        if( (new GlobalParams().getPlatformName()).contains("Android")) {

            return getElementText(availableDays, "Extracting available leaves");
//            String leaveBalance = getElementText(availableDays);
//            Assert.assertTrue("Available Leaves are invalid", Float.parseFloat(leaveBalance) >= 0);
//            utils.log().info("Available Days are valid");
        }
        else{
            return null;
//                isElementdisplayed(absenceBtn);
//                Assert.assertTrue("Absence button is not displayed", absenceBtn.isDisplayed());
//                utils.log().info("Absence button is displayed");
        }
    }
}
