package Commands;

import Commands.Implementation.CommandImplementation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

/**
 * Class of scenario implementation.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 20.11.2016.
 */
public class ScenarioImplementation {

    ArrayList<CommandImplementation> commandsBuild;

    /**
     * Constructor of class. Get implementation of all commands from CommandsBuild class.
     */
    public ScenarioImplementation() {
        this.commandsBuild = new CommandsBuild().getCommandsBuild();
    }

    /**
     * Method for getting results about commands implementation.
     *
     * @param commands list of commands, which should be implementation.
     * @return list of results about commands implementation.
     */
    public ArrayList<CommandResult> resultsImplementationCommands(ArrayList<Command> commands) {
        ArrayList<CommandResult> results = new ArrayList<CommandResult>();
        System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        for (Command command : commands) {
            results.add(getResultsByCommand(chromeDriver, command));
        }
        chromeDriver.quit();
        return results;
    }

    /**
     * Method for getting results about commands performance.
     *
     * @param command entered commands from files/command line
     * @return result about performance each command.
     */
    public CommandResult getResultsByCommand(WebDriver webDriver, Command command) {
        CommandResult result = new CommandResult();
        for (CommandImplementation implementation : commandsBuild) {
            if (implementation.canImplementation(command)) {
                result = implementation.implementationOfCommand(webDriver, command);
            }
        }
        return result;
    }
}
