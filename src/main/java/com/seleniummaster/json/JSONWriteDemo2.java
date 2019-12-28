package com.seleniummaster.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ahmet Bughra
 * @create 2019-12-28-8:04 PM
 * @email bughra1991@gmail.com
 */
public class JSONWriteDemo2 {
    public static void main(String[] args) {
        UserObject user1 = new UserObject(
                "testautomation1",
                "automation123!",
                "testing",
                "automationtesting");

        UserObject user2 = new UserObject(
                "testautomation2",
                "automation123!",
                "testing",
                "automationtesting");

        UserObject user3 = new UserObject(
                "testautomation3",
                "automation123!",
                "testing",
                "automationtesting");

        List<UserObject> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        LoginUser loginUser = new LoginUser(users);

        ObjectMapper objectMapper = new ObjectMapper();
        String userInfo = null;
        try {
            userInfo = objectMapper.writeValueAsString(loginUser);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(userInfo);
        try {
            FileUtils.writeStringToFile(
                    new File("logs\\users.json"),userInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
