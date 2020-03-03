package com.appiumframework.core;

import com.appiumframework.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.Properties;
import java.util.Set;

public class BaseTest {
    protected static AppiumDriver driver;
    protected static Properties props;

    public BaseTest() {
        //Initliziis UI Elements for the page factory
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @BeforeTest
    public void beforeTest() throws Exception{
        try {
            props = new Properties();
            String propFileName = "config.properties";
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "iOS");
            desiredCapabilities.setCapability("platformVersion", "13.3");
            desiredCapabilities.setCapability("deviceName", "iPhone 11");
            desiredCapabilities.setCapability("automationName", "XCUITest");
            desiredCapabilities.setCapability("noReset", false);
            desiredCapabilities.setCapability("app", "/Users/sgriggs/iOS-FrontlineMobile/build/Prod-iphonesimulator/Frontline Mobile.app");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new IOSDriver(url, desiredCapabilities);
            String sessionId = driver.getSessionId().toString();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    //MobileElement Actions:
    public void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void click(MobileElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void sendKeys(MobileElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public void getAttribute(MobileElement e, String attribute) {
        waitForVisibility(e);
        e.getAttribute(attribute);
    }

    //WebElement Actions:
    public void switchContextToNative() {
        Set<String> contextNames = driver.getContextHandles();
        driver.context((String) contextNames.toArray()[1]);
        System.out.println("THE CONTEXT IS NOW SET TO " + driver.getContext());
    }

    public void waitForVisibilityWebElement(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void sendKeysWebElement(WebElement e, String txt) {
        waitForVisibilityWebElement(e);
        e.sendKeys(txt);
    }

    public void clickWebElement(WebElement e) {
        waitForVisibilityWebElement(e);
        e.click();
    }

    public void switchContextToWebview() throws InterruptedException {
        changeDriverContextToWeb(driver);
        System.out.println("THE CONTEXT IS NOW SET TO " + driver.getContext());
    }

    public static void changeDriverContextToWeb(AppiumDriver driver) throws InterruptedException {
        //allow time for the webView to load completely
        Thread.sleep(5000);
        //TODO: Find a way to wait for the webview to load without using Thread.sleep

        //gets all of the avilable contexts
        Set<String> contextNames = driver.getContextHandles();
        //Switch to WebView Context
        driver.context((String) contextNames.toArray()[1]);
        System.out.println(contextNames);
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}

//TODO: STEPS BELOW:
/*
* Change Context to webview
* Make Function in Base Class       [x]
* Wait For Visibility of LOGIN      [x]
* Wait For Visibility of PASSWORD   [x]
* Send Password to LOGIN            [x]
* Send Password to PASSWORD         [x]
*
*   TESTING FLOWS
*       CORRECT     UN/PW           [x]
*       INCORRECT   UN/PW           [ ]
*
* Upon Logging in Switch to Dashboard Class switch the context back to Mobile   [ ]
*
* Create Dashboard Page Class           [ ]
* Create Dashboard Test Cla             [ ]
*
* Add Wait for PreLoader Class to finisH FIND ACCESSABILITY ID
* Wait for Username and Password to be ENABLED
* MATT HARRIS
*
*   MISC
*       USE XCODE SAFARI INSPECTOR TO GET THE ID OF INCORRECT PASSWORD BUBBLE FOR TEST ASSERTIONS [ ]
* */