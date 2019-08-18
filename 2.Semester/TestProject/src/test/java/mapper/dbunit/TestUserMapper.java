package mapper.dbunit;

import entity.User;
import mapper.UserMapper;
import database.connector.DatabaseConnector;
import java.sql.Connection;
import java.io.FileInputStream;
import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.dbunit.operation.DatabaseOperation;

public class TestUserMapper
{
    private static UserMapper userMapper;
    
    private static DatabaseConnector dbc;
    private static Connection connection;
    private static IDatabaseConnection dbConnection;
    private static IDataSet xmlDataSet;
    private static QueryDataSet databaseDataSet;
    private static ITable xmlTable, databaseTable;

    @BeforeClass
    public static void beforeClass()
    {
        System.out.println("DBUnit Tests...");
        
        dbc = new DatabaseConnector();
        dbc.setDataSource(new DataSourceMysql().getDataSource());
    }
    
    @Before
    public void beforeEach()
    {
        try
        {
            connection = dbc.open();
            dbConnection = new DatabaseConnection(connection, "testdatabase");
            dbConnection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
            dbConnection.getConfig().setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new MySqlMetadataHandler());
        
            xmlDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("TestDataset.xml"));
            
            DatabaseOperation.CLEAN_INSERT.execute(dbConnection, xmlDataSet);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        userMapper = new UserMapper();
        userMapper.setDataSource(new DataSourceMysql().getDataSource());
    }
    
    @After
    public void after()
    {
        try
        {
            dbConnection.close();
            dbc.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }        
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
    
        try
        {
            databaseDataSet = new QueryDataSet(dbConnection);
            databaseDataSet.addTable("user");
            databaseTable = databaseDataSet.getTable("user");

            assertEquals(databaseTable.getValue(2, "username"), validatedUser.getUserName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}