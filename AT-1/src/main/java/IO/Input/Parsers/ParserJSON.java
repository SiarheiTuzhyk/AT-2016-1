package IO.Input.Parsers;

import Commands.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Parser JSON file class, which implements Parser interface.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 20.11.2016
 */
public class ParserJSON implements Parser {
    JsonObject json;

    /**
     * Constructor of class. Create objects, which need in parse json-file.
     *
     * @param path path to json-file.
     */
    public ParserJSON(String path) throws Exception {
        json = new JsonParser().parse(new BufferedReader(new FileReader(path))).getAsJsonObject();
    }

    /**
     * Method for parse json-file.
     *
     * @return list of commands.
     * @throws Exception if problems with file parse or create new command.
     */
    public ArrayList<Command> parse() throws Exception {
        ArrayList<Command> enteredCommands = new ArrayList<>();
        try {
            JsonArray commandJsonArray = json.getAsJsonArray("commands");
            for (JsonElement command : commandJsonArray) {
                enteredCommands.add(getCommandByLine(command.getAsJsonObject()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return enteredCommands;
    }

    /**
     * Method parse each line of json array.
     *
     * @param line json element form array.
     * @return entered command.
     * @throws Exception if problems with create new command.
     */
    private Command getCommandByLine(JsonObject line) throws Exception {
        String name =
                line.get("name") == null ? null : line.get("name").getAsString();
        String url =
                line.get("url") == null ? null : line.get("url").getAsString();
        String expected =
                line.get("expected") == null ? null : line.get("expected").getAsString();
        if (url == null) {
            return new Command(name, expected);
        } else {
            return new Command(name, url, expected);
        }
    }
}
