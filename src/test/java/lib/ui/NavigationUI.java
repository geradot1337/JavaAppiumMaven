package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class NavigationUI  extends MainPageObject{
    protected static String
    MY_LIST_LINK,
    OPEN_NAVUGATION,
    SYNC_CLOSE_BTN;


    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
    public void openNavigation()
    {
        if (Platform.getInstance().isMW()){
            this.waitAndClick(OPEN_NAVUGATION,"Cannot click hamburger",5);
        } else System.out.println("Не работает этот метод");
    }
    public void clickMylist() {
        if (Platform.getInstance().isMW()){
            this.tryClickElementWithFewAttempts(
                    MY_LIST_LINK,
                    "Нет кнопки мой список",
                    6
            );
        }
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
