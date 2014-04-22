package com.ibu.crud;

import java.sql.Connection;
import java.sql.SQLException;
import com.ibu.database.HelperService;

public class CRUD {
	protected HelperService StudentIS = new HelperService(); 
	public Connection dbconnection = null;
	public boolean isConnectionOpened = false; //Check if connection to database is opened
	
	//CRUD classes
	public states States = new states();
	public faculties Faculties = new faculties();
	public ranks Ranks = new ranks();
	public titles Titles = new titles();
	public educatorstatuses EducatorStatuses = new educatorstatuses();
	public statuses Statuses = new statuses();
	public departments Departments = new departments();
	public wayofstuding WayOfStuding = new wayofstuding();
	public cities Cities = new cities();
	public educators Educators = new educators();
	
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
	public class states {
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
		public boolean UpdateName(int StateID,String Name)
	{
		boolean updated = false;
		
		java.sql.PreparedStatement query;
		
		try
		{
			String sql = "UPDATE States SET Name=? WHERE StateID=?";
			query = dbconnection.prepareStatement(sql);
			query.setString(1, Name);
			query.setInt(2, StateID);
			query.execute();
			updated = true;
		} 
		catch (SQLException e) {e.printStackTrace();}
		return updated;
	}
	}
	
	/*//////////
	 * Table Faculties:
	 */
	public class faculties{
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
		public boolean UpdateFacultyName(int FacultyID, String Name)
		{
			boolean Updated = false;
			
			java.sql.PreparedStatement query;
			
			try
			{
				String sql = "UPDATE Faculties SET Name=? WHERE FacultyID=?";
				query = dbconnection.prepareStatement(sql);
				query.setString(1,Name);
				query.setInt(2,FacultyID);
				query.execute();
				Updated = true;
			}
			catch (SQLException e) {e.printStackTrace();}
			return Updated;
		}
	}
	
	/*
	 * Table Ranks
	 */
	public class ranks{
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
		public boolean UpdateRank(int RankID,String Name)
		{
			boolean updated = false;
			
			java.sql.PreparedStatement query;
			
			try
			{
				String sql = "UPDATE Ranks SET Name=? WHERE RankID=?";
				query = dbconnection.prepareStatement(sql);
				query.setString(1, Name);
				query.setInt(2, RankID);
				query.execute();
				updated = true;
			} 
			catch (SQLException e) {e.printStackTrace();}
			return updated;
		}
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
	public class titles{
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
		public boolean UpdateTitle(int TitleID ,String Name)
		{
			boolean updated = false;
			java.sql.PreparedStatement query;
			try
			{
				String sql = "UPDATE Titles SET Name=? WHERE TitleID=?";
				query = dbconnection.prepareStatement(sql);
				query.setString(1, Name);
				query.setInt(2, TitleID);
				query.execute();
				updated = true;
			}
			catch (SQLException e) {e.printStackTrace();}
			return updated;
		}
	}
	
	/*
	 * Table EducatorStatus
	 */
	public class educatorstatuses{
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
		public boolean UpdateEducatorStatus(int EducatorStatusID ,String Name)
		{
			boolean updated = false;
			java.sql.PreparedStatement query;
			try
			{
				String sql = "UPDATE EducatorStatus SET Name=? WHERE EducatorStatusID=?";
				query = dbconnection.prepareStatement(sql);
				query.setString(1, Name);
				query.setInt(2, EducatorStatusID);
				query.execute();
				updated = true;
			}
			catch (SQLException e) {e.printStackTrace();}
			return updated;
		}
	}
	
	/*
	 * Table Statuses
	 */
	public class statuses{
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
		public boolean UpdateStatus(int StatusID ,String Name)
		{
			boolean updated = false;
			java.sql.PreparedStatement query;
			try
			{
				String sql = "UPDATE Statuses SET Name=? WHERE StatusID=?";
				query = dbconnection.prepareStatement(sql);
				query.setString(1, Name);
				query.setInt(2, StatusID);
				query.execute();
				updated = true;
			}
			catch (SQLException e) {e.printStackTrace();}
			return updated;
		}
	}
	
