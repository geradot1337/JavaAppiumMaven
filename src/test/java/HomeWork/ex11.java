package HomeWork;

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

public class ex11 extends CoreTestCase
{
    private static String name_of_folder = "Learning";
    public static String second_article = "Appium";
    @Test
    public void testSaveTwoArticlesAndDelete()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String first_article_title = ArticlePageObject.getArticleTitle();
        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else
        {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Automation for Apps");

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addNotFirstArticleToMyList(name_of_folder);
        } else
        {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMylist();

        MyListPageObject MyListPageObject = MyListPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeArticleToDelete(first_article_title);
        SearchPageObject.clickByArticleWithSubstring("Automation for Apps");

    }
}
