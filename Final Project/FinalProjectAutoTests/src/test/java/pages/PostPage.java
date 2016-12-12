package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Class of "Post" page. Page Object realisation.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 02.12.2016.
 */
public class PostPage {

    private final By textArea = By.id("comment");
    private final By authorComment = By.id("author");
    private final By authorEmail = By.id("email");
    private final By websiteOFAuthor = By.id("url");
    private final By sumbitComment = By.id("submit");
    private final By title_news = By.cssSelector(".entry-title");
    private String url;
    private WebDriver driver;

    public PostPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getURL() {
        String url = "";
        List<WebElement> elementList = driver.findElements(By.tagName("link"));
        for (WebElement webElement : elementList) {
            if (webElement.getAttribute("rel") != "shortlink") {
                url = webElement.getAttribute("href");
            }
        }
        return url;
    }

    public PostPage postComment(String comment, String author, String email, String url) {
        driver.findElement(textArea)
                .sendKeys(comment);
        driver.findElement(authorComment)
                .sendKeys(author);
        driver.findElement(authorEmail)
                .sendKeys(email);
        driver.findElement(websiteOFAuthor)
                .sendKeys(url);
        driver.findElement(sumbitComment)
                .click();
        return new PostPage(driver);
    }

    public PostPage cleanFields(){
        driver.findElement(textArea)
                .sendKeys("");
        driver.findElement(authorComment)
                .sendKeys("");
        driver.findElement(authorEmail)
                .sendKeys("");
        driver.findElement(websiteOFAuthor)
                .sendKeys("");
        return new PostPage(driver);
    }

    public boolean isContainTitle(String title) {
        System.out.println(driver.findElement(title_news).getText());
        return driver.findElement(title_news).getText().equals(title);
    }
}
