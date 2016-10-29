import Movement.CheckPoint;
import Movement.Route;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for getting and validating data from file.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 28.10.2016
 */
public class InputData {

    /**
     * Method for getting data from file.
     *
     * @param pathToFile path to file, from which getting checkpoints.
     * @return route with checkpoints, which contain in data file.
     */
    public Route getCheckPoint(String pathToFile) throws Exception {
        ArrayList<CheckPoint> checkPoints = new ArrayList<CheckPoint>();
        Route route = new Route();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(pathToFile)));
            String bufferLine;
            while ((bufferLine = bufferedReader.readLine()) != null) {
                String[] numbers = bufferLine.split(" ", 2);
                checkPoints.add(new CheckPoint(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])));
            }
            route.addRoute(route, checkPoints);
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
        return route;
    }
}
