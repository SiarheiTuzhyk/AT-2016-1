package Movement;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
/**
 * Test class "Route".
 */
public class RouteTest {
    Route route;
    ArrayList<CheckPoint> checkPoints;

    @Before
    public void setUp() {
        route = new Route();
        checkPoints = new ArrayList<CheckPoint>();
    }

    @Test
    public void positiveCheckSizeOfRoute() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(1, 1));
        route.addRoute(route, checkPoints);
        assertEquals(2, route.getSizeRoute(), 0);
    }

    @Test
    public void positiveCheckGetCheckPointByIndex() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(1, 1));
        route.addRoute(route, checkPoints);
        assertEquals(0, route.getCheckPointByIndex(0).getFirstCoordinate(), 0.001);
    }


    @Test(expected = Exception.class)
    public void negativeEmptyRouteTest() throws Exception {
        route.addRoute(route, checkPoints);
    }

    @Test(expected = Exception.class)
    public void negativeOnlyOneCheckPointTest() throws Exception {
        checkPoints.add(new CheckPoint(1, 1));
        route.addRoute(route, checkPoints);
    }

    @Test(expected = Exception.class)
    public void negativeFirstAndLastCheckPointsEqualsTest() throws Exception {
        checkPoints.add(new CheckPoint(1, 1));
        checkPoints.add(new CheckPoint(1, 50));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(1, 1));
        route.addRoute(route, checkPoints);
    }

    @Test(expected = Exception.class)
    public void negativeRouteWithNullCheckPointTest() throws Exception {
        checkPoints.add(new CheckPoint(1, 1));
        checkPoints.add(null);
        checkPoints.add(new CheckPoint(50, 50));
        route.addRoute(route, checkPoints);
    }
}