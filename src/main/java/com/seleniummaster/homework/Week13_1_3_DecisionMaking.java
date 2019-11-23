package com.seleniummaster.homework;

import java.util.Scanner;

/**
 * 1- Using Java nested conditional statement, implement a java code for the Federal Tax Rate Schedule in 2008.
 * Below is the requirement.
 * 1. Enter the annual salary from the console;
 * 2. If your tax filing status is single, pay 10% tax for the annual salary between $0 - $32,000;
 * pay 25% tax for the annual salary over $32,000;
 * 3. If your tax filing status is married, pay 10% tax for the annual salary between $0 - $64,000;
 * pay 25% tax for the annual salary over $64,000;
 * 4. You need to print out annual salary, tax filing status, tax percentage, and total tax on the console.
 * 2- Package the above code as a Jar file and run the jar file in command prompt using Java.
 * 3- Use windows task scheduler to schedule a task to execute the above Jar file.
 * Note: after completing the code for the above requirements,
 * please export your code as "HTML" and upload to the assignment as an attachment.
 */
public class Week13_1_3_DecisionMaking {

    public static void main(String[] args) {
        //enter the annual salary
        System.out.println("Please enter the annual salary: ");
        Scanner scanner = new Scanner(System.in);
        int annualSalary = scanner.nextInt();
        //input status if single or married
        System.out.println("Select your status:");
        System.out.println("1. Single");
        System.out.println("2. Married");
        System.out.println("Just type 1 or 2.");
        int status = scanner.nextInt();

        // if single ...
        if (status == 1) {
            System.out.println("===========================");
            System.out.println("You are single.");
            //if annual salary between 0 an 32'000$
            if (annualSalary > 0 && annualSalary < 32000) {
                System.out.println("Your annual salary :" + annualSalary + "$");
                System.out.println("Your Tax percentage 10%.");
                System.out.println("You will pay " + (double) annualSalary * 0.1 + "$ for tax.");
                System.out.println("===========================");
            }
            //if annual salary over 32'000$
            else if (annualSalary >= 32000) {
                System.out.println("Your annual salary :" + annualSalary + "$");
                System.out.println("Your Tax percentage 25%.");
                System.out.println("Your will pay " + (double) annualSalary * 0.25 + "$ for tax.");
                System.out.println("===========================");
            } else
                System.out.println("Your entered wrong number.");
        }

        //if married...
        else if (status == 2) {
            System.out.println("===========================");
            System.out.println("Your are married.");
            //if annual salary between 0 an 64'000$
            if (annualSalary > 0 && annualSalary < 64000) {
                System.out.println("Your annual salary :" + annualSalary + "$");
                System.out.println("Your Tax percentage 10%.");
                System.out.println("You will pay " + (double) annualSalary * 0.1 + "$ for tax.");
                System.out.println("===========================");
            }
            //if annual salary over 64'000$
            else if (annualSalary >= 64000) {
                System.out.println("Your annual salary :" + annualSalary + "$");
                System.out.println("Your Tax percentage 25%.");
                System.out.println("Your will pay " + (double) annualSalary * 0.25 + "$ for tax.");
                System.out.println("===========================");
            } else
                System.out.println("Your entered wrong number.");
        }
        //if input a wrong number
        else {
            System.out.println("Your input a wrong number.");
        }
    }
}
