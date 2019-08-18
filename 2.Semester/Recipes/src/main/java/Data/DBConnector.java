/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author sofieamalielandt
 */
public class DBConnector
{
    private Connection connection = null;

    //Constants
    private static final String IP = "142.93.160.41";
    private static final String PORT = "3306";
    public static final String DATABASE = "Recipes";
    private static final String USERNAME = "Dennis";
    private static final String PASSWORD = "12345";

    /* public DBConnector() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
        
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }*/
    public DBConnector() throws Exception
    {
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
        System.out.println("hej");
    }

    public Connection getConnection()
    {
        return this.connection;
    }
    
}