package com.seleniummaster.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Ahmet Bughra
 * @create 2019-12-28-7:25 PM
 * @email bughra1991@gmail.com
 */
public class TestResultObject {
    // this is how we map json element
    @JsonProperty("test-module") //anitaion
    private String userModule;
    @JsonProperty("test-name")
    private String testName;
    @JsonProperty("test-data")
    private String testData;
    @JsonProperty("test-time")
    private String testTime;
    @JsonProperty("test-status")
    private Boolean testStatus; // use Boolean(class) instead of boolean(primitive data type)
    // Boolean can store Null value
    // boolean store true and false


    // default constructor

    public TestResultObject() {
    }

    // constructor with all elements

    public TestResultObject(String userModule, String testName, String testData, String testTime, Boolean testStatus) {
        this.userModule = userModule;
        this.testName = testName;
        this.testData = testData;
        this.testTime = testTime;
        this.testStatus = testStatus;
    }

    // generate getter and setter

    public String getUserModule() {
        return userModule;
    }

    public void setUserModule(String userModule) {
        this.userModule = userModule;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestData() {
        return testData;
    }

    public void setTestData(String testData) {
        this.testData = testData;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public Boolean getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(Boolean testStatus) {
        this.testStatus = testStatus;
    }
}
