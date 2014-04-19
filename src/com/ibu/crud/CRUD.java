package com.ibu.crud;

import java.sql.Connection;
import java.sql.SQLException;

import com.ibu.database.HelperService;

public class CRUD {
	HelperService StudentIS = new HelperService(); 
	public Connection dbconnection = null;
	public boolean isConnectionOpened = false; //Check if connection to database is opened
	
	//Default constructor, gets connection from HelperService.java
	public CRUD()
	{
		if(StudentIS.getConnection())
		{
			dbconnection = StudentIS.dbconnection;
			isConnectionOpened = true;
			System.out.println("Connection is opened");
		}
	}
	
	//Second constructor, takes connection as argument
	public CRUD(Connection DatabaseConnection) throws SQLException
	{
		if (!DatabaseConnection.isClosed()){
			dbconnection = DatabaseConnection;
			isConnectionOpened = true;
		}
	}
	
	/*
	 * Table States:
	 */
	public boolean InsertIntoStates(String name)
	{
		boolean inserted = false;
		java.sql.PreparedStatement query;
		
		try
		{
			String sql = "INSERT INTO States VALUES(?,?)";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1, 0);
			query.setString(2, name);
			query.execute();
			inserted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		
		return inserted;
	}
	public boolean DeleteFromStates(int id)
	{
		boolean deleted = false;
		java.sql.PreparedStatement query;
		
		try
		{
			String sql = "DELETE FROM States WHERE StateID =?";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1,id);
			query.execute();
			deleted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		
		return deleted;
	}
	public boolean UpdateStates(int id,String name)
	{
		boolean updated = false;
		
		java.sql.PreparedStatement query;
		
		try
		{
			String sql = "UPDATE States SET Name=? WHERE StateID=?";
			query = dbconnection.prepareStatement(sql);
			query.setString(1, name);
			query.setInt(2, id);
			query.execute();
			updated = true;
		} 
		catch (SQLException e) {e.printStackTrace();}
		return updated;
	}

