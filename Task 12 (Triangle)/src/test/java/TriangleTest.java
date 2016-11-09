package test.java;
import main.java.Triangle;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.testng.Assert.*;
/**
 * Test class "Triangle."
 */
public class TriangleTest {
    private final String DATA_PATH = "E:\\TAT-homeworks\\Task 12 (Triangle)\\src\\test\\java\\data_provider_triangle.xml";
    private final String CONSTRUCTORPOSITIVE = "constructorPositive";
    private final String CONSTRUCTORNEGATIVE = "constructorNegative";
    private final String TRIANGLETYPE = "triangleType";
    private final String EXPECTED = "expected";
    private final String FIRSTSIDE = "firstSide";
    private final String SECONDSIDE = "secondSide";
    private final String THIRDSIDE = "thirdSide";
    Triangle triangle;

    @DataProvider(name = "positive test constructor of class")
    public Object[][] positiveRightValuesConstructor() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        File testDataFile = new File(DATA_PATH);
        Document document = documentBuilder.parse(testDataFile);
        NodeList nodes = document.getElementsByTagName(CONSTRUCTORPOSITIVE);
        Object[][] result = new Object[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attributes = nodes.item(i).getAttributes();
            result[i] = new Object[]{
                    attributes.getNamedItem(EXPECTED).getNodeValue(),
                    Double.parseDouble(attributes.getNamedItem(FIRSTSIDE).getNodeValue()),
                    Double.parseDouble(attributes.getNamedItem(SECONDSIDE).getNodeValue()),
                    Double.parseDouble(attributes.getNamedItem(THIRDSIDE).getNodeValue())
            };
        }
        return result;
    }

    @DataProvider(name = "negative test checkTriangle with wrong values")
    public Object[][] negativeWrongValuesConstructor() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        File testDataFile = new File(DATA_PATH);
        Document document = documentBuilder.parse(testDataFile);
        NodeList nodes = document.getElementsByTagName(CONSTRUCTORNEGATIVE);
        Object[][] result = new Double[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attributes = nodes.item(i).getAttributes();
            result[i] = new Double[]{
                    attributes.getNamedItem(FIRSTSIDE) == null ? null
                            :Double.parseDouble(attributes.getNamedItem(FIRSTSIDE).getNodeValue()),
                    attributes.getNamedItem(SECONDSIDE) == null ? null
                            :Double.parseDouble(attributes.getNamedItem(SECONDSIDE).getNodeValue()),
                    attributes.getNamedItem(THIRDSIDE) == null ? null
                            :Double.parseDouble(attributes.getNamedItem(THIRDSIDE).getNodeValue())
            };
        }
        return result;
    }

    @DataProvider(name = "positive test getTypeOfTriangle")
    public Object[][] positiveRightTypeOfTriangle() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        File testDataFile = new File(DATA_PATH);
        Document document = documentBuilder.parse(testDataFile);
        NodeList nodes = document.getElementsByTagName(TRIANGLETYPE);
        Object[][] result = new Object[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attributes = nodes.item(i).getAttributes();
            result[i] = new Object[]{
                    attributes.getNamedItem(EXPECTED).getNodeValue(),
                    Double.parseDouble(attributes.getNamedItem(FIRSTSIDE).getNodeValue()),
                    Double.parseDouble(attributes.getNamedItem(SECONDSIDE).getNodeValue()),
                    Double.parseDouble(attributes.getNamedItem(THIRDSIDE).getNodeValue())
            };
        }
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