package POM.Elements;

import Managers.ThreadManager;
import Utils.Runner;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class Frame extends AbstractElement {
    public Frame(By locator) {
        super(locator);
    }

    public void switchTo() {
        ThreadManager.getDriver().switchTo().frame(getWebElement());
    }

    public boolean isExist() {
        try {
            waitForElementVisible(Runner.getCfg().defaultWait());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

}
