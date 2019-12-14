package com.seleniummaster.sandbox;

public class CWLogin {
    private String userName;
    private String passWord;

    public CWLogin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
