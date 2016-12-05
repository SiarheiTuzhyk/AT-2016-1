package pages;

import components.NavigationLog;
import components.NavigationPost;
import components.NavigationSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Class of "HomePage". Page Object realisation.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 01.12.2016.
 */
public class HomePage {

    private static final String HOMEPAGE_URL = "http://localhost:8888";
    private By searchField = By.xpath(".//*[@id='search-2']/form/label/input");
    private final NavigationLog navigationLogMenu;
    private  final NavigationSearch navigationSearchMenu;
    private final NavigationPost navigationPostMenu;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.navigationLogMenu = new NavigationLog(driver);
        this.navigationPostMenu = new NavigationPost(driver);
        this.navigationSearchMenu = new NavigationSearch(driver);
    }

    public HomePage open() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public HomePage searchPosts(String searchText){
        driver.findElement(searchField).sendKeys(searchText);
        driver.findElement(searchField).submit();
        return new HomePage(driver);
    }

    public NavigationSearch navigationSearchMenu(){
        return navigationSearchMenu;
    }

    public NavigationLog navigationLogMenu() {
        return navigationLogMenu;
    }

    public NavigationPost navigationPostMenu() {
        return navigationPostMenu;
    }

    public List<WebElement> findAllLinksOnHomePage() {
        List<WebElement> elementList = driver.findElements(By.tagName("a"));
        elementList.addAll(driver.findElements(By.tagName("img")));
        List<WebElement> finalList = new ArrayList<>();
        for (WebElement element : elementList) {
            if (element.getAttribute("href") != null) {
                finalList.add(element);
            }
        }
        return finalList;
    }

    public boolean isLinkBroken(String testURL) throws Exception {
        URL url = new URL(testURL);
        HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
        httpURLConnect.setConnectTimeout(3000);
        httpURLConnect.connect();
        if (httpURLConnect.getResponseCode() == 200) {
            return false;
        } else if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
            return true;
        }
        return true;
    }
}