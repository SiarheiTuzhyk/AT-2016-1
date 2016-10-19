import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Class for create HTML table.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 19.10.2016
 */
public class BuildHTML {
    // Row colors.
    private final String HEAD_COLOR = "#cecfce";
    private final String FIRSTCOLOR = "#efefef";
    private final String SECONDCOLOR = "#f7f7f7";
    private static final String MAXIMUMCOLOR = "FF0000";

    //Minimum and maximum interval values
    private final int MIN = 10;
    private final int MAX = 500;

    // HTML code of header.
    private final String HEADER = "<head>\n" +
            "  <meta charset=\"utf-8\">\n" +
            "  <title>Servers!</title>\n" +
            " </head> ";

    // HTML code of footer.
    private final String FOOTER = "</tbody>\n" +
            "  </table>\n" +
            " </body>\n" +
            "</html>";

    // HTML code of table head.
    private final String HEAD_OF_TABLE = "<body>\n" +
            "  <table width=\"100%\" cellpadding=\"5\">\n" +
            "  <tr valign = \"top\"bgcolor =\"" + HEAD_COLOR + "\" align = center height = \"20\"> \n" +
            "      <th width = \"150\">Server</th>\n" +
            "      <th width = \"150\">Response, ms</th>\n" +
            "   </tr>\n";

    /**
     * Method for creating HTML table of our entered ip address of servers.
     *
     * @param nameHTML name of HTML file.
     * @param servers  arraylist which contain entered ip address of servers.
     */
    public void createHTML(File nameHTML, ArrayList<String> servers) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameHTML));
            // Write components to HTML table.
            bufferedWriter.write(HEADER);
            bufferedWriter.write(HEAD_OF_TABLE);
            bufferedWriter.write(addBodyToHTML(servers));
            bufferedWriter.write(FOOTER);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Method to add rows to the HTML table file.
     *
     * @param servers arraylist which contain entered ip address of servers.
     * @return body code, which consist each ip address row.
     */
    private String addBodyToHTML(ArrayList<String> servers) {
        String body = "";
        int indexColor = 1;
        String color;
        int indexOfServer = 0;
        // Generation servers response.
        int[] pings = pingServers(servers.size());
        //Search maximum of pings.
        int max = maxPingOFServers(pings);
        for (String server : servers) {
            if (pings[indexOfServer] == max) {
                color = MAXIMUMCOLOR;
            } else if (indexColor % 2 == 0) {
                color = SECONDCOLOR;
                indexColor++;
            } else {
                color = FIRSTCOLOR;
                indexColor++;
            }
            body += lineOfTable(color, server, pings[indexOfServer]);
            indexOfServer++;
        }
        return body;
    }

    /**
     * Method for add line code to body of HTML table.
     *
     * @param color color of line.
     * @param name  ip address of server.
     * @param ping  server response.
     * @return line HTML code to table body.
     */
    private String lineOfTable(String color, String name, int ping) {
        String line = "  <tr valign = \"top\"bgcolor =\"" + color + "\" align = center height = \"20\"> \n" +
                "      <th width = \"120\">" + name + "</th>\n" +
                "      <th width = \"120\">" + ping + "</th>\n" +
                "   </tr>\n";
        return line;
    }

    /**
     * Method for generation random number.
     *
     * @param min minimum value of interval.
     * @param max maximum value of interval.
     * @return random number, which located in our interval.
     */
    private int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    /**
     * Method for filing response time for each server.
     *
     * @param size number of servers
     * @return array with response time for each server.
     */
    private int[] pingServers(int size) {
        int[] pingServers = new int[size];
        for (int i = 0; i < pingServers.length; i++) {
            pingServers[i] = rnd(MIN, MAX);
        }
        return pingServers;
    }

    /**
     * Method for searching maximum response time of servers.
     *
     * @param pings response time of each servers.
     * @return maximum response time.
     */
    private int maxPingOFServers(int[] pings) {
        int max = 0;
        for (int ping : pings) {
            if (ping >= max) {
                max = ping;
            }
        }
        return max;
    }

}
