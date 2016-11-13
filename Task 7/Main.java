import rules.*;
import java.util.ArrayList;
/**
 * Entrance point to the program.
 * This class calls methods of other classes.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 10-10-2016
 */
public class Main {
    /**
     * Entrance to solution. Creating a list of rules and checking.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        try {
            String enteredString = InputArguments.inputWordsFromKeyboard();
            ArrayList<RulesValidate> rules = CheckRules.initRules();
            CheckRules.checkStringToRules(rules, enteredString);
        }
        catch (Exception e) {
            System.out.println("Program error.");
        }
    }
}
