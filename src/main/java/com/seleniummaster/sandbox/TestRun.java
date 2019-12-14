package com.seleniummaster.sandbox;

public class TestRun {
    public static void main(String[] args) {
        com.seleniummaster.sandbox.CWFunctionLibrary cwFunctionLibrary = new com.seleniummaster.sandbox.CWFunctionLibrary();
        cwFunctionLibrary.openBrowser("http://sandbox.clinicwise.net/");
        com.seleniummaster.sandbox.CWLogin login = new com.seleniummaster.sandbox.CWLogin("admin", "test");
        cwFunctionLibrary.Login(login);
        com.seleniummaster.sandbox.CWAddNewClient newClient = new com.seleniummaster.sandbox.CWAddNewClient("Sam", "Smith",false,"10/11/1984", 12345,123423,
                0432121201,"sm@aol.com","100 E Pratt St","Baltimore",21010,"Analyst",
                "Love Java Coding");
        cwFunctionLibrary.NewClient(newClient);





    }
}
