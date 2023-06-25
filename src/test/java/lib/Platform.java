package lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {
    private static final String PLATFORM_IOS = "iOS";
    private static final String PLATFORM_ANDROID = "ANDROID";
    private static final String PLATFORM_MOBILE_WEB = "mobile_web";
    private static final String APPIUM_URL = "http://127.0.0.1:4747/";
    private static Platform instance;
    private Platform() {}
    public static Platform getInstance()
    {
        if (instance == null ) {
            instance = new Platform();
        }
        return instance;
    }
    public RemoteWebDriver getDriver() throws Exception
    {
        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid()){
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        } else if (this.isIOS()){
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());
        } else if (this.isMW()) {
            return new ChromeDriver(this.getMvChromeOptions());
        }
        else throw new Exception("Cannot detected type of the Driver, Platform value: "+ this.getPlatformVar());
    }

public boolean isAndroid()
{
    return  isPlatform(PLATFORM_ANDROID);
}
    public boolean isIOS()
    {
        return  isPlatform(PLATFORM_IOS);
    }
    public boolean isMW()
    {
        return  isPlatform(PLATFORM_MOBILE_WEB);
    }

    private DesiredCapabilities getAndroidDesiredCapabilities()
    { DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/alexandremelyanov/Desktop/javaAppium/JavaApppium/apks/org.wikipedia.apk");
        capabilities.setCapability("orientation", "PORTRAIT");
        return capabilities;
    }
    private DesiredCapabilities getIOSDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("platformVersion", "16.4");
        capabilities.setCapability("app", "/Users/alexandremelyanov/Desktop/javaAppium/JavaApppium/ipa/Wikipedia.app");
        capabilities.setCapability("orientation", "PORTRAIT");
        capabilities.setCapability("appium:automationName", "XCUITest");
        return capabilities;
    }
    private boolean isPlatform(String my_platform)
    {
        String platform = getPlatformVar();
        return my_platform.equals(platform);
    }
    private ChromeOptions getMvChromeOptions()
    {
        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);
        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) \n" +
                "\n" +
                "AppleWebKit/535.19 (KHTML, like Gecko) \n" +
                "\n" +
                "Chrome/18.0.1025.166 Mobile Safari/535.19");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=340,640");
        return chromeOptions;
    }
   public String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }
}
