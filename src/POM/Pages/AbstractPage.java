package POM.Pages;


import Managers.ThreadManager;
import POM.Elements.*;
import Utils.Logger;
import Utils.Runner;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.util.ArrayList;

public class AbstractPage {
    private static final By MP_LOGO_ELEMENT = By.xpath("//div[contains(@class, 'brand-logo-login')]");
    protected String url;

    public void open() {
        Logger.STEP("Navigating to: " + url);
        ThreadManager.getDriver().get(url);
    }

//GETTERS FOR WEB_ELEMENT WRAPPERS

    public Button getButton(By locator) {
        return new Button(locator);
    }

    public Input getInput(By locator) {
        return new Input(locator);
    }

    public Frame getFrame(By locator) {
        return new Frame(locator);
    }

    public Select getSelect(By locator) {
        return new Select(locator);
    }

    public Text getText(By locator) {
        return new Text(locator);
    }

    public CheckBox getCheckBox(By locator) {
        return new CheckBox(locator);
    }

    public Switcher getSwitcher(By locator) {
        return new Switcher(locator);
    }

    public DropDownMenuMore getDropDownMenu() {
        return new DropDownMenuMore();
    }

    public POM.Elements.List getList(By locator) {
        return new POM.Elements.List(locator);
    }

//COMMON FUNCTIONALITY

    /**
     * Waits for IFrame is visible up to 60 seconds then focuses it
     *
     * @param locator - IFrame's locator.
     */
    protected void switchToFrame(By locator) {
        Logger.DEBUG("Switching to IFrame: " + locator.toString());
        getFrame(locator).waitForElementVisible(60);
        getFrame(locator).switchTo();
    }

    /**
     * Switches to default content of the page.
     * Useful when IFrame was selected and access to default content is required
     */
    public void switchToDefaultContent() {
        Logger.DEBUG("Switching to default content");
        ThreadManager.getDriver().switchTo().defaultContent();
    }

    /**
     * Returns current url of the page
     *
     * @return String - Current url
     */
    public String getCurrentUrl() {
        return ThreadManager.getDriver().getCurrentUrl();
    }

    /**
     * Try to avoid using this function!
     * Wrapper for Thread.sleep
     *
     * @param millis - time in milliseconds
     */
    public static void sleep(int millis) {
        Logger.DEBUG("Sleeping for " + millis + " milliseconds.");

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Logger.EXCEPTION("Problem was encountered during using Thread.sleep() method.");
        }
    }

    public void reloadPage() {
        Logger.STEP("Reload page");
        ThreadManager.getDriver().navigate().refresh();
    }

    public String getSource() {
        return ThreadManager.getDriver().getPageSource();
    }

    public boolean isLogoDisplayed() {

        try {
            getButton(MP_LOGO_ELEMENT).waitForElementPresent();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void waitForAllResponsesAreSuccessful() {
        long expectedTime = System.currentTimeMillis() + Runner.getCfg().defaultWaitForReceiveResponse();
        Har har;
        boolean isResponseSuccess;
        ArrayList<String> badResults = new ArrayList<>();
        do {
            isResponseSuccess = true;
            badResults.clear();
            sleep(50);
            har = ThreadManager.getBrowserMobProxy().getHar();
            java.util.List<HarEntry> harEntries = har.getLog().getEntries();

            for (HarEntry entry : harEntries) {
                if (entry.getResponse().getError() != null && entry.getResponse().getError().contains("No response received")) {
                    isResponseSuccess = false;
                    badResults.add(entry.getRequest().getUrl());
                }
            }

        }
        while (System.currentTimeMillis() < expectedTime && !isResponseSuccess);

        if (!isResponseSuccess) {
            throw new AssertionError("Responses for: " + badResults.toString() + " not received in " + Runner.getCfg().defaultWaitForReceiveResponse());
        }
        ThreadManager.getBrowserMobProxy().endHar();
    }

    public void startHttpTrafficRecord() {
        ThreadManager.getBrowserMobProxy().newHar();
    }

}
