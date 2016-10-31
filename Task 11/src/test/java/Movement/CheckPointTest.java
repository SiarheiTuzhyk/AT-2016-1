package Movement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class "CheckPoint".
 */
public class CheckPointTest {
    CheckPoint checkPoint;

    @Test
    public void positiveConstructorCheckPointTest() throws Exception {
        checkPoint = new CheckPoint(20, 5);
        assertEquals(5, checkPoint.getSecondCoordinate(), 0.0001);
    }

    @Test(expected = Exception.class)
    public void negativeNaNCoordinateCheckPointTest() throws Exception {
        checkPoint = new CheckPoint(Double.NaN,0);
    }

    @Test(expected = Exception.class)
    public void negativePositiveInfinityCoordinateCheckPointTest() throws Exception {
        checkPoint = new CheckPoint(Double.POSITIVE_INFINITY,0);
    }

    @Test(expected = Exception.class)
    public void negativeNegativeInfinityCoordinateCheckPointTest() throws Exception {
        checkPoint = new CheckPoint(Double.POSITIVE_INFINITY,0);
    }
}