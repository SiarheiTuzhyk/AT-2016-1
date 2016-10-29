package Movement;

/**
 * Class of pedestrian. Implements Move interface.
 *
 * @author Siarhei Tuzhyk
 * @version 1.3
 * @since 29.10.2016
 */
public class Pedestrian implements Move {
    //Constant values
    private final double AVERAGESPEED = 5.5;
    private final double SPENDPRICE = 0;

    //Fields of Pedestrian class.
    private double averageSpeed;
    private double price;

    /**
     * Constructor of class. Appoints values to fields.
     */
    public Pedestrian() {
        averageSpeed = AVERAGESPEED;
        price = SPENDPRICE;
    }

    /**
     * Implements method of interface. Method for getting spend time for passed distance.
     *
     * @param route arraylist with checkpoints.
     * @return time for passed distance.
     */
    public double howMuchTime(Route route) {
        double time = 0;
        Distance distanceClass = new Distance();
        for (int i = 1; i < route.getSizeRoute(); i++) {
            time += (distanceClass.distanceBetweenCheckpoint(route.getCheckPointByIndex(i - 1),
                    route.getCheckPointByIndex(i))) / averageSpeed;
        }
        return Math.rint(1000.0 * time) / 1000.0;
    }

    /**
     * Implements method of interface. Method for getting cost for passed distance.
     *
     * @param route arraylist with checkpoints.
     * @return cost for passed distance.
     */
    public double howMuchPrice(Route route) {
        return price;
    }
}
