package test.java;
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
 * Test class "inputSides".
 */
public class InputSidesTest {
    private final String DATA_PATH = "E:\\TAT-homeworks\\Task 12 (Triangle)\\src\\test\\java\\data_provider_inputSides.xml";
    private final String POSITIVE = "positive";
    private final String NEGATIVE = "negative";
    private final String FIRSTSIDE = "firstSide";
    private final String SECONDSIDE = "secondSide";
    private final String THIRDSIDE = "thirdSide";
    ArrayList<BigDecimal> sides;
    ArrayList<BigDecimal> sidesExpected;
    @DataProvider(name = "positive inputSides")
    public Object[][] positiveInputSides() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        File testDataFile = new File(DATA_PATH);
        Document document = documentBuilder.parse(testDataFile);
        NodeList nodes = document.getElementsByTagName(POSITIVE);
        Object[][] result = new Object[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attributes = nodes.item(i).getAttributes();
            result[i] = new Object[]{
                    attributes.getNamedItem(FIRSTSIDE).getNodeValue(),
                    attributes.getNamedItem(SECONDSIDE).getNodeValue(),
                    attributes.getNamedItem(THIRDSIDE).getNodeValue()
            };
        }
        return result;
    }

    @DataProvider(name = "negative inputSides")
    public Object[][] negativeInputSides() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        File testDataFile = new File(DATA_PATH);
        Document document = documentBuilder.parse(testDataFile);
        NodeList nodes = document.getElementsByTagName(NEGATIVE);
        Object[][] result = new Object[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attributes = nodes.item(i).getAttributes();
            result[i] = new Object[]{
                    attributes.getNamedItem(FIRSTSIDE).getNodeValue(),
                    attributes.getNamedItem(SECONDSIDE).getNodeValue(),
                    attributes.getNamedItem(THIRDSIDE).getNodeValue()
            };
        }
        return result;
    }

    @Test(dataProvider = "positive inputSides")
    public void positiveTestInputSides(String a, String b, String c) {
        ArrayList<BigDecimal> sides = new ArrayList<>();
        sides.add(new BigDecimal(new ScannerMock(a).next()));
        sides.add(new BigDecimal(new ScannerMock(b).next()));
        sides.add(new BigDecimal(new ScannerMock(c).next()));
        ArrayList<BigDecimal> sidesExpected = new ArrayList<>();
        sidesExpected.add(new BigDecimal(a));
        sidesExpected.add(new BigDecimal(b));
        sidesExpected.add(new BigDecimal(c));
        assertEquals(sides, sidesExpected);
    }

    @Test(dataProvider = "negative inputSides", expectedExceptions = Exception.class)
    public void negativeTestInputSides(String a, String b, String c) throws Exception {
        sides = new ArrayList<>();
        sides.add(new BigDecimal(new ScannerMock(a).next()));
        sides.add(new BigDecimal(new ScannerMock(b).next()));
        sides.add(new BigDecimal(new ScannerMock(c).next()));
        sidesExpected = new ArrayList<>();
        sidesExpected.add(new BigDecimal(a));
        sidesExpected.add(new BigDecimal(b));
        sidesExpected.add(new BigDecimal(c));
    }
}