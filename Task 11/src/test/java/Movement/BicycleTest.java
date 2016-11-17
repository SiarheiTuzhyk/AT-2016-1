package Movement;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
/**
 * Test class "Bicycle".
 */
public class BicycleTest {
    Route route;
    ArrayList<CheckPoint> checkPoints;
    Bicycle bicycle;

    @Before
    public void getUp() {
        route = new Route();
        checkPoints = new ArrayList<CheckPoint>();
        bicycle = new Bicycle();
    }

    @Test
    public void positiveHowMuchTimeTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(50, 0));
        route.addRoute(route, checkPoints);
        assertEquals(8.824, bicycle.howMuchTime(route), 0.001);
    }

    @Test
    public void positiveHowMuchPriceTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(50, 0));
        route.addRoute(route, checkPoints);
        assertEquals(0, bicycle.howMuchPrice(route), 0.001);
    }
}