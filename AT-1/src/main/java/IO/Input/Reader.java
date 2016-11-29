package IO.Input;

import Commands.Command;
import IO.Input.Parsers.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for read files/command line.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 20.11.2016
 */
public class Reader {
    /**
     * Method for choose method of data import and return commands from there method.
     *
     * @param args command line arguments.
     * @return list of commands.
     * @throws Exception if have problems with import data. or not input data import.
     */
    public ArrayList<Command> getCommands(String[] args) throws Exception {
        ArrayList<Command> commands = new ArrayList<Command>();
        try {
            Parser parser;
            if (args.length != 0) {
                parser = new ParserCommandLine(args);
                commands = parser.parse();
            } else {
                System.out.println("Choose import option: \nt/T - txt file; x/X - xml file; j/J - json file;");
                Scanner scanner = new Scanner(System.in);
                String entered = scanner.next();
                if (entered.equals("t") || entered.equals("T")) {
                    parser = new ParserTXT(PathConstants.PATH_TXT);
                    commands = parser.parse();
                } else if (entered.equals("x") || entered.equals("X")) {
                    parser = new ParserXML(PathConstants.PATH_XML);
                    commands = parser.parse();
                } else if (entered.equals("j") || entered.equals("J")) {
                    parser = new ParserJSON(PathConstants.PATH_JSON);
                    commands = parser.parse();
                } else {
                    throw new IOException("Not input import option!");
                }
            }
        } catch (Exception ex) {
            throw new Exception("Read error: " + ex.getMessage());
        }
        return commands;
    }
}
