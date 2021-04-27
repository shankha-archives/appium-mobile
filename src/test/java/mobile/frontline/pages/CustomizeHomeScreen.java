package mobile.frontline.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class CustomizeHomeScreen extends BasePage {

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/drag_handle")
    @iOSXCUITFindBy(accessibility = "Reorder New Version Available")
    public MobileElement dragableEle;

    @AndroidFindBy(id = "com.frontline.frontlinemobile:id/save")
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement saveOrderWidgetbtn;

    public CustomizeHomeScreen() {
    }

    public void rearrangeWidget() throws Throwable {
        TouchAction action = new TouchAction(driver);
        int dragX = dragableEle.getLocation().x + (dragableEle.getSize().width / 2);
        int dragY = dragableEle.getLocation().y + (dragableEle.getSize().height / 2);
        action.press(PointOption.point(dragX, dragY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(dragX, dragY + 400)).release().perform();
    }

    public void saveReorderedWidget() {
        click(saveOrderWidgetbtn, "Clicking on saving widgetss");
    }
}
