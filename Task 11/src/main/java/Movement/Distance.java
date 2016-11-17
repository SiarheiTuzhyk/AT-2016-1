package Movement;

/**
 * Class for calculation distance of pathway.
 *
 * @author Siarhei Tuzhyk
 * @version 1.2
 * @since 29.10.2016
 */
public class Distance {

    /**
     * Method for calculation passed distance.
     *
     * @param route checkpoints of route.
     * @return passed distance.
     */
    public double getDistance(Route route) {
        double distance = 0;
        for (int i = 1; i < route.getSizeRoute(); i++) {
            distance += distanceBetweenCheckpoint(route.getCheckPointByIndex(i - 1),
                    route.getCheckPointByIndex(i));
        }
        return Math.rint(1000.0 * distance) / 1000.0;
    }

    /**
     * Method for calculation distance between adjacent checkpoints.
     *
     * @param first  first checkpoint.
     * @param second second checkpoint.
     * @return distance between adjacent checkpoints.
     */
    public double distanceBetweenCheckpoint(CheckPoint first, CheckPoint second) {
        return Math.sqrt(Math.pow((second.getFirstCoordinate() - first.getFirstCoordinate()), 2)
                + Math.pow((second.getSecondCoordinate() - first.getSecondCoordinate()), 2));
    }
}
