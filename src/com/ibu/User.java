package com.ibu;

public class User {
	enum UserRole{STUDENT,PROFESSOR}
	
    private String _username;
    private String _password;
    private UserRole _userrole;

    public User(UserRole userrole, String username, String password)
    {
        _username = username;
        _password = password;
        _userrole = userrole;
    }

    public String GetUsername() { return this._username;}
    public String GetPassword() {return this._password;}
    public String GetRole() {return this._userrole.toString(); }
}
