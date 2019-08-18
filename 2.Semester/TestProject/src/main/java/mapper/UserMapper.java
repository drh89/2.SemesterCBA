package mapper;

import database.connector.DatabaseConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import entity.User;

public class UserMapper
{
    private DatabaseConnector dbc = new DatabaseConnector();

    public void setDataSource(DataSource ds)
    {
        dbc.setDataSource(ds);
    }
    
    public User registerUser(User user)
    {
        try
        {
            dbc.open();

            String sql = "insert into user (username, password, admin) values (?,?,?)";
            
            PreparedStatement preparedStatement = dbc.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, user.isAdmin());
            
            preparedStatement.executeUpdate();
            
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            
            if (resultSet.next())
            {
                user.setId(resultSet.getInt(1));
                return user;
            }

            dbc.open();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public User validateUser(String username, String password)
    {
        try
        {
            dbc.open();

            String sql = "select * from user where username = ? and password = ?";
            
            PreparedStatement preparedStatement = dbc.preparedStatement(sql);
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next())
            {
                int id = resultSet.getInt("id");
                boolean admin = resultSet.getBoolean("admin");
                
                return new User(id, username, password, admin);
            }
            
            dbc.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }

    public User getUser(int id)
    {
        try
        {
            dbc.open();

            String sql = "select * from user where id = ?";
            
            PreparedStatement preparedStatement = dbc.preparedStatement(sql);
            preparedStatement.setInt(1, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next())
            {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                boolean admin = resultSet.getBoolean("admin");
                
                return new User(id, username, password, admin);
            }
            
            dbc.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public List<User> getUsers()
    {
        List<User> users = new ArrayList();
        
        try
        {
            dbc.open();

            String sql = "select * from user";
            
            PreparedStatement preparedStatement = dbc.preparedStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                boolean admin = resultSet.getBoolean("admin");
                
                users.add(new User(id, username, password, admin));
            }
            
            dbc.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return users;
    }
}