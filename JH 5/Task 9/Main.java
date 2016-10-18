import java.io.File;

/**
 * Main class of program. Entrance point to the program.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 18.10.2016
 */
public class Main {
    // Name of html file
    public final static String NAMEOFHTML = "catalog.html";

    /**
     * Method to get the file launch directory and for creation HTML table of files from this directory.
     *
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        // Getting directory of file.
        String userDirectory = System.getProperty("user.dir");
        File pathOfHTML = new File(userDirectory + "\\" + NAMEOFHTML);
        SearchFiles searchFiles = new SearchFiles();
        BuildHTML report = new BuildHTML();
        // Create HTML table of files from this directory.
        report.createHTML(pathOfHTML, searchFiles.searchFiles(new File(userDirectory)));
    }
}
