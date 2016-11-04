package test.java;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.testng.Assert.*;

/**
 * Test class "inputSides".
 */
public class InputSidesTest {

    ArrayList<BigDecimal> sides;
    ArrayList<BigDecimal> sidesExpected;

    @DataProvider(name = "positive inputSides")
    public Object[][] positiveInputSides() {
        return new Object[][]{
                {"1", "1", "1"}, {"0", "0", "0"}, {"-1", "-1", "-1"},
                {"0.0001", "0.0001", "0.0001"}, {"3", "4.000001", "5"},
                {"1E100", "1E100", "99E100"},{"4.0", "4.0", "2.0"},
                {"+5","1","1"},{"1","+5","1"},{"1","1","+5"},
                {"1.","1","1"},{"1","1.","1"},{"1","1","1."}

        };
    }

    @DataProvider(name = "negative inputSides")
    public Object[][] negativeInputSides() {
        return new Object[][]{
                {"1f", "1", "1"}, {"0", "null", "0"}, {"-1", "-1d", "-1"},
                {"0,9","1","1"},{"1","0,9","1"},{"1","1","0,9"},
                {"1/2","1","1"},{"1","1/2","1"},{"1","1","1/2"},
                {"1\2","\1","1"},{"1","1\2","1"},{"1","1","1\2"},
                {"o","0","1"},{"0","o","1"},{"0","1","o"},
        };
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