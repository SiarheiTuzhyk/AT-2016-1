package Movement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
/**
 * Test class "Pedestrian".
 */
public class PedestrianTest {
    Pedestrian pedestrian;

    @BeforeMethod
    public void getUp() {
        pedestrian = new Pedestrian();
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
                {5.455, firstRoute}, {5.455, secondRoute},
                {77.139, thirdRoute}, {0.182, forthRoute}, {1.543, fifthRoute}
        };
    }

    @Test(dataProvider = "positive how much time")
    public void positiveTestHowMuchTime(double expectedTime, Route route) throws Exception {
        assertEquals(pedestrian.howMuchTime(route), expectedTime);
    }
}