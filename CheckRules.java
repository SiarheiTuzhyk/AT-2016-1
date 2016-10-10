import rules.*;
import java.util.ArrayList;
/**
 * Class for initialization of rules and Checking string for compliance with the rules.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 10-10-2016
 */
public class CheckRules {
    /**
     * Initialization of rules to arraylist.
     *
     * @return rules list of rules
     */
    public static ArrayList<RulesValidate> initRules() {
        ArrayList<RulesValidate> rules = new ArrayList<>();
        rules.add(new NotHaveNumbers());
        rules.add(new HaveOnlyNumbers());
        rules.add(new MoreThanNWords());
        rules.add(new WordFromVocabulary());
        return rules;
    }

    /**
     * Checking string for compliance with the rules.
     *
     * @param rules         list of rules
     * @param enteredString string, that user entered
     */
    public static void checkStringToRules(ArrayList<RulesValidate> rules, String enteredString) {
        // count of satisfy rules
        int count = 0;
        for (RulesValidate rule : rules) {
            if (rule.checkRule(enteredString)) {
                rule.printRules();
                ++count;
            }
        }
        if (count == 0) {
            System.out.println("This string doesn't satisfy the rules.");
        }
    }
}
