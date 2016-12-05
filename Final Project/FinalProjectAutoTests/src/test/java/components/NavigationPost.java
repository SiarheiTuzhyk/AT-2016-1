package components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.PostPage;

import java.util.List;

/**
 * Class of NavigationPost.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 02.12.2016.
 */
public class NavigationPost {
    private WebDriver driver;
    private By POST = By.cssSelector(".entry-title>a");
    private By ERROR = By.id("error-page");

    public NavigationPost(WebDriver driver) {
        this.driver = driver;
    }

    public PostPage navigateToPostPage() {
        driver.findElement(POST).click();
        return new PostPage(driver);
    }

    public boolean failedComment() {
        try {
            driver.findElement(ERROR);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
