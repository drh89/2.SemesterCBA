package mapper.h2;

import entity.User;
import mapper.UserMapper;
import database.connector.DatabaseConnector;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.assertEquals;

public class TestUserMapper
{
    private static UserMapper userMapper;
    
    private static String sqlStatements = "";
    
    @BeforeClass
    public static void beforeClass()
    {
        System.out.println("H2 Tests...");
        
        BufferedReader sqlScript;
        try
        {
            sqlScript = new BufferedReader(new InputStreamReader(new FileInputStream("TestDatabase_H2.sql"), "UTF-8"));
            
            String sqlStatement;
            while ((sqlStatement = sqlScript.readLine()) != null)
            {
                sqlStatements += sqlStatement;
            }
        
            DatabaseConnector dbc = new DatabaseConnector();
            dbc.setDataSource(new DataSourceH2().getDataSource());
            dbc.open();
            dbc.preparedStatement(sqlStatements).executeUpdate();
            dbc.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        userMapper = new UserMapper();        
        userMapper.setDataSource(new DataSourceH2().getDataSource());
    }
    
    @Test
    public void testGetUsers()
    {
        System.out.println("testGetUsers...");
        
        List<User> users = userMapper.getUsers();
                
        assertEquals(users.size(), 2);
    }
            
    @Test
    public void testRegisterValidateUser()
    {
        System.out.println("testRegisterValidateUser...");
        
        User user = new User("SuperUser", "1234", true);
        userMapper.registerUser(user);
        
        User validatedUser = userMapper.validateUser("SuperUser", "1234");
                
        assertEquals("SuperUser", validatedUser.getUserName());
        assertEquals("1234", validatedUser.getPassword());
        assertEquals(true, validatedUser.isAdmin());
    }
}