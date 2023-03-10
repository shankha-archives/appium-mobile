package mobile.frontline.stepdef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.GlobalParams;
import mobile.frontline.pages.MenuScreen;
import org.junit.Assert;
import java.util.List;

public class MenuLinksScreenStepDef {

    public MenuScreen menuScreen = new MenuScreen();

    @And("Click on Settings")
    public void clickOnSettings() throws Exception {
        menuScreen.clickSettingsOption();
    }

    @Then("Enter search text {string}")
    public void enterSearchText(String searchResullt) {
        menuScreen.enterSearchText(searchResullt);
    }

    @When("Click on calendar search result")
    public void clickOnCalendarSearchResult() {
        menuScreen.clickOnCalendarResult();
    }

    @And("^click the absence search result$")
    public void click_the_absence_search_result() throws Throwable {
        menuScreen.clickOnAbsenceSearchResult();
    }

    @And("Long press on Frontline Logo")
    public void longPressOnFrontlineLogo() throws Exception {
        menuScreen.longPressFrontlineLogo();
    }

    @And("User click on the send Diagnostics btn")
    public void userClickOnTheSendDiagnosticsBtn() {
        menuScreen.clickSendDiagnosticsBtn();
    }

    @Then("Verify the toast message of sent diagnostic")
    public void verifyTheToastMessageOfSentDiagnostic() throws Throwable {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            Assert.assertEquals("Diagnostic is not sent", "Diagnostics sent!", menuScreen.getSendDiagnosticToastMsg());
        else
            Assert.assertEquals("Diagnostic is not sent", "Your diagnostic information has been successfully sent.", menuScreen.getSendDiagnosticToastMsg());
    }

    @When("Click on calendar in menu link")
    public void clickOnCalendarInMenuLink() {
        menuScreen.clickOnCalendarLink();
    }

    @Then("The user clicks on Feedback")
    public void theUserClicksOnFeedBack() {
        menuScreen.clickFeedBackBtn();
    }

    @Then("Validate Feedback Header")
    public void validateFeedbackHeader() throws InterruptedException {
        Assert.assertTrue("Unable to Locate Feedback Header", menuScreen.waitForFeedbackHeader());
    }

    @Then ("Verify the below menu options")
    public void verifyTheBelowMenuOptions(DataTable table) {
        List<String> data = table.asList();
        for (int i=0; i<data.size();i++)
        {
            Assert.assertTrue(menuScreen.verifyMenuLinkText(data.get(i)));
        }

    }

    @And ("Verify menu screen loaded")
    public void verifyMenuScreenLoaded() {
        Assert.assertTrue("Menu screen not loaded", menuScreen.menuScreen());
    }
}
