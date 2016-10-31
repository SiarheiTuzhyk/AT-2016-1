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
    public void positiveHowMuchTimeTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(50, 0));
        route.addRoute(route, checkPoints);
        assertEquals(27.273, pedestrian.howMuchTime(route), 0.001);
    }

    @Test
    public void positiveHowMuchPriceTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(50, 0));
        route.addRoute(route, checkPoints);
        assertEquals(0, pedestrian.howMuchPrice(route), 0.001);
    }
}