package rules;
import java.util.regex.*;
/**
 * Class for rule, when string have more, than five words.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 10.10.2016
 */
public class MoreThanNWords extends RulesValidate {
    // Constant of regular expressions (space and punctuation)
    private final String SPACE = "[ \\t\\n\\r]+";
    private final String PUNCTUATION = "\\p{Punct}";
    private final int FIVE = 5;
    /**
     * Method checks if string correspond to this rule.
     *
     * @param enteredWords entered string from keyboard
     * @return <code>true</code> if @param corresponds to rule
     * <code>else</code> otherwise
     */
    @Override
    public boolean checkRule(String enteredWords) {
        int countSpace = howMuchInEnteredString(enteredWords, SPACE);
        int countPunctuation = howMuchInEnteredString(enteredWords, PUNCTUATION);
        return !(countPunctuation < FIVE && countSpace < FIVE);
    }

    /**
     * This method check how much <code>compile</code> found in string.
     *
     * @param enteredString entered string from keyboard
     * @param compile       regular expressions (space and punctuation)
     * @return count        how much <code>compile</code> found in string
     */
    private static int howMuchInEnteredString(String enteredString, String compile) {
        int count = 0;
        Pattern pattern = Pattern.compile(compile);
        Matcher matcher = pattern.matcher(enteredString);
        while (matcher.find()) {
            count++;
        }
        return count + 1;
    }

    /**
     * Method output message that the string corresponds to this rule.
     */
    @Override
    public void printRules() {
        System.out.println("String complies to a 3 rule.");
    }
}
