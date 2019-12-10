package com.seleniummaster.weeklyproject.week15project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaharaTestRunner {
    public static void main(String[] args) {
        WebDriver browser;
        MaharaFunctionLibrary week15TestCase = new MaharaFunctionLibrary();
        week15TestCase.OpenBrowser("http://mahara.unitedcoderschool.com/mahara/");
        boolean isLoggedIn = week15TestCase.Login("ahmed", "Demo123456789!");
        boolean isTestCase1Passed = week15TestCase.createANewPlan("New_plan_ahmed", "This plan is created by ahmed.", "student_plan");
        boolean isTestCase2Passed = week15TestCase.addTaskToAPlan("New_task_ahmed", "This task is created by ahmed.", "Student_task");
        boolean isTestCase3Passed = week15TestCase.editingTask("This task is edited by ahmed.");
        boolean isTestCase4Passed = week15TestCase.viewAllPlans();
        boolean isTLoggedOut = week15TestCase.logout();

        if (isLoggedIn && isTestCase1Passed && isTestCase2Passed && isTestCase3Passed && isTestCase4Passed && isTLoggedOut) {
            System.out.println("\u001B[34m===============================");
            System.out.println("Mahara Automation Test passed.\t✓ ");
            System.out.println("===============================\u001B[0m");
        } else {
            System.out.println("\u001B[31m===============================");
            System.out.println("Mahara Automation Test failed.\t✖");
            System.out.println("===============================\u001B[0m");
        }
        week15TestCase.exitChromeDriver();
    }
}
