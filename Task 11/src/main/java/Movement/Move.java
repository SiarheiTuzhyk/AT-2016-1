package Movement;

import java.util.ArrayList;

/**
 * Interface of move. All types of transport should implements this interface
 * Declare methods to find spend price and time.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 26.10.2016
 */

public interface Move {

    /**
     * Method for getting spend time for passed distance.
     *
     * @param checkPoints arraylist with checkpoints.
     */
    double howMuchTime(ArrayList<CheckPoint> checkPoints);

    /**
     * Method for getting cost for passed distance.
     *
     * @param checkPoints arraylist with checkpoints.
     */
    double howMuchPrice(ArrayList<CheckPoint> checkPoints);
}
