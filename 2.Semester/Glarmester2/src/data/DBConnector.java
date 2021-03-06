/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Dennis
 */
public class DBConnector {
     private Connection connection = null;

    //Constants
    private static final String IP =  "142.93.160.41";
    private static final String PORT = "3306";
    public static final String DATABASE = "Glarmester";
    private static final String USERNAME = "Dennis";
    private static final String PASSWORD = "12345";

    
    
    
//    public DBConnector() throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?allowMultiQueries=true";
//        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
//    }
    public DBConnector() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
            Properties props = new Properties();
            props.put("user", USERNAME);
            props.put("password", PASSWORD);
            props.put("allowMultiQueries", true);
            props.put("useUnicode", true);
            props.put("useJDBCCompliantTimezoneShift", true);
            props.put("useLegacyDatetimeCode", false);
            props.put("serverTimezone", "CET");
            this.connection = DriverManager.getConnection(url, props);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
            throw new SQLException(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
    
}
