package Calculation;

import Input.InputParameters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Builder class of calculations.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 06.12.2016.
 */
public class CalculationsBuild {
    /**
     * Method for build objects of calculation interface.
     *
     * @param args command line params.
     * @return list of calculation objects.
     */
    public List<Calculation> calculationsBuilder(String[] args) throws Exception {
        List<Calculation> calculations = new ArrayList<Calculation>();
        try {
            InputParameters.checkParameters(args);
            BigDecimal firstVariable = new BigDecimal(args[0]);
            BigDecimal secondVariable = new BigDecimal(args[1]);
            calculations.add(new SumCalculation(firstVariable, secondVariable));
            calculations.add(new DifferenceCalculation(firstVariable, secondVariable));
            calculations.add(new MultiplyCalculation(firstVariable, secondVariable));
            calculations.add(new DivisionCalculation(firstVariable, secondVariable));
        } catch (Exception ex) {
            System.out.println("Build error: " + ex.getMessage());
        }
        return calculations;
    }
}
