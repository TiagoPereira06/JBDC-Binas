package pt.isel.adeetc.si1.datalayer.common.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import pt.isel.adeetc.si1.datalayer.common.ConnectionFactory;

public class SQLServerConnectionFactory extends ConnectionFactory {

	private static SQLServerConnectionFactory connFactory=null;
	
	public static ConnectionFactory getInstance(){
		if( connFactory==null){
			connFactory = new SQLServerConnectionFactory();
		}
		return connFactory;
	}
	
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		/* Private methods */

		Connection conn;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// get a connection to DB
		conn = DriverManager.getConnection(GetConnectionString());
		conn.setAutoCommit(false);
		
		return conn;
	}

}
