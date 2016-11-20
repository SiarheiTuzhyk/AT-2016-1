package Commands;

/**
 * Class of entered command.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 20.11.2016
 */
public class Command {
    // Fields of class.
    private String url;
    private String command;
    private String expected;

    /**
     * Construction of class. his constructor for others commands, because that command have got 2 arguments.
     *
     * @param command  entered command.
     * @param expected entered expected argument.
     */
    public Command(String command, String expected) throws Exception {
        CommandValidate.validateEnteredCommand(command, expected);
        this.command = command;
        this.expected = expected;
    }

    /**
     * Construction of class. his constructor for "open" command, because that command have got 3 arguments.
     *
     * @param command  entered command.
     * @param url      entered url.
     * @param expected entered expected timeout.
     */
    public Command(String command, String url, String expected) throws Exception {
        CommandValidate.validateEnteredCommand(command, url, expected);
        this.command = command;
        this.url = url;
        this.expected = expected;
    }

    /**
     * Getter of url field.
     *
     * @return url string.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Getter of command field.
     *
     * @return command string.
     */
    public String getCommand() {
        return command;
    }

    /**
     * Getter of expected field.
     *
     * @return expected string.
     */
    public String getExpected() {
        return expected;
    }

    /**
     * Method return string of all command in one string.
     *
     * @return string of all command.
     */
    public String getStringOfAllCommand() {
        if (url != null) {
            return (command + " \"" + url + "\" " + "\"" + expected + "\"");
        } else {
            return (command + " \"" + expected + "\"");
        }
    }

    /**
     * Method for print command.
     */
    public void printCommand() {
        if (url != null) {
            System.out.println(command + " " + url + " " + expected);
        } else {
            System.out.println(command + " " + expected);
        }
    }
}
