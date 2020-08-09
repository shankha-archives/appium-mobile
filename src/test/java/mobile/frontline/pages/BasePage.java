package mobile.frontline.pages;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobile.Frontline.utils.CommandPrompt;
import mobile.Frontline.utils.DriverManager;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.Utils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

//import com.aventstack.extentreports.Status;
//import io.appium.java_client.android.AndroidKeyCode;

@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public class BasePage {
    public static int LOAD_TIMEOUT = 50;
    int generic_timeOutInMiliSeconds = 5000;
    private CommandPrompt cmd = new CommandPrompt();


    public AppiumDriver<MobileElement> driver;
    Utils utils = new Utils();

    public BasePage(){
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Utils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, Utils.WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    public void clear(MobileElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void click(MobileElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void click(MobileElement e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.click();
    }

    public void click(By e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        driver.findElement(e).click();
    }

    public void sendKeys(MobileElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public void sendKeys(MobileElement e, String txt, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.sendKeys(txt);
    }

    public String getAttribute(MobileElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getAttribute(By e, String attribute) {
        waitForVisibility(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    public String getText(MobileElement e, String msg) {
        String txt;
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
        }
        utils.log().info(msg + txt);
        return txt;
    }

    public String getText(By e, String msg) {
        String txt;
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
        }
        utils.log().info(msg + txt);
        return txt;
    }

    public void closeApp() {
        ((InteractsWithApps) driver).closeApp();
    }

    public void launchApp() {
        ((InteractsWithApps) driver).launchApp();
    }

    public MobileElement andScrollToElementUsingUiScrollable(String childLocAttr, String childLocValue) {
        return (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector()."+ childLocAttr +"(\"" + childLocValue + "\"));");
    }

    public MobileElement iOSScrollToElementUsingMobileScroll(MobileElement e) {
        RemoteWebElement element = ((RemoteWebElement) e);
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
//	  scrollObject.put("direction", "down");
//	  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//	  scrollObject.put("name", "test-ADD TO CART");
        scrollObject.put("toVisible", "sdfnjksdnfkld");
        driver.executeScript("mobile:scroll", scrollObject);
        return e;
    }

    public By iOSScrollToElementUsingMobileScrollParent(MobileElement parentE, String predicateString) {
        RemoteWebElement parent = (RemoteWebElement)parentE;
        String parentID = parent.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", parentID);
//	  scrollObject.put("direction", "down");
        scrollObject.put("predicateString", predicateString);
//	  scrollObject.put("name", "test-ADD TO CART");
//        scrollObject.put("toVisible", "sdfnjksdnfkld");
        driver.executeScript("mobile:scroll", scrollObject);
        By m = MobileBy.iOSNsPredicateString(predicateString);
        System.out.println("Mobilelement is " + m);
        return m;
    }

    public MobileElement scrollToElement(MobileElement element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.4);
                startY = (int) (size.height * 0.6);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 3; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }
        if(!isFound){
            throw new Exception("Element not found");
        }
        return element;
    }

    public By scrollToElement(By element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.4);
                startY = (int) (size.height * 0.6);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 3; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }
        if(!isFound){
            throw new Exception("Element not found");
        }
        return element;
    }

    public boolean find(final MobileElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    if (element.isDisplayed()) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public boolean find(final By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    if (driver.findElement(element).isDisplayed()) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public void swipe(int startX, int startY, int endX, int endY, int millis)
            throws InterruptedException {
        TouchAction t = new TouchAction(driver);
        t.press(point(startX, startY)).waitAction(waitOptions(ofMillis(millis))).moveTo(point(endX, endY)).release()
                .perform();
    }

    public void wait(int n) {
        long t0, t1;
        t0 = System.currentTimeMillis();
        do {
            t1 = System.currentTimeMillis();
        } while (t1 - t0 < n);
    }

    public void clickWithExplicitWait(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element)));
        WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//android.widget.ProgressBar[@content-desc='Progress_Bar']")));
            System.out.println("************* SPINNER VANISHED **************");
        } catch (Exception e) {
            System.out.println("********** No Spinner Detected *********");
        }
        elementToClick.click();
        System.out.println("*** CLICKED ****");
    }

    public boolean isElementFound(MobileElement ele) {
        boolean val = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(ele)));
            wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(ele)));
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath("//android.widget.ProgressBar[@content-desc='Progress_Bar']")));
                System.out.println("************* SPINNER VANISHED **************");
            } catch (Exception e) {
                System.out.println("********** No Spinner Detected *********");
            }
            val = ele.isDisplayed();
        } catch (Exception e) {
            val = false;
        }
        return val;
    }

    public boolean isElementFoundForRecovery(MobileElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        boolean val;
        try {
            wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(ele)));
            wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(ele)));
            val = ele.isDisplayed();
            // 36015
        } catch (Exception e) {
            val = false;
        }
        return val;
    }

    /**
     * Return the property key value from config.properties
     *
     //* @param String field*/

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

    /**
     * Set Page Load Time
     */
    void setLoadTime() {
        String loadtime = getPropValue("PAGELOAD_WAIT");
        if (loadtime != null) {
            LOAD_TIMEOUT = Integer.parseInt(loadtime);
        }
    }

    public void getLoadTime() {
        setLoadTime();
    }

    public void getPageSource() {
        System.out.println(driver.getPageSource());
    }

    /**
     * Wait for page to load using visibilityOf
     *
     // @param WebElement id
     */
    public void waitForPageToLoad(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, LOAD_TIMEOUT);
        try {
            wait.until(ExpectedConditions.visibilityOf(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToDisAppear(String id) {
        WebDriverWait wait = new WebDriverWait(driver, LOAD_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
    }

    public boolean waitForElementToDisAppear(WebElement elementName, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOf(elementName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Wait for page to load using elementToBeClickable
     *
     // @param MobileElement id
     */
    public void waitForElementClickable(WebElement id) {
        setLoadTime();
        WebDriverWait wait = new WebDriverWait(driver, LOAD_TIMEOUT);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Wait for Element and return an element
     //* @param id
     */
    public WebElement waitForElement(WebElement arg) {
        waitForPageToLoad(arg);
        WebElement el = arg;
        return el;
    }

    /**
     * Set fluent wait.
     *
     * @param webby WebElement
     */
    public WebElement fluentWait(final WebElement webby) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (webby.isDisplayed())
                    return webby;
                return webby;
            }
        });
        return foo;
    }
    /**
     * Set fluent wait.
     *
     * @param webby WebElement
     */
    public WebElement fluentWait(final WebElement webby, long duration) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(duration, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (webby.isDisplayed())
                    return webby;
                return webby;
            }
        });
        return foo;
    }
    /**
     * Navigate back to the previous screen
     */
    public void clickBackButton() {
        driver.navigate().back();
    }

    /**
     * Hide the Keyboard
     */
    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    /**
     * Return the current method name
     */
    public String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    /**
     * Click on the element
     *
     * @param element is the mobile element
     */
    public void clickElement(MobileElement element) {
        element.click();
    }

    /**
     * Set the test field with the value
     *
     * @param element is the mobile element and string is the value which will pass
     *                in the text field
     */
    public void setTextField(MobileElement element, String value) {
        // pName=driver.getCapabilities().getCapability("platformName").toString();
        element.sendKeys(value);
    }

    public void clickIOSKeyboard(String keyname) {
        List<MobileElement> el;
        try {
            el = driver.findElement(MobileBy.className("XCUIElementTypeKeyboard"))
                    .findElements(MobileBy.className("XCUIElementTypeButton"));
            for (WebElement elem : el) {
                if (elem.getAttribute("name").equalsIgnoreCase(keyname)) {
                    elem.click();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickKeyboardSearch() {
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
            // ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
            wait(500);
            // ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
            wait(500);
        }
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("iOS")) {
            wait(500);
            clickIOSKeyboard("Search");
            // ((IOSDriver) driver).hideKeyboard("pressKey","Search");
            wait(3000);
        }
    }

    public void clickKeyboardDone() {
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
            driver.hideKeyboard();
        }
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("iOS")) {
            clickIOSKeyboard("Done");
            wait(500);
        }
    }

    /**
     * Return true if element is present else return false
     *
     * @param element
     */
    public Boolean IsElementPresent(MobileElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Return true if element is not present else return false
     *
     * @param element
     */
    public boolean IsElementNotPresent(MobileElement element) {
        try {
            element.isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
    public boolean isElementNotPresent(MobileElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20, 500);
            wait.until(ExpectedConditions.invisibilityOf(element));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    /**
     * Return true if elements are present else return false
     //* @param list
     */
    public boolean IsElementsPresent(List<MobileElement> element) {
        boolean value = false;
        try {
            if (element.size() > 0) {
                value = true;
            }
            return value;
        } catch (NoSuchElementException e) {
            return value;
        }
    }

    /**
     * Return true if element is present else return false
     *
     * @param by
     */
    public boolean IsElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    /**
     * Swipe Down
     */
    public void swipeDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * .2);
        int endY = (int) (size.height * .8);
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
            (new TouchAction<>(driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(700))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        }
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios")) {
            (new TouchAction<>(driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        }
    }

    /**
     * Swipe Up
     */
    public void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * .8);
        int endY = (int) (size.height * .2);
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
            (new TouchAction<>(driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(700))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        }
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios")) {
            (new TouchAction<>(driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        }
    }

    public void swipeUpSlowly() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * .6);
        int endY = (int) (size.height * .3);
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
            (new TouchAction<>(driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(700))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        }
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios")) {
            (new TouchAction<>(driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        }
    }

    public void scrollAndSearch(MobileElement ele, int swipeCount) {
        boolean elementFound = false;
        try {
            for (int i = 0; i < swipeCount; i++) {
                elementFound = isElementFound(ele);
                if (elementFound) {
                    break;
                } else {
                    swipeUp();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

     /*Swipe Element
    // @param int  startX, int startY, int endX, int endY
     @param long Duration*/

    public void swipe(int startX, int startY, int endX, int endY, long duration) {
        (new TouchAction<>(driver)).press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

  /*   Swipe Up Element
     @param MobileElement
     @param Int Duration*/

    public void swipeUpElement(MobileElement element, int duration) {
        int topY = element.getLocation().getY();
        int bottomY = topY + element.getSize().getHeight();
        int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);

        (new TouchAction<>(driver)).press(PointOption.point(centerX, bottomY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300))).moveTo(PointOption.point(centerX, topY))
                .release().perform();
    }

    /**
     * Scroll Up Screen
     */
    public void scrollUp() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * .8);
        int endY = (int) (size.height * .2);
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
            (new TouchAction<>(driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(700))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        }
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios")) {
            (new TouchAction<>(driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        }
    }

    /**
     * Scroll Down Screen
     */
    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * .2);
        int endY = (int) (size.height * .8);
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
            (new TouchAction<>(driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(700))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        }
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios")) {
            (new TouchAction<>(driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        }
    }

    /**
     * Swipe Right
     */
    public void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.05);
        int endx = (int) (size.width * 0.50);
        int starty = size.height / 2;
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
            (new TouchAction<>(driver)).press(PointOption.point(startx, starty))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300))).moveTo(PointOption.point(endx, starty))
                    .release().perform();
        }
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios")) {
            (new TouchAction<>(driver)).press(PointOption.point(0, starty))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(900)))
                    .moveTo(PointOption.point(endx + 200, starty)).release().perform();
        }
    }

    /**
     * Swipe Left
     */
    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.50);
        int endx = (int) (size.width * 0.05);
        int starty = size.height / 2;
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
            (new TouchAction<>(driver)).press(PointOption.point(startx, starty))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300))).moveTo(PointOption.point(endx, starty))
                    .release().perform();
        }
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios")) {
            (new TouchAction<>(driver)).press(PointOption.point(startx + 100, starty))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(900)))
                    .moveTo(PointOption.point(endx - 100, starty)).release().perform();
        }
    }

   /* Swipe Up Until Text Exist
     @param String expected*/

    public void swipeUpUntilTextExists(String expected) {
        do {
            swipeUp();
        } while (!driver.getPageSource().contains(expected));
    }

    /* Swipe Down Until Text Exist
     @param String expected*/

    public void swipeDownUntilTextExists(String expected) {
        do {
            swipeDown();
        } while (!driver.getPageSource().contains(expected));
    }

   /* Swipe Right Until Text Exist
     @param String expected*/

    public void swipeRightUntilTextExists(String expected) {
        do {
            swipeRight();
        } while (!driver.getPageSource().contains(expected));
    }

    /*Swipe Left Until Text Exist
     @param String expected*/

    public void swipeLeftUntilTextExists(String expected) {
        do {
            swipeLeft();
        } while (!driver.getPageSource().contains(expected));
    }

    /*Swipe Right Until Element Exist
     @param By expected*/

    public void swipeRightUntilElementExist(By by) {
        do {
            swipeRight();
        } while (!IsElementPresent(by));
    }

  /*  Swipe Left Until Element Exist
     @param By expected*/

    public void swipeLeftUntilElementExist(By by) {
        do {
            swipeLeft();
        } while (!IsElementPresent(by));
    }

    /*Swipe Up Until Element Exist
     @param By expected*/

    public void swipeUpUntilElementExist(By by) {
        do {
            swipeUp();
        } while (!IsElementPresent(by));
    }

    /*Swipe Down Until Element Exist
    @param By expected*/

    public void swipeDownUntilElementExist(By by) {
        do {
            swipeDown();
        } while (!IsElementPresent(by));
    }
    //#####################

   /* Swipe Right Until Element Exist
     @param MobileElement element*/

    public void swipeRightUntilElementExist(MobileElement element) {
        do {
            swipeRight();
        } while (!IsElementPresent(element));
    }

     /*Swipe Left Until Element Exist
     @param MobileElement element*/

    public void swipeLeftUntilElementExist(MobileElement element) {
        do {
            swipeLeft();
        } while (!IsElementPresent(element));
    }

   /*  Swipe Up Until Element Exist
     @param MobileElement element*/

    public void swipeUpUntilElementExist(MobileElement element) {
        do {
            swipeUp();
        } while (!IsElementPresent(element));
    }

  /* Swipe Down Until Element Exist
    @param MobileElement element*/

    public void swipeDownUntilElementExist(MobileElement element) {
        do {
            swipeDown();
        } while (!IsElementPresent(element));
    }

    /**
     * Switch from WebView to Native
     */
    public void switchToNativeApp() {
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE")) {
                driver.context(contextName);
                System.out.println("Current context" + driver.getContext());
            }
        }
    }

 /*   method to get the context to required view
    @param context view to be set*/

    public void getContext() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
        }
    }

    /**
     * method to set the context to required view.
     *
     * @param context view to be set
     */
    public void setContext(String context) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.context((String) context.toString());
        System.out.println("Current context" + driver.getContext());
    }

    /**
     * method to set the default webview context
     */
    public void switchToWebView() {
    	try {
    		Thread.sleep(4000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	@SuppressWarnings("unchecked")
    	Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
    	for (String contextName : contextNames) {
    		if(contextName.contains("WEBVIEW") || contextName.contains("Webview"))
    		{
    			utils.log().info("Setting WebView: "+contextName);
    			break;
    		}
    	}
    }

    /*public void logStepIntoExtentReport(String elementDescription, String action, String typeString) {
        ExtentTestManager.getTest().log(Status.INFO,
                elementDescription + "; " + withBoldHTML("Text") + ": " + typeString);
    }

    public void logStepIntoReport(String elementDescription) {
        ExtentTestManager.getTest().log(Status.INFO, elementDescription);
    }
*/
    public String withBoldHTML(String string) {
        if (!string.trim().isEmpty()) {
            return "<b>" + string + "</b>";
        } else {
            return "";
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    /**
     * This method un-install apk from the devices attached
     *
     * @param app_package
     * @throws Exception
     */

    public void uninstallApkFromDevices(String deviceID, String app_package) throws Exception {

        cmd.runCommand("adb -s " + deviceID + " uninstall " + app_package);
    }

    /**
     * This method install apk in the devices attached
     *
     * @param app_package
     * @throws Exception
     */

    public void installApkFromDevices(String deviceID, String app_package) throws Exception {
        cmd.runCommand("adb -s " + deviceID + " -r install " + app_package);
    }

    /**
     * This method close the running app from the devices attached
     *
     * @param app_package
     * @throws Exception
     */
    public void closeRunningApp(String deviceID, String app_package) throws Exception {
        cmd.runCommand("adb -s " + deviceID + " shell am force-stop " + app_package);
    }

    /**
     * This method close the running app from the devices attached
     */
    public void closeRunningApp() throws Exception {
        driver.closeApp();
    }

    /**
     * This method close the running app from the devices attached
     */
    public void bgRunningApp() throws Exception {
        driver.runAppInBackground(Duration.ofSeconds(-1));
    }

    /**
     * This method close the running app from the devices attached
     *
     * @param app_package
     */
    public void closeRunningApp(String app_package) throws Exception {
        Map<String, Object> params = new HashMap<>();

        params.put("command", "am force-stop " + app_package);
        driver.executeScript("mobile:shell", params);
    }

    /**
     * This method launch app from the devices attached
     *
     * @param app_package
     * @param app_activity
     * @throws Exception
     */
    public void launchApp(String deviceID, String app_package, String app_activity) throws Exception {
        cmd.runCommand("adb -s " + deviceID + " shell am start " + app_package + "/" + app_activity);
    }

    /**
     * This method launch app from the devices attached
     *
     * @param app_package
     */
    public void launchApp(String app_package) throws Exception {
        driver.activateApp(app_package);
    }

    public boolean fontColorValidation(final MobileElement element, String Color) throws IOException {
        org.openqa.selenium.Point point = element.getCenter();
        int centerx = point.getX();
        int centerY = point.getY();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage image = ImageIO.read(scrFile);
        // Getting pixel color by position x and y
        int clr = image.getRGB(centerx, centerY);
        int red = (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue = clr & 0x000000ff;

        switch (Color) {
            case "red":
                if ((red > 150) && (green < 50) && blue < 50)
                    return true;
                break;
            case "green":
                if ((red < 50) && (green > 150) && blue < 50)
                    return true;
                break;

        }
        return false;

    }

    public boolean scrollUpAndSearch(MobileElement elementName, int maxScroll, Direction swipeDirection,
                                     AndroidDriver driver) {
        boolean elementFound = false;
        for (int i = 0; i <= maxScroll; i++) {
            try {
                elementFound = isElementFound(elementName);
                if (elementFound) {
                    break;
                } else {
                    swipeUp();
                }

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return elementFound;
    }

    public boolean scrollUpAndSearch(MobileElement elementName, int maxScroll) {
        boolean elementFound = false;
        for (int i = 0; i <= maxScroll; i++) {
            try {
                elementFound = elementName.isDisplayed();
                if (elementFound) {
                    break;
                }

            } catch (Exception e1) {
                swipeUp();
            }
        }
        return elementFound;
    }

    public void WaitUntilElementToDisappear(MobileElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.and(ExpectedConditions.invisibilityOf(element)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public enum Direction {
        UP, DOWN, RIGHT, LEFT;
    }

    public boolean isElementClickable(MobileElement ele) {
        boolean val = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(ele)));
            wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(ele)));
            val = ele.isEnabled();
        } catch (TimeoutException | NoSuchSessionException e) {
            val = false;
        }
        return val;
    }

    public boolean isElementDisplayed(MobileElement ele) {
        boolean val = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(ele)));
            val = ele.isDisplayed();
        } catch (Exception e) {
            val = false;
        }
        return val;
    }

    public boolean checkElementIsEnabled(MobileElement ele) {
        return ele.isEnabled();
    }

    public boolean waitForElementToDisappear(MobileElement ele) {
        boolean isElementPresent = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.and(ExpectedConditions.invisibilityOf(ele)));
            ele.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementPresent;

    }

    public void sleeping(int timeOutInMiliSeconds) {
        try {
            Thread.sleep(timeOutInMiliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getElementText(MobileElement ele) {
        String elementText = "";
        try {
            if (isElementDisplayed(ele)) {
                elementText = ele.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        utils.log().info("The text Shows:" + elementText);
        return elementText;
    }

    public void clearTextField(MobileElement ele) {
        try {
            if (isElementDisplayed(ele)) {
                ele.click();
                ele.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterValueInTextField(MobileElement ele, String keysToSend) {
        try {
            if (isElementDisplayed(ele)) {
                ele.click();
                ele.clear();
                ele.sendKeys(keysToSend);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setValueInTextField(MobileElement ele, String keysToSend) {
        try {
            ImmutableMap.Builder args = ImmutableMap.builder().put("id", ele.getId()).put("value", keysToSend);
            driver.execute("setValue", args.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tapAtCordinates(int x, int y) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(x, y)).perform();
    }

    public boolean isElementEnabled(MobileElement ele) {
        boolean val = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(ele)));
            val = ele.isEnabled();
            System.out.println("Is button enabled :-" + val);
        } catch (Exception e) {
            val = false;
        }
        return val;
    }

    public void waitTimeOut() {
        try {
            Thread.sleep(generic_timeOutInMiliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyBackgroundColor(MobileElement elem) throws IOException {
        Point point = elem.getCenter();
        int centerx = point.getX();
        int centerY = point.getY();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        BufferedImage image = ImageIO.read(scrFile);
        // Getting pixel color by position x and y
        int clr = image.getRGB(centerx, centerY);
        int red = (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue = clr & 0x000000ff;
        utils.log().info("Red Color value = " + red);
        utils.log().info("Green Color value = " + green);
        utils.log().info("Blue Color value = " + blue);
    }

    public void swipeUpOnePage() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * .8);
        int endY = (int) (size.height * .3);
        if (driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
            (new TouchAction<>(driver)).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(700))).moveTo(PointOption.point(startX, endY))
                    .release().perform();
        }
    }

    public void swipeElementLeft(MobileElement elem)
    {
        Point bannerPoint = elem.getLocation();
        Dimension screenSize = driver.manage().window().getSize();
        int startX = Math.toIntExact(Math.round(screenSize.getWidth() * 0.8));
        int endX = 0;
        TouchAction action = new TouchAction(driver);
        action
                .press(PointOption.point(startX, bannerPoint.getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, bannerPoint.getY()))
                .release();
        driver.performTouchAction(action);
    }

    public void swipeElementRight(MobileElement elem)
    {
        Point bannerPoint = elem.getLocation();
        Dimension screenSize = driver.manage().window().getSize();
        int startX = 0;
        int endX = Math.toIntExact(Math.round(screenSize.getWidth() * 0.8));
        TouchAction action = new TouchAction(driver);
        action
                .press(PointOption.point(startX, bannerPoint.getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, bannerPoint.getY()))
                .release();
        driver.performTouchAction(action);
    }

    public void wifiOnOff(String status) {
        try {
            launchApp("com.android.settings");
            wait(1000);
            MobileElement wifiBtn = (MobileElement) driver
                    .findElement(By.xpath("//android.widget.TextView[@text='Network & Internet']"));
            wifiBtn.click();
            wait(1000);
            wifiBtn = (MobileElement) driver.findElementByAccessibilityId("Wi‑Fi");
            if (!wifiBtn.getText().equalsIgnoreCase(status)) {
                wifiBtn.click();
                wait(1700);
                clickBackButton();
                wait(200);
            } else {
                utils.log().info("WiFi is already " + status);
                clickBackButton();
                wait(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setWiFiState(boolean status)
    {
        try {
            AndroidDriver anddriver=((AndroidDriver) driver);
            ConnectionState con=anddriver.getConnection();
            boolean val=con.isWiFiEnabled();
            if (val != status) {
                anddriver.toggleWifi();
                wait(1700);
            } else {
                utils.log().info("WiFi is already " + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean checkWiFiStatus() {
        AndroidDriver anddriver=((AndroidDriver) driver);
        ConnectionState con=anddriver.getConnection();
        boolean val=con.isWiFiEnabled();
        return val;
    }

    public void checkBatteryStatus() {
        AndroidBatteryInfo baatInfo = ((AndroidDriver) driver).getBatteryInfo();
        utils.log().info(baatInfo.getState().CHARGING.toString());
    }
    public String getDeviceTime() {
        String deviceTimeInfo = ((AndroidDriver) driver).getDeviceTime();
        utils.log().info(deviceTimeInfo);
        return deviceTimeInfo;
    }
    public boolean getApplicationStatus(String bundleId) {
        boolean appStatus = ((AndroidDriver) driver).isAppInstalled(bundleId);
        return appStatus;
    }


}