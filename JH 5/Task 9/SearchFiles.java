import java.util.ArrayList;
import java.io.File;

/**
 * Class for searching files in our directory
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 18.10.2016
 */
public class SearchFiles {

    public ArrayList<File> allFiles;

    public SearchFiles() {
        allFiles = new ArrayList<>();
    }

    /**
     * Method for searching files in our directory. After that files enroll to list of all files in this directory.
     *
     * @param directory path of our launch file.
     * @return allFiles arraylist of file from this directory.
     */
    public ArrayList<File> searchFiles(File directory) {

        // Receive files from that directory.
        File[] folderEntries = directory.listFiles();
        ArrayList<File> files = new ArrayList<>();
        ArrayList<File> folders = new ArrayList<>();
        for (File entry : folderEntries) {
            if (entry.isFile()) {
                files.add(entry);
            }
            if (entry.isDirectory()) {
                folders.add(entry);
            }
        }
        allFiles.addAll(folders);
        allFiles.addAll(files);
        return allFiles;
    }
}
