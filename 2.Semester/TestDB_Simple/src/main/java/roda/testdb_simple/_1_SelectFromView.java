package roda.testdb_simple;

import java.sql.ResultSet;

public class _1_SelectFromView {
    public static void main(String[] args) throws Exception {
        DBConnector c = new DBConnector();
        
        ResultSet rs = c.getConnection().createStatement().executeQuery("SELECT * FROM `users_and_class`;");
        while(rs.next()){
            String username = rs.getString("username");
            String name = rs.getString("name");
            String classname = rs.getString("classname");
            System.out.println(String.format("%-10s", username)+" "+String.format("%-30s", name)+" "+classname);
        }
    }
}
