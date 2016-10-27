package Movement;

import java.util.ArrayList;

/**
 * Class of bus. Extends Vehicle abstract class, which include Move interface.
 *
 * @author Siarhei Tuzhyk
 * @version 1.2
 * @since 27.10.2016
 */
public class Bus extends Vehicle {

    //Constant values
    private final double AVERAGESPEED = 80;
    private final double FUELCONSUMPTION = 0;
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
        Distance distanceClass = new Distance();
        double distance = distanceClass.getDistance(checkPoints);
        double price = ((distance / 100) * fuelConsumption * priceLitreOfFuel) / passengers;
        return Math.rint(100.0 * price) / 100.0;
    }
}
