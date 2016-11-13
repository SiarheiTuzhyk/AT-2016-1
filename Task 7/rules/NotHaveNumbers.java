package rules;
import java.util.regex.*;
/**
 * Class for rule, when string haven't digits.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 10.10.2016
 */
public class NotHaveNumbers extends RulesValidate {
    /**
     * Method checks if string correspond to this rule.
     *
     * @param enteredString entered string from keyboard
     * @return <code>true</code> if @param corresponds to rule
     * <code>else</code> otherwise
     */
    @Override
    public boolean checkRule(String enteredString) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(enteredString);
        return !matcher.find();
    }

    /**
     * Method output message that the string corresponds to this rule.
     */
    @Override
    public void printRules() {
        System.out.println("String complies to a 1 rule.");
    }
}
