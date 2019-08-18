package mapper.h2;

import org.h2.jdbcx.JdbcDataSource;

public class DataSourceH2
{
    private JdbcDataSource dataSource = new JdbcDataSource();
    
    public DataSourceH2()
    {
        dataSource.setURL("jdbc:h2:mem:testdatabase;DB_CLOSE_DELAY=-1");
    }
    
    public JdbcDataSource getDataSource()
    {
        return dataSource;
    }
}