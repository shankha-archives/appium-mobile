package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.SubscriptionScreen;
import org.junit.Assert;

public class SubscriptionScreenStepDef {

    SubscriptionScreen subscriptionScreen = new SubscriptionScreen();
    BasePage basePage = new BasePage();

    @Then("Validate the Subscription details Screen")
    public void validateTheSubscriptionDetailsScreen() throws Exception {
        Assert.assertEquals("The subscription is inactive",subscriptionScreen.getSubscriptionHeadLine(),"You're the Best!");
        Assert.assertEquals("The subscription is active with other plan",subscriptionScreen.getsubscriptionPlan(),"Yearly");
        Assert.assertEquals("The subscription is expired",subscriptionScreen.getSubscriptionStatus(),"Active");
        Assert.assertEquals("The subscription is expiry date is different",subscriptionScreen.getSubscriptionValidity(), basePage.changeDateFormat(basePage.workingDay("current day","MM/dd/yyyy",0), "MM/dd/yyyy", "MMMM dd, YYYY") );
    }
}
