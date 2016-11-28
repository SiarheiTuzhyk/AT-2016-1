package app;
import util.DBWorker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class of person. Consist data from database table "person".
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 28.11.2016
 */
public class Person {

    /**
     * Fields of class.
     */
    private String id;
    private String name;
    private String surname;
    private String middlename;
    private ArrayList<Phone> phones = new ArrayList<>();

    /**
     * Constructor to create a record of the person on the basis of data from the database.
     *
     * @param id person id from database.
     * @param name person name.
     * @param surname person surname.
     * @param middlename person middle name.
     */
    public Person(String id, String name, String surname, String middlename) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        // Get phone numbers from database.
        ResultSet db_data = DBWorker.getInstance().getDBData("SELECT * FROM `phone` WHERE `owner`=" + id);
        try {
            if (db_data != null) {
                while (db_data.next()) {
                    this.phones.add(new Phone(db_data.getString(StringConstants.ID),
                            db_data.getString(StringConstants.OWNER),
                            db_data.getString(StringConstants.NUMBER)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor to create an empty record of the person.
     */
    public Person() {
        this.id = "0";
        this.name = "";
        this.surname = "";
        this.middlename = "";
    }

    /**
     * Constructor for creating records intended to be added to the database.
     * @param name person name.
     * @param surname person surname.
     * @param middlename person middle name.
     */
    public Person(String name, String surname, String middlename) {
        this.id = "0";
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
    }

    /**
     * Validation of parts of the name. For a middle name can be passed a second paraetr == true, then allowed to empty.
     *
     * @param name_part part of name for validate.
     * @param empty_allowed for a middle name can be passed if equals true, then allowed to empty.
     * @return if part of name fit to requirements
     */
    public boolean validateFMLNamePart(String name_part, boolean empty_allowed) {
        if (empty_allowed) {
            if (!name_part.equals("")) {
                Matcher matcher = Pattern.compile("[a-zA-Zа-яА-ЯёЁ+(-|_)]{1,150}").matcher(name_part);
                return matcher.matches();
            } else {
                return true;
            }
        } else {
            Matcher matcher = Pattern.compile("[a-zA-Zа-яА-ЯёЁ+(-|_)]{1,150}").matcher(name_part);
            return matcher.matches();
        }
    }

    /**
     * SETTERS AND GETTERS.
     */
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getMiddlename() {
        if ((this.middlename != null) && (!this.middlename.equals(StringConstants.NULL))) {
            return this.middlename;
        } else {
            return "";
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    /**
     * @return ArrayList of person phones
     */
    public ArrayList<Phone> getPhones() {
        return phones;
    }

    /**
     * Method for getting phone by id number.
     * @param id id number of phone.
     * @return selected phone
     */
    public Phone getPhone(String id) {
        for (Phone phone : phones) {
            if (phone.getId().equals(id)) {
                return phone;
            }
        }
        return null;
    }

    /**
     * Method for delete phone by id number.
     * @param id id number of phone.
     */
    public void deletePhone(String id) {
        Iterator<Phone> iterator = phones.iterator();
        while (iterator.hasNext()) {
            Phone phone = iterator.next();
            if (phone.getId().equals(id)) {
                iterator.remove();
            }
        }
    }
}
