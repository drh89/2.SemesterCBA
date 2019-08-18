package mapper.mockito;

import entity.User;
import mapper.UserMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

public class TestUserMapper
{
    private static UserMapper userMapper;
    
    private static ResultSet resultSet;
    
    @BeforeClass
    public static void beforeClass()
    {   
        System.out.println("Mockito Tests...");
        
        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        
        try
        {
            when(dataSource.getConnection()).thenReturn(connection);
            when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
            when(connection.prepareStatement(anyString(), anyInt())).thenReturn(preparedStatement);
            when(preparedStatement.executeQuery()).thenReturn(resultSet);
            when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        userMapper = new UserMapper();        
        userMapper.setDataSource(dataSource);
    }

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetUsers()
    {
        System.out.println("testGetUsers...");
        
        try
        {
            when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        List<User> users = userMapper.getUsers();
                
        assertEquals(users.size(), 2);
    }
            
    @Test
    public void testRegisterValidateUser()
    {
        System.out.println("testRegisterValidateUser...");
        
        try
        {
            when(resultSet.next()).thenReturn(true);
            when(resultSet.getInt("id")).thenReturn(3); 
            when(resultSet.getBoolean("admin")).thenReturn(true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        User user = new User(3, "SuperUser", "1234", true);
        
        userMapper.registerUser(user);
        
        User validatedUser = userMapper.validateUser("SuperUser", "1234");
                
        assertEquals("SuperUser", validatedUser.getUserName());
        assertEquals("1234", validatedUser.getPassword());
        assertEquals(true, validatedUser.isAdmin());
    }
}