package com.seleniummaster.week19;

public class HtmlReportBuilder {
    StringBuilder report=new StringBuilder();
    public void setHtmlHeader()
    {
        report.append("<html><head><title>Automation Report</title></head>");
        report.append("<body>");
    }
    public void setTableHeader()
    {
        report.append("<table border=1>");
        report.append("<tr>");
        report.append("<td>Test Name </td>");
        report.append("<td>Test Module </td>");
        report.append("<td>Test Data </td>");
        report.append("<td>Test Result </td>");
        report.append("<td>Executed at </td>");
        report.append("<td>Executed by </td>");
        report.append("</tr>");
    }
    public void addTestReport(String testName,String testModule,String testData,boolean testResult,
                              String executedAt,String executedBy)
    {
        String colorCode=testResult?"aqua":"red";
        report.append("<tr bgcolor="+colorCode+">");
        report.append("<td>").append(testName).append("</td>");
        report.append("<td>").append(testModule).append("</td>");
        report.append("<td>").append(testData).append("</td>");
        report.append("<td>").append(testResult).append("</td>");
        report.append("<td>").append(executedAt).append("</td>");
        report.append("<td>").append(executedBy).append("</td>");
        report.append("</tr>");
    }
    public void endTestReport()
    {
        report.append("</table></body></html");
    }
    public StringBuilder getFinalReport()
    {
        return report;
    }
}
