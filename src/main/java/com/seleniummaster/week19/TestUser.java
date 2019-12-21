package com.seleniummaster.week19;

public class TestUser {
    private String userName; //instance variable
    private String userPassword;
    public TestUser()
    {
    }
    public TestUser(String userName,String userPassword)
    {
        this.userName=userName;
        this.userPassword=userPassword;
    }
    public String getUserName()
    {
        return userName;
    }
    public String getUserPassword()
    {
        return userPassword;
    }
}
