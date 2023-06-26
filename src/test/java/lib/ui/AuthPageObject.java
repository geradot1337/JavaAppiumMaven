package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthPageObject extends MainPageObject
{
    private static final String
    LOGIN_BUTTON ="xpath://body/div/a[text()='Log in']",
    LOGIN_INPUT = "css:input[name='wpName']",
    PASSWORD_INPUT = "css:input[name='wpPassword']",
    SUBMIT_BUTTON = "css:button#wpLoginAttempt";
    public AuthPageObject(RemoteWebDriver driver){
        super(driver);
    }
    public void clickAuthBtn()
    {
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot find login btn", 6);
        this.waitAndClick(LOGIN_BUTTON,"cannot click login btn", 5);
    }
    public void enterLoginData(String login, String password)
    {
        this.waitAndSendKeys(LOGIN_INPUT, login, "Cannot fina and put a login to the login input",5);
        this.waitAndSendKeys(PASSWORD_INPUT,password, "Cannot fina and put a pass to the pass input",5);
    }
    public void submitForm()
    {
        this.waitAndClick(SUBMIT_BUTTON, "Cannot find and click submit auth button.",5);
    }
}
