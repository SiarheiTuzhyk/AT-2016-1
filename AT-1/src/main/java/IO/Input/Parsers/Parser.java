package IO.Input.Parsers;

import Commands.Command;

import java.util.ArrayList;

/**
 * Parser interface.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 20.11.2016
 */
public interface Parser {
    /**
     * Method for parse files or command line arguments to commands.
     *
     * @return list of commands.
     * @throws Exception if problems with parse.
     */
    ArrayList<Command> parse() throws Exception;
}
