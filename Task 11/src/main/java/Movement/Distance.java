package Movement;

import Movement.CheckPoint;

import java.util.ArrayList;

/**
 * Class for calculation distance of pathway.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 26.10.2016
 */
public class Distance {

    /**
     * Method for calculation passed distance.
     *
     * @param checkPoints checkpoints from data file.
     * @return passed distance.
     */
    public double getDistance(ArrayList<CheckPoint> checkPoints) {
        double distance = 0;
        for (int i = 1; i < checkPoints.size() - 1; i++) {
            distance += distanceBetweenCheckpoint(checkPoints.get(i - 1), checkPoints.get(i));
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
