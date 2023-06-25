package lib.ui.iOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSNavigationUI extends NavigationUI
{ static {
    MY_LIST_LINK = "id:Saved";
    SYNC_CLOSE_BTN = "id:Close";
}
    public iOSNavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
}
