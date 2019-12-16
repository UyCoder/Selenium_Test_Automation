package com.seleniummaster.cubecart;

import com.seleniummaster.configutility.ApplicationConfig;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.function.Function;

public class AddNewProductTest {
    final static String username = ApplicationConfig.readConfigProperties
            ("config.properties", "cubecartUser");
    final static String password = ApplicationConfig.readConfigProperties
            ("config.properties", "cubecartPassword");
    final static String siteUrl = ApplicationConfig.readConfigProperties
            ("config.properties", "cubecartUrl");

    public static void main(String[] args) {
        StringBuilder report= new StringBuilder();
        report.append("<html><head><title>Tset Result</title></head><body>");
        report.append("<table border=1>");
        report.append("<tr><td>Test Name</td><td>Test Result</td></tr>");
        User loginUser = new User(username, password);
        FunctionLibrary functionLibrary = new FunctionLibrary();
        functionLibrary.openBrowser(siteUrl);
        functionLibrary.Login(loginUser);
        Product testProduct = new Product
                ("Java" + System.currentTimeMillis(),
                        ProductCondition.New,
                        "JAVA101",
                        5);
        boolean testResult = functionLibrary.addNewProduct(testProduct);
        if (testResult) {
            report.append("<tr bgcolor=#5cd65c ><td>Add new product</td> <td>Passed</td><tr>");
        }else {
            report.append("<tr><td>Add new product</td> <td>Failed</td><tr>");
        }
        functionLibrary.Logout();
        functionLibrary.closeBrowser();

        report.append("</table></body></html>");
        try {
            FileUtils.writeStringToFile(new File("logs\\productTest.html"),report.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
