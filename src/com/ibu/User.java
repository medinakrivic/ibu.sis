package com.ibu;

public class User {
    private String _username;
    private String _password;
    private String _role;

    public User(String role, String username, String password)
    {
        _username = username;
        _password = password;
        _role = role;
    }

    public String GetUsername() { return this._username;}
    public String GetPassword() {return this._password;}
    public String GetRole() {return this._role; }
}
