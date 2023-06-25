package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class SearchPageObject extends MainPageObject {
 protected    static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT ,
    SEARCH_CANCEL_BUTTON ,
            CLOSE_SEARCH_BTN ,
LOCATOR  ,
    NO_RESULTS_LABEL ,
    SEARCH_RESULT_ELEMENT ,
    SEARCH_RESULT_BY_SUBSTRING_TPL ,
    SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL;
public void waitForCancelButtonToAppear()
{
    this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);
}
    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }
    public void clickCancelButtun()
    {
        this.waitAndClick(SEARCH_CANCEL_BUTTON,"Cannot find search cancel button", 5);
    }
    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

   /* TEMPLATES METHODS */
   public static String replaceTitle (String title, String description)
   {

       return SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL.replace("{DESCRIPTION}", description).replace("{TITLE}", title);

   }


    public static String getResultSearchElement(String substring)
{
    return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
}
    /* TEMPLATES METHODS */
    public void initSearchInput() {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element",5);
        this.waitAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into searchline", 5);
    }
    public void waitForSearchResult(String substring)
    {   String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring , 5);
    }
    public void waitForSearchResultByTitleAndDescription(String title, String description)
    {   String search_result_xpath = replaceTitle(title, description);
        System.out.println(search_result_xpath);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with title " + title + " and description " + description , 5);
    }
    public void clickByArticleWithSubstring(String substring)
    {   String search_result_xpath = getResultSearchElement(substring);
        this.waitAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring , 5);

    }
    public  int getAmountOfFoundArticles()
    {

        this.waitForElementPresent(
                LOCATOR,
                "Не удалось найти результаты по запросу: ",
                15
        );
        return this.getElementsCount(LOCATOR);

    }
    public void waitForEmptyResultListLabel()
    {
        this.waitForElementPresent(NO_RESULTS_LABEL, "Cannot find empty result label", 5);
    }
    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "Wa suppossed not find any results");
    }
    public void closeSearchWindow()
    {
        this.waitAndClick(
                CLOSE_SEARCH_BTN,
                "Cannot find 'Close Btn'",
                5
        );
    }
    public void assertSearchInputIsNull()
    {
    this.waitForElementPresent(SEARCH_INPUT, "Search input is not null",2);
    }
}
