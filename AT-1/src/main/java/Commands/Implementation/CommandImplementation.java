package Commands.Implementation;

import Commands.Command;
import Commands.CommandResult;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

/**
 * Command implementation class. This class should be extends by others command.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 20.11.2016
 */
public abstract class CommandImplementation {
    /**
     * Method for checking command to implementation.
     *
     * @param command entered command.
     * @return true if command equals with command implementation argument,
     * false otherwise.
     */
    public abstract boolean canImplementation(Command command);

    /**
     * Method for implementation command.
     *
     * @param webDriver WebDriver object.
     * @param command   entered command.
     * @return object CommandResult, which consist all results about command implementation.
     */
    public abstract CommandResult implementationOfCommand(WebDriver webDriver, Command command);

    /**
     * Method for calculating runtime of command.
     *
     * @param firstTime  start time of program.
     * @param secondTime end time of program.
     * @return runtime of command in seconds.
     */
    public abstract BigDecimal getRunTimeByCommand(BigDecimal firstTime, BigDecimal secondTime);
}
