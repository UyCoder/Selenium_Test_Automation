package com.seleniummaster.cubecart;

public class TestRunner {
    public static void main(String[] args) {
        FunctionLibrary functionLibrary = new FunctionLibrary();
        functionLibrary.openBrowser("http://cubecart.unitedcoderschool.com/ecommerce/admin_w4vqap.php");
        functionLibrary.Login("testautomation", "automation123!");
        String categoryToAdd = "Java" + System.currentTimeMillis();
        functionLibrary.addNewInventoryCategory(
                categoryToAdd, "/Test Automation");
        functionLibrary.verifyCategoryName(categoryToAdd);
        functionLibrary.Logout();

    }
}
