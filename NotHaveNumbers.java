package rules;
import java.util.regex.*;
/**
 * Class for rule, when string haven't a numbers.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 08.10.2016
 */
public class NotHaveNumbers extends RulesBuild {
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
        if (matcher.find()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method output message that the string corresponds to this rule.
     */
    @Override
    public void printRules() {
        System.out.println("String complies to a 1 rule.");
    }
}
