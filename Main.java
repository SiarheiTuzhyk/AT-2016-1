import rules.*;
import java.util.ArrayList;
/**
 * Entrance point to the program.
 * This class calls methods of other classes.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 08-10-2016
 */
public class Main {
    /**
     * Entrance to solution. Creating a list of rules and checking.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        String enteredString = InputArguments.inputWordsFromKeyboard();
        ArrayList<RulesBuild> rules = Builder.initRules();
        Builder.checkStringToRules(rules, enteredString);
    }
}
