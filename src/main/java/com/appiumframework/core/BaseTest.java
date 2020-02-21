package com.appiumframework.core;

import com.appiumframework.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.Properties;

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

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
