package com.ibu.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperService {
	public Connection dbconnection = null;
	
	public boolean getConnection(String username,String password, String connectionstring)
	{
		boolean isConnected = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}
		 
		try {
			dbconnection = DriverManager
			.getConnection(connectionstring,username, password);
			isConnected = true;
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		
		return isConnected;
	}
}
