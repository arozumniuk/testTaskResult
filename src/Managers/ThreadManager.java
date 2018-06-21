package Managers;

import Utils.Logger;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.openqa.selenium.WebDriver;

public class ThreadManager {

    private static ThreadLocal<ApiFactory> apiManager = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private static ThreadLocal<BrowserMobProxyServer> browserMobProxy = new ThreadLocal<BrowserMobProxyServer>();


    public static ApiFactory getApi() {
        if (apiManager.get() != null) {
            return apiManager.get();
        } else {
            setApiManager(new ApiFactory());
            return apiManager.get();
        }
    }

    private static void setApiManager(ApiFactory api_Manager) {
        apiManager.set(api_Manager);
    }

    public static void removeApiDriver() {
        apiManager.remove();
    }

    public static WebDriver getDriver() {
        if (webDriver.get() != null) {
            return webDriver.get();
        } else {
            WebDriverFactory webDriverFactory = new WebDriverFactory();
            WebDriver driver = webDriverFactory.createDriverInstance();
            setWebDriver(driver);
            setBrowserMobProxy(webDriverFactory.getBrowserMobProxy());

            return webDriver.get();
        }
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static BrowserMobProxyServer getBrowserMobProxy() {
        return browserMobProxy.get();
    }

    public static void setBrowserMobProxy(BrowserMobProxyServer browserProxy) {
        browserMobProxy.set(browserProxy);
    }


    /**
     * Closes WebDriver as well as Browser.
     */
    public static void removeDriver() {
        Logger.INFO("Thread id = " + Thread.currentThread().getId() +
                " Hashcode of webDriver instance = " + webDriver.get().hashCode() + " was closed");
        WebDriver driver = ThreadManager.getDriver();
        if (driver != null) {
            driver.quit();
            webDriver.remove();
        }
    }
}

