package com.seleniummaster.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Ahmet Bughra
 * @create 2019-12-28-9:22 PM
 * @email bughra1991@gmail.com
 */
public class JSONReadDemo {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        // mapping json file content to object
        try {
            LoginUser loginUser=objectMapper.readValue(new File(
                    "logs\\users-new.json"),
                    LoginUser.class);
            List<UserObject> users = loginUser.getUsers();
            for (UserObject userObject : users) {
                System.out.println(String.format(
                        "%s %s %s %s",
                        userObject.getUsername(),
                        userObject.getPassword(),
                        userObject.getRole(),
                        userObject.getUserType()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
