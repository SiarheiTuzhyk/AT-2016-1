package IO.Input.Parsers;

import Commands.*;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Parser XML file class, which implements Parser interface.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 20.11.2016
 */
public class ParserXML implements Parser {

    private final static String COMMANDS = "commands";
    Document document;

    /**
     * Constructor of class. Create objects, which need to parse xml file.
     *
     * @param path patho to xml-file.
     */
    public ParserXML(String path) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.parse(new File(path));
    }

    /**
     * Method for parse xml file.
     *
     * @return list of commands.
     * @throws Exception if problems with parse xml-file.
     */
    public ArrayList<Command> parse() throws Exception {
        ArrayList<Command> enteredInstructions = new ArrayList<Command>();
        NodeList nodes = document.getElementsByTagName(COMMANDS);
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attributes = nodes.item(i).getAttributes();
            enteredInstructions.add(getCommandByLine(attributes));
        }
        return enteredInstructions;
    }

    /**
     * Method for getting Command from 1 line.
     *
     * @param attributes NamedNodeMap object.
     * @return entered command.
     */
    private Command getCommandByLine(NamedNodeMap attributes) throws Exception {
        String command = attributes.getNamedItem(CommandsConstant.COMMAND) == null
                ? null : attributes.getNamedItem(CommandsConstant.COMMAND).getNodeValue();
        String url = attributes.getNamedItem(CommandsConstant.URL) == null
                ? null : attributes.getNamedItem(CommandsConstant.URL).getNodeValue();
        String expected = attributes.getNamedItem(CommandsConstant.EXPECTED) == null
                ? null : attributes.getNamedItem(CommandsConstant.EXPECTED).getNodeValue();
        if (url == null) {
            return new Command(command, expected);
        } else {
            return new Command(command, url, expected);
        }
    }
}
