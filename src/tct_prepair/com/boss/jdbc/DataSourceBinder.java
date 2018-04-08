package tct_prepair.com.boss.jdbc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceBinder {
	private static DataSourceBinder instance;
	private DataSource dataSource;
	static{
		instance = new DataSourceBinder();
	}
	private DataSourceBinder(){
		Context context=null;
		try{
			context = new InitialContext();
			Context envContext = (Context)context.lookup("java:/comp/env");
			dataSource=(DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException e)
		{
			System.out.println("오류");
		}
	}
	public static DataSourceBinder getInstance() {
		return instance;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	
}
