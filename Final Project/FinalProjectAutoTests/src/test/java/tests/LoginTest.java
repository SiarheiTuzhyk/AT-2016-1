package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

/**
 * Class of "LogIn" tests.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 30.11.2016.
 */
public class LoginTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.manage()
                .timeouts()
                .implicitlyWait(7, TimeUnit.SECONDS);
    }



    @DataProvider(name = "positive login test")
    public Object[][] positiveLoginTest() {
        return new Object[][]{
                {"admin", "120896"}, {"Admin", "120896"}, {"ADMIN", "120896"},
                {"kizha", "120896"}, {"Kizha", "120896"}, {"KIZHA", "120896"},
                {"fomas", "120896"}, {"Fomas", "120896"}, {"FOMAS", "120896"},
        };
    }

    @DataProvider(name = "negative login test")
    public Object[][] negativeLoginTest() {
        return new Object[][]{
                {"automation.user2015@gmail.com", "120896"}, {"120896", "admin"},
                {"a dmin", "120896"}, {"/admin", "120896"}, {"admin", ""}, {"", "120896"}
        };
    }

    @Test(dataProvider = "negative login test")
    public void negativeTestSignIn(String login, String password) {
        homePage.open();
        homePage.navigationLogMenu()
                .navigateToLoginPage()
                .loginAs(login, password);
        Assert.assertTrue(homePage.navigationLogMenu()
                .isUserNotLogged());
    }

    @Test(dataProvider = "positive login test")
    public void positiveTestSignIn(String login, String password) throws InterruptedException {
        homePage.open();
        homePage.navigationLogMenu()
                .navigateToLoginPage()
                .loginAs(login, password);
        Assert.assertFalse(homePage.navigationLogMenu()
                .isUserNotLogged());
        homePage.open();
        homePage.navigationLogMenu().signOut();
    }


    @AfterClass
    public void endOfClass() {
        if (driver != null) {
            driver.close();
        }
    }
}
