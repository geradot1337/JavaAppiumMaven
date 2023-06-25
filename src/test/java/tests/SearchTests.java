package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testSearchByTitleAndDescription()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResultByTitleAndDescription("Java", "Object-oriented programming language");
    }
    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.waitForSearchResult("Automation for Apps");
    }

    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelButtun();
        SearchPageObject.waitForCancelButtonToDisappear();

    }
    @Test
    public void testAmountOfNotEmptySearch()
    {
        String search_line = "Linkin Park Discography";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);


        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
        assertTrue(
                "Нет результатов поиска",
                amount_of_search_results > 0
        );

    }
    @Test
    public void testAmountOfEmptySearch()
    {
        String search_line = "sfsdfdsfdsfdfsdfs";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultListLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();

    }
}
