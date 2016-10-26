package Movement;

import java.util.ArrayList;

/**
 * Class of bicycle. Implements Move interface.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 26.10.2016
 */
public class Bicycle implements Move {

    //Fields of Bicycle class.
    private double averageSpeed;
    private double price;

    /**
     * Constructor of class. Appoints values to fields.
     */
    public Bicycle() {
        averageSpeed = 20;
        price = 0;
    }

    /**
     * Implements method of interface. Method for getting spend time for passed distance.
     *
     * @param checkPoints arraylist with checkpoints.
     * @return time for passed distance.
     */
    public double howMuchTime(ArrayList<CheckPoint> checkPoints) {
        double time = 0;
        Distance distanceClass = new Distance();
        for (int i = 1; i < checkPoints.size() - 1; i++) {
            time += (distanceClass.distanceBetweenCheckpoint(checkPoints.get(i - 1), checkPoints.get(i)))/averageSpeed;
        }
        return Math.rint(1000.0 * time) / 1000.0;
    }

    /**
     * Implements method of interface. Method for getting cost for passed distance.
     *
     * @param checkPoints arraylist with checkpoints.
     * @return cost for passed distance.
     */
    public double howMuchPrice(ArrayList<CheckPoint> checkPoints) {
        return price;
    }
}