package com.frontline.pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import com.afpluscucumbermobile.config.CommonMobileMethods;
import com.frontline.page.objects.LoginPageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPageMethods extends CommonMobileMethods
{
	public LoginPageObjects loginPageObjects = new LoginPageObjects();
	
	public LoginPageMethods(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofMillis(10)), loginPageObjects);
	}
	public void enterEmailAddress(String email)
	{
		
	}

	
	public void enterPassword(String pass)
	{
		
	}
	
	public void clickLoginButton() {
	
    }
}
