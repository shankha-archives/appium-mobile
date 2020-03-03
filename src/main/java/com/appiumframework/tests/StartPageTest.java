package com.appiumframework.tests;

import com.appiumframework.core.BaseTest;
import com.appiumframework.pages.PinEntryPage;
import com.appiumframework.pages.StartPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StartPageTest extends BaseTest {
    StartPage startPage;
    PinEntryPage pinEntryPage;

    @BeforeClass
    public void beforeClass() {

    }

    @AfterClass
    public void afterClass() {

    }

    @BeforeMethod
    public void beforeMethod() {
        startPage = new StartPage();
        pinEntryPage = new PinEntryPage();
    }

    @Test
    public void fail() {
        startPage.pressGetStartedBtn();
        pinEntryPage.pressIncorrectPinBtns();
        pinEntryPage.pressIncorrectPinBtns();
        pinEntryPage.pressIncorrectPinBtns();

    }

    @Test
    public void xxx() {
//        startPage.pressGetStartedBtn();
        pinEntryPage.pressPinBtns();
    }


}
