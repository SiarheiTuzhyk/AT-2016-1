package Commands;

import Commands.Implementation.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

/**
 * Class for build commands implementation.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 20.11.2016
 */
public class CommandsBuild {

    ArrayList<CommandImplementation> commandsBuild;

    /**
     * Constructor of class. Create new objects of commands implementation.
     */
    public CommandsBuild() {
        commandsBuild = new ArrayList<>();
        commandsBuild.add(new OpenCommand());
        commandsBuild.add(new CheckLinkPresentByHrefCommand());
        commandsBuild.add(new CheckLinkPresentByNameCommand());
        commandsBuild.add(new CheckPageTitleCommand());
        commandsBuild.add(new CheckPageContainsCommand());
    }

    /**
     * Getter of commands build.
     *
     * @return list of implementations of commands.
     */
    public ArrayList<CommandImplementation> getCommandsBuild() {
        return commandsBuild;
    }
}
