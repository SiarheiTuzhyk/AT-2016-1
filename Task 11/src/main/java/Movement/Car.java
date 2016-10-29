package Movement;
/**
 * Class of car. Extends Vehicle abstract class, which include Move interface.
 *
 * @author Siarhei Tuzhyk
 * @version 1.3
 * @since 29.10.2016
 */
public class Car extends Vehicle {
    //Constant values
    private final double AVERAGESPEED = 80;
    private final double FUELCONSUMPTION = 7;
    private final double PRICELITREOFFUEL = 0.5;

    //Fields of Car class.
    private double averageSpeed;
    private double fuelConsumption;
    private double priceLitreOfFuel;

    /**
     * Constructor of class. Appoints values to fields.
     */
    public Car() {
        averageSpeed = AVERAGESPEED;
        fuelConsumption = FUELCONSUMPTION;
        priceLitreOfFuel = PRICELITREOFFUEL;
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
        Distance distanceClass = new Distance();
        double distance = distanceClass.getDistance(route);
        double price = (distance / 100) * fuelConsumption * priceLitreOfFuel;
        return Math.rint(100.0 * price) / 100.0;
    }
}
