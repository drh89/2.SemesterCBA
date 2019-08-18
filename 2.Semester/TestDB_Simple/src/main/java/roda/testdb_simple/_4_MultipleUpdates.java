package roda.testdb_simple;

import java.sql.Connection;

public class _4_MultipleUpdates {
    public static void main(String[] args) throws Exception {
        DBConnector c = new DBConnector();

        Connection con = c.getConnection();
        
        c.getConnection().createStatement().executeUpdate("INSERT INTO `class_member` VALUES ('KOE', 'teacher');");
        c.getConnection().createStatement().executeUpdate("INSERT INTO `class_member` VALUES ('RODA', 'teacher');");
    }
}
