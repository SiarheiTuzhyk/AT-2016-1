import rules.*;
import java.util.ArrayList;
/**
 * Class for initialization of rules and Checking string for compliance with the rules.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 08-10-2016
 */
public class Builder {
    /**
     * Initialization of rules to arraylist.
     *
     * @return rules list of rules
     */
    public static ArrayList<RulesBuild> initRules() {
        ArrayList<RulesBuild> rules = new ArrayList<>();
        rules.add(new NotHaveNumbers());
        rules.add(new HaveOnlyNumbers());
        rules.add(new MoreThanFiveWords());
        rules.add(new WordFromVocabulary());
        return rules;
    }

    /**
     * Checking string for compliance with the rules.
     *
     * @param rules         list of rules
     * @param enteredString string, that user entered
     */
    public static void checkStringToRules(ArrayList<RulesBuild> rules, String enteredString) {
        // count of satisfy rules
        int count = 0;
        for (RulesBuild rule : rules) {
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
