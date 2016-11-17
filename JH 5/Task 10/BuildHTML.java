import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Class for create HTML table.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 19.10.2016
 */
public class BuildHTML {
    // Row colors.
    private final String HEAD_COLOR = "#cecfce";
    private final String FIRSTCOLOR = "#efefef";
    private final String SECONDCOLOR = "#f7f7f7";
    private static final String MAXIMUMCOLOR = "FF0000";

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
     * @param servers  arraylist which contain entered ip address and response of servers.
     */
    public void createHTML(File nameHTML, ArrayList<Server> servers) {
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
     * @param servers arraylist which contain entered ip address and response of servers.
     * @return body code, which consist each ip address row.
     */
    private String addBodyToHTML(ArrayList<Server> servers) {
        String body = "";
        int indexColor = 1;
        String color;
        //Search maximum of responses.
        int max = maxPingOFServers(servers);
        for (Server server : servers) {
            if (server.getPing() == max) {
                color = MAXIMUMCOLOR;
            } else if (indexColor % 2 == 0) {
                color = SECONDCOLOR;
                indexColor++;
            } else {
                color = FIRSTCOLOR;
                indexColor++;
            }
            body += lineOfTable(color, server);
        }
        return body;
    }

    /**
     * Method for add line code to body of HTML table.
     *
     * @param color  color of line.
     * @param server server, which consist address and response.
     * @return line HTML code to table body.
     */
    private String lineOfTable(String color, Server server) {
        String line = "  <tr valign = \"top\"bgcolor =\"" + color + "\" align = center height = \"20\"> \n" +
                "      <th width = \"120\">" + server.getAddress() + "</th>\n" +
                "      <th width = \"120\">" + server.getPing() + "</th>\n" +
                "   </tr>\n";
        return line;
    }

    /**
     * Method for searching maximum response time of servers.
     *
     * @param servers arraylist with all servers.
     * @return maximum response time.
     */
    private int maxPingOFServers(ArrayList<Server> servers) {
        int max = 0;
        for (Server server : servers) {
            if (server.getPing() >= max) {
                max = server.getPing();
            }
        }
        return max;
    }
}
