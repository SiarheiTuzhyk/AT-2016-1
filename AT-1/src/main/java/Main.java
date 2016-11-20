import IO.Input.Reader;
import IO.Output.Writer;
import Commands.*;

import java.util.ArrayList;

/**
 * Main class of framework. Entrance point of a program.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 20.11.2016
 */
public class Main {

    /**
     * Main method of the program.
     *
     * @param args command line params.
     */
    public static void main(String[] args) throws Exception {
        try {
            ArrayList<Command> commands = new ArrayList<Command>();
            Reader reader = new Reader();
            commands = reader.getCommands(args);
            CommandsBuild commandsBuild = new CommandsBuild();
            ScenarioImplementation scenarioImplementation = new ScenarioImplementation();
            ArrayList<CommandResult> resultsCommands = scenarioImplementation.resultsImplementationCommands(commands);
            Writer writer = new Writer();
            writer.writeLogToTXT(resultsCommands);
            System.out.println("End of the program!");
        } catch (Exception ex) {
            System.out.println("Program error: " + ex.getMessage());
        }
    }
}
