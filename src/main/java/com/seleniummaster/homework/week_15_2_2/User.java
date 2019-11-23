package com.seleniummaster.homework.week_15_2_2;

public class User {

    // We don't need to create main method on constructor..
    // Define elements
    private String userName;
    private String password;
    private String role;
    private boolean active;

    // Generate constructor with all elements
    public User(String userName, String password, String role, boolean active) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    // Generate only getter method. Because we'll set the value on UserPint.java file.
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean isAvtive() {
        return active;
    }


    // generate toString
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", active=" + active +
                '}';
    }
}
