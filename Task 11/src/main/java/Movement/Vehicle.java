package Movement;

import java.util.ArrayList;

/**
 * Abstract class of vehicle transport. Class implements Move interface.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 26.10.2016
 */
public abstract class Vehicle implements Move {

    //Fields of vehicle class.
    public double averageSpeed;
    public double fuelConsumption;

    /**
     * Method for getting spend time for passed distance.
     *
     * @param checkPoints arraylist with checkpoints.
     * @return time for passed distance.
     */
    public abstract double howMuchTime(ArrayList<CheckPoint> checkPoints);

    /**
     * Method for getting cost for passed distance.
     *
     * @param checkPoints arraylist with checkpoints.
     * @return cost for passed distance.
     */
    public abstract double howMuchPrice(ArrayList<CheckPoint> checkPoints);

}
