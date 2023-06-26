package lib.ui.mobileWeb;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI
{ static {
    MY_LIST_LINK = "css:a[data-event-name='menu.watchlist']";
    SYNC_CLOSE_BTN = "id:Close";
    OPEN_NAVUGATION = "css:#mw-mf-main-menu-button";
}
    public MWNavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
}
