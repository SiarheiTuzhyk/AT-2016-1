import Movement.*;
/**
 * Main class of program. Entrance point to the program.
 *
 * @author Siarhei Tuzhyk
 * @version 1.2
 * @since 29.10.2016
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
        try {
            InputData inputData = new InputData();
            Route route = inputData.getCheckPoint(PATHTOFILE);
            double distance = new Distance().getDistance(route);
            System.out.println("Distance is " + distance + " kilometers.\n");
            System.out.println(getStats(new Car(), route));
            System.out.println(getStats(new Bus(), route));
            System.out.println(getStats(new Bicycle(), route));
            System.out.println(getStats(new Pedestrian(), route));
        } catch (Exception e) {
            System.out.println("Program error: " + e.getMessage());
        }
    }

    /**
     * Method for getting stats of transportation.
     *
     * @param transportation type of transportation.
     * @param route          arraylist with checkpoints.
     * @return string with stats of transportation.
     */
    private static String getStats(Move transportation, Route route) {
        return transportation.getClass().getSimpleName() +
                " spend " + transportation.howMuchTime(route) +
                " hours and cost " + transportation.howMuchPrice(route) + " USD.";
    }
}
