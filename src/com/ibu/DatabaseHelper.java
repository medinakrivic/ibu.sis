/**
 * Sqlite Student Information System Database helper for application
 * Using Java JDBC Drivers
 */
package com.ibu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author said
 *
 */

public class DatabaseHelper {
	
	private final static String Username = "InnovationCenter";
	private final static String Password = "burch";
	private final static String ConnStr = "jdbc:sqlite:ibu.university.sqlite";
	
	enum Country{BiH,Croatia,Serbia,Turkey}
	
	public static Connection GetConnection() throws SQLException
	{
		return DriverManager.getConnection(ConnStr, Username, Password);	
	}
}
