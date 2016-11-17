import java.util.ArrayList;

/**
 * Class for validate entered ip addresses.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 19.10.2016
 */
public class ValidateAddress {
    /**
     * Method for validate entered ip address.
     *
     * @param servers entered servers.
     * @throws Exception if have input errors with address of server.
     */
    public void validateIpAddress(ArrayList<Server> servers) throws Exception {
        String ip;
        for (Server server : servers) {
            ip = server.getAddress();
            for (int i = 0; i < 3; i++) {
                int separatorIndex = ip.indexOf(".");
                if (separatorIndex == -1) {
                    throw new Exception("Invalid IP address.");
                }
                String ipPart = ip.substring(0, separatorIndex);
                int numberInPart = Integer.parseInt(ipPart);
                if (numberInPart < 0 || numberInPart > 255) {
                    throw new Exception("Invalid IP address.");
                }
                ip = ip.substring(separatorIndex + 1);
            }
        }
    }
}
