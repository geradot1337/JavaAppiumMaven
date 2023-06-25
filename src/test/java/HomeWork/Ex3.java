package HomeWork;
import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;


public class Ex3 extends CoreTestCase {
    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.waitForSearchResult("Automation for Apps");
        SearchPageObject.closeSearchWindow();
        SearchPageObject.assertSearchInputIsNull();
    }
}
