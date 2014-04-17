package com.ibu.crud;

import java.sql.Connection;
import java.sql.SQLException;

import com.ibu.database.HelperService;
import com.mysql.jdbc.PreparedStatement;

public class CRUD {
	HelperService StudentIS = new HelperService();
	public Connection dbconnection = null;
	public boolean isConnectionOpened = false;
	
	public CRUD()
	{
	
		if(StudentIS.getConnection("said","1234","jdbc:mysql://localhost:3306/studentis"))
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
	
	
}
