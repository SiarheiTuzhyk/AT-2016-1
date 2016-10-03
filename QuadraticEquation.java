/**
 * This program is intended for search roots of a quadratic equation.
 */
import java.util.*;
public class QuadraticEquation {
    // Add constant observational error
    public static final double EPS = 10e-15;
    // This method required for the use of methods to input the coefficients of quadratic equation and finding roots.
    public static void main(String[] args) {
        // Data input
        System.out.println("Please, enter coefficients of quadratic equation:");
        double[] coefficients = new double[3];
        coefficients = inputCoefficients(coefficients);
        // Operation for searching roots of quadratic equation
        searchRootsOfQuadraticEquation(coefficients);
    }
    // This method is intended to enter the coefficients of quadratic equation
    public static double[] inputCoefficients(double[] coefficients) {
        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < coefficients.length; i++) {
                System.out.print((i + 1) + " coefficient = ");
                coefficients[i] = scanner.nextDouble();
                // Check first coefficients equal to zero
                if (i == 0) {
                    if (coefficients[i] < EPS && coefficients[i] > -EPS) {
                        System.out.print("You entered 'a' = 0.\nThanks for all.");
                        System.exit(1);
                    }
                }
            }
            // Output received quadratic equation
            System.out.println("Your quadratic equation is: (" + coefficients[0] + ")x^2 + (" + coefficients[1]
                    + ")x + (" + coefficients[2] + ")");
        } catch (Exception ex) {
            System.out.println("I/O error.\nThanks for all.");
        }
        return coefficients;
    }
    // This method search roots of quadratic equation
    public static void searchRootsOfQuadraticEquation(double[] coefficients){
        // Initialization of parameters
        double firstRoot;
        double secondRoot;
        double delta = Math.pow(coefficients[1],2) - 4*coefficients[0]*coefficients[2];
        // Search roots under certain conditions
        if(delta > EPS){
            firstRoot = (-coefficients[1]+Math.sqrt(delta))/(2*coefficients[0]);
            secondRoot = (-coefficients[1]-Math.sqrt(delta))/(2*coefficients[0]);
            System.out.println("Roots of quadratic equation:\nFirst root = " +
                    firstRoot + ";\nSecond root = " + secondRoot + ";");
        }
        else if(delta < EPS && delta > -EPS){
            firstRoot = (-coefficients[1]);
            firstRoot /= (2*coefficients[0]);
            System.out.println("Root of quadratic equation:\nRoot = " + firstRoot + ";");
        }
        else if(delta < -EPS){
            System.out.println("Quadratic equation has no real roots.");
        }
    }
}
