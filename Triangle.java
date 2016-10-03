import java.util.*;
/**
 *  This class is intended to identify the type of the triangle.
 *  Entrance point to the program.
 *
 *  @author Siarhei Tuzhyk
 *  @version 1.1
 *  @since 04-10-2016
 */
public class Triangle {
    // Add constant observational error, instead of comparing the variables with zero. Number is very close to 0.
    public static final double EPS = 10e-15;
    /**
     * Entrance to solution.
     * This method required for the use of methods to input sides and identify the type of the triangle.
     *
     * @param args arguments from command line.
     */
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
    /**
     * This method is intended to enter the coefficients of quadratic equation.
     *
     * @param sides array with line segments of triangle.
     * @return array with input variables.
     * */
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
    /**
     * Method check the entered number.
     *
     * @param x input line segment
     * */
    public static void isReallyLineSegments(double x){
        if (x <= 0) {
            System.out.print("Triangle with such line segment doesn't exist.\nThanks for all.");
            System.exit(1);
        }
    }
    /**
     * Method check the existence of a triangle.
     *
     * @param sides input line segments of the triangle
     * @return {@code true} if triangle exist
     * {@code false} otherwise
     * */
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
    /**
     * Method determines type of triangle and print it.
     *
     * @param sides array with line segments of triangle.
     * */
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
    /**
     * Method checking on is isosceles type of triangle.
     *
     * @param sides input line segments of the triangle
     * @return {@code true} if triangle is isosceles
     * {@code false} otherwise
     * */
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
