package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.Frontline.utils.GlobalParams;
import org.openqa.selenium.By;

public class PeopleScreen extends BasePage{

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "DirectoryView_EmployeeCell_0")
    public MobileElement searchPeople;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/search_view_edit_text")
    @iOSXCUITFindBy(accessibility = "Search employees by last name")
    public MobileElement serachEditText;

    public PeopleScreen(){
    }

    public void enterLastNameTobeSearched(String lastName){
        if( (new GlobalParams().getPlatformName()).contains("Android")){
            sendKeys(searchPeople, lastName, "Entering last name of the person to be searched");
//            hideKeyboard();
        }
        else
            sendKeys(serachEditText, lastName, "Entering last name of the person to be searched");
    }

    public void clickOnSearchedUser(String lastName){

        if( (new GlobalParams().getPlatformName()).contains("Android")){
            By searchedEmployee = By.xpath("//android.widget.TextView[contains(@text,'" + lastName + "')]");
           // scrollToElement(searchedEmployee, "up");
            click(searchedEmployee, "Clicking on searched Employee");
        }
        else
            click(searchPeople, "Clicking on search People");
    }
}
