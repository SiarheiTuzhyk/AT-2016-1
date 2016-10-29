package Movement;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
/**
 * Test class "Pedestrian".
 */
public class PedestrianTest {
    Route route;
    ArrayList<CheckPoint> checkPoints;
    Pedestrian pedestrian;

    @Before
    public void getUp() {
        route = new Route();
        checkPoints = new ArrayList<CheckPoint>();
        pedestrian = new Pedestrian();
    }

    @Test
    public void howMuchTimeTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(50, 0));
        route.addRoute(route, checkPoints);
        assertEquals(27.273, pedestrian.howMuchTime(route), 0.001);
    }

    @Test
    public void howMuchPriceTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(50, 0));
        route.addRoute(route, checkPoints);
        assertEquals(0, pedestrian.howMuchPrice(route), 0.001);
    }

    @Test(expected = Exception.class)
    public void howMuchTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(0, 0));
        route.addRoute(route, checkPoints);
        assertEquals(5, pedestrian.howMuchPrice(route), 0.001);
    }

    @Test(expected = Exception.class)
    public void emptyRouteTest() throws Exception {
        route.addRoute(route, checkPoints);
    }

    @Test(expected = Exception.class)
    public void onlyOneCheckPointHowMuchTime() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        route.addRoute(route, checkPoints);
    }

    @Test(expected = Exception.class)
    public void equalsFirstANdLastHowMuchTime() throws Exception {
        checkPoints.add(new CheckPoint(0.1, 0.2));
        checkPoints.add(new CheckPoint(0.1, 5));
        checkPoints.add(new CheckPoint(0.1, 6));
        checkPoints.add(new CheckPoint(5, 5));
        checkPoints.add(new CheckPoint(5, 10));
        checkPoints.add(new CheckPoint(0.1, 0.2));
        route.addRoute(route, checkPoints);
    }

    @Test(expected = Exception.class)
    public void addNullCheckPointTest() throws Exception {
        checkPoints.add(null);
        route.addRoute(route, checkPoints);
    }

    @Test(expected = Exception.class)
    public void howMuchTimeWithNullCheckPointTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(null);
        checkPoints.add(new CheckPoint(10, 10));
        route.addRoute(route, checkPoints);
    }
}