package com.seleniummaster.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Ahmet Bughra
 * @create 2019-12-28-7:40 PM
 * @email bughra1991@gmail.com
 */
public class JSONWriteDemo {
    public static void main(String[] args) {
        UserObject user1 = new UserObject();
        user1.setUsername("tsetautomarion1");
        user1.setPassword("automation123!");
        user1.setRole("testing");
        user1.setUserType("automationtesting");

        ObjectMapper objectMapper = new ObjectMapper();
        String userInfo = null;
        try {
            userInfo = objectMapper.writeValueAsString(user1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(userInfo);
        try {
            FileUtils.writeStringToFile(new File("logs\\user.json"),userInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
