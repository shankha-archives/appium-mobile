package com.appiumframework.pages;

import com.appiumframework.core.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseTest {
    @FindBy(id = "Username") private WebElement username;
    @FindBy(id = "Password") private WebElement password;
    @FindBy(id = "qa-button-login") private WebElement loginBtn;



    public LoginPage enterUserName() {
        sendKeysWebElement(username,"Prod01");
        return this;
    }

    public LoginPage enterPassword() {
        sendKeysWebElement(password,"Password1!");
        return this;
    }

    public LoginPage tapLoginBtn() {
        clickWebElement(loginBtn);
        return this;
    }
}