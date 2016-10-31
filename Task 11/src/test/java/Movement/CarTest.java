package Movement;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
/**
 * Test class "Car".
 */
public class CarTest {
    Route route;
    ArrayList<CheckPoint> checkPoints;
    Car car;

    @Before
    public void getUp() {
        route = new Route();
        checkPoints = new ArrayList<CheckPoint>();
        car = new Car();
    }

    @Test
    public void positiveHowMuchTimeTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(50, 0));
        route.addRoute(route, checkPoints);
        assertEquals(1.875, car.howMuchTime(route), 0.001);
    }

    @Test
    public void positiveHowMuchPriceTest() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(50, 0));
        route.addRoute(route, checkPoints);
        assertEquals(5.25, car.howMuchPrice(route), 0.001);
    }
}