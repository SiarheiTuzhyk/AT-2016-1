package Commands;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test class of "Command" class.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 20.11.2016.
 */
public class CommandTest {
    @DataProvider(name = "positive open command constructor")
    public Object[][] forPositiveOpenConstructorCommand() {
        return new Object[][]{
                {"open", "http://www.google.com", "3"}, {"open", "http://m.vk.com", "3"},
                {"open", "http://m.vk.com", "0.0001"}, {"open", "http://m.vk.com", "3.0"}
        };
    }

    @DataProvider(name = "negative open command constructor")
    public Object[][] forNegativeOpenConstructorCommand() {
        return new Object[][]{
                {"open", "http://www.google.com", ""}, {"open", "http://www.google.com", " "},
                {"open", "http://www.google.com", "3,0"}, {"open", "http://www.google.com", "3 0"},
                {"open", "http://m.vk.com", "-0.1"}, {"open", "http://www.google.com", "3.,0"},
                {"open", "http://www.google.com", "3;0"}, {"open", "http://www.google.com", "3\"0"},
                {"open", "http:// m.vk.com", "0.1"}, {" open", "http://m.vk.com", "0.1"},
                {" open ", "http://m.vk.com", "0.1"}, {"open ", "http://m.vk.com", "0.1"},
                {"open", "http://m.vk.com", "0.0"}, {"open", "http://m.vk.com", "O"},
                {"open", "m.vk.com", "1"}, {null, "http://www.google.com", "3.0"},
                {"open", null, "3"}, {"open", "http://m.vk.com", null},
                {"checkPageContains", "http://www.google.com", "3.0"},
                {"checkPageTitle", "http://www.google.com", "3.0"},
                {"checkLinkPresentByHref", "http://www.google.com", "3.0"},
                {"checkLinkPresentByName", "http://www.google.com", "3.0"},
                {"http://www.google.com", "open", "3"}, {"3", "http://www.google.com", "open"},
                {null, "http://www.google.com", null}, {null, null, null}
        };
    }

    @DataProvider(name = "positive other commands constructor")
    public Object[][] forPositiveOtherCommandsConstructor() {
        return new Object[][]{
                {"checkPageContains", "Google"}, {"checkPageContains", "Google \"Hello\""},
                {"checkPageContains", "Google, Hello!"}, {"checkPageTitle", "Google"},
                {"checkPageTitle", "Google forever!"}, {"checkPageTitle", "Google, \"forever!\""},
                {"checkLinkPresentByHref", "href"}, {"checkLinkPresentByName", "name"},
        };
    }

    @DataProvider(name = "negative other commands constructor")
    public Object[][] forNegativeOtherCommandsConstructor() {
        return new Object[][]{
                {"checkPageContains", null}, {"checkPageTitle", null},
                {"checkLinkPresentByHref", null}, {"checkLinkPresentByName", null},
                {"open", "Google"}, {"checkPageContains ", "Google"},
                {" checkPageContains", "Google"}, {" checkPageContains ", "Google"},
                {"checkPageTitle ", "Google"}, {" checkPageTitle", "Google"},
                {" checkPageTitle ", "Google"}, {" checkLinkPresentByHref", "href"},
                {"checkLinkPresentByHref ", "href"}, {" checkLinkPresentByHref ", "href"},
                {" checkLinkPresentByName", "name"}, {"checkLinkPresentByName ", "name"},
                {" checkLinkPresentByName ", "name"}, {null, "Google"}, {null, null},
        };
    }

    @Test(dataProvider = "positive open command constructor")
    public void positiveTestConstructorOpenCommand(String command, String url, String expected) throws Exception {
        new Command(command, url, expected);
    }

    @Test(dataProvider = "negative open command constructor", expectedExceptions = Exception.class)
    public void negativeTestConstructorOpenCommand(String command, String url, String expected) throws Exception {
        new Command(command, url, expected);
    }

    @Test(dataProvider = "positive other commands constructor")
    public void positiveTestConstructorOtherCommand(String command, String expected) throws Exception {
        new Command(command, expected);
    }

    @Test(dataProvider = "negative other commands constructor", expectedExceptions = Exception.class)
    public void negativeTestConstructorOtherCommand(String command, String expected) throws Exception {
        new Command(command, expected);
    }
}