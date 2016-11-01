package Movement;
import java.util.ArrayList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
/**
 * Test class "Bicycle".
 */
public class BicycleTest {
    Bicycle bicycle;

    @BeforeMethod
    public void getUp() {
        bicycle = new Bicycle();
    }

    @DataProvider(name = "positive how much time")
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
                // {expectedTime, route}
                {1.765, firstRoute}, {1.765, secondRoute},
                {24.957, thirdRoute}, {0.059, forthRoute}, {0.499, fifthRoute}
        };
    }

    @Test(dataProvider = "positive how much time")
    public void positiveTestHowMuchTime(double expectedTime, Route route) throws Exception {
        assertEquals(bicycle.howMuchTime(route), expectedTime);
    }
}