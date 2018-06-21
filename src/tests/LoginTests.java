package tests;

import Managers.ThreadManager;
import POM.Pages.DashboardPage;
import POM.Pages.LoginPage;
import Utils.Runner;
import Utils.TestNGListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class LoginTests {

    @AfterMethod
    public void afterTest() {
        ThreadManager.removeDriver();
    }


    @DataProvider(name = "incorrect values for SignIn")
    public Object[][] incorrectValuesForSignIn() {

        return new Object[][]{
                {Runner.getCfg().login(), "incorrectPassword"},
                {"incorrectLogin@test.com", Runner.getCfg().password()}
        };
    }


    @Test(dataProvider = "incorrect values for SignIn")
    public void testIncorrectLogin(String login, String password) throws Exception {
        LoginPage loginPage = new LoginPage();
        String EXPECTED_WORNING = "Password or email are incorrect";

        loginPage.open();
        loginPage.signIn(login, password);

        String currentWorning = loginPage.getWarningMessage();
        Assert.assertEquals(currentWorning, EXPECTED_WORNING, "Expected worning is incorrect!");

    }

    @Test
    public void testLoginWithValidValues() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.signIn(Runner.getCfg().login(), Runner.getCfg().password());

        Assert.assertTrue(new DashboardPage().checkIfHeaderBarIsShown(), "Dashboard's header bar is not shown after click 'Sign in'");

    }

}
