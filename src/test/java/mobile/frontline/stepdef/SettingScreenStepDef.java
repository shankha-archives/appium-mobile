package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.GlobalParams;
import mobile.frontline.pages.SettingScreen;
import org.junit.Assert;

public class SettingScreenStepDef {

    SettingScreen settingScreen = new SettingScreen();

    @When("Toggle the Dark Mode")
    public void toggleTheDarkMode() {
        settingScreen.clickDarkModeBtn();
    }

    @And("Logout from app")
    public void logoutFromApp() {
        settingScreen.clickLogoutbtn();
    }

    @Then("Verify the dark mode btn is OFF")
    public void verifyTheDarkModeBtnIsOFF() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            Assert.assertEquals("OFF", settingScreen.getDarkModeBtn());
        else
            Assert.assertEquals("0", settingScreen.getDarkModeBtn());
    }

    @Then("Verify the dark mode button is ON")
    public void verifyTheDarkModeButtonIsON() throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android"))
            Assert.assertEquals("ON", settingScreen.getDarkModeBtn());
        else
            Assert.assertEquals("1", settingScreen.getDarkModeBtn());
    }

    @When("Click on subscription detail button")
    public void clickOnSubscriptionDetailButton() throws InterruptedException {
        settingScreen.clickSubscriptionDetailBtn();
    }
}
