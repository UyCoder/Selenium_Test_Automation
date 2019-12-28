package com.seleniummaster.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seleniummaster.cubecart.FunctionLibrary;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SeleniumLoginAutomation {
    public static void main(String[] args) {
        FunctionLibrary functionLibrary=new FunctionLibrary();
        functionLibrary.openBrowser("http://cubecart.unitedcoderschool.com/ecommerce/admin_w4vqap.php");
        //prepare login test data
        ObjectMapper objectMapper=new ObjectMapper();
        //mapping json file content to object
        LoginUser loginUser=new LoginUser();
        try {
            loginUser=  objectMapper.readValue(new File("testdata\\users.json"),
                    LoginUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<UserObject> users=loginUser.getUsers();
        int testCounter=0;
        for(UserObject userObject:users)
        {
            testCounter++;
            System.out.println("Test Execution "+testCounter);
            functionLibrary.Login(userObject.getUsername(),userObject.getPassword());
            functionLibrary.sleep(5);
            functionLibrary.Logout();
            functionLibrary.sleep(5);
            System.out.println("---------------------------");
        }
        functionLibrary.closeBrowser();
    }
}
