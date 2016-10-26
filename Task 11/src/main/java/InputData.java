import Movement.CheckPoint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Class for getting and validating data from file.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 26.10.2016
 */
public class InputData {

    /**
     * Method for getting data from file.
     *
     * @param pathToFile path to file, from which getting checkpoints.
     * @return arraylist with checkpoints, which contain in data file.
     */
    public ArrayList<CheckPoint> getCheckPoint(String pathToFile) {
        ArrayList<CheckPoint> checkPoints = new ArrayList<CheckPoint>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(pathToFile)));
            String bufferLine;
            while ((bufferLine = bufferedReader.readLine()) != null) {
                String[] numbers = bufferLine.split(" ", 2);
                checkPoints.add(new CheckPoint(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])));
            }
            validateInputData(checkPoints);
        } catch (Exception e) {
            System.out.println("Read error: " + e.getMessage());
            System.exit(1);
        }
        return checkPoints;
    }

    /**
     * Method for validation checkpoints.
     *
     * @param checkPoints checkpoints from data file.
     * @throws Exception if have input errors with checkpoints.
     */
    public void validateInputData(ArrayList<CheckPoint> checkPoints) throws Exception {
        // Empty file.
        if (checkPoints.size() == 0) {
            throw new Exception("Not input coordinates.");
        }
        // Only one checkpoint.
        if (checkPoints.size() == 1) {
            throw new Exception("Pathway cant't contain only one checkpoint.");
        }
        // Coordinates less, than zero.
        for (CheckPoint checkPoint : checkPoints) {
            if (checkPoint.getFirstCoordinate() < 0 || checkPoint.getSecondCoordinate() < 0) {
                throw new Exception("Input coordinates less, than zero!");
            }
        }
        // First and last checkpoint are equals.
        CheckPoint firstCheckPoint = checkPoints.get(0);
        CheckPoint lastCheckPoint = checkPoints.get(checkPoints.size() - 1);
        if (firstCheckPoint.getFirstCoordinate() == lastCheckPoint.getFirstCoordinate()
                && firstCheckPoint.getSecondCoordinate() == lastCheckPoint.getSecondCoordinate()) {
            throw new Exception("First and last checkpoints are equals!");
        }
    }
}
