package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.TestUtils;
import org.junit.Assert;

public class LoginScreen extends BasePage {

    TestUtils utils = new TestUtils();

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
    // @iOSXCUITFindBy(accessibility = "")
    public MobileElement noLoginDialogBox;

    public LoginScreen() {
    }

    public boolean verifySplashScreenLoaded() {
      //  isElementDisplayed(splashScreen, "Searching for text: Work without limits");
        return  isElementDisplayed(splashScreen, "Searching for text: Work without limits");
    }

    public void clickOnGetStartedBtn() {
        click(getStarted, "Clicking on Get Started Button");
    }

    public boolean verify_loginPageLoaded() {
        switchToWebView();
//        isElementDisplayed(loginPageHeader);
        return isElementDisplayed(loginPageHeader,"Waiting for login page to load");
    }

    public void enterUserName(String userName) {
       // isElementDisplayed(username);
        enterValueInTextField(username, userName,"Entering user name");
    }

    public void enterUserPassword(String userPassword) throws Exception {
       // isElementDisplayed(password);
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            hideKeyboard();
            enterValueInTextField(password, userPassword,"Entering user password");
        } else {
            password.click();
            driver.getKeyboard().sendKeys(userPassword);
        }
    }

    public void clickOnLoginBtn() throws Exception {
        isElementDisplayed(loginBtn);
        if ((new GlobalParams().getPlatformName()).contains("Android")) {
            hideKeyboard();
            click(loginBtn, "Clicking on Login Button");
            Thread.sleep(3000);
        }
        else
                click(loginBtn, "Clicking on Login Button");
    }
    public boolean verifyInvalidCredentials_errorMessage() {
       // isElementDisplayed(credentialErr);
        return isElementDisplayed(credentialErr, "Waiting for invalid credentials error");
    }


    public boolean verifyNoUserName_errorMessage() {
        //isElementDisplayed(userNameRequired);
        return isElementDisplayed(userNameRequired,"Searching for username field error");
    }

    public boolean verifyNoPassword_errorMessage() {
       // isElementDisplayed(userPasswordRequired);
        return isElementDisplayed(userPasswordRequired, "Searching for password error");
    }

    public void loginToApplication(String userName, String password) throws Exception {
        if (verify_loginPageLoaded()){
            enterUserName(userName);
            enterUserPassword(password);
            clickOnLoginBtn();
        }
//        else
//            utils.log().info("Login page didnt appear");
    }
    public String verifyNoLoginDialogbox() {
        isElementDisplayed(noLoginDialogBox);
        return getElementText(noLoginDialogBox);
//        Assert.assertEquals("You have been granted access to any organizations that use the Frontline Insights Platform",
//                getElementText(noLoginDialogBox),"You have not been granted access to any organizations that use the Frontline Insights Platform.");
//        utils.log().info(
//                "You have not been granted access to any organizations that use the Frontline Insights Platform is displayed");
    }


    public boolean waitAndverify_splashScreenLoaded() throws Exception {
        Thread.sleep(30000);
        isElementDisplayed(splashScreen);
        Thread.sleep(30000);

        return splashScreen.isDisplayed();
       // Assert.assertTrue("Splash Screen is not displayed", splashScreen.isDisplayed());
    }
}