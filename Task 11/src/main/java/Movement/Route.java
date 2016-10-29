package Movement;

import java.util.ArrayList;

/**
 * Class of route, which contain arraylist with checkpoints and validate all route.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 29.10.2016
 */
public class Route {
    // Field of class.
    public ArrayList<CheckPoint> route;

    /**
     * Constructor of class, where create arraylist for route.
     */
    public Route() {
        route = new ArrayList<CheckPoint>();
    }

    /**
     * Method for getting size of route.
     *
     * @return size of route.
     */
    public int getSizeRoute() {
        return route.size();
    }

    /**
     * Methdd for getting certain checkpoint for the index.
     *
     * @param index index of checkpoint.
     * @return certain checkpoint for the index
     */
    public CheckPoint getCheckPointByIndex(int index) {
        return route.get(index);
    }

    /**
     * Method for adding new checkpoint for the route.
     *
     * @param checkpoint checkpoint for adding.
     */
    public void addNewCheckPoint(CheckPoint checkpoint) {
        route.add(checkpoint);
    }

    /**
     * Method for adding route and him validation.
     *
     * @param route       route for adding checkpoints
     * @param checkPoints checkpoint for adding to route.
     * @throws Exception if route does not satisfy the conditions.
     */
    public void addRoute(Route route, ArrayList<CheckPoint> checkPoints) throws Exception {
        for (CheckPoint checkpoint : checkPoints) {
            route.addNewCheckPoint(checkpoint);
        }
        validateRoute(route);
    }

    /**
     * Method for validation checkpoints.
     *
     * @param route checkpoints of route.
     * @throws Exception if route does not satisfy the conditions.
     */
    public void validateRoute(Route route) throws Exception {
        int sizeRoute = route.getSizeRoute();
        // Empty file.
        if (sizeRoute == 0) {
            throw new Exception("Not input coordinates.");
        }
        // Only one checkpoint
        if (sizeRoute == 1) {
            throw new Exception("Pathway cant't contain only one checkpoint.");
        }
        // First and last checkpoint are equals.
        CheckPoint firstCheckPoint = route.getCheckPointByIndex(0);
        CheckPoint lastCheckPoint = route.getCheckPointByIndex(sizeRoute - 1);
        if (firstCheckPoint.getFirstCoordinate() == lastCheckPoint.getFirstCoordinate()
                && firstCheckPoint.getSecondCoordinate() == lastCheckPoint.getSecondCoordinate()) {
            throw new Exception("First and last checkpoints are equals!");
        }
    }
}
