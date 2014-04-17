package com.ibu.crud;

import java.sql.Connection;
import java.sql.SQLException;

import com.ibu.database.HelperService;

public class CRUD {
	HelperService StudentIS = new HelperService();
	public Connection dbconnection = null;
	public boolean isConnectionOpened = false;
	
	public CRUD()
	{
		if(StudentIS.getConnection("BurchAdmin","hemuli","jdbc:mysql://localhost:3306/studentis"))
		{
			dbconnection = StudentIS.dbconnection;
			isConnectionOpened = true;
			System.out.println("Opened conection");
		}
	}
	
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
		catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return updated;
	}
	
	public boolean InsertIntoFaculties(String name) //Sakib
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
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return Inserted;
		}
	
	public boolean DeleteFromFaculties(int id)         //Sakib
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
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return Deleted;
		}
	
	public boolean UpdateFaculties(int id, String name)        //Sakib
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
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return Updated;
	}
	
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
		catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return updated;
	}
	
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
	
}