	/*
	 * Table Faculties:
	 */
	public boolean InsertIntoFaculties(String name)
	{
		boolean Inserted = false;
		
		java.sql.PreparedStatement query;
		
		try
		{
			String sql = "INSERT INTO Faculties VALUES (?,?)";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1, 0);
			query.setString(2, name);
			query.execute();
			Inserted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return Inserted;
		}
	public boolean DeleteFromFaculties(int id)
	{
		boolean Deleted = false;
		
		java.sql.PreparedStatement query;
		
		try
		{
			String sql = "DELETE FROM Faculties WHERE FacultyID=?";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1, id);
			query.execute();
			Deleted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return Deleted;
	}
	public boolean UpdateFaculties(int id, String name)
	{
		boolean Updated = false;
		
		java.sql.PreparedStatement query;
		
		try
		{
			String sql = "UPDATE Faculties SET Name=? WHERE FacultyID=?";
			query = dbconnection.prepareStatement(sql);
			query.setString(1,name);
			query.setInt(2, id);
			query.execute();
			Updated = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return Updated;
	}
	
	/*
	 * Table Ranks
	 */
	public boolean InsertIntoRanks(String name)
	{
		boolean inserted = false;
		java.sql.PreparedStatement query;
		
		try
		{
			String sql = "INSERT INTO Ranks VALUES(?,?)";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1, 0);
			query.setString(2, name);
			query.execute();
			inserted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return inserted;
	}
	public boolean DeleteFromRanks(int id)
	{
		boolean deleted = false;
		java.sql.PreparedStatement query;
	
		try
		{
			String sql = "DELETE FROM Ranks WHERE RankID =?";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1,id);
			query.execute();
			deleted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return deleted;
	}
	public boolean UpdateRanks(int id,String name)
	{
		boolean updated = false;
		
		java.sql.PreparedStatement query;
		
		try
		{
			String sql = "UPDATE Ranks SET Name=? WHERE RankID=?";
			query = dbconnection.prepareStatement(sql);
			query.setString(1, name);
			query.setInt(2, id);
			query.execute();
			updated = true;
		} 
		catch (SQLException e) {e.printStackTrace();}
		return updated;
	}
	
	/*
	 * TODO: Login Info
	 */
	public boolean InsertLoginInformation(int StudentID,String password)
	{
		boolean inserted = false;
		java.sql.PreparedStatement query;
		try
		{
			String sql = "INSERT INTO StudentLoginInfo VALUES(?,AES_ENCRYPT(?,'supersecretkey'))";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1, StudentID);
			query.setString(2, password);
			query.execute();
			inserted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return inserted;
	}
	
	/*
	 * Table Titles
	 */
	public boolean InsertIntoTitles(String name)
	{
		boolean inserted = false;
		java.sql.PreparedStatement query;
		try
		{
			String sql = "INSERT INTO Titles VALUES(?,?)";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1, 0);
			query.setString(2, name);
			query.execute();
			inserted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return inserted;
	}
	public boolean DeleteFromTitles(int id)
	{
		boolean deleted = false;
		java.sql.PreparedStatement query;
		try
		{
			String sql = "DELETE FROM Titles WHERE TitleID=?";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1, id);
			query.execute();
			deleted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return deleted;
	}
	public boolean UpdateTitles(int id ,String name)
	{
		boolean updated = false;
		java.sql.PreparedStatement query;
		try
		{
			String sql = "UPDATE Titles SET Name=? WHERE TitleID=?";
			query = dbconnection.prepareStatement(sql);
			query.setString(1, name);
			query.setInt(2, id);
			query.execute();
			updated = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return updated;
	}
	
	/*
	 * Table EducatorStatus
	 */
	public boolean InsertIntoEducatorStatus(String name)
	{
		boolean inserted = false;
		java.sql.PreparedStatement query;
		try
		{
			String sql = "INSERT INTO EducatorStatus VALUES(?,?)";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1, 0);
			query.setString(2, name);
			query.execute();
			inserted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return inserted;
	}
	public boolean DeleteFromEducatorStatus(int id) 
	{
		boolean deleted = false;
		java.sql.PreparedStatement query;
		try
		{
			String sql = "DELETE FROM EducatorStatus WHERE EducatorStatusID=?";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1, id);
			query.execute();
			deleted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return deleted;
	}
	public boolean UpdateEducatorStatus(int id ,String name)
	{
		boolean updated = false;
		java.sql.PreparedStatement query;
		try
		{
			String sql = "UPDATE EducatorStatus SET Name=? WHERE EducatorStatusID=?";
			query = dbconnection.prepareStatement(sql);
			query.setString(1, name);
			query.setInt(2, id);
			query.execute();
			updated = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return updated;
	}
	
	/*
	 * Table Statuses
	 */
	public boolean InsertIntoStatuses(String name)
	{
		boolean inserted = false;
		java.sql.PreparedStatement query;
		try
		{
			String sql = "INSERT INTO Statuses VALUES(?,?)";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1, 0);
			query.setString(2, name);
			query.execute();
			inserted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return inserted;
	}
	public boolean DeleteFromStatuses(int id)
	{
		boolean deleted = false;
		java.sql.PreparedStatement query;
		try
		{
			String sql = "DELETE FROM Statuses WHERE StatusID=?";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1, id);
			query.execute();
			deleted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return deleted;
	}
	public boolean UpdateStatuses(int id ,String name)
	{
		boolean updated = false;
		java.sql.PreparedStatement query;
		try
		{
			String sql = "UPDATE Statuses SET Name=? WHERE StatusID=?";
			query = dbconnection.prepareStatement(sql);
			query.setString(1, name);
			query.setInt(2, id);
			query.execute();
			updated = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return updated;
	}
	
	/*
	 * Table Departments
	 */
	public boolean InsertIntoDepartments(String name)
	{
		boolean inserted = false;
		java.sql.PreparedStatement query;
		try
		{
			String sql = "INSERT INTO Departments VALUES(?,?)";
			query = dbconnection.prepareStatement(sql);
			query.setInt(1, 0);
			query.setString(2, name);
			query.execute();
			inserted = true;
		}
		catch (SQLException e) {e.printStackTrace();}
		return inserted;
	}
	public boolean DeleteFromDepartments(int id)
	{  boolean updated = false;
	   java.sql.PreparedStatement query;
	   try
	   { String sql ="DELETE FROM Departments WHERE DepartmentsID = ?";
		 query = dbconnection.prepareStatement(sql);
		 query.setInt(1, id);
		 query.execute();
		 updated = true;
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	   return updated;
	}
	public boolean UpadateDepartments(int id,String name)
	{   boolean updated = false ;
	    java.sql.PreparedStatement query;
	    
	    try
	    { String sql ="UPDATE Departments SET name = ? WHERE DepartmentsID = ?";
	      query = dbconnection.prepareStatement(sql);
	      query.setString(1, name);
	      query.setInt ( 2, 0);
	      query.execute();
	      updated = true;
	  
	    }
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	    return updated;
	}
   
	/*
	 * Table WayOfStudy
	 */
	public boolean InsertIntoWayOfStudy(String name)
	{ boolean inserted = false;
	  java.sql.PreparedStatement query;
	  
	  try{
		  String sql = "INSERT INTO WayOfStudy VALUES(?,?)";
		  query = dbconnection.prepareStatement(sql);
		  query.setInt(1, 0);
		  query.setString(2, name);
		  query.execute();
		  inserted = true;
	  }
	  catch (SQLException e)
	  {e.printStackTrace();}
	  return inserted ; 
	}
	public boolean DeleteFromWayOfStudy(int id)
	{  boolean updated = false;
	   java.sql.PreparedStatement query;
	   try
	   { String sql ="DELETE FROM WayOfStudy WHERE WayOfStudyID = ?";
		 query = dbconnection.prepareStatement(sql);
		 query.setInt(1, id);
		 query.execute();
		 updated = true;
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	   return updated;
	}
	public boolean UpadateWayOfStudy(int id,String name)
	{   boolean updated = false ;
	    java.sql.PreparedStatement query;
	    
	    try
	    { String sql ="UPDATE WayOfStuding SET name = ? WHERE WayOfStudyID = ?";
	      query = dbconnection.prepareStatement(sql);
	      query.setString(1, name);
	      query.setInt ( 2, 0);
	      query.execute();
	      updated = true;
	  
	    }
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	    return updated;
	}
}
