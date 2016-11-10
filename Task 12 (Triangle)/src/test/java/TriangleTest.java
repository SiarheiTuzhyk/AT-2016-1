package test.java;
import main.java.Triangle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.testng.Assert.*;
/**
 * Test class "Triangle."
 */
public class TriangleTest {

    ReadXML readXML;
    private final String DATAPATH = "E:\\TAT-homeworks\\Task 12 (Triangle)\\src\\test\\java\\data_provider.xml";
    private final String CONSTRUCTORPOSITIVE = "constructorPositive";
    private final String CONSTRUCTORNEGATIVE = "constructorNegative";
    private final String TRIANGLETYPE = "triangleType";
    Triangle triangle;

    @BeforeClass
    public void setUp() throws Exception{
        readXML = new ReadXML(DATAPATH);
    }

    @DataProvider(name = "positive test constructor of class")
    public Object[][] positiveRightValuesConstructor() throws Exception {
        Object[][] result = readXML.getDataFromTag(CONSTRUCTORPOSITIVE);
        return result;
    }

    @DataProvider(name = "negative test checkTriangle with wrong values")
    public Object[][] negativeWrongValuesConstructor() throws Exception {
        Object[][] result = readXML.getDataFromTag(CONSTRUCTORNEGATIVE);
        return result;
    }

    @DataProvider(name = "positive test getTypeOfTriangle")
    public Object[][] positiveRightTypeOfTriangle() throws Exception {
        Object[][] result = readXML.getDataFromTag(TRIANGLETYPE);
        return result;
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