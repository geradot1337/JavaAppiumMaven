package lib.ui.iOS;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject
{
    static
    {
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_INPUT = "id:Search Wikipedia";
        SEARCH_CANCEL_BUTTON = "id:Clear text";
        CLOSE_SEARCH_BTN = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
      //  LOCATOR = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']";
        NO_RESULTS_LABEL = "id:No results found";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        //SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://android.widget.FrameLayout[//android.widget.TextView[@text='{TITLE}']][//android.widget.TextView[@text='{DESCRIPTION}']]";
    }
    public IOSSearchPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
