package POM.Elements;

import org.openqa.selenium.By;

public class Select extends AbstractElement {
    public Select(By locator) {
        super(locator);
    }

    public void selectByVisibleText(String label) {

    /*    for (int i =0; i<3 && !getButton(By.xpath("//a/span[contains(.,'"+label+"')]")).isPresent(); i++) {
            getButton(locator).waitForVisibleAndClick(3);

            try {
                getButton(By.xpath("//a/span[contains(.,'"+label+"')]")).waitForVisibleAndClick(2);
                return;

            } catch (TimeoutException e) {
                getButton(locator).waitForVisibleAndClick(3);
                Logger.INFO(e.getMessage());
            }

        }*/

        getButton(locator).waitForVisibleAndClick();
        getButton(By.xpath("//ul[@role='select']")).waitForElementVisible();
        getButton(By.xpath("//a/span[contains(.,'" + label + "')]")).waitForClickableAndClick();

    }


}
