package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import lib.Platform;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeOut) {
        By by = this.getLocatorString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage(error_message + "\n");

        return wait.until(

                ExpectedConditions.presenceOfElementLocated(by)
        );

    }

    public WebElement waitAndClick(String locator, String error_message, long timeout) {
        WebElement element = waitForElementPresent(locator, error_message, timeout);
        element.click();
        return element;
    }

    public WebElement waitAndSendKeys(String locator, String value, String error_message, long timeout) {
        WebElement element = waitForElementPresent(locator, error_message, timeout);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String error_message, long timeout) {
        By by = this.getLocatorString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(error_message + "\n");

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClear(String locator, String error_message, long timeout) {
        WebElement element = waitForElementPresent(locator, error_message, timeout);
        element.clear();
        return element;
    }

    public void swipeUp(int timeOfSwipe) {
        if (driver instanceof AppiumDriver) {

            TouchAction action = new TouchAction((AppiumDriver) driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int start_y = (int) (size.height * 0.8);
            int end_y = (int) (size.height * 0.2);
            action
                    .press(PointOption.point(x, start_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                    .moveTo(PointOption.point(x, end_y))
                    .release()
                    .perform();
        } else {
            System.out.println("Method swipeUp do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void swipeUpQuick() {
        swipeUp(200);
    }

    public void swipeUpToFindElement(String locator, String error_message, int max_swipes) {
        By by = this.getLocatorString(locator);
        int already_swipe = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swipe > max_swipes) {
                waitForElementPresent(locator, "Не удалось найти эелемент " + locator + "\n" + error_message, 0);
            }
            swipeUpQuick();
            ++already_swipe;
        }
    }

    public void swipeUpTillElementAppear(String locator, String error_message, int max_swipes) {
        int already_swiped = 0;
        while (!this.isElementLocatedOnTheScreen(locator)) {
            if (already_swiped > max_swipes) {
                Assert.assertTrue(error_message, this.isElementLocatedOnTheScreen(locator));
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

    public boolean isElementLocatedOnTheScreen(String locator)
    {
        int element_location_by_y = this.waitForElementPresent(locator, "Cannot find element by locator", 10).getLocation().getY();
       if (Platform.getInstance().isMW()){
           JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
           Object js_result = JSExecutor.executeScript("return window.pageYOffset");
           element_location_by_y -=Integer.parseInt(js_result.toString());
       }
        int screen_size_by_y = driver.manage().window().getSize().getHeight();
        return element_location_by_y < screen_size_by_y;
    }
    public boolean isElementPresent(String locator)
    {
        return getElementsCount(locator)>0;
    }

    public void swipeToLeft(String locator, String error_message) {
       if(driver instanceof AppiumDriver)
       { WebElement element = waitForElementPresent(locator,
                error_message,
                10
        );
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;
        TouchAction action = new TouchAction((AppiumDriver) driver);

        action
                .press(PointOption.point(right_x, middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(150)))
                .moveTo(PointOption.point(left_x, middle_y))

                .release()
                .perform();
    } else    {
        System.out.println("Method swipeToLeft do mothing for platform " + Platform.getInstance().getPlatformVar());
    }

}
    public int getElementsCount(String locator)
    {
        By by = this.getLocatorString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }
    public void assertElementNotPresent(String locator, String error_message)
    {
        int amount_of_elements = getElementsCount(locator);
        if (amount_of_elements > 0 )
        {
            String message = "An element "+ locator.toString()+ " supposed to be not present";
            throw new AssertionError(message + " " + error_message);
        }
    }
    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeout)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeout);
        return element.getAttribute(attribute);
    }
    private By getLocatorString(String locator_with_type)
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")){
            return By.xpath(locator);
        }
        else if (by_type.equals("id")){
            return By.id(locator);
                    }
        else if (by_type.equals("css")){
            return By.cssSelector(locator);
        }
        else {
            throw new IllegalArgumentException("Cannot get type of locator: "+ locator_with_type);
        }

    }
    public void clickElementToTheRightUpperCorner(String locator, String error_message) {
        if (driver instanceof AppiumDriver) {
            WebElement element = this.waitForElementPresent(locator + "/..", error_message, 5);
            int right_x = element.getLocation().getX();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getWidth();
            int middle_y = (upper_y + lower_y) / 2;
            int width = element.getSize().getWidth();
            int point_to_click_x = (right_x + width) - 3;
            int point_to_click_y = middle_y;
            TouchAction action = new TouchAction((AppiumDriver)driver);
            action.tap(PointOption.point(point_to_click_x, point_to_click_y)).perform();
        } else {
            System.out.println("Method swipeUp do mothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }
    public void clickSavedElementToDelete(String locator, String error_message)
    {
        this.waitAndClick(locator, error_message, 5);
    }
    public void scrollWebPageUp()
    {
        if (Platform.getInstance().isMW()){
            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
            JSExecutor.executeScript("window.scrollBy(0, 250)");
        } else System.out.println("This method does nothing for platform "+ Platform.getInstance().getPlatformVar());
    }
    public void scrollWebPageTillElementNotVisible(String locator, String error_message, int max_swipes)
    {
        int already_swiped = 0;
        WebElement element = this.waitForElementPresent(locator, error_message, 5);
        while (!this.isElementLocatedOnTheScreen(locator)){
            scrollWebPageUp();
            ++already_swiped;
            if (already_swiped> max_swipes){
                Assert.assertTrue(error_message, element.isDisplayed());
            }
        }
    }
    public void tryClickElementWithFewAttempts(String locator, String error_message, int amount_of_atempts)
    {
        int current_attempts = 0;
        boolean need_more_attempts = true;
while (need_more_attempts) {
    try {
        this.waitAndClick(locator, error_message, 1);
        need_more_attempts = false;
    } catch (Exception e) {
        if (current_attempts>amount_of_atempts){
            this.waitAndClick(locator,error_message,1);
        }
    }
    ++current_attempts;
}
    }
}
