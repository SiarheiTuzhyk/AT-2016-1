package test.java;
import main.java.ScannerAdapter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.testng.Assert.*;

/**
 * Test class "inputSides".
 */
public class InputSidesTest {

    @DataProvider(name = "positive inputSides")
    public Object[][] positiveInputSides(){
        return new Object[][]{
                {1,1,1},{0,0,0},{-1,-1,-1},{0.0001,0.0001,0.0001},
                {Double.MIN_VALUE,Double.MIN_VALUE,Double.MIN_VALUE},
                {Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE}
        };
    }

    @DataProvider(name = "negative inputSides")
    public Object[][] negativeInputSides(){
        return new Object[][]{
                {1f,1,1},{0,null,0},{-1,-1d,-1},{Double.POSITIVE_INFINITY,1,1},
                {Double.NEGATIVE_INFINITY,1,1},{Double.NaN,1,1}
        };
    }

    @Test(dataProvider = "positive inputSides")
    public void positiveTestInputSides(double a, double b, double c){
        ArrayList<BigDecimal> sides = new ArrayList<>();
        sides.add(new BigDecimal(a));
        sides.add(new BigDecimal(b));
        sides.add(new BigDecimal(c));
        fail();
        // TODO: 04.11.2016 positive tests for inputSides method.
    }

    @Test(dataProvider = "negative inputSides",expectedExceptions = Exception.class)
    public void negativeTestInputSides(double x) throws Exception {
        ScannerAdapter in = new ScannerMock(x);
        assertEquals(in.nextDouble(),x);
        fail();
        // TODO: 04.11.2016 negative tests for inputSides method.
    }
}