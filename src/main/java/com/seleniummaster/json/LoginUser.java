package com.seleniummaster.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

/**
 * @author Ahmet Bughra
 * @create 2019-12-28-7:58 PM
 * @email bughra1991@gmail.com
 */
public class LoginUser {
    @JsonProperty("Users")
    private List<UserObject> users;

    public LoginUser() {
    }

    public LoginUser(List<UserObject> users) {
        this.users = users;
    }

    public List<UserObject> getUsers() {
        return users;
    }

    public void setUsers(List<UserObject> users) {
        this.users = users;
    }
}
