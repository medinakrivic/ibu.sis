package com.ibu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Administration {

    public void AddUser(User newuser)
    {
        CreateDatabaseConnection();

        String username,password,role;

        username = newuser.GetUsername();
        password = newuser.GetPassword();
        role = newuser.GetRole();

        String eusername = null;
        String epassword = null;

           try{
               eusername = Encryption.encrypt(username);
               epassword = Encryption.encrypt(password);
           }
           catch (Exception e)
           {
               System.err.println(e.getMessage());
           }

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ibu.university.sqlite");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Users " +
                    "VALUES (?,'"+eusername+"','"+epassword+"','"+role+"')");

            System.out.println("Insertion completed"); //TODO : Just for testing purposes
        } catch (Exception e)
        {
            System.out.println("error");
        }
    }

    public void CreateDatabaseConnection()
    {

        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ibu.university.sqlite");
            Statement stmt = null;

            stmt = conn.createStatement();

            String sql = " CREATE TABLE main.Users" +
                    "(userid INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL," +
                    " username TEXT NOT NULL," +
                    " password TEXT NOT NULL," +
                    " userrole TEXT NOT NULL)";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
            System.out.println("Database connected");

        } catch ( Exception e ) {
            //Raise exception if table is already created
        }

    }
}
