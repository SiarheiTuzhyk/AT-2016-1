package Commands;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class for validate entered commands.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
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

        try {
            new BigDecimal(expected);
        } catch (Exception ex) {
            throw new Exception("Expected time is not a number!");
        }

        Pattern pattern = Pattern.compile(" ");
        Matcher matcher = pattern.matcher(url);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        if (count > 0) {
            throw new Exception("Invalid url!");
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
}
