package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidMyListPageObject;
import lib.ui.MyListPageObject;
import lib.ui.iOS.iOSMyListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListPageObjectFactory
{
public static MyListPageObject get(RemoteWebDriver driver)
{
    if (Platform.getInstance().isAndroid()){
        return new AndroidMyListPageObject(driver);
    } else {
        return new iOSMyListPageObject(driver);
    }
}

}
