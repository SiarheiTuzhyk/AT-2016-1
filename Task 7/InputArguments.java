import java.util.Scanner;
/**
 * Class for string input.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 08-10-2016
 */
public class InputArguments {
    /**
     * Method for string input.
     *
     * @return inputString entered string from keyboard
     */
    public static String inputWordsFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter your string:");
        String inputString = scanner.nextLine();
        return inputString;
    }
}
