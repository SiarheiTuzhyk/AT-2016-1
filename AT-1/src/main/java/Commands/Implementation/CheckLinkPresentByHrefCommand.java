package Commands.Implementation;

import Commands.Command;
import Commands.CommandResult;
import Commands.CommandsConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class or implementation command "checkLinkPresentByHref". Extends class "CommandImplementation".
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 20.11.2016
 */
public class CheckLinkPresentByHrefCommand extends CommandImplementation {
    /**
     * Method for checking command to implementation.
     *
     * @param command entered command.
     * @return true if command equals with command implementation argument,
     * false otherwise.
     */
    @Override
    public boolean canImplementation(Command command) {
        return command.getCommand().equals(CommandsConstant.CHECK_LINK_PRESENT_BY_HREF);
    }

    /**
     * Method for implementation command.
     *
     * @param webDriver WebDriver object.
     * @param command   entered command.
     * @return object CommandResult, which consist all results about command implementation.
     */
    @Override
    public CommandResult implementationOfCommand(WebDriver webDriver, Command command) {
        BigDecimal firstTime = new BigDecimal(System.currentTimeMillis());
        boolean result = getResultByNullURL(webDriver);
        if (!result) {
            List<WebElement> elements = webDriver.findElements(By.xpath("a"));
            for (WebElement webElement : elements) {
                if (webElement.getAttribute("href").equals(command.getExpected())) {
                    result = true;
                }
            }
        }
        BigDecimal secondTime = new BigDecimal(System.currentTimeMillis());
        BigDecimal runTime = getRunTimeByCommand(firstTime, secondTime);
        return new CommandResult(result, command, runTime);
    }

    /**
     * Method for calculating runtime of command.
     *
     * @param firstTime  start time of program.
     * @param secondTime end time of program.
     * @return runtime of command in seconds.
     */
    @Override
    public BigDecimal getRunTimeByCommand(BigDecimal firstTime, BigDecimal secondTime) {
        return (secondTime.subtract(firstTime)).divide(new BigDecimal(1000));
    }

    /**
     * Method for checking webdriver current url.
     *
     * @param webDriver WebDriver object.
     * @return if webdriver haven't got url, method return true, else otherwise.
     */
    public boolean getResultByNullURL(WebDriver webDriver) {
        return webDriver.getCurrentUrl() == null;
    }
}
