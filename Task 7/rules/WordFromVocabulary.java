package rules;

import java.util.ArrayList;
import java.util.regex.*;

/**
 * Class for rule, when string have words from vocabulary.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 10.10.2016
 */
public class WordFromVocabulary extends RulesValidate {
    // Vocabulary words
    private final static String KEY = new String("key");
    private final static String SCHOOL = new String("school");
    private final static String TRAIN = new String("train");
    private final static String BALL = new String("ball");
    private final static String BARCELONA = new String("barcelona");

    /**
     * Method checks if string correspond to this rule.
     *
     * @param enteredWords entered string from keyboard
     * @return <code>true</code> if @param corresponds to rule
     * <code>else</code> otherwise
     */
    @Override
    public boolean checkRule(String enteredWords) {
        ArrayList<String> vocabulary = new ArrayList<String>();
        vocabulary.add(KEY);
        vocabulary.add(SCHOOL);
        vocabulary.add(TRAIN);
        vocabulary.add(BALL);
        vocabulary.add(BARCELONA);
        // Count of founding words in string
        int count = 0;
        for (String x : vocabulary) {
            count += checkVocabularyAtString(enteredWords, x, count);
        }
        return (count > 0);
    }

    /**
     * Method for check vocabulary words in entered string.
     *
     * @param enteredWords   entered string from keyboard
     * @param vocabularyWord word from Vocabulary
     */
    private static int checkVocabularyAtString(String enteredWords, String vocabularyWord, int count) {
        Pattern pattern = Pattern.compile(vocabularyWord);
        Matcher matcher = pattern.matcher(enteredWords);
        if (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * Method output message that the string corresponds to this rule.
     */
    @Override
    public void printRules() {
        System.out.println("String complies to a 4 rule.");
    }
}
