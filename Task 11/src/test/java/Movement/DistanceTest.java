package Movement;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
/**
 * Test class "Distance".
 */
public class DistanceTest {
    Distance distance;
    ArrayList<CheckPoint> checkPoints;
    Route route;

    @Before
    public void setUp() {
        distance = new Distance();
        checkPoints = new ArrayList<CheckPoint>();
        route = new Route();
    }

    @Test
    public void positiveGetDistanceTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        route.addRoute(route, checkPoints);
        assertEquals(100, distance.getDistance(route), 0.001);
    }

    @Test
    public void positiveDistanceBetweenCheckpointTest() throws Exception {
        CheckPoint a = new CheckPoint(0, 0);
        CheckPoint b = new CheckPoint(50, 0);
        assertEquals(50, distance.distanceBetweenCheckpoint(a, b), 0.001);
    }

    @Test(expected = Exception.class)
    public void negativeGetDistanceWithPositiveInfinitiveTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(0, Double.NEGATIVE_INFINITY));
        route.addRoute(route, checkPoints);
    }

    @Test(expected = Exception.class)
    public void negativeGetDistanceWithNaNTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(0, Double.NaN));
        route.addRoute(route, checkPoints);
    }

    @Test(expected = Exception.class)
    public void negativeDistanceWithEqualsFirstAndLastCheckPoints() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(0, 0));
        route.addRoute(route, checkPoints);
    }
}