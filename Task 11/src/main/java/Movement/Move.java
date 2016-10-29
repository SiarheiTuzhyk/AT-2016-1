package Movement;

/**
 * Interface of move. All types of transport should implements this interface
 * Declare methods to find spend price and time.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 29.10.2016
 */

public interface Move {

    /**
     * Method for getting spend time for passed distance.
     *
     * @param route arraylist with checkpoints.
     */
    double howMuchTime(Route route);

    /**
     * Method for getting cost for passed distance.
     *
     * @param route arraylist with checkpoints.
     */
    double howMuchPrice(Route route);
}
