package IO.Output;

import Commands.CommandResult;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Class for write information to file.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 17.11.2016
 */
public class Writer {

    MyLogger myLogger;

    /**
     * Method for write lof-data for txt-file.
     *
     * @param results list with results about command performance.
     * @throws Exception if have problems with writing dta for txt-file.
     */
    public void writeLogToTXT(ArrayList<CommandResult> results) throws Exception {
        try {
            myLogger = new MyLogger();
            BigDecimal totalTime = BigDecimal.ZERO;
            for (CommandResult result : results) {
                myLogger.log(result.resultConverter());
                totalTime = totalTime.add(result.getRunTime());
            }
            BigDecimal averageTime = totalTime.divide(new BigDecimal(results.size())).setScale(3, BigDecimal.ROUND_HALF_UP);
            myLogger.log("Total tests: " + results.size());
            int passedTests = countPassesTests(results);
            int failedTests = results.size() - passedTests;
            myLogger.log("Passed/Failed: " + passedTests + "/" + failedTests);
            myLogger.log("Total time: " + totalTime + "s");
            myLogger.log("Average time: " + averageTime + "s");
        } catch (Exception ex) {
            System.out.println("Write error: " + ex.getMessage());
        }
    }

    /**
     * Method for count passes tests.
     *
     * @param results list with results about command performance.
     * @return count of passes tests.
     */
    public int countPassesTests(ArrayList<CommandResult> results) {
        int count = 0;
        for (CommandResult resultInstruction : results) {
            if (resultInstruction.getResult()) {
                count++;
            }
        }
        return count;
    }
}
