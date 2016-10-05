package Homework_1;
import java.math.BigDecimal;
import java.util.*;
/**
 *  This class is intended to identify the type of the triangle.
 *  Entrance point to the program.
 *
 *  @author Siarhei Tuzhyk
 *  @version 1.4
 *  @since 05-10-2016
 */
public class Triangle {
    // Numbers, which we'll need to enter
    public static final int NUMBERS = 3;
    /**
     * Entrance to solution.
     * This method required for the use of methods to input sides and identify the type of the triangle.
     *
     * @param args arguments from command line.
     */
    public static void main(String[] args) {
        ArrayList <BigDecimal> sides = new ArrayList <BigDecimal>(NUMBERS);
        sides = inputSides(sides);
        // Checking the existence of line segment
        for(int i=0;i<NUMBERS;i++) {
            isReallyLineSegments(sides.get(i));
        }
        // Check the existence of a triangle
        if (isItTriangle(sides)) {
            whatTypeOfTriangle(sides);
        } else {
            System.out.println("Triangle isn't exist.\nThanks for all.");
        }
    }
    /**
     * This method is intended to enter the coefficients of quadratic equation.
     *
     * @param sides array with line segments of triangle.
     * @return arraylist with input variables.
     * */
    public static ArrayList <BigDecimal> inputSides(ArrayList <BigDecimal> sides) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please, enter line segments of the triangle: ");
            for (int i = 0; i < NUMBERS; i++) {
                System.out.print((i + 1) + " line segment = ");
                sides.add(i,new BigDecimal(scanner.next()));
            }
        } catch (NumberFormatException ex) {
            System.out.println("You didn't enter a number.");
        }
        return sides;
    }
    /**
     * Method checking the existence of line segment
     *
     * @param x input line segment
     * */
    public static void isReallyLineSegments(BigDecimal x){
        if (x.compareTo(BigDecimal.ZERO) == 0 || x.compareTo(BigDecimal.ZERO) == -1 ) {    // (x<=0)
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
    public static boolean isItTriangle(ArrayList <BigDecimal> sides) {
        if((sides.get(0)).compareTo((sides.get(1)).add(sides.get(2))) == -1     // a < b + c
                && (sides.get(1)).compareTo((sides.get(0)).add(sides.get(2))) == -1     // b < a + c
                && (sides.get(2)).compareTo((sides.get(0)).add(sides.get(1))) == -1) {     // c < a + b
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
     * @param sides arraylist with line segments of triangle.
     * */
    public static void whatTypeOfTriangle(ArrayList <BigDecimal> sides){
        if((sides.get(0)).compareTo(sides.get(1)) == 0    // (a=b)
                && (sides.get(1)).compareTo(sides.get(2)) == 0    // (b=c)
                && (sides.get(0)).compareTo(sides.get(2)) == 0) {    // (a==c)
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
    public static boolean isItAIsoscelesTriangle(ArrayList <BigDecimal> sides){
        if(((sides.get(0)).compareTo(sides.get(1)) == 0 && (sides.get(1)).compareTo(sides.get(2)) != 0)    // (a=b & a!=c)
                || ((sides.get(1)).compareTo(sides.get(2)) == 0 && (sides.get(0)).compareTo(sides.get(2)) != 0)    // (b=c & c!=a)
                || ((sides.get(2)).compareTo(sides.get(0)) == 0 && (sides.get(0)).compareTo(sides.get(1)) != 0)) {    // (c=a & a!=b)
            return true;
        }
        else {
            return false;
        }
    }
}
