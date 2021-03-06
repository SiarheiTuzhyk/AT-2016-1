package Commands;

import java.util.ArrayList;

/**
 * Abstract class of Commands.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 11.10.2016
 */
public abstract class InstructionBuild {
    /**
     * Method for doing command.
     *
     * @param products entered products
     */
    public abstract void doCommand(ArrayList<Product> products);

    /**
     * Checking command for this class.
     *
     * @param command  entered command
     * @param products entered products
     * @return <>true</> if class can do this command
     * <>false</> otherwise
     */
    public abstract boolean canExecute(String command, ArrayList<Product> products);

    /**
     * Method for print result of command.
     *
     * @param variable certain variable, which need for print result of command
     */
    public abstract void printMessage(double variable);
}
