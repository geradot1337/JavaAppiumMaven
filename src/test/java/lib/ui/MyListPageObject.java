package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class MyListPageObject extends MainPageObject{
    protected static String
    FOLDER_BY_NAME_TPL,
    ARTICLE_BY_TITLE_TPL,
    DELETE_ARTICLE;
    public MyListPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }
    private static String getSaveArticleByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{ARTICLE_NAME}", article_title);
    }
    public void openFolderByName(String name_of_folder)
    { String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitAndClick(
                folder_name_xpath,
                "Нет созданного списка",
                10
        );
    }
    public void swipeArticleToDelete(String article_title)
    {this.waitForArticleToAppearByTittle(article_title);
        String article_xpath = getSaveArticleByTitle(article_title);
        this.swipeToLeft(
                article_xpath,
                "нет нужной статьи"
        );
        if(Platform.getInstance().isIOS()){
this.clickSavedElementToDelete(DELETE_ARTICLE, "Cannot find saved article");

        }
            this.waitForArticleToDisappearByTittle(article_title);


    }
    public void waitForArticleToDisappearByTittle(String article_title)
    {
        String article_xpath = getSaveArticleByTitle(article_title);
       this.waitForElementNotPresent(
                article_xpath ,
                "Saved article still present with title " + article_title,
                15
       );
    }
    public void waitForArticleToAppearByTittle(String article_title)
    {
        String article_xpath = getSaveArticleByTitle(article_title);
        this.waitForElementPresent(
                article_xpath ,
                "Cannot find saved article by title " + article_title,
                15
        );
    }

}
