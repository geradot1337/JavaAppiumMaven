package HomeWork;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ex17 extends CoreTestCase {
    @Test
    public void testTwoArticleSave()
    {
        String name_of_folder = "Learning";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String first_article_title = ArticlePageObject.getArticleTitle();
        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else
        {
            ArticlePageObject.addArticlesToMySaved();
        }
        if (Platform.getInstance().isMW()) {
            AuthPageObject AuthPageObject = new AuthPageObject(driver);
            AuthPageObject.clickAuthBtn();
            AuthPageObject.enterLoginData("Geradot1337", "V123hu09stt");
            AuthPageObject.submitForm();
            ArticlePageObject.waitForTitleElement();
            assertEquals("We are not same page", first_article_title, ArticlePageObject.getArticleTitle());
            ArticlePageObject.addArticlesToMySaved();
        }


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("oman censor in 312 BC");
        ArticlePageObject.waitForTitleElement();
        String second_article_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticlesToMySaved();
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMylist();

        MyListPageObject MyListPageObject = MyListPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeArticleToDelete(first_article_title);
        MyListPageObject.waitForArticleToAppearByTittle(second_article_title);
    }


}

