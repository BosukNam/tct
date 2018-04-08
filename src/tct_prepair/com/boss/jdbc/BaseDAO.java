package tct_prepair.com.boss.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

public class BaseDAO {
	public Connection getConnection() throws Exception{
		DataSource dataSource = DataSourceBinder.getInstance().getDataSource();
		try{
			return dataSource.getConnection();
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception();
		}
	}
	public void closeDBObjects(ResultSet resultSet, Statement statement, Connection connection){
		try{
			if(resultSet!=null)resultSet.close();
			if(statement!=null)statement.close();
			if(connection!=null)connection.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
