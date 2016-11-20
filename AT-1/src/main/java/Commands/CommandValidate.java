package Commands;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for validate entered commands.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 20.11.2016
 */
public class CommandValidate {
    /**
     * Method for validate command "open".
     *
     * @param command  entered command.
     * @param url      entered url.
     * @param expected entered expected time.
     * @throws Exception if entered commands have got invalid arguments.
     */
    public static void validateEnteredCommand(String command, String url, String expected) throws Exception {
        if (command == null || url == null || expected == null) {
            throw new Exception("Argument is null!");
        }
        if (!command.equals(CommandsConstant.OPEN)) {
            throw new Exception("Input not valid command!");
        }
        if (checkSymbolsAtString(url, " ") > 0) {
            throw new Exception("Invalid url!");
        }
        if (checkSymbolsAtString(url, "http://") == 0
                && checkSymbolsAtString(url, "https://") == 0) {
            throw new Exception("Invalid url!");
        }
        try {
            new BigDecimal(expected);
        } catch (Exception ex) {
            throw new Exception("Expected time is not a number!");
        }
        if (new BigDecimal(expected).compareTo(BigDecimal.ZERO) == -1
                || new BigDecimal(expected).compareTo(BigDecimal.ZERO) == -0) {
            throw new Exception("Expected time isn't less or equals by zero!");
        }
    }


    /**
     * Method for validate command other command.
     *
     * @param command  entered command.
     * @param expected entered expected time.
     * @throws Exception if entered commands have got invalid arguments.
     */
    public static void validateEnteredCommand(String command, String expected) throws Exception {
        if (command == null || expected == null) {
            throw new Exception("Argument is null!");
        }
        switch (command) {
            case CommandsConstant.CHECK_LINK_PRESENT_BY_HREF:
                break;
            case CommandsConstant.CHECK_LINK_PRESENT_BY_NAME:
                break;
            case CommandsConstant.CHECK_PAGE_TITLE:
                break;
            case CommandsConstant.CHECK_PAGE_CONTAINS:
                break;
            default:
                throw new Exception("Invalid command!");
        }
    }

    /**
     * @param enteredWords
     * @param symbols
     * @return
     */
    private static int checkSymbolsAtString(String enteredWords, String symbols) {
        Pattern pattern = Pattern.compile(symbols);
        Matcher matcher = pattern.matcher(enteredWords);
        int count = 0;
        if (matcher.find()) {
            count++;
        }
        return count;
    }
}
