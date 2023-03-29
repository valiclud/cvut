


package integration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import core.AddressaryException;

// TODO: Auto-generated Javadoc
/**
 * The Class SQLConnection.
 *
 * @author Ludvik Valíèek
 */
public class SQLConnection {

    /** The connection. */
    Connection connection;
    
    /** The Constant URL. */
    static final String URL = "jdbc:derby://localhost:1527/library";
    
    /** The Constant USER. */
    static final String USER = "public";
    
    /** The Constant PASSWORD. */
    static final String PASSWORD = "public";

   /**
    * Instantiates a new SQL connection.
    *
    * @throws SQLException the SQL exception
    */
   public SQLConnection() throws SQLException {
        this(URL, USER, PASSWORD);
    }

    /**
     * Instantiates a new SQL connection.
     *
     * @param url the url
     * @param user the user
     * @param password the password
     * @throws SQLException the SQL exception
     */
    public SQLConnection (String url, String user, String password) throws SQLException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        connection = DriverManager.getConnection(url, user, password);
    }

//    public DAOInterface getDAO() throws AddressaryException, SQLException {
//        return new CustomerDAOSql(connection);
//    }

    /**
 * Close.
 *
 * @throws AddressaryException the addressary exception
 */
public void close() throws AddressaryException {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new AddressaryException(ex);
        }
    }

}
