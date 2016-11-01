package Movement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
/**
 * Test class "Car".
 */
public class CarTest {
    Car car;

    @BeforeMethod
    public void getUp() {
        car = new Car();
    }

    @DataProvider(name = "positive how much time and price")
    public Object[][] positiveHowMuch() throws Exception {
        ArrayList<CheckPoint> firstGroup = new ArrayList<>();
        Route firstRoute = new Route();
        firstGroup.add(new CheckPoint(0, 0));
        firstGroup.add(new CheckPoint(10, 0));
        firstGroup.add(new CheckPoint(-10, 0));
        firstRoute.addRoute(firstRoute, firstGroup);
        ArrayList<CheckPoint> secondGroup = new ArrayList<>();
        Route secondRoute = new Route();
        secondGroup.add(new CheckPoint(0, 0));
        secondGroup.add(new CheckPoint(0, 10));
        secondGroup.add(new CheckPoint(0, -10));
        secondRoute.addRoute(secondRoute, secondGroup);
        ArrayList<CheckPoint> thirdGroup = new ArrayList<>();
        Route thirdRoute = new Route();
        thirdGroup.add(new CheckPoint(0, 0));
        thirdGroup.add(new CheckPoint(100, -100));
        thirdGroup.add(new CheckPoint(-100, 100));
        thirdRoute.addRoute(thirdRoute, thirdGroup);
        ArrayList<CheckPoint> forthGroup = new ArrayList<>();
        Route forthRoute = new Route();
        forthGroup.add(new CheckPoint(0, 0));
        forthGroup.add(new CheckPoint(0, 0));
        forthGroup.add(new CheckPoint(0, 1));
        forthRoute.addRoute(forthRoute, forthGroup);
        ArrayList<CheckPoint> fifthGroup = new ArrayList<>();
        Route fifthRoute = new Route();
        fifthGroup.add(new CheckPoint(0.0, 0.0));
        fifthGroup.add(new CheckPoint(1.0, 1.0));
        fifthGroup.add(new CheckPoint(2.0, 2.0));
        fifthGroup.add(new CheckPoint(1.0, 1.0));
        fifthGroup.add(new CheckPoint(0.0, 0.0));
        fifthGroup.add(new CheckPoint(0.0, 0.0));
        fifthGroup.add(new CheckPoint(-1.0, -1.0));
        fifthGroup.add(new CheckPoint(-2.0, -2.0));
        fifthRoute.addRoute(fifthRoute, fifthGroup);
        return new Object[][]{
                // {expectedTime, expectedPrice, route}
                {0.375, 1.05, firstRoute}, {0.375, 1.05, secondRoute},
                {5.303, 14.85, thirdRoute}, {0.012, 0.04, forthRoute}, {0.106, 0.3, fifthRoute}
        };
    }

    @Test(dataProvider = "positive how much time and price")
    public void positiveTestHowMuchTime(double expectedTime, double expectedPrice, Route route) throws Exception {
        // Parameter expectedPrice don't used in this tests.
        assertEquals(car.howMuchTime(route), expectedTime);
    }

    @Test(dataProvider = "positive how much time and price")
    public void positiveTestHowMuchPrice(double expectedTime, double expectedPrice, Route route) throws Exception {
        // Parameter expectedTime don't used in this tests.
        assertEquals(car.howMuchPrice(route), expectedPrice);
    }
}