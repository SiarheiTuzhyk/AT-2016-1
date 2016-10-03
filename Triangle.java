/**
 *  This program is intended to identify the type of the triangle.
 */
import java.util.Scanner;
public class Triangle {
    // Add constant observational error
    public static final double EPS = 10e-15;
    // This method required for the use of methods to input sides and identify the type of the triangle.
    public static void main(String[] args) {
        // Data input
        double[] sides = new double[3];
        sides = inputSides(sides);
        // Check the existence of a triangle
        if (isItTriangle(sides)) {
            whatTypeOfTriangle(sides); // Triangle type definition
        } else {
            System.out.println("Triangle isn't exist.\nThanks for all.");
        }
    }
    // This method is intended to enter the coefficients of quadratic equation
    public static double[] inputSides(double[] sides) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please, enter line segments of the triangle: ");
            for (int i = 0; i < sides.length; i++) {
                System.out.print((i + 1) + " segment = ");
                sides[i] = scanner.nextDouble();
                isReallyLineSegments(sides[i]);
            }
        } catch (Exception ex) {
            System.out.println("I/O error.");
        }
        return sides;
    }
    // Checking the entered number
    public static void isReallyLineSegments(double x){
        if (x <= 0) {
            System.out.print("Triangle with such line segment doesn't exist.\nThanks for all.");
            System.exit(1);
        }
    }
    // Check the existence of a triangle
    public static boolean isItTriangle(double[] sides) {
        if ((sides[0] < sides[1] + sides[2]) && (sides[1] < sides[0] + sides[2]) && (sides[2] < sides[0] + sides[1])) {
            System.out.println("Triangle exist.");
            return true;
        }
        else {
            return false;
        }
    }
    // Triangle type definition
    public static void whatTypeOfTriangle(double[] sides){
        if (sides[0] == sides[1] && sides[1] == sides[2] && sides[0] == sides[2]) {
            System.out.println("It is a equilateral triangle.");
        }
        else if (isItAIsoscelesTriangle(sides)) {
            System.out.println("It is a isosceles triangle.");
        }
        else {
            System.out.println("It is a scalene triangle.");
        }
        System.out.println("Thanks for all.");
    }
    // Checking on is isosceles type of triangle
    public static boolean isItAIsoscelesTriangle(double[] sides){
        if ((sides[0] == sides[1] && sides[1] != sides[2])
                ||(sides[1] == sides[2] && sides[0] != sides[2])
                ||(sides[2] == sides[0] && sides[0] != sides[1] )) {
            return true;
        }
        else {
            return false;
        }
    }
}
