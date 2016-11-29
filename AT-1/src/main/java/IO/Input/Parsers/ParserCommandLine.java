package IO.Input.Parsers;

import Commands.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for parse command line parameters.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 15.11.2016
 */
public class ParserCommandLine implements Parser {

    String[] inputParameters;
    private final String COMMAND_PREFIX = "--command=";

    /**
     * Constructor of class
     *
     * @param args command line arguments.
     */
    public ParserCommandLine(String[] args) {
        for (String x : args) {
            this.inputParameters = args;
        }
    }

    /**
     * Method for parse files or command line arguments to commands.
     *
     * @return list of commands.
     * @throws Exception if problems with parse.
     */
    public ArrayList<Command> parse() throws Exception {
        ArrayList<Command> enteredCommands = new ArrayList<Command>();
        int count_commands = howMuchCommandInEnteredString(inputParameters, COMMAND_PREFIX);
        int elementOfArgs = 0;
        for (int i = 0; i < count_commands; i++) {
            String command = inputParameters[elementOfArgs++];
            if (command.startsWith(COMMAND_PREFIX)) {
                command = command.substring(COMMAND_PREFIX.length());
            }
            if (command.equals(CommandsConstant.OPEN)) {
                String url = inputParameters[elementOfArgs++];
                enteredCommands.add(new Command(command, url, inputParameters[elementOfArgs++]));
            } else if (command.equals(CommandsConstant.CHECK_LINK_PRESENT_BY_HREF)
                    || command.equals(CommandsConstant.CHECK_LINK_PRESENT_BY_NAME)
                    || command.equals(CommandsConstant.CHECK_PAGE_TITLE)
                    || command.equals(CommandsConstant.CHECK_PAGE_CONTAINS)) {
                String expected = inputParameters[elementOfArgs++];
                enteredCommands.add(new Command(command, expected));
            }
        }
        return enteredCommands;
    }

    /**
     * Method for search how much commands in command line arguments.
     *
     * @param enteredString command line arguments
     * @param command       command prefix
     */
    private int howMuchCommandInEnteredString(String[] enteredString, String command) {
        int count = 0;
        for (String x : enteredString) {
            Pattern pattern = Pattern.compile(command);
            Matcher matcher = pattern.matcher(x);
            while (matcher.find()) {
                count++;
            }
        }
        return count;
    }
}
