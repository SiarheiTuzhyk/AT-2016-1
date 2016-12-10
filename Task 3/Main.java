import Calculation.*;
import Input.InputParameters;

import java.util.List;

/**
 * Main class of program.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 05.12.2016.
 */
public class Main {
    /**
     * Main method of program. Performed important operations of program.
     *
     * @param args command line params.
     */
    public static void main(String[] args) {
        try {
            InputParameters.checkParameters(args);
            List<Calculation> calculations = new CalculationsBuild().calculationsBuilder(args);
            for (Calculation calculation : calculations) {
                calculation.calculate();
                calculation.printResult();
            }
        } catch (Exception ex) {
            System.out.println("Program error: " + ex.getMessage());
        }
    }
}