	/*
	 * Table Departments
	 */
	public class departments{
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
		public boolean UpadateDepartment(int DepartmentID,String Name)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Departments SET name = ? WHERE DepartmentsID = ?";
		      query = dbconnection.prepareStatement(sql);
		      query.setString(1, Name);
		      query.setInt ( 2, DepartmentID);
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
	
	/*
	 * Table WayOfStudy
	 */
	public class wayofstuding{
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
		{
		   java.sql.PreparedStatement query;
		   try
		   { String sql ="DELETE FROM WayOfStudy WHERE WayOfStudyID = ?";
			 query = dbconnection.prepareStatement(sql);
			 query.setInt(1, id);
			 query.execute();
			 return true;
		   }
		   catch(SQLException e)
		   {
			   e.printStackTrace();
		   }
		   return false;
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
	
	/*
	 * Table Cities
	 */
	public class cities{
		public boolean InsertIntoCites(int StateID, String name,String PostNumber)
		{
			  java.sql.PreparedStatement query;
			  
			  try{
				  String sql = "INSERT INTO Cities VALUES(?,?,?,?)";
				  query = dbconnection.prepareStatement(sql);
				  query.setInt(1, 0);
				  query.setInt(2,StateID);
				  query.setString(3, name);
				  query.setString(4, PostNumber);
				  query.execute();
				  return true;
			  }
			  catch (SQLException e)
			  {e.printStackTrace();}
			  return false;
		}
		public boolean DeleteFromCities(int id)
		{
			java.sql.PreparedStatement query;
			try
			   { String sql ="DELETE FROM StudentIS.Cities WHERE CityID = ?";
				 query = dbconnection.prepareStatement(sql);
				 query.setInt(1, id);
				 query.execute();
				 System.out.println("delted");
				 return true;
			   }
			   catch(SQLException e)
			   {
				   e.printStackTrace();
			   }
			return false;
		}
		public boolean UpadateCityState(int CityID,int StateID)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Cities SET StateID = ? WHERE CityID = ?";
		      query = dbconnection.prepareStatement(sql);
		      query.setInt(1, StateID);
			  query.setInt(2, CityID);
		      query.execute();
		      updated = true;
		  
		    }
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		    return updated;
		}
		public boolean UpadateCityName(int CityID,String Name)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Cities SET Name = ? WHERE CityID = ?";
		      query = dbconnection.prepareStatement(sql);
		      query.setString(1, Name);
			  query.setInt(2, CityID);
		      query.execute();
		      updated = true;
		  
		    }
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		    return updated;
		}
		public boolean UpadateCityPostNumber(int CityID,String PostNumber)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Cities SET PostNumber = ? WHERE CityID = ?";
		      query = dbconnection.prepareStatement(sql);
		      query.setString(1, PostNumber);
			  query.setInt(2, CityID);
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
	
	public class educators{
		public boolean InsertIntoEducators(String Surname,String name,String adress,int cityID,String phone, String email,int rankID,int titleID,int educatorstatusesID)
		{
			  java.sql.PreparedStatement query;
			  
			  try{
				  String sql = "INSERT INTO Educators VALUES(?,?,?,?,?,?,?,?,?,?)";
				  query = dbconnection.prepareStatement(sql);
				  query.setInt(1, 0);
				  query.setString(2, Surname);
				  query.setString(3, name);
				  query.setString(4, adress);
				  query.setInt(5, cityID);
				  query.setString(6, phone);
				  query.setString(7, email);
				  query.setInt(8, rankID);
				  query.setInt(9, titleID);
				  query.setInt(10, educatorstatusesID);
				  query.execute();
				  return true;
			  }
			  catch (SQLException e)
			  {e.printStackTrace();}
			  return false;
		}
		
