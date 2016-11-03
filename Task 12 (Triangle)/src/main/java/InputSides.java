package main.java;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class for input sides of triangle.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 03-11-2016
 */
public class InputSides {
    /**
     * This method is intended to enter sides of triangle.
     *
     * @return arraylist with input variables.
     */
    public ArrayList<BigDecimal> inputSides(int size) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BigDecimal> sides = new ArrayList<>();
        try {
            System.out.println("Please, enter line segments of the triangle: ");
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + " line segment = ");
                sides.add(i, new BigDecimal(scanner.next()));
            }
        } catch (Exception e) {
            System.out.println("Read error: " + e.getMessage());
        }
        return sides;
    }
}
