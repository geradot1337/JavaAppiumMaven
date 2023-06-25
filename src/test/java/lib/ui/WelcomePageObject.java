package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;


public class WelcomePageObject extends MainPageObject
{
    private static final String
    LEARN_MORE_XPATH = "xpath://XCUIElementTypeStaticText[@name='Lear more about Wikipedia]",
    NEW_WAYS = "xpath://XCUIElementTypeStaticText[@name='New ways to explore']",
    LEARN_MORE_ABOUT_DATA = "id:Help make the app better",
    NEXT_BTN ="xpath://XCUIElementTypeButton[@name='Next']",
    FIND_LANGUAGE_BTN = "id:Search in over 300 languages",
    SKIP = "xpath://XCUIElementTypeButton[@name='Skip']",
    GET_STARTED_BTN = "xpath://XCUIElementTypeStaticText[@name='Get started']";
    public WelcomePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
public void waitForLearnMoreLink()
{
    this.waitForElementPresent(LEARN_MORE_XPATH,
            "Cannot find узнать подробнее о Википедии",5);
}
public void clickNextBtn()
{
    this.waitAndClick(NEXT_BTN,
            "Cannot find 'Далее' btn",5);
}
public void waitForNewWaysTitle()
{
    this.waitForElementPresent(NEW_WAYS,
            "Не удалось найти заголовок 'Новые способы изучения'",5);
}
public void waitForFindLanguageTitle()
{
    this.waitForElementPresent(FIND_LANGUAGE_BTN,
            "Не удалось найти заголовок 'Искать на почти 300 языках'",5);
}
public void waitForHelpToDoTitle()
{
    this.waitForElementPresent(LEARN_MORE_ABOUT_DATA,
            "Не удалось найти заголовок 'Помогите сделать это приложение лучше'",5);
}
public void clickGetStarted()
{
    this.waitAndClick(GET_STARTED_BTN
    ,"Нет удалось найти кнопку Начать", 5);
}
public void clickSkip()
{
    this.waitAndClick(SKIP, "Cannot find Skip btn", 5);
}
}
