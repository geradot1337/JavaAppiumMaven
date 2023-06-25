package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class NavigationUI  extends MainPageObject{
    protected static String
    MY_LIST_LINK,
    SYNC_CLOSE_BTN;


    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
    public void clickMylist() {
        if (Platform.getInstance().isAndroid()) {
            this.waitAndClick(
                    MY_LIST_LINK,
                    "Нет кнопки мой список",
                    5
            );
        } else {
            this.waitAndClick(
                    MY_LIST_LINK,
                    "Нет кнопки мой список",
                    5
            );
            this.waitAndClick(SYNC_CLOSE_BTN, "Cannot find close sync btn", 5);
        }
    }

}
