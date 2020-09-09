package mobile.frontline.stepdef;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.Frontline.utils.TestDataManager;
import mobile.frontline.pages.BasePage;
import mobile.frontline.pages.JobsMethods;
import mobile.frontline.pages.LoginPage;

public class SmokeStepDef {

    public LoginPage loginPage = new LoginPage();
    public JobsMethods jobulatorPage = new JobsMethods();
    public BasePage basePage = new BasePage();
	public TestDataManager testdata=new TestDataManager();

	
 	 @And("^Enter username and password and click on Sign In button$")
 	    public void enter_username_and_password_and_click_on_sign_in_button() throws Throwable {
 		  loginPage.verify_loginPageLoaded();
 	      loginPage.enterUserID_OnLoginPage(testdata.read_property("Account", "valid", "substitutelogin"));
 	      loginPage.enterUserPassword_onLoginPage(testdata.read_property("Account", "valid", "substitutepass"));
 	      loginPage.clickOnLoginBtn(); 
 	    }
 	@And("^The user kill and relaunch the application$")
   public void the_user_kill_and_relaunch_the_application() throws Throwable {
 		basePage.killAndRelaunch();  	
    }

     //@MOB-4229
 	 @And("^The user minimize and relaunch the application$")
     public void the_user_minimize_and_relaunch_the_application() throws Throwable {
       basePage.bgRunningApp();
     }
    
}
