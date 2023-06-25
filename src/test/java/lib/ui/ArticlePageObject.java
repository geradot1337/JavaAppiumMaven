package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static lib.ui.SearchPageObject.CLOSE_SEARCH_BTN;


abstract public class ArticlePageObject extends MainPageObject
{
 protected static String
    TITLE,
    TITLE1,
    OPTIONS_BUTTON,
    OPTIONS_ADD_TO_MY_READING_LIST,
    ADD_TO_MY_READING_LIST_OVERLAY,
    MY_LIST_NAME_INPUT ,
    MY_LIST_NAME_OK,
    CLOSE_ARTICLE_BTN,
    FOOTER_ELEMENT ;
    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }



    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article tittle on page", 10);
    }
    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else
        {
            return title_element.getAttribute("name");
        }
    }
    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        } else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        }
    }
    public void addArticleToMyList(String nameOfFolder)
    {
        this.waitAndClick(
            OPTIONS_BUTTON,
                "Где три точки ссаные?",
                5
        );
this.waitForElementPresent(
        OPTIONS_ADD_TO_MY_READING_LIST, "Нету добавить в реадинг лист",5

);

        this.waitAndClick(
                ADD_TO_MY_READING_LIST_OVERLAY,
                "Нет кнопки Гот Ит",
                5
        );
        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Нет инпута",
                5
        );
        this.waitAndSendKeys(
               MY_LIST_NAME_INPUT,
                nameOfFolder,
                "не удалось ввести название листа",
                5
        );
        this.waitAndClick(
                MY_LIST_NAME_OK,
                "Не удалось нажать ОКей",
                5
        );
    }
    public void closeArticle()
    { if(Platform.getInstance().isAndroid()) {
        this.waitAndClick(
                CLOSE_ARTICLE_BTN,
                "Не удалось закрыть, нет кнопки выход",
                5
        );
    } else {
        this.waitAndClick(                CLOSE_ARTICLE_BTN,                "Не удалось закрыть, нет кнопки выход",
                5
        );
        this.waitAndClick(CLOSE_SEARCH_BTN,"Cannot find search cancel button", 5);
    }
    }
    public void addNotFirstArticleToMyList(String nameOfFolder)
    {
        this.waitAndClick(
                OPTIONS_BUTTON,
                "Где три точки ссаные?",
                5
        );
        this.waitForElementPresent(
             OPTIONS_ADD_TO_MY_READING_LIST, "Нету добавить в реадинг лист",5

        );


        this.waitForElementAndClear(
               MY_LIST_NAME_INPUT,
                "Нет инпута",
                5
        );
        this.waitAndSendKeys(
                MY_LIST_NAME_INPUT,
                nameOfFolder,
                "не удалось ввести название листа",
                5
        );
        this.waitAndClick(
            MY_LIST_NAME_OK,
                "Не удалось нажать ОКей",
                5
        );
    }
    public void addArticlesToMySaved()
    {
        this.waitAndClick(OPTIONS_ADD_TO_MY_READING_LIST,"Cannot find option to add article to reading list", 5);
    }
}
