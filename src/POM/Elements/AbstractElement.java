package POM.Elements;

import Managers.ThreadManager;
import Utils.Logger;
import Utils.Runner;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Class for abstract element of the page.
 * Each wrapper for WebElement should extends this class.
 */
public class AbstractElement {
    private final By PENDO_CLOSE_BUTTON_LOCATOR = By.xpath("//button[@id='_pendo-close-guide_']");
    public final int DEFAULT_WAIT = Runner.getCfg().defaultWait();

    protected By locator;
    protected By targetLocator;
    protected By draggableLocator;

    public AbstractElement(By locator) {
        this.locator = locator;
    }

    public AbstractElement(By draggableLocator, By targetLocator) {
        closePendo();
        this.targetLocator = targetLocator;
        this.draggableLocator = draggableLocator;
    }

    public void closePendo() {
        try {
            changeImplicitlyWait(0);
            if (ThreadManager.getDriver().findElement(PENDO_CLOSE_BUTTON_LOCATOR).isDisplayed()) {
                ThreadManager.getDriver().findElement(PENDO_CLOSE_BUTTON_LOCATOR).click();
                restoreDefaultImplicitlyWait();
            }
        } catch (Exception e) {
            //Logger.INFO("Pendo was not found");
            restoreDefaultImplicitlyWait();
            return;
        }
    }

    /**
     * This function performs searching for WebElement on the page by locator of this Element
     */
    public WebElement getWebElement() {
//        try{
//            //for element highlighting
//            WebElement element = ThreadManager.getDriver().findElement(locator);
//            for (int i = 0; i < 2; i++) {
//                JavascriptExecutor js = (JavascriptExecutor) ThreadManager.getDriver();
//                js.executeScript("arguments[0].style.border='3px solid red'", element);
//                js.executeScript("arguments[0].style.border=''", element);
//            }
//            return element;
        return ThreadManager.getDriver().findElement(locator);
//        }
//        catch (Exception e){
//            Logger.WARNING("Locator " + locator + " was not found.");
//        }
//        return null;
    }

    public List<WebElement> getWebElements() {

        return ThreadManager.getDriver().findElements(locator);
    }

    public int getCount() {
        return ThreadManager.getDriver().findElements(locator).size();
    }

    /**
     * Imitates cursor hovering over this element. Depends on WebDriver's capabilities: ENABLE_PERSISTENT_HOVERING
     */
    public void mouseOver() {
        Actions actions = new Actions(ThreadManager.getDriver());
        actions.moveToElement(getWebElement()).build().perform();
    }

    /**
     * Returns value of specified attribute.
     *
     * @param attribute - exact name of the attribute you want to get.
     */
    public String getAttribute(String attribute) {
        try {
            return getWebElement().getAttribute(attribute);
        } catch (StaleElementReferenceException e) {
            return getWebElement().getAttribute(attribute);
        }
    }

    public String getCssValue(String attribute) {
        try {
            return getWebElement().getCssValue(attribute);
        } catch (StaleElementReferenceException e) {
            return getWebElement().getAttribute(attribute);
        }
    }

    /**
     * This function check immediately whether element is present on the page or not.
     * ImplicitlyWait has no impact on this function.
     */
    public boolean isPresent() {
        boolean isPresent = false;

        //to avoid redundant waiting because of implicitlyWait
        changeImplicitlyWait(0);

        try {
            isPresent = ThreadManager.getDriver().findElements(locator).size() != 0;
        } finally {
            //restoring default value
            restoreDefaultImplicitlyWait();
        }

        return isPresent;
    }

    /**
     * This function check immediately whether element is present on the page and is visible.
     * ImplicitlyWait has no impact on this function.
     */
    public boolean isVisible() {
        boolean isDisplayed;

        //to avoid redundant waiting because of implicitlyWait
        changeImplicitlyWait(0);

        try {
            isDisplayed = getWebElement().isDisplayed();
        } catch (NullPointerException | StaleElementReferenceException e) {
            isDisplayed = getWebElement().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            restoreDefaultImplicitlyWait();
        }

        return isDisplayed;
    }

    /**
     * Waits until element appears on the page.
     *
     * @param seconds - int
     */
    public void waitForElementPresent(int seconds) throws TimeoutException {
        //to avoid redundant waiting because of implicitlyWait
        changeImplicitlyWait(0);

        try {
            WebDriverWait wait = new WebDriverWait(ThreadManager.getDriver(), (seconds));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            WebDriverWait wait = new WebDriverWait(ThreadManager.getDriver(), (seconds));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } finally {
            //restoring default value
            restoreDefaultImplicitlyWait();
        }
    }

    /**
     * Wait until element appears on the page during default wait period
     *
     * @throws TimeoutException
     */
    public void waitForElementPresent() throws TimeoutException {
        //to avoid redundant waiting because of implicitlyWait

        changeImplicitlyWait(0);

        try {
            WebDriverWait wait = new WebDriverWait(ThreadManager.getDriver(), (DEFAULT_WAIT));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            WebDriverWait wait = new WebDriverWait(ThreadManager.getDriver(), (DEFAULT_WAIT));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } finally {
            //restoring default value
            restoreDefaultImplicitlyWait();
        }
    }

    /**
     * Waits until element becomes visible on the page.
     *
     * @param seconds how long to wait int seconds
     */
    public void waitForElementVisible(int seconds) throws TimeoutException {
        //to avoid redundant waiting because of implicitlyWait
        changeImplicitlyWait(0);

        try {
            WebDriverWait wait = new WebDriverWait(ThreadManager.getDriver(), seconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (WebDriverException e) {
            WebDriverWait wait = new WebDriverWait(ThreadManager.getDriver(), seconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } finally {
            //restoring default value
            restoreDefaultImplicitlyWait();
        }
    }

    /**
     * Waits until element becomes visible on the page during default wait period.
     */
    public void waitForElementVisible() throws TimeoutException {
        waitForElementVisible(Runner.getCfg().defaultWait());
    }

    /**
     * Waits until specified attribute contains specified value.
     *
     * @param attribute attribute name
     * @param value     text in attribute you are waiting for
     * @param seconds   time in seconds
     */
    public void waitForTextIsPresentInAttribute(String attribute, String value, int seconds) {
        for (int i = 0; i < (seconds * 2); i++) {
            sleep(50);
            if (getAttribute(attribute).contains(value)) {
                return;
            }
        }

        Logger.EXCEPTION("Timeout after " + seconds + " seconds waiting for text '" + value + "' is present in attribute '" + attribute + "'");

        throw new TimeoutException();
    }

    /**
     * This function designed to change default implicitlyWait of WebDriver.
     * It could be useful when realizing of custom flow is needed.
     * IMPORTANT: Do not forget to set default value using restoreDefaultImplicitlyWait function!!!
     *
     * @param seconds time in seconds
     */
    protected void changeImplicitlyWait(int seconds) {
        ThreadManager.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    /**
     * Restores default value of implicitlyWait for WebDriver using Config.
     */
    protected void restoreDefaultImplicitlyWait() {
        ThreadManager.getDriver().manage().timeouts().implicitlyWait(Runner.getCfg().defaultImplicitlyWait(), TimeUnit.SECONDS);
    }

    public Button getButton(By locator) {
        return new Button(locator);
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


}
