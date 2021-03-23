package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import mobile.frontline.pages.MenuScreen;

public class MenuLinksStepDef {

    public MenuScreen menuScreen  = new MenuScreen();

    @And("Click on Settings")
    public void clickOnSettings() throws Exception {
        menuScreen.clickSettingsOption();
    }
}
