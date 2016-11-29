package IO.Output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Logger class. This class write information to default file.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 20.11.2016
 */
public class MyLogger {
    private static final String PATH_LOG_FILE = ".//logResultCommands.txt";
    private File logFile;

    /**
     * Constructor of MyLogger class. If log-file exist in default directory, we delete this file and create new empty.
     *
     * @throws IOException if have got problems with IO-operation.
     */
    public MyLogger() throws IOException {
        new File(PATH_LOG_FILE).delete();
        this.logFile = new File(PATH_LOG_FILE);
    }

    /**
     * Method for write message to lof-file.
     *
     * @param logMessage message to write.
     * @throws IOException if have got problems with IO-operation.
     */
    public void log(String logMessage) throws IOException {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(logMessage);
            writer.write(System.lineSeparator());
        } catch (IOException ex) {
            throw new IOException("Can not log to file. " + ex.getMessage());
        }
    }
}
