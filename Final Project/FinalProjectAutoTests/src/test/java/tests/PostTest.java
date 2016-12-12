package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Class of "Post" tests*
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 04.12.2016.
 */
public class PostTest {
    private WebDriver driver;
    private HomePage homePage;
    //DBTests dbTests;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage()
                .timeouts()
                .implicitlyWait(7, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void runHomePage(){
        homePage = PageFactory.initElements(driver,HomePage.class);
    }

    @DataProvider(name = "positive test do comment")
    public Object[][] forPositiveDoComment(){
        return new Object[][]{
                {"fdhfdh","hop","hop@gmail.com",""},{"adsgadsfh","hopeee","hopeee@gmail.com",""},
                {"fadbrhhbav","hop","hop@gmail.com",""},{"null","null","null@mail.ru",""},
                {"admin","admin","admin@project.com",""}
        };
    }

    @DataProvider(name = "negative test do comment")
    public Object[][] forNegativeDoComment(){
        return new Object[][]{
                {"","hop","hop@gmail.com",""},{"hey"," ","hop@gmail.com",""},{"hey","hop","",""},
                {"hop","hop","hop@gb",""},{"hop","hop","hop@.ru",""}, {null,null,null,null},
                {" ","s","f@gmail.ru",null},{"null","null","null","null"}, {"h","h","h@",""}
        };
    }

    @Test(dataProvider = "positive test do comment")
    public void positiveTestDoComment(String content, String author, String email, String website){
        homePage = new HomePage(driver);
        homePage.open();
        homePage.navigationPostMenu()
                .navigateToPostPage()
                .postComment(content,author,email,website);
        Assert.assertFalse(homePage.navigationPostMenu().failedComment());
        homePage.open();
    }

    @Test(dataProvider = "negative test do comment")
    public void negativeTestDoComment(String content, String author, String email, String website){
        homePage.open();
        homePage.navigationPostMenu()
                .navigateToPostPage()
                .postComment(content,author,email,website);
        Assert.assertTrue(homePage.navigationPostMenu().failedComment());
        homePage.open();
    }

    @AfterClass
    public void endOfClass(){
        if (driver != null) {
            driver.close();
        }
    }
}
