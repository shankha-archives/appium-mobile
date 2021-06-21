package mobile.frontline.stepdef;

import io.cucumber.java.en.Then;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.SubscriptionScreen;
import org.junit.Assert;

public class SubscriptionScreenStepDef {

    SubscriptionScreen subscriptionScreen = new SubscriptionScreen();
    BasePage basePage = new BasePage();

    @Then("Validate the active Subscription details Screen")
    public void validateTheSubscriptionDetailsScreen() throws Exception {
        Assert.assertEquals("The subscription is inactive",subscriptionScreen.getSubscriptionHeadLine(),"You're the Best!");
        Assert.assertEquals("The subscription is active with other plan",subscriptionScreen.getsubscriptionPlan(),"Yearly");
        Assert.assertEquals("The subscription is expired",subscriptionScreen.getSubscriptionStatus(),"Active");
        Assert.assertEquals("The subscription is expiry date is different",subscriptionScreen.getSubscriptionValidity(), basePage.changeDateFormat(basePage.workingDay("current day","MM/dd/yyyy",0), "MM/dd/yyyy", "MMMM dd, YYYY") );
    }

    @Then("Validate the expired Subscription details Screen")
    public void validateTheExpiredSubscriptionDetailsScreen() throws Exception {
        Assert.assertEquals("The subscription is active",subscriptionScreen.getSubscriptionHeadLine(),"Oh No!");
        Assert.assertEquals("The subscription is inactive with other plan",subscriptionScreen.getsubscriptionPlan(),"Yearly");
        Assert.assertEquals("The subscription is Active",subscriptionScreen.getSubscriptionStatus(),"Expired");
    }

    @Then("Validate the Subscription Free Trail Screen")
    public void validateTheSubscriptionFreeTrailScreen() {
        Assert.assertEquals("The Free Trail subscription is Availed",subscriptionScreen.getFreeTrial(),"14 days Free Trial");
        Assert.assertEquals("The Free Trail subscription is no more Active",subscriptionScreen.getFreeTrailBodyStatus(),"Supercharge your job search.");
        Assert.assertEquals("The Free Trail subscription is Ended",subscriptionScreen.getFreeTrailEnd(),"Billed After 14 days");
    }
}