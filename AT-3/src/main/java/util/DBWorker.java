package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for working with database.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 28.11.2016
 */
public class DBWorker {

    /**
     * Number of table rows affected by the last query.
     */
    private Integer affected_rows = 0;

    /**
     * The value of the auto-increment primary key obtained after the addition of the new record.
     */
    private Integer last_insert_id = 0;

    /**
     * A pointer to a class instance.
     */
    private static DBWorker instance = null;

    /**
     * Method for the instance (implemented Singleton).
     *
     * @return instance.
     */
    public static DBWorker getInstance() {
        if (instance == null) {
            instance = new DBWorker();
        }
        return instance;
    }

    /**
     * Plug to an instance can not be obtained directly.
     */
    private DBWorker() {
    }

    /**
     * A request for data retrieval.
     *
     * @param query query for database.
     * @return result of query.
     */
    public ResultSet getDBData(String query) {
        Statement statement;
        Connection connect;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost/phonebook?user=root&password=120896&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("null on getDBData()!");
        return null;
    }

    /**
     * A request for data modification.
     *
     * @param query query for database.
     * @return result of query.
     */
    public Integer changeDBData(String query) {
        Statement statement;
        Connection connect;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost/phonebook?user=root&password=120896&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
            statement = connect.createStatement();
            this.affected_rows = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                this.last_insert_id = rs.getInt(1);
            }
            return this.affected_rows;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("null on changeDBData()!");
        return null;
    }

    /**
     * @return Number of table rows affected by the last query.
     */
    public Integer getAffectedRowsCount() {
        return this.affected_rows;
    }

    /**
     * @return value of the auto-increment primary key obtained after the addition of the new record.
     */
    public Integer getLastInsertId() {
        return this.last_insert_id;
    }
}