		public boolean DeleteFromEducators(int id)
		{
			java.sql.PreparedStatement query;
			try
			   { String sql ="DELETE FROM StudentIS.Educators WHERE EducatorID = ?";
				 query = dbconnection.prepareStatement(sql);
				 query.setInt(1, id);
				 query.execute();
				 System.out.println("delted");
				 return true;
			   }
			   catch(SQLException e)
			   {
				   e.printStackTrace();
			   }
			return false;
		}
		
		public boolean UpadateEducatorCity(int EducatorID,int CityID)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Educators SET cityID = ? WHERE EducatorID = ?";
		      query = dbconnection.prepareStatement(sql);
			  query.setInt(1, CityID);
			  query.setInt(2, EducatorID);
		      query.execute();
		      updated = true;
		  
		    }
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		    return updated;
		}
		
		public boolean UpadateEducatorRank(int EducatorID,int RankID)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Educators SET RankID = ? WHERE EducatorID = ?";
		      query = dbconnection.prepareStatement(sql);
		      query.setInt(1, RankID);
			  query.setInt(2, EducatorID);
		      query.execute();
		      updated = true;
		  
		    }
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		    return updated;
		}
		
		public boolean UpadateEducatorTitle(int EducatorID,int TitleID)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Educators SET TitleID = ? WHERE EducatorID = ?";
		      query = dbconnection.prepareStatement(sql);
		      query.setInt(1, TitleID);
			  query.setInt(2, EducatorID);
		      query.execute();
		      updated = true;
		  
		    }
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		    return updated;
		}
		
		public boolean UpadateEducatorStatus(int EducatorID,int EducatorStatusID)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Educators SET EducatorstatusID = ? WHERE EducatorID = ?";
		      query = dbconnection.prepareStatement(sql);
		      query.setInt(1, EducatorStatusID);
			  query.setInt(2, EducatorID);
		      query.execute();
		      updated = true;
		  
		    }
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		    return updated;
		}
		
		public boolean UpadateEducatorSurname(int EducatorID,String Surname)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Educators SET Surname = ? WHERE EducatorID = ?";
		      query = dbconnection.prepareStatement(sql);
		      query.setString(1, Surname);
			  query.setInt(2, EducatorID);
		      query.execute();
		      updated = true;
		  
		    }
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		    return updated;
		}
		
		public boolean UpadateEducatorName(int EducatorID,String Name)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Educators SET Name = ? WHERE EducatorID = ?";
		      query = dbconnection.prepareStatement(sql);
		      query.setString(1, Name);
			  query.setInt(2, EducatorID);
		      query.execute();
		      updated = true;
		  
		    }
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		    return updated;
		}
		
		public boolean UpadateEducatorAdress(int EducatorID,String Adress)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Educators SET Adress = ? WHERE EducatorID = ?";
		      query = dbconnection.prepareStatement(sql);
		      query.setString(1, Adress);
			  query.setInt(2, EducatorID);
		      query.execute();
		      updated = true;
		  
		    }
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		    return updated;
		}
		
		public boolean UpadateEducatorPhone(int EducatorID,String Phone)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Educators SET Phone = ? WHERE EducatorID = ?";
		      query = dbconnection.prepareStatement(sql);
		      query.setString(1, Phone);
			  query.setInt(2, EducatorID);
		      query.execute();
		      updated = true;
		  
		    }
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		    return updated;
		}
		
		public boolean UpadateEducatorEmail(int EducatorID,String Email)
		{   boolean updated = false ;
		    java.sql.PreparedStatement query;
		    
		    try
		    { String sql ="UPDATE Educators SET Email = ? WHERE EducatorID = ?";
		      query = dbconnection.prepareStatement(sql);
		      query.setString(1, Email);
			  query.setInt(2, EducatorID);
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
}