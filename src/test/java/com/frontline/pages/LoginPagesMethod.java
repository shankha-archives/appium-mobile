package com.frontline.pages;

import com.frontline.object.LoginPageObjects;
import config.CommonMobileMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

public class LoginPagesMethod extends CommonMobileMethods {

	public LoginPageObjects loginPageObject = new LoginPageObjects();
	public CommonMobileMethods comman;

	public LoginPagesMethod(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofMillis(10)), loginPageObject);
		comman = new CommonMobileMethods(driver);
	}

	public void enterEmailAddress(String email) {
		verify_emailAddressTextBox();
		comman.enterValueInTextField(loginPageObject.username, email);
	}

	public void verify_emailAddressTextBox() {
		Assert.assertTrue("Email text box is not displayed", loginPageObject.username.isDisplayed());
	}

	public void verify_passwordlAddressTextBox() {
		Assert.assertTrue("Password text box is not displayed", loginPageObject.password.isDisplayed());
	}

	public void enterPassword(String pass) {
		verify_passwordlAddressTextBox();
		comman.enterValueInTextField(loginPageObject.password, pass);
	}

	public void verify_loginBtn() {
		Assert.assertTrue("Password text box is not displayed", loginPageObject.password.isDisplayed());
	}

	public void clickLoginButton() {
		verify_loginBtn();
		comman.clickElement(loginPageObject.loginButton);
	}

	public void loginPageHeader() {
		waitForElementClickable(loginPageObject.homeHeading);
		Assert.assertTrue("Home Page is not displayed", loginPageObject.homeHeading.isDisplayed());
	}
	
	public void clickOnTryAgainBtn() {
		comman.clickElement(loginPageObject.tryAgain);
	}

}