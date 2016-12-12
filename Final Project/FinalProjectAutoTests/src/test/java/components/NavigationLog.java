package components;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

/**
 * Class of Navigation login.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 01.12.2016.
 */
public class NavigationLog {
    private static By LOGIN_ERROR = By.xpath(".//*[@id='login_error']");
    private static By SIGN_IN = By.xpath(".//a[text()='Log in']");
    private static By SIGN_OUT = By.xpath(".//a[text()='Log out']");
    private WebDriver driver;

    public NavigationLog(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage navigateToLoginPage() {
        driver.findElement(SIGN_IN).click();
        return new LoginPage(driver);
    }

    public boolean isUserNotLogged() {
        try {
            driver.findElement(LOGIN_ERROR);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public HomePage signOut() {
        driver.findElement(SIGN_OUT).click();
        return new HomePage(driver);
    }
}
