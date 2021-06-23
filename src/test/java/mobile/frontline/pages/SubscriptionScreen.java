package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SubscriptionScreen extends BasePage{

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/subscription_header_line1")
    @iOSXCUITFindBy(accessibility = "SubscriptionHeaderView_Title_Label")
    public MobileElement subscriptionHeadLine;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/tv_plan_value")
    //@iOSXCUITFindBy(accessibility = "darkMode")
    public MobileElement subscriptionPlan;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/tv_status_value")
    @iOSXCUITFindBy(accessibility = "SubscriptionDetailTableViewCell_Description_Label_Active")
    public MobileElement subscriptionStatus;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/tv_validity_value")
    @iOSXCUITFindBy(accessibility = "SubscriptionHeaderView_Validity_Label")
    public MobileElement subscriptionValidity;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/free_trail_text")
    @iOSXCUITFindBy(accessibility = "SubscriptionPurchase_trailDaysLabel")
    public MobileElement freeTrailValidity;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/billed_status_message")
    @iOSXCUITFindBy(accessibility = "SubscriptionPurchase_BilledDurationHeader.")
    public MobileElement freeTrailEndBilling;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/supercharge_job_text")
    @iOSXCUITFindBy(accessibility = "SubscriptionPurchase_TrailSubstringLabel.")
    public MobileElement freeTrailBodyMessage;

    public String getSubscriptionHeadLine() throws Exception {
        isElementDisplayed(subscriptionHeadLine, "Waiting for HeadLine to be visible");
        return getElementText(subscriptionHeadLine, "Extracting text msg of HeadLine");
    }

    public String getsubscriptionPlan() throws Exception {
        isElementDisplayed(subscriptionPlan, "Waiting for Plan to be visible");
        return getElementText(subscriptionPlan, "Extracting text msg of Plan");
    }

    public String getSubscriptionStatus() throws Exception {
        isElementDisplayed(subscriptionStatus, "Waiting for Status to be visible");
        return getElementText(subscriptionStatus, "Extracting text msg of Status");
    }

    public String getSubscriptionValidity() throws Exception {
        isElementDisplayed(subscriptionValidity, "Waiting for validy to be visible");
        return getElementText(subscriptionValidity, "Extracting text msg of validy");
    }

    public String getFreeTrial() {
        isElementDisplayed(freeTrailValidity, "Waiting for Free Trail validity to be visible");
        return getElementText(freeTrailValidity, "Extracting text msg of free Trail ");
    }
    public String getFreeTrailEnd() {
        isElementDisplayed(freeTrailEndBilling, "Waiting for Free Trail validity to be visible");
        return getElementText(freeTrailEndBilling, "Extracting text msg of free Trail End Date");
    }
    public String getFreeTrailBodyStatus() {
        isElementDisplayed(freeTrailBodyMessage, "Waiting for Free Trail validity to be visible");
        return getElementText(freeTrailBodyMessage, "Extracting text msg of Free Trail body");
    }
}
