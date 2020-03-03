package com.appiumframework.pages;

import com.appiumframework.core.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PinEntryPage extends BaseTest {
    @iOSXCUITFindBy(id = "1_button") private MobileElement oneBtn;
    @iOSXCUITFindBy(id = "2_button") private MobileElement twoBtn;
    @iOSXCUITFindBy(id = "3_button") private MobileElement threeBtn;
    @iOSXCUITFindBy(id = "4_button") private MobileElement fourBtn;
    @iOSXCUITFindBy(id = "5_button") private MobileElement fiveBtn;
    @iOSXCUITFindBy(id = "6_button") private MobileElement sixBtn;
    @iOSXCUITFindBy(id = "7_button") private MobileElement sevenBtn;
    @iOSXCUITFindBy(id = "8_button") private MobileElement eightBtn;
    @iOSXCUITFindBy(id = "9_button") private MobileElement nineBtn;
    @iOSXCUITFindBy(id = "0_button") private MobileElement zeroBtn;

    public PinEntryPage pressIncorrectPinBtns() {
        click(oneBtn);
        click(nineBtn);
        click(oneBtn);
        click(oneBtn);
        return this;
    }

    public LoginPage pressPinBtns() {
        click(sevenBtn);
        click(threeBtn);
        click(fiveBtn);
        click(fourBtn);
        return new LoginPage();
    }
}
