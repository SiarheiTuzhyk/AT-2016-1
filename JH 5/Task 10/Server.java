/**
 * Server class.
 *
 * @author Siarhei Tuhzyk
 * @version 1.0
 * @since 19.10.2016
 */
public class Server {

    private String address;
    private int ping;

    /**
     * Constructor of class.
     *
     * @param address server address.
     * @param ping response of address.
     */
    public Server(String address, int ping) {
        this.address = address;
        this.ping = ping;
    }

    /**
     * Method for getting address of server.
     * @return address of server.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Mathod for getting response of server
     * @return ping response of server
     */
    public int getPing() {
        return ping;
    }
}
