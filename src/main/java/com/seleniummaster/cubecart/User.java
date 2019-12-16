package com.seleniummaster.cubecart;

import java.io.PrintWriter;

public class User {
    // prapare tset data
    private String username;
    private String password;
    // generate default constructor
    public User() {
    }
    // generate constructor with username, password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    // generate getter method
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
