import Movement.*;

import java.util.ArrayList;

/**
 * Main class of program. Entrance point to the program.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 26.10.2016
 */

public class Main {

    // Path to file with checkPoints.
    private static final String PATHTOFILE = "E:\\Coordinates.txt";

    /**
     * Method for getting checkpoints from file, calculation passed distance and output results for console.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        ArrayList<CheckPoint> checkPoints = new InputData().getCheckPoint(PATHTOFILE);
        double distance = new Distance().getDistance(checkPoints);
        System.out.println("Distance is " + distance + " kilometers.\n");

        System.out.println(getStats(new Car(), checkPoints));
        System.out.println(getStats(new Bus(), checkPoints));
        System.out.println(getStats(new Bicycle(), checkPoints));
        System.out.println(getStats(new Pedestrian(), checkPoints));
    }

    /**
     * Method for getting stats of transportation.
     *
     * @param transportation type of transportation.
     * @param checkPoints    arraylist with checkpoints.
     * @return string with stats of transportation.
     */
    private static String getStats(Move transportation, ArrayList<CheckPoint> checkPoints) {
        return transportation.getClass().getSimpleName() +
                " spend " + transportation.howMuchTime(checkPoints) +
                " hours and cost " + transportation.howMuchPrice(checkPoints) + " USD.";
    }
}
