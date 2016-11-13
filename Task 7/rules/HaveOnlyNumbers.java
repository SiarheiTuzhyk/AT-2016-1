package rules;
import java.util.regex.*;
/**
 * Class for rule, when string have only digits.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 10.10.2016
 */
public class HaveOnlyNumbers extends RulesValidate {
    /**
     * Method checks if string correspond to this rule.
     *
     * @param enteredWords
     * @return <code>true</code> if @param corresponds to rule
     * <code>else</code> otherwise
     */
    @Override
    public boolean checkRule(String enteredWords) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(enteredWords);
        return matcher.matches();
    }

    /**
     * Method output message that the string corresponds to rule.
     */
    @Override
    public void printRules() {
        System.out.println("String complies to a 2 rule.");
    }
}
