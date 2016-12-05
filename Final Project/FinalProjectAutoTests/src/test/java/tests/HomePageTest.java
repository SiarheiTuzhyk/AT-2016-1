package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;

/**
 * Class of "HomePage" tests.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 04.12.2016.
 */
public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        homePage = PageFactory.initElements(driver,HomePage.class);
        driver.manage()
                .timeouts()
                .implicitlyWait(7, TimeUnit.SECONDS);
    }

    @DataProvider(name = "positive search")
    public Object[][] forPositiveSearch(){
        return new Object[][]{
                {"university"},{"hockey"},{"EPAM"},{"Uncategorized"},{"admin"},
        };
    }

    @DataProvider(name = "negative search")
    public Object[][] forNegativeSearch(){
        return new Object[][]{
                {"30.11.2016"},{"@admin"},{"Hello, world"}
        };
    }


    @Test(dataProvider = "positive search")
    public void testPositiveSearchFieldTest(String searchText){
        homePage.open();
        homePage.navigationSearchMenu()
                .navigateToSearchField()
                .searchPosts(searchText);
        Assert.assertTrue(driver.getPageSource().contains(searchText));
    }

    @Test(dataProvider = "negative search")
    public void testNegativeSearchFieldTest(String searchText){
        homePage.open();
        homePage.navigationSearchMenu()
                .navigateToSearchField()
                .searchPosts(searchText);
        Assert.assertFalse(driver.getPageSource().contains(searchText));
    }

    @Test
    public void checkPageTitle(){
        homePage.open();
        Assert.assertEquals(driver.getTitle(),"FINAL PROJECT | Final project by EPAM TAT");
    }

    @Test
    public void testClickAllLinks() throws Exception {
        homePage.open();
        List<WebElement> tagsList = homePage.findAllLinksOnHomePage();
        for (WebElement tagElement : tagsList) {
            assertFalse(homePage.isLinkBroken(tagElement.getAttribute("href")));
        }
    }

    @AfterClass
    public void endOfClass(){
        if (driver != null) {
            driver.close();
        }
    }
}
