package lib.ui.mobileWeb;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject
{
    static
    {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>Input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        CLOSE_SEARCH_BTN = "css:button.close";
        //  LOCATOR = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']";
        NO_RESULTS_LABEL = "css:p.without-results";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikidata-description')][contains(text(), '{SUBSTRING}')]";
        //SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://android.widget.FrameLayout[//android.widget.TextView[@text='{TITLE}']][//android.widget.TextView[@text='{DESCRIPTION}']]";
    }
    public MWSearchPageObject(RemoteWebDriver driver){
        super(driver);
    }
}