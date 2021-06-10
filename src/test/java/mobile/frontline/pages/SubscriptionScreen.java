package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SubscriptionScreen extends BasePage{

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/subscription_header_line1")
  //  @iOSXCUITFindBy(accessibility = "darkMode")
    public MobileElement subscriptionHeadLine;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/tv_plan_value")
    //  @iOSXCUITFindBy(accessibility = "darkMode")
    public MobileElement subscriptionPlan;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/tv_status_value")
    //  @iOSXCUITFindBy(accessibility = "darkMode")
    public MobileElement subscriptionStatus;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/tv_validity_value")
    //  @iOSXCUITFindBy(accessibility = "darkMode")
    public MobileElement subscriptionValidity;

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
}
