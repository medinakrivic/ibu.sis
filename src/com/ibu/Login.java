package com.ibu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Login {
    private String _USERNAME;
    private String _PASSWORD;
    private boolean _isLoggedIn = false;

    public Login(String username,String password)
    {
        CreateDatabaseConnection();
        _USERNAME = username;
        _PASSWORD = password;
        LoginToSystem();
    }

    public boolean isLogedIn()
    {
        return _isLoggedIn;
    }

    private void LoginToSystem()
    {
        if (_USERNAME.equals("said")){
            if (_PASSWORD.equals("123"))
        {
            System.out.println("Succesfull login");
            _isLoggedIn = true;
        }
        else
        {
            System.out.println("Wrong username or password");
        }
        }
    }

    public void CreateDatabaseConnection()
    {

        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DatabaseHelper.GetConnection();
            Statement stmt = null;

            stmt = conn.createStatement();
            String sql = " CREATE TABLE main.Users" +
                    "(userid INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL," +
                    " username TEXT NOT NULL," +
                    " password TEXT NOT NULL)";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
            System.out.println("Database connected");

        } catch ( Exception e ) {
            //Raise exception if table is already created
        }

    }
}