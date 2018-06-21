package POM.Elements;

import Utils.Logger;
import org.openqa.selenium.By;

public class DropDownMenuMore extends AbstractElement {

    private static final By OPEN_DROP_DOWN_MENU_BTN_LOCATOR = By.xpath("//span[@id='dropdownMenuMore']");

    private static final By DROP_DOWN_MENU_LOCATOR = By.xpath("//div[@class='dropdown toolsDropdown open']");

    private static final By SHARE_BTN_LOCATOR = By.xpath("//div[@ui-view='navTopBar']//a[*[@class='icon-share']]");
    private static final By EDIT_BTN_LOCATOR = By.xpath("//ul[@class='dropdown-menu']//a[*[@class='icon-edit']]");
    private static final By DELETE_BTN_LOCATOR = By.xpath("//a[contains(.,'Delete')]");
    private static final By RUN_NOW_BTN_LOCATOR = By.xpath("//a[*[@class='icon-run']]");

    public DropDownMenuMore() {
        super(OPEN_DROP_DOWN_MENU_BTN_LOCATOR);
    }

    public void expandDropDownMenu() {
        Logger.ACTION("Expand DropDownMenuMore");
        getButton(OPEN_DROP_DOWN_MENU_BTN_LOCATOR).waitForElementVisible();
        getButton(OPEN_DROP_DOWN_MENU_BTN_LOCATOR).waitForClickableAndClick();
        getButton(DROP_DOWN_MENU_LOCATOR).waitForElementPresent(2);
    }

    public void clickDelete() {
        expandDropDownMenu();
        // used because ObservePoints modals doesn't load at time
        Logger.ACTION("DropDownMenu: Click 'Delete' button");
        getButton(DELETE_BTN_LOCATOR).waitForVisibleAndClick();
    }

    public void clickShare() {
        expandDropDownMenu();
        Logger.ACTION("DropDownMenu: Click 'Share' button");
        getButton(SHARE_BTN_LOCATOR).waitForVisibleAndClick();
    }

    public void clickEdit() {
        expandDropDownMenu();
        Logger.ACTION("DropDownMenu: Click 'Edit' button");
        getButton(EDIT_BTN_LOCATOR).waitForVisibleAndClick();
    }

    public void clickRunNow() {
        expandDropDownMenu();
        Logger.ACTION("DropDownMenu: Click 'Run Now' button");
        getButton(RUN_NOW_BTN_LOCATOR).waitForVisibleAndClick();
    }

    public Button getEditButton() {
        getButton(EDIT_BTN_LOCATOR);
        return getButton(EDIT_BTN_LOCATOR);
    }

    public Button getRunNowButton() {
        getButton(RUN_NOW_BTN_LOCATOR);
        return getButton(RUN_NOW_BTN_LOCATOR);
    }
}
