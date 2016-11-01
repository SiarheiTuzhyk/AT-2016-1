package Movement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test class "CheckPoint".
 */
public class CheckPointTest {
    CheckPoint checkPoint;

    @DataProvider(name = "positive check coordinates of checkpoints")
    public Object[][] positiveCheckCoordinatesOfCheckPoints() throws Exception {
        return new Object[][]{
                {new CheckPoint(0, 0)}, {new CheckPoint(1, 0)}, {new CheckPoint(-1, 0)},
                {new CheckPoint(0, 1)}, {new CheckPoint(0, -1)},
        };
    }

    @Test(dataProvider = "positive check coordinates of checkpoints")
    public void positiveConstructorCheckPointTest(CheckPoint checkPoint) throws Exception {
        assertNotNull(checkPoint);
    }

    @DataProvider(name = "negative check coordinates of checkpoints")
    public Object[][] negativeCheckCoordinatesOfCheckPoints() throws Exception {
        return new Object[][]{
                {Double.POSITIVE_INFINITY, 0.0}, {Double.NEGATIVE_INFINITY, 0.0},
                {Double.NaN, 0.0}, {0.0, Double.POSITIVE_INFINITY},
                {0.0, Double.NEGATIVE_INFINITY}, {0.0, Double.NaN}
        };
    }

    @Test(expectedExceptions = Exception.class, dataProvider = "negative check coordinates of checkpoints")
    public void negativeConstructorCheckPointTest(double x, double y) throws Exception {
        CheckPoint checkPoint = new CheckPoint(x,y);
    }
}