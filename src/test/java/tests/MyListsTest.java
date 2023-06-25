package tests;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTest extends CoreTestCase
{ private static final String name_of_folder = "Learning";
    @Test
    public void testSaveArticleToMyReadList()
    {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else
        {
         ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMylist();


        MyListPageObject MyListPageObject = MyListPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeArticleToDelete(article_title);
    }
}
