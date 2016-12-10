package Calculation;

import java.math.BigDecimal;

/**
 * Class of sum calculation. Implements interface of calculation.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 05.12.2016.
 */
public class SumCalculation implements Calculation {
    BigDecimal firstVariable;
    BigDecimal secondVariable;
    BigDecimal result;

    /**
     * Constructor. Assign values to class fields.
     */
    public SumCalculation(BigDecimal firstVariable, BigDecimal secondVariable) {
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
    }

    /**
     * Calculate sum of two variables.
     */
    public void calculate() {
        result = firstVariable.add(secondVariable);
    }

    /**
     * Print result of calculation.
     */
    public void printResult() {
        System.out.println("Sum of " + firstVariable + " and " + secondVariable + " is " + result);
    }
}
