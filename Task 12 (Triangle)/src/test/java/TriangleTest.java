package test.java;
import main.java.Triangle;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.testng.Assert.*;
/**
 * Test class "Triangle."
 */
public class TriangleTest {

    Triangle triangle;

    @DataProvider(name = "positive test constructor of class")
    public Object[][] positiveRightValuesConstructor() {
        return new Object[][]{
                {"exist", 1.0, 1.0, 1.0}, {"exist", 4, 4, 2},
                {"exist", 3, 4, 5}, {"exist", 3, 4, 6.9}, {"exist", 0.0001, 0.0001, 0.0001},
                {"exist", 1, 1, 0.0001}, {"exist", 4.0001, 6.00001, 4.00001},
                {"exist", 3, 4.000001, 5}
        };
    }

    @DataProvider(name = "negative test checkTriangle with wrong values")
    public Object[][] forNegativeTestWrongValuesCheckTriangle() {
        return new Object[][]{
                {-1, -1, -1}, {-0.001, -0.001, -0.001}, {1E100,1E100,99E100},
                {-4.0001, -6.00001, -4.00001}, {-3, -4.000001, -5},
                {0, 0, 0}, {-1, -1, -1}, {1, 1, 0}, {1, 0, 1}, {0, 1, 1},
                {1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {-1, 0, 0}, {0, -1, 0}, {0, 0, -1},
                {0.0001, 0.0001, 0}, {0.0001, 0.0, 0.0001}, {0.0, 0.0001, 0.0001},
                {-5, 4, 4}, {4, -5, 5}, {4, 5, -5}, {1, 1, 2}, {7, 4, 3},
                {2, 6, 2}, {1, 1, 10}, {1, 1, -1}, {1, -1, 1}, {-1, 1, 1},
                {Double.POSITIVE_INFINITY, 1, 1}, {1, Double.POSITIVE_INFINITY, 1},
                {1, 1, Double.POSITIVE_INFINITY}, {Double.NEGATIVE_INFINITY, 1, 1},
                {1, Double.NEGATIVE_INFINITY, 1}, {1, 1, Double.NEGATIVE_INFINITY},
                {Double.NaN, 1, 1}, {1, Double.NaN, 1}, {1, 1, Double.NaN},
                {Double.POSITIVE_INFINITY, -1, -1}, {-1, Double.POSITIVE_INFINITY, -1},
                {-1, -1, Double.POSITIVE_INFINITY}, {Double.NEGATIVE_INFINITY, -1, -1},
                {-1, Double.NEGATIVE_INFINITY, -1}, {-1, -1, Double.NEGATIVE_INFINITY},
                {Double.NaN, 1, 1}, {1, Double.NaN, 1}, {1, 1, Double.NaN},
                {1, 0, Double.POSITIVE_INFINITY}, {1, Double.POSITIVE_INFINITY, 0},
                {Double.POSITIVE_INFINITY, 1, 0}, {1, 0, Double.NEGATIVE_INFINITY},
                {1, Double.NEGATIVE_INFINITY, 0}, {Double.NEGATIVE_INFINITY, 1, 0},
                {1, 0, Double.NaN}, {1, Double.NaN, 0}, {Double.NaN, 1, 0},
                {1, 1, null}, {1, null, 1}, {null, 1, 1}, {1, null, null}, {null, 1, null}, {null, null, 1}
        };
    }

    @DataProvider(name = "positive test getTypeOfTriangle")
    public Object[][] positiveRightTypeOfTriangle() {
        return new Object[][]{
                {"equilateral", 1, 1, 1}, {"equilateral", 0.001, 0.001, 0.001},
                {"isosceles", 2, 2, 3},{"isosceles", 2, 3, 2},{"isosceles", 3, 2, 2},
                {"isosceles", 4.0001, 6.00001, 4.0001},{"isosceles", 4.0001, 4.0001, 6.00001},
                {"isosceles", 6.00001, 4.0001, 6.00001},
                {"ordinary", 4.0001, 6.00001, 4.0}, {"ordinary", 4.0, 6.00001, 4.0001},
                {"ordinary", 3, 4, 6}, {"ordinary", 3, 4.000001, 4.00001}
        };
    }

    @Test(dataProvider = "positive test constructor of class")
    public void positiveTestRightValuesConstructor(String expected, double a, double b, double c) throws Exception {
        ArrayList<BigDecimal> sides = new ArrayList<>();
        sides.add(new BigDecimal(a));
        sides.add(new BigDecimal(b));
        sides.add(new BigDecimal(c));
        triangle = new Triangle(sides);
        assertTrue(triangle.getMessage().equals(expected));
    }

    @Test(dataProvider = "negative test checkTriangle with wrong values", expectedExceptions = Exception.class)
    public void negativeTestWrongValuesConstructor(double a, double b, double c) throws Exception {
        ArrayList<BigDecimal> sides = new ArrayList<>();
        sides.add(new BigDecimal(a));
        sides.add(new BigDecimal(b));
        sides.add(new BigDecimal(c));
        triangle = new Triangle(sides);
    }

    @Test(dataProvider = "positive test getTypeOfTriangle")
    public void positiveTestRightValuesTypeOfTriangle(String expected, double a, double b, double c) throws Exception {
        ArrayList<BigDecimal> sides = new ArrayList<>();
        sides.add(new BigDecimal(a));
        sides.add(new BigDecimal(b));
        sides.add(new BigDecimal(c));
        triangle = new Triangle(sides);
        assertTrue(triangle.getTypeOfTriangle().equals(expected));
    }

}