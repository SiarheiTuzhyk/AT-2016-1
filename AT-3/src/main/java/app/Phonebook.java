package app;

import util.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Class of phonebook. Include data from database and query for database.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 28.11.2016
 */
public class Phonebook {

    /**
     * Storage of people records.
     */
    private HashMap<String, Person> persons = new HashMap<String, Person>();

    /**
     * Object to work with the database.
     */
    private DBWorker db = DBWorker.getInstance();

    /**
     * A pointer to a class instance.
     */
    private static Phonebook instance = null;

    /**
     * Method for the instance (implemented Singleton).
     *
     * @return pointer to a class instance.
     */
    public static Phonebook getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new Phonebook();
        }
        return instance;
    }

    /**
     * When create an instance of a class is retrieved from the database all the records.
     */
    protected Phonebook() throws ClassNotFoundException, SQLException {
        try {
            ResultSet db_data = this.db.getDBData("SELECT * FROM `person` ORDER BY `surname` ASC");
            while (db_data.next()) {
                this.persons.put(db_data.getString(StringConstants.ID),
                        new Person(db_data.getString(StringConstants.ID),
                                db_data.getString(StringConstants.NAME),
                                db_data.getString(StringConstants.SURNAME),
                                db_data.getString(StringConstants.MIDDLENAME)));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    /**
     * Add record about person.
     *
     * @param person person for add.
     * @return <>true</> if person added without error
     * <>else</> otherwise.
     */
    public boolean addPerson(Person person) {
        String query;
        if (!person.getMiddlename().equals("")) {
            query = "INSERT INTO `person` (`name`, `surname`, `middlename`) VALUES ('"
                    + person.getName() + "', '"
                    + person.getSurname() + "', '"
                    + person.getMiddlename() + "')";
        } else {
            query = "INSERT INTO `person` (`name`, `surname`) VALUES ('"
                    + person.getName() + "', '"
                    + person.getSurname() + "')";
        }
        Integer affected_rows = this.db.changeDBData(query);
        if (affected_rows > 0) {
            person.setId(this.db.getLastInsertId().toString());
            // Добавляем запись о человеке в общий список.
            this.persons.put(person.getId(), person);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Update info about person.
     *
     * @param person updatable person.
     * @return <>true</> if person update without error
     * <>else</> otherwise.
     */
    public boolean updatePerson(Person person) {
        Integer id_filtered = Integer.parseInt(person.getId());
        String query;
        if (!person.getMiddlename().equals("")) {
            query = "UPDATE `person` SET `name` = '" + person.getName()
                    + "', `surname` = '" + person.getSurname()
                    + "', `middlename` = '" + person.getMiddlename()
                    + "' WHERE `id` = " + id_filtered;
        } else {
            query = "UPDATE `person` SET `name` = '" + person.getName()
                    + "', `surname` = '" + person.getSurname()
                    + "' WHERE `id` = " + id_filtered;
        }
        Integer affected_rows = this.db.changeDBData(query);
        if (affected_rows > 0) {
            this.persons.put(person.getId(), person);
            return true;
        } else {
            return false;
        }
    }

    // Удаление записи о человеке.

    /**
     * Delete record about person.
     *
     * @param id person id.
     * @return <>true</> if person delete without error
     * <>else</> otherwise.
     */
    public boolean deletePerson(String id) {
        if ((id != null) && (!id.equals(StringConstants.NULL))) {
            int filtered_id = Integer.parseInt(id);
            Integer affected_rows = this.db.changeDBData("DELETE FROM `person` WHERE `id`=" + filtered_id);
            if (affected_rows > 0) {
                this.persons.remove(id);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Add phone to database.
     *
     * @param phone phone to adding.
     * @return <>true</> if phone added without error
     * <>else</> otherwise.
     */
    public boolean addPhone(Phone phone) {
        String query = "INSERT INTO `phone` (`owner`, `number`) VALUES ('"
                + phone.getOwnerId() + "', '" + phone.getNumber() + "')";
        Integer affected_rows = this.db.changeDBData(query);
        // Если удаление прошло успешно...
        if (affected_rows > 0) {
            // Удаляем запись о человеке из общего списка.
            phone.setId(db.getLastInsertId().toString());
            this.persons.get(phone.getOwnerId()).getPhones().add(phone);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Update phone on database.
     *
     * @param phone phone to update.
     * @return <>true</> if phone updated without error
     * <>else</> otherwise.
     */
    public boolean updatePhone(Phone phone) {
        Integer id = Integer.parseInt(phone.getId());
        String query = "UPDATE `phone` SET `number` = '"
                + phone.getNumber() + "' WHERE `id` = " + id;
        Integer affected_rows = this.db.changeDBData(query);
        // Если обновление прошло успешно...
        // Если удаление прошло успешно...
        if (affected_rows > 0) {
            // Удаляем запись о телефоне из общего списка.
            this.persons.get(phone.getOwnerId()).getPhone(phone.getId()).setNumber(phone.getNumber());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Delete phone from database.
     *
     * @param id      phone id.
     * @param ownerId id number of owner.
     * @return <>true</> if phone deleted without error
     * <>else</> otherwise.
     */
    public boolean deletePhone(String ownerId, String id) {
        if ((id != null) && (!id.equals(StringConstants.NULL))) {
            int filtered_id = Integer.parseInt(id);
            Integer affected_rows = this.db.changeDBData("DELETE FROM `phone` WHERE `id`=" + filtered_id);
            if (affected_rows > 0) {
                // Удаляем запись о человеке из общего списка.
                this.persons.get(ownerId).deletePhone(id);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Get phone by id number.
     *
     * @param id phone id.
     * @return phone by id number.
     */
    public Phone getPhone(String id) {
        int filtered_id = Integer.parseInt(id);
        ResultSet db_data = this.db.getDBData("SELECT * FROM `phone` WHERE `id`=" + filtered_id);
        try {
            db_data.next();
            return new Phone(db_data.getString(StringConstants.ID),
                    db_data.getString(StringConstants.OWNER),
                    db_data.getString(StringConstants.NUMBER));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return All persons recordings.
     */
    public HashMap<String, Person> getContents() {
        return persons;
    }

    /**
     * @return Persond by id number.
     */
    public Person getPerson(String id) {
        return this.persons.get(id);
    }
}
