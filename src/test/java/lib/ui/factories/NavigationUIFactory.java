package lib.ui.factories;

import lib.Platform;
import lib.ui.Android.AndroidNavugationUI;
import lib.ui.NavigationUI;
import lib.ui.iOS.iOSNavigationUI;
import lib.ui.mobileWeb.MWNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory
{
    public static NavigationUI get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidNavugationUI(driver);

        } else if (Platform.getInstance().isIOS()){
            return new iOSNavigationUI(driver);
        } else return new MWNavigationUI(driver);
    }
}
