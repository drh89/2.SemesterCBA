package roda.testdb_simple;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author RODA
 */
public class DBConnector {
    private Connection connection = null;
	
    //Constants
    private static final String IP	 = "localhost"; //142.93.109.235";
    private static final String PORT     = "3306";
    public static final String DATABASE  = "spsys";
    private static final String USERNAME = "BigBoss"; 
    private static final String PASSWORD = "1234";	     	
	
    public DBConnector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?allowMultiQueries=true";
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return this.connection;
    }
}
