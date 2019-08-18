package roda.testdb_simple;

import java.sql.PreparedStatement;

public class _3_PreparedStatemnt {
    public static void main(String[] args) throws Exception {
        DBConnector c = new DBConnector();
//        String classname = "teacher";
        String classname = "teacher'); UPDATE `user` SET `name` = 'Idiot' WHERE `username` = 'RODA'; SELECT ('hello";
        String query = "INSERT INTO `class_member` VALUES ('RODA', ?);";
        System.out.println(query);
        
        PreparedStatement stmt = c.getConnection().prepareStatement(query);
        stmt.setString(1, classname);
        stmt.execute();
    }
}
