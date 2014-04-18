package com.ibu.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperService extends Config {
	public Connection dbconnection = null;
	
	public boolean getConnection()
	{
		boolean isConnected = false;
		final String ConnectionString = "jdbc:mysql://"+ Config.dbhost + ":" + Config.dbport + "/" + Config.dbname;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Error[JDBC Driver not found]");
			e.printStackTrace();
		}
		 
		try {
			dbconnection = DriverManager
			.getConnection(ConnectionString,Config.dbuser,Config.dbpass);
			isConnected = true;
	 
		} catch (SQLException e) {
			System.err.println("Eror[Connection Failed] Stack trace:");
			e.printStackTrace();
		}
		
		return isConnected;
	}
}
