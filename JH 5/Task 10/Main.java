import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Main class of the program. Entrance point to the program.
 *
 * @author Siarhei Tuhzyk
 * @version 1.0
 * @since 19.10.2016
 */
public class Main {

    // Name of html file
    public final static String NAMEOFHTML = "servers.html";
    public static final String PREFIX = "--filename=";

    /**
     * Method selects the way to the data source, then check the input data and creates a HTML table.
     *
     * @param args command line parameters.
     */
    public static void main(String[] args) {
        String userDirectory = System.getProperty("user.dir");
        File pathOfHTML = new File(userDirectory + "\\" + NAMEOFHTML);
        ArrayList<String> servers = new ArrayList<>();
        ValidateAddress valid = new ValidateAddress();
        try {
            if (args.length > 0) {
                // If entered path to file with ip address.
                if (args[0].startsWith(PREFIX)) {
                    String pathToFileWithIP = args[0].substring(PREFIX.length());
                    File file = new File(pathToFileWithIP);
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        servers.add(line);
                    }
                    valid.validateIpAddress(servers);
                }
                // if entered ip address from command line.
                else {
                    for (int i = 0; i < args.length; i++) {
                        servers.add(args[i]);
                    }
                    valid.validateIpAddress(servers);
                }
            }
            // Create HTML table of servers.
            BuildHTML report = new BuildHTML();
            report.createHTML(pathOfHTML, servers);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}