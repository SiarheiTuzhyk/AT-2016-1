import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Main class of the program. Entrance point to the program.
 *
 * @author Siarhei Tuhzyk
 * @version 1.1
 * @since 19.10.2016
 */
public class Main {

    //Minimum and maximum interval values
    private static final int MIN = 10;
    private static final int MAX = 500;
    // Name of html file
    private static final String NAMEOFHTML = "servers.html";
    private static final String PREFIX = "--filename=";

    /**
     * Method selects the way to the data source, then check the input data and creates a HTML table.
     *
     * @param args command line parameters.
     */
    public static void main(String[] args) {
        String userDirectory = System.getProperty("user.dir");
        File pathOfHTML = new File(userDirectory + "\\" + NAMEOFHTML);
        ArrayList<Server> servers = new ArrayList<>();
        ValidateAddress valid = new ValidateAddress();
        try {
            if (args.length > 0) {
                // If entered path to file with ip address.
                if (args[0].startsWith(PREFIX)) {
                    String pathToFileWithIP = args[0].substring(PREFIX.length());
                    File file = new File(pathToFileWithIP);
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String address;
                    while ((address = bufferedReader.readLine()) != null) {
                        servers.add(new Server(address, rnd(MIN, MAX)));
                    }
                    valid.validateIpAddress(servers);
                }
                // if entered ip address from command line.
                else {
                    for (int i = 0; i < args.length; i++) {
                        servers.add(new Server(args[i], rnd(MIN, MAX)));
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

    /**
     * Method for generation random number.
     *
     * @param min minimum value of interval.
     * @param max maximum value of interval.
     * @return random number, which located in our interval.
     */
    private static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}