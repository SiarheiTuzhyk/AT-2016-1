package Commands;

import java.math.BigDecimal;

/**
 * Result class of command implementation.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 20.11.2016
 */
public class CommandResult {
    //Fields of class
    private boolean result;
    private Command command;
    private BigDecimal runTime;

    /**
     * Default constructor of class.
     */
    public CommandResult() {
    }

    /**
     * Constructor of class.
     *
     * @param result  result of command implementation.
     * @param command entered command.
     * @param runTime runtime of command.
     */
    public CommandResult(boolean result, Command command, BigDecimal runTime) {
        this.result = result;
        this.command = command;
        this.runTime = runTime;
    }

    /**
     * Getter of result field.
     *
     * @return result of command implementation.
     */
    public boolean getResult() {
        return result;
    }

    /**
     * Getter of runTime field.
     *
     * @return runtime of command implementation.
     */
    public BigDecimal getRunTime() {
        return runTime;
    }

    /**
     * Getter of command field.
     *
     * @return command, which implementation..
     */
    public Command getCommand() {
        return command;
    }

    /**
     * Method create string, which should be write to log-file.
     *
     * @return string, which should be write to log-file.
     */
    public String resultConverter() {
        if (result) {
            return ("+ [" + command.getStringOfAllCommand() + "] " + runTime + "s");
        } else {
            return ("! [" + command.getStringOfAllCommand() + "] " + runTime + "s");
        }
    }
}
