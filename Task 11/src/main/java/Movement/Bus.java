package Movement;
/**
 * Class of bus. Extends Vehicle abstract class, which include Move interface.
 *
 * @author Siarhei Tuzhyk
 * @version 1.3
 * @since 29.10.2016
 */
public class Bus extends Vehicle {
    //Constant values
    private final double AVERAGESPEED = 50;
    private final double FUELCONSUMPTION = 20;
    private final double PRICELITREOFFUEL = 0.5;
    private final int PASSANGERS = 40;

    //Fields of Bus class.
    private double averageSpeed;
    private double fuelConsumption;
    private double priceLitreOfFuel;
    private int passengers;

    /**
     * Constructor of class. Appoints values to fields.
     */
    public Bus() {
        averageSpeed = AVERAGESPEED;
        fuelConsumption = FUELCONSUMPTION;
        priceLitreOfFuel = PRICELITREOFFUEL;
        passengers = PASSANGERS;
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
        double price = ((distance / 100) * fuelConsumption * priceLitreOfFuel) / passengers;
        return Math.rint(100.0 * price) / 100.0;
    }
}
