package com.seleniummaster.week19;

public class CsvReportBuilder {
    StringBuilder report=new StringBuilder();
    public void addHeaderColumn()
    {
       report.append("Test Name,Test Module,Test Result,Executed At, Executed By").append("\n");
    }
    public void addTestResult(String testName,String testModule,
                              boolean testResult,String executedAt,String executedBy)
    {
        report.append(testName+","+testModule+","+testResult+","+executedAt+","+executedBy).append("\n");
    }
    public String getReport()
    {
        return report.toString();
    }
}
