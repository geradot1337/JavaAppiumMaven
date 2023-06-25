package HomeWork;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class firstExs {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/alexandremelyanov/Desktop/javaAppium/JavaApppium/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }



    @Test
    public void fieldHasText()
    {
String searchQuery = "JavaScript";
waitAndSendKeys(
        By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
        searchQuery,
        "Cannot find search input",
        5
);
assertElementHasText(
        "org.wikipedia:id/search_src_text",
        searchQuery,
        "Строка не соответсвует ожиданию",
        5
);
    }


    private WebElement waitForElementPresent(By by, String error_message, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage(error_message + "\n");

        return wait.until(

                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
        public void assertElementHasText(String by, String expected, String error,long timeout)
        {
            WebElement search = waitForElementPresent(
                    By.id(by),
                    "Cannot find element",
                    5
            );
            String actualValue = search.getAttribute("text");
            Assert.assertEquals(
                  error,
                    expected,
                    actualValue
            );

        }
    private WebElement waitAndSendKeys(By by, String value, String error_message, long timeout)
    {
        WebElement element = waitForElementPresent(by,error_message,timeout);
        element.sendKeys(value);
        return element;
    }
}