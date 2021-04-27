package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestUtils;
import org.junit.Assert;

public class LoginScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Get Started']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Get Started']")
    public MobileElement getStarted;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Work Without Limits']")
    @iOSXCUITFindBy(accessibility = "Work Without Limits")
    public MobileElement splashScreen;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public MobileElement username;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    public MobileElement password;

    @AndroidFindBy(className = "android.widget.Button") // class_name : qa-button-login
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Sign In with Frontline ID']")
    public MobileElement loginBtn;

    @AndroidFindBy(xpath = "//android.view.View[@text='Your username is required.']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your username is required.']")
    public MobileElement userNameRequired;

    @AndroidFindBy(xpath = "//android.view.View[@text='Your password is required.']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your password is required.']")
    public MobileElement userPasswordRequired;

    @AndroidFindBy(xpath = "//android.view.View[@text='The username or password you entered is incorrect']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='The username or password you entered is incorrect']")
    public MobileElement credentialErr;

    @AndroidFindBy(className = "android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign in with a Frontline ID']")
    public MobileElement loginPageHeader;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/error_description")
    @iOSXCUITFindBy(accessibility = "You have not been granted access to any organizations that use the Frontline Insights Platform.")
    public MobileElement noLoginDialogBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Unlock Code']")
    @iOSXCUITFindBy(accessibility = "Enter Unlock Code")
    public MobileElement enterUnlockCode;

    public LoginScreen() {
    }

    public boolean waitSplashScreenLoaded() {
        return isElementDisplayed(splashScreen, "Searching for text: Work without limits");
    }

    public void clickOnGetStartedBtn() {
        click(getStarted, "Clicking on Get Started Button");
    }

    public boolean verify_loginPageLoaded() {
        switchToWebView();
        return isElementDisplayed(loginPageHeader, "Waiting for login page to load");
    }

    public void enterUserName(String userName) {
        enterValueInTextField(username, userName, "Entering user name");
    }

    public void enterUserPassword(String userPassword) throws Exception {
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            hideKeyboard();
            enterValueInTextField(password, userPassword, "Entering user password");
        } else {
            password.click();
            driver.getKeyboard().sendKeys(userPassword);
        }
    }

    public void clickOnLoginBtn() throws Exception {
        isElementDisplayed(loginBtn, "Waiting for login btn to display");
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            hideKeyboard();
            click(loginBtn, "Clicking on Login Button");
            Thread.sleep(3000);
        } else
            click(loginBtn, "Clicking on Login Button");
    }

    public boolean waitForInvalidCredentials_errorMessage() {
        return isElementDisplayed(credentialErr, "Waiting for invalid credentials error");
    }

    public boolean waitNoUserName_errorMessage() {
        return isElementDisplayed(userNameRequired, "Searching for username field error");
    }

    public boolean waitNoPassword_errorMessage() {
        return isElementDisplayed(userPasswordRequired, "Searching for password error");
    }

    public void loginToApplication(String userName, String password) throws Exception {
        if (verify_loginPageLoaded()) {
            enterUserName(userName);
            enterUserPassword(password);
            clickOnLoginBtn();
        }
    }

    public String waitNoLoginDialogbox() {
        isElementDisplayed(noLoginDialogBox, "Waiting for the error dialog box");
        return getElementText(noLoginDialogBox, "Extracting the error message");
    }

    public boolean waitAndverify_splashScreenLoaded() throws Exception {
        Thread.sleep(30000);
        isElementDisplayed(splashScreen, "Waiting for splash screen to display");
        Thread.sleep(30000);

        return isElementDisplayed(splashScreen, "Waiting for splash screen to display");
    }

    public boolean waitUnlockCodePage() throws Throwable {
        return IsElementNotPresent(enterUnlockCode);
    }
}