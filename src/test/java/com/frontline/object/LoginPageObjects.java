package com.frontline.object;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPageObjects 
{
        @CacheLookup
	    @AndroidFindBy(xpath = "//android.view.View[@text='Sign in with a Frontline ID']")
	    @iOSXCUITFindBy(accessibility = "")
	    public MobileElement homeHeading;

		@CacheLookup
	    @AndroidFindBy(id = "Username")
	    @iOSXCUITFindBy(accessibility = "") 
		public MobileElement username;

	    @iOSXCUITFindBy(accessibility = "")
	    @AndroidFindBy(id="Password")
	    public MobileElement password;
	    
	    @iOSXCUITFindBy(accessibility = "")
	    @AndroidFindBy(id="qa-button-login")
	    public MobileElement loginButton;

	    @iOSXCUITFindBy(accessibility = "")
	    @AndroidFindBy(xpath="//android.view.View[@text='Forgot Username']")
	    public MobileElement forgotUserName;

	    @iOSXCUITFindBy(accessibility = "")
	    @AndroidFindBy(xpath="//android.view.View[@text='Forgot Password']")
	    public MobileElement forgotPassword;

	    @iOSXCUITFindBy(accessibility = "")
	    @AndroidFindBy(xpath="//android.view.View[@text='About Frontline']")
	    public MobileElement aboutFrontline;

	    @iOSXCUITFindBy(accessibility = "")
	    @AndroidFindBy(xpath="//android.view.View[@text='Terms & Conditions']")
	    public MobileElement termsAndCondition;

	    @iOSXCUITFindBy(accessibility = "")
	    @AndroidFindBy(xpath="//android.view.View[@text='© 2020 Frontline Education. All rights reserved.']")
	    public MobileElement copyRights;
	    
	    @iOSXCUITFindBy(accessibility = "")
	    @AndroidFindBy(id="com.frontline.frontlinemobile:id/try_again_btn")
	    public MobileElement tryAgain;

	    
}
