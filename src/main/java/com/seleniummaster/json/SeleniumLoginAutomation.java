package com.seleniummaster.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seleniummaster.cubecart.FunctionLibrary;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
        String testStartTime = new Date().toString();// test start time
        String currentUser = System.getProperty("user.name"); // get user name of the pc
        List<TestResultObject> testResultObjects= new ArrayList<>();// define test result object
        int testCounter=0;
        for(UserObject userObject:users)
        {
            testCounter++;
            System.out.println("Test Execution "+testCounter);
            boolean loginResult = functionLibrary.Login(userObject.getUsername(), userObject.getPassword());
            testResultObjects.add(
                    new TestResultObject(
                            "login-logout",
                            "login",
                            userObject.getUsername(),
                            new Date().toString(),
                            loginResult
                    ));
            functionLibrary.sleep(5);
            boolean logoutResult=functionLibrary.Logout();
            testResultObjects.add(
                    new TestResultObject(
                            "login-logout",
                            "logout",
                            "",
                            new Date().toString(),
                            logoutResult
                    ));
            functionLibrary.sleep(5);
            System.out.println("---------------------------");
        }
        functionLibrary.closeBrowser();
        String testEndTime = new Date().toString();
        // defien test result
        TestResult testResult = new TestResult();
        testResult.setTestStartTime(testStartTime);
        testResult.setTestEndTime(testEndTime);
        testResult.setTestExcutedBy(currentUser);
        testResult.setTestResultObjectList(testResultObjects);
        //write test result into json file
        ObjectMapper testResultMapper = new ObjectMapper();
        String testResultString = null;
        try {
            testResultString = testResultMapper.writeValueAsString(testResult);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            FileUtils.writeStringToFile(new File("logs\\cubecart-result.json"),testResultString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
