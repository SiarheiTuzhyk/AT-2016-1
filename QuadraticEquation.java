package Homework_1;
import java.math.BigDecimal;
import java.util.*;
/**
 *  This class is intended for search roots of a quadratic equation.
 *  Entrance point to the program.
 *
 *  @author Siarhei Tuzhyk
 *  @version 1.3
 *  @since 04-10-2016
 */
public class QuadraticEquation {
    // Add constant observational error, instead of comparing the variables with zero. Number is very close to 0.
    public static final int NUMBERS = 3;
    public static final BigDecimal ZERO = new BigDecimal(0);
    public static final BigDecimal TWO = new BigDecimal(2);
    public static final BigDecimal MINUS_ONE = new BigDecimal(-1);
    //public static final BigDecimal ZERO
    /**
     * Entrance to solution.
     * This method required for the use of methods to input the coefficients of quadratic equation and finding roots.
     *
     * @param args arguments from command line.
     */
    public static void main(String[] args) {
        // Data input
        System.out.println("Please, enter coefficients of quadratic equation:");
        ArrayList <BigDecimal> coefficients = new ArrayList <BigDecimal>(NUMBERS);
        // Enter the coefficients of quadratic equation.
        coefficients = inputCoefficients(coefficients);
        // Operation for searching roots of quadratic equation
        searchRootsOfQuadraticEquation(coefficients);
    }
    /**
     * This method is intended to enter the coefficients of quadratic equation.
     *
     * @param coefficients arraylist of coefficients of quadratic equation.
     * @return arraylist with input variables.
    */
    public static ArrayList <BigDecimal> inputCoefficients(ArrayList <BigDecimal> coefficients) {
        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < NUMBERS; i++) {
                System.out.print((i + 1) + " coefficient = ");
                coefficients.add(i,new BigDecimal(scanner.next()));
            }
            // Check first coefficients equal to zero
            if (coefficients.get(0).compareTo(ZERO) == 0) { // 'a' = 0
                System.out.print("You entered 'a' = 0.\nThanks for all.");
                System.exit(1);
            }
            // Output received quadratic equation
            System.out.println("Your quadratic equation is: (" + coefficients.get(0) + ")x^2 + (" + coefficients.get(1)
                    + ")x + (" + coefficients.get(2) + ")");
        } catch (NumberFormatException ex) {
            System.out.println("You didn't enter a number.");
        }
        return coefficients;
    }
    /**
     * This method search roots of quadratic equation and display result of searching.
     *
     * @param coefficients arraylist with coefficients of quadratic equation.
    */
    public static void searchRootsOfQuadraticEquation(ArrayList <BigDecimal> coefficients){
        // Calculating additional expressions
        BigDecimal delta = (coefficients.get(1).pow(2)); // b^2
        delta = delta.subtract(TWO.pow(2).multiply(coefficients.get(0).multiply(coefficients.get(2)))); // b^2 - (2^2)*a*c
        BigDecimal minusB = coefficients.get(1).multiply(MINUS_ONE); // -1*b
        BigDecimal twoMultiplyA = TWO.multiply(coefficients.get(0)); // 2*a
        // Search roots under certain conditions
        if(delta.compareTo(ZERO) == 1){ // delta > 0
            rootsWhenDeltaMoreThanZero(delta,minusB,twoMultiplyA);
        }
        else if(delta.compareTo(ZERO) == 0){ // delta = 0
            rootWhenDeltaEqualsZero(minusB,twoMultiplyA);
        }
        else if(delta.compareTo(ZERO) == -1){ // delta < 0
            System.out.println("Quadratic equation has no real roots.");
        }
    }
    /**
     * This method search roots of quadratic equation, if discriminant > 0
     *
     * @param delta discriminant of quadratic equation.
     * @param minusB expression for calculation of roots
     * @param twoMultiplyA expression for calculation of roots
     */
    public static void rootsWhenDeltaMoreThanZero(BigDecimal delta, BigDecimal minusB, BigDecimal twoMultiplyA) {
        BigDecimal delta_sqrt_plus = (minusB).add(delta.divide(delta)); // -b+sqrt(delta)
        BigDecimal delta_sqrt_substract = (minusB).subtract(delta.divide(delta)); // -b-sqrt(delta)
        BigDecimal firstRoot = delta_sqrt_plus.divide(twoMultiplyA); // -b+sqrt(delta) / 2*a
        BigDecimal secondRoot = delta_sqrt_substract.divide(twoMultiplyA); // -b-sqrt(delta) / 2*a
        System.out.println("Roots of quadratic equation:\nFirst root = " +
                firstRoot + ";\nSecond root = " + secondRoot + ";");
    }
    /**
     * This method search only one root of quadratic equation, if discriminant = 0
     *
     * @param minusB expression for calculation of roots
     * @param twoMultiplyA expression for calculation of roots
     */
    public static void rootWhenDeltaEqualsZero(BigDecimal minusB, BigDecimal twoMultiplyA) {
        BigDecimal firstRoot = minusB.divide(twoMultiplyA); // (-1*b)/(2*a)
        System.out.println("Root of quadratic equation:\nRoot = " + firstRoot + ";");
    }
}
