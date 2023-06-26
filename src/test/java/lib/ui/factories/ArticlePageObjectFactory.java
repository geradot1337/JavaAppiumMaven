package lib.ui.factories;

import lib.Platform;
import lib.ui.Android.AndroidArticlePageObject;
import lib.ui.ArticlePageObject;
import lib.ui.iOS.IOSArticlePageObject;
import lib.ui.mobileWeb.MWArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory
{
    public static ArticlePageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
           return new AndroidArticlePageObject(driver);
        } else if (Platform.getInstance().isMW()) {
            return new MWArticlePageObject(driver);
        }else {
            return new IOSArticlePageObject(driver);
        }
    }
}
