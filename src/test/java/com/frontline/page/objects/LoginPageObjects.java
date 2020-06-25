package com.frontline.page.objects;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPageObjects 
{
	@CacheLookup
    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(accessibility = "") 
	public MobileElement username;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(id="")
    public MobileElement nextButton;
    
    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(id="")
    public MobileElement loginButton;

}
