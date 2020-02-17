package qa.mobile;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class test1 {
	
	AppiumDriver driver;
	
//  @Test
//  public void login() throws Exception {
//	  MobileElement getStartedBtn = (MobileElement) driver.findElementByAccessibilityId("Get_Started_Button");
//	  getStartedBtn.click();
//	  
//      MobileElement sevenBtn = (MobileElement) driver.findElementByAccessibilityId("7_button");
//      sevenBtn.click();
//
//      MobileElement threeBtn = (MobileElement) driver.findElementByAccessibilityId("3_button");
//      threeBtn.click();
//
//      MobileElement fiveBtn = (MobileElement) driver.findElementByAccessibilityId("5_button");
//      fiveBtn.click();
//
//      MobileElement fourBtn = (MobileElement) driver.findElementByAccessibilityId("4_button");
//      fourBtn.click();
//      
//      //allow time for the webView to load completely
//      Thread.sleep(5000);
//      
//      //gets all of the avilable contexts
//      Set<String> contextNames = driver.getContextHandles();
//      //Switch to WebView Context
//      driver.context((String) contextNames.toArray()[1]);
//      System.out.println(contextNames);
//
//
//      
//      System.out.println("#################################### " + driver.getContext());
//      
//      WebElement userName = driver.findElementById("Username");
//      userName.sendKeys("Prod01");
//     
//      WebElement password = driver.findElementById("Password");
//      password.sendKeys("Password1!");
//      
//      WebElement submitButton = driver.findElementById("qa-button-login");
//      submitButton.click();
//      
//  }
  
//  @Test
//  public void logIn() throws Exception {  
//	  System.out.println("First Context............ " + driver.getContext());
//  
//
//	Set<String> contextNames = driver.getContextHandles();
//	//Switch to WebView Context
//	System.out.println("All Context............ " + contextNames);
//
//	
//	driver.context((String) contextNames.toArray()[1]);
//	
//	WebDriverWait wait = new WebDriverWait(driver, 15);
//		wait.until(ExpectedConditions.titleContains("Frontline - Sign In"));
//		  
//		  
////	System.out.println("#################################### " + driver.getContext());
//	  WebElement userName = driver.findElementById("Username");
//      userName.sendKeys("Prod01");
//   
//    WebElement password = driver.findElementById("Password");
//    password.sendKeys("Password1!");
//    
//    WebElement submitButton = driver.findElementById("qa-button-login");
//    submitButton.click();
//  
 // }
  
  
  @Test
  public void clockIn() throws Exception {
	  //System.out.println( driver.getPageSource());
	  
	  //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 

	  //System.out.println( driver.getPageSource());
	  
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 

	 System.out.println( driver.getPageSource());
	 
	 
	  MobileElement clockIn = (MobileElement) driver.findElementByAccessibilityId("Dashboard_Widget_Clock_In_Button");
	  clockIn.click();
//			  
//	  System.out.println("####################################");
//      
//                
//      // AccID verify LocationNeeded_StaticText
//      MobileElement result_0 = (MobileElement) driver.findElementByAccessibilityId("LocationNeeded_StaticText");
//      
//      //Assert.assertEquals(result_0.getText(), "We Need Your Location");
//      System.out.println("####################################" + result_0.getText());
//      
//      // AccID verify You can manage Location Services at any time by going to Settings > Privacy > Location Services
//      MobileElement result_1 = (MobileElement) driver.findElementByAccessibilityId("You can manage Location Services at any time by going to Settings > Privacy > Location Services");
//      //Assert.assertEquals(result_1.getText(), "You can manage Location Services at any time by going to Settings > Privacy > Location Services");
//      System.out.println("####################################" + result_1.getText());
//
//      //Enable_Location_Services_Button
//      MobileElement eightBtn = (MobileElement) driver.findElementByAccessibilityId("Enable_Location_Services_Button");
//      eightBtn.click();
//      
//      //verify prompt //XCUIElementTypeAlert[@name="Allow “Frontline” to access your location?"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]
//      
//      // TAP //XCUIElementTypeButton[@name="Allow While Using App"]
//      driver.switchTo().alert().accept();
//      
//      // TAP Dashboard_Widget_Clock_In_Button
//      MobileElement nineBtn = (MobileElement) driver.findElementByAccessibilityId("Dashboard_Widget_Clock_Out_Button");
//      nineBtn.click();
//      
//      // Check for //XCUIElementTypeStaticText[@name="Clock Out"]
//      MobileElement result_3 = (MobileElement) driver.findElementByName("Timesheets_ModuleHeader");
//      //Assert.assertEquals(result_3.getText(), "Clock Out");
//      System.out.println(result_3.getText());
//      // TAP //XCUIElementTypeButton[@name="Timesheets_ModuleHeader"]
//      
//      // Must figure out how to access items in //XCUIElementTypeTable[@name="Timesheet_Table"]
//
//      //ie WED 2/12
//      
//      //Tap Cells //XCUIElementTypeCell[@name="Time_Event_Cell_1"] starts at _0
//      
//      // //XCUIElementTypeButton[@name="Time_Entry_Delete_Button"]
//      
//      // verify //XCUIElementTypeStaticText[@name="Are you sure?"]
//      // //XCUIElementTypeButton[@name="Okay"]
//
//      MobileElement svnBtn = (MobileElement) driver.findElementByAccessibilityId("Enable_Location_Services_Button");
//      //sixBtn.click();
//      
//      /*
//       * LocationNeeded_StaticText
//       * This functionality requires your location to work properly.
//       * Enable_Location_Services_Button
//
//       * * */
//      
//      //userName.sendKeys("Prod01");
//      // password.sendKeys("Password1!");
//      // submitButton.click();
  }
  
  @BeforeClass
  public void beforeClass() throws Exception {

      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
      desiredCapabilities.setCapability("platformName", "iOS");
      desiredCapabilities.setCapability("platformVersion", "13.3");
      desiredCapabilities.setCapability("deviceName", "iPhone 11");
      desiredCapabilities.setCapability("automationName", "XCUITest");
      desiredCapabilities.setCapability("noReset", true);
      desiredCapabilities.setCapability("app", "/Users/sgriggs/iOS-FrontlineMobile/build/Prod-iphonesimulator/Frontline Mobile.app");
      //desiredCapabilities.setCapability("fullContextList", true);
      
      URL url = new URL("http://127.0.0.1:4723/wd/hub");

      driver = new IOSDriver(url, desiredCapabilities);
      String sessionId = driver.getSessionId().toString();
      //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      
	  
  }

  @AfterClass
  public void afterClass() {

	  //driver.quit();
  }

}
