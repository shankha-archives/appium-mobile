package com.appiumframework.tests;

import com.appiumframework.core.BaseTest;
import com.appiumframework.pages.LoginPage;
import com.appiumframework.pages.PinEntryPage;
import com.appiumframework.pages.StartPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;
    PinEntryPage pinEntryPage;

    @BeforeClass
    public void beforeClass() {

    }

    @AfterClass
    public void afterClass() {

    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage();
    }

    @Test
    public void zzz() throws InterruptedException {
        loginPage.switchContextToWebview();
        loginPage.enterUserName();
        loginPage.enterPassword();
    }

}
