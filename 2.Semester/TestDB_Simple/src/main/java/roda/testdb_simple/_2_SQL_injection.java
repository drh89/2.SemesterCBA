package roda.testdb_simple;

public class _2_SQL_injection {
    public static void main(String[] args) throws Exception {
        DBConnector c = new DBConnector();
//        String classname = "teacher";
        String classname = 
                  "teacher'); "
                + "UPDATE `user` SET `name` = 'Ronnie Dalsgaard' WHERE `username` = 'RODA'; "
                + "SELECT ('hello";
        
        String query = "INSERT INTO `class_member` VALUES ('RODA', '"+classname+"');";
        System.out.println(query);
        c.getConnection().createStatement().executeUpdate(query);
    }
}
