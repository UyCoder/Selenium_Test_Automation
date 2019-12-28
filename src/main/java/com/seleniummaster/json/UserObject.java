package com.seleniummaster.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Ahmet Bughra
 * @create 2019-12-28-7:25 PM
 * @email bughra1991@gmail.com
 */
public class UserObject {
    @JsonProperty("username") //anitaion
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("role")
    private String role;
    @JsonProperty("userType")
    private String userType;


    public UserObject() {
    }

    public UserObject(
            String username,
            String password,
            String role,
            String userType) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
}
