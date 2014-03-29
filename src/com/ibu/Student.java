package com.ibu;

import java.sql.*;
import java.util.Date;

import com.ibu.DatabaseHelper.Country;

public class Student {
    //private int _studentid; //TODO : Implement getid() method
    private String _name;
    private String _surname;
    private java.util.Date _dateofbirth; 
    private String _birthtown;
    private String _birthcity;
    private Country _birthcountry;
    private String _currenttown;
    private String _currentcity;
    private Country _currentcounry;
    private String _currentadress;
    private String _mobile;
    private boolean _isInserted = false;

    public void SetName(String name){ this._name = name; }
    public void SetSurname(String surname) {this._surname = surname; }
    public void SetBirthTown(String birthtown) { this._birthtown = birthtown;}
    public void SetBirthCity(String birthcity) {this._birthcity = birthcity; }
    public void SetBirthCountry(Country birthcountry) {this._birthcountry = birthcountry; }
    public void SetCurrentAdress(String currentadress) {this._currentadress = currentadress;}
    public void SetCurrentTown(String currenttown) {this._currenttown = currenttown; }
    public void SetCurrentCity(String currentcity) { this._currentcity = currentcity;}
    public void SetCurrentCountry(Country currentcountry) {this._currentcounry = currentcountry;}
    public void SetMobile(String mobile) {this._mobile = mobile;}

    public void SetDateOfBirth(String dateofbirth) {
        @SuppressWarnings("deprecation")
		java.util.Date birth = new Date(dateofbirth); //TODO: java.util.Date is now deprecated. Change to DateFormat.Parse(String s)
        this._dateofbirth = birth;
    }


    public Student (){
        CreateDatabaseConnection();
    }

    public Student(String name, String surname,java.util.Date dateofbirth ,String birthtown, String birthcity, Country birthcountry, String currentown, String currentcity, Country currentcountry, String currentadress, String mobile)
    {
        CreateDatabaseConnection();

        _name = name;
        _surname = surname;
        _dateofbirth = dateofbirth;
        _birthtown = birthtown;
        _birthcity = birthcity;
        _birthcountry = birthcountry;
        _currenttown = currentown;
        _currentcity = currentcity;
        _currentcounry = currentcountry;
        _mobile = mobile;
    }

    public void CreateDatabaseConnection()
    {

        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DatabaseHelper.GetConnection();
            Statement stmt = null;

            stmt = conn.createStatement();
            String sql = " CREATE TABLE main.Students" +
                    "(studentid INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL," +
                    " Name TEXT NOT NULL," +
                    " Surname TEXT NOT NULL," +
                    " DateOfBirth DATETIME NOT NULL," +
                    " BirthTown TEXT ," +
                    " BirthCity TEXT NOT NULL," +
                    " BirthCountry TEXT NOT NULL," +
                    " CurrentTown TEXT," +
                    " CurrentCity TEXT NOT NULL," +
                    " CurrentCountry TEXT NOT NULL," +
                    " CurrentAdress TEXT NOT NULL," +
                    " Mobile TEXT NOT NULL)";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
            System.out.println("Database connected");

        } catch ( Exception e ) {
            //Raise exception if table is already created
        }

    }

    public void InsertIntoDatabase(){

        java.sql.Date sqlitedate = new java.sql.Date(_dateofbirth.getTime());

        if(!_isInserted){
            Connection conn = null;
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:ibu.university.sqlite");
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO Students " +
                        "VALUES (?,'"+_name+"','"+_surname+"','"+sqlitedate+"','"+_birthtown+"','"+_birthcity+"','"+_birthcountry+"','"+_currenttown+"','"+_currentcity+"','"+_currentcounry+"','"+_currentadress+"','"+_mobile+"')");

                System.out.println("Insertion completed"); //TODO : Just for testing purposes
                _isInserted = true;
            } catch (Exception e)
            {
                System.err.println(e.getLocalizedMessage());
            }
        }
    }

   /* public int GetID()
    {

    }
    public String GetName(int _id)
    {

    }*/

}
