package mobile.frontline.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import mobile.frontline.pages.CustomizeHomeScreen;

public class CustomizeHomeScreenStepDef {

    CustomizeHomeScreen customizeHomeScreen = new CustomizeHomeScreen();

    @And("Change the widget order")
    public void changeTheWidgetOrder() throws Throwable {
        customizeHomeScreen.rearrangeWidget();
    }

    @And("Click on save arranged widgets button")
    public void clickOnSaveArrangedWidgetsButton() {
        customizeHomeScreen.saveReorderedWidget();
    }
}
