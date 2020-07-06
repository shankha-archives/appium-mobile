package mobile.frontline.pages;

import mobile.Frontline.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	TestUtils utils = new TestUtils();
	BasePage common = new BasePage();

	@AndroidFindBy(xpath = "//android.view.View[@text='Sign in with a Frontline ID']")
	@iOSXCUITFindBy(accessibility = "")
	public MobileElement splashHeader;

	@AndroidFindBy(className = "android.widget.EditText")
	@iOSXCUITFindBy(accessibility = "")
	public MobileElement username;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Get Started']")
	@iOSXCUITFindBy(accessibility = "")
	public MobileElement getStarted;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Work Without Limits']")
	@iOSXCUITFindBy(accessibility = "")
	public MobileElement splashScreen;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Unlock Code']")
	@iOSXCUITFindBy(accessibility = "")
	public MobileElement enterUnlockCode;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='7']")
	@iOSXCUITFindBy(accessibility = "")
	public MobileElement enterCode7;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3']")
	@iOSXCUITFindBy(accessibility = "")
	public MobileElement enterCode3;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='5']")
	@iOSXCUITFindBy(accessibility = "")
	public MobileElement enterCode5;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='4']")
	@iOSXCUITFindBy(accessibility = "")
	public MobileElement enterCode4;

	@AndroidFindBy(className = "android.view.View")
	@iOSXCUITFindBy(accessibility = "")
	public MobileElement loginPageHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='You may not have access yet.']")
	@iOSXCUITFindBy(accessibility = "")
	public MobileElement pinUnlockErr;
	//###################################################################
	public LoginPage(){
	}

	public void verify_splashScreen_displayed() {
		fluentWait(splashHeader);
		isElementDisplayed(splashHeader);
		Assert.assertTrue("Splash screen is not displayed", splashHeader.isDisplayed());
		utils.log().info("Splash screen Page is displayed");
	}

	public void verify_emailAddressTextBox() throws InterruptedException {
		waitForElementClickable(username);
		Assert.assertTrue("Email text box is not displayed", username.isDisplayed());
		//loginPageObject.username.sendKeys("xyz@abc.com");
		Thread.sleep(3000);
	}

	public void waitFor_loader_disappears()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10, 500);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("android.widget.ProgressBar")));
		} catch (NoSuchElementException e) {}
	}

	public void verify_splashScreenLoaded() {
		Assert.assertTrue("Splash Screen is not displayed", splashScreen.isDisplayed());
	}

	public void clickOnGetStartedBtn() {
		verify_splashScreenLoaded();
		common.clickElement(getStarted);
	}

	public void verify_enterUnlockCodeScreen() {
		common.waitForElement(enterUnlockCode);
		Assert.assertTrue("Enter Unlock code screen is not displayed", enterUnlockCode.isDisplayed());
	}
	public void verify_code7() {
		Assert.assertTrue("Code 7 is not displayed", enterCode7.isDisplayed());
	}

	public void verify_code3() {
		Assert.assertTrue("Code 3 is not displayed", enterCode3.isDisplayed());
	}

	public void verify_code5() {
		Assert.assertTrue("Code 5 is not displayed", enterCode5.isDisplayed());
	}

	public void verify_code4() {
		Assert.assertTrue("Code 4 is not displayed", enterCode4.isDisplayed());
	}

	public void clickOnCode7Btn() {
		verify_code7();
		common.clickElement(enterCode7);
	}

	public void clickOnCode3Btn() {
		verify_code3();
		common.clickElement(enterCode3);
	}

	public void clickOnCode5Btn() {
		verify_code5();
		common.clickElement(enterCode5);
	}
	public void clickOnCode4Btn() {
		verify_code4();
		common.clickElement(enterCode4);
	}

	public void enterUnlockCode()
	{
		verify_enterUnlockCodeScreen();
		clickOnCode7Btn();
		clickOnCode3Btn();
		clickOnCode5Btn();
		clickOnCode4Btn();
	}

	public void enterUnlockCode3()
	{
		verify_enterUnlockCodeScreen();
		clickOnCode3Btn();
		clickOnCode3Btn();
		clickOnCode3Btn();
		clickOnCode3Btn();
	}

	public void enterUnlockCode7()
	{
		verify_enterUnlockCodeScreen();
		clickOnCode7Btn();
		clickOnCode7Btn();
		clickOnCode7Btn();
		clickOnCode7Btn();
	}

	public void enterUnlockCode5()
	{
		verify_enterUnlockCodeScreen();
		clickOnCode5Btn();
		clickOnCode5Btn();
		clickOnCode5Btn();
		clickOnCode5Btn();
	}

	public void verify_loginPageLoaded() {
		common.switchToWebView();
		Assert.assertTrue("Login Page is not displayed", loginPageHeader.isDisplayed());
		utils.log().info("Login Page Loaded successfully" );
	}

	public void verify_pinUnlokError(){
		Assert.assertTrue("Pin Unlock error message is not displayed", pinUnlockErr.isDisplayed());
		utils.log().info("Unlock error message displays successfully" );
	}
}
