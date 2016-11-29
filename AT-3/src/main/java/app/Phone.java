package app;
/**
 * Class of Phone.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 28.11.2016.
 */
public class Phone {
    /**
     * Fields of class.
     */
    private String id;
    private String ownerId;
    private String number="";

    /**
     * Dummy constructor.
     */
    public Phone() {
    }

    /**
     * Constructor of class.
     * @param id number of phone.
     * @param ownerId id number of owner.
     * @param number phone number.
     */
    public Phone(String id, String ownerId, String number) {
        this.id = id;
        this.ownerId = ownerId;
        this.number = number;
    }

    /**
     * Constructor of class.
     * @param ownerId id number of owner.
     * @param number phone number.
     */
    public Phone(String ownerId, String number) {
        this.ownerId = ownerId;
        this.number = number;
    }


    /**
     * GETTERS AND SETTERS.
     */

    public void setId(String id) {
        this.id = id;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getNumber() {
        return number;
    }

    /**
     * END OF GETTERS AND SETTERS.
     */
}
