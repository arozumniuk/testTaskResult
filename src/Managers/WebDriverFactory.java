package Managers;


import Utils.Logger;
import Utils.Runner;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

import static net.lightbody.bmp.proxy.CaptureType.getHeaderCaptureTypes;

public class WebDriverFactory {
    private BrowserMobProxyServer proxyServer;

    WebDriver createDriverInstance() {
        String browser = Runner.getCfg().browser();
        WebDriver driver = null;

        switch (browser) {
            case "chrome":

                ChromeOptions options = new ChromeOptions();
                proxyServer = new BrowserMobProxyServer();
                proxyServer.setTrustAllServers(true);
                proxyServer.start(0);
                proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
                proxyServer.enableHarCaptureTypes(getHeaderCaptureTypes());

                Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer, InetAddress.getLoopbackAddress());

                options.addArguments("start-maximized", "--ignore-certificate-errors");
                options.setProxy(seleniumProxy)
                        .setAcceptInsecureCerts(true);

                DesiredCapabilities capability = DesiredCapabilities.chrome();
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

                selectDriverForSystem();
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                break;
        }
        return driver;
    }

    private void selectDriverForSystem() {
        String opSystem = System.getProperty("os.name");
        Logger.INFO("Your system is: " + opSystem);

        if (opSystem.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "/Users/alena/IdeaProjects/qa-automation/MoonbeamTests/resources/chromedriver");
        } else if (opSystem.contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver_linux");
        } else if (opSystem.contains("Win")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        } else {
            Logger.ERROR("Your system is: " + opSystem + ", no chrome driver for it");
        }
    }

    public BrowserMobProxyServer getBrowserMobProxy() {
        return proxyServer;
    }

}
