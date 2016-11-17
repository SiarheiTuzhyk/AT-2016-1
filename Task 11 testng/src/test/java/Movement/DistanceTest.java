package Movement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
/**
 * Test class "Distance".
 */
public class DistanceTest {
    Distance distance;
    ArrayList<CheckPoint> checkPoints;
    Route route;

    @BeforeMethod
    public void setUp() {
        distance = new Distance();
        checkPoints = new ArrayList<CheckPoint>();
        route = new Route();
    }

    @DataProvider(name = "check distance between checkpoints")
    public Object[][] positiveGetDistanceBetweenCheckPoints() throws Exception {
        return new Object[][]{
                {0.0, new CheckPoint(0, 0), new CheckPoint(0, 0)},
                {10.0, new CheckPoint(10, 0), new CheckPoint(0, 0)},
                {10.0, new CheckPoint(-10, 0), new CheckPoint(0, 0)},
                {10.0, new CheckPoint(0, 0), new CheckPoint(10, 0)},
                {10.0, new CheckPoint(0, 0), new CheckPoint(-10, 0)}
        };
    }

    @Test(dataProvider = "check distance between checkpoints")
    public void positiveTestGetDistanceBetweenCheckPoints(double dist, CheckPoint a, CheckPoint b) {
        assertEquals(distance.distanceBetweenCheckpoint(a, b), dist);
    }

    @DataProvider(name = "get all of distance")
    public Object[][] positiveGetDistance() throws Exception {
        ArrayList<CheckPoint> firstGroup = new ArrayList<>();
        firstGroup.add(new CheckPoint(0, 0));
        firstGroup.add(new CheckPoint(10, 0));
        firstGroup.add(new CheckPoint(-10, 0));
        ArrayList<CheckPoint> secondGroup = new ArrayList<>();
        secondGroup.add(new CheckPoint(0, 0));
        secondGroup.add(new CheckPoint(0, 10));
        secondGroup.add(new CheckPoint(0, -10));
        ArrayList<CheckPoint> thirdGroup = new ArrayList<>();
        thirdGroup.add(new CheckPoint(0, 0));
        thirdGroup.add(new CheckPoint(100, -100));
        thirdGroup.add(new CheckPoint(-100, 100));
        ArrayList<CheckPoint> forthGroup = new ArrayList<>();
        forthGroup.add(new CheckPoint(0, 0));
        forthGroup.add(new CheckPoint(0, 0));
        forthGroup.add(new CheckPoint(0, 1));
        ArrayList<CheckPoint> fifthGroup = new ArrayList<>();
        fifthGroup.add(new CheckPoint(0.0, 0.0));
        fifthGroup.add(new CheckPoint(1.0, 1.0));
        fifthGroup.add(new CheckPoint(2.0, 2.0));
        fifthGroup.add(new CheckPoint(1.0, 1.0));
        fifthGroup.add(new CheckPoint(0.0, 0.0));
        fifthGroup.add(new CheckPoint(0.0, 0.0));
        fifthGroup.add(new CheckPoint(-1.0, -1.0));
        fifthGroup.add(new CheckPoint(-2.0, -2.0));
        return new Object[][]{
                {30.0, firstGroup}, {30.0, secondGroup}, {424.264, thirdGroup},
                {1.0, forthGroup}, {8.485, fifthGroup}
        };
    }

    @Test(dataProvider = "get all of distance")
    public void positiveTestGetDistance(double expected, ArrayList<CheckPoint> checkPoints) throws Exception {
        route.addRoute(route, checkPoints);
        assertEquals(distance.getDistance(route), expected);
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeTestGetDistanceWithOneCheckpoint() throws Exception {
        CheckPoint checkPoint = new CheckPoint(0, 0);
        distance.distanceBetweenCheckpoint(checkPoint, null);
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeTestGetDistanceBetweenCheckPointsWithPositiveInfinitive() throws Exception {
        distance.distanceBetweenCheckpoint(new CheckPoint(0, 0), new CheckPoint(0, Double.NEGATIVE_INFINITY));
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeTestGetDistanceBetweenCheckPointsWithNaN() throws Exception {
        distance.distanceBetweenCheckpoint(new CheckPoint(0, 0), new CheckPoint(0, Double.NaN));
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeTestDistanceWithEqualsFirstLastCheckPoints() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(new CheckPoint(0, 0));
        route.addRoute(route, checkPoints);
        distance.getDistance(route);
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeTestDistanceWithNullCheckPoint() throws Exception {
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(50, 0));
        checkPoints.add(new CheckPoint(50, 50));
        checkPoints.add(null);
        checkPoints.add(new CheckPoint(100, 100));
        route.addRoute(route, checkPoints);
        distance.getDistance(route);
    }
}