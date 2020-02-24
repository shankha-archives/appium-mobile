package com.appiumframework.pages;

import com.appiumframework.core.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PinEntryPage extends BaseTest {
    @iOSXCUITFindBy(id = "7_button") private MobileElement sevenBtn;
    @iOSXCUITFindBy(id = "3_button") private MobileElement threeBtn;
    @iOSXCUITFindBy(id = "5_button") private MobileElement fiveBtn;
    @iOSXCUITFindBy(id = "4_button") private MobileElement fourBtn;

    public LoginPage pressPinBtns() {
        click(sevenBtn);
        click(threeBtn);
        click(fiveBtn);
        click(fourBtn);
        return new LoginPage();
    }
}
