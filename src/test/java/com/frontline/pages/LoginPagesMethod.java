package com.frontline.pages;


import com.frontline.config.CommonMobileMethods;
import com.frontline.object.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPagesMethod extends CommonMobileMethods
{
   public LoginPageObject loginPageObject = new LoginPageObject();

    public LoginPagesMethod(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofMillis(10)), loginPageObject);
    }

    public void enterUserID(String userID)
    {

    }

    public void enterPassword(String password)
    {

    }

    public void clickOnLoginButton()
    {

    }


}