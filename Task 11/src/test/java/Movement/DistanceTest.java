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
    public void getDistanceTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        route.addRoute(route, checkPoints);
        assertEquals(100, distance.getDistance(route), 0.001);
    }

    @Test
    public void distanceBetweenCheckpointTest() throws Exception {
        Distance distance = new Distance();
        CheckPoint a = new CheckPoint(0, 0);
        CheckPoint b = new CheckPoint(50, 0);
        assertEquals(50, distance.distanceBetweenCheckpoint(a, b), 0.001);
    }

    @Test(expected = Exception.class)
    public void emptyRouteTest() throws Exception {
        route.addRoute(route, checkPoints);
    }

    @Test(expected = Exception.class)
    public void onlyOneCheckPointTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        route.addRoute(route, checkPoints);
    }

    @Test(expected = Exception.class)
    public void equalsFirstANdLastTest() throws Exception {
        checkPoints.add(new CheckPoint(0.1, 0.2));
        checkPoints.add(new CheckPoint(0.1, 5));
        checkPoints.add(new CheckPoint(5, 5));
        checkPoints.add(new CheckPoint(0.1, 0.2));
        route.addRoute(route, checkPoints);
    }
}