package mobile.frontline.pages;

import mobile.Frontline.utils.GlobalParams;
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
	//JobsMethods jobs = new JobsMethods();

	@AndroidFindBy(xpath = "//android.view.View[@text='Sign in with a Frontline ID']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign in with a Frontline ID']")
	public MobileElement splashHeader;

	@AndroidFindBy(className = "android.widget.EditText")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Frontline - Sign In']/XCUIElementTypeOther[7]/XCUIElementTypeTextField")
	public MobileElement username;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Get Started']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Get Started']")
	public MobileElement getStarted;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Work Without Limits']")
	@iOSXCUITFindBy(accessibility = "Work Without Limits")
	public MobileElement splashScreen;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Unlock Code']")
	@iOSXCUITFindBy(accessibility = "Enter Unlock Code")
	public MobileElement enterUnlockCode;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='7']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='7']")
	public MobileElement enterCode7;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='3']")
	public MobileElement enterCode3;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='5']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='5']")
	public MobileElement enterCode5;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='4']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='4']")
	public MobileElement enterCode4;

	@AndroidFindBy(className = "android.view.View")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign in with a Frontline ID']")
	public MobileElement loginPageHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='You may not have access yet.']")
	@iOSXCUITFindBy(accessibility = "You may not have access yet.")
	public MobileElement pinUnlockErr;

	@AndroidFindBy(xpath = "(//*[android.widget.EditText])[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Frontline - Sign In']/XCUIElementTypeOther[9]/XCUIElementTypeSecureTextField")
	public MobileElement password;

	@AndroidFindBy(className = "android.widget.Button") //class_name : qa-button-login
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Sign In with Frontline ID']")
	public MobileElement loginBtn;

	@AndroidFindBy(xpath = "//android.view.View[@text='Your username is required.']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your username is required.']")
	public MobileElement userNameRequired;

	@AndroidFindBy(xpath = "//android.view.View[@text='Your password is required.']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your password is required.']")
	public MobileElement userPasswordRequired;
	@AndroidFindBy(xpath = "//android.view.View[@text='Forgot Username']")
	//@iOSXCUITFindBy(accessibility = "")
	public MobileElement forgotUsername;

	@AndroidFindBy(xpath = "//android.view.View[@text='Forgot Password']")
	//@iOSXCUITFindBy(accessibility = "")
	public MobileElement forgotPassword;

	@AndroidFindBy(xpath = "//android.view.View[@text='The username or password you entered is incorrect']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='The username or password you entered is incorrect']")
	public MobileElement credentialErr;

	@AndroidFindBy(id = "com.frontline.frontlinemobile:id/welcome_user_text")
	@iOSXCUITFindBy(accessibility = "New Version Available_ModuleHeader")
	public MobileElement homePageHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select a Role']")
    //@iOSXCUITFindBy(accessibility = "")
    public MobileElement rolePickerPageHeader;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select an Organization']")
    //@iOSXCUITFindBy(accessibility = "")
    public MobileElement orgPickerPageHeader;
    
   // @AndroidFindBy(xpath = "")
   // @iOSXCUITFindBy(accessibility = "")
    public MobileElement noLoginDialogBox;
    
    //@AndroidFindBy(xpath = "")
   // @iOSXCUITFindBy(accessibility = "")
    public MobileElement orgWithOnlySubRole;
    
   // @AndroidFindBy(xpath = "")
    //@iOSXCUITFindBy(accessibility = "")
    public MobileElement errorMessageLogin;
    
    //@AndroidFindBy(xpath = "")
   // @iOSXCUITFindBy(accessibility = "")
    public MobileElement bckBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    public MobileElement PushNotificationAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Okay']")
    public MobileElement PushNotificationOK;


    //###################################################################
	public LoginPage(){
	}

	public void verify_splashScreen_displayed() {
		fluentWait(splashScreen);
		isElementDisplayed(splashScreen);
		Assert.assertTrue("Splash screen is not displayed", splashScreen.isDisplayed());
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
		clickElement(enterCode5);
	}
	public void clickOnCode4Btn() {
		verify_code4();
		clickElement(enterCode4);
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

	public void verify_loginPageLoaded() throws InterruptedException {
		switchToWebView();
		//Thread.sleep(35000);
		isElementDisplayed(loginPageHeader);
		Assert.assertTrue("Login Page is not displayed", loginPageHeader.isDisplayed());
		utils.log().info("Login Page Loaded successfully" );
	}

	public void verify_pinUnlokError(){
		isElementDisplayed(pinUnlockErr);
		utils.log().info("Unlock error message displays successfully" );
		Assert.assertTrue("Pin Unlock error message is not displayed", pinUnlockErr.isDisplayed());
		}


	public void enterUserID_OnLoginPage(String userName) {
		Assert.assertTrue("Email text box is not displayed", username.isDisplayed());
		//username.click();
		//driver.getKeyboard().sendKeys(userName);
		enterValueInTextField(username, userName);
	}

	public void enterPassword(String userPassword)
	{
		password.click();
		driver.getKeyboard().sendKeys(userPassword);
	}
	public void enterUserPassword_onLoginPage(String userPassword){
		hideKeyboard();
		Assert.assertTrue("Password text box is not displayed", password.isDisplayed());
		password.click();
		driver.getKeyboard().sendKeys(userPassword);
		//enterValueInTextField(password, userPassword);
	}

	public void clickOnLoginBtn() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
				hideKeyboard();
				Assert.assertTrue("Login btn is not displayed", loginBtn.isDisplayed());
				clickElement(loginBtn);
				utils.log().info("Clicked on Login Button");
				Thread.sleep(3000);
				break;
			case "iOS":
				clickElement(loginBtn);
				utils.log().info("Clicked on Login Button");
				break;
			default:
				throw new Exception("Invalid platform Name");

		}
	/*	hideKeyboard();
		Assert.assertTrue("Login btn is not displayed", loginBtn.isDisplayed());
		clickElement(loginBtn);
		utils.log().info("Clicked on Login Button");
		Thread.sleep(3000);*/
	}

	public void verifyInvalidCredentials_errorMessage() {
		fluentWait(credentialErr);
		Assert.assertTrue("No Invalid Credentials error message is displayed",
				credentialErr.isDisplayed());
		utils.log().info(" 'Invalid Credentials' error message is displayed");
	}


	public void verify_homeScreen_displayed() throws Exception {
		switch (new GlobalParams().getPlatformName()) {
			case "Android":
				Thread.sleep(8000);
				switchToNativeApp();
				isElementDisplayed(homePageHeader);
				Assert.assertTrue("Home Page is not displayed", homePageHeader.isDisplayed());
				utils.log().info("Home Page is displayed");
				break;
			case "iOS":
				isElementDisplayed(PushNotificationAllow);
				clickElement(PushNotificationAllow);
				isElementDisplayed(PushNotificationOK);
				clickElement(PushNotificationOK);
				switchToNativeApp();
				isElementDisplayed(homePageHeader);
				Assert.assertTrue("Home Page is not displayed", homePageHeader.isDisplayed());
				utils.log().info("Home Page is displayed");
				break;
			default:
				throw new Exception("Invalid platform Name");

		}
	//	switchToWebView();
	/*	Thread.sleep(8000);
		clickElement(PushNotificationAllow);
		fluentWait(PushNotificationOK);
		clickElement(PushNotificationOK);
		switchToNativeApp();
		fluentWait(homePageHeader);
		isElementDisplayed(homePageHeader);
		Assert.assertTrue("Home Page is not displayed", homePageHeader.isDisplayed());
		utils.log().info("Home Page is displayed");*/
	}

	public void verifyNoUserName_errorMessage() {
		fluentWait(userNameRequired);
		Assert.assertTrue("Your username is required error message is not displayed",
				userNameRequired.isDisplayed());
		utils.log().info("Your username is required error message is displayed");
	}

	public void verifyNoPassword_errorMessage() {
		fluentWait(userPasswordRequired);
		Assert.assertTrue("Your username is required error message is not displayed",
				userNameRequired.isDisplayed());
		utils.log().info("Your username is required error message is displayed");
	}
	
	public void rolePickerPageLoads() {
        fluentWait(rolePickerPageHeader);
        Assert.assertTrue("Role picker page is not displayed", rolePickerPageHeader.isDisplayed());
        utils.log().info("Role picker page is displayed");
	}
	
	public void orgPickerPageLoads() {
        fluentWait(orgPickerPageHeader);
        Assert.assertTrue("Organization picker page is not displayed", orgPickerPageHeader.isDisplayed());
        utils.log().info("Organization picker page is displayed");
	}
	
	public void verifyNoLoginDialogbox() {
		 fluentWait(noLoginDialogBox);
	        Assert.assertTrue("You have not been granted access to any organizations that use the Frontline Insights Platform", noLoginDialogBox.isDisplayed());
	        utils.log().info("You have not been granted access to any organizations that use the Frontline Insights Platform is displayed");
	}
	
	public void orgWithOnlySubRole() {
		fluentWait(orgWithOnlySubRole);
		clickElement(orgWithOnlySubRole);
        utils.log().info("Clicked on selected org");
      //  clickElement(jobs.contbtn);
	}
	
	public void VerifyMessage() {
		fluentWait(errorMessageLogin);
		  Assert.assertTrue("This mobile app is not currently available for substitutes", errorMessageLogin.isDisplayed());
	        utils.log().info("Error Dialog box is displayed");
	}
	
	public void clickBackBtn() {
		 clickElement(bckBtn);
	}
}
