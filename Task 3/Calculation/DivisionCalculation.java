package Calculation;

import java.math.BigDecimal;

/**
 * Class of divide calculation. Implements interface of calculation.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 05.12.2016.
 */
public class DivisionCalculation implements Calculation {
    BigDecimal firstVariable;
    BigDecimal secondVariable;
    BigDecimal result;

    /**
     * Constructor. Assign values to class fields.
     */
    public DivisionCalculation(BigDecimal firstVariable, BigDecimal secondVariable) {
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
    }

    /**
     * Calculate divide of two variables.
     */
    public void calculate() {
        result = firstVariable.divide(secondVariable);
    }

    /**
     * Print result of calculation.
     */
    public void printResult() {
        System.out.println("Division of " + firstVariable + " and " + secondVariable + " is " + result);
    }
}
