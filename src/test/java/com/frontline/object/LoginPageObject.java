package com.frontline.object;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject
{
    @CacheLookup
    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement username;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(id="")
    public MobileElement loginButton;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(id = "")
    public MobileElement enterPassword;

    @CacheLookup
    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(accessibility = "")
    @FindBy(id = "")
    public MobileElement password;
}
