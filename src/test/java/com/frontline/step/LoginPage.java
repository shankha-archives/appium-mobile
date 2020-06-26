
package com.frontline.step;

import com.frontline.pages.LoginPagesMethod;
import cucumber.api.java.en.Given;
import com.afpluscucumbermobile.config.TestDataManager;
import com.afpluscucumbermobile.manager.AppiumDriverManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPage {
    public AppiumDriver<MobileElement> driver;
    public AppiumDriverManager appdriverManager;
    public LoginPagesMethod loginPages;
    public TestDataManager testdata = new TestDataManager();

    public LoginPage() throws Exception{
    }

    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() throws Throwable {
    appdriverManager = new AppiumDriverManager();
    driver=appdriverManager.getDriver();
    loginPages = new LoginPagesMethod(driver);
    loginPages.clickOnTryAgainBtn();
    Thread.sleep(5000);
    loginPages.loginPageHeader();
    }

    @When("^User enter the UserID$")
    public void user_enter_the_UserID() throws Throwable {
    	loginPages.enterEmailAddress(testdata.read_property("Account", "login", "userid"));
    }

    @When("^User enter the Password$")
    public void user_enter_the_Password() throws Throwable {
    	loginPages.enterPassword(testdata.read_property("Account", "login", "password"));
     }

    @When("^Click on login button$")
    public void click_on_login_button() throws Throwable {

        loginPages.clickLoginButton();
    }

    @Then("^User navigate to next screen$")
    public void user_navigate_to_next_screen() throws Throwable {

        
    }


}
