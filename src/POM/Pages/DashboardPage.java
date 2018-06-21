package POM.Pages;

import org.openqa.selenium.By;

public class DashboardPage extends AbstractPage {

    private static final By HEADER_LOCATOR = By.id("header-navbar");

    public boolean checkIfHeaderBarIsShown() {
        return getFrame(HEADER_LOCATOR).isExist();
    }


}
