import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Class for creating HTML table of files from our directory.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 18.10.2016
 */
public class BuildHTML {

    private final long KILOBYTESIZE = 1024;

    // Colors of rows.
    private final String HEAD_COLOR = "#cecfce";
    private final String FIRSTCOLOR = "#efefef";
    private final String SECONDCOLOR = "#f7f7f7";

    // HTML code of header.
    private final String HEADER = "<head>\n" +
            "  <meta charset=\"utf-8\">\n" +
            "  <title>Catalog of our directory!</title>\n" +
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
            "      <th width = \"120\">ИМЯ</th>\n" +
            "      <th width = \"120\">ТИП</th>\n" +
            "      <th width = \"120\">ДАТА СОЗДАНИЯ</th>\n" +
            "      <th width = \"120\">РАЗМЕР (в Kb)</th>\n" +
            "   </tr>\n";

    /**
     * Method for creating HTML table of our files from directory.
     *
     * @param nameHTML name of HTML file.
     * @param allFiles arraylist which contain all files from out directory.
     */
    public void createHTML(File nameHTML, ArrayList<File> allFiles) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameHTML));
            // Write components to HTML table.
            bufferedWriter.write(HEADER);
            bufferedWriter.write(HEAD_OF_TABLE);
            bufferedWriter.write(addBodyToHTML(allFiles));
            bufferedWriter.write(FOOTER);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Method to add rows to the HTML table file.
     *
     * @param allFiles files in our directory.
     * @return body code, which consist each file row.
     * @throws IOException errors with file reading rights.
     */
    private String addBodyToHTML(ArrayList<File> allFiles) throws IOException {
        String body = "";
        int indexColor = 1;
        String color;
        String type = "";
        long sizeOfFile = 0;
        for (File file : allFiles) {
            if (file.isFile()) {
                type = "FILE";
                sizeOfFile = file.length();
            }
            if (file.isDirectory()) {
                type = "DIR";
                sizeOfFile = getSizeOfFolder(file);
            }
            if (indexColor % 2 == 0) {
                color = SECONDCOLOR;
            } else {
                color = FIRSTCOLOR;
            }
            body += lineOfTable(color, file.getName(), type, creationDataOFFile(file), sizeOfFilesToKilobytes(sizeOfFile));
            indexColor++;
        }
        return body;
    }

    /**
     * Method for add line code to body of HTML table.
     *
     * @param color color line.
     * @param name  name of file.
     * @param type  type of file.
     * @param data  creation data of file.
     * @param size  size of file.
     * @return line HTML code to table body.
     */
    private String lineOfTable(String color, String name, String type, String data, long size) {
        String line = "  <tr valign = \"top\"bgcolor =\"" + color + "\" align = center height = \"20\"> \n" +
                "      <th width = \"120\">" + name + "</th>\n" +
                "      <th width = \"120\">" + type + "</th>\n" +
                "      <th width = \"120\">" + data + "</th>\n" +
                "      <th width = \"120\">" + size + "</th>\n" +
                "   </tr>\n";
        return line;
    }

    /**
     * Method for getting and converting date.
     *
     * @param file file from our directory.
     * @return creation date of file.
     * @throws IOException errors with file reading rights.
     */
    private String creationDataOFFile(File file) throws IOException {

        Path p = file.toPath();
        BasicFileAttributes attributes = Files.readAttributes(p, BasicFileAttributes.class);
        FileTime date = attributes.creationTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return simpleDateFormat.format(date.toMillis());
    }

    /**
     * Method for getting size of folder, which located in our directory.
     *
     * @param file file of folder from our directory.
     * @return size of folder.
     */
    private long getSizeOfFolder(File file) {
        long size = 0;
        if (file.isDirectory()) {
            File[] folderEntries = file.listFiles();
            if (folderEntries != null) {
                for (File entry : folderEntries) {
                    if (entry.isFile()) {
                        size += entry.length();
                    }
                    if (entry.isDirectory()) {
                        // Recursive method.
                        size += getSizeOfFolder(entry);
                    }
                }
            }
        }
        return size;
    }

    /**
     * Method for exchange size of file to kilobytes.
     *
     * @param sizeOfFile size of file in bytes.
     * @return sizeOfFile size of file in kilobytes.
     */
    private long sizeOfFilesToKilobytes(long sizeOfFile) {
        if (sizeOfFile / KILOBYTESIZE < 1) {
            return 1;
        } else {
            return sizeOfFile / KILOBYTESIZE;
        }
    }
}
