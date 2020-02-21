package com.appiumframework.pages;

import com.appiumframework.core.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class StartPage extends BaseTest {
    @iOSXCUITFindBy(id = "Get_Started_Button") private MobileElement getGetStartedBtn;

    public PinEntryPage pressGetStartedBtn() {
        click(getGetStartedBtn);
        return new PinEntryPage();
    }
}