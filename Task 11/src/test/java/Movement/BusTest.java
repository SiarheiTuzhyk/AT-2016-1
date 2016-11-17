package Movement;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
/**
 * Test class "Bus".
 */
public class BusTest {
    Route route;
    ArrayList<CheckPoint> checkPoints;
    Bus bus;

    @Before
    public void getUp() {
        route = new Route();
        checkPoints = new ArrayList<CheckPoint>();
        bus = new Bus();
    }

    @Test
    public void positiveHowMuchTimeTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(50, 0));
        route.addRoute(route, checkPoints);
        assertEquals(3.0, bus.howMuchTime(route), 0.001);
    }

    @Test
    public void positiveHowMuchPriceTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(50, 0));
        route.addRoute(route, checkPoints);
        assertEquals(0.38, bus.howMuchPrice(route), 0.001);
    }
}