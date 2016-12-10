package Calculation;

import java.math.BigDecimal;

/**
 * Class of multiply calculation. Implements interface of calculation.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 05.12.2016.
 */
public class MultiplyCalculation implements Calculation {
    BigDecimal firstVariable;
    BigDecimal secondVariable;
    BigDecimal result;

    /**
     * Constructor. Assign values to class fields.
     */
    public MultiplyCalculation(BigDecimal firstVariable, BigDecimal secondVariable) {
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
    }

    /**
     * Calculate multiply of two variables.
     */
    public void calculate() {
        result = firstVariable.multiply(secondVariable);
    }

    /**
     * Print result of calculation.
     */
    public void printResult() {
        System.out.println("Multiply of " + firstVariable + " and " + secondVariable + " is " + result);
    }
}
