package POM.Pages;

import Utils.Logger;
import Utils.Runner;
import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {

    private static final By LOGIN_INPUT_LOCATOR = By.id("login-email");
    private static final By PASSWORD_INPUT_LOCATOR = By.id("login-password");
    private static final By SIGN_IN_BUTTON_LOCATOR = By.xpath("//form[@name='loginForm']//button[.='Sign in']");

    private static final By FAIL_MESSAGE_TEXT_LOCATOR = By.xpath("//form[@name='loginForm']//div[contains(@class, 'alert-dismissable')]");

    public LoginPage() {
        url = Runner.getCfg().startUrl();
    }

    public void signInToMaxPay() {
        if (!isLogoDisplayed()) {
            open();
            signIn(Runner.getCfg().login(), Runner.getCfg().password());
        }
    }

    public LoginPage setLogin(String login) {
        Logger.ACTION("Setting Login to: " + login);

        getInput(LOGIN_INPUT_LOCATOR).waitForElementVisible();
        getInput(LOGIN_INPUT_LOCATOR).sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        Logger.ACTION("Setting Password to: " + password);

        getInput(PASSWORD_INPUT_LOCATOR).waitForElementVisible();
        getInput(PASSWORD_INPUT_LOCATOR).sendKeys(password);

        return this;
    }

    public void clickSignIn() {

        Logger.ACTION("Click 'Sign In' button");
        getButton(SIGN_IN_BUTTON_LOCATOR).waitForClickableAndClick();
    }

    public void signIn(String login, String password) {
        startHttpTrafficRecord();
        Logger.STEP("Login with\nUser name: " + login + "\nPassword:  " + password);
        setLogin(login);
        setPassword(password);
        clickSignIn();
        waitForAllResponsesAreSuccessful();
    }


    public String getWarningMessage() {
        getText(FAIL_MESSAGE_TEXT_LOCATOR).waitForElementPresent();
        return getText(FAIL_MESSAGE_TEXT_LOCATOR).getText();
    }
}
