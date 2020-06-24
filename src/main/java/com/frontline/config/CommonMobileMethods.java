package com.frontline.config;

import com.aventstack.extentreports.Status;
import com.frontline.report.ExtentTestManager;
import com.google.common.base.Function;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class CommonMobileMethods {
    public static int LOAD_TIMEOUT = 10;

    public AppiumDriver driver;

    public CommonMobileMethods(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void wait(int n) {
        long t1, t0 = System.currentTimeMillis();
        do {
            t1 = System.currentTimeMillis();
        } while (t1 - t0 < n);
    }

    public String getPropValue(String field) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("config.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String expectedField = prop.getProperty(field);
        return expectedField;
    }

    void setLoadTime() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("config.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String loadtime = null;
        if (prop.containsKey("PAGELOAD_WAIT"))
            loadtime = getPropValue("PAGELOAD_WAIT");
        if (loadtime != null)
            LOAD_TIMEOUT = Integer.parseInt(loadtime);
    }

    public void getLoadTime() {
        setLoadTime();
    }

    public void getPageSource() {
        System.out.println(this.driver.getPageSource());
    }

    public void waitForPageToLoad(WebElement id) {
        WebDriverWait wait = new WebDriverWait((WebDriver)this.driver, LOAD_TIMEOUT);
        try {
            wait.until((Function)ExpectedConditions.visibilityOf(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToDisAppear(String id) {
        WebDriverWait wait = new WebDriverWait((WebDriver)this.driver, LOAD_TIMEOUT);
        wait.until((Function)ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
    }

    public void waitForElementClickable(WebElement id) {
        setLoadTime();
        WebDriverWait wait = new WebDriverWait((WebDriver)this.driver, LOAD_TIMEOUT);
        try {
            wait.until((Function)ExpectedConditions.elementToBeClickable(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForElement(WebElement arg) {
        waitForPageToLoad(arg);
        WebElement el = arg;
        return el;
    }

    public WebElement fluentWait(final WebElement webby) {
        FluentWait fluentWait = (new FluentWait(this.driver)).withTimeout(Duration.ofMillis(1200L)).pollingEvery(Duration.ofMillis(120L)).ignoring(NoSuchElementException.class);
        WebElement foo = (WebElement)fluentWait.until((Function)new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (webby.isDisplayed())
                    return webby;
                return webby;
            }
        });
        return foo;
    }

    public void clickBackButton() {
        this.driver.navigate().back();
    }

    public void hideKeyboard() {
        this.driver.hideKeyboard();
    }

    public String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public void clickElement(MobileElement element) {
        element.click();
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void setTextField(MobileElement element, String value) {
        element.sendKeys(new CharSequence[] { value });
    }

    public void setTextField(WebElement element, String value) {
        element.sendKeys(new CharSequence[] { value });
    }

    public void clickIOSKeyboard(String keyname) {
        try {
            List<MobileElement> el = this.driver.findElement(MobileBy.className("XCUIElementTypeKeyboard")).findElements(MobileBy.className("XCUIElementTypeButton"));
            for (MobileElement elem : el) {
                if (elem.getAttribute("name").equalsIgnoreCase(keyname))
                    elem.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickKeyboardSearch() {
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
            ((AndroidDriver)this.driver).pressKey((new KeyEvent(AndroidKey.ENTER))
                    .withFlag(KeyEventFlag.SOFT_KEYBOARD)
                    .withFlag(KeyEventFlag.KEEP_TOUCH_MODE)
                    .withFlag(KeyEventFlag.EDITOR_ACTION));
            wait(500);
            ((AndroidDriver)this.driver).pressKeyCode(66);
            wait(500);
            ((AndroidDriver)this.driver).pressKeyCode(66);
            wait(5000);
        }
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("iOS")) {
            wait(500);
            clickIOSKeyboard("Search");
            wait(3000);
        }
    }

    public void clickKeyboardDone() {
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android"))
            this.driver.hideKeyboard();
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("iOS")) {
            clickIOSKeyboard("Done");
            wait(500);
        }
    }

    public Boolean IsElementPresent(MobileElement element) {
        try {
            element.isDisplayed();
            return Boolean.valueOf(true);
        } catch (NoSuchElementException e) {
            return Boolean.valueOf(false);
        }
    }

    public Boolean IsElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return Boolean.valueOf(true);
        } catch (NoSuchElementException e) {
            return Boolean.valueOf(false);
        }
    }

    public boolean IsElementsPresent(List<MobileElement> element) {
        boolean value = false;
        try {
            if (element.size() > 0)
                value = true;
            return value;
        } catch (NoSuchElementException e) {
            return value;
        }
    }

    public boolean IsWebElementsPresent(List<WebElement> element) {
        boolean value = false;
        try {
            if (element.size() > 0)
                value = true;
            return value;
        } catch (NoSuchElementException e) {
            return value;
        }
    }

    public boolean IsElementPresent(By by) {
        try {
            this.driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void swipeDown() {
        Dimension size = this.driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int)(size.height * 0.2D);
        int endY = (int)(size.height * 0.8D);
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android"))
            (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(700L))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios"))
            (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100L))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
    }

    public void swipeUp() {
        Dimension size = this.driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int)(size.height * 0.8D);
        int endY = (int)(size.height * 0.2D);
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android"))
            (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(700L))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios"))
            (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100L))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
    }

    public void swipe(int startX, int startY, int endX, int endY, long duration) {
        (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    public void swipeUpElement(MobileElement element, int duration) {
        int topY = element.getLocation().getY();
        int bottomY = topY + element.getSize().getHeight();
        int centerX = element.getLocation().getX() + element.getSize().getWidth() / 2;
        (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(centerX, bottomY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300L))).moveTo(PointOption.point(centerX, topY))
                .release().perform();
    }

    public void scrollUp() {
        Dimension size = this.driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int)(size.height * 0.8D);
        int endY = (int)(size.height * 0.2D);
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android"))
            (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(700L))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios"))
            (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100L))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
    }

    public void scrollDown() {
        Dimension size = this.driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int)(size.height * 0.2D);
        int endY = (int)(size.height * 0.8D);
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android"))
            (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(700L))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios"))
            (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100L))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
    }

    public void swipeRight() {
        Dimension size = this.driver.manage().window().getSize();
        int startx = (int)(size.width * 0.05D);
        int endx = (int)(size.width * 0.5D);
        int starty = size.height / 2;
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android"))
            (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(startx, starty))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300L))).moveTo(PointOption.point(endx, starty))
                    .release().perform();
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios"))
            (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(0, starty))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(900L))).moveTo(PointOption.point(endx + 200, starty))
                    .release().perform();
    }

    public void swipeLeft() {
        Dimension size = this.driver.manage().window().getSize();
        int startx = (int)(size.width * 0.5D);
        int endx = (int)(size.width * 0.05D);
        int starty = size.height / 2;
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android"))
            (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(startx, starty))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300L))).moveTo(PointOption.point(endx, starty))
                    .release().perform();
        if (this.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios"))
            (new TouchAction((PerformsTouchActions)this.driver)).press(PointOption.point(startx + 100, starty))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(900L))).moveTo(PointOption.point(endx - 100, starty))
                    .release().perform();
    }

    public void swipeUpUntilTextExists(String expected) {
        do {
            swipeUp();
        } while (!this.driver.getPageSource().contains(expected));
    }

    public void swipeDownUntilTextExists(String expected) {
        do {
            swipeDown();
        } while (!this.driver.getPageSource().contains(expected));
    }

    public void swipeRightUntilTextExists(String expected) {
        do {
            swipeRight();
        } while (!this.driver.getPageSource().contains(expected));
    }

    public void swipeLeftUntilTextExists(String expected) {
        do {
            swipeLeft();
        } while (!this.driver.getPageSource().contains(expected));
    }

    public void swipeRightUntilElementExist(By by) {
        do {
            swipeRight();
        } while (!IsElementPresent(by));
    }

    public void swipeLeftUntilElementExist(By by) {
        do {
            swipeLeft();
        } while (!IsElementPresent(by));
    }

    public void swipeUpUntilElementExist(By by) {
        do {
            swipeUp();
        } while (!IsElementPresent(by));
    }

    public void swipeDownUntilElementExist(By by) {
        do {
            swipeDown();
        } while (!IsElementPresent(by));
    }

    public void swipeRightUntilElementExist(MobileElement element) {
        do {
            swipeRight();
        } while (!IsElementPresent(element).booleanValue());
    }

    public void swipeLeftUntilElementExist(MobileElement element) {
        do {
            swipeLeft();
        } while (!IsElementPresent(element).booleanValue());
    }

    public void swipeUpUntilElementExist(MobileElement element) {
        do {
            swipeUp();
        } while (!IsElementPresent(element).booleanValue());
    }

    public void swipeDownUntilElementExist(MobileElement element) {
        do {
            swipeDown();
        } while (!IsElementPresent(element).booleanValue());
    }

    public void switchToNativeApp() {
        Set<String> contextNames = this.driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE")) {
                this.driver.context(contextName);
                System.out.println("Current context" + this.driver.getContext());
            }
        }
    }

    public void getContext() {
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contextNames = this.driver.getContextHandles();
        for (String contextName : contextNames)
            System.out.println(contextName);
    }

    public void setContext(String context) {
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.driver.context(context.toString());
        System.out.println("Current context" + this.driver.getContext());
    }

    public void switchToWebView() {
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contextNames = this.driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("WEBVIEW") || contextName.contains("Webview")) {
                System.out.println("Setting WebView: " + contextName);
                this.driver.context(contextNames.toString());
                System.out.println("Current context" + this.driver.getContext());
            }
        }
    }

    public void logStepIntoExtentReport(String elementDescription, String action, String typeString) {
        ExtentTestManager.getTest().log(Status.INFO, elementDescription + "; " +
                withBoldHTML("Text") + ": " + typeString);
    }

    public void logStepIntoReport(String elementDescription) {
        ExtentTestManager.getTest().log(Status.INFO, elementDescription);
    }

    public String withBoldHTML(String string) {
        if (!string.trim().isEmpty())
            return "<b>" + string + "</b>";
        return "";
    }

    public boolean isElementPresent(By by) {
        try {
            this.driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
