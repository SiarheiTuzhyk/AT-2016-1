package Movement;
/**
 * Class of Checkpoint. Contain two fields: coordinates of checkpoint.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 26.10.2016
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
    public CheckPoint(double firstCoordinate, double secondCoordinate) {
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
}
