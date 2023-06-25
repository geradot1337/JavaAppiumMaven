package lib.ui.Android;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject
{
static {
    SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
            SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]";
            SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
            CLOSE_SEARCH_BTN = "id:org.wikipedia:id/search_close_btn";
            LOCATOR = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']";
            NO_RESULTS_LABEL = "xpath://*[@text='No results found']";
            SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']";
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";
            SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://android.widget.FrameLayout[//android.widget.TextView[@text='{TITLE}']][//android.widget.TextView[@text='{DESCRIPTION}']]";
}
    public AndroidSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
