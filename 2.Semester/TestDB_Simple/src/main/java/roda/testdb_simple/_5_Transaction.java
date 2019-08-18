package roda.testdb_simple;

import java.sql.Connection;
import java.util.Scanner;

public class _5_Transaction {
    public static void main(String[] args) throws Exception {
        DBConnector c = new DBConnector();

        Scanner scanner = new Scanner(System.in);
        Connection con = c.getConnection();
        
        con.setAutoCommit(false);
        c.getConnection().createStatement().executeUpdate("INSERT INTO `class_member` VALUES ('KOE', 'teacher')");
        c.getConnection().createStatement().executeUpdate("INSERT INTO `class_member` VALUES ('RODA', 'teacher')");
        
        System.out.println("Paused - Press [Enter] to unpause.");
        scanner.nextLine();
        
        con.commit();
        con.setAutoCommit(true);
    }
}
