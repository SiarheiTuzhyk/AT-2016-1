package IO.Input.Parsers;

import Commands.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Parser txt-files class. Implements Parser interface with his method "parse".
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 20.11.2016
 */
public class ParserTXT implements Parser {
    BufferedReader bufferedReader;

    /**
     * Constructor of class.
     *
     * @param path path to txt-file, which consist data for import.
     */
    public ParserTXT(String path) throws Exception {
        bufferedReader = new BufferedReader(new FileReader(new File(path)));
    }

    /**
     * Method for getting commands from txt-file.
     *
     * @return entered commands.
     * @throws Exception if problems with parse file or creating new Command.
     */
    public ArrayList<Command> parse() throws Exception {
        ArrayList<Command> enteredCommands = new ArrayList<Command>();
        String bufferLine;
        while ((bufferLine = bufferedReader.readLine()) != null) {
            String[] params = bufferLine.split(" ", 2);
            enteredCommands.add(getCommandByLine(params));
        }
        return enteredCommands;
    }

    /**
     * Method for getting only one command from 1 line txt-file.
     *
     * @param params line from txt-file.
     * @return entered command from line.
     * @throws Exception if problems in creating new object of class Command.
     */
    private Command getCommandByLine(String[] params) throws Exception {
        String command = params[0];
        if (command.equals(CommandsConstant.OPEN)) {
            String[] argument = params[1].split(" ", 2);
            String url = argument[0].substring(1, argument[0].length() - 1);
            String expected = argument[1].substring(1, argument[1].length() - 1);
            return (new Command(command, url, expected));
        } else if (command.equals(CommandsConstant.CHECK_LINK_PRESENT_BY_HREF)
                || command.equals(CommandsConstant.CHECK_LINK_PRESENT_BY_NAME)
                || command.equals(CommandsConstant.CHECK_PAGE_TITLE)
                || command.equals(CommandsConstant.CHECK_PAGE_CONTAINS)) {
            String expected = params[1].substring(1, params[1].length() - 1);
            return (new Command(command, expected));
        } else {
            throw new Exception("Not valid command!");
        }
    }
}
