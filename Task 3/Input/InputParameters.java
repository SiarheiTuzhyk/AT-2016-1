package Input;

import java.math.BigDecimal;

/**
 * Class for validate input parameters.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 05.12.2016.
 */
public class InputParameters {
    /**
     * Method for validate input parameters.
     *
     * @param args command line params.
     * @throws Exception if params don't pass validation.
     */
    public static void checkParameters(String[] args) throws Exception {
        if (args.length > 2) {
            throw new Exception("Input more than two numbers.");
        } else if (args.length < 2) {
            throw new Exception("Enter more numbers.");
        }
        try {
            for (String arg : args) {
                new BigDecimal(arg);
            }
        } catch (Exception ex) {
            throw new Exception("Enter string isn't a number.");
        }
    }
}
