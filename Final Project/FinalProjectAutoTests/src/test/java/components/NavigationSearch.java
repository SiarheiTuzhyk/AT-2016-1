package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

/**
 * Class of NavigationSearch.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 04.12.2016.
 */
public class NavigationSearch {

    private By searchField = By.xpath(".//*[@id='search-2']/form/label/input");
    private WebDriver driver;

    public NavigationSearch(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage navigateToSearchField() {
        driver.findElement(searchField);
        return new HomePage(driver);
    }
}
