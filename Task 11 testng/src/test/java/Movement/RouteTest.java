package Movement;
import java.util.ArrayList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * Test class "Route".
 */
public class RouteTest {
    Route route;
    ArrayList<CheckPoint> checkPoints;

    @BeforeMethod
    public void setUp() {
        route = new Route();
        checkPoints = new ArrayList<CheckPoint>();
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeEmptyRouteTest() throws Exception {
        route.addRoute(route, checkPoints);
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeOnlyOneCheckPointTest() throws Exception {
        checkPoints.add(new CheckPoint(1, 1));
        route.addRoute(route, checkPoints);
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeFirstAndLastCheckPointsEqualsTest() throws Exception {
        checkPoints.add(new CheckPoint(1, 1));
        checkPoints.add(new CheckPoint(1, 50));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(1, 1));
        route.addRoute(route, checkPoints);
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeRouteWithNullCheckPointTest() throws Exception {
        checkPoints.add(new CheckPoint(1, 1));
        checkPoints.add(null);
        checkPoints.add(new CheckPoint(50, 50));
        route.addRoute(route, checkPoints);
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeNaNCoordinateCheckPointTest() throws Exception {
        checkPoints.add(new CheckPoint(1, 1));
        checkPoints.add(new CheckPoint(1, 50));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(Double.NaN, 0));
    }
}