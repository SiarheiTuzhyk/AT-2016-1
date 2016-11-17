package Movement;

/**
 * Class of Checkpoint. Contain two fields: coordinates of checkpoint.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 30.10.2016
 */
public class CheckPoint {
    //Fields of CheckPoint class
    private double firstCoordinate;
    private double secondCoordinate;

    /**
     * Constructor of CheckPoint class. Appoints values to fields.
     *
     * @param firstCoordinate  first coordinate of checkpoint.
     * @param secondCoordinate second coordinate of checkpoint.
     */
    public CheckPoint(double firstCoordinate, double secondCoordinate) throws Exception {
        validateCoordinates(firstCoordinate, secondCoordinate);
        this.firstCoordinate = firstCoordinate;
        this.secondCoordinate = secondCoordinate;
    }

    /**
     * Method for getting first coordinate of checkpoint.
     *
     * @return first coordinate of checkpoint.
     */
    public double getFirstCoordinate() {
        return firstCoordinate;
    }

    /**
     * Method for getting second coordinate of checkpoint.
     *
     * @return second coordinate of checkpoint.
     */
    public double getSecondCoordinate() {
        return secondCoordinate;
    }

    /**
     * Method for validation input coordinates.
     *
     * @param x first coordinate of checkpoint.
     * @param y second coordinate of checkpoint.
     * @throws Exception if coordinate doesn't exist.
     */
    private void validateCoordinates(double x, double y) throws Exception {
        if (Double.isNaN(x) || Double.isNaN(y)) {
            throw new Exception("Coordinate is NaN!");
        }
        if(Double.isInfinite(x) || Double.isInfinite(y)){
            throw new Exception("Coordinate is Infinite!");
        }
    }
}
