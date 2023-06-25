package HomeWork;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;


public class Ex5 extends CoreTestCase {
       @Test
    public void testTwoArticleSave()
    {
        String name_of_folder = "Learning";
       SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String first_article_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Roman censor in 312 BC");
       ArticlePageObject.waitForTitleElement();
        String second_article_title = ArticlePageObject.getArticleTitle();
       ArticlePageObject.addNotFirstArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMylist();

        MyListPageObject MyListPageObject = MyListPageObjectFactory.get(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeArticleToDelete(first_article_title);
       MyListPageObject.waitForArticleToAppearByTittle(second_article_title);
    }


}
