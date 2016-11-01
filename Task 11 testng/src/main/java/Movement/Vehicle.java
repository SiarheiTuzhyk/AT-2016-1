package Movement;

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
     * @param route arraylist with checkpoints.
     * @return time for passed distance.
     */
    public abstract double howMuchTime(Route route);

    /**
     * Method for getting cost for passed distance.
     *
     * @param route arraylist with checkpoints.
     * @return cost for passed distance.
     */
    public abstract double howMuchPrice(Route route);

}
