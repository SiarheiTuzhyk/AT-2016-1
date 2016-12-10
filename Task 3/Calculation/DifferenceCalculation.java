package Calculation;

import java.math.BigDecimal;

/**
 * Class of difference calculation. Implements interface of calculation.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 05.12.2016.
 */
public class DifferenceCalculation implements Calculation {
    BigDecimal firstVariable;
    BigDecimal secondVariable;
    BigDecimal result;

    /**
     * Constructor. Assign values to class fields.
     */
    public DifferenceCalculation(BigDecimal firstVariable, BigDecimal secondVariable) {
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
    }

    /**
     * Calculate subtract of two variables.
     */
    public void calculate() {
        result = firstVariable.subtract(secondVariable);
    }

    /**
     * Print result of calculation.
     */
    public void printResult() {
        System.out.println("Difference of " + firstVariable + " and " + secondVariable + " is " + result);
    }
}
