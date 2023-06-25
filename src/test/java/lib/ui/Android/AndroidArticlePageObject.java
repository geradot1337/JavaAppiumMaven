package lib.ui.Android;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "id:org.wikipedia:id/view_page_title_text";
        OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
        OPTIONS_ADD_TO_MY_READING_LIST = "xpath://*[@text='Add to reading list']";
        ADD_TO_MY_READING_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        MY_LIST_NAME_OK = "xpath://*[@text='OK']";
        CLOSE_ARTICLE_BTN = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        FOOTER_ELEMENT = "xpath://*[@text='View page in browser']";
    }
    public AndroidArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
