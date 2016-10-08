package rules;
/**
 * Base class of rules.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 08.10.2016
 */
public abstract class RulesBuild {
    /**
     * Method checks if string correspond to rule.
     *
     * @param enteredWords
     * @return <code>true</code> if @param corresponds to rule
     * <code>else</code> otherwise
     */
    public abstract boolean checkRule(String enteredWords);

    /**
     * Method output message that the string corresponds to rule.
     */
    public abstract void printRules();
}
