package com.seleniummaster.json;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true) // system will not generate error
/**
 * @author Ahmet Bughra
 * @create 2020-01-06-9:46 AM
 * @email bughra1991@gmail.com
 */
public class TestResult {
    @JsonProperty("tests")
    private List<TestResultObject> testResultObjectList;
    @JsonProperty("test-start-time")
    private String testStartTime;
    @JsonProperty("test-end-time")
    private String testEndTime;
    @JsonProperty("test-executed-by")
    private String testExcutedBy;

    //default constructor
    public TestResult() {
    }
    // generate costructor with all element
    public TestResult(List<TestResultObject> testResultObjectList, String testStartTime, String testEndTime, String testExcutedBy) {
        this.testResultObjectList = testResultObjectList;
        this.testStartTime = testStartTime;
        this.testEndTime = testEndTime;
        this.testExcutedBy = testExcutedBy;
    }


    // generate getter and setter
    public List<TestResultObject> getTestResultObjectList() {
        return testResultObjectList;
    }

    public void setTestResultObjectList(List<TestResultObject> testResultObjectList) {
        this.testResultObjectList = testResultObjectList;
    }

    public String getTestStartTime() {
        return testStartTime;
    }

    public void setTestStartTime(String testStartTime) {
        this.testStartTime = testStartTime;
    }

    public String getTestEndTime() {
        return testEndTime;
    }

    public void setTestEndTime(String testEndTime) {
        this.testEndTime = testEndTime;
    }

    public String getTestExcutedBy() {
        return testExcutedBy;
    }

    public void setTestExcutedBy(String testExcutedBy) {
        this.testExcutedBy = testExcutedBy;
    }
}
