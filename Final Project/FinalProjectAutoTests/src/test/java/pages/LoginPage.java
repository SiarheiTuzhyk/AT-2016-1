package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class of "login" page. Page Object realisation
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 01.12.2016.
 */
public class LoginPage {

    private By LOGIN_INPUT = By.id("user_login");
    private By PASSWORD_INPUT = By.id("user_pass");
    private By SIGN_IN_BUTTON = By.id("wp-submit");
    private By SIGN_IN_FORM = By.id("loginform");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage loginAs(String username, String password) {
        driver.findElement(LOGIN_INPUT)
                .sendKeys(username);
        driver.findElement(PASSWORD_INPUT)
                .sendKeys(password);
        driver.findElement(SIGN_IN_BUTTON)
                .click();
        return new HomePage(driver);
    }
}